package com.example.waaonlineminimarketbackend.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileUploadService {
    public void uploadFile(MultipartFile file) throws IOException;
}
