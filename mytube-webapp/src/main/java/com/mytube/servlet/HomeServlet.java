package com.mytube.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class myTubeServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	VideoRepository videoRepo = null; 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("Content-Type", "text/html");
		response.setCharacterEncoding("UTF-8");
		
		String pathInfo= request.getPathInfo();
		
		if (videoRepo == null) videoRepo = new VideoRepository();
		
		List<Video> videoList = new ArrayList<>();
		videoList = videoRepo.findAllVideos();
		request.setAttribute("allVideoList", videoList);
		
		List<Video> trendingVideoList = new ArrayList<>();
		trendingVideoList = videoRepo.findTrending();
		request.setAttribute("trendingVideoList", trendingVideoList);
		
		List<Video> recommendedVideoList = new ArrayList<>();
		recommendedVideoList = videoRepo.findRecommended();
		request.setAttribute("recommendedVideoList", recommendedVideoList);
		
		//if (videoRepo != null) videoRepo.close();
		
		if (pathInfo == null ) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
			
		
		} else {
			response.setStatus(404);
			response.getWriter().append("<p>404 - La page demand�e n'existe pas</p>");
			return;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
