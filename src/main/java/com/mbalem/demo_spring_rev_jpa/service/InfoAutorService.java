package com.mbalem.demo_spring_rev_jpa.service;

import com.mbalem.demo_spring_rev_jpa.domain.InfoAutor;
import com.mbalem.demo_spring_rev_jpa.repository.InfoAutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true) //Apenas métodos de transação com consulta, para todos os metodos da classe
public class InfoAutorService {

    @Autowired
    private InfoAutorRepository infoAutorRepository;

    public InfoAutor findById(Long infoAutorId){
        InfoAutor infoAutor = new InfoAutor();
        infoAutor.setIdInfo(infoAutorId);
        return this.infoAutorRepository.findOne(Example.of(infoAutor)).orElseGet(InfoAutor::new);
    }
}
