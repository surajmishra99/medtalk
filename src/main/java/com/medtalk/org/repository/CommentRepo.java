package com.medtalk.org.repository;

import com.medtalk.org.entity.Comment;
import com.medtalk.org.entity.Post;
import com.medtalk.org.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment,Integer> {

    List<Comment> findByUser(User user);
    List<Comment> findByPost(Post post);
}
