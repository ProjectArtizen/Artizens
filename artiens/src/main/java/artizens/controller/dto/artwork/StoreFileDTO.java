package artizens.controller.dto.artwork;

public class StoreFileDTO {

	private String storeFileName;
	private String uploadFileName;
	private String profileImage;
	private String content;
	private String nickname;
	
	
	
	@Override
	public String toString() {
		return "StoreFileDTO [storeFileName=" + storeFileName + ", uploadFileName=" + uploadFileName + ", profileImage="
				+ profileImage + ", content=" + content + ", nickname=" + nickname + "]";
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStoreFileName() {
		return storeFileName;
	}
	public void setStoreFileName(String storeFileName) {
		this.storeFileName = storeFileName;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
	
}	
