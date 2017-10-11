package com.niit.Backend.DAO;

import java.util.List;

import com.niit.Backend.model.Product;



public interface ProductDAO 
{
	public boolean createProduct(Product product);
	
	public boolean getProduct(int id);
	
	//public List<Product> retrieveProduct();
	
	public boolean updateProduct(Product product);
	
	public boolean deleteProduct(int id);
}