package com.example.portfolioapi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
    `idred` INT(11) NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(50) NULL DEFAULT NULL,
    `url` VARCHAR(2000) NULL DEFAULT NULL,
    `fotourl` VARCHAR(200) NULL DEFAULT NULL,
    `persona` INT(11) NULL DEFAULT NULL,
*/



@Entity
@Table(name = "redes")
public class RedesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(unique = true, nullable = false)
    private int idred;
    private String nombre;
    private String url;
    private String fotourl;
    private int persona;

    public RedesModel(int idred, String nombre, String url, String fotourl, int persona) {
        this.idred = idred;
        this.nombre = nombre;
        this.url = url;
        this.fotourl = fotourl;
        this.persona = persona;
    }

    public RedesModel(String nombre, String url, String fotourl, int persona) {
        this.nombre = nombre;
        this.url = url;
        this.fotourl = fotourl;
        this.persona = persona;
    }

    public RedesModel() {
        
    }
    

    public int getIdred() {
        return this.idred;
    }

    public void setIdred(int idred) {
        this.idred = idred;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFotourl() {
        return this.fotourl;
    }

    public void setFotourl(String fotourl) {
        this.fotourl = fotourl;
    }

    public int getPersona() {
        return this.persona;
    }

    public void setPersona(int persona) {
        this.persona = persona;
    }


    @Override
    public String toString() {
        return "{" +
            " idred='" + getIdred() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", url='" + getUrl() + "'" +
            ", fotourl='" + getFotourl() + "'" +
            ", persona='" + getPersona() + "'" +
            "}";
    }


}