package artizens.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import artizens.domain.UploadFile;
import artizens.domain.UserProfile;
import artizens.mapper.CollaborationMapper2;
import artizens.mapper.dto.collaboration.CollaborationArtWorkInsertDto;
import artizens.mapper.dto.collaboration.CollaborationArtworkDetailDto;
import artizens.mapper.dto.collaboration.CollaborationDetailDto;
import artizens.repository.CollaborationRepository;
import artizens.web.aws.FileUploadService;

@Service
@Transactional	
public class CollaborationService2 {
	@Autowired CollaborationMapper2 collaborationMapper;
	@Autowired CollaborationRepository collaborationRepository;
	@Autowired FileUploadService fileUploadService;
	
	/**
	 * collaboartion 단건 상세조회
	 * @param collaborationId
	 * @return
	 */
	public CollaborationDetailDto collaborationDetailForm(Long collaborationId) {
		return collaborationMapper.findCollaborationById(collaborationId);
	}
	
	/**
	 * collaborationArtwork 단건 상세 조회
	 * @param collaborationArtWorkId
	 * @return
	 */
	public CollaborationArtworkDetailDto collaborationArtWotkDetailForm(Long collaborationArtWorkId) {
		return collaborationMapper.findaCollaboArtWorkById(collaborationArtWorkId);
	}
	
	/**
	 * collaborationArtwork Insert 
	 * @param collaborationArtWorkInsertDto
	 * 조건 : 일단 로그인을 해야되고, 크리에이터에 등록되야되고, 자신이 올린 공모전에는 참가신청을 할수 없음.
	 * return CollaborationArtWorkId
	 */
	public String insertCollaborationArtWotk(UserProfile user, CollaborationArtWorkInsertDto collaborationArtWorkInsertDto) {
		//user 권한 확인
		if (user == null) {
			return "noUser";
		}
		Long creatorId = collaborationMapper.findCreaotrByUserId(user.getId());
		if (creatorId == 0L) 
			return "noCreator";
		Long collaborationId = collaborationMapper.findCollaborationByCreatorId(creatorId);
		if (collaborationId == collaborationArtWorkInsertDto.getCollaborationId()) {
			return "organizer";
		}
		UploadFile uploadFile = fileUploadService.uploadImage(collaborationArtWorkInsertDto.getFile());
		collaborationArtWorkInsertDto.setFileName(uploadFile.getStoreFileName());
		collaborationArtWorkInsertDto.setCreatorId(creatorId);
		collaborationMapper.insertCollaborationArtWork(collaborationArtWorkInsertDto);
		return collaborationArtWorkInsertDto.getCollaborationArtWorkId().toString();
	}
	
}
