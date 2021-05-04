package com.ass.site.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ass.common.CookieUtils;
import com.ass.common.Sesssion;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	CookieUtils.add("username", null, 0, response);
	Sesssion.invalidate(request);
	request.setAttribute("isLogin", false);
	request.getRequestDispatcher("/Homepage").forward(request, response);
	
	}

}
