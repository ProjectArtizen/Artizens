package artizens.repository.querydsl.patron;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.querydsl.jpa.impl.JPAQueryFactory;

import artizens.domain.Patron;

public class PatronRepositoryImpl implements PatronRepositoryQueryDsl{

	private final JPAQueryFactory queryFactory;
	
	public PatronRepositoryImpl(EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}
	
	@Override
	public List<Patron> findAllPatronWithSort() {
//		queryFactory.
//		select()
		
		return null;
	}
}
