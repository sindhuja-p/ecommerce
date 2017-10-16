package com.backend.Test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.backend.DAO.CategoryDAO;
import com.backend.model.Category;
import com.backend.model.Product;

@SuppressWarnings("unused")
@ComponentScan("com.backend")
public class CategoryTest {
	@Autowired
	private static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void Initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.backend.*");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
	
	@Test
		public void saveCategory()
	{
	   Category category= new Category();
	   category.setCatName("Andriod");
	   category.setCatDescription("kitkat os");
	   boolean flag=categoryDAO.saveCategory(category);
	   assertEquals("createCategoryTest",true,flag);
	}
	@Ignore	
		@Test
		public void deleteCategory()
	{
	   Category category= new Category();
	   category.setCatName("Mobile accessories");
	   category.setCatDescription("IOSsoftware");
	 
	boolean flag=categoryDAO.deleteCategory(28);
	   assertEquals("createCategoryTest",true,flag);
	}
		@Ignore
		@Test
		public void updateCategory()
	{
	   Category category= new Category();
	   category.setCatName("Mobile accessories");
	   category.setCatDescription("Andriod software");
	   boolean flag=categoryDAO.updateCategory(category);
	   assertEquals("createCategoryTest",true,flag);
	}

	
		@Test
		public void retrieveCategory()
		{
			Category category= new Category();
			boolean listcategory=categoryDAO.getCategory(6);
			assertNotNull("problem in getting by id",category);
		}
}
