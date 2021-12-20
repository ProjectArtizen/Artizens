package artizens.repository.querydsl.patron;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.data.domain.Pageable;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import static artizens.domain.QCreator.creator;
import static artizens.domain.QPatron.patron; 
import static artizens.domain.QPatronImages.patronImages;; 

public class PatronRepositoryImpl implements PatronRepositoryQueryDsl{
	
	private final EntityManager entityManager;
	private final JPAQueryFactory queryFactory;
	
	public PatronRepositoryImpl(EntityManager em) {
		this.entityManager = em;
		this.queryFactory = new JPAQueryFactory(entityManager);
	}
	
	// patron 생성 일시 순으로 생성
	@Override
	public List<PatronCreatorDto> findAllPatornWithCreator(Pageable pageable){
		return queryFactory.
				select(Projections.constructor(PatronCreatorDto.class,
						patron.id,
						patron.title,
						patron.content,
						patron.createdDate,
						creator.nickName,
						creator.uploadFile.storeFileName))
				.from(patron)
				.leftJoin(patron.creator, creator)
				.offset(pageable.getOffset())
				.limit(pageable.getPageSize())
				.orderBy(patron.createdDate.asc())
				.fetch();
	}
	
	@Override
	public List<PatronImagesDto> findAllPatronImagesInPatron(List<Long> patronIds){
		return queryFactory.select(Projections.constructor(PatronImagesDto.class, 
				patronImages.patron.id,
				patronImages.uploadFile.storeFileName))
		.from(patronImages)
		.where(patronImages.patron.id.in(patronIds))
		.fetch();
	}
	
}
