package com.mbalem.demo_spring_rev_jpa.controller;


import com.mbalem.demo_spring_rev_jpa.domain.Post;
import com.mbalem.demo_spring_rev_jpa.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public Post save(@RequestBody Post post){
        return this.postService.save(post);
    }

    @GetMapping("categoria/{categoria}/autor/{autorId}")
    public List<Post> getByCategoriaAndAutor(@PathVariable("categoria") String categoria, Long autorId){
        return this.postService.findAllByCategoriaAndAutorId(categoria, autorId);
    }

}
