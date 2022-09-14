package com.medtalk.org.repository;

import com.medtalk.org.entity.Category;
import com.medtalk.org.entity.Post;
import com.medtalk.org.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostRepo extends JpaRepository<Post,Integer> {

    List<Post> findByUser(User user);

    List<Post> findByCategory(Category category);

    List<Post> findByPostTitleContaining(String postTitle);

}


//    @Query("select p from Post p where p.postTitle like :key")
//    List<Post> searchByTitle(@Param("key") String postTitle);