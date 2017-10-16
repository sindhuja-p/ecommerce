package com.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component

public class Product {
	
	@Id
	@GeneratedValue
private int id;
private String Name;
private int Quantity;
private double Price;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public int getQuantity() {
	return Quantity;
}
public void setQuantity(int quantity) {
	Quantity = quantity;
}
public double getPrice() {
	return Price;
}
public void setPrice(double price) {
	Price = price;
}


	
}
