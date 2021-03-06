package com.niit.Backend.DAO;

import java.util.List;

import com.niit.Backend.model.Cart;



public interface CartDAO {
	public boolean addCart(Cart cart);
	public boolean updateCart(Cart cart);
	public boolean deleteCart(Cart cart);
	public Cart getCartItem(int CartItemId);
	public List<Cart> getCartItems(String username);


}