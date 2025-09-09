package com.mbalem.demo_spring_rev_jpa.service;

import com.mbalem.demo_spring_rev_jpa.domain.InfoAutor;
import com.mbalem.demo_spring_rev_jpa.repository.InfoAutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) //Apenas métodos de transação com consulta, para todos os metodos da classe
public class InfoAutorService {

    @Autowired
    private InfoAutorRepository infoAutorRepository;

    public InfoAutor findById(Long infoAutorId) {
        InfoAutor infoAutor = new InfoAutor();
        infoAutor.setIdInfo(infoAutorId);
        return this.infoAutorRepository.findOne(Example.of(infoAutor)).orElseGet(InfoAutor::new);
    }

    //Busca pelo termo cargo em qualquer parte do nome do cargo
    public List<InfoAutor> findAllContainsCargo(String cargo) {
        InfoAutor infoAutor = new InfoAutor();
        infoAutor.setCargo(cargo);
        ExampleMatcher cargoMatcher = ExampleMatcher.matching()
                .withMatcher("cargo", ExampleMatcher.GenericPropertyMatchers.contains());
        return this.infoAutorRepository.findAll(Example.of(infoAutor, cargoMatcher));
    }

    public List<InfoAutor> findAllContainsCargoEmpresa(String cargo, String empresa) {
        InfoAutor infoAutor = new InfoAutor();
        infoAutor.setCargo(cargo);
        infoAutor.setBio(empresa);
        ExampleMatcher cargoMatcher = ExampleMatcher.matchingAll()
                .withMatcher("cargo", ExampleMatcher.GenericPropertyMatchers.startsWith())
                .withMatcher("bio", ExampleMatcher.GenericPropertyMatchers.contains());

        return this.infoAutorRepository.findAll(Example.of(infoAutor, cargoMatcher));
    }

    public InfoAutor findFromBio(String bio) {
        InfoAutor infoAutor = new InfoAutor();
        infoAutor.setBio(bio);

        ExampleMatcher bioMatcher = ExampleMatcher.matching()
                .withMatcher("bio", ExampleMatcher.GenericPropertyMatchers.contains());

        return this.infoAutorRepository.findBy(
                Example.of(infoAutor, bioMatcher),
                query -> query.sortBy(Sort.by("cargo").descending()).first()
        ).orElseGet(InfoAutor::new);
    }

}
