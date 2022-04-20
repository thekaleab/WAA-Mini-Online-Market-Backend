package com.example.waaonlineminimarketbackend.service.Implementation;

import com.example.waaonlineminimarketbackend.service.FileUploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Value("${static.image.path}")
    private String imageBaseUrl;

    @Override
    public void uploadFile(MultipartFile file) throws IOException {
        String path = imageBaseUrl + file.getOriginalFilename();
        file.transferTo(new File(path));
    }
}
