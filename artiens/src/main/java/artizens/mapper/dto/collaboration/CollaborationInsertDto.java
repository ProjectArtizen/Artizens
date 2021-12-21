package artizens.mapper.dto.collaboration;

import java.time.LocalDateTime;

public class CollaborationInsertDto {
	private Long id;
	private String title;
	private String deadLineDate;
	private String content;
	
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getDeadLineDate() {
		return deadLineDate;
	}
	public String getContent() {
		return content;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDeadLineDate(String deadLineDate) {
		this.deadLineDate = deadLineDate;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "CollaborationInsertDto [id=" + id + ", title=" + title + ", deadLineDate=" + deadLineDate + ", content="
				+ content + "]";
	}
	
	
}
