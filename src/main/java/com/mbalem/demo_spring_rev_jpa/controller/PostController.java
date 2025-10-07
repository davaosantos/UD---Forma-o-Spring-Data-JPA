package com.mbalem.demo_spring_rev_jpa.controller;


import com.mbalem.demo_spring_rev_jpa.domain.Post;
import com.mbalem.demo_spring_rev_jpa.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public Post save(@RequestBody Post post){
        return this.postService.save(post);
    }

}
