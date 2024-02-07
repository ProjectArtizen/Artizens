package artizens;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import artizens.domain.ArtWork;
import artizens.domain.ArtWorkCategory;
import artizens.domain.Collaboration;
import artizens.domain.CollaborationArtWork;
import artizens.domain.Creator;
import artizens.domain.Patron;
import artizens.domain.PatronImages;
import artizens.domain.Reward;
import artizens.domain.RewardCategory;
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
			/**
			 * user - admin
			 * creator - creator 등록 완료,
			 * patron - patron 등록 완료)
			 */
			UserProfile admin = UserProfile.createUser("user@gmail.com", "1234", "고흐");
			em.persist(admin);

			// admin creator
			UploadFile creatorImage = UploadFile.createUploadFile("고흐.png",
					"/images/artwork/profile/gogh.png");
			Creator creator = Creator.createCreator("고흐", creatorImage, "otherUri", admin);
			em.persist(creator);

			// admin artwork - 1
			List<UploadFile> artWorkImages1 = new ArrayList<UploadFile>();
			artWorkImages1.add(UploadFile.createUploadFile("별이빛나는밤에.png",
					"/images/artwork/profile/2fb61b17-7dcb-43ab-8a33-7bfb7ff83611.png"));
			artWorkImages1.add(UploadFile.createUploadFile("카페.png",
					"/images/artwork/profile/d6d96ab0-d8f0-413e-b683-aaea23a89e2e.png"));
			artWorkImages1.add(UploadFile.createUploadFile("침대.png",
					"/images/artwork/profile/b3b5addc-9b57-4639-a043-e4b455679bbd.png"));
			ArtWork artwork1 = ArtWork.createArtWork("고흐의 작품들", "이것은 별이 빛나고 있는 카페의 침대에 대한 내용입니다.", ArtWorkCategory.풍경화, creator, artWorkImages1);
			em.persist(artwork1);

			// admin artwork - 2
			List<UploadFile> artWorkImages2 = new ArrayList<UploadFile>();
			artWorkImages2.add(UploadFile.createUploadFile("해바라기.png",
					"/images/artwork/profile/99e159d2-c5f9-427e-bfe1-efec77549c54.png"));
			ArtWork artwork2 = ArtWork.createArtWork("해바라기", "이것은 고흐의 해바라기에 대한 내용입니다.", ArtWorkCategory.정물화, creator, artWorkImages2);
			em.persist(artwork2);

			// admin artwork - 3
			List<UploadFile> artWorkImages3 = new ArrayList<UploadFile>();
			artWorkImages3.add(UploadFile.createUploadFile("밀밭.png",
					"/images/artwork/profile/1d4bf854-584a-4b1b-b870-c8a61e4732ac.png"));
			ArtWork artwork3 = ArtWork.createArtWork("사이프러스가 서 있는 밀밭", "사이프러스가 서 있는 밀밭. 고흐, 1889년 6월 유화", ArtWorkCategory.풍경화, creator, artWorkImages3);
			em.persist(artwork3);

			// admin patron(후원등록 creator)
			List<UploadFile> patronImages = new ArrayList<UploadFile>();
			patronImages.add(UploadFile.createUploadFile("별이빛나는밤에.png",
					"/images/artwork/profile/2fb61b17-7dcb-43ab-8a33-7bfb7ff83611.png"));
			patronImages.add(UploadFile.createUploadFile("카페.png",
					"/images/artwork/profile/d6d96ab0-d8f0-413e-b683-aaea23a89e2e.png"));
			patronImages.add(UploadFile.createUploadFile("침대.png",
					"/images/artwork/profile/b3b5addc-9b57-4639-a043-e4b455679bbd.png"));

			Patron patron = Patron.createPatron("나는 고흐다. 배고프다...", "저는 고흐입니다. 저에게 투자하시면 나중에 빛을 보실껍니다. 저는 이 돈으로 압생트를 사먹을 겁니다.", creator, patronImages);
			em.persist(patron);


			/**
			 * user - user1 조커
			 * creator - creator1 등록 완료,
			 * patron - 미등록)
			 */
			UserProfile user1 = UserProfile.createUser("user1@gmail.com", "1234", "dlwngus");
			em.persist(user1);

			// user1 creator
			UploadFile creatorImage1 = UploadFile.createUploadFile("user1.png",
					"/images/patron/creator/author/a173df44-0776-470b-9322-d8d4dc22b25c.png");
			Creator creator1 = Creator.createCreator("조커", creatorImage1, "otherUri", user1);
			em.persist(creator1);



			/**
			 * user - user2
			 * creator - 미등록,
			 * patron - 미등록)
			 */
			UserProfile user2 = UserProfile.createUser("user2@gmail.com", "1234", "dlwngus");
			em.persist(user2);





			RewardCategory[] rewardCategory = RewardCategory.values();

			// user3 ~ 50 (creator 등록, patron 미등록)
			/**
			 * user - userProfile(user3 ~user100)
			 * creator - creators(제작자3 ~ 제작자100),
			 * patron - bobPatron 등록
			 * reward - reward - (달력, 컵, 노트 이미지 등록, 나머지는 default))
			 */
			for (int i = 3; i <= 100; i++) {
				String userString = "user" + String.valueOf(i);
				UserProfile userProfile = UserProfile.createUser(userString + "@gmail.com", "1234", userString);
				em.persist(userProfile);

				// 참쉽죠 아저씨 이미지
				UploadFile creatorImageDefault = UploadFile.createUploadFile("밥로스.png",
						"/images/patron/creator/author/fe9b1626-bd9a-40ae-934f-6ec53b96b062.png");
				Creator creators = Creator.createCreator("제작자"+String.valueOf(i), creatorImageDefault, "www.naver.com", userProfile);
				em.persist(creators);


				// artwork 100개 (creators)
				List<UploadFile> artWorkImages = new ArrayList<UploadFile>();
				artWorkImages.add(UploadFile.createUploadFile("별이빛나는밤에.png",
						"/images/artwork/profile/2fb61b17-7dcb-43ab-8a33-7bfb7ff83611.png"));
				artWorkImages.add(UploadFile.createUploadFile("카페.png",
						"/images/artwork/profile/d6d96ab0-d8f0-413e-b683-aaea23a89e2e.png"));
				artWorkImages.add(UploadFile.createUploadFile("침대.png",
						"/images/artwork/profile/b3b5addc-9b57-4639-a043-e4b455679bbd.png"));
				ArtWork artworks = ArtWork.createArtWork("고흐의 작품들TEST"+String.valueOf(i), "이것은 별이 빛나고 있는 카페의 침대에 대한 내용"+String.valueOf(i)+"입니다.", ArtWorkCategory.추상화, creators, artWorkImages);
				em.persist(artworks);


				// admin patron(후원등록 creator)
				List<UploadFile> bobImages = new ArrayList<UploadFile>();
				bobImages.add(UploadFile.createUploadFile("밥로스_산.png",
						"/images/patron/creator/items/48958747-6658-4803-a2d6-cc4bb41ed225.png"));
				bobImages.add(UploadFile.createUploadFile("밥로스_숲.png",
						"/images/patron/creator/items/3acb7a41-e7ee-4409-bcdd-9fafff667db0.png"));
				bobImages.add(UploadFile.createUploadFile("밥로스_노을산.png",
						"/images/patron/creator/items/e1730b52-28ad-4245-9359-375964ba1b41.png"));
				bobImages.add(UploadFile.createUploadFile("밥로스_설원.png",
						"/images/patron/creator/items/3db768bb-9b2e-432b-98bd-b28a9e6af5c4.png"));
				Patron bobPatron = Patron.createPatron("저는 그림이 쉬운 밥로스입니다.", "저는 밥로스입니다. 이렇게 그리면 됩니다. 참쉽죠?", creators, bobImages);
				em.persist(bobPatron);

				// admin reward(후원등록 creator)
				List<UploadFile> rewardImages = new ArrayList<UploadFile>();
				String itemName = rewardCategory[i % rewardCategory.length].toString();

				if (itemName.equals(RewardCategory.calendar.toString())) {
					rewardImages.add(UploadFile.createUploadFile("calendar.png", "/images/patron/creator/items/17c51c8c-ccbf-4f80-b29b-204659fefd6c.png"));
					rewardImages.add(UploadFile.createUploadFile("calendar2.png", "/images/patron/creator/items/d5cb43ed-86c8-477c-9294-aea7b05996b8.png"));
				}
				else if (itemName.equals(RewardCategory.cup.toString())) {
					rewardImages.add(UploadFile.createUploadFile("cup.png", "/images/patron/creator/items/3dd96fb8-5112-4b28-9a1a-4ce85cb91f74.png"));
					rewardImages.add(UploadFile.createUploadFile("cup2.png", "/images/patron/creator/items/950b49d1-da98-4be9-bd5e-408d98484ca3.png"));
				}
				else if(itemName.equals(RewardCategory.note.toString())) {
					rewardImages.add(UploadFile.createUploadFile("note.png", "/images/patron/creator/items/6b4247b3-a10e-4ec7-995b-e0bb11d4afd8.png"));
					rewardImages.add(UploadFile.createUploadFile("note2.png", "/images/patron/creator/items/79c5f226-2d24-4ba1-a1d3-8f6be0702c87.png"));
				}else {
					rewardImages.add(UploadFile.createUploadFile("rewardDefault.png","/images/patron/creator/items/c04a08bd-8ae3-44d8-9405-268e449eacdc.png"));
				}

				Reward reward = Reward.createReward("리워드"+ String.valueOf(i), "내용"+String.valueOf(i), i*1000, itemName, bobPatron , rewardImages);
				em.persist(reward);
			}

			// 콜라보레이션 initDB

			/**
			 * creator : admin
			 * collaboration : 아티즌과 함께하는 피자 일러스트 공모전
			 */
			Collaboration collaboration1 = Collaboration.createCollaboration(
					"아티즌과 함께하는 피자 일러스트 공모전",
					LocalDateTime.now().plusDays(7),
					"참여 방법<br>" +
							"맛있는 피자의 모습을 그려주세요!<br>" +
							"※ 실제 공모전이 아닌 프로젝트 보여주기용 공모전입니다.",
					creator,
					"/images/collaboration/col/f97bc0b0-262d-49d4-a9eb-f455d4666499.png");
			em.persist(collaboration1);

			/**
			 * creator : creator1
			 * collaboration : 아티즌과 함께하는 피자 일러스트 공모전
			 * collaborationArtWork : 피자집 주인이 미대생?
			 */
			CollaborationArtWork collabo1_1 = CollaborationArtWork.createCollaborationArtWork(
					"피자집 주인이 미대생?",
					"피자 주문을 한지 2시간.. 피자가 배달되어 상자를 열었더니 그림이 그려져 있었다.",
					creator1,
					"/images/collaboration/art/86ff7b55-2e81-4406-b041-e5097d4a95eb.png",
					collaboration1);
			em.persist(collabo1_1);

			/**
			 * creator : creator1
			 //			 * collaboration : 아티즌과 함께하는 피자 일러스트 공모전
			 * collaborationArtWork : 토핑(2021)
			 */
			CollaborationArtWork collabo1_2 = CollaborationArtWork.createCollaborationArtWork(
					"토핑(2021)",
					"- 앙리 마티스",
					creator1,
					"/images/collaboration/art/350bc0cf-ecea-40c0-8468-eb4171e8482c.png",
					collaboration1);
			em.persist(collabo1_2);


			/**
			 * creator : creator1
			 * collaboration : 아티즌과 함께하는 피자 일러스트 공모전
			 * collaborationArtWork : 불고기 피자
			 */
			CollaborationArtWork collabo1_3 = CollaborationArtWork.createCollaborationArtWork(
					"불고기 피자",
					"불 : 불고심해 가스밸브 잘 잠그고<br>" +
							"고 : 고기같은 것도 좀 사먹어<br>" +
							"기 : 기어이 독립하니 좋니?<br>" +
							"피 : 피치 못할 사정 아니면 가끔은<br>" +
							"자 : 자기 전에 엄마한테 연락 좀 해줘",
					creator1,
					"/images/collaboration/art/fe6e509d-d195-467b-a8f0-b1b029a52104.png",
					collaboration1);
			em.persist(collabo1_3);


			/**
			 * creator : creator1
			 * collaboration : 천하제일 무술대회 포스터 공모전
			 */
			Collaboration collaboration2 = Collaboration.createCollaboration(
					"천하제일 무술대회 포스터 공모전",
					LocalDateTime.now().plusDays(3),
					"참여 방법<br>" +
							"당신의 그림으로 무술의 화려한 세계를 표현하세요!<br>" +
							"참가자들에게 무술의 숨겨진 아름다움과 역동성을 전달할 예술 작품을 만들어주세요.<br> " +
							"내가 그린 포스터가 무술가들에게 알려질 기회를 드립니다.<br>" +
							"※ 실제 공모전이 아닌 프로젝트 보여주기용 공모전입니다.",
					creator1,
					"/images/collaboration/col/86ff7b55-2e81-4406-b041-e5097d4a95eb.png");
			em.persist(collaboration2);

			/**
			 * creator : creator(admin)
			 * collaboration : 천하제일 무술대회 포스터 공모전
			 * collaborationArtWork : 시대(2021)
			 */
			CollaborationArtWork collabo2_1 = CollaborationArtWork.createCollaborationArtWork(
					"시대(2021)",
					"- Midjourney",
					creator,
					"/images/collaboration/art/104516de-26e0-4ac0-889e-abcdc7c2465c.png",
					collaboration2);
			em.persist(collabo2_1);

			/**
			 * creator : creator(admin)
			 * collaboration : 천하제일 무술대회 포스터 공모전
			 * collaborationArtWork : 투혼
			 */
			CollaborationArtWork collabo2_2 = CollaborationArtWork.createCollaborationArtWork(
					"투혼",
					"영화 Bloodsport(1988)을 아십니까? <br>" +
							"프랑스의 무희인 프랭크 덕(Frank Dux)이 <br>" +
							"전 세계에서 최강의 무술가들이 모여 싸우는 전설적인 무예 대회인 쿠마이태겐에서 <br>" +
							"세계 최고의 무희들과 대결하고자 하는 이야기를 다룹니다.<br>" +
							"누가 주인공이 되겠습니까?",
					creator,
					"/images/collaboration/art/3795aca1-6cf2-4317-8e27-63e3d004ea87.png",
					collaboration2);
			em.persist(collabo2_2);

			/**
			 * creator : creator(admin)
			 * collaboration : 천하제일 무술대회 포스터 공모전
			 * collaborationArtWork : 전설
			 */
			CollaborationArtWork collabo2_3 = CollaborationArtWork.createCollaborationArtWork(
					"전설",
					"bruce lee VS chuck norris",
					creator,
					"/images/collaboration/art/5d8e76ed-351b-4443-890c-f09064b55608.png",
					collaboration2);
			em.persist(collabo2_3);


			/**
			 * creator : creator(admin)
			 * collaboration : 천하제일 무술대회 포스터 공모전
			 * collaborationArtWork : 마스터
			 * image : collaboartwork2-4.JPG
			 */
			CollaborationArtWork collabo2_4 = CollaborationArtWork.createCollaborationArtWork(
					"마스터",
					"정확도가 파워를 압도하고. 타이밍이 스피드를 이긴다.<br>" +
							"- 맥그리거",
					creator,
					"/images/collaboration/art/9a82bfde-82d0-4e57-ba8b-dc0faa0b1353.png",
					collaboration2);
			em.persist(collabo2_4);

			/**
			 * creator : creator1
			 * collaboration : 아르누보 양식의 영화 포스터 공모전
			 */
			Collaboration collaboration3 = Collaboration.createCollaboration(
					"아르누보 양식의 영화 포스터 공모전",
					LocalDateTime.now().minusDays(10),
					LocalDateTime.now().minusDays(1),
					"참여 방법<br>" +
							"* 자유롭게 아르누보 양식을 응용한 영화 포스터를 그려서 제출하세요.<br>" +
							"* 콜라보레이션의 취지(주제와 무관 또는 광고, 타인 작품 도용 등)에 맞지 않는 응모작은 보기가 제한될 수 있습니다.<br>" +
							"※ 실제 공모전이 아닌 프로젝트 보여주기용 공모전입니다.",
					creator1,
					"/images/collaboration/col/f4f4979b-aad5-435c-bc72-8a5858ffcac6.png");
			em.persist(collaboration3);

			/**
			 * creator : creator
			 * collaboration : 아르누보 양식의 영화 포스터 공모전
			 * collaborationArtWork : 100살 공주의 리즈 시절
			 */
			CollaborationArtWork collabo3_1 = CollaborationArtWork.createCollaborationArtWork(
					"100살 공주의 리즈 시절",
					"백설공주와 일곱 난쟁이를 모티브로 아르누보 양식의 일러스트를 그렸습니다.",
					creator,
					"/images/collaboration/art/8f09f2f6-bce5-4356-95ca-24041cef96a9.png",
					collaboration3);
			em.persist(collabo3_1);

			/**
			 * creator : creator
			 * collaboration : 아르누보 양식의 영화 포스터 공모전
			 * collaborationArtWork : 인어공주
			 */
			CollaborationArtWork collabo3_2 = CollaborationArtWork.createCollaborationArtWork(
					"인어공주",
					"인어공주를 모티브로 아르누보 양식의 일러스트를 그렸습니다.",
					creator,
					"/images/collaboration/art/d2a1bcc3-3e1d-4305-bce1-ebe25faeded2.png",
					collaboration3);
			em.persist(collabo3_2);

			/**
			 * creator : creator
			 * collaboration : 아르누보 양식의 영화 포스터 공모전
			 * collaborationArtWork : 4번 달걀의 비밀
			 * image : collaboartwork3-3.JPG
			 */
			CollaborationArtWork collabo3_3 = CollaborationArtWork.createCollaborationArtWork(
					"말레피센트",
					"잘 들으시오, 모두 다, <br>" +
							"오로라 공주는 바라는대로 우아하고 아름답게 자라 모든 사람의 사랑을 받게 될 것이다. " +
							"그러나.<br>" +
							"그건 오로라 공주의 16번째 생일까지만이지. <br>" +
							"그 해가 저물기 전에, 공주는 손가락을 물레바늘에 찔려 죽게 될 거다.<br>" +
							"- 말레피센트",
					creator,
					"/images/collaboration/art/a1643e2c-49fa-4e8d-b67c-c639f460a54e.png",
					collaboration3);
			em.persist(collabo3_3);


			// jpa 영속성 컨텍스트 초기화
			em.flush();
			em.clear();
		}

	}
}
