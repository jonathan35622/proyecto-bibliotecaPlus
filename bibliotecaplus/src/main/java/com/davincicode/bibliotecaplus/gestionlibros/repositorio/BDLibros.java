package com.davincicode.bibliotecaplus.gestionlibros.repositorio;

import com.davincicode.bibliotecaplus.gestionlibros.modelo.Libro;
import com.davincicode.bibliotecaplus.gestionlibros.modelo.Resenia;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BDLibros implements LibroRepository{

    private List<Resenia> resenias;
    private List<Libro> libros;

    public BDLibros(){
        this.resenias = new ArrayList<>();
        this.libros = new ArrayList<>();
    }

    @Override
    public void agregarReseniaLibro(Resenia resenia) {
        if(resenia == null){
            JOptionPane.showMessageDialog(null, "El usuario no envió los datos del libro", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        resenias.add(resenia);
        JOptionPane.showMessageDialog(null, "La reseña se agregó correctamente, gracias por su contribución! ");
    }

    @Override
    public List<Resenia> mostrarResenias() {
        return List.of((Resenia) resenias);
    }

    @Override
    public void agregarLibro(String titulo, String autor, boolean disponibilidad, int fechaDeDevolucion) {
        Libro libroACargar = new Libro(titulo, autor, disponibilidad, fechaDeDevolucion);
        libros.add(libroACargar);
        JOptionPane.showMessageDialog(null, "Libro agregado a la lista de libros");

    }

}
