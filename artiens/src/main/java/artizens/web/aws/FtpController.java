package artizens.web.aws;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import artizens.domain.UploadFile;

@RestController
public class FtpController {
	private final FileUploadService fileUploadService;
	
    public FtpController(FileUploadService fileUploadService) {
		this.fileUploadService = fileUploadService;
	}
    
    
    @PostMapping("/awsUpload")
    public ResponseEntity<?> uploadImage(@RequestPart MultipartFile file){
        UploadFile uploadFile = fileUploadService.uploadImage(file);
        System.out.println(uploadFile.toString());
        return ResponseEntity.ok(uploadFile.toString());
    }
}
