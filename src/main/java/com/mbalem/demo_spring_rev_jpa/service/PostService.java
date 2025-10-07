package com.mbalem.demo_spring_rev_jpa.service;


import com.mbalem.demo_spring_rev_jpa.domain.Autor;
import com.mbalem.demo_spring_rev_jpa.domain.Categoria;
import com.mbalem.demo_spring_rev_jpa.domain.Post;
import com.mbalem.demo_spring_rev_jpa.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AutorService autorService;

    @Autowired
    private CategoriaService categoriaService;

    @Transactional
    public Post save(Post post){

        Autor autor = this.autorService.findById(post.getAutor().getId());
        post.setAutor(autor);

        // busco as categorias conforme o titulo de String, para ter os objetos categorias em estado persistente
        List<String> titulos = post.getCategorias().stream().map(
                Categoria::getTitulo
        ).toList();

        List<Categoria> categorias = this.categoriaService.findByTitulos(titulos); // Estado persistente

        if (!categorias.isEmpty()){
            post.setCategorias(categorias);
        }

        return this.postRepository.save(post);
    }


}
