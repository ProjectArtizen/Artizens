package artizens.repository.querydsl.patron;

import java.util.List;
import java.util.stream.Collectors;

public class PatronCreatorRewardDto {
	private Long patronId;
	private String patronTitle;
	private String patronContent;
	private List<String> patronImages;
	private String creatorNickName;
	private List<RewardDto> rewards;
	
	public PatronCreatorRewardDto(
			Long patronId, 
			String patronTitle, 
			String patronContent, 
			String creatorNickName) {
		this.patronId = patronId;
		this.patronTitle = patronTitle;
		this.patronContent = patronContent;
		this.creatorNickName = creatorNickName;
	}

	public Long getPatronId() {
		return patronId;
	}

	public String getPatronTitle() {
		return patronTitle;
	}

	public String getPatronContent() {
		return patronContent;
	}

	public List<String> getPatronImages() {
		return patronImages;
	}

	public String getCreatorNickName() {
		return creatorNickName;
	}

	public List<RewardDto> getRewards() {
		return rewards;
	}

	public void setPatronId(Long patronId) {
		this.patronId = patronId;
	}

	public void setPatronTitle(String patronTitle) {
		this.patronTitle = patronTitle;
	}

	public void setPatronContent(String patronContent) {
		this.patronContent = patronContent;
	}

	public void setPatronImages(List<PatronImagesDto> patronImages) {
		this.patronImages = patronImages.stream().map(p -> p.patronUploadFileName).collect(Collectors.toList());;
	}

	public void setCreatorNickName(String creatorNickName) {
		this.creatorNickName = creatorNickName;
	}

	public void setRewards(List<RewardDto> rewards) {
		this.rewards = rewards;
	}
}	
