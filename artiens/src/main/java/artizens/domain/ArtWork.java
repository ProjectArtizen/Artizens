package artizens.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "artwork")
public class ArtWork {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "artwork_id")
	private Long id;
	
	@Column(name = "artwork_title", length = 45)
	private String title;
	
	@Column(name = "artwork_content", length = 1000000)
	private String content;

	@Column(name = "artwork_inquiry_num")
	private int inquiryNum;
	
	@Column(name = "artwork_sympathy_num")
	private int sympathyNum;
	
	@Column(name = "artwork_register_date")
	private Date registerDate;
	
	@Column(name = "artwork_category_name", length = 45)
	private String categoryName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "creator_id")
	private Creator creator;
	
	@OneToMany(mappedBy = "artWork", cascade = CascadeType.ALL)
	private List<ArtWorkComment> artWorkComment;
	
	@OneToMany(mappedBy = "artWork", cascade = CascadeType.ALL)
	private List<ArtWorkArtWorkTag> artWorkArtWorkTag;
	
	@OneToMany(mappedBy = "artWork", cascade = CascadeType.ALL)
	private List<ArtWorkImages> artWorkImages;
	
	public ArtWork() {
	}
	
	// 외래키 artWork 만 주입하고 다시 return
	public List<ArtWorkImages> updateArtWorkImage(List<ArtWorkImages> artWorkImages) {
		for (ArtWorkImages images : artWorkImages) {
			images.setArtWork(this);
		}
		return artWorkImages;
	}
	
//	public static ArtWork createArtWork1(String title, String content) {
//		ArtWork artwork = new ArtWork();
//		artwork.title = title;
//		artwork.content = content;
//		 return artwork;
//	}

	public static ArtWork createArtWork(String title, String content, List<ArtWorkImages> artWorkImages) {
		ArtWork artwork = new ArtWork();
		artwork.title = title;
		artwork.content = content;
		artwork.artWorkImages = artwork.updateArtWorkImage(artWorkImages);
		return artwork;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public int getInquiryNum() {
		return inquiryNum;
	}

	public int getSympathyNum() {
		return sympathyNum;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public List<ArtWorkComment> getArtWorkComment() {
		return artWorkComment;
	}

	public List<ArtWorkArtWorkTag> getArtWorkArtWorkTag() {
		return artWorkArtWorkTag;
	}

	public List<ArtWorkImages> getArtWorkImages() {
		return artWorkImages;
	}
}
