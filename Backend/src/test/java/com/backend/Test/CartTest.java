package com.backend.Test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.backend.DAO.CartDAO;
import com.backend.model.Cart;



public class CartTest {
	@Autowired
	private static CartDAO cartDAO;
	
	@BeforeClass
	public static void Initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.backend.*");
		context.refresh();
		cartDAO = (CartDAO) context.getBean("cartDAO");
	}
	
	@Test
		public void saveCategory()
	{
	   Cart cart= new Cart();
	   cart.setCartid(11);
	   cart.setProductid(123);
	   cart.setProductname("phone");
	   cart.setUsename("swetha");
	   cart.setPrice(15999);
	   cart.setStatus("process");
	   cart.setQuantity(5);
	   
	  boolean flag=cartDAO.updateCart(cart);
	   assertEquals("createCartTest",true,flag);
	}
}
