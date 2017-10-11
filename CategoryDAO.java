package com.niit.Backend.DAO;

import java.util.List;

import com.niit.Backend.model.Category;



public interface CategoryDAO 
{
	public boolean saveCategory(Category c);
	public  List getAllCategory();
}