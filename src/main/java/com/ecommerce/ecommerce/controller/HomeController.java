package com.ecommerce.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.ecommerce.domaine.ProduitVo;
import com.ecommerce.ecommerce.service.ProduitImpl;

@Controller
public class HomeController {

	@Autowired
	private ProduitImpl service;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView Home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}

	/*@RequestMapping(value = { "/produits" }, method = RequestMethod.GET)
	public ModelAndView Produits() {
		ModelAndView modelAndView = new ModelAndView();
		List<ProduitVo> list = service.getProduit();

		modelAndView.setViewName("produits");
		m.addAttribute("list", list);
		return modelAndView;
	}*/

	@RequestMapping(value = { "/produits" }, method = RequestMethod.GET)
	public String viewProduits(Model m) {
		List<ProduitVo> list = service.getProduit();
		m.addAttribute("list", list);
		return "produits";
	}
	
	
	/*@RequestMapping("/produits")
	public String viewemp(Model m) {
	List<ProduitVo> list = service.getProduit();
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	m.addAttribute("userName", "Welcome " + auth.getName());
	m.addAttribute("list", list);
	return "produits";
	}*/

}
