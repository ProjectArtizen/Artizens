package artizens.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import artizens.controller.dto.artwork.StoreFileDTO;
import artizens.controller.dto.artwork.UploadFileDTO;
import artizens.mapper.ArtMapper;
import artizens.mapper.ArtWorkImagesMapper;

@Service
public class ArtService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ArtWorkService.class);
	
	@Autowired ArtMapper artMapper;
	@Autowired ArtWorkImagesMapper artWorkImagesMapper;
	
	public UploadFileDTO insertText( String title, String nickname, String subject ) {
		UploadFileDTO uploadfiledto = new UploadFileDTO();
		uploadfiledto.setTitle(title);
		uploadfiledto.setNickname(nickname);
		uploadfiledto.setSubject(subject);
		artMapper.insertText( uploadfiledto );
		return uploadfiledto;
	}
	
	public void insertImageURL( String storeFileName,String uploadFileName, Long id) {
		artWorkImagesMapper.insertArtWork(storeFileName, uploadFileName, id);
	}
	
	public List<StoreFileDTO> findByImageURL() {
		
		List<StoreFileDTO> storeFileName = artMapper.findByImageURL();
		
		LOGGER.info("storeFileName={}",storeFileName.toString());
		
		return storeFileName;
	}

}
