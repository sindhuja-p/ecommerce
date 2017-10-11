package com.niit.Backend;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.niit.Backend.Config.Dbconfig;
import com.niit.Backend.DAO.CartDAO;
import com.niit.Backend.model.Cart;

@SuppressWarnings("unused")
@ComponentScan("com.spring")
public class Carttest 
{	
	/*@Autowired
	private static Product product;
	*/
	@Autowired
	private static CartDAO cartDAO;
	
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.register(Dbconfig.class);
		context.refresh();
		
	//	product=(Product) context.getBean("product");
		cartDAO=(CartDAO) context.getBean("cartDAO");
		
		
	}
	@Ignore
	@Test
	public void addCart()
	{
		Cart cart=new Cart();
		cart.setCartItemId(1);
		cart.setOrderId(142);
		cart.setPrice(2500);
		cart.setProductId(198);
		cart.setQuantity(3);
		cart.setUsername("NP");
		cart.setUsername("reethu");
	
		boolean flag=cartDAO.addCart(cart);
		assertEquals("createCartTestCase", true, flag);
	}
	
	@Test
	public void updateCart()
	{
		Cart cart=new Cart();
		cart.setCartItemId(1);
		cart.setOrderId(135);
		cart.setPrice(2500);
		cart.setProductId(186);
		cart.setQuantity(4);
		cart.setStatus("yes");
		cart.setUsername("priya");
	
		//boolean flag=cartDAO.updateCart(cart);
		assertEquals("problem in cart", cartDAO.updateCart(cart));
	}
	@Ignore
	@Test
	public void deleteCart()
	{
		Cart cart=new Cart();
		cart.setCartItemId(1);
		cart.setOrderId(124);
		cart.setPrice(2500);
		cart.setProductId(124);
		cart.setQuantity(3);
		cart.setStatus("NP");
		cart.setUsername("sneha");
	
		boolean flag=cartDAO.deleteCart(cart);
		assertEquals("createCartTestCase", true, flag);
	}
	
}



