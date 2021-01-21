package com.ecommerce.ecommerce.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.ecommerce.domaine.ProduitVo;

public interface IProduit {
	List<ProduitVo> getProduit();
	void save(ProduitVo produit);
	ProduitVo getProduitById(Long id);
	void delete(Long id);
	List<ProduitVo> findBydesignation(String designation);
	List<ProduitVo> findAll(int pageId, int size);
	
	void uploadProductPhotos(MultipartFile[] photos, String uuid) throws IOException;
	  void updateProductIdForPhoto(String uuid, String newProductId);

}
