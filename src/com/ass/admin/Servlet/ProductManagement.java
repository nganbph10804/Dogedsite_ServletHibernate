package com.ass.admin.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.ass.admin.Dao.Productdao;
import com.ass.model.Product;
import com.ass.common.PageInfo;
import com.ass.common.PageType;

@WebServlet({ "/Admin/ProductManagement", "/Admin/ProductManagement/create", "/Admin/ProductManagement/update",
		"/Admin/ProductManagement/delete", "/Admin/ProductManagement/edit" , "/Admin/ProductManagement/reset"})
@MultipartConfig
public class ProductManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		Product Product = new Product();
		Product.setImg("images/dq.jpg");

		findAll(request, response);

		request.setAttribute("product", Product);

		PageInfo.prepareAndForward(request, response, PageType.PRODUCT_MANAGEMENT_PAGE);
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		Product vid = new Product();
		vid.setImg("images/dq.jpg");
		
		request.setAttribute("Product", vid);
		PageInfo.prepareAndForward(request, response, PageType.PRODUCT_MANAGEMENT_PAGE);
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("productId");
		if (id == null) {
			request.setAttribute("error", "Product is required!");
			PageInfo.prepareAndForward(request, response, PageType.PRODUCT_MANAGEMENT_PAGE);
			return;
		}

		try {
			Productdao dao = new Productdao();
			Product pro = dao.findById(id);
			
			if(pro==null) {
				request.setAttribute("error", "Product not found!");
				PageInfo.prepareAndForward(request, response, PageType.PRODUCT_MANAGEMENT_PAGE);
				return;
			}
			dao.delete(id);
			request.setAttribute("message", "Product is deleted!");
			request.setAttribute("product", new Product());
			findAll(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		PageInfo.prepareAndForward(request, response, PageType.PRODUCT_MANAGEMENT_PAGE);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product vid = new Product();

		try {
			BeanUtils.populate(vid, request.getParameterMap());
			Productdao dao = new Productdao();
			dao.update(vid);
			request.setAttribute("product", vid);
			request.setAttribute("message", "Product is updated");
			findAll(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		PageInfo.prepareAndForward(request, response, PageType.PRODUCT_MANAGEMENT_PAGE);
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) {

		try {

			Productdao dao = new Productdao();

			List<Product> list = dao.findAll();
			request.setAttribute(getServletName(), dao);

			request.setAttribute("products", list);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("productId");
		if (id == null) {
			request.setAttribute("error", "Product is required!");
			PageInfo.prepareAndForward(request, response, PageType.PRODUCT_MANAGEMENT_PAGE);
			return;
		}

		try {
			Productdao dao = new Productdao();
			Product pro = dao.findById(id);
			request.setAttribute("product", pro);
			findAll(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		PageInfo.prepareAndForward(request, response, PageType.PRODUCT_MANAGEMENT_PAGE);
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product pro = new Product();

		try {
			BeanUtils.populate(pro, request.getParameterMap());
			Productdao dao = new Productdao();
			dao.insert(pro);

			request.setAttribute("product", pro);
			request.setAttribute("message", "Product is inserted!");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());

		}
		findAll(request, response);
		PageInfo.prepareAndForward(request, response, PageType.PRODUCT_MANAGEMENT_PAGE);
	}

}
