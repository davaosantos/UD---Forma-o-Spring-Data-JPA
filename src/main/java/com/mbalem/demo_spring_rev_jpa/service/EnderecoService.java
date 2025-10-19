package com.mbalem.demo_spring_rev_jpa.service;


import com.mbalem.demo_spring_rev_jpa.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

}
