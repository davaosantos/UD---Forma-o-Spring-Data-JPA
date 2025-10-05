package com.mbalem.demo_spring_rev_jpa.controller;

import com.mbalem.demo_spring_rev_jpa.domain.Categoria;
import com.mbalem.demo_spring_rev_jpa.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public List<Categoria> salvar(@RequestBody List<Categoria> categorias){
        return this.categoriaService.save(categorias);
    }

    @GetMapping("titulo/{titulo}")
    public Categoria getByTitulo(@PathVariable String titulo){
        return this.categoriaService.findByTitulo(titulo);
    }

    @GetMapping("titulo/inicio/{tituloInicio}")
    public List<Categoria> getByInicioTitulo(@PathVariable("tituloInicio") String titulo){
        return this.categoriaService.findByInicioTitulo(titulo);
    }

    @GetMapping("titulos")
    public List<Categoria> getByTitulos(@RequestParam(name = "t") List<String> titulos){
        return this.categoriaService.findByTitulos(titulos);
    }

    @GetMapping
    public List<Categoria> getCategoriasOrderAsc(){
        return this.categoriaService.findAllOrderByTituloAsc();
    }

}
