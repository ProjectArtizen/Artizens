package artizens.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import artizens.domain.Collaboration;
import artizens.mapper.CollaborateMapper;
public interface CollaborationRepository extends JpaRepository<Collaboration, Long>{
}
