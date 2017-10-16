package com.backend.DAO;


import java.util.Iterator;
import java.util.List;


import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;


import com.backend.model.Product;


public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private ProductDAO productDAO;
	private SessionFactory sessionFactory;
	
	 public ProductDAOImpl(SessionFactory sessionFactory){
		 this.sessionFactory=sessionFactory;
	 }
	

	public boolean saveProduct(Product product) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		s.saveOrUpdate(product);
		Transaction t=s.beginTransaction();
		t.commit();
		
		return false;
		
	}

	@SuppressWarnings("rawtypes")
	public boolean getProduct(int id) {
		// TODO Auto-generated method stub
		 Session s=sessionFactory.openSession();
		Query q=s.createQuery("from Product product");
		 List l=q.getResultList();
		 System.out.println("Totaal number of records:"+l.size());;
			Iterator it=l.iterator();
			
			while(it.hasNext())
			 {
				 Object o = (Object)it.next();
				 Product product = (Product)o;
				 System.out.println("Product id : "+product.getId());
				 System.out.println("Product Name : "+product.getName());
				 System.out.println("Product Quantity : "+product.getQuantity());
				 System.out.println("Product Price : "+product.getPrice());
				 System.out.println("----------------------");
			 } 
			return true;
	 }
		 
	// @Transactional
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		 Object o=session.load(Product.class,new Integer(10));
		 Product s=(Product)o;
		 
		 Transaction tx = session.beginTransaction(); 
		 s.setPrice(70000);  
		 tx.commit();
		 
		 System.out.println("Object Updated successfully.....!!");
		return true;
	}


	 //@Transactional
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		 sessionFactory.getCurrentSession().createQuery("DELETE FROM Product WHERE id = "+id).executeUpdate();
			return true;
	}

}
