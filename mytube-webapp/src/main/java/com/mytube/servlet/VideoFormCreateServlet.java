package com.mytube.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class VideoFormCreateServlet
 */
@WebServlet("/form")
public class VideoFormCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoFormCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html");
		response.setCharacterEncoding("UTF-8");
		
		String pathInfo = request.getPathInfo();
		if (pathInfo == null) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/video-creation.jsp").forward(request, response);

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
		
	Map<String, String> validationMap = new HashMap<>();

		request.setAttribute("request", request);
		
		Map<String, String> validationErrors = new HashMap<>();
		if (request.getParameter("title").isEmpty()) {
			validationErrors.put("title", "The title is too short");
		}
		
		if (request.getParameter("url").isEmpty()) {
			validationErrors.put("url", "Invalid url");
		}
		
		String duration = request.getParameter("duration");
		try {
			Integer.parseInt(duration);
			if (Integer.parseInt(duration)<0) {
				throw new Exception("Duration must be an integer");
			} 
		} catch (Exception e) {
			validationErrors.put("duration", "Duration must be an integer");
		}
		
		if (request.getParameter("type").isEmpty()) {
			validationErrors.put("type", "Invalid type");
		}
		
		if (request.getParameter("capture").isEmpty()) {
			validationErrors.put("capture", "Invalid capture");
		}
		
		if (validationErrors.isEmpty()) {
			VideoRepository repo = new VideoRepository();
			repo.addVideo(request);
			response.sendRedirect( request.getContextPath() + "/VideoPlayer");
			return;
			//redirection http


			  
		} else {
			request.setAttribute("validationErrors", validationErrors);
			this.getServletContext().getRequestDispatcher("/WEB-INF/video-creation.jsp").forward(request, response);
		}
		
		
	}

}
