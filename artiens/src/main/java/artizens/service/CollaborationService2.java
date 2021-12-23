package artizens.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import artizens.mapper.CollaborationMapper2;
import artizens.mapper.dto.collaboration.CollaborationDetailDto;
import artizens.repository.CollaborationRepository;
import artizens.web.aws.FileUploadService;

@Service
@Transactional	
public class CollaborationService2 {
	@Autowired CollaborationMapper2 collaborationMapper;
	@Autowired CollaborationRepository collaborationRepository;
	@Autowired FileUploadService fileUploadService;
	
	public CollaborationDetailDto collaborationDetailForm(Long collaborationId) {
		return collaborationMapper.findCollaborationById(collaborationId);
	}
	
	public CollaborationDetailDto collaborationArtWotkDetailForm(Long collaborationArtWorkId) {
		return collaborationMapper.findaCollaboArtWorkById(collaborationArtWorkId);
	}
}
