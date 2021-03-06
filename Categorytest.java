package com.niit.Backend;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.niit.Backend.Config.Dbconfig;
import com.niit.Backend.DAO.CategoryDAO;
import com.niit.Backend.model.Category;


@SuppressWarnings("unused")
@ComponentScan("com.spring")
public class Categorytest 
{	
	/*@Autowired
	private static Product product;
	*/
	@Autowired
	private static CategoryDAO categoryDAO;
	
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.register(Dbconfig.class);
		context.refresh();
		
	//	product=(Product) context.getBean("product");
		categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
		
		
	}
	@Test
	public void createCategory()
	{
		Category category =new Category();
		category.setName("Men's Wear");
		category.setDescription("Shirts");
		boolean flag=categoryDAO.saveCategory(category);
		assertEquals("createCategorytestCase", true, flag);
	}
}


