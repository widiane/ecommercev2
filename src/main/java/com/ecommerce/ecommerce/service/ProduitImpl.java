package com.ecommerce.ecommerce.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.ecommerce.dao.ProductImageRepository;
import com.ecommerce.ecommerce.dao.ProduitRepository;
import com.ecommerce.ecommerce.domaine.ProduitConverter;
import com.ecommerce.ecommerce.domaine.ProduitVo;
import com.ecommerce.ecommerce.model.Produit;


import com.ecommerce.ecommerce.model.ProductImage;


@Service("produitService")
@Transactional
public class ProduitImpl  implements IProduit{

	@Autowired
	ProduitRepository produitRepository; 
	
    @Autowired
    private ProductImageRepository productImageRepo;
	@Override
	public List<ProduitVo> getProduit() {
		 List<Produit> list = produitRepository.findAll()	;	

		return ProduitConverter.toListVo(list);

	}

	@Override
	public void save(ProduitVo produit) {

		 /* byte[] image = produit.getFileData().getBytes();
	        if (image != null && image.length > 0) {
	            produit.setPhoto(image);
	            produit.setNomPhoto("photo name");
	        }
	      
	        
	        //produitRepository.save(produit);
	        
	  
	produitRepository.save(ProduitConverter.toBo(produit));*/
		/*  byte[] image = produit.getFileData().getBytes();
	        if (image != null && image.length > 0) {
	        	produit.setPhoto(image);
	        }
	        if(produit.getIdProduit()==null){
	        	produitRepository.save(ProduitConverter.toBo(produit));
	        }
	        else{
	        	produitRepository.save(ProduitConverter.toBo(produit));
	        }*/
		produitRepository.save(ProduitConverter.toBo(produit));
	    }

	

	@Override
	public ProduitVo getProduitById(Long id) {
		boolean trouve = produitRepository.existsById(id);
		if(!trouve)
			return null;
		return ProduitConverter.toVo(produitRepository.getOne(id));
	}

	@Override
	public void delete(Long id) {

		produitRepository.deleteById(id);
	}

	@Override
	public List<ProduitVo> findBydesignation(String designation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProduitVo> findAll(int pageId, int size) {
		Page<Produit> result = produitRepository.findAll(PageRequest.of(pageId, size,Direction.ASC,"name"));
		return ProduitConverter.toListVo(result.getContent());

	}
	
	  @Override
	    public void uploadProductPhotos(MultipartFile[] photos, String uuid) throws IOException {
	        if (photos != null) {
	            List<ProductImage> images = new ArrayList<>();
	            for (MultipartFile photo : photos) {
	                ProductImage image = new ProductImage();
	                image.setContent(photo.getBytes());
	                image.setName(photo.getOriginalFilename());
	                image.setType(photo.getContentType());
	                image.setProductId(uuid);
	                images.add(image);
	            }
	            // TODO: must be the user's choice!
	            images.stream().findFirst().get().setMain(true);
	            images.stream().forEach(image -> productImageRepo.save(image));
	        }
	    }
	  
	   @Override
	    public void updateProductIdForPhoto(String uuid, String newProductId) {
	        productImageRepo.updateProductId(uuid, newProductId);
	    }


	    private Set<ProductImage> getMainImageForProduct(List<ProductImage> mainImages, Produit product) {
	        Set<ProductImage> images = new HashSet<>();
	        mainImages.stream().forEach(productImage -> {
	            if (product.getIdProduit().equals(productImage.getProductId())) {
	                images.add(productImage);
	            }
	        });
	        return images;
	    }
	
}