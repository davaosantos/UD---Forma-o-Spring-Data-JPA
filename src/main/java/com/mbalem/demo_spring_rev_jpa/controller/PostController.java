package com.mbalem.demo_spring_rev_jpa.controller;


import com.mbalem.demo_spring_rev_jpa.domain.Post;
import com.mbalem.demo_spring_rev_jpa.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

    @GetMapping("all")
    public Page<Post> getAllPagination(@PageableDefault(page = 0,
            size = 10,
            value = 10,
            sort = "id",
            direction = Sort.Direction.DESC
    )  Pageable pageable){
        return this.postService.findAllPagination(pageable);
    }


    @GetMapping("ano/{ano}")
    public Page<Post> getAllPaginationRequestParam(@RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "5") int size,
                                                   @RequestParam(defaultValue = "dataPublicacao") String sort,
                                                   @RequestParam(defaultValue = "desc") String dir,
                                                   @RequestParam(defaultValue = "ano") int ano
    ){
        return this.postService.findAllByAno(ano, page, size, sort, dir);
    }
}
