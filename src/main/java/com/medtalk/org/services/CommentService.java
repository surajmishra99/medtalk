package com.medtalk.org.services;

import com.medtalk.org.payloads.CommentDto;


import java.util.List;

public interface CommentService {


    CommentDto createComment(CommentDto commentDto, Integer userId, Integer postId);

    CommentDto getCommentById(Integer commentId);

    List<CommentDto> getAllComment();


    void deleteComment(Integer commentId);


    List<CommentDto> getCommentByUser(Integer userId);

    List<CommentDto>getCommentByPost(Integer postId);
}
