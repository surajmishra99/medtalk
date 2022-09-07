package com.medtalk.org.payloads;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class CommentDto {


    @NotEmpty
    @Size(max = 100,message = "Comment content not more than 100characters !!")
    private String commentContent;

    private PostDto post;

    private UserDto user;
}
