package com.example.waaonlineminimarketbackend.controller;

import java.io.IOException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/static")
public class StaticResourceContrller {

    @GetMapping(value="/images/{imgUrl}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable String imgUrl) throws IOException {

        if(imgUrl == null || imgUrl.equals("null")) {
            return ResponseEntity.badRequest().body(null);
        }
        var imgFile = new ClassPathResource("static/"+imgUrl);
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }
}