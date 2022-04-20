package com.example.waaonlineminimarketbackend.service.Implementation;

import com.example.waaonlineminimarketbackend.service.FileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Override
    public void uploadFile(MultipartFile file) throws IOException {
        file.transferTo(new File("C:\\Users\\k\\Desktop\\FileUpload\\" + file.getOriginalFilename())); //put directory of your preference
    }
}
