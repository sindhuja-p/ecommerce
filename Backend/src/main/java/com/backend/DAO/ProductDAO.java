package com.backend.DAO;

import com.backend.model.Product;

public interface ProductDAO {

	public boolean saveProduct(Product product);
	
	public boolean getProduct(int id);
	 
	public boolean updateProduct(Product product);
	
	public boolean deleteProduct(int id);
}
