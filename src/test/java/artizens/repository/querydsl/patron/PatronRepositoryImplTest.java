package artizens.repository.querydsl.patron;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.querydsl.jpa.impl.JPAQueryFactory;

import artizens.domain.UploadFile;
import artizens.repository.PatronRepository;

import java.util.ArrayList;
import java.util.List;

@Transactional
@SpringBootTest
public class PatronRepositoryImplTest {
	
	@PersistenceContext EntityManager em;
	@Autowired PatronRepository patronRepository;
	
	JPAQueryFactory queryFactory;
	
	@BeforeEach
	public void before() {
		queryFactory = new JPAQueryFactory(em);
		List<UploadFile> uploadFile = new ArrayList<>();
//		UserProfile user = UserProfile.createUser("email.com", "1234", "dlwngus");
//		Creator creator = Creator.createCreator("nickname", "uri", user);
//		Patron patron = Patron.createPatron("title", "content", creator, uploadFile);
	}
	
	@Test
	public void patronRepositoryTest() {
		
//		PageRequest pageRequest = PageRequest.of(0,6);
//		Page<PatronCreatorDto> result = patronRepository.findAllPatronWithSort(pageRequest);
//		for (PatronCreatorDto patronCreatorDto : result) {
//			System.out.println(patronCreatorDto.toString());
//			for (String patronfile : patronCreatorDto.getPatronStoredFiles()) {
//				System.out.println(patronfile);
//			}
//		}
	}
}
