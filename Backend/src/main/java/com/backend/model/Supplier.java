package com.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
	@Entity
	@Table(name="Supplier_details")
	public class Supplier {
	@Id
	@Column(name="supid")
	   @GeneratedValue
	private int id;
	private String  supplier_Name ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return supplier_Name;
	}
	public void setName(String name) {
		supplier_Name = name;
	}
	public void setSupplier_name(String string) {
		// TODO Auto-generated method stub
		
	}
	public String getSupplier_name() {
		// TODO Auto-generated method stub
		return null;
	}

	
}