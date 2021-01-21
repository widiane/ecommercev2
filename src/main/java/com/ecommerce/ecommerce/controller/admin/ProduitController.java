package com.ecommerce.ecommerce.controller.admin;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.ecommerce.domaine.ProduitVo;
import com.ecommerce.ecommerce.model.Produit;
import com.ecommerce.ecommerce.service.IProduit;
import com.ecommerce.ecommerce.utils.ImageUtil;

@Controller
@RequestMapping("/admin/produit")
public class ProduitController {

	@Autowired
	private IProduit service;
	

	@RequestMapping("/form")
	public String showform(Model m) {
		m.addAttribute("produitVo", new ProduitVo());
		return "/admin/produit/edit";
	}
	
	

	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
		ProduitVo produit = new ProduitVo();
		model.addAttribute("ProduitVo", produit);

		return "admin/produit/new_product";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = {"multipart/form-data"})
	public String save(@ModelAttribute("ProduitVo") ProduitVo produit,  @RequestParam("imagefile") MultipartFile file) throws Exception{
		
		//service.uploadProductPhotos(produit.getImages(), produit.getIdProduit());
		//if(!file.isEmpty()) {
			
			
		//}else if(produit.getIdProduit()!=null) {
		//produit.setPhoto(file.getBytes());
		//produit.setNomPhoto(file.getName());
		// byte[] image = produit.getFileData().getBytes();
		// ByteArrayMultipartFileEditor bytconvert =  new ByteArrayMultipartFileEditor();
		 
	       /*if (file != null ) {
	        	produit.setPhoto(IOUtils.toByteArray(new ByteArrayInputStream(file.getBytes())));
	        	produit.setNomPhoto(file.getName());
	        }*/
		//Byte[] byteObjects = convertToBytes(file);
		produit.setPhoto(convertToBytes(file));
		
			service.save(produit);
			
		//}
		return "redirect:/admin/produit/list";
	}
	 private Byte[] convertToBytes(MultipartFile file) throws IOException {
	        Byte[] byteObjects = new Byte[file.getBytes().length];
	        int i = 0;
	        for (byte b : file.getBytes()) {
	            byteObjects[i++] = b;
	        }
	        return byteObjects;
	    }
	

	

	@RequestMapping("/list")
	public String viewemp(Model m) {
		List<ProduitVo> list = service.getProduit();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		m.addAttribute("userName", "Welcome " + auth.getName());
		m.addAttribute("imgUtil", new ImageUtil() );
		m.addAttribute("list", list);
		return "/admin/produit/list";
	}
	
	

	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable Long id, Model m) {
		ProduitVo produit = service.getProduitById(id);
		m.addAttribute("ProduitVo", produit);
		return "/admin/produit/edit";
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("produitVo") ProduitVo produit) {
		service.save(produit);
		return "redirect:/admin/produit/view";
	}

	
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id) {
		service.delete(id);
		return "redirect:/admin/produit/list";
	}
}
