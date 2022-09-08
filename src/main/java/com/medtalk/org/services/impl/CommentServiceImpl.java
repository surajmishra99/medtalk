package com.medtalk.org.services.impl;



import com.medtalk.org.entity.Category;
import com.medtalk.org.entity.Comment;
import com.medtalk.org.entity.Post;
import com.medtalk.org.entity.User;
import com.medtalk.org.exceptions.ResourceNotFoundException;
import com.medtalk.org.payloads.CategoryDto;
import com.medtalk.org.payloads.CommentDto;
import com.medtalk.org.payloads.PostDto;
import com.medtalk.org.payloads.UserDto;
import com.medtalk.org.repository.CommentRepo;
import com.medtalk.org.repository.PostRepo;
import com.medtalk.org.repository.UserRepo;
import com.medtalk.org.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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


    //for getting all comments
    @Override
    public List<CommentDto> getAllComments() {

        List<Comment> getAllComments = this.commentRepo.findAll();
        List<CommentDto> commentDtos = getAllComments.stream().map((comments) -> this.modelMapper.map(comments, CommentDto.class)).collect(Collectors.toList());
        return commentDtos;
    }

    //for deleting comment
    @Override
    public void deleteComment(Integer commentId) {
        Comment comment= this.commentRepo.findById(commentId)
                .orElseThrow(()-> new ResourceNotFoundException("Comment","comment id ",commentId));
        this.commentRepo.delete(comment);

    }


    //for getting comments by user
    @Override
    public List<CommentDto> getCommentByUser(Integer userId) {
        User user= this.userRepo.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User","user id",userId));
        List<Comment> comments = this.commentRepo.findByUser(user);

        List<CommentDto>CommentDtos =comments.stream().map((comment) -> this.modelMapper.map(comment,CommentDto.class)).collect(Collectors.toList());

        return CommentDtos;

    }



    //for getting comments by post
    @Override
    public List<CommentDto> getCommentByPost(Integer postId) {
        Post posts= this.postRepo.findById(postId)
                .orElseThrow(()->new ResourceNotFoundException("Post","post id",postId));
        List<Comment> comments = this.commentRepo.findByPost(posts);

        List<CommentDto>CommentDtos =comments.stream().map((comment) -> this.modelMapper.map(comment,CommentDto.class)).collect(Collectors.toList());
        return CommentDtos;
    }


}