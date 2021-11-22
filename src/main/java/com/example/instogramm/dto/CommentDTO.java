package com.example.instogramm.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CommentDTO {

    private Long id;
    @NotEmpty
    private String message;

    @NotEmpty
    private String username;

}
