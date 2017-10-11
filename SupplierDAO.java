package com.niit.Backend.DAO;

import java.util.List;

import com.niit.Backend.model.Supplier;





public interface SupplierDAO {
	public boolean saveSupplier(Supplier supplier);
	public List getAllSuppliers();
}

