package com.proyecto_final.proyecto_poo.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "destino")
public class Destino {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Integer numeroPaquetes;
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "id_carrito")
    private Carrito carrito;

    public Destino() {
    }

    public Destino(Integer id, String nombre, Integer numeroPaquetes, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.numeroPaquetes = numeroPaquetes;
        this.precio = precio;
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
    public Integer getNumeroPaquetes() {
        return numeroPaquetes;
    }
    public void setNumeroPaquetes(Integer numeroPaquetes) {
        this.numeroPaquetes = numeroPaquetes;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }



}
