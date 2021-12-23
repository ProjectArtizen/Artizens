package artizens.controller.dto.artwork;

public class CommentDTO {
	
	private String comment;
	private String userid;
	private String artworkId;
	
	@Override
	public String toString() {
		return "CommentDTO [comment=" + comment + ", userid=" + userid + ", artworkId=" + artworkId + "]";
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getArtworkId() {
		return artworkId;
	}
	public void setArtworkId(String artworkId) {
		this.artworkId = artworkId;
	}
	
	
}
