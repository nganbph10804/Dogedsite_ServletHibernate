package com.ass.site.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ass.admin.Dao.Userdao;
import com.ass.model.User;
import com.ass.admin.domain.Email;
import com.ass.common.EmailUtils;
import com.ass.common.PageInfo;
import com.ass.common.PageType;


@WebServlet("/ForgotPassword")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageInfo.prepareAndForwardSites(request, response, PageType.SITE_FORGOTPASSWORDPAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String emailAddress = request.getParameter("email");
			String username= request.getParameter("username");
			
			Userdao dao = new Userdao();
			User user = dao.findByUsernameAndMail(username, emailAddress);
			
			if(user==null) {
				request.setAttribute("error", "Username or email are incorrect!");
				return;
			}else {
				Email email = new Email();
				email.setFrom("nganbph10804@fpt.edu.vn");
				email.setFromPassword("cryomancer2309");
				email.setTo(emailAddress);
				email.setSubject("Forgot Password in DogedSite!");
				StringBuilder sb = new StringBuilder();
				sb.append("Dear ").append(username).append("<br>");
				sb.append("You are used the forgot password function in Dogedsite. <br>");
				sb.append("Your password is <b>").append(user.getPassword()).append("</b>");
				sb.append("Best regards! <br>");
				sb.append("Adminstrator");
				email.setContent(sb.toString());
				EmailUtils.send(email);
				
				
				request.setAttribute("message", "Email sent to the email Address!"+
												"Please check your email!"
						);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("error", e.getMessage());
		}
		
		
		PageInfo.prepareAndForwardSites(request, response, PageType.SITE_FORGOTPASSWORDPAGE);
	}

}
