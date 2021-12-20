package artizens.repository.querydsl.patron;

public class PatronImagesDto {
	Long patronId;
	String patronUploadFileName;
	
	public PatronImagesDto(Long patronId, String patronUploadFileName) {
		this.patronId = patronId;
		this.patronUploadFileName = patronUploadFileName;
	}

	public Long getPatronId() {
		return patronId;
	}

	public String getPatronUploadFileName() {
		return patronUploadFileName;
	}

	public void setPatronId(Long patronId) {
		this.patronId = patronId;
	}

	public void setPatronUploadFileName(String patronUploadFileName) {
		this.patronUploadFileName = patronUploadFileName;
	}
}
