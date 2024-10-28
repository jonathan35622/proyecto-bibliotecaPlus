package com.davincicode.bibliotecaplus.gestionlibros.servicio;

import com.davincicode.bibliotecaplus.gestionlibros.modelo.Resenia;
import com.davincicode.bibliotecaplus.gestionlibros.repositorio.BDLibros;

import java.util.List;

public class LibroServicio {
    private BDLibros datosLibros;

    public LibroServicio( ){
        this.datosLibros = new BDLibros();
    }

    public void agregarResenia(Resenia resenia){
         datosLibros.agregarReseniaLibro(resenia);
    }

    List<Resenia> mostrarResenias(){
        return datosLibros.mostrarResenias();
    }

}
