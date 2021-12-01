package com.example.instogramm.controller;

import com.example.instogramm.entity.Image;
import com.example.instogramm.payload.response.MessageResponse;
import com.example.instogramm.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@RestController
@RequestMapping("api/image")
@CrossOrigin
public class ImageController {
    @Autowired
    ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<MessageResponse> uploadImageToProfile(@RequestParam("file")MultipartFile file,
                                                                Principal principal) throws IOException{
        imageService.uploadImageToProfile(file,principal);
        return ResponseEntity.ok(new MessageResponse("Image uploaded successfully"));

    }
    @PostMapping("{postId}/upload")
    public ResponseEntity<MessageResponse> uploadImageToPost(@PathVariable("postId") String postId,
                                                             @RequestParam("file") MultipartFile file,
                                                             Principal principal) throws IOException{
        imageService.uploadImageToPost(file,principal,Long.parseLong(postId));
        return ResponseEntity.ok(new MessageResponse("Image uploaded successfully to post "+ postId));
    }

    @GetMapping("/profileImage")
    public ResponseEntity<Image> getUserProfileImage(Principal principal){
        Image profileImage = imageService.getUserProfileImage(principal);
        return new ResponseEntity<>(profileImage, HttpStatus.OK);
    }

    @GetMapping("{postId}/image")
    public ResponseEntity<Image> getPostImage(@PathVariable String postId){
        Image postImage = imageService.getPostImage(Long.parseLong(postId));
        return  new ResponseEntity<>(postImage,HttpStatus.OK);
    }
}
