package com.backend.DAO;



import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.backend.model.Cart;



public class CartDAOImpl implements CartDAO {
	@SuppressWarnings("unused")
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unused")
	@Autowired
	private CartDAO cartDAO;
	
	public CartDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory; 
		
	}

	@Transactional
	public boolean saveCart(Cart cart) {
		// TODO Auto-generated method stub
		Session session =sessionFactory.openSession();
		session.persist(cart);
		org.hibernate.Transaction tx=session.beginTransaction();
		
		tx.commit();
		return true;
	}

	public boolean getCart(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query qry = session.createQuery("from Cart c");
		List l=qry.getResultList();
		
		System.out.println("Total Number Of Records : "+l.size());
		Iterator it = l.iterator();
		 
		while(it.hasNext())
		 {
			 Object o = (Object)it.next();
			 Cart c = (Cart)o;
			 System.out.println("cartid : "+c.getCartid());
			 System.out.println("productid : "+c.getProductid());
			 System.out.println("Productname Name : "+c.getProductname());
			 System.out.println(" Username: "+c.getUsename());
			 System.out.println("----------------------");
		 } 

		return true;	
	}

	@Transactional
	public boolean updateCart(Cart cart) {
		Session session = null;
		// TODO Auto-generated method stub
		 Object o=session.load(Cart.class,new Integer(140));
		 Cart s=(Cart)o;
		 
		 Transaction tx = session.beginTransaction(); 
		 s.setProductname("Electronic Gadgets");  // implicitly update method will be called.
		 tx.commit();
		 
		 System.out.println("Object Updated successfully.....!!");
		return true;
	}

	public boolean deleteCart(Cart cart) {
		return false;
		// TODO Auto-generated method stub
	
	}

}
