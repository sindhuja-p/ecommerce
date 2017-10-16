package com.backend.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Cart implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = -1876474684599266638L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int cartid,productid,quantity,price;
private String usename,productname,status;
public int getCartid() {
	return cartid;
}
public void setCartid(int cartid) {
	this.cartid = cartid;
}
public int getProductid() {
	return productid;
}
public void setProductid(int productid) {
	this.productid = productid;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getUsename() {
	return usename;
}
public void setUsename(String usename) {
	this.usename = usename;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

}
