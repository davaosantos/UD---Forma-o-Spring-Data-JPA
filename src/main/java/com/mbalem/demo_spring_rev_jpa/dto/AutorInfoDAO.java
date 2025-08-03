package com.mbalem.demo_spring_rev_jpa.dto;

public class AutorInfoDAO {
    private String nomeCompleto;

    private String cargo;

    private String bio;

    public AutorInfoDAO(String nome, String sobrenome, String cargo, String bio) {
        this.nomeCompleto = nome + " " + sobrenome;
        this.cargo = cargo;
        this.bio = bio;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
