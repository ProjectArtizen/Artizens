package artizens.repository.querydsl.patron;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import artizens.domain.PatronImages;

public class PatronCreatorDto {
	private Long patronId;
	private String patronTitle;
	private String patronContenet;
	private String patronRegisterDate;
	private List<String> patronStoredFiles;
	private String creatorNickName;
	private String creatorStoredFiles;
	
	public PatronCreatorDto(
			Long patronId,
			String patronTitle, 
			String patronContenet, 
			LocalDateTime patronRegisterDate,
			List<PatronImages> patronImages,
			String creatorNickName, 
			String creatorStoredFiles) {
		this.patronId = patronId;
		this.patronTitle = cutContentLength(patronTitle);
		this.patronContenet = cutContentLength(patronContenet);
		this.patronRegisterDate = patronRegisterDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		this.patronStoredFiles = 
				patronImages
				.stream()
				.map(patronimages->patronimages.getUploadFile().getStoreFileName())
				.collect(Collectors.toList());
		this.creatorNickName = creatorNickName;
		this.creatorStoredFiles = creatorStoredFiles;
	}

	public Long getPatronId() {
		return patronId;
	}
	public String getPatronTitle() {
		return patronTitle;
	}
	public String getPatronContenet() {
		return patronContenet;
	}
	public String getPatronRegisterDate() {
		return patronRegisterDate;
	}
	public List<String> getPatronStoredFiles() {
		return patronStoredFiles;
	}
	public String getCreatorNickName() {
		return creatorNickName;
	}
	public String getCreatorStoredFiles() {
		return creatorStoredFiles;
	}
	public String cutContentLength(String content) {
//		if (content.length() > 10) {
//			return content.substring(0, 10) + "...";
//		}
		return content;
	}
	@Override
	public String toString() {
		return "PatronCreatorDto [patronId=" + patronId + ", patronTitle=" + patronTitle + ", patronContenet="
				+ patronContenet + ", patronRegisterDate=" + patronRegisterDate + ", patronStoredFiles="
				+ patronStoredFiles + ", creatorNickName=" + creatorNickName + ", creatorStoredFiles="
				+ creatorStoredFiles + "]";
	}

}
