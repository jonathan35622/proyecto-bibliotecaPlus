package com.davincicode.bibliotecaplus.interfaz.socio;
import com.davincicode.bibliotecaplus.gestionlibros.modelo.Resenia;
import com.davincicode.bibliotecaplus.gestionlibros.servicio.LibroServicio;

import javax.swing.*;

public class MenuSocio {
    public void mostrarMenu() {
        JOptionPane.showMessageDialog(null, "Bienvenido ☺!", "Socio", JOptionPane.INFORMATION_MESSAGE);
        String[] funcionalidades = {"Buscar Libros disponibles", "Agregar Libro", "Dejar reseña", "Salir"};
        
        int funcionSeleccionada = mostrarMsjeSeleccionFuncionalidad(funcionalidades);

        switch (funcionSeleccionada){
            case -1:
                System.exit(0);
                //     break;
            case 0:
                 //TODO: llamamos a la función que posibilita buscar libros disponibles
                break;
            case 1:
                //TODO: llamar método para Agregar libros
                break;
            case 2:
                agregarResenia();
                break;
            case 3:
                /*si selecciona la opción de la posición 3 "salir" lo sacamos del sistema*/
                System.exit(0);
                break;
        }
    }

    private void agregarResenia(){
        String[] inputs = ingresarLibroYResena();
        //posicion 0= nombre del libro, 1= nombre persona , 2 = calificacioón , 3= comentario
        capturarDatosResenia(inputs);


    }

    private  void capturarDatosResenia(String[] inputs){
        String nombreLibro = inputs[0];
        String nombreSocio = inputs[1];
        int calificacionLibro = Integer.parseInt(inputs[2]);
        String textoResenia = inputs[3];

        Resenia resenia = new Resenia(nombreLibro,nombreSocio, calificacionLibro,textoResenia );
        agregarResenia(resenia);
    }

    private void agregarResenia(Resenia resenia){
        LibroServicio biblioteca = new LibroServicio();
        biblioteca.agregarResenia(resenia);
    }

    private static String[] ingresarLibroYResena() {
        // Crea un JPanel para los inputs donde ingresa información el usuario
        JPanel panel = new JPanel();
        JTextField libroField = new JTextField(20);
        JTextField usuarioField = new JTextField(20);
        JTextField calificacionField = new JTextField(5);
        JTextArea reseniaArea = new JTextArea(5, 20);
        reseniaArea.setLineWrap(true);
        reseniaArea.setWrapStyleWord(true);

        // Agregar los campos al panel
        panel.add(new JLabel("Ingrese el nombre del libro:"));
        panel.add(libroField);
        panel.add(new JLabel("Ingrese su nombre:"));
        panel.add(usuarioField);
        panel.add(new JLabel("Ingrese la calificación (1-5):"));
        panel.add(calificacionField);
        panel.add(new JLabel("Ingrese una reseña:"));
        panel.add(new JScrollPane(reseniaArea));

        // Mostrar el dialogo con el panel
        int option = JOptionPane.showConfirmDialog(null, panel, "Ingresar Libro y Reseña", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario presiona OK, retornar los valores
        if (option == JOptionPane.OK_OPTION) {
            return new String[]{
                    libroField.getText(),
                    usuarioField.getText(),
                    calificacionField.getText(),
                    reseniaArea.getText()
            };
        }
        return null; // Retornar null si se cancela
    }

    private int mostrarMsjeSeleccionFuncionalidad(String[] funcionalidades){
        return JOptionPane.showOptionDialog(null, "Seleccione una funcionalidad:", "Funciones Socio",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, funcionalidades, funcionalidades[0]);

    }
}
