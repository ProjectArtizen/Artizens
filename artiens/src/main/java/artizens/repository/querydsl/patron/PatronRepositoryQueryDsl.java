package artizens.repository.querydsl.patron;

import java.util.List;

import org.springframework.data.domain.Pageable;

public interface PatronRepositoryQueryDsl {
	
	List<PatronCreatorDto> findAllPatornWithCreator(Pageable pageable);
	
	List<PatronImagesDto> findAllPatronImagesInPatron(List<Long> patronIds);
	
}
