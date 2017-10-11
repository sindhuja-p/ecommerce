package com.niit.Backend.DAO;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Backend.model.Product;


@Repository
public class ProductDAOImpl implements ProductDAO 
{
		
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ProductDAO productDAO;
	
	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	
	public ProductDAOImpl(SessionFactory sessionFactory) 
	{	
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public boolean createProduct(Product product) 
	{
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(product);
		Transaction tx=session.beginTransaction();
		tx.commit();
		return true;
	}
	
	
	@Transactional
	public boolean updateProduct(Product product) 
	{
		 Session session = sessionFactory.openSession();
		 Object o=session.load(Product.class,new Integer(140));
		 Product s=(Product)o;
		 
		 Transaction tx = session.beginTransaction(); 
		 s.setPrice(678.9);  // implicitly update method will be called.
		 tx.commit();
		 
		 System.out.println("Object Updated successfully.....!!");
		 return true;
	}
	
	@Transactional
	public boolean deleteProduct(int id) 
	{
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Product WHERE id = "+id).executeUpdate();
		return true;	
	}
	
	@SuppressWarnings( "rawtypes" )
	@Transactional
	public boolean getProduct(int id) 
	{
		
		Session session=sessionFactory.openSession();
		Query qry = session.createQuery("from Product p");
		List l=qry.getResultList();
		
		System.out.println("Total Number Of Records : "+l.size());
		Iterator it = l.iterator();
		 
		while(it.hasNext())
		 {
			 Object o = (Object)it.next();
			 Product p = (Product)o;
			 System.out.println("Product id : "+p.getId());
			 System.out.println("Product Name : "+p.getName());
			 System.out.println("Product Price : "+p.getPrice());
			 System.out.println("----------------------");
		 } 

		return true;
	}

	
}

