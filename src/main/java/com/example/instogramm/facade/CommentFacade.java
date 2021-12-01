package com.example.instogramm.facade;

import com.example.instogramm.dto.CommentDTO;
import com.example.instogramm.entity.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentFacade {

    public CommentDTO commentToCommentDTO(Comment comment){
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setUsername(comment.getUsername());
        commentDTO.setMessage(comment.getMessage());
        return commentDTO;
    }
}
