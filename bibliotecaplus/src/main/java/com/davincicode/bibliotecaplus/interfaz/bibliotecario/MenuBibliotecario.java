package com.davincicode.bibliotecaplus.interfaz.bibliotecario;

import com.davincicode.bibliotecaplus.gestionautores.servicio.AutorServicio;
import com.davincicode.bibliotecaplus.gestionautores.modelo.Autor;
import com.davincicode.bibliotecaplus.gestionlibros.servicio.LibroServicio;

import javax.swing.*;
import java.util.List;

public class MenuBibliotecario {

    public void mostrarMenu() {
        /*colocamos las funcionalidades que puede realizar un usuario bibliotecario en la app dentro de un array*/
        String[] funcionalidades = {"Buscar Autores por Nacionalidad", "Buscar Libros disponibles", "Agregar Libros", "Salir"};

        /*carga el modal con el msje para el bibliotecario y captura la elección del usuario bibliotecario */
        int funcionSeleccionada = mostrarMsjeSeleccionFuncionalidad(funcionalidades);

        /*armamos un switch que según el n° de opción (posición del arreglo funcionalidades[]) dispara una función en particular*/
        switch (funcionSeleccionada){
            case -1:
                System.exit(0);
           //     break;
            case 0:
                buscarAutoresPorNacionalidad(); //llamamos a la función que posibilita buscar autores por nacionalidad
                break;
            case 1:
                //TODO: llamar método para buscar libros
                break;
            case 2:
                agregarLibroABiblioteca();
                break;
            case 3:
               /*si selecciona la opción de la posición 3 "salir" lo sacamos del sistema*/
                System.exit(0);
                break;
        }

    }

    private void agregarLibroABiblioteca(){
        String[] datosLibro = armarModalCargarLibro();
        String titulo, autor, fechaDevolucion;
        titulo = datosLibro[0];
        autor = datosLibro[1];
        fechaDevolucion = datosLibro[2];
        Integer fechaDevolucionConvertidaAInteger = Integer.valueOf(fechaDevolucion);/*convertimos la fecha String a Integer*/
        boolean disponibilidad = true; /*cuando cargamos el libro lo dejamos disponible para que lo pidan*/

        LibroServicio bibliotecario = new LibroServicio();/*creamos instancia de LibroServicio para llamar al método que agrega el libro*/
        bibliotecario.agregarLibroABiblioteca(titulo, autor, disponibilidad, fechaDevolucionConvertidaAInteger);

    }

    private static String[] armarModalCargarLibro() {
        // Crea un JPanel para los inputs donde ingresa información el usuario
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JTextField tituloLibro = new JTextField(20);
        JTextField autorLibro = new JTextField(20);
        JTextField fechaDevolucionDelLibro = new JTextField(20);

        // Agregar los campos al panel
        panel.add(new JLabel("Ingrese título del libro:"));
        panel.add(tituloLibro);
        panel.add(new JLabel("Ingrese autor del libro:"));
        panel.add(autorLibro);
        panel.add(new JLabel("Ingrese Fecha devolución del libro:"));
        panel.add(fechaDevolucionDelLibro);

        // Mostrar el dialogo con el panel
        int option = JOptionPane.showConfirmDialog(null, panel, "Ingresar usuario y contraseña", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario presiona OK, retornar los valores
        if (option == JOptionPane.OK_OPTION) {
            return new String[]{
                    tituloLibro.getText(),
                    autorLibro.getText(),
                    fechaDevolucionDelLibro.getText(),
            };
        }
        return null; // Retornar null si se cancela
    }

    private int mostrarMsjeSeleccionFuncionalidad(String[] funcionalidades){
        return JOptionPane.showOptionDialog(null, "Seleccione una funcionalidad:", "Funciones Bibliotecario",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, funcionalidades, funcionalidades[0]);

    }

    private void buscarAutoresPorNacionalidad() {

        String nacionalidad = ingresarNacionalidadAutor();//mostramos msje y capturamos la respuesta del usuario bibliotecario

        if (validarNacionalidad(nacionalidad)) { //validamos que se haya ingresado un texto y que no esté vacío

                List<Autor> listaAutores = buscarAutoresPorNacionalidad(nacionalidad);//llamamos al método que invoca a la función del servicio "AutorServicio" que nos posibilita buscar autores
                mostrarDatosAutoresMismaNacionalidad(listaAutores);

        } else {
            mostrarAdvertencia("La nacionalidad no puede estar vacía.");
        }
    }

    private String ingresarNacionalidadAutor(){
        return JOptionPane.showInputDialog("Ingrese la nacionalidad del autor/escritor");
    }

    private boolean validarNacionalidad(String nacionalidad){
        return nacionalidad != null && !nacionalidad.trim().isEmpty();
    }

    private List<Autor> buscarAutoresPorNacionalidad(String nacionalidad)  {
        AutorServicio autorServicio = new AutorServicio(); //crear un objeto de tipo AutorServicio para poder acceder al método findAutorByNacionalidad
        return  autorServicio.findAutorByNacionalidad(nacionalidad); //llama al método para buscar autor por nacionalidad y le pasa el argumento de la nacionalidad
    }

    private void  mostrarDatosAutoresMismaNacionalidad(List<Autor> listaAutores){
        StringBuilder escritoresMismaNacionalidad = new StringBuilder("Autores encontrados:\n");
        for (Autor autor : listaAutores) {
            escritoresMismaNacionalidad.append("Nombre: ").append(autor.getNombre()) //añadimos a la variable "escritoresMismaNacionalidad" los datos personales de aquellos escritores que tienen en común la nacionalidad
                    .append(", Apellido: ").append(autor.getApellido())
                    .append(", Nacionalidad: ").append(autor.getNacionalidad()).append("\n");
        }
        JOptionPane.showMessageDialog(null, escritoresMismaNacionalidad.toString(), "Resultados de Búsqueda", JOptionPane.INFORMATION_MESSAGE); //mostramos al usuario la lista de autores de determinada nacionalidad
    }
    private void mostrarAdvertencia(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);

    }
}
