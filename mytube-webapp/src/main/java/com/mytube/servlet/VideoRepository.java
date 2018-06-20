package com.mytube.servlet;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class VideoRepository {
	/**
	 * m�thode qui va chercher dans la database la vid�o � l'id demand�
	 * 
	 * @param id
	 * @return Video
	 */
	SessionFactory sessionFactory;
	Session session;
	public VideoRepository() {
		sessionFactory = HibernateUtils.getSessionFactory();
		session = sessionFactory.openSession();	
	}
	public void close() {
		session.close();
	sessionFactory.close();
	}
	public Video findVideoById(Integer id) {
			Video currentVideo = session.find(Video.class, id);
				session.getTransaction().begin();					
				session.getTransaction().commit();
		return currentVideo;
	}
	public Video findVideoByIdWithComments(Integer id) {

		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			Session session = sessionFactory.openSession();	
			String queryHQL = "SELECT v FROM Video v WHERE v.id = 1";
			Query<Video> query = session.createQuery(queryHQL, Video.class);
			Video resultQuery = query.uniqueResult();
			session.close();
		sessionFactory.close();
		return resultQuery;
	}
	
	public void addVideo(HttpServletRequest request) {

		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			Session session = sessionFactory.openSession();	
				
					Video video = new Video();	
					video.setTitle(request.getParameter("title"));
					video.setUrl(request.getParameter("url"));
					video.setDuration(Integer.parseInt(request.getParameter("duration")));
					Date date = new Date();
					video.setPublicationDate(date);
					video.setType(request.getParameter("type"));
					video.setNumberOfViews(0L);
					video.setNumberOfComments(0);
					video.setCapture(request.getParameter("capture"));
					video.setDescription(request.getParameter("description"));
					video.setUserId(14);
				session.getTransaction().begin();
				session.persist(video);
				session.getTransaction().commit();
			session.close();
		sessionFactory.close();
		
	}
	public List<Video> findAllVideos() {

		String queryHQL = "SELECT v FROM Video v";
		Query<Video> query = session.createQuery(queryHQL, Video.class);
		List<Video> resultQuery = query.getResultList();
			session.getTransaction().begin();
				
			session.getTransaction().commit();

	return resultQuery;
	
	}
	public List<Video> findAllOtherVideos(int i) {

		String queryHQL = "SELECT v FROM Video v WHERE v.id != 1";
		Query<Video> query = session.createQuery(queryHQL, Video.class);
		List<Video> resultQuery = query.getResultList();
		session.getTransaction().begin();
		
		session.getTransaction().commit();
		return resultQuery;
	}
	public List<Video> findTrending() {

		String queryHQL = "SELECT v FROM Video v WHERE v.type='Trending'";
		Query<Video> query = session.createQuery(queryHQL, Video.class);
		List<Video> resultQuery = query.getResultList();
		session.getTransaction().begin();
		
		session.getTransaction().commit();
		return resultQuery;
	}
	
	public List<Video> findRecommended() {

		String queryHQL = "SELECT v FROM Video v WHERE v.type='Recommended'";
		Query<Video> query = session.createQuery(queryHQL, Video.class);
		List<Video> resultQuery = query.getResultList();
		session.getTransaction().begin();
		
		session.getTransaction().commit();
		return resultQuery;
	}

}
