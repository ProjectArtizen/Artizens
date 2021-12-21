package artizens.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import artizens.mapper.CollaborationMapper;
import artizens.mapper.dto.collaboration.CollaborationInsertDto;


@Service
public class CollaborationService {
	@Autowired CollaborationMapper collaborationMapper;
	
	public Long insertCollaboration(CollaborationInsertDto dto) {
		return collaborationMapper.insertCollaboration(dto);
	}
}
