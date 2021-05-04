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
import com.ass.admin.domain.ChangPasswordForm;
import com.ass.common.PageInfo;
import com.ass.common.PageType;
import com.ass.common.Sesssion;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePassword")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username= Sesssion.getLoginedUsername(request);
		if(username==null) {
			request.getRequestDispatcher("/Login").forward(request, response);
			return;
		} 
		
		request.setAttribute("username", username);
		
		
		PageInfo.prepareAndForwardSites(request, response, PageType.SITE_CHANGEPASSWORDPAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				String username = Sesssion.getLoginedUsername(request);
				
				ChangPasswordForm form =new ChangPasswordForm();
				BeanUtils.populate(form, request.getParameterMap());
				
				request.setAttribute("username", username);
				
				if(!form.getConfirmPassword().equals(form.getPassword())) {
					request.setAttribute("error", "new password and new confirm password are not identical!");
					
				}else {
					Userdao dao = new Userdao();
					dao.changePassword(form.getUsername(), form.getCurrentPassword(), form.getPassword());
					request.setAttribute("message", "Password has beeen changed");
					
				}
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("error", e.getMessage());
			}
		
		
		
		PageInfo.prepareAndForwardSites(request, response, PageType.SITE_CHANGEPASSWORDPAGE);
	}

}
