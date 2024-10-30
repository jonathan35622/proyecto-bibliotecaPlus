package com.davincicode.bibliotecaplus.interfaz.socio;
import com.davincicode.bibliotecaplus.gestionlibros.modelo.Resenia;
import com.davincicode.bibliotecaplus.gestionlibros.servicio.LibroServicio;
import com.davincicode.bibliotecaplus.gestionsesionsocio.servicio.ServicioSesion;

import javax.swing.*;

public class MenuSocio {
    public void mostrarMenu() {

        String[] loginRegistro = {"Registrarse" , "Iniciar Sesión"};

        int seleccionIngresoSesion =  mostrarMsjeRegistroOLoginSocio(loginRegistro);
        ejecutarOpcionIniciarSesion(seleccionIngresoSesion);

    }

    private void ejecutarOpcionIniciarSesion(int seleccionIngresoSesion){
        switch (seleccionIngresoSesion){
            case 0:
                registrarSocio();
                break;
            case 1:
                realizarLoginAplicacionSocio();
                break;
            default:
                JOptionPane.showMessageDialog(null, "No es una opción correcta!");
                System.exit(0);
        }
    }

    private void registrarSocio(){
        String [] datosRegistro = armarModalRegistroSocio();
        String nombre, apellido, correo, telefono, nombreUsuarioRegistro, contraseniaUsuarioRegistro;
        nombre = datosRegistro[0];
        apellido = datosRegistro[1];
        correo = datosRegistro[2];
        telefono = datosRegistro[3];
        nombreUsuarioRegistro = datosRegistro[4];
        contraseniaUsuarioRegistro = datosRegistro[5];

        if(validarDatosIngresadosRegistro(nombre, apellido, correo, telefono, nombreUsuarioRegistro, contraseniaUsuarioRegistro)){
            ServicioSesion registrarSocio = new ServicioSesion();
            registrarSocio.registrarSocio(nombre, apellido, correo, telefono,nombreUsuarioRegistro, contraseniaUsuarioRegistro);
        }else{
            JOptionPane.showMessageDialog(null, "Todos los datos son necesarios para el registro", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private boolean validarDatosIngresadosRegistro(String nombre, String apellido, String correo, String telefono, String nombreUsuarioRegistro, String contraseniaUsuarioRegistro) {
        /*validamos que los datos que ingresa el usuario no estén vacíos / Si no están vacíos retornamos true   */
        if(!nombre.trim().isEmpty() && !apellido.trim().isEmpty() &&
                !correo.trim().isEmpty() && !telefono.trim().isEmpty() &&
                !nombreUsuarioRegistro.trim().isEmpty() && !contraseniaUsuarioRegistro.trim().isEmpty()){
            return  true;
        }
        return false; //retornamos false por defecto
    }

    private boolean realizarLoginAplicacionSocio( ) {
        String[] inputsIniciarSesion =  armarModaliniciarSesion();
        if(permitirLoguearse(inputsIniciarSesion)){
            String[] funcionalidades = funcionalidadesSocio();
            int funcionSeleccionada = mostrarMsjeSeleccionFuncionalidad(funcionalidades);
            ejecutarFuncionSeleccionadaPorSocio(funcionSeleccionada);
            return true;
        }
        return false;
    }

    private boolean permitirLoguearse(String[] inputsLogearse ){
        String nombreUsuarioLogin = inputsLogearse[0];
        String contraseniaUsuarioLogin = inputsLogearse[1];

        ServicioSesion servicioSesion = new ServicioSesion();
         boolean permiteLogin = servicioSesion.permitirLogin(nombreUsuarioLogin, contraseniaUsuarioLogin);
         return permiteLogin;

    }

    private void agregarResenia(){
        String[] inputs = armarModalParaIngresarDatosResenia();
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

    private static String[] armarModalRegistroSocio() {
        // Crea un JPanel para los inputs donde ingresa información el usuario
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JTextField nombreSocio = new JTextField(20);
        JTextField apellidoSocio = new JTextField(20);
        JTextField correoSocio = new JTextField(20);
        JTextField celularSocio = new JTextField(20);
        JTextField nombreUsuarioRegistro = new JTextField(20);
        JTextField contraseniaUsuarioRegistro = new JTextField(20);


        // Agregar los campos al panel
        panel.add(new JLabel("Ingrese su nombre:"));
        panel.add(nombreSocio);
        panel.add(new JLabel("Ingrese su apellido:"));
        panel.add(apellidoSocio);
        panel.add(new JLabel("Ingrese su correo:"));
        panel.add(correoSocio);
        panel.add(new JLabel("Ingrese su número de teléfono:"));
        panel.add(celularSocio);

        panel.add(new JLabel("Ingrese un nombre usuario para su registro:"));
        panel.add(nombreUsuarioRegistro);
        panel.add(new JLabel("Ingrese su contraseña:"));
        panel.add(contraseniaUsuarioRegistro);


        // Mostrar el dialogo con el panel
        int option = JOptionPane.showConfirmDialog(null, panel, "Ingresar usuario y contraseña", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario presiona OK, retornar los valores
        if (option == JOptionPane.OK_OPTION) {
            return new String[]{
                    nombreSocio.getText(),
                    apellidoSocio.getText(),
                    correoSocio.getText(),
                    celularSocio.getText(),
                    nombreUsuarioRegistro.getText(),
                    contraseniaUsuarioRegistro.getText(),
            };
        }
        return null; // Retornar null si se cancela
    }

    private static String[] armarModaliniciarSesion() {
        // Crea un JPanel para los inputs donde ingresa información el usuario
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField nombreUsuarioLoginField = new JTextField(20);
        JTextField contraseniaUsuarioLoginField = new JTextField(20);


        // Agregar los campos al panel
        panel.add(new JLabel("Ingrese nombre usuario login:"));
        panel.add(nombreUsuarioLoginField);
        panel.add(new JLabel("Ingrese su contraseña:"));
        panel.add(contraseniaUsuarioLoginField);


        // Mostrar el dialogo con el panel
        int option = JOptionPane.showConfirmDialog(null, panel, "Ingresar usuario y contraseña", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario presiona OK, retornar los valores
        if (option == JOptionPane.OK_OPTION) {
            return new String[]{
                    nombreUsuarioLoginField.getText(),
                    contraseniaUsuarioLoginField.getText(),
            };
        }
        return null; // Retornar null si se cancela
    }



    private static String[] armarModalParaIngresarDatosResenia() {
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

    private int mostrarMsjeRegistroOLoginSocio(String[] loginRegistro){
        return JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Ingreso",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, loginRegistro, loginRegistro[0]);
    }

    private String[] funcionalidadesSocio(){
        String[] funcionalidades = {"Buscar Libros disponibles", "Agregar Libro", "Dejar reseña", "Salir"};
        return  funcionalidades;
    }
    private void ejecutarFuncionSeleccionadaPorSocio(int funcionSeleccionada){
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

}
