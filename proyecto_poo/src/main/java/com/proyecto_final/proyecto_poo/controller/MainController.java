package com.proyecto_final.proyecto_poo.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyecto_final.proyecto_poo.dto.Login;
import com.proyecto_final.proyecto_poo.entitys.Usuario;
import com.proyecto_final.proyecto_poo.repository.UsuarioRepository;

@Controller
public class MainController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/index")
    public String verVista(Model model) {
        model.addAttribute("login", new Login());
        return "index";
    }

    @PostMapping("/login")
    public String postMethodName(@ModelAttribute("login") Login login) {
        System.out.println(login);
        
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(login.getEmail());

        if(usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            String contrasenia = usuario.getContrasenia();

            if(contrasenia.equals(login.getContrasenia())) {
                return "redirect:/principalcliente";
            }
        }

        return "redirect:/index";
    }

    // register

    @GetMapping("/registrar")
    public String mostrarVistaRegistrarUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registrar";
    }

    @PostMapping("/guardar")
    public String registrarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        try {
            usuarioRepository.save(usuario);
        } catch(Exception e) {
            return "redirect:/registrar";
        }
        
        return "redirect:/index";
    }
    
    @Controller
    public class PrincipalControllerClientes {
        @GetMapping("/principalcliente")
        public String mostrarPrincipal() {
            return "PrincipalClientes";
        }
    }
    @Controller
    public class PrincipalControllerUsuario {
        @GetMapping("/principalUsuarios")
        public String mostrarPrincipal() {
            return "PrincipalUsuario";
        }
    }
    
    @Controller
    public class parqueolivo {
        @GetMapping("/parque-olivo")
        public String mostrarPrincipal() {
            return "parqueolivargeneral";
        }
    }
    @Controller
    public class museolarco {
        @GetMapping("/museo-larco")
        public String mostrarPrincipal() {
            return "museo_larco";
        }
    }

    @Controller
    public class noryauyos {
        @GetMapping("/nor-yauyos-cochas")
        public String mostrarPrincipal() {
            return "noryauyos";
        }
    }
    @Controller
    public class puntanegra {
        @GetMapping("/punta-negra")
        public String mostrarPrincipal() {
            return "punta_negra";
        }
    }
}
