package com.learn.springstarter.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.springstarter.models.Post;
import com.learn.springstarter.repositories.PostRepository;

@Service
public class PostService   {
    
    @Autowired
    private PostRepository ps;

    public Optional<Post>getByID(Long ID){
        return ps.findById(ID);
    }
    
    public List<Post>getAll(){
        return ps.findAll();
    }
    
    public void delete(Post post){
        ps.delete(post);
    }

    public Post save(Post post){
        if(post.getId()==null){
            post.setCreatedAt(LocalDateTime.now());
        }
        return ps.save(post);
    }
}
