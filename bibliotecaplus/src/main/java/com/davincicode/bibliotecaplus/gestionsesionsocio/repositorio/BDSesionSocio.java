package com.davincicode.bibliotecaplus.gestionsesionsocio.repositorio;

import com.davincicode.bibliotecaplus.gestionusuarios.modelo.Socio;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BDSesionSocio implements SesionSocioRepository{

    private List<Socio> registroSocios;
    private final static String ROL_SOCIO = "socio";

    /*constructor clase BDSesionSocio / inicializa una lista vacía de socios y luego con el método inicializarListaSocio registra uno */
    public BDSesionSocio(){
        this.registroSocios = new ArrayList<>();
        inicializarListaSocio();
    }

    private void inicializarListaSocio(){
        registroSocios.add(new Socio(1L, "login", "123"));
    }

    @Override
    public void aniadirRegistroSocio(String nombre, String apellido, String correo, String telefono,String nombreUsuarioRegistro, String contraseniaUsuarioRegistro) {
        Socio nuevoSocio = new Socio(ROL_SOCIO, nombre,apellido, correo, telefono, nombreUsuarioRegistro, contraseniaUsuarioRegistro);
        registroSocios.add(nuevoSocio);
        JOptionPane.showMessageDialog(null, "El socio fue registrado con éxito!");
    }

    @Override
    public boolean permitirLoginSocio(String nombreUsuarioLoginIngresado , String contraseniaLoginIngresada) {
        if(!nombreUsuarioLoginIngresado.trim().isEmpty() && !contraseniaLoginIngresada.trim().isEmpty() ){
            for(int i = 0; i < registroSocios.size(); i++){
                //valido que nombre usuario y contraseña coincidan con algún elemento de la lista
                if(nombreUsuarioLoginIngresado.equalsIgnoreCase(registroSocios.get(i).getNombreUsuarioLogin())
                        && contraseniaLoginIngresada.equalsIgnoreCase(registroSocios.get(i).getContraseniaLogin())) {
                    return true;
                }
            }
        }
        return false;/*por defecto no va a permitir el login*/
    }
}
