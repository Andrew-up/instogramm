package com.example.instogramm.facade;

import com.example.instogramm.dto.PostDTO;
import org.springframework.stereotype.Component;
import com.example.instogramm.entity.Post;

@Component
public class PostFacade {

    public PostDTO postToPostDTO(Post post){
        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setUsername(post.getUser().getUsername());
        postDTO.setCaption(post.getCaption());
        postDTO.setTitle(post.getTitle());
        postDTO.setLikes(post.getLikes());
        postDTO.setLikedUser(post.getLikedUsers());
        postDTO.setLocation(post.getLocation());

        return postDTO;
    }
}
