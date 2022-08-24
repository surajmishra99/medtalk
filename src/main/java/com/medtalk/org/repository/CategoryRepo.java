package com.medtalk.org.repository;

import com.medtalk.org.entity.Category;
import com.medtalk.org.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
