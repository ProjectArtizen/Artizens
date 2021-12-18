package artizens.mapper.dto;

public class CollaborationDetailDto {
	
	private Long id;
	private String title;
	private String registerDate;
	private String creatorNickname;
	private String collaborationImgName;
	private String creatorImgName;
	private String content;
	private Integer commentCount;
	private Long commentId;
	private String comment;

	
	public CollaborationDetailDto() {
		
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getCreatorNickname() {
		return creatorNickname;
	}

	public void setCreatorNickname(String creatorNickname) {
		this.creatorNickname = creatorNickname;
	}

	public String getCollaborationImgName() {
		return collaborationImgName;
	}

	public void setCollaborationImgName(String collaborationImgName) {
		this.collaborationImgName = collaborationImgName;
	}

	public String getCreatorImgName() {
		return creatorImgName;
	}

	public void setCreatorImgName(String creatorImgName) {
		this.creatorImgName = creatorImgName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
