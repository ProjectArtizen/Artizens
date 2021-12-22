package artizens.controller.dto.artwork;

public class BlogInfoDTO {
	
	/**
	 * nickname / profile / comment 
	 * image_url / date / title / artworkId /creatorId
	 */
	
	/**
	 *  Creator nickname
	 */
	private String nickname;
	
	/**
	 * Creator profile_image_storefilename
	 */
	private String profile;
	/**
	 * Creator_comment
	 */
	private String comment;
	
	/**
	 *  Image_storefilename
	 */
	private String images;
	
	/**
	 * ArtWork register_day
	 */
	private String date;
	
	/**
	 * ArtWork title
	 */
	private String title;
	
	/**
	 * ArtWork ID
	 */
	private Long artworkId;
	
	/**
	 * Creator ID
	 */
	private Long creatorId;
	
	/**
	 * Image Id
	 */
	private Long imageId;

	private Long follower;
	
	private Long folling;
	
	private String talk;
	
	
	
	@Override
	public String toString() {
		return "BlogInfoDTO [nickname=" + nickname + ", profile=" + profile + ", comment=" + comment + ", images="
				+ images + ", date=" + date + ", title=" + title + ", artworkId=" + artworkId + ", creatorId="
				+ creatorId + ", imageId=" + imageId + ", follower=" + follower + ", folling=" + folling + ", talk="
				+ talk + "]";
	}

	public String getTalk() {
		return talk;
	}

	public void setTalk(String talk) {
		this.talk = talk;
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public Long getImageId() {
		return imageId;
	}
	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getArtworkId() {
		return artworkId;
	}
	public void setArtworkId(Long artworkId) {
		this.artworkId = artworkId;
	}
	public Long getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}
	public Long getFollower() {
		return follower;
	}
	public void setFollower(Long follower) {
		this.follower = follower;
	}
	public Long getFolling() {
		return folling;
	}
	public void setFolling(Long folling) {
		this.folling = folling;
	}
	
}
