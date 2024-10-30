package com.davincicode.bibliotecaplus.gestionlibros.modelo;

import java.util.Date;

public class Libro {
   /**Escribir atributos y comportamientos que necesitamos*/

    private static int id = 0; /*generamos un atributo de clase y no de objeto que funciona como contador cada vez que se instancia un objeto*/
    private int idLibro; /*atributo id que va a tener cada objeto creado*/
    private String titulo;
    private String autor;
    private boolean disponibilidad;
    private int fechaDeDevolucion;

    public Libro(String titulo, String autor, boolean disponibilidad, int fechaDeDevolucion){
        idLibro = Libro.id++; /*el id del socio le ponemos el valor del contador*/
        this.titulo = titulo;
        this.autor = autor;
        this.disponibilidad = disponibilidad;
        this.fechaDeDevolucion = fechaDeDevolucion;
    }

    public static int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getFechaDeDevolucion() {
        return fechaDeDevolucion;
    }

    public void setFechaDeDevolucion(int fechaDeDevolucion) {
        this.fechaDeDevolucion = fechaDeDevolucion;
    }
}
