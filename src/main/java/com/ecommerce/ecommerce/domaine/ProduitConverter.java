package com.ecommerce.ecommerce.domaine;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.ecommerce.model.Produit;

public class ProduitConverter {

	public static ProduitVo toVo(Produit bo) {
		if (bo == null || bo.getIdProduit()==null)
			return null;
			ProduitVo vo = new ProduitVo();
			vo.setIdProduit(bo.getIdProduit());
			vo.setDesignation(bo.getDesignation());
			vo.setDescription(bo.getDescription());
			vo.setPhoto(bo.getPhoto());
			vo.setNomPhoto(bo.getNomPhoto());
			vo.setPrix(bo.getPrix());
			vo.setQuantite(bo.getQuantite());
			vo.setSelectionne(bo.isSelectionne());
			return vo;
	}
	
	public static Produit toBo(ProduitVo vo) {
			Produit bo = new Produit();
			bo.setIdProduit(vo.getIdProduit());
			bo.setDesignation(vo.getDesignation());
			bo.setDescription(vo.getDescription());
			bo.setPhoto(vo.getPhoto());
			bo.setNomPhoto(vo.getNomPhoto());
			bo.setPrix(vo.getPrix());
			bo.setQuantite(vo.getQuantite());
			bo.setSelectionne(vo.isSelectionne());
			return bo;
	}
	
	public static List<ProduitVo> toListVo(List<Produit> listBo) {
		List<ProduitVo> listVo = new ArrayList<>();
		for (Produit produit : listBo) {
		listVo.add(toVo(produit));
		}
		return listVo;
		}
}
