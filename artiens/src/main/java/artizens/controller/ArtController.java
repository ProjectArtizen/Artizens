package artizens.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import artizens.controller.dto.artwork.StoreFileDTO;
import artizens.controller.dto.artwork.UploadFileDTO;
import artizens.domain.UploadFile;
import artizens.mapper.UserMapper;
import artizens.service.ArtService;
import artizens.web.aws.FileUploadService;

@Controller
public class ArtController {
		
	private static final Logger LOGGER = LoggerFactory.getLogger(ArtController.class);
	
	@Autowired FileUploadService fileUploadService;
	@Autowired UserMapper userMapper;
	@Autowired ArtService artService;
	
	@RequestMapping("/artizen/blog")
	public String userBlog( Model model) throws Exception {
		List<StoreFileDTO> store = artService.findByImageURL();
		model.addAttribute("store",store);
		for( StoreFileDTO storeFileDTO:store) {
			LOGGER.info("storeFile={}",storeFileDTO.getStoreFileName());
		}
		
		return "artWork/blog";
	}
	
	
	@GetMapping("/artizen/upload")
	public String FileUpload(Model model) {
		return "FileUpload/Upload";
	}
	
	@PostMapping("/artizen/upload")
	public String FileSave( @ModelAttribute UploadFileDTO uploadfiledto ) throws Exception {	
		
		UploadFileDTO upload = artService.insertText( uploadfiledto.getTitle(),
														  uploadfiledto.getNickname(),
														  uploadfiledto.getSubject());
		
		UploadFile uploadFile = fileUploadService.uploadImage( uploadfiledto.getFile() );
		
		artService.insertImageURL(uploadFile.getStoreFileName(), 
								  	  uploadFile.getUploadFileName(),
								  	  upload.getId());
		
		return "FileUpload/Upload";
		
	}
	
}
