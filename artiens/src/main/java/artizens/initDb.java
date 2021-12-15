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
			UserProfile admin = UserProfile.createUser("user@gmail.com", "1234", "고흐");
			em.persist(admin);

			// admin creator
			UploadFile creatorImage = UploadFile.createUploadFile("고흐.jpg",
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/1d741251-946f-43cf-a640-c92442a697f7.jpg");
			Creator creator = Creator.createCreator("고흐", creatorImage, "otherUri", admin);
			em.persist(creator);
			
			

			// admin patron(후원등록 creator)
			List<UploadFile> patronImages = new ArrayList<UploadFile>();
			patronImages.add(UploadFile.createUploadFile("별이빛나는밤에.JPG",
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/2fb61b17-7dcb-43ab-8a33-7bfb7ff83611.JPG"));
			patronImages.add(UploadFile.createUploadFile("카페.JPG",
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/d6d96ab0-d8f0-413e-b683-aaea23a89e2e.JPG"));
			patronImages.add(UploadFile.createUploadFile("침대.JPG",
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/b3b5addc-9b57-4639-a043-e4b455679bbd.JPG"));
				
			Patron patron = Patron.createPatron("나는 고흐다. 배고프다...", "저는 고흐입니다. 저에게 투자하시면 나중에 빛을 보실껍니다. 저는 이 돈으로 압생트를 사먹을 겁니다.", creator, patronImages);
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
			
			// user3 ~ 50 (creator 등록, patron 미등록)
			for (int i = 3; i <= 50; i++) {
				String userString = "user" + String.valueOf(i);
				UserProfile userProfile = UserProfile.createUser(userString + "@gmail.com", "1234", userString);
				em.persist(userProfile);
				
				UploadFile creatorImageDefault = UploadFile.createUploadFile("크리에이터.JPG",
						"https://sunminki.s3.ap-northeast-2.amazonaws.com/aef04562-61c7-4a8b-9bb5-851490cbff34.JPG");
				Creator creators = Creator.createCreator("제작자"+String.valueOf(i), creatorImageDefault, "www.naver.com", userProfile);
				em.persist(creators);
				
			}

			em.flush();
			em.clear();
		}

	}
}
