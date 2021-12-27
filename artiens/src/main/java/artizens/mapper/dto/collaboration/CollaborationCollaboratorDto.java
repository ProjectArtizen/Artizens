package artizens.mapper.dto.collaboration;

public class CollaborationCollaboratorDto {
	private Long creatorId;
	/*
	 * creator nickname 
	 */
	private String onenickname;
	
	/*
	 *  creator_profile_storefilename
	 */
	private String creatorimage;
	
	/*
	 * collaboration_register_date
	 */
	private String registerdate;

	
	
	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	public String getOnenickname() {
		return onenickname;
	}

	public void setOnenickname(String onenickname) {
		this.onenickname = onenickname;
	}

	public String getCreatorimage() {
		return creatorimage;
	}

	public void setCreatorimage(String creatorimage) {
		this.creatorimage = creatorimage;
	}

	public String getRegisterdate() {
		return registerdate;
	}

	public void setRegisterdate(String registerdate) {
		this.registerdate = registerdate.substring(0,10);
	}
	
	
}
