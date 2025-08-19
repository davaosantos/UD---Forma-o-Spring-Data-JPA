package com.mbalem.demo_spring_rev_jpa.dto;

import org.springframework.beans.factory.annotation.Value;

public interface AutorInfoDAO {

    @Value("#{target.nome + ' ' + target.sobrenome}")
    String getNomeCompleto();

    String getCargo();

    String getBio();

}
