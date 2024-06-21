package com.proyecto_final.proyecto_poo.entitys;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    @Column(unique = true)
    private String email;

    private String contrasenia;

    public Usuario() {

    }

    public Usuario(String nombre, String email, String contrasenia) {
        this.nombre = nombre;
        this.email = email;
        this.contrasenia = contrasenia;
    }

    public Usuario(Integer id, String nombre, String email, String contrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contrasenia = contrasenia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    // get and sett

}
