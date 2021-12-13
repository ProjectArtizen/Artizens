package artizens.mapper.dto;


public class ArtWorkMainDto {
	 
	private Long id;
	private String title;
	private String artworkImgName;
	private String creatorImgName;
	private String creatorNickName ;
	private Integer likeCount;
	private Integer commentCount;
	
	public ArtWorkMainDto() {
		
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
	
}
