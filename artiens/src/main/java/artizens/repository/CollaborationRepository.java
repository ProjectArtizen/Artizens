package artizens.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import artizens.domain.Collaboration;
public interface CollaborationRepository extends JpaRepository<Collaboration, Long>{
}
