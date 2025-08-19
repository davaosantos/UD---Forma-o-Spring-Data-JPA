package com.mbalem.demo_spring_rev_jpa.repository;

import com.mbalem.demo_spring_rev_jpa.domain.Autor;
import com.mbalem.demo_spring_rev_jpa.dto.AutorInfoDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Query("select a from Autor a where a.infoAutor.cargo like :cargo order by a.nome asc")
    List<Autor> findByCargo(@Param("cargo") String cargo);

    //        String query = "select a from Autor a " +
//                "where a.nome like :termo OR a.sobrenome like :termo";
    @Query("select a from Autor a where a.nome like :termo OR a.sobrenome like :termo")
    List<Autor> findByNomeOrSobrenome(String termo);

    @Query("select a.nome as nome, a.sobrenome as sobrenome, a.infoAutor.cargo as cargo, a.infoAutor.bio as bio from Autor a "
            + "where a.id = :id ")
    AutorInfoDAO findAutorInfoById(Long id);

}
