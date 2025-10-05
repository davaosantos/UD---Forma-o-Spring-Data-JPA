package com.mbalem.demo_spring_rev_jpa.repository;

import com.mbalem.demo_spring_rev_jpa.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByTitulo(String titulo);

    List<Categoria> findByTituloStartsWith(String titulo);

    List<Categoria> findByTituloIn(List<String> titulos);

    List<Categoria> findByOrderByTituloAsc();

}
