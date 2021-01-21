package com.ecommerce.ecommerce.model;

import javax.persistence.*;

@Entity
@Table(name = "ligneCommande")
public class LigneCommande {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idLigneCommande ;
	@ManyToOne
	@JoinColumn(name="idProduit")
	private Produit produit ;
	private int quantite ;
	private double prix ;
	
	public LigneCommande(Produit produit, int quantite, double prix) {
		super();
		this.produit = produit;
		this.quantite = quantite;
		this.prix = prix;
	}
	public LigneCommande() {
		super();
	}
	public long getIdLigneCommande() {
		return idLigneCommande;
	}
	public void setIdLigneCommande(long idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	@Override
	public String toString() {
		return "LigneCommande [idLigneCommande=" + idLigneCommande + ", produit=" + produit + ", quantite=" + quantite
				+ ", prix=" + prix + "]";
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
}
