package com.mbalem.demo_spring_rev_jpa.controller;

import com.mbalem.demo_spring_rev_jpa.dao.AutorDao;
import com.mbalem.demo_spring_rev_jpa.domain.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
