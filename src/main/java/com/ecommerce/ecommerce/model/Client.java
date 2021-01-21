package com.ecommerce.ecommerce.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clientsite")

public class Client{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idClient ;
	private String nomClient;
	private String email;
	private String adresse;
	private String telephone;
	@OneToMany(mappedBy="client")
	private Collection<Commande> commandes ;
	public long getIdClient() {
		return idClient;
	}
	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Collection<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(Collection<Commande> commandes) {
		this.commandes = commandes;
	}
	public Client(String nomClient, String email, String adresse, String telephone,
			Collection<Commande> commandes) {
		super();
		this.nomClient = nomClient;
		this.email = email;
		this.adresse = adresse;
		this.telephone = telephone;
		this.commandes = commandes;
	}
	public Client() {
		super();
	}
	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nomClient=" + nomClient + ", email=" + email + ", adresse=" + adresse
				+ ", telephone=" + telephone + ", commandes=" + commandes + "]";
	}
	
	
}
