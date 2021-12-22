package artizens.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "collaboration")
public class Collaboration {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "collaboration_id")
	private Long id;
	
	@Column(name = "collaboration_title", length = 45)
	private String title; 
	
	@Column(name = "collaboration_register_date")
	private Date registerDate;
	
	@Column(name = "collaboration_deadline_date")
	private Date deadlineDate;
	
	@Column(name = "collaboration_content", length = 1000000)
	private String content;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "creator_id")
	private Creator creator;
	
	@OneToMany(mappedBy = "collaboration", cascade = CascadeType.ALL)
	private List<CollaborationImages> collaborationImages;

	@OneToMany(mappedBy = "collaboration", cascade = CascadeType.ALL)
	private List<CollaborationComment> collaborationComment;
	
	public Collaboration() {
	}
	
	
	
	public Long getId() {
		return id;
	}



	public String getTitle() {
		return title;
	}



	public Date getRegisterDate() {
		return registerDate;
	}



	public Date getDeadlineDate() {
		return deadlineDate;
	}



	public String getContent() {
		return content;
	}



	public Creator getCreator() {
		return creator;
	}



	public List<CollaborationImages> getCollaborationImages() {
		return collaborationImages;
	}



	public List<CollaborationComment> getCollaborationComment() {
		return collaborationComment;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}



	public void setDeadlineDate(Date deadlineDate) {
		this.deadlineDate = deadlineDate;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public void setCreator(Creator creator) {
		this.creator = creator;
	}



	public void setCollaborationImages(List<CollaborationImages> collaborationImages) {
		this.collaborationImages = collaborationImages;
	}



	public void setCollaborationComment(List<CollaborationComment> collaborationComment) {
		this.collaborationComment = collaborationComment;
	}



	@Override
	public String toString() {
		return "Collaboration [id=" + id + ", title=" + title + ", registerDate=" + registerDate + ", deadlineDate="
				+ deadlineDate + ", content=" + content + ", creator=" + creator + ", collaborationImages="
				+ collaborationImages + ", collaborationComment=" + collaborationComment + "]";
	}
	
	

}
