package artizens.web.file.local;

import artizens.web.file.UploadService;
import com.amazonaws.services.s3.model.ObjectMetadata;

import java.io.InputStream;

public class LocalFileUploadService  implements UploadService {

    @Override
    public void uploadFile(InputStream inputStream, ObjectMetadata objectMetadata, String fileName) {

    }

    @Override
    public String getFileUrl(String fileName) {
        return null;
    }
}
