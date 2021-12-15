package artizens.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import artizens.controller.dto.artwork.StoreFileDTO;
import artizens.controller.dto.artwork.UploadFileDTO;
import artizens.domain.UploadFile;
import artizens.mapper.ArtMapper;
import artizens.mapper.ArtWorkImagesMapper;
import artizens.web.aws.FileUploadService;

@Service
public class ArtService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ArtWorkService.class);
	
	@Autowired ArtMapper artMapper;
	@Autowired ArtWorkImagesMapper artWorkImagesMapper;
	@Autowired FileUploadService fileUploadService;
	
	public String insertImageUpload( UploadFileDTO uploadfiledto ) {
		
		UploadFileDTO upload = new UploadFileDTO();
		upload.setNickname(uploadfiledto.getNickname());
		upload.setUserProfileId(uploadfiledto.getUserProfileId());
		artMapper.insertCreatorNickname( upload );
		
		upload.setTalk(uploadfiledto.getTalk());
		upload.setSubject(uploadfiledto.getSubject());
		upload.setTitle(uploadfiledto.getTitle());
		upload.setCreatorId(upload.getCreatorId());
		Long artworkId = artMapper.insertArtWork( upload );
		
		upload.setFile( uploadfiledto.getFile() );
		UploadFile uploadFile = fileUploadService.uploadImage( upload.getFile() );
		artWorkImagesMapper.insertArtWork( uploadFile.getStoreFileName(), uploadFile.getUploadFileName(), artworkId);
		
		return "이미지 업로드 성공";
	}
	
	public List<StoreFileDTO> findByImageURL() {
		
		List<StoreFileDTO> storeFileName = artMapper.findByImageURL();
		
		LOGGER.info("storeFileName={}",storeFileName.toString());
		
		return storeFileName;
	}

}