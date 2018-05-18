package com.mytube.servlet;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Commentary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // cl�
	
	private String message;
	
	@ManyToOne
	@JoinColumn(name="user_id", foreignKey=@ForeignKey(name="is_written_by"))
	private User author;
	
	@ManyToOne
	@JoinColumn(name="video_id", foreignKey=@ForeignKey(name="belongs_to"))
	private Video video;

	//getters and setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}
}


