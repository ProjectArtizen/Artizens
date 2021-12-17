package artizens;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import artizens.domain.ArtWork;
import artizens.domain.ArtWorkCategory;
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
			
			// admin artwork - 1
			List<UploadFile> artWorkImages1 = new ArrayList<UploadFile>();
			artWorkImages1.add(UploadFile.createUploadFile("별이빛나는밤에.JPG",
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/2fb61b17-7dcb-43ab-8a33-7bfb7ff83611.JPG"));
			artWorkImages1.add(UploadFile.createUploadFile("카페.JPG",
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/d6d96ab0-d8f0-413e-b683-aaea23a89e2e.JPG"));
			artWorkImages1.add(UploadFile.createUploadFile("침대.JPG",
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/b3b5addc-9b57-4639-a043-e4b455679bbd.JPG"));
			ArtWork artwork1 = ArtWork.createArtWork("고흐의 작품들", "이것은 별이 빛나고 있는 카페의 침대에 대한 내용입니다.", ArtWorkCategory.풍경화, creator, artWorkImages1);
			em.persist(artwork1);
			
			// admin artwork - 2
			List<UploadFile> artWorkImages2 = new ArrayList<UploadFile>();
			artWorkImages2.add(UploadFile.createUploadFile("해바라기.JPG",
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/99e159d2-c5f9-427e-bfe1-efec77549c54.JPG"));
			ArtWork artwork2 = ArtWork.createArtWork("해바라기", "이것은 고흐의 해바라기에 대한 내용입니다.", ArtWorkCategory.정물화, creator, artWorkImages2);
			em.persist(artwork2);
			
			// admin artwork - 3
			List<UploadFile> artWorkImages3 = new ArrayList<UploadFile>();
			artWorkImages3.add(UploadFile.createUploadFile("밀밭.JPG",
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/1d4bf854-584a-4b1b-b870-c8a61e4732ac.JPG"));
			ArtWork artwork3 = ArtWork.createArtWork("사이프러스가 서 있는 밀밭", "사이프러스가 서 있는 밀밭. 고흐, 1889년 6월 유화", ArtWorkCategory.풍경화, creator, artWorkImages3);
			em.persist(artwork3);
			
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

			
			
			// user(user2) (creator 미등록, patron 미등록)
			UserProfile user2 = UserProfile.createUser("user2@gmail.com", "1234", "dlwngus");
			em.persist(user2);
			
			
			
			
			// user3 ~ 50 (creator 등록, patron 미등록)
			for (int i = 3; i <= 100; i++) {
				String userString = "user" + String.valueOf(i);
				UserProfile userProfile = UserProfile.createUser(userString + "@gmail.com", "1234", userString);
				em.persist(userProfile);
				
				// 참쉽죠 아저씨 이미지 
				UploadFile creatorImageDefault = UploadFile.createUploadFile("크리에이터.JPG",
						"https://sunminki.s3.ap-northeast-2.amazonaws.com/aef04562-61c7-4a8b-9bb5-851490cbff34.JPG");
				Creator creators = Creator.createCreator("제작자"+String.valueOf(i), creatorImageDefault, "www.naver.com", userProfile);
				em.persist(creators);
				
				// admin patron(후원등록 creator)
				List<UploadFile> bobImages = new ArrayList<UploadFile>();
				bobImages.add(UploadFile.createUploadFile("밥로스_산.JPG",
						"https://sunminki.s3.ap-northeast-2.amazonaws.com/48958747-6658-4803-a2d6-cc4bb41ed225.JPG"));
				bobImages.add(UploadFile.createUploadFile("밥로스_숲.JPG",
						"https://sunminki.s3.ap-northeast-2.amazonaws.com/3acb7a41-e7ee-4409-bcdd-9fafff667db0.JPG"));
				bobImages.add(UploadFile.createUploadFile("밥로스_노을산.JPG",
						"https://sunminki.s3.ap-northeast-2.amazonaws.com/e1730b52-28ad-4245-9359-375964ba1b41.JPG"));
				bobImages.add(UploadFile.createUploadFile("밥로스_설원.JPG",
						"https://sunminki.s3.ap-northeast-2.amazonaws.com/3db768bb-9b2e-432b-98bd-b28a9e6af5c4.JPG"));
				Patron bobPatron = Patron.createPatron("저는 그림이 쉬운 밥로스입니다.", "저는 밥로스입니다. 이렇게 그리면 됩니다. 참쉽죠?", creators, bobImages);
				em.persist(bobPatron);
				
			}

			
			
			// jpa 영속성 컨텍스트 초기화
			em.flush();
			em.clear();
		}

	}
}
