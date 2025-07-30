package com.mbalem.demo_spring_rev_jpa.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "info_autores")
public class InfoAutor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_info", nullable = false)
    private Long idInfo;

    @Column(name = "cargo", length = 45, nullable = false)
    private String cargo;

    @Column(name = "bio") // default é 255 caracteres, nullable = true por default
    private String bio;

    public void setIdInfo(Long idInfo) {
        this.idInfo = idInfo;
    }

    public Long getIdInfo() {
        return idInfo;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InfoAutor infoAutor = (InfoAutor) o;
        return Objects.equals(idInfo, infoAutor.idInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idInfo);
    }

    @Override
    public String toString() {
        return "InfoAutor{" +
                "idInfo=" + idInfo +
                '}';
    }
}
