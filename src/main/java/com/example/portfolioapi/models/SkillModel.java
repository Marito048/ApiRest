package com.example.portfolioapi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "skill")
public class SkillModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(unique = true, nullable = false)
    private int idskill;
    
    private String titulo;
    
    private int dominio; 
    private int persona;
    
    public SkillModel(){}

    
    public SkillModel(String titulo, int dominio, int persona)
    {        
        this.titulo = titulo;
        this.dominio = dominio;
        this.persona = persona;
    }

    public SkillModel(int idskill, String titulo, int dominio, int persona)
    {
        this.idskill = idskill;
        this.titulo = titulo;
        this.dominio = dominio;
        this.persona = persona;
    }

    public int getIdskill() {
        return idskill;
    }

    public void setIdskill(int idskill) {
        this.idskill = idskill;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDominio() {
        return dominio;
    }

    public void setDominio(int dominio) {
        this.dominio = dominio;
    }

    public int getPersona() {
        return persona;
    }

    public void setPersona(int persona) {
        this.persona = persona;
    }

    
    
    
    @Override
    public String toString() {
        return "SkillModel{" + "idskill=" + idskill + ", titulo=" + titulo + ", dominio=" + dominio + ", persona=" + persona + '}';
    }


}
