package com.diseno_patrones.disenopatrones.dto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diseno_patrones.disenopatrones.Entity.cursos;
import com.diseno_patrones.disenopatrones.interfaceService.CRUDcursos;
import com.diseno_patrones.disenopatrones.repository.CursosRepository;

@Service
public class CursosDTO implements CRUDcursos{

    @Autowired  
    private CursosRepository cursosRepository;
    

    @Override
    public List<cursos> listar() {
        return (List<cursos>)cursosRepository.findAll();
    }

    @Override
    public Optional<cursos> listarId(int id) {
        return null;
    }

    @Override
    public int save(cursos c) {
        int res=0;
        cursos curso=cursosRepository.save(c);
        if(!curso.equals(null)) {
            res=1;
        }
        return res;
    }

    @Override
    public void delete(int id) {
        
      }

   

}
