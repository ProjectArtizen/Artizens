package artizens.service;


import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import artizens.domain.Creator;
import artizens.domain.UserProfile;

@Transactional
@SpringBootTest
class PatronServiceTest {
	
	@Autowired PatronService patronService;
	@Autowired EntityManager em;
	
	
	private UserProfile createUserTest() {
		return UserProfile.createUser("email", "1234", "dlwngus");
	}
	
	private Creator createCreatorTest(UserProfile userProfile) {
		return Creator.createCreator("creatorNamd", "otherUri", userProfile);
	}
	
	@Test
	void patronRegister권한확인() throws Exception {
		
		UserProfile userProfile = createUserTest();
		em.persist(userProfile);
		Creator creator = createCreatorTest(userProfile);
		em.persist(creator);
		
		String accept = patronService.patronRegisterCondition(userProfile.getId());
		
		Assertions.assertThat(accept).isEqualTo("accept");
	}

}