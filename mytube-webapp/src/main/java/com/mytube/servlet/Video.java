package com.mytube.servlet;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "video")

public class Video {
	// instance fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id; // cl�
		
	@Column(name="title")
	private String title; // titre de la vid�o
	
	@Column(name="url")
	private String url; // lien youtube
	
	@Column(name="duration")
	private Integer duration; // dur�e totale de la vid�o en s
	
	@Column(name="publicationdate")
	private Date publicationDate; // date et heure de publication

	@ManyToOne
	@JoinColumn(name="user_id", foreignKey=@ForeignKey(name="fk_video_user1"),insertable=false, updatable=false)
	private User author; // membre MyTube qui a publi� la vid�o
	
	//private List<Comment> comments; // liste des commentaires
	
	@Column(name="type")
	private String type; // type de vid�o
	
	@Column(name="numberofviews")
	private Long numberOfViews; // nombre de vues de la vid�o
	
	@Column(name="numberofcomments")
	private Integer numberOfComments; // nombre de commentaires d'une vid�o
	
	@Column(name="capture")
	private String capture; // src de la miniature
	
	@Column(name="description")
	private String description; // texte de description
	
	@Column(name = "user_id")
	private Integer userId; // cl� vers l'auteur

	//getters and setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getNumberOfViews() {
		return numberOfViews;
	}

	public void setNumberOfViews(Long numberOfViews) {
		this.numberOfViews = numberOfViews;
	}

	public Integer getNumberOfComments() {
		return numberOfComments;
	}

	public void setNumberOfComments(Integer numberOfComments) {
		this.numberOfComments = numberOfComments;
	}

	public String getCapture() {
		return capture;
	}

	public void setCapture(String capture) {
		this.capture = capture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
	


}
