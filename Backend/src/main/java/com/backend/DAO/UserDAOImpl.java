package com.backend.DAO;

import java.util.List;

import javax.transaction.Transactional;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory; 
		
	}


@Transactional
public boolean saveUser(com.backend.model.User user) {
	// TODO Auto-generated method stub	return false;
	Session s= sessionFactory.openSession();
	s.saveOrUpdate(user);
	Transaction t= s.beginTransaction();
	t.commit();
	return true;
}




@Transactional
public List getAllUser() {
	return sessionFactory.getCurrentSession().createQuery("from User").list();
}




}


