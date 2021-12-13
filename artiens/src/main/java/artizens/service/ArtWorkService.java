package artizens.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import artizens.domain.ArtWork;
import artizens.mapper.ArtWorkImagesMapper;
import artizens.mapper.ArtWorkMapper;
import artizens.mapper.dto.ArtWorkMainDto;

@Service
public class ArtWorkService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ArtWorkService.class);
	
	@Autowired ArtWorkMapper artWorkMapper;
	@Autowired ArtWorkImagesMapper artWorkImagesMapper; 
	
	public ArtWork insertArtWotk(String title, String content) {
		ArtWork artWork = ArtWork.createArtWork1(title, content);
		artWorkMapper.insertArtWork(artWork.getTitle(), artWork.getContent());
		return artWork;
	}
	
	public List<ArtWorkMainDto> selectAll(){
		List<ArtWorkMainDto> result = artWorkMapper.findArtWorkMainAll();
		return result; 
	}
	
}
