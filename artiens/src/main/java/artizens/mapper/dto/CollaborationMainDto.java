package artizens.mapper.dto;

public class CollaborationMainDto {
	
	private Long id;
	private String title;
	private String registerDate;
	private String deadlineDate; 
	private String creatorNickname;
	private String collaborationImgName;
	private String creatorImgName;
	private Integer artworkCount;
	private Integer commentCount;
	
	
	
	public CollaborationMainDto() {
		
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

	public String getDeadlineDate() {
		return deadlineDate;
	}

	public void setDeadlineDate(String deadlineDate) {
		deadlineDate.split(".");
		this.deadlineDate = deadlineDate;
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

	public Integer getArtworkCount() {
		return artworkCount;
	}

	public void setArtworkCount(Integer artworkCount) {
		this.artworkCount = artworkCount;
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
}
