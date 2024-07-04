package com.proyecto_final.proyecto_poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto_final.proyecto_poo.entitys.Carrito;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Integer>{
    
}
