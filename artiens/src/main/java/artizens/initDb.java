package artizens;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import artizens.domain.Creator;
import artizens.domain.Patron;
import artizens.domain.PatronImages;
import artizens.domain.UploadFile;
import artizens.domain.UserProfile;

@Component
public class initDb {

	private final InitService initService;

	public initDb(InitService initService) {
		this.initService = initService;
	}

	/**
	 * 빈설정이 완료되면 @PostConstruct의 빈이 실행됨. initService.dbInit1() 가 실행되서 dbinit1()이
	 * 실행(db에 값이 넣어짐)
	 */
	@PostConstruct
	public void init() {
		initService.dbInit1();
	}

	@Component
	@Transactional
	static class InitService {

		private final EntityManager em;

		public InitService(EntityManager em) {
			this.em = em;
		}

		public void dbInit1() {
			// 최초 생성 user(admin) (creator 등록 완료, patron 등록 완료)
			UserProfile admin = UserProfile.createUser("user@gmail.com", "1234", "dlwngus");
			em.persist(admin);
			
			// admin creator
			UploadFile creatorImage = UploadFile.createUploadFile("admin.JPG",
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/066c7fb6-9a8c-462c-a4f1-c72a4cc74d8e.JPG");
			Creator creator = Creator.createCreator("배그의 고수", creatorImage, "otherUri", admin);
			em.persist(creator);
			
			// admin patron(후원등록 creator)
			List<UploadFile> patronImages = new ArrayList<UploadFile>();
			patronImages.add(UploadFile.createUploadFile("patron1.JPG",
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/89c55243-3157-4e11-8dd5-b993b90bc635.JPG"));
			patronImages.add(UploadFile.createUploadFile("patron2.JPG",
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/5d31e33d-3be5-4027-82fe-6459904df315.JPG"));
			patronImages.add(UploadFile.createUploadFile("patron3.jpg",
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/2a823132-b250-4435-9823-66a9978daac6.jpg"));
			
			Patron patron = Patron.createPatron("이것은 patron 제목입니다.", "이것은 내용이 들어갈 예정입니다.", creator, patronImages);
			em.persist(patron);
			
			
			
			// user(user1) (creator 등록, patron 미등록)
			UserProfile user1 = UserProfile.createUser("user1@gmail.com", "1234", "dlwngus");
			em.persist(user1);
			
			// user1 creator
			UploadFile creatorImage1 = UploadFile.createUploadFile("user1.JPG",
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/a173df44-0776-470b-9322-d8d4dc22b25c.JPG");
			Creator creator1 = Creator.createCreator("조커", creatorImage1, "otherUri", user1);
			em.persist(creator1);
			
			
			
			
			// user(user1) (creator 미등록, patron 미등록)
			UserProfile user2 = UserProfile.createUser("user2@gmail.com", "1234", "dlwngus");
			em.persist(user2);
			
			
		}

	}
}
