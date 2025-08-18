package com.mbalem.demo_spring_rev_jpa.controller;

import com.mbalem.demo_spring_rev_jpa.service.AutorService;
import com.mbalem.demo_spring_rev_jpa.domain.Autor;
import com.mbalem.demo_spring_rev_jpa.domain.InfoAutor;
import com.mbalem.demo_spring_rev_jpa.dto.AutorInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping
    public Autor salvar(@RequestBody Autor autor){
        autorService.save(autor); // Hibernate salva e atribui o ID do banco ao objeto autor
        return autor;
    }

    @PutMapping
    public Autor atualizar(@RequestBody Autor autor){
        autorService.update(autor);
        return autor;
    }

    // /autores/10
    @DeleteMapping("{id}")
    public String remover(@PathVariable Long id){
        autorService.delete(id);
        return "Autor id = " + id + " foi excluido com sucesso";
    }

    @GetMapping("{id}")
    public Autor getById(@PathVariable Long id){
        return autorService.findById(id);
    }

    @GetMapping
    public List<Autor> getAll(){
        return autorService.findAll();
    }

    @GetMapping("nomeOrSobrenome")
    public List<Autor> getAllByNomeOrSobrenome(@RequestParam("termo") String termo){
        return autorService.findAllByNomeOrSobrenome(termo);
    }

    @GetMapping("total")
    public Long getTotalAutores(){
        return autorService.getTotalElements();
    }

    @PutMapping("{id}/info")
    public Autor salvarInfoAutor(@PathVariable(value = "id") Long idAutor, @RequestBody InfoAutor infoAutor){
        return autorService.saveInfoAutor(infoAutor, idAutor);
    }

    @GetMapping("info")
    public List<Autor> getAutoresByCargo(@RequestParam(value = "cargo") String cargo){
            return autorService.findByCargo(cargo);
    }

    @GetMapping("autor-info") // Consulta com retorno projetado apenas de alguns parametros
    public AutorInfoDAO findAutorInfoById(@RequestParam(value = "id") Long idAutor){
        return autorService.findAutorInfoById(idAutor);
    }

}
