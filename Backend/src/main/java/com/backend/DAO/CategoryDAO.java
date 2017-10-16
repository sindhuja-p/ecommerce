package com.backend.DAO;



import com.backend.model.Category;


public interface CategoryDAO {
  
	 public boolean saveCategory(Category category);
	  public boolean getCategory(int id);
	  public boolean updateCategory(Category category);
	  public boolean deleteCategory(int id);
}