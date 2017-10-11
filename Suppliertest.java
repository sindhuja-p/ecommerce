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
import com.niit.Backend.DAO.SupplierDAO;
import com.niit.Backend.model.Supplier;


@SuppressWarnings("unused")
@ComponentScan("com.backend")
public class Suppliertest 
{	
	@Autowired
	private static Supplier supplier;
	
	@Autowired
	private static SupplierDAO supplierDAO;
	
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.register(Dbconfig.class);
		context.refresh();
		supplier=(Supplier) context.getBean("supplier");
		supplierDAO=(SupplierDAO) context.getBean("supplierDAO");
		
		
	}
	@Test
	public void createSupplier()
	{
		Supplier supplier =new Supplier();
		supplier.setSuppliername("flipkart");
		boolean flag=supplierDAO.saveSupplier(supplier);
		assertEquals("createSuppliertestCase", true, flag);
	}
}