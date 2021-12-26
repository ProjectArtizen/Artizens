package artizens.mapper.dto.collaboration;

import org.springframework.web.multipart.MultipartFile;

public class CollaborationPlanningDto {
	
	private Long collaborationId;
	private String title;
	private String content;
	private String deadLineDate;
	private String registerDate;
	private String storedFileName;
	private MultipartFile collaborationImage;
	private Long creatorId;
	private String creatorNickName;
	private String creatorProfileStoredFileName;
	
	public CollaborationPlanningDto() {
		super();
	}
	
	public Long getCollaborationId() {
		return collaborationId;
	}
	public String getTitle() {
		return title;
	}
	public String getDeadLineDate() {
		return deadLineDate;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public String getStoredFileName() {
		return storedFileName;
	}
	public MultipartFile getCollaborationImage() {
		return collaborationImage;
	}
	public String getCreatorNickName() {
		return creatorNickName;
	}
	public String getCreatorProfileStoredFileName() {
		return creatorProfileStoredFileName;
	}
	public String getContent() {
		return content;
	}
	public Long getCreatorId() {
		return creatorId;
	}
	
	
	
	
	public void setCollaborationId(Long collaborationId) {
		this.collaborationId = collaborationId;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDeadLineDate(String deadLineDate) {
		this.deadLineDate = deadLineDate + " 23:59:59.111000";
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate.substring(0,10);
	}
	public void setStoredFileName(String storedFileName) {
		this.storedFileName = storedFileName;
	}
	public void setCollaborationImage(MultipartFile collaborationImage) {
		this.collaborationImage = collaborationImage;
	}
	public void setCreatorNickName(String creatorNickName) {
		this.creatorNickName = creatorNickName;
	}
	public void setCreatorProfileStoredFileName(String creatorProfileStoredFileName) {
		this.creatorProfileStoredFileName = creatorProfileStoredFileName;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}
	
	
	
	
	
}
	
