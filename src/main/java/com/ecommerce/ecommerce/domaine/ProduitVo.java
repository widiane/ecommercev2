package com.ecommerce.ecommerce.domaine;

import java.util.Set;

import javax.persistence.Lob;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ecommerce.ecommerce.model.ProductImage;

import lombok.Data;

@Data
public class ProduitVo {
	private Long idProduit ;
	@NotEmpty
	private String designation ;
	private String description;
	private String nomPhoto ;
	private double prix ;
	private int quantite ;
	private boolean selectionne ;
	
	@Lob
	private Byte[] photo;
	@Transient
    private CommonsMultipartFile fileData;

	
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

	public Byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(Byte[] photo) {
		this.photo = photo;
	}

	public ProduitVo() {
		super();
	}

	public ProduitVo(Long idProduit, String designation, String description, String nomPhoto, double prix, int quantite,
			boolean selectionne, Byte[] photo) {
		super();
		this.idProduit = idProduit;
		this.designation = designation;
		this.description = description;
		this.nomPhoto = nomPhoto;
		this.prix = prix;
		this.quantite = quantite;
		this.selectionne = selectionne;
		this.photo = photo;
	}

	  public Set<ProductImage> getImages() {
		    return images;
		  }

		  public void setImages(Set<ProductImage> images) {
		    this.images = images;
		  }
		  public CommonsMultipartFile getFileData() {
				return fileData;
			}
		  public void setFileData(CommonsMultipartFile fileData) {
				this.fileData = fileData;
			}
	
}
