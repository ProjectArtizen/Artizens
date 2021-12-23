package artizens.mapper.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class ArtWorkMainDto {
	 
	private Long id;
	private Long imageId;
	private String title;
	private String artworkImgName;
	private String creatorImgName;
	private String creatorNickName;
	private String registerday;
	private Integer likeCount;
	private Integer commentCount;
	
	public ArtWorkMainDto() {
		
	}
	
	public String getRegisterday() {
		return registerday;
	}

	public void setRegisterday(String registerday) {
		this.registerday = registerday;
	}

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
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
	public String getArtworkImgName() {
		return artworkImgName;
	}
	public void setArtworkImgName(String artworkImgName) {
		this.artworkImgName = artworkImgName;
	}
	public String getCreatorImgName() {
		return creatorImgName;
	}
	public void setCreatorImgName(String creatorImgName) {
		this.creatorImgName = creatorImgName;
	}
	public String getCreatorNickName() {
		return creatorNickName;
	}
	public void setCreatorNickName(String creatorNickName) {
		this.creatorNickName = creatorNickName;
	}
	public Integer getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}
	public Integer getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	
	public String Day( String registerday ) {
		SimpleDateFormat format = new SimpleDateFormat();
		Calendar cal = Calendar.getInstance();
		cal.getTimeInMillis();
		return "";
	}
	
}
