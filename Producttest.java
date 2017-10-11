package com.niit.Backend;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.niit.Backend.Config.Dbconfig;
import com.niit.Backend.DAO.ProductDAO;
import com.niit.Backend.model.Product;



@SuppressWarnings("unused")
@ComponentScan("com.niit")
public class Producttest 
{
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
	public void createProduct()
	{
		Product product = new Product();
		product.setName("Silk");
		product.setQuantity(9);
		product.setP_category("Cadbury");
		//product.setPrice(678.67);
		boolean flag=productDAO.createProduct(product);
		assertEquals("createProductTestCase", true, flag);
	}
	
	@Ignore
	@Test
	public void updateProduct()
	{
		Product product = new Product();

		product.setName("Silk");
		product.setQuantity(9);
		product.setP_category("Cadbury");
		//product.setPrice(678.67)
		boolean flag=productDAO.updateProduct(product);
		assertEquals("createProductTestCase", true, flag);
	}
	
	
	@Test
	public void deleteProduct()
	{
		Product product = new Product();
		product.setName("Dairy Milk");
		product.setQuantity(2);
		product.setP_category("Cadbury");
		product.setPrice(567.78);
		boolean flag=productDAO.deleteProduct(47);
		assertEquals("createProductTestCase", true, flag);
	}
	
	
	@Test
	public void retrieveProduct()
	{
		Product product=new Product();
		boolean listproduct=productDAO.getProduct(41);
		assertNotNull("problem in getting product by id", product);
	}


}

