package com.backend.DAO;

import java.util.List;

import com.backend.model.Supplier;

public interface SupplierDAO {
	 public boolean createSupplier(Supplier supplier);
	  public boolean getSupplier(int id);
	  public boolean updateSupplier(Supplier supplier);
	  public boolean deleteSupplier(int id);
	
}
