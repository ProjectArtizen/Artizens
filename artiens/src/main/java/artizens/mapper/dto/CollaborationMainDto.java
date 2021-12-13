package artizens.mapper.dto;

public class CollaborationMainDto {
	
	private Long id;
	private String title;
	private String registerDate;
	private String deadlineDate;
	private String[] deadlineDateAry = deadlineDate.split("-"); 
	private String createrNickname;
	private String collaborationImgName;
	private String createrImgName;
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
		this.deadlineDate = deadlineDate;
	}
	
	public String[] getDeadlineDateAry() {
		return deadlineDateAry;
	}

	public void setDeadlineDateAry(String[] deadlineDateAry) {
		this.deadlineDateAry = deadlineDateAry;
	}

	public String getCreaterNickname() {
		return createrNickname;
	}

	public void setCreaterNickname(String createrNickname) {
		this.createrNickname = createrNickname;
	}

	public String getCollaborationImgName() {
		return collaborationImgName;
	}

	public void setCollaborationImgName(String collaborationImgName) {
		this.collaborationImgName = collaborationImgName;
	}

	public String getCreaterImgName() {
		return createrImgName;
	}

	public void setCreaterImgName(String createrImgName) {
		this.createrImgName = createrImgName;
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
