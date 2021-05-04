package com.ass.site.Servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ass.admin.Dao.Orderdao;
import com.ass.model.Order;
import com.ass.model.User;
import com.ass.model.Product;
import com.ass.common.Sesssion;


@WebServlet("/OrderProduct")
public class OrderProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	if(!Sesssion.isLogin(request)) {
		request.getRequestDispatcher("/Login").forward(request, response);
		return;
		
		
	}
	String page = request.getParameter("page");
	String productId=request.getQueryString().substring(8, 12);
	if(productId==null) {
		
		
		request.getRequestDispatcher("/Homepage").forward(request, response);
		return;
	    }
	
		try {
			Orderdao dao = new Orderdao();
			Order ord = new Order();
			Product pro= new Product();
			pro.setProductId(productId);
			ord.setProduct(pro);
			
			String username= Sesssion.getLoginedUsername(request);
			User user= new User();
			user.setUsername(username);
			ord.setDate(new Date());
			ord.setUser(user);
			dao.insert(ord);
			
			request.setAttribute("message", "Your Product is Ordered!");
			
		} catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("error", e.getMessage());
		}
		if(page==null) {
			page="/Homepage";
			
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
