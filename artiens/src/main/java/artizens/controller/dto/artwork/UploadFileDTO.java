package artizens.controller.dto.artwork;

import org.springframework.web.multipart.MultipartFile;

public class UploadFileDTO {
	
	/**
	 * 아이디
	 */
	private Long id;
	
	/**
	 * 작품 제목
	 */
	private String title;
	
	/**
	 * 닉네임
	 */
	private String nickname;

	/**
	 * 이미지 파일
	 */
	private MultipartFile file;
	
	/**
	 * 태그 종류
	 */
	private String tagbox;
	
	/**
	 * 작품 종류
	 */
	private String subject;
	
	/**
	 * 작가의 말
	 */
	private String talk;

	
	
	
	@Override
	public String toString() {
		return "UploadFileDTO [id=" + id + ", title=" + title + ", nickname=" + nickname + ", file=" + file
				+ ", tagbox=" + tagbox + ", subject=" + subject + ", talk=" + talk + "]";
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public UploadFileDTO() {
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getTagbox() {
		return tagbox;
	}

	public void setTagbox(String tagbox) {
		this.tagbox = tagbox;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTalk() {
		return talk;
	}

	public void setTalk(String talk) {
		this.talk = talk;
	}
	
	
	
}
