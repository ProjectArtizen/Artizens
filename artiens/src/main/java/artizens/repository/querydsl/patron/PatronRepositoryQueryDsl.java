package artizens.repository.querydsl.patron;

import java.util.List;

import artizens.domain.Patron;

public interface PatronRepositoryQueryDsl {
	List<Patron> findAllPatronWithSort();
}
