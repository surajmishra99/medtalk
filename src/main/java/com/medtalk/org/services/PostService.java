package com.medtalk.org.services;

import com.medtalk.org.entity.Post;
import com.medtalk.org.payloads.PostDto;


import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
    PostDto updatePost(PostDto postDto,Integer postId);
    PostDto getPostById(Integer postId);
    List<PostDto> getAllPost();
    void deletePost(Integer postId);

//    get all post by category
    List<Post>getPostsByCategory(Integer categoryId);

    //get all post by user
    List<Post> getPostByUser(Integer userId);

    //search posts
    List<Post> searchPosts (String keyword);

}
