package com.davincicode.bibliotecaplus.gestionlibros.servicio;

import com.davincicode.bibliotecaplus.gestionlibros.repositorio.BDLibros;

public class LibroServicio {
    private BDLibros datosLibros;

    public LibroServicio( ){
        this.datosLibros = new BDLibros();
    }

}
