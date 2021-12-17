package artizens.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import artizens.controller.PatronController;
import artizens.controller.dto.patron.PatronRegisterDto;
import artizens.domain.Creator;
import artizens.domain.Patron;
import artizens.domain.Reward;
import artizens.domain.UploadFile;
import artizens.domain.UserProfile;
import artizens.repository.CreatorRepository;
import artizens.repository.PatronRepository;
import artizens.repository.RewardRepository;
import artizens.repository.UserProfileRepository;
import artizens.repository.querydsl.patron.PatronCreatorDto;
import artizens.repository.querydsl.patron.PatronImagesDto;
import artizens.web.aws.FileUploadService;

@Service
@Transactional(readOnly = true)
public class PatronService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PatronService.class);
	
	@Autowired PatronRepository patronRepository;
	@Autowired CreatorRepository creatorRepository;
	@Autowired RewardRepository rewardRepository;
	@Autowired UserProfileRepository userProfileRepository;
	
	@Autowired FileUploadService fileUploadService;
	@Autowired RewardService rewardService;
	
	
	public String patronRegisterCondition(Long userId) {
		//user의 id가 존재하는지 체크
		Optional<UserProfile> user = userProfileRepository.findById(userId);
		if (user == null) {
			return "noUser";
		}
		// user가 creator에 등록이 됐는지 체크
		List<Creator> creators = creatorRepository.findAllByUserProfileId(user.get().getId());
		if (creators.size() == 0) {
			return "noCreator";
		}
		// user가 creator로 등록이 됐으면서 Patron에 이미 등록이 됐는지 체크
		List<Patron> patrons = patronRepository.findAllByCreatorId(creators.get(0).getId());
		if (patrons.size() > 0 ) {
			return "alreadyPatorn";
		}
		return "accept";
	}
	
	@Transactional
	public String registerPatronAndReward(PatronRegisterDto patronRegisterDto) {
		
		// patron 이미지 aws s3 반환
		List<UploadFile> patronImages = new ArrayList<UploadFile>();
		if (patronRegisterDto.getPatronFiles().get(0).getSize() > 0) {
			patronImages = fileUploadService.uploadImages(patronRegisterDto.getPatronFiles());
		}
		else {
			patronImages.add(
					UploadFile.createUploadFile(
					"patrondefault.jpg", 
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/03f17cb9-0a54-4051-979b-4afdf3fc4769.jpg"
					));
		}
		
		List<Creator> creator = creatorRepository.findAllByNickName(patronRegisterDto.getPatronAuthor());
		if (creator.size() == 0) {
			return "fail";
		}
		// patron 저장
		Patron patron = patronRepository.save(Patron.createPatron(
				patronRegisterDto.getPatronTitle(),
				patronRegisterDto.getPatronContent(),
				creator.get(0),
				patronImages));
		
		// reward 이미지 aws s3 반환
		List<UploadFile> rewardImages = new ArrayList<UploadFile>();
		if (patronRegisterDto.getRewardFiles().get(0).getSize() > 0) {
			rewardImages = fileUploadService.uploadImages(patronRegisterDto.getRewardFiles());
		}
		else {
			rewardImages.add(
					UploadFile.createUploadFile(
					"reward.jpg", 
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/2c55e43e-bb32-4d4b-819b-4be4eb254b64.JPG"
					));
		}
		
		Reward reward = rewardService.registerReward(
				patronRegisterDto.getRewardTitle(), 
				patronRegisterDto.getRewardContent(),
				patronRegisterDto.getRewardPrice(), 
				patronRegisterDto.getRewardCategory(),
				patron,
				rewardImages);
		
		LOGGER.info("reward={}",reward.toString());
		LOGGER.info("reward={}",reward.getRewardImages().toArray());
		return "complete";
	}
	
	public Page<PatronCreatorDto> totalPatronView(Pageable pageable){
		// paging 적용 patron join creator 전체 
		List<PatronCreatorDto> patronResult = patronRepository.findAllPatornWithCreator(pageable);
		
		// patronResult의 id만 추출
		List<Long> patronIds = patronResult.stream().map(patronResults -> patronResults.getPatronId()).collect(Collectors.toList());
		
		// id 순서대로 image 추출 -> patronId 별로 grouping
		List<PatronImagesDto> patronImages = patronRepository.findAllPatronImagesInPatron(patronIds);
		Map<Long, List<PatronImagesDto>> patronImagesMap = patronImages.stream().collect(Collectors.groupingBy(PatronImagesDto::getPatronId));
		
		// PatronCreatorDto에 List<patronImage> 세팅
		patronResult.forEach(p -> p.setPatronStoredFiles((patronImagesMap.get(p.getPatronId()))));
		
		return new PageImpl<PatronCreatorDto>(patronResult, pageable, patronRepository.count());
	}
	
}
