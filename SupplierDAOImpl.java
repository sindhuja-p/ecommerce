package com.niit.Backend.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.Backend.model.Supplier;


public class SupplierDAOImpl implements SupplierDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public SupplierDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
@Transactional
	public boolean saveSupplier(Supplier supplier) {
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(supplier);
		Transaction t=session.beginTransaction();
		t.commit();
		return true;
	}

	public List getAllSuppliers() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}

}