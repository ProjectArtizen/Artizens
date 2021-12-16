package artizens.repository.querydsl.patron;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import artizens.domain.Patron;

public interface PatronRepositoryQueryDsl {
	
	List<PatronCreatorDto> findAllPatornWithCreator(Pageable pageable);
	
	List<PatronImagesDto> findAllPatronImagesInPatron(List<Long> patronIds);
	
}
