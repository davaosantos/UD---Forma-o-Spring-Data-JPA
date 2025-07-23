package com.mbalem.demo_spring_rev_jpa.dao;


import com.mbalem.demo_spring_rev_jpa.domain.Autor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AutorDao {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    public void save(Autor autor){
        this.manager.persist(autor);
    }

    @Transactional(readOnly = false)
    public void update(Autor autor){
        this.manager.merge(autor);
    }

    @Transactional(readOnly = false)
    public void delete(Long id){

        this.manager.remove(this.manager.getReference(Autor.class, id));
    }

    @Transactional(readOnly = true)
    public Autor findById(Long id){
        return this.manager.find(Autor.class, id);
    }

    @Transactional(readOnly = true)
    public List<Autor> findAll(){
        String query = "select a from Autor a";
        return this.manager.createQuery(query,Autor.class).getResultList();
    }

    @Transactional(readOnly = true)
    public List<Autor> findAllByNomeOrSobrenome(String termo){
        String query = "select a from Autor a " +
                "where a.nome like :termo OR a.sobrenome like :termo";
        return this.manager.createQuery(query,Autor.class)
                .setParameter("termo", "%" + termo + "%")
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Long getTotalElements(){
        String query = "select count(1) from Autor a ";
        return this.manager.createQuery(query, Long.class)
                .getSingleResult();
    }

}
