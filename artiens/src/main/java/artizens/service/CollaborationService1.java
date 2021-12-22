package artizens.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import artizens.domain.UploadFile;
import artizens.mapper.CollaborationMapper;
import artizens.mapper.CollaborationMapper1;
import artizens.mapper.dto.collaboration.CollaborationDto;
import artizens.mapper.dto.collaboration.CollaborationMainDto;
import artizens.repository.CollaborationRepository;
import artizens.web.aws.FileUploadService;

@Service
@Transactional
public class CollaborationService1 {
	
	@Autowired CollaborationMapper1 collaborationMapper1;
	@Autowired CollaborationRepository collaborationRepository;
	@Autowired FileUploadService fileUploadService;
	
	
	// collaboration insert service method
	public CollaborationMainDto insertCollaboration(CollaborationMainDto dto) {
		// collaboration insert
		collaborationMapper1.insertCollaboration(dto);
		
		// mutipartfile -> aws -> uploadfile객체로 loadW
		UploadFile image = fileUploadService.uploadImage(dto.getCollaborationImage());
		CollaborationMainDto imageDto = new CollaborationMainDto(dto.getCollaborationId(), image.getStoreFileName());
		collaborationMapper1.insertCollaborationImage(imageDto);
		return dto;
	}
	
	public List<CollaborationMainDto> findAllByCollaboration(){
//		return collaborationRepository.findAll();
		return collaborationMapper1.findAllCollaboration();
	}

}
