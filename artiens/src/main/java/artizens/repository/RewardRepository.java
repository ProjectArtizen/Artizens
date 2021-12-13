package artizens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import artizens.domain.Reward;

public interface RewardRepository extends JpaRepository<Reward, Long>{

}
