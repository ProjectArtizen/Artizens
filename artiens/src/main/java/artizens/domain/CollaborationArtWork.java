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
import javax.persistence.Table;

@Entity
@Table(name = "collaboration_artwork")
public class CollaborationArtWork {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "collaboration_artwork_id")
	private Long id;
	
	@Column(name = "collaboration_artwork_title")
	private String title;
	
	@Column(name = "collaboration_artwork_content")
	private String content;
	
	@Column(name = "collaboration_artwork_register_date")
	private Date registerDate;
	
	@Column(name = "collaboration_artwork_winner")
	private String winner; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "collaboration_id")
	private Collaboration collaboration;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "creator_id")
	private Creator creator;
	
	@OneToMany(mappedBy = "collaborationArtWork", cascade = CascadeType.ALL)
	private List<CollaborationArtWorkComment> collaborationArtWorkComments;
	
	@OneToMany(mappedBy = "collaborationArtWork", cascade = CascadeType.ALL)
	private List<CollaborationArtWorkImages> collaborationArtWorkImages;
	
	public CollaborationArtWork() {
	}
	
}
