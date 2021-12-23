package artizens.mapper.dto.collaboration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.multipart.MultipartFile;

public class CollaborationMainDto {
	
//	private Long 
	private Long collaborationId;
	private Long collaborationImageId;
	private String title;
	private String content;
	private String deadLineDate;
	private String deadLineYear;
	private String deadLineMonth;
	private String deadLineDay;
	private String registerDate;
	private String storedFileName;
	private MultipartFile collaborationImage;
	
	public CollaborationMainDto() {
		super();
	}
	public CollaborationMainDto(Long collaborationId, String storedFileName) {
		this.collaborationId = collaborationId;
		this.storedFileName = storedFileName;
	}
	public Long getCollaborationId() {
		return collaborationId;
	}
	public Long getCollaborationImageId() {
		return collaborationImageId;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
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
	public String getDeadLineYear() {
		return deadLineYear;
	}
	public String getDeadLineMonth() {
		return deadLineMonth;
	}
	public String getDeadLineDay() {
		return deadLineDay;
	}
	
	
	
	
	public void setCollaborationId(Long collaborationId) {
		this.collaborationId = collaborationId;
	}
	public void setCollaborationImageId(Long collaborationImageId) {
		this.collaborationImageId = collaborationImageId;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setDeadLineDate(LocalDateTime deadLineDate) {
		this.deadLineDate = deadLineDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		this.deadLineYear = Integer.toString(deadLineDate.getYear());
		this.deadLineMonth = Integer.toString(deadLineDate.getMonthValue());
		this.deadLineDay = Integer.toString(deadLineDate.getDayOfMonth());
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public void setStoredFileName(String storedFileName) {
		this.storedFileName = storedFileName;
	}
	public void setCollaborationImage(MultipartFile collaborationImage) {
		this.collaborationImage = collaborationImage;
	}
	@Override
	public String toString() {
		return "CollaborationMainDto [collaborationId=" + collaborationId + ", collaborationImageId="
				+ collaborationImageId + ", title=" + title + ", content=" + content + ", deadLineDate=" + deadLineDate
				+ ", deadLineYear=" + deadLineYear + ", deadLineMonth=" + deadLineMonth + ", deadLineDay=" + deadLineDay
				+ ", registerDate=" + registerDate + ", storedFileName=" + storedFileName + ", collaborationImage="
				+ collaborationImage + "]";
	}
	
	
}
