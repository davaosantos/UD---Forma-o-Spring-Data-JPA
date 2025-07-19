package com.mbalem.demo_spring_rev_jpa.controller;

import com.mbalem.demo_spring_rev_jpa.dao.AutorDao;
import com.mbalem.demo_spring_rev_jpa.domain.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("autores")
public class AutorController {

    @Autowired
    private AutorDao autorDao;

    @PostMapping
    public Autor salvar(@RequestBody Autor autor){
        autorDao.save(autor); // Hibernate salva e atribui o ID do banco ao objeto autor
        return autor;
    }

    @PutMapping
    public Autor atualizar(@RequestBody Autor autor){
        autorDao.update(autor);
        return autor;
    }

    // /autores/10
    @DeleteMapping("{id}")
    public String remover(@PathVariable Long id){
        autorDao.delete(id);
        return "Autor id = " + id + " foi excluido com sucesso";
    }

    @GetMapping("{id}")
    public Autor getById(@PathVariable Long id){
        return autorDao.findById(id);
    }

}
