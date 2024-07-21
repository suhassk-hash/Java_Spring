package com.learn.springstarter.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.learn.springstarter.models.Post;
import com.learn.springstarter.service.PostService;

@Controller
public class HomeController {
    
    @Autowired
    private PostService ps;
    
    @GetMapping("/")
    public String home(Model model){
        List<Post> posts=ps.getAll();
        model.addAttribute("posts",posts);
        return "About";
    }

}
