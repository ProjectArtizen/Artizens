package artizens.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import artizens.domain.Patron;
import artizens.domain.Reward;
import artizens.domain.UploadFile;
import artizens.repository.RewardRepository;

@Service
@Transactional(readOnly = true)
public class RewardService {

	@Autowired RewardRepository rewardRepository;
	
	@Transactional
	public Reward registerReward(
			String title, 
			String content,
			int price,
			String subject, 
			Patron patron,
			List<UploadFile> rewardImages) {
		return rewardRepository.save(Reward.createReward(title, content, price, subject, patron, rewardImages));
	}
	
	
	
}
