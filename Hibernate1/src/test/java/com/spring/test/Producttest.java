package com.spring.test;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.backend.config.Dbconfig;
import com.backend.DAO.ProductDAO;
import com.backend.model.Product;



@SuppressWarnings("unused")
@ComponentScan("com.niit")
public class Producttest 
{	
	//@Autowired
	//private static Product product;
	

	@Autowired
	private static ProductDAO productDAO;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(Dbconfig.class);
		context.scan("com.niit.*");
		
		context.refresh();
		
		//product=(Product) context.getBean("product");
		productDAO=(ProductDAO) context.getBean("productDAO");
	
	}
	@Test
	public void addProduct()
	{
		Product product=new Product();
		productDAO.addProduct(product);
		product.setName( "ram");
		product.setPrice(9087.89);
		product.setQuantity(9);
		product.setP_category("rahim");
		
		boolean flag=productDAO.saveProduct1(product);
		
		assertEquals("createProductTestCase", true, flag);
	}
	
	
	
	
	/*public void getAllProducts()
	{
		//List<Product1> Product1 = productDAO.getAllProducts();
		//assertEquals(16,productDAO);
		
	}*/
	
	
	
	
	/*public void deleteProduct1()
	{
		productDAO.deleteProduct1(45);
		
		//boolean flag=productDAO.deleteProduc1();
		
		//assertEquals("createProductTestCase", true, flag);		
	}*/
}