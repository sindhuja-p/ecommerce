package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.dao.CardDAO;
import com.niit.dao.CartDAO;
import com.niit.dao.CheckDAO;
import com.niit.dao.OrderDAO;
import com.niit.dao.UserDAO;
import com.niit.model.Card;
@Controller
public class CheckController {
	
	@Autowired
	CheckDAO checkDAO;
	

	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	OrderDAO orderDAO;
	
	@Autowired
	CardDAO cardDAO;
	
	@RequestMapping("Checkout")
	public String CheckoutPage(@ModelAttribute ("card") Card card, Model model)
	{
		//model.addAttribute("total", checkDAO.getTotal(uid));
		return "Checkout";
		
	}

	
	@RequestMapping(value="/invoice",method=RequestMethod.POST)
	public String InvoicePage(@ModelAttribute ("card") Card card, HttpSession session, Model model){
		
		int charges=99;
		int userId = (Integer) session.getAttribute("userid");
		cartDAO.getCartById(userId);
		card.setUserid(userId);
		cardDAO.saveCard(card);
		orderDAO.OrderDetails();
		
	   	
		model.addAttribute("user", userDAO.getUserById(userId));
    	model.addAttribute("cd", cartDAO.getCartById(userId));
    	model.addAttribute("total",checkDAO.getTotal(userId));
		model.addAttribute("cod", charges);
		cartDAO.removeCartById(userId);
		return "Invoice";
	
	
	}
	
	@RequestMapping(value="/CodInvoice",method=RequestMethod.POST)
	public String CodInvoicePage(@ModelAttribute ("card") Card card,HttpSession session, Model model){
		int charges=99;
		
		int userId = (Integer) session.getAttribute("userid");
		cartDAO.getCartById(userId);
	//	mailService.sendEmail(userId);
	
		orderDAO.OrderDetails();
		   
		
		
		model.addAttribute("user", userDAO.getUserById(userId));
    	model.addAttribute("cd", cartDAO.getCartById(userId));
    //	cart.setGrandTotal(checkDAO.getTotal(userId)+"99");
    	model.addAttribute("total",checkDAO.getTotal(userId));
   
		model.addAttribute("cod", charges);
		//cartDAO.deleteCartbyUserId(userId);
		return "Invoice";
	
	
	}
}
