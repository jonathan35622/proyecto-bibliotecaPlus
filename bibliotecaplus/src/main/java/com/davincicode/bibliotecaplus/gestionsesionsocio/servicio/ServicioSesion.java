package com.davincicode.bibliotecaplus.gestionsesionsocio.servicio;

import com.davincicode.bibliotecaplus.gestionsesionsocio.repositorio.BDSesionSocio;

public class ServicioSesion {
    private BDSesionSocio bdSesionSocio;

    public ServicioSesion(){
        this.bdSesionSocio = new BDSesionSocio();
    }

    public void registrarSocio(String nombre, String apellido, String correo, String telefono,String nombreUsuarioRegistro, String contraseniaUsuarioRegistro ){

        this.bdSesionSocio.aniadirRegistroSocio(nombre, apellido, correo, telefono, nombreUsuarioRegistro, contraseniaUsuarioRegistro);
    }

    public boolean permitirLogin(String nombreUsuarioLogin , String contraseniaLogin){
        return  bdSesionSocio.permitirLoginSocio(nombreUsuarioLogin,contraseniaLogin );

    }

}
