package com.learn.springstarter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.springstarter.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    
}
