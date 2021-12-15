package artizens.repository.querydsl.patron;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

import artizens.domain.Patron;

import static artizens.domain.QCreator.creator;
import static artizens.domain.QPatron.patron; 
import static artizens.domain.QPatronImages.patronImages;; 

public class PatronRepositoryImpl implements PatronRepositoryQueryDsl{

	private final JPAQueryFactory queryFactory;
	
	public PatronRepositoryImpl(EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}
	
	@Override
	public List<PatronCreatorDto> findAllPatronWithSort() {
		List<Patron> patrons = queryFactory.
		selectFrom(patron)
		.leftJoin(patron.creator, creator).fetchJoin()
		.fetch();
		
		List<PatronCreatorDto> result = patrons.stream().map(
				maps -> new PatronCreatorDto(
						maps.getId(),
						maps.getTitle(), 
						maps.getContent(),
						maps.getCreatedDate(),
						maps.getPatronImages(),
						maps.getCreator().getNickName(),
						maps.getCreator().getUploadFile().getStoreFileName())).collect(Collectors.toList());

		return result;
	}
}
