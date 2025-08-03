package com.mbalem.demo_spring_rev_jpa.dao;


import com.mbalem.demo_spring_rev_jpa.domain.Autor;
import com.mbalem.demo_spring_rev_jpa.domain.InfoAutor;
import com.mbalem.demo_spring_rev_jpa.dto.AutorInfoDAO;
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
                .setParameter("termo", montaValueParam(termo))
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Long getTotalElements(){
        String query = "select count(1) from Autor a ";
        return this.manager.createQuery(query, Long.class)
                .getSingleResult();
    }

    @Transactional(readOnly = false)
    public Autor saveInfoAutor(InfoAutor infoAutor, Long autorId){
        Autor autor = this.findById(autorId);
        autor.setInfoAutor(infoAutor);
        return autor;
    }

    @Transactional(readOnly = true)
    public List<Autor> findByCargo(String cargo){
        //Query jpql com tres aspas apenas a partir do java 21
        String query = """ 
                select a from Autor a\s
                where a.infoAutor.cargo like :cargo
                order by a.nome asc
               \s""";

        return this.manager.createQuery(query, Autor.class)
                .setParameter("cargo", montaValueParam(cargo))
                .getResultList();
    }

    @Transactional(readOnly = true)
    public AutorInfoDAO findAutorInfoById(Long id){
        String query = "select new AutorInfoDAO(a.nome, a.sobrenome, a.infoAutor.cargo, a.infoAutor.bio) from Autor a " //Query jpql para java anterior ao 21
                + "where a.id = :id ";

        return this.manager.createQuery(query, AutorInfoDAO.class)
                .setParameter("id", + id)
                .getSingleResult();
    }

    private static String montaValueParam(String param) {
        return "%" + param + "%";
    }



}
