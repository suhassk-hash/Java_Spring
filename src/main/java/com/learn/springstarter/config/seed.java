package com.learn.springstarter.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learn.springstarter.models.Account;
import com.learn.springstarter.models.Post;
import com.learn.springstarter.service.AccountService;
import com.learn.springstarter.service.PostService;

@Component
public class seed implements CommandLineRunner {
    
    @Autowired
    private PostService ps;
    @Autowired
    private AccountService as;
        
    @Override
    public void run(String... args) throws Exception {

        Account a = new Account();
        Account a1 = new Account();

        a.setEmail("spamsharmask@gmail.com");
        a.setName("Unknown");
        a.setPassword("Suhasskhash");

        a1.setEmail("spamsharmask@gmail.com");
        a1.setName("Unknown");
        a1.setPassword("Suhasskhash");

        as.save(a);
        as.save(a1);

        List<Post> posts=ps.getAll();
        if(posts.size()==0){
            Post post1=new Post();
            post1.setTitle("First Post");
            post1.setContent("This is the first post");
            post1.setAccount(a);
            ps.save(post1);
            
            Post post2=new Post();
            post2.setTitle("Second Post");
            post2.setContent("This is the second post");
            post2.setAccount(a1);
            ps.save(post2);
        }
    }   
}
