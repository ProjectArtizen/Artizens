package artizens.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import artizens.mapper.CollaborateMapper;
import artizens.mapper.UserMapper;
import artizens.mapper.dto.CollaborationMainDto;

@Service
public class CollaborateService {
	@Autowired UserMapper userMapper;
	@Autowired CollaborateMapper collaborationmapper;
	
	public void insertCollaborate() {
	}

	public List<CollaborationMainDto> selectAll() {
		List<CollaborationMainDto> result = collaborationmapper.findcollaborationMainAll();
		return result;
	}
}
