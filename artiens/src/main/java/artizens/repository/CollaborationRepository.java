package artizens.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import artizens.domain.Collaboration;
import artizens.mapper.CollaborateMapper;
import artizens.mapper.CollaborationMapper;
public interface CollaborationRepository extends JpaRepository<Collaboration, Long>{
}
