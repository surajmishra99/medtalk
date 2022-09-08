package com.medtalk.org.controllers;

import com.medtalk.org.entity.Comment;
import com.medtalk.org.payloads.ApiResponse;
import com.medtalk.org.payloads.CommentDto;
import com.medtalk.org.payloads.PostDto;
import com.medtalk.org.services.CommentService;
import com.medtalk.org.services.PostService;
import com.medtalk.org.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    // for get all comments


    //delete comment
    @DeleteMapping("/comment/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable("commentId") Integer cId) {
        this.commentService.deleteComment(cId);
        return new ResponseEntity(new ApiResponse("Comment Deleted Successfully", true), HttpStatus.OK);
    }


    //for getting comments by user
    @GetMapping("/user/{userId}/comment")

    public ResponseEntity<List<CommentDto>> getCommentByUser(
            @PathVariable Integer userId
    ) {
        List<CommentDto> comments = this.commentService.getCommentByUser(userId);
        return new ResponseEntity<List<CommentDto>>(comments, HttpStatus.OK);
    }

    //for getting comments by post
    @GetMapping("/post/{postId}/comment")

    public ResponseEntity<List<CommentDto>> getCommentByPost(
            @PathVariable Integer postId
    ) {
        List<CommentDto> comments = this.commentService.getCommentByPost(postId);
        return new ResponseEntity<List<CommentDto>>(comments, HttpStatus.OK);
    }



}
