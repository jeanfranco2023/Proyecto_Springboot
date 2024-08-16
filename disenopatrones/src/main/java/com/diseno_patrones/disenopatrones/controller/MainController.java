package com.diseno_patrones.disenopatrones.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.diseno_patrones.disenopatrones.entity.cursos;
import com.diseno_patrones.disenopatrones.interfaceService.CRUDcursos;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MainController {

    @Autowired
    private CRUDcursos crudCursos;

    @GetMapping("/index")
    public String listar(Model model) {
    model.addAttribute("cursos", new cursos());
    List<cursos> cursos = crudCursos.listar();
    model.addAttribute("cursos", cursos);
    return "index";
    
    }
    @PostMapping("/save")
    public String save(@Validated cursos c) {
    crudCursos.save(c);
    return "redirect:/listar";
    }
    
} 

