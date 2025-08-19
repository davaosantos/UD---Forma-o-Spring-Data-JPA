package com.mbalem.demo_spring_rev_jpa.service;


import com.mbalem.demo_spring_rev_jpa.domain.Autor;
import com.mbalem.demo_spring_rev_jpa.domain.InfoAutor;
import com.mbalem.demo_spring_rev_jpa.dto.AutorInfoDAO;
import com.mbalem.demo_spring_rev_jpa.repository.AutorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @PersistenceContext // Classe para injeção de um EntityManager
    private EntityManager manager;

//    @Transactional
//    public void save(Autor autor){
//        this.manager.persist(autor);
//    }

    @Transactional
    public void save(Autor autor){
        this.autorRepository.save(autor);
    }

    @Transactional(readOnly = false)
    public void update(Autor autor){
        this.autorRepository.save(autor);
    }

//    @Transactional(readOnly = false)
//    public void delete(Long id){
//        this.manager.remove(this.manager.getReference(Autor.class, id));
//    }

    @Transactional(readOnly = false)
    public void delete(Long id){
        this.autorRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Autor findById(Long id){
//        return this.autorRepository.findById(id).get();
//        return this.autorRepository.findById(id).orElseGet(Autor::new);
//        return this.autorRepository.findById(id).orElse(new Autor());
        return this.autorRepository.findById(id).orElseThrow(() -> new RuntimeException("Nao encontrado o id : " + id));
    }

    @Transactional(readOnly = true)
    public List<Autor> findAll(){
        return this.autorRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Long getTotalElements(){
        return this.autorRepository.count();
    }

    @Transactional(readOnly = true)
    public List<Autor> findAllByNomeOrSobrenome(String termo){

        return this.autorRepository.findByNomeOrSobrenome("%" + termo + "%");
//        String query = "select a from Autor a " +
//                "where a.nome like :termo OR a.sobrenome like :termo";
//        return this.manager.createQuery(query,Autor.class)
//                .setParameter("termo", montaValueParam(termo))
//                .getResultList();
    }

    @Transactional(readOnly = false)
    public Autor saveInfoAutor(InfoAutor infoAutor, Long autorId){
        Autor autor = this.findById(autorId);
        autor.setInfoAutor(infoAutor);
        return autor;
    }

    @Transactional(readOnly = true)
    public List<Autor> findByCargo(String cargo){
        return this.autorRepository.findByCargo("%" + cargo + "%");
    }

    @Transactional(readOnly = true)
    public AutorInfoDAO findAutorInfoById(Long id){
        return this.autorRepository.findAutorInfoById(id);
    }

    private static String montaValueParam(String param) {
        return "%" + param + "%";
    }



}
