package com.ecommerce.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommerce.model.Produit;


public interface ProduitRepository  extends JpaRepository<Produit, Long> {

}
