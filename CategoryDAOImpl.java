package com.niit.Backend.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Backend.model.Category;
import com.niit.Backend.model.Product;


@Repository
public class CategoryDAOImpl implements CategoryDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean createCategory(Category category) 
	{
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(category);
		Transaction tx=session.beginTransaction();
		tx.commit();
		return true;
	} 

	public boolean saveCategory(Category c) {
		// TODO Auto-generated method stub
		return false;
	}
	public List getAllCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
