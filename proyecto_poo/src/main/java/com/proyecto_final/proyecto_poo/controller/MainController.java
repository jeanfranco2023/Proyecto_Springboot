package com.proyecto_final.proyecto_poo.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyecto_final.proyecto_poo.dto.CarritoDTO;
import com.proyecto_final.proyecto_poo.dto.Login;
import com.proyecto_final.proyecto_poo.entitys.Carrito;
import com.proyecto_final.proyecto_poo.entitys.Destino;
import com.proyecto_final.proyecto_poo.entitys.Usuario;
import com.proyecto_final.proyecto_poo.repository.CarritoRepository;
import com.proyecto_final.proyecto_poo.repository.DestinoRepository;
import com.proyecto_final.proyecto_poo.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class MainController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private DestinoRepository destinoRepository;

    private Usuario usuarioIniciado;

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
                usuarioIniciado = usuario;
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
            Carrito carrito = new Carrito();
            carritoRepository.save(carrito);
            usuario.setCarrito(carrito);

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
        public String mostrarPrincipal(Model model) {
            model.addAttribute("nombreUsuario", usuarioIniciado.getNombre());
            return "parqueolivargeneral";
        }

        @GetMapping("/parque_olivo")
        public String getMethodName(@RequestParam(name = "nombreDestino") String nombreDestino, @RequestParam(name = "precio") Double precio) {
            Destino destino = new Destino();
            destino.setNombre(nombreDestino);
            destino.setPrecio(precio);
            destino.setNumeroPaquetes(1);
            destino.setCarrito(usuarioIniciado.getCarrito());
            destinoRepository.save(destino);

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

    @Controller
    public class caral {
        @GetMapping("/caral")
        public String mostrarPrincipal() {
            return "caral";
        }
    }
    @Controller
    public class huacapucllana {
        @GetMapping("/huaca-pucllana")
        public String mostrarPrincipal() {
            return "huaca_pucllana";
        }
    }

    @Controller
    public class islapalomino {
        @GetMapping("/islas-palomino")
        public String mostrarPrincipal() {
            return "islas_palomino";
        }
    }
    @Controller
    public class maleconmiraflores {
        @GetMapping("/malecon-miraflores")
        public String mostrarPrincipal() {
            return "maleconmiraflores";
        }
    }


    @GetMapping("/verCarrito")
    public String verCarrito(Model model) {
        Carrito carrito = usuarioIniciado.getCarrito();
        CarritoDTO carritoDTO = new CarritoDTO(carrito.getId(), carrito.getListaDestinos(), carrito.getUsuario().getNombre());

        model.addAttribute("carrito", carritoDTO);

        return "carrito";
    }

    
}
