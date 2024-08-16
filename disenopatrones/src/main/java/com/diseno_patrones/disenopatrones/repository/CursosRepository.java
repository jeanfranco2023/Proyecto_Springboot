package com.diseno_patrones.disenopatrones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diseno_patrones.disenopatrones.entity.cursos;

    @Repository
    public interface CursosRepository extends JpaRepository<cursos, Integer> {



}
