package artizens.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import artizens.controller.dto.artwork.ArtDetailDTO;
import artizens.controller.dto.artwork.CommentDTO;
import artizens.controller.dto.artwork.BlogInfoDTO;
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
	@Autowired ArtService artService;
	
	public String insertImageUpload( UploadFileDTO uploadfiledto ) {
		
		UploadFileDTO upload = new UploadFileDTO();
		Long creator_id = artMapper.findByCreator(uploadfiledto.getNickname());		
		
		LOGGER.info("크리에이터아이디입니다={}",creator_id);
		upload.setTalk(uploadfiledto.getTalk());
		upload.setSubject(uploadfiledto.getSubject());
		upload.setTitle(uploadfiledto.getTitle());
		upload.setCreatorId(creator_id);
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
		LOGGER.info("업로드이미지파일={}",uploadFile.getStoreFileName());
		artWorkImagesMapper.insertArtWork( uploadFile.getStoreFileName(), uploadFile.getUploadFileName(), upload.getArtworkId());
		
		return "success";
	}
	
	public List<StoreFileDTO> findByAll( Long creator ) {
		
		List<StoreFileDTO> storeFileName = artMapper.findByImageURL( creator );
		return storeFileName;
	}
	
	public List<StoreFileDTO> findByProfile( Long creator ) {
		List<StoreFileDTO> store = artMapper.findByCreatorImage( creator );
		return store;
	}
	
	public String findByCreatorImage(Long creatorId ) {
		String profileImage = artMapper.findByCreatorProfileImage(creatorId);
		return profileImage;
	}
	
	public String findByCreatorName( Long creator ) {
		String nickname = artMapper.findByCreatorName(creator);
		return nickname;
	}
	
	public Long findByCreator(String nickname) {
		Long creatorId = artMapper.findByCreator(nickname);
		return creatorId;
	}
	
	public List<BlogInfoDTO> findByCreatorForBlogAll(Long creatorid ) {
		List<BlogInfoDTO> store = artMapper.findByCreatorBlogAll( creatorid );
		return store;
	}
	
	public ArtDetailDTO clickImageAction( Long imageId ) {
		
		List<ArtDetailDTO> store = artMapper.clickImageAction(imageId);
		ArtDetailDTO detail = new ArtDetailDTO();
		for( ArtDetailDTO a : store) {
			detail.setTitle(a.getTitle());
			detail.setTalk(a.getTalk());
			detail.setProfile(a.getProfile());
			detail.setNickname(a.getNickname());
			detail.setContent(a.getContent());
			detail.setImages(a.getImages());
			detail.setDate(a.getDate());
		}
		LOGGER.info("detail={}",detail.toString());
		return detail;
	}
	
	public String InsertComment( CommentDTO commentDto ) {
		artMapper.insertComment(commentDto.getArtworkId(),commentDto.getUserid(),commentDto.getComment());
		return "success";
	}
}