package artizens.service;

import java.util.List;
import java.util.Map;

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
		artMapper.insertArtWork( upload );
		
		upload.setFile( uploadfiledto.getFile() );
		UploadFile uploadFile = fileUploadService.uploadImage( upload.getFile() );
		artWorkImagesMapper.insertArtWork( uploadFile.getStoreFileName(), uploadFile.getUploadFileName(), upload.getArtworkId());
		
		return "success";
	}
	
	public String noneCreatorUpload( UploadFileDTO uploadfiledto ) {
		
		UploadFileDTO upload = new UploadFileDTO();
		upload.setNickname(uploadfiledto.getNickname());
		upload.setUserProfileId(uploadfiledto.getUserProfileId());
		artMapper.insertCreatorNickname( upload );
		
		upload.setTalk(uploadfiledto.getTalk());
		upload.setSubject(uploadfiledto.getSubject());
		upload.setTitle(uploadfiledto.getTitle());
		upload.setCreatorId(upload.getCreatorId());
		artMapper.insertArtWork( upload );
		
		upload.setFile( uploadfiledto.getFile() );
		UploadFile uploadFile = fileUploadService.uploadImage( upload.getFile() );
		artWorkImagesMapper.insertArtWork( uploadFile.getStoreFileName(), uploadFile.getUploadFileName(), upload.getArtworkId());
		
		return "success";
	}
	
	public List<StoreFileDTO> findByAll( Long creator ) {
		
		List<StoreFileDTO> storeFileName = artMapper.findByImageURL( creator );
		LOGGER.info("storeFileName={}",storeFileName.toString());
		return storeFileName;
	}
	
	public List<StoreFileDTO> findByProfile( Long creator ) {
		List<StoreFileDTO> store = artMapper.findByCreatorImage( creator );
		return store;
	}
	
}