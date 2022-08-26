package com.medtalk.org.services;

import com.medtalk.org.payloads.PostDto;


import java.util.List;

public interface PostService {

    PostDto createPost(PostDto post);
    PostDto updatePost(PostDto post,Integer postId);
    PostDto getPostById(Integer postId);
    List<PostDto> getAllPosts();
    void deletePost(Integer postId);
}
