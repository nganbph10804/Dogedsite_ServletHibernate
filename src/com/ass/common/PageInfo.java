package com.ass.common;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

public class PageInfo {
  public static Map<PageType, PageInfo> pageRoute = new HashedMap();
	   static {
		   // admin side
		   pageRoute.put(PageType.USER_MANAGEMENT_PAGE, new PageInfo("User Management","/admin/user/users.jsp",null));
		   pageRoute.put(PageType.ORDER_MANAGEMENT_PAGE, new PageInfo("Orders","/admin/order/orders.jsp",null));
		   pageRoute.put(PageType.PRODUCT_MANAGEMENT_PAGE, new PageInfo("Products","/admin/product/products.jsp",null));
		   pageRoute.put(PageType.ADMINISTRATION_PAGE, new PageInfo("Videos","/admin/common/welcome.jsp",null));
		   
		   // site side
		   pageRoute.put(PageType.SITE_HOMEPAGE, new PageInfo("Homepage","/site/home/home.jsp",null));
		   pageRoute.put(PageType.SITE_LOGINPAGE, new PageInfo("Login","/site/user/login.jsp",null));
		   pageRoute.put(PageType.SITE_REGISTRATIONPAGE, new PageInfo("Registration","/site/user/registration.jsp",null));
		   pageRoute.put(PageType.SITE_CHANGEPASSWORDPAGE, new PageInfo("Change Password","/site/user/change-password.jsp",null));
		   pageRoute.put(PageType.SITE_EDITPROFILEPAGE, new PageInfo("Edit Profile","/site/user/edit-profile.jsp",null));
		   pageRoute.put(PageType.SITE_FORGOTPASSWORDPAGE, new PageInfo("ForgotPassword","/site/user/forgot-password.jsp",null));
		   pageRoute.put(PageType.SITE_CARTPAGE, new PageInfo("YourCart","/site/cart.jsp",null));
	   }
	   public static void prepareAndForward(HttpServletRequest req,HttpServletResponse resp,PageType pageType)
	   throws ServletException,IOException
	   {
		   PageInfo page = pageRoute.get(pageType);
		   
		   req.setAttribute("page", page);
		   req.getRequestDispatcher("/admin/layout.jsp").forward(req, resp);
	   }
	   
	   public static void prepareAndForwardSites(HttpServletRequest req, HttpServletResponse resp,PageType pageType)
			   throws ServletException,IOException
			   {
				   PageInfo page = pageRoute.get(pageType);
				   
				   req.setAttribute("page", page);
				   req.getRequestDispatcher("/site/layout.jsp").forward(req, resp);
			   }
	   
   	private String title;
   	private String contentURL;
   	private String scriptURL;
   	
   	
   	
   	
	public PageInfo(String title, String contentURL, String scriptURL) {
		super();
		this.title = title;
		this.contentURL = contentURL;
		this.scriptURL = scriptURL;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContentURL() {
		return contentURL;
	}
	public void setContentURL(String contentURL) {
		this.contentURL = contentURL;
	}
	public String getScriptURL() {
		return scriptURL;
	}
	public void setScriptURL(String scriptURL) {
		this.scriptURL = scriptURL;
	}
   	
}
