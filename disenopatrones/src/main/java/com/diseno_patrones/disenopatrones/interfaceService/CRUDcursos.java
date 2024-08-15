package com.diseno_patrones.disenopatrones.interfaceService;

import java.util.List;
import java.util.Optional;


import com.diseno_patrones.disenopatrones.Entity.cursos;

public interface CRUDcursos {
    public List<cursos> listar();
    public Optional<cursos> listarId(int id);
    public int save(cursos c);
    public void delete(int id);
    
}
