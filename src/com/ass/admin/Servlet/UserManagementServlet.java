package com.ass.admin.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.ass.admin.Dao.Userdao;
import com.ass.common.PageInfo;
import com.ass.common.PageType; 
import com.ass.model.User;

/**
 * Servlet implementation class UserManagementServlet
 */
@WebServlet({"/UserManagementServlet","/UserManagementServlet/create","/UserManagementServlet/update"
		, "/UserManagementServlet/delete","/UserManagementServlet/reset","/UserManagementServlet/edit"
})
public class UserManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		if (url.contains("edit")) {
			edit(request, response);
			return;
		} else if (url.contains("delete")) {
			delete(request, response);
			return;
		}

		else if (url.contains("reset")) {
			reset(request, response);
			return;
		}
	
		

		findAll(request, response);

		
	 PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();

		if (url.contains("create")) {
			create(request, response);
			return;
		} else if (url.contains("update")) {
			update(request, response);
			return;
		} else if (url.contains("delete")) {
			delete(request, response);
			return;
		} else if (url.contains("reset")) {
			reset(request, response);
			return;
		}
	}

	private void reset(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User us = new User();
		request.setAttribute("user", us);
		PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userId");
		if (id == null) {
			request.setAttribute("error", "User is required!");
			PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
			return;
		}

		try {
			Userdao dao = new Userdao();
			User us = dao.findById(id);
			
			if(us==null) {
				request.setAttribute("error", "User not found!");
				PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
				return;
			}
			dao.delete(id);
			request.setAttribute("message", "User is deleted!");
			request.setAttribute("user", new User());
			findAll(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User us = new User();

		try {
			BeanUtils.populate(us, request.getParameterMap());
			Userdao dao = new Userdao();
			dao.update(us);
			request.setAttribute("user", us);
			request.setAttribute("message", "User is updated");
			findAll(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) {

		try {

			Userdao dao = new Userdao();

			List<User> list = dao.findAll();
			request.setAttribute(getServletName(), dao);

			request.setAttribute("users", list);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userId");
		if (id == null) {
			request.setAttribute("error", "User is required!");
			PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
			return;
		}

		try {
			Userdao dao = new Userdao();
			User us = dao.findById(id);
			request.setAttribute("user", us);
			findAll(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User us = new User();

		try {
				String id = request.getParameter("userId");
				String email = request.getParameter("mail");
				String pass = request.getParameter("password");
				String name = request.getParameter("fullname");
			us.setUserId(id);
			us.setEmail(email);
			us.setFullname(name);
			us.setPassword(pass);
			Userdao dao = new Userdao();
			
			dao.insert(us);

			request.setAttribute("user", us);
			request.setAttribute("message", "User is inserted!");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());

		}
		findAll(request, response);
		PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
	}
}
