package com.ass.site.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.ass.admin.Dao.Userdao;
import com.ass.model.User;
import com.ass.common.PageInfo;
import com.ass.common.PageType;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PageInfo.prepareAndForwardSites(request, response, PageType.SITE_REGISTRATIONPAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		User user = new User();
		try {
			
			
			BeanUtils.populate(user, request.getParameterMap());
			Userdao dao = new Userdao();
			dao.insert(user);
			request.setAttribute("message", "success!");
			request.getRequestDispatcher("/Login").forward(request, response);
			return;
		} catch (Exception e) {
		e.printStackTrace();
		request.setAttribute("error", e.getMessage());
		}
		request.setAttribute("user", user);
		PageInfo.prepareAndForwardSites(request, response, PageType.SITE_REGISTRATIONPAGE);
	}

}
