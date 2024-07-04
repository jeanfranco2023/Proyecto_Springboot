package com.proyecto_final.proyecto_poo.dto;

import java.util.List;
import com.proyecto_final.proyecto_poo.entitys.Destino;

public class CarritoDTO {
    private Integer id;
    private List<Destino> listaDestinos;
    private String usuarioNombre;

    public CarritoDTO() {
    }

    public CarritoDTO(Integer id, List<Destino> listaDestinos, String usuarioNombre) {
        this.id = id;
        this.listaDestinos = listaDestinos;
        this.usuarioNombre = usuarioNombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Destino> getListaDestinos() {
        return listaDestinos;
    }

    public void setListaDestinos(List<Destino> listaDestinos) {
        this.listaDestinos = listaDestinos;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }
}
