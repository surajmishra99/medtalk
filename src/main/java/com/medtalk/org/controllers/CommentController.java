package com.medtalk.org.controllers;

import com.medtalk.org.payloads.CommentDto;
import com.medtalk.org.payloads.PostDto;
import com.medtalk.org.services.CommentService;
import com.medtalk.org.services.PostService;
import com.medtalk.org.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class CommentController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;


    //  Create Comment
    @PostMapping("/user/{userId}/post/{postId}/comment")
    public ResponseEntity<CommentDto> createComment(
            @RequestBody CommentDto commentDto,
            @PathVariable Integer userId,
            @PathVariable Integer postId
    ) {
        CommentDto createComment = this.commentService.createComment(commentDto, userId, postId);
        return new ResponseEntity<>(createComment, HttpStatus.CREATED);

    }

    //get comment by id
    @GetMapping("/comment/{commentId}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable Integer commentId) {
        CommentDto commentDto = this.commentService.getCommentById(commentId);
        return new ResponseEntity<CommentDto>(commentDto, HttpStatus.OK);
    }

}
