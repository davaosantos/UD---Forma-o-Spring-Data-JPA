package com.mbalem.demo_spring_rev_jpa.controller;

import com.mbalem.demo_spring_rev_jpa.domain.InfoAutor;
import com.mbalem.demo_spring_rev_jpa.service.InfoAutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("info")
public class InfoAutorController {

    @Autowired
    private InfoAutorService infoAutorService;

    @GetMapping("{id}")
    private InfoAutor getInfoAutorById(@PathVariable("id") Long idAutor){
        return infoAutorService.findById(idAutor);
    }

    @GetMapping("cargo/{cargo}")
    private List<InfoAutor> getContainsCargo(@PathVariable("cargo") String cargo){
        return infoAutorService.findAllContainsCargo(cargo);
    }

    @GetMapping("cargo/{cargo}/empresa/{empresa}")
    private List<InfoAutor> getContainsCargoAndEmpresa(@PathVariable("cargo") String cargo,
                                                       @PathVariable("empresa") String empresa){
        return infoAutorService.findAllContainsCargoEmpresa(cargo, empresa);
    }

}
