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
import com.ass.common.Sesssion;

/**
 * Servlet implementation class EditProfile
 */
@WebServlet("/EditProfile")
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = Sesssion.getLoginedUsername(request);
		if (username == null) {
			request.getRequestDispatcher("/Login").forward(request, response);
			return;

		}
		try {
			Userdao dao = new Userdao();
			User user = dao.findById(username);
			request.setAttribute("user", user);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		 PageInfo.prepareAndForwardSites(request, response, PageType.SITE_EDITPROFILEPAGE);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				try {
					User user = new User();
					BeanUtils.populate(user, request.getParameterMap());
					
					String username = Sesssion.getLoginedUsername(request);
					Userdao dao = new Userdao();
					User oldUser = dao.findById(username);

					user.setAdmin(oldUser.isAdmin());
					dao.update(user);
					request.setAttribute("message", "User profile is updated!");
					request.setAttribute("user", user);
					
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("error", e.getMessage());
				}
				 PageInfo.prepareAndForwardSites(request, response, PageType.SITE_EDITPROFILEPAGE);
	}

}
