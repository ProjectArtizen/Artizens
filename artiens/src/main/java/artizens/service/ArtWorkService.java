package artizens.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import artizens.controller.dto.artwork.CreatorDTO;
import artizens.domain.ArtWork;
import artizens.domain.Creator;
import artizens.domain.UserProfile;
import artizens.mapper.ArtWorkImagesMapper;
import artizens.mapper.ArtWorkMapper;
import artizens.mapper.dto.ArtWorkMainDto;

@Service
public class ArtWorkService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ArtWorkService.class);
	
	@Autowired ArtWorkMapper artWorkMapper;
	@Autowired ArtWorkImagesMapper artWorkImagesMapper; 
	
	public List<ArtWorkMainDto> selectAll(){
		List<ArtWorkMainDto> result = artWorkMapper.findArtWorkMainAll();
		return result; 
	}
	
	public Long findByUserId( UserProfile user ) {
		
		Long UserId = user.getId();
		List<UserProfile> result = artWorkMapper.findByUserId( user );
		if ( result == null ) UserId = 0L;
		for( UserProfile id : result ) {
			UserId = id.getId();
		}
		LOGGER.info("userId={}",UserId);
		return UserId;
	}
	
	public Long findByCreatorId( Long userId ) {
		
		Long creatorId = 0L;
		List<Creator> creator = artWorkMapper.findByCreatorId( userId );
		for( Creator info : creator ) {
			creatorId = info.getId();
		}
		LOGGER.info("creatorId={}",creatorId);
		
		return creatorId;
	}
	
	public List<CreatorDTO> findByAll( Long creatorId ) {
		List<CreatorDTO> creator = artWorkMapper.findByCreator( creatorId );
		return creator;
	}
	
}
