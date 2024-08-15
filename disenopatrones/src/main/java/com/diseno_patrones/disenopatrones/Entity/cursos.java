package com.diseno_patrones.disenopatrones.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity
@Table(name = "cursos")

public class cursos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(unique = true)      
    private String nombre;

    private Integer codcurso;

    private String duracion;

    private int ciclo;

    public cursos(int id, String nombre, Integer codcurso, String duracion, int ciclo) {
        this.id = id;
        this.nombre = nombre;
        this.codcurso = codcurso;
        this.duracion = duracion;
        this.ciclo = ciclo;
    }

    public cursos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCodcurso() {
        return codcurso;
    }

    public void setCodcurso(Integer codcurso) {
        this.codcurso = codcurso;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }
    
}
