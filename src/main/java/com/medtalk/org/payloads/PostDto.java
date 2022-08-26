package com.medtalk.org.payloads;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

public class PostDto {

    private Integer postId;

    @NotEmpty
    @Size(min = 4,message = "Post Title must contains min of 4 characters !!")
    private String postTitle;

    @NotEmpty
    @Size(min = 10,max = 200,message = "Post Content Min contains 10 and Max contains only 200 characters !!")
    private String postContent;

    private String image;

    private Date addedDate;
}
