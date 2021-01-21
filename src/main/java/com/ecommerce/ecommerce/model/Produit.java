package com.ecommerce.ecommerce.model;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.commons.CommonsMultipartFile;



@Entity
@Table(name = "produit")
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduit ;
	@NotEmpty
	private String designation ;
	private String description;
	private String nomPhoto ;
	private double prix ;
	private int quantite ;
	private boolean selectionne ;
	@Transient
    private CommonsMultipartFile fileData;

	@Lob
	private Byte[] photo;
	
	
	@Transient
	private Set<ProductImage> images;


	public Long getIdProduit() {
		return idProduit;
	}


	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getNomPhoto() {
		return nomPhoto;
	}


	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	public boolean isSelectionne() {
		return selectionne;
	}


	public void setSelectionne(boolean selectionne) {
		this.selectionne = selectionne;
	}


	public CommonsMultipartFile getFileData() {
		return fileData;
	}


	public void setFileData(CommonsMultipartFile fileData) {
		this.fileData = fileData;
	}


	public Byte[] getPhoto() {
		return photo;
	}


	public void setPhoto(Byte[] photo) {
		this.photo = photo;
	}


	public Set<ProductImage> getImages() {
		return images;
	}


	public void setImages(Set<ProductImage> images) {
		this.images = images;
	}


	public Produit(Long idProduit, @NotEmpty String designation, String description, String nomPhoto, double prix,
			int quantite, boolean selectionne, CommonsMultipartFile fileData, Byte[] photo, Set<ProductImage> images) {
		super();
		this.idProduit = idProduit;
		this.designation = designation;
		this.description = description;
		this.nomPhoto = nomPhoto;
		this.prix = prix;
		this.quantite = quantite;
		this.selectionne = selectionne;
		this.fileData = fileData;
		this.photo = photo;
		this.images = images;
	}


	public Produit() {
	
	}



	
}
