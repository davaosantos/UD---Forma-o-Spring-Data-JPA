package com.mbalem.demo_spring_rev_jpa.service;

import com.mbalem.demo_spring_rev_jpa.domain.Categoria;
import com.mbalem.demo_spring_rev_jpa.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional
    public List<Categoria> save (List<Categoria> categoriaList){
        return this.categoriaRepository.saveAll(categoriaList);
    }

    @Transactional(readOnly = true)
    public Categoria findByTitulo(String titulo){
        return this.categoriaRepository.findByTitulo(titulo).orElseGet(Categoria::new);
    }

    @Transactional(readOnly = true)
    public List<Categoria> findByInicioTitulo(String titulo){
        return this.categoriaRepository.findByTituloStartsWith(titulo);
    }

    @Transactional(readOnly = true)
    public List<Categoria> findByTitulos(List<String> titulos){
        return this.categoriaRepository.findByTituloIn(titulos);
    }

    @Transactional(readOnly = true)
    public List<Categoria> findAllOrderByTituloAsc(){
        return this.categoriaRepository.findByOrderByTituloAsc();
    }

}
