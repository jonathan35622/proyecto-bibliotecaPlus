package com.davincicode.bibliotecaplus.gestionlibros.repositorio;

import com.davincicode.bibliotecaplus.gestionlibros.modelo.Libro;
import com.davincicode.bibliotecaplus.gestionlibros.modelo.Resenia;

import java.util.List;

public interface LibroRepository {

    //TODO 
    void agregarReseniaLibro(Resenia resenia);
    List<Resenia> mostrarResenias();
}
