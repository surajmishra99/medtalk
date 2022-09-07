package com.medtalk.org.services.impl;



import com.medtalk.org.entity.Comment;
import com.medtalk.org.entity.Post;
import com.medtalk.org.entity.User;
import com.medtalk.org.exceptions.ResourceNotFoundException;
import com.medtalk.org.payloads.CommentDto;
import com.medtalk.org.payloads.PostDto;
import com.medtalk.org.repository.CommentRepo;
import com.medtalk.org.repository.PostRepo;
import com.medtalk.org.repository.UserRepo;
import com.medtalk.org.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PostRepo postRepo;

    //for creating a comment
    @Override
        public CommentDto createComment(CommentDto commentDto, Integer userId, Integer postId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "UserId", userId));
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", "PostId", postId));
        Comment comment = this.modelMapper.map(commentDto, Comment.class);
        comment.setCommentContent(comment.getCommentContent());
        comment.setUser(user);
        comment.setPost(post);
        Comment newComment = this.commentRepo.save(comment);
        return this.modelMapper.map(newComment, CommentDto.class);

    }

    //for getting comment by id

    @Override
    public CommentDto getCommentById(Integer commentId) {
        Comment comment = this.commentRepo.findById(commentId).orElseThrow(()->new ResourceNotFoundException("comment","comment id", commentId));

        return this.modelMapper.map(comment,CommentDto.class);
    }



    @Override
    public List<CommentDto> getAllComment() {
        return null;
    }

    @Override
    public void deleteComment(Integer commentId) {

    }

    @Override
    public List<CommentDto> getCommentByUser(Integer userId) {
        return null;
    }

    @Override
    public List<CommentDto> getCommentByPost(Integer postId) {
        return null;
    }


}