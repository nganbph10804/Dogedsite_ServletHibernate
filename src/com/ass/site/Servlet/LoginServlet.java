package com.ass.site.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.beanutils.BeanUtils;

import com.ass.admin.Dao.Userdao;
import com.ass.admin.Dao.Userdao;
import com.ass.model.User;
import com.ass.admin.domain.LoginForm;
import com.ass.common.CookieUtils;
import com.ass.common.PageInfo;
import com.ass.common.PageType;
import com.ass.common.Sesssion;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username = CookieUtils.get("username", request);
		if(username==null) {
			PageInfo.prepareAndForwardSites(request, response, PageType.SITE_LOGINPAGE);
			return;
		}
	 Sesssion.add(request, "username", username);
	 request.getRequestDispatcher("/Homepage").forward(request, response);
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			LoginForm form = new LoginForm();
			
			BeanUtils.populate(form, request.getParameterMap());
			Userdao dao = new Userdao();
			User user = dao.findById(form.getUsername());
			if(user!=null && user.getPassword().equals(form.getPassword())) {
				Sesssion.add(request,"username", form.getUsername());
				if(form.isRemember()) {
					CookieUtils.add("username", form.getUsername(), 24, response);
				}else {
					CookieUtils.add("username", form.getUsername(), 0, response);
				}
				request.setAttribute("isLogin", true);
				request.setAttribute("name", user.getFullname());
				if(user.isAdmin()) {
					request.setAttribute("name", user.getFullname());
					request.getRequestDispatcher("/Administration").forward(request, response);
				}
				request.getRequestDispatcher("/Homepage").forward(request, response);
				return;
			}
			request.setAttribute("error", "invalid user or password");
			
		} catch (Exception e) { 
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		PageInfo.prepareAndForwardSites(request, response, PageType.SITE_LOGINPAGE);
	}

}
