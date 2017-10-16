package com.backend.DAO;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.backend.model.Category;

public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unused")
	@Autowired
	private CategoryDAO categoryDAO;
	
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory; 
		
	}
	public boolean saveCategory(Category category) {
		// TODO Auto-generated method stub
		Session session =sessionFactory.openSession();
		session.persist(category);
		org.hibernate.Transaction tx=session.beginTransaction();
		
		tx.commit();
		return true;
	}
	@Transactional
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.openSession();
		 Object o=session.load(Category.class,new Integer(140));
		 Category s=(Category)o;
		 
		 Transaction tx = session.beginTransaction(); 
		 s.setCatName("Electronic Gadgets");  // implicitly update method will be called.
		 tx.commit();
		 
		 System.out.println("Object Updated successfully.....!!");
		return true;
	}

	
	@Transactional
	public boolean createCategory(Category category) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.persist(category);
		Transaction tx=session.beginTransaction();
		tx.commit();
		return true;
	}
	@SuppressWarnings("rawtypes")
	public boolean getCategory(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query qry = session.createQuery("from Category c");
		List l=qry.getResultList();
		
		System.out.println("Total Number Of Records : "+l.size());
		Iterator it = l.iterator();
		 
		while(it.hasNext())
		 {
			 Object o = (Object)it.next();
			 Category c = (Category)o;
			 System.out.println("Category id : "+c.getCatid());
			 System.out.println("Category Name : "+c.getCatName());
			 System.out.println("Category Description : "+c.getCatDescription());;
			 System.out.println("----------------------");
		 } 

		return true;
	}
	@Transactional
	public boolean deleteCategory(int id) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Category WHERE id = "+id).executeUpdate();
		return true;
		
	}


}
