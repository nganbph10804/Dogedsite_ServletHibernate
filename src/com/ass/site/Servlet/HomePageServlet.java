package com.ass.site.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ass.admin.Dao.Productdao;
import com.ass.model.Product;
import com.ass.common.PageInfo;
import com.ass.common.PageType;

/**
 * Servlet implementation class HomePageServlet
 */
@WebServlet("/Homepage")
public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Productdao dao = new Productdao();
			
			List<Product> list= dao.findAll();
			request.setAttribute("products", list);
		} catch (Exception e) {
			e.printStackTrace();
			
		request.setAttribute("error", e.getMessage());
		} 
		
		
		PageInfo.prepareAndForwardSites(request, response, PageType.SITE_HOMEPAGE);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
