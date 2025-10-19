package com.mbalem.demo_spring_rev_jpa.controller;


import com.mbalem.demo_spring_rev_jpa.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

}
