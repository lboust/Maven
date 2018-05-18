package com.mytube.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;



/**
 * Servlet implementation class VideoServlet
 */
@WebServlet("/player")
public class VideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoServlet() {
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
		
		VideoRepository videoRepo = new VideoRepository();
		
		Video currentVideo=videoRepo.findVideoById(6);
		request.setAttribute("currentVideo", currentVideo);
/*		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();	
			session.getTransaction().begin();
				Video currentVideo = session.find(Video.class, 6);
			session.getTransaction().commit();
		session.close();
	sessionFactory.close();
	request.setAttribute("currentVideo", currentVideo);
*/

		
		
		if (pathInfo == null) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/VideoWithHibernate.jsp").forward(request, response);

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
