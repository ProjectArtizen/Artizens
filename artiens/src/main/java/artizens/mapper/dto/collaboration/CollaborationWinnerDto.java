package artizens.mapper.dto.collaboration;

public class CollaborationWinnerDto {
	
	private Long collaborationId;
	private String image;
	private String title;
	private String nickname;
	
	
	public Long getCollaborationId() {
		return collaborationId;
	}
	public void setCollaborationId(Long collaborationId) {
		this.collaborationId = collaborationId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}
