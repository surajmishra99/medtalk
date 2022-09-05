package com.medtalk.org.services.impl;

import com.medtalk.org.entity.Category;
import com.medtalk.org.entity.Post;
import com.medtalk.org.entity.User;
import com.medtalk.org.exceptions.ResourceNotFoundException;
import com.medtalk.org.payloads.PostDto;
import com.medtalk.org.repository.CategoryRepo;
import com.medtalk.org.repository.PostRepo;
import com.medtalk.org.repository.UserRepo;
import com.medtalk.org.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {


    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;


    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
        User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","UserId",userId));
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category","CategoryId",categoryId));
        Post post = this.modelMapper.map(postDto, Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);
        Post newPost = this.postRepo.save(post);
        return this.modelMapper.map(newPost,PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto post, Integer postId) {
        return null;
    }

    @Override
    public PostDto getPostById(Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("post","post id", postId));

        return this.modelMapper.map(post,PostDto.class);
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> allPosts = this.postRepo.findAll();
        List<PostDto> postDtos = allPosts.stream().map((post)->this.modelMapper.map(post,PostDto.class))
                .collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public void deletePost(Integer postId) {
        Post post= this.postRepo.findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("Post"," Id ",postId));
        this.postRepo.delete(post);

    }

    @Override
    public List<PostDto> getPostsByCategory(Integer categoryId) {
        Category cat= this.categoryRepo.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("Category","category id",categoryId));
        List<Post> posts = this.postRepo.findByCategory(cat);

        List<PostDto>PostDtos =posts.stream().map((post) -> this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
        return PostDtos;
    }

    @Override
    public List<PostDto> getPostByUser(Integer userId) {
        User user= this.userRepo.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User","user id",userId));
        List<Post> posts = this.postRepo.findByUser(user);

        List<PostDto>PostDtos =posts.stream().map((post) -> this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());

        return PostDtos;
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        return null;
    }


}