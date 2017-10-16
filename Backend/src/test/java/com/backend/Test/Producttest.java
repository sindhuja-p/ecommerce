package com.backend.Test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import com.backend.DAO.ProductDAO;
import com.backend.config.Dbconfig;
import com.backend.model.Product;


@SuppressWarnings("unused")
@ComponentScan("com.backend")
public class Producttest {

	@Autowired
	private static ProductDAO productDAO;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(Dbconfig.class);
		context.scan("com.backend.*");
		context.refresh();
		
		Product product=(Product) context.getBean("product");
		productDAO=(ProductDAO) context.getBean("productDAO");
		
	}
	@Test
	public void createProduct()
	{
		Product product=new Product();
		product.setName("Iphone 6");
		product.setPrice(65999);;
		product.setQuantity(5);
boolean flag=productDAO.saveProduct(product);
		
		assertEquals("createProductTestCase", true, flag);
	}
}
