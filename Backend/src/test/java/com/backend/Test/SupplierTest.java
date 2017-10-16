package com.backend.Test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.backend.DAO.SupplierDAO;
import com.backend.model.Supplier;

import jdk.nashorn.internal.ir.annotations.Ignore;
@SuppressWarnings("unused")
@ComponentScan("com.backend")
public class SupplierTest {
	@Autowired
	private static SupplierDAO supplierDAO;
	
		
	@BeforeClass
	public static void initialize()
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.backend.*");
		context.refresh();
		
			//supplier = (Supplier) context.getBean("supplier");
			supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
	}
	
	@Test
	public void createSupplierTestCase()
	{
		Supplier supplier= new Supplier();
		supplier.setSupplier_name("jabong");
			supplierDAO.createSupplier(supplier);
			boolean flag=supplierDAO.createSupplier(supplier);
			
			assertEquals("createsupplierTestCase",true,flag);

		} 
	@Ignore
	@Test
	public void deleteSupplierTestCase()
	
	{

		Supplier supplier= new Supplier();
		supplier.setSupplier_name("Myntra");

			boolean flag=supplierDAO.deleteSupplier(25);
			
			assertEquals("createsupplierTestCase",true,flag);
	}
}
