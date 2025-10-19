package com.mbalem.demo_spring_rev_jpa.repository;

import com.mbalem.demo_spring_rev_jpa.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByCategoriasTituloAndAutorId(String categoria, Long autorId);

    @Query("select p from Post p where YEAR(p.dataPublicacao) = :ano")
    Page<Post> findByAno(int ano, PageRequest pageRequest);
}
