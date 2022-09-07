package com.medtalk.org.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {


    @NotEmpty
    @Size(min = 4,message = "Post Title must contains min of 4 characters !!")
    private String postTitle;

    @NotEmpty
    @Size(min = 10,max = 200,message = "Post Content Min contains 10 and Max contains only 200 characters !!")
    private String postContent;

    private String image;

    private Date addedDate;

    private CategoryDto category;

    private UserDto user;

}
