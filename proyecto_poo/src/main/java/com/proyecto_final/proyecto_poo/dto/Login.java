package com.proyecto_final.proyecto_poo.dto;

public class Login {
    private String email;
    private String contrasenia;
    
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
    public Login(String email, String contrasenia) {
        this.email = email;
        this.contrasenia = contrasenia;
    }
    public Login() {
    }
    @Override
    public String toString() {
        return "Login [email=" + email + ", contrasenia=" + contrasenia + "]";
    }

    
}
