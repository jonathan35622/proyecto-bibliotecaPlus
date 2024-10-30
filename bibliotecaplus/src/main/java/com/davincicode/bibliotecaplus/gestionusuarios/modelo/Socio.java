package com.davincicode.bibliotecaplus.gestionusuarios.modelo;


import com.davincicode.bibliotecaplus.comunusuarios.modelo.Usuario;

public class Socio extends Usuario {
 private  Long idSocio;
 private String telefono;
 private String nombreUsuarioLogin;
 private String contraseniaLogin;

    public Socio() {
    }

    public Socio( Long id, String nombreUsuarioLogin, String contraseniaLogin) {
        this.idSocio  = id;
        this.nombreUsuarioLogin = nombreUsuarioLogin;
        this.contraseniaLogin = contraseniaLogin;
    }



    public Socio(String nombre, String apellido, String nombreUsuarioLogin, String contraseniaLogin) {

    }

    public Socio(String rol, String nombre, String apellido, String correo, String telefono, String nombreUsuarioRegistro, String contraseniaUsuarioRegistro) {
        super(rol, nombre, apellido, correo);
        this.telefono = telefono;
        this.nombreUsuarioLogin = nombreUsuarioRegistro;
        this.contraseniaLogin = contraseniaUsuarioRegistro;

    }

    public Long getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Long idSocio) {
        this.idSocio = idSocio;
    }

    public String getNombreUsuarioLogin() {
        return nombreUsuarioLogin;
    }

    public void setNombreUsuarioLogin(String nombreUsuarioLogin) {
        this.nombreUsuarioLogin = nombreUsuarioLogin;
    }

    public String getContraseniaLogin() {
        return contraseniaLogin;
    }

    public void setContraseniaLogin(String contraseniaLogin) {
        this.contraseniaLogin = contraseniaLogin;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
