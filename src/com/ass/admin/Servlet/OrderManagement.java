package com.ass.admin.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import com.ass.admin.Dao.Favortitedao;
import com.ass.admin.Dao.Videodao;
import com.ass.admin.Model.Video;
import com.ass.common.PageInfo;
import com.ass.common.PageType;
import com.ass.admin.domain.FavoriteReport;
import com.ass.admin.domain.FavoriteUserReport;
/**
 * Servlet implementation class OrderManagement
 */
@WebServlet("/OrderManagement")
public class OrderManagement extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reportFavoritesByVideo(request, response);
		reportFavoriteUserByVideo(request, response);
		
		PageInfo.prepareAndForward(request, response,PageType.REPORT_MANAGEMENT_PAGE);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
protected void reportFavoriteUserByVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String vidUserId= request.getParameter("videoUserId");
			Videodao daoVid= new Videodao();
			List<Video> vList = daoVid.findAll();
			if(vidUserId==null&&vList.size()>0) {
				vidUserId = vList.get(0).getVideoId();
			}
			
			Favortitedao dao = new Favortitedao();
			List<FavoriteUserReport> list = dao.reportFavoriteUserByVideo(vidUserId);
			
			request.setAttribute("videoUserId", vidUserId);
			request.setAttribute("vidList", vList);
			
			request.setAttribute("favUsers", list);
		} catch (Exception e) {
			e.printStackTrace();
		request.setAttribute("error", e.getMessage());
		}
	}

protected void reportFavoritesByVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		Favortitedao dao = new Favortitedao();
		List<FavoriteReport> list = dao.reportFavoritesByVideos();
		request.setAttribute("favList", list);
	} catch (Exception e) {
		e.printStackTrace();
	request.setAttribute("error", e.getMessage());
	}
}

}
