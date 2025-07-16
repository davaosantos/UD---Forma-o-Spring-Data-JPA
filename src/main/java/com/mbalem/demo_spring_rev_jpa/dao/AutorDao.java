package com.mbalem.demo_spring_rev_jpa.dao;


import com.mbalem.demo_spring_rev_jpa.domain.Autor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AutorDao {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    public void save(Autor autor){
        this.manager.persist(autor);
    }

}
