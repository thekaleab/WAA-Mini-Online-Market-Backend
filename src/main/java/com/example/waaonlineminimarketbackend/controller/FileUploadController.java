package com.example.waaonlineminimarketbackend.controller;


import com.example.waaonlineminimarketbackend.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/upload")
public class FileUploadController {

    @Autowired
    FileUploadService fileUploadService;

    @PostMapping
    public void uploadFile(@RequestParam ("file")MultipartFile file) throws IOException {
        fileUploadService.uploadFile(file);

    }



}

