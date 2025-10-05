package com.mbalem.demo_spring_rev_jpa.service;


import com.mbalem.demo_spring_rev_jpa.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


}
