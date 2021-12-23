package artizens.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import artizens.mapper.CollaborationMapper3;
import artizens.mapper.dto.collaboration.CollaborationWinnerDto;

@Service
public class CollaborationService3 {
	@Autowired CollaborationMapper3 collaborationMapper3;
	
	public List<CollaborationWinnerDto> findAllCollaborationWinner(){
		return collaborationMapper3.findAllCollaborationWinner();
	}

}
