package com.mh.biblioteca;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Objects;

public class BiblioController {

    @FXML
    public ComboBox<String> cbgenero;

    @FXML
    public ComboBox<String> cbgeneroeditadmin;


    @FXML
    private TableColumn<?, ?> ColumNombre;

    @FXML
    private TableColumn<?, ?> ColumDNI;


    @FXML
    private TableColumn<?, ?> Columemail;

    @FXML
    private TableColumn<?, ?> Columtelefono;

    @FXML
    private AnchorPane PaneLibros;

    @FXML
    private VBox Panebienvenida;

    @FXML
    private AnchorPane PanelEditarUsuario;

    @FXML
    private AnchorPane PanelIniciar;

    @FXML
    private AnchorPane PanelInicio;

    @FXML
    private AnchorPane PanelRegistro;

    @FXML
    private AnchorPane PanelUsuarios;

    @FXML
    private AnchorPane Paneladdlibros;


    @FXML
    private AnchorPane Panelbusquedas;

    @FXML
    private AnchorPane Paneldesplegable;

    @FXML
    private AnchorPane Panelsuperior;

    @FXML
    private ScrollPane Panelveradmin;

    @FXML
    private ScrollPane Panelverusuario;

    @FXML
    private TableView<Usuarios> TableUsuarios;

    @FXML
    private VBox Vboxadmin;

    @FXML
    private VBox Vboxusuario;

    @FXML
    private Button btmenu;

    @FXML
    private Button btnaddlibro;

    @FXML
    private Button btmenu1;

    @FXML
    private Button btmenu11;

    @FXML
    private Button btmenubusqueda;

    @FXML
    private CheckBox cbarte;

    @FXML
    private CheckBox cbbiografias;

    @FXML
    private CheckBox cbciencia;

    @FXML
    private CheckBox cbcocina;

    @FXML
    private CheckBox cbcomics;

    @FXML
    private CheckBox cbdeporte;

    @FXML
    private CheckBox cbdrama;

    @FXML
    private CheckBox cbfantasia;

    @FXML
    private CheckBox cbficcion;

    @FXML
    private CheckBox cbfilosofia;

    @FXML
    private CheckBox cbhumor;

    @FXML
    private CheckBox cbinfantil;

    @FXML
    private CheckBox cbmisterio;

    @FXML
    private CheckBox cbnovelas;

    @FXML
    private CheckBox cbpoesia;

    @FXML
    private CheckBox cbterror;

    @FXML
    private CheckBox cbthrillers;

    @FXML
    private CheckBox cbviajes;

    @FXML
    private CheckBox cbdisp;

    @FXML
    private GridPane gridlibros;

    @FXML
    private ImageView imglibro;

    @FXML
    private ImageView imgperfilregistro1;

    @FXML
    private ImageView imglibrover;

    @FXML
    private ImageView imglibrover1;

    @FXML
    private ImageView imgperfilregistro11;

    @FXML
    private Label lblautor;

    @FXML
    private Label lbldescripcion;

    @FXML
    private Label lbleditorial;

    @FXML
    private Label lblgenero;

    @FXML
    private Label lblisbn;

    @FXML
    private Label lbltitulo;

    @FXML
    private ScrollPane scrollpane;

    @FXML
    private TextField txtautor;

    @FXML
    private TextField txtbusquedas;


    @FXML
    private TextArea txtdescripcion;


    @FXML
    private TextField txteditorial;


    @FXML
    private TextField txtisbn;

    @FXML
    private TextField txtgenero;

    @FXML
    private TextField txtusuario;


    @FXML
    private TextField txtusuario1;

    @FXML
    private TextField txtcontrasena;

    @FXML
    private TextField txtdniregister;

    @FXML
    private TextField txtemailregistro;

    @FXML
    private TextField txtpassregister;


    @FXML
    private TextField txttelefonoregistro;

    @FXML
    private TextField txttituloeditadmin;

    @FXML
    private TextField txtnombreUpdate;

    @FXML
    private TextField txtdniupdate;

    @FXML
    private TextField txtpassUpdate;

    @FXML
    private TextField txtemailUpdate;

    @FXML
    private TextField txttelefonoUpdate;

    @FXML
    private TextField txtautoreditadmin;

    @FXML
    private TextField txteditorialadmin;

    @FXML
    private TextField txtisbneditadmin;

    @FXML
    private TextArea txtdescripcioneditadmin;


    @FXML
    private TextField txttitulolibro;
    @FXML
    private Pane Panelverlibros;
    private Pane panelactual;


    private boolean usuarioact = false;

    Button btnuevo;

    int ultimafila = 0;
    private final String conexionbiblio = "jdbc:mysql://localhost:3306/biblio";
    //Esta variable tiene el usuario con el que nos conectaremos a la base de datos
    private final String user = "root";
    //Esta es la contraseña del usuario anterior para conectarnos a la base de datos
    private final String pswd = "1492";

    private Button bt;

    private boolean complogin;

    private String imageruta;

    private boolean compregister;

    ArrayList<Button> listabotones = new ArrayList<>();

    FileChooser fil_chooser = new FileChooser();
    Stage selec = new Stage();

    Usuarios useractual;

    private boolean admin;//Debes hacer la consulta al acceder para determinar si es admin o no

    private void cambiarpanel(Pane panel1, Pane panel2) {
        panel1.setVisible(false);
        panel2.setVisible(true);
        panelactual = panel2;
    }

    @FXML
    public void pressbtacceder() {
        //Definimos conexion como null
        Connection conexion = null;
        //Ejecutamos el comprobarlogin para controlar posibles fallos a la hora de hacer la consulta
        comprobarlogin();
        //Comprobamos que la variable complogin sea true
        if (complogin) {
            //Ejecutamos dentro de un try para controlar posibles excepciones
            try {
                conexion = DriverManager.getConnection(conexionbiblio, user, pswd);
                //Creamos la consulta con PreparedStatement
                PreparedStatement ps2 = conexion.prepareStatement("select dni from usuarios where dni = ?");
                ps2.setString(1, txtusuario.getText());
                //Ejecutamos la consulta
                ResultSet rs2 = ps2.executeQuery();
                //Comprobamos que la consulta tenga datos
                if (rs2.next()) {
                    //Comparamos que el usuario escrito exista en la base de datos
                    if (Objects.equals(rs2.getString(1), txtusuario.getText()) && complogin) {
                        //Si existe definimos que usuarioact es true
                        usuarioact = true;
                        //Creamos la consulta con PreparedStatement
                        PreparedStatement ps = conexion.prepareStatement("select Pswd, userroot from usuarios where dni = ? ");
                        ps.setString(1, txtusuario.getText());
                        //Ejecutamos la consulta
                        ResultSet rs = ps.executeQuery();

                        //Comprobamos que la consulta tenga datos
                        if (rs.next()) {
                            //Comparamos los datos introducidos por el usuario con la contraseña que nos ha dado la consulta anterior
                            if (Objects.equals(rs.getString(1), txtcontrasena.getText())) {
                                admin = rs.getInt(2) == 1;
                                useractual = new Usuarios(txtusuario.getText(), txtcontrasena.getText());
                                //Abrimos la ventana principal
                                btmenu.setDisable(false);
                                PanelIniciar.setVisible(false);
                                Panebienvenida.setVisible(true);
                                panelactual = PanelInicio;
                                if (admin) {
                                    cambiarpanel(Vboxusuario, Vboxadmin);
                                } else {
                                    cambiarpanel(Vboxadmin, Vboxusuario);
                                }
                            } else {
                                //Informamos al usuario
                                crearalertaerror("La contraseña para este usuario es incorrecta");
                            }
                        }
                    } else {
                        //Definimos que la variable usuarioact es false
                        usuarioact = false;
                    }
                }
                //Comprobamos si la variable usuarioact es false
                if (!usuarioact) {
                    //Informamos al usuario
                    crearalertaerror("Usuario no registrado");
                }
                //Controlamos la excepciones
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    BiblioApplication app = new BiblioApplication();

    @FXML
    void presslogout(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        app.start(new Stage());
    }

    @FXML
    public void pressbtregistrate() {
        cambiarpanel(panelactual, PanelRegistro);
    }

    @FXML
    public void cerrarregistro() {
        cambiarpanel(panelactual, PanelIniciar);
    }

    @FXML
    public void cerrar(ActionEvent event) {
        Button botonclick = (Button) event.getSource();
        botonclick.getParent().setVisible(false);
    }

    @FXML
    public void pressbtalquilar() {
        try {
            Connection con = DriverManager.getConnection(conexionbiblio, user, pswd);

            String st = String.format("Select Ban from usuarios where DNI = '%s' ", useractual.getDNI());
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(st);
            if(rs.next()){
                LocalDate fechaban = rs.getDate(1).toLocalDate();
                fechaban = fechaban.minusDays(1);
                Period tiemporestante = (Period.between(LocalDate.now(), fechaban));
                if(fechaban.isBefore(LocalDate.now())){
                    String update = String.format("Update tabla_biblio set stock = 0 where Nombre = '%s'", lbltitulo.getText());
                    String datoslibro = String.format("Select * from tabla_biblio where nombre = '%s'", lbltitulo.getText());
                    ResultSet rs3 = stat.executeQuery(datoslibro);
                    if(rs3.next()){
                        LocalDate fechaentrega = LocalDate.now().plusDays(30);
                        java.sql.Date fechaSQL = java.sql.Date.valueOf(fechaentrega);
                        String insercion = String.format("Insert into librouser values ('%s', '%s', '%s'", useractual.getDNI(), rs3.getString(7), fechaSQL);
                        stat.executeUpdate(insercion);
                        stat.executeQuery(update);
                        System.out.println("Libro asignado");
                    }
                } else {
                    crearalertaerror(String.format("Estas Baneado durante: '%s' años, '%s' meses y '%s' dias", tiemporestante.getYears(), tiemporestante.getMonths(), tiemporestante.getDays()));
                }
            }
            bdlibros("SELECT Nombre, Foto FROM TABLA_BIBLIO");
            Panelveradmin.setVisible(false);
            PaneLibros.setVisible(true);
            Panelverlibros.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void cerrarmenubusquedas() {
        Panelbusquedas.setVisible(false);
    }

    @FXML
    public void pressbtbuscarusuario() {
    }

    @FXML
    public void pressbteliminarlibros() {
        try {
            Connection con = DriverManager.getConnection(conexionbiblio, user, pswd);

            String st = String.format("delete from TABLA_BIBLIO where ISBN = '%s' ", txtisbneditadmin.getText());
            Statement stat = con.createStatement();
            stat.execute(st);
            crearalertainfo("Libro borrado");
            bdlibros("SELECT Nombre, Foto FROM TABLA_BIBLIO");
            Panelveradmin.setVisible(false);
            PaneLibros.setVisible(true);
            Panelverlibros.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void pressbteditarlibros() {
        try {
            Connection con = DriverManager.getConnection(conexionbiblio, user, pswd);
            Statement stat = con.createStatement();
            if (imageruta == null) {
                String consul = String.format("Select Foto from tabla_biblio where ISBN = '%s'", txtisbneditadmin.getText());
                ResultSet rs4 = stat.executeQuery(consul);
                if (rs4.next()) {
                    imageruta = rs4.getString(1);
                }
            }

            String st = String.format("update TABLA_BIBLIO set Nombre = '%s', Foto = '%s', Genero = '%s', Autor = '%s', Editorial = '%s', Descripcion = '%s' where ISBN = '%S'", txttituloeditadmin.getText(), imageruta, cbgeneroeditadmin.getSelectionModel().getSelectedItem(), txtautoreditadmin.getText(), txteditorialadmin.getText(), txtdescripcioneditadmin.getText(), txtisbneditadmin.getText());
            stat.execute(st);
            crearalertainfo("Libro actualizado");
            bdlibros("SELECT Nombre, Foto FROM TABLA_BIBLIO");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void pressbtusuarios() {
        cambiarpanel(panelactual, PanelUsuarios);
        PaneLibros.setVisible(false);
        PanelUsuarios.setVisible(true);
        Panelsuperior.setStyle("-fx-opacity: 0.7");
    }

    void rellenarUsuarios() {
        Connection conexion = null;
        //Ejecutamos el código en un try para controlar las excepciones
        try {
            //Creamos la conexion);
            conexion = DriverManager.getConnection(conexionbiblio, user, pswd);
            Statement st = conexion.createStatement();
            TableUsuarios.getItems().clear();
            //Creamos la consulta
            String consulta = "SELECT DNI, Nombre, telefono, email, Pswd, img FROM usuarios";
            //Guardamos la ejecución de la consulta en la variable rs
            ResultSet rs = st.executeQuery(consulta);
            //Bucle para seguir importando datos mientras los haya
            ObservableList<Usuarios> obsuser = FXCollections.observableArrayList();
            while (rs.next()) {
                //ObservableList para guardar dentro el paciente correspondiente para añadirlo a las columnas
                //Creamos un paciente, con los campos obtenidos de la consulta
                obsuser.add(new Usuarios(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
                //Relacionamos la columna con el campo del constructor correcto
                ColumDNI.setCellValueFactory(new PropertyValueFactory<>("DNI"));
                ColumNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
                Columtelefono.setCellValueFactory(new PropertyValueFactory<>("Telefono"));
                Columemail.setCellValueFactory(new PropertyValueFactory<>("Email"));
                //Metemos dentro la tabla paciente la lista creada anteriormente
                TableUsuarios.setItems(obsuser);
            }
            //Refrescamos la tabla paciente
            TableUsuarios.refresh();
            //Controlamos las excepciones mostrándolas por la terminal
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void pressbtbiblioteca() {
        bdlibros("SELECT Nombre, Foto FROM TABLA_BIBLIO");
        cambiarpanel(panelactual, PaneLibros);
        PaneLibros.setVisible(true);
        PanelUsuarios.setVisible(false);
        Panelsuperior.setStyle("-fx-opacity: 1");
    }

    @FXML
    public void pressbtmislibros() {
        bdmislibros();
        cambiarpanel(panelactual, PaneLibros);
        PaneLibros.setVisible(true);
        Panelsuperior.setStyle("-fx-opacity: 1");
    }

    @FXML
    void pressbtbuscar() {
        String gen = String.valueOf(cbselec);
        if(cbdisp.isSelected()){
            if (Objects.equals(txtbusquedas.getText(), "") && cbselec.length()<=0){
                bdlibros("SELECT * FROM TABLA_BIBLIO WHERE Stock = 1");
            }else if(!Objects.equals(txtbusquedas.getText(), "") && (cbselec.length() <= 0)){
                bdlibros(String.format("SELECT * FROM TABLA_BIBLIO WHERE Nombre LIKE '%s' AND Stock = 1","%" + txtbusquedas.getText() + "%"));
            }else if(Objects.equals(txtbusquedas.getText(), "") && cbselec.length()>0){
                bdlibros(String.format("SELECT * FROM TABLA_BIBLIO WHERE Genero IN (%s) AND Stock = 1 ORDER BY Nombre ASC", gen));
            } else {
                bdlibros(String.format("SELECT * FROM TABLA_BIBLIO WHERE Nombre LIKE '%s' AND Genero IN (%s) AND Stock = 1 ORDER BY Nombre ASC","%" + txtbusquedas.getText() + "%", gen));
            }
        }else{
            if (Objects.equals(txtbusquedas.getText(), "") && cbselec.length()<=0){
                bdlibros("SELECT Nombre, Foto FROM TABLA_BIBLIO");
            }else if(!Objects.equals(txtbusquedas.getText(), "") && (cbselec.length() <= 0)){
                bdlibros(String.format("SELECT * FROM TABLA_BIBLIO WHERE Nombre LIKE '%s'","%" + txtbusquedas.getText() + "%"));
            }else if(Objects.equals(txtbusquedas.getText(), "") && cbselec.length()>0){
                bdlibros(String.format("SELECT * FROM TABLA_BIBLIO WHERE Genero IN (%s) ORDER BY Nombre ASC", gen));
            } else {
                bdlibros(String.format("SELECT * FROM TABLA_BIBLIO WHERE Nombre LIKE '%s' AND Genero IN (%s) ORDER BY Nombre ASC","%" + txtbusquedas.getText() + "%", gen));
            }
        }
    }

    @FXML
    public void pressbtanadir() {
        // Agregar filtros para facilitar la busqueda
        fil_chooser.setTitle("Selecciona una imagen");
        fil_chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Images", "*.*"), new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("PNG", "*.png"));

        File file = fil_chooser.showOpenDialog(selec);

        if (file != null) {
            if (PanelRegistro.isVisible()) {
                copiararchivos2(file, imgperfilregistro1);
            }
            if (Paneladdlibros.isVisible()) {
                copiarArchivos(file, imglibro);
            }
            if (Panelveradmin.isVisible()) {
                copiarArchivos(file, imglibrover1);
            }
            if (PanelEditarUsuario.isVisible()) {
                copiararchivos2(file, imgperfilregistro11);
            }
        }
        assert file != null;
        String image = file.getPath();
        new Image(image);
        imageruta = file.getName();
    }

    private void copiararchivos2(File file, ImageView imgperfilregistro1) {
        try {
            Path source = file.toPath();
            Image imagenem = new Image(String.valueOf(source));
            imgperfilregistro1.setImage(imagenem);
            Path target = Paths.get("src/main/resources/img/imgusers/" + file.getName());
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            experimentalists(file);
        } catch (IOException ex) {
            System.out.println();

        }
    }

    private void copiarArchivos(File file, ImageView imglibrover1) {
        try {
            Path source = file.toPath();
            Image imagenem = new Image(String.valueOf(source));
            imglibrover1.setImage(imagenem);
            Path target = Paths.get("src/main/resources/img/imglibros/" + file.getName());
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            experimentalists(file);
        } catch (IOException ex) {
            System.out.println();

        }
    }


    void crearalertainfo(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Info");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    //Lo usaremos para informar al usuario de errores mediante ventanas emergentes, podemos establecer el mensaje
    //pasándoselo por parámetros
    void crearalertaerror(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }


    private void clearRegistro() {
        txtusuario1.clear();
        txtemailregistro.clear();
        txtpassregister.clear();
        txttelefonoregistro.clear();
        txtdniregister.clear();
        imgperfilregistro1.setImage(null);
    }

    @FXML
    public void pressbtnregister() {
        //Definimos conexion como null
        Connection conexion = null;
        //Ejecutamos el comprobarlogin para controlar posibles fallos a la hora de hacer la consulta
        comprobrarregister();
        //Comprobamos que la variable complogin sea true
        if (compregister) {

            //Ejecutamos dentro de un try para controlar posibles excepciones
            try {
                conexion = DriverManager.getConnection(conexionbiblio, user, pswd);
                //Creamos la consulta con PreparedStatement
                PreparedStatement ps2 = conexion.prepareStatement("insert into usuarios (nombre, dni, pswd, email, telefono, img, userroot) VALUES (?, ?, ?, ?, ?, ?, ?)");
                ps2.setString(1, txtusuario1.getText());
                ps2.setString(3, txtpassregister.getText());
                ps2.setString(2, txtdniregister.getText());
                ps2.setString(4, txtemailregistro.getText());
                ps2.setString(5, txttelefonoregistro.getText());
                ps2.setString(6, imageruta);
                ps2.setInt(7, 0);
                System.out.println(imageruta);
                ps2.executeUpdate();
                crearalertainfo("Usuario Registrado");
                cambiarpanel(panelactual, PanelIniciar);
                clearRegistro();

                //Controlamos la excepciones
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    //Cerramos la conexion para ahorrar recursos
                    assert conexion != null;
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void comprobrarregister() {
        compregister = false;
        if (Objects.equals(txtusuario1.getText(), "") || Objects.equals(txtpassregister.getText(), "") || Objects.equals(txtdniregister.getText(), "") || Objects.equals(txtemailregistro.getText(), "") || Objects.equals(txttelefonoregistro.getText(), "")) {
            crearalertaerror("Debe rellenar todos los campos");
        } else if (txtusuario1.getLength() > 20) {
            crearalertaerror("El usuario no puede tener más de 20 carácteres");
        } else if (txtusuario1.getLength() < 4) {
            crearalertaerror("El usuario no puede tener menos de 4 carácteres");
        } else if (txtpassregister.getLength() > 16) {
            crearalertaerror("La contraseña no puede tener más de 16 carácteres");
        } else if (txttelefonoregistro.getLength() != 9) {
            crearalertaerror("El teléfono debe tener una longitud de 9 dígitos");
        } else if (!isNumeric(txttelefonoregistro.getText())) {
            crearalertaerror("El número de telefono no pueden ser letras");
        } else {
            compregister = true;
        }
    }

    private static boolean isNumeric(String cadena) {
        //Lo ejecutamos dentro del try para controlar las excepciones
        try {
            //Intentamos parsearlo a Long
            Long.parseLong(cadena);
            //Si lo consigue, nos devuelve true
            return true;
            //Controlamos la excepcion correspondiente
        } catch (NumberFormatException nfe) {
            //En caso de que no podamos transformar el numero, devolvera false
            return false;
        }
    }

    private void comprobarlogin() {
        //Definimos complogin como false
        complogin = false;
        //Comprobamos que los datos no esten en blanco
        if (Objects.equals(txtusuario.getText(), "") || Objects.equals(txtcontrasena.getText(), "")) {
            crearalertaerror("Debe rellenar los dos campos");
            //Comprobamos que los datos del usuario no sobrepasen los 20 caracteres
        } else if (txtusuario.getLength() > 20) {
            crearalertaerror("El usuario no puede tener más de 20 caracteres");
            //Comprobamos que el campo de contraseña no tenga una longitud mayor de 16 caracteres
        } else if (txtcontrasena.getLength() > 16) {
            crearalertaerror("La contraseña no puede tener más de 16 caracteres");
            //Definimos true la variable complogin en caso de no haber ningun fallo en la comprobación
        } else {
            complogin = true;
        }
    }

    /*

    void cleanDirectorio(){
        File directorio = new File("src/main/resources/img/imglibros");

        File[] files = directorio.listFiles();
        if (files != null){
            for(File file : files){
                if(!file.delete()){
                    System.out.println("No se pudo eliminar el archivo " + file.getName());
                }
            }
        }
    }


     */
    void experimentalists(File file) {
        try {
            Connection con = DriverManager.getConnection(conexionbiblio, user, pswd);

            FileInputStream fis = new FileInputStream(file);
            PreparedStatement ps = con.prepareStatement("INSERT INTO imagenes values (?, ?, ?)");
            ps.setString(1, file.getName());
            ps.setString(2, file.getName());
            ps.setBinaryStream(3, fis, (int) file.length());
            ps.executeUpdate();
            fis.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /*
    void importarimagenes(){
        try{
            Connection con = DriverManager.getConnection(conexionbiblio, user, pswd);
            PreparedStatement ps = con.prepareStatement("SELECT * from imagenes");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String foto = rs.getString(1);
                Blob blob = rs.getBlob(3);
                byte[] bytes = blob.getBytes(1, (int) blob.length());

                FileOutputStream fos = new FileOutputStream("src/main/resources/img/imglibros/"+foto);
                fos.write(bytes);
                fos.close();
            }

            rs.close();
            ps.close();
            con.close();
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }


     */
    @FXML
    void bdlibros(String consult) {
        System.out.println(consult);
        int fil = 0;
        int col = 0;
        gridlibros.getChildren().clear();
        if (admin) {
            col = 1;
            btnuevo = new Button();
            Image imgnew = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/mas.png")));
            ImageView view1 = new ImageView();
            view1.setImage(imgnew);
            view1.setFitHeight(70);
            view1.setFitWidth(70);
            view1.setPreserveRatio(true);
            btnuevo.setGraphic(view1);
            btnuevo.setId("btslibros");
            btnuevo.setMinWidth(200);
            btnuevo.setMinHeight(270);
            btnuevo.setMaxWidth(Control.USE_COMPUTED_SIZE);
            btnuevo.setMaxHeight(270);
            btnuevo.setOnAction(event -> Paneladdlibros.setVisible(true));
            gridlibros.add(btnuevo, 0, 0);
        }


        gridlibros.setPrefWidth(scrollpane.getPrefWidth());

        try {
            listabotones.clear();
            Connection con = DriverManager.getConnection(conexionbiblio, user, pswd);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consult);
            // Recorrer los resultados obtenidos y mostrarlos en pantalla
            while (rs.next()) {
                String nombre = rs.getString("Nombre");
                String foto = rs.getString("Foto");
                bt = new Button();
                bt.setText(nombre);
                listabotones.add(bt);
                if (foto == null) {
                    String consul = String.format("Select Foto from tabla_biblio where nombre = '%s'", nombre);
                    ResultSet rs4 = st.executeQuery(consul);
                    if (rs4.next()) {
                        foto = rs4.getString(1);
                    }
                }
                asignarfotos(con, foto);
                bt.setOnAction(this::rellenartext);
                gridlibros.add(bt, col, fil);
                gridlibros.setPrefWidth(scrollpane.getPrefWidth());
                col++;
                ultimafila = fil + 1;
                if (col == 6) {
                    col = 0;
                    fil++;
                }
            }
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    private void asignarfotos(Connection con, String foto) {
        Image img = null;
        try {
            PreparedStatement ps = con.prepareStatement("Select image from imagenes where Foto = ?");
            ps.setString(1, foto);
            ResultSet rs4 = ps.executeQuery();
            if (rs4.next()) {
                Blob blob = rs4.getBlob(1);
                byte[] bytes = blob.getBytes(1, (int) blob.length());

                img = new Image(new ByteArrayInputStream(bytes));
            }
        } catch (Exception ignored) {
            imagenes(null);
        }
        imagenes(img);
    }

    void rellenartext(ActionEvent event) {
        Button botonclick = (Button) event.getSource();
        if (admin) {
            try {
                Connection con = DriverManager.getConnection(conexionbiblio, user, pswd);
                Statement st2 = con.createStatement();
                System.out.println(botonclick.getText() + "Texto Boton");
                String consulta2 = String.format("SELECT * FROM TABLA_BIBLIO where Nombre = '%s'", botonclick.getText());
                System.out.println("Consulta creada");
                ResultSet rs2 = st2.executeQuery(consulta2);
                if (rs2.next()) {
                    System.out.println("Dentro del if");
                    Panelverlibros.setVisible(true);
                    Panelverusuario.setVisible(false);
                    Panelveradmin.setVisible(true);
                    System.out.println("Paneles visibles supuestamente");
                    txttituloeditadmin.setText(rs2.getString(2));
                    cbgeneroeditadmin.getSelectionModel().select(rs2.getString(4));
                    txtautoreditadmin.setText(rs2.getString(5));
                    txteditorialadmin.setText(rs2.getString(6));
                    txtisbneditadmin.setText(rs2.getString(7));
                    txtisbneditadmin.setDisable(true);
                    txtdescripcioneditadmin.setText(rs2.getString(8));
                    extraerfotobdd(con, rs2, imglibrover1);
                }
            } catch (Exception ei) {
                ei.printStackTrace();
            }
        } else {
            try {
                Connection con = DriverManager.getConnection(conexionbiblio, user, pswd);
                Statement st2 = con.createStatement();
                System.out.println(botonclick.getText() + "Texto Boton");
                String consulta2 = String.format("SELECT * FROM TABLA_BIBLIO where Nombre = '%s'", botonclick.getText());
                System.out.println("ID= " + botonclick.getId());
                ResultSet rs2 = st2.executeQuery(consulta2);
                if (rs2.next()) {
                    Panelverusuario.setVisible(true);
                    Panelverlibros.setVisible(true);
                    Panelveradmin.setVisible(false);
                    lbltitulo.setText("Título: " + rs2.getString(2));
                    lblgenero.setText("Género: " + rs2.getString(4));
                    lblautor.setText("Autor: " + rs2.getString(5));
                    lbleditorial.setText("Editorial: " + rs2.getString(6));
                    lblisbn.setText("ISBN: " + rs2.getString(7));
                    lbldescripcion.setText("Descripción:" + rs2.getString(8));
                    extraerfotobdd(con, rs2, imglibrover);
                }
            } catch (Exception ei) {
                ei.printStackTrace();
            }
        }
    }

    private void extraerfotobdd(Connection con, ResultSet rs2, ImageView imglibrover) throws SQLException {
        PreparedStatement ps = con.prepareStatement("Select image from imagenes where Foto = ?");
        ps.setString(1, rs2.getString(3));
        rsconimg(imglibrover, ps);
    }

    private void rsconimg(ImageView imglibrover, PreparedStatement ps) throws SQLException {
        ResultSet rs4 = ps.executeQuery();
        Image imge = null;
        if (rs4.next()) {
            Blob blob = rs4.getBlob(1);
            byte[] bytes = blob.getBytes(1, (int) blob.length());

            imge = new Image(new ByteArrayInputStream(bytes));
        }
        imglibrover.setImage(imge);
    }


    @FXML
    void bdmislibros() {
        int fil = 0;
        int col = 0;
        gridlibros.getChildren().clear();
        try {
            Connection con = DriverManager.getConnection(conexionbiblio, user, pswd);

            Statement st = con.createStatement();
            String consulta = String.format("SELECT DNI, ISBN from librosuser where DNI = '%s'", useractual.getDNI());
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                String consulta2 = String.format("Select Nombre, Foto from TABLA_BIBLIO where ISBN = '%s'", rs.getString(2));
                ResultSet rs2 = st.executeQuery(consulta2);
                // Recorrer los resultados obtenidos y mostrarlos en pantalla
                if (rs2.next()) {

                    String nombre = rs.getString("Nombre");
                    String foto = rs.getString("Foto");
                    bt = new Button();
                    bt.setText(nombre);
                    asignarfotos(con, foto);
                    gridlibros.add(bt, col, fil);
                    gridlibros.setPrefWidth(scrollpane.getPrefWidth());
                    col++;
                    ultimafila = fil + 1;
                    if (col == 6) {
                        col = 0;
                        fil++;
                    }
                    bt.setOnAction(event -> System.out.println(bt.getText()));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void imagenes(Image img) {
        ImageView view = new ImageView();
        view.setImage(img);
        view.setFitHeight(200);
        view.setFitWidth(200);
        view.setPreserveRatio(true);
        bt.setGraphic(view);
        bt.setContentDisplay(ContentDisplay.TOP);
        bt.setId("btslibros");
        bt.setMinWidth(200);
        bt.setMinHeight(270);
        bt.setMaxWidth(Control.USE_COMPUTED_SIZE);
        bt.setMaxHeight(270);
    }

    @FXML
    void pressbtmenubusqueda() {
        Panelbusquedas.setVisible(true);
    }

    @FXML
    public void pressbtaddlibro() {
        try {
            Connection con = DriverManager.getConnection(conexionbiblio, user, pswd);

            PreparedStatement st = con.prepareStatement("insert into TABLA_BIBLIO (Nombre, Foto, Genero, Autor, Editorial, ISBN, Descripcion, Stock) values (?, ?, ?, ?, ?, ?, ?, 1)");
            st.setString(1, txttitulolibro.getText());
            st.setString(2, imageruta);
            st.setString(3, cbgenero.getSelectionModel().getSelectedItem());
            st.setString(4, txtautor.getText());
            st.setString(5, txteditorial.getText());
            st.setString(6, txtisbn.getText());
            st.setString(7, txtdescripcion.getText());
            st.executeUpdate();
            crearalertainfo("Libro creado");
            clearAddLibro();
            cambiarpanel(Paneladdlibros, Panelbusquedas);
            bdlibros("SELECT Nombre, Foto FROM TABLA_BIBLIO");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearAddLibro() {
        txttitulolibro.clear();
        txtautor.clear();
        txteditorial.clear();
        txtisbn.clear();
        txtdescripcion.clear();
        imglibro.setImage(null);
    }

    @FXML
    public void cerrarmenu() {
        Paneldesplegable.setVisible(false);
    }

    @FXML
    public void pressbtmenu() {
        Paneldesplegable.setVisible(true);
        if (admin) {
            Vboxadmin.setVisible(true);
            Vboxusuario.setVisible(false);
        } else {
            Vboxusuario.setVisible(true);
            Vboxadmin.setVisible(false);
        }
    }

    ObservableList<TextField> txtaddlibros = FXCollections.observableArrayList();
    ObservableList<CheckBox> cbs = FXCollections.observableArrayList();
    StringBuilder cbselec = new StringBuilder();
    @FXML
    void initialize() {
        txtaddlibros.addAll(txttitulolibro, txtgenero, txtautor, txteditorial, txtisbn);
        panelactual = PanelIniciar;
        btmenu.setDisable(true);
        ObservableList<String> relleno = FXCollections.observableArrayList();
        cbdisp.setOnAction(event -> pressbtbuscar());
        cbs.addAll(cbthrillers,cbbiografias,cbterror,cbnovelas,cbpoesia,cbmisterio,cbinfantil,cbhumor,cbfilosofia,cbarte,cbviajes,cbficcion,cbdeporte,cbcocina,cbdrama,cbcomics,cbciencia,cbviajes);
        for (int i = 0; i < cbs.size(); i++) {
            int finalI = i;
            int finalI1 = i;
            cbs.get(i).setOnAction(event ->{
                if(cbselec.length()<0){
                    bdlibros("SELECT Nombre, Foto FROM TABLA_BIBLIO");
                    return;
                }
                if (cbs.get(finalI).isSelected()) {
                    if (cbselec.length() > 2) {
                        cbselec.append(", ");
                    }
                    cbselec.append("'" + cbs.get(finalI1).getText() + "'");
                    if (cbselec.length() == 1) {
                        cbselec.append(")");
                    }
                    System.out.println(cbselec);
                }else{
                    int startIndex = cbselec.indexOf("'" + cbs.get(finalI1).getText() + "'");
                    int endIndex = startIndex + cbs.get(finalI1).getText().length() + 3;
                    cbselec.delete(startIndex, endIndex);
                    if (cbselec.length() > 2 && cbselec.charAt(cbselec.length() - 2) == ',') {
                        cbselec.deleteCharAt(cbselec.length() - 2);
                    }
                    if (cbselec.length() <= 2) {
                        cbselec.delete(0, cbselec.length());
                    }
                    System.out.println(cbselec);
                }
                pressbtbuscar();

            });
        }
        relleno.addAll("Biografías", "Ciencia", "Cómics", "Filosofía", "Arte y Fotografía", "Cocina", "Deporte", "Drama", "Ficción", "Fantasía", "Humor", "Terror", "Viajes", "Thrillers", "Poesía", "Misterio", "Infantil", "Novelas");
        cbgenero.setItems(relleno);
        cbgeneroeditadmin.setItems(relleno);
        rellenarUsuarios();
    }

    @FXML
    public void pressbteditar() throws SQLException {
        Connection con = DriverManager.getConnection(conexionbiblio, user, pswd);
        if (TableUsuarios.getSelectionModel().getSelectedItem() == null) {
            crearalertaerror("Seleccione un usuario de la tabla");
        } else {
            Usuarios uss = TableUsuarios.getSelectionModel().getSelectedItem();
            txtdniupdate.setDisable(true);
            txtnombreUpdate.setText(uss.getNombre());
            txttelefonoUpdate.setText(uss.getTelefono());
            txtdniupdate.setText(uss.getDNI());
            txtpassUpdate.setText(uss.getPass());
            txtemailUpdate.setText(uss.getEmail());
            PreparedStatement ps = con.prepareStatement("Select image from imagenes where Foto = ?");
            ps.setString(1, uss.getFoto());
            rsconimg(imgperfilregistro11, ps);
            PanelEditarUsuario.setVisible(true);
        }
    }

    @FXML
    public void pressbteliminar() {
        if (TableUsuarios.getSelectionModel().getSelectedItem() == null) {
            crearalertaerror("Seleccione un usuario de la tabla");
        } else {
            Usuarios uss = TableUsuarios.getSelectionModel().getSelectedItem();
            try {
                Connection con = DriverManager.getConnection(conexionbiblio, user, pswd);

                String st = String.format("delete from usuarios where DNI = '%s' ", uss.getDNI());
                Statement stat = con.createStatement();
                stat.execute(st);
                crearalertainfo("Usuario borrado");
                rellenarUsuarios();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void pressbteditarusuarios() {
        try {
            Connection con = DriverManager.getConnection(conexionbiblio, user, pswd);
            Statement stat = con.createStatement();
            if (imageruta == null) {
                String consul = String.format("Select img from usuarios where DNI = '%s'", txtdniupdate.getText());
                ResultSet rs4 = stat.executeQuery(consul);
                if (rs4.next()) {
                    imageruta = rs4.getString(1);
                }
            }
            String st = String.format("update usuarios set Nombre = '%s', img = '%s', Pswd = '%s', Telefono = '%s', Email = '%s' where DNI = '%S'", txtnombreUpdate.getText(), imageruta, txtpassUpdate.getText(), txttelefonoUpdate.getText(), txtemailUpdate.getText(), txtdniupdate.getText());
            stat.execute(st);
            crearalertainfo("Usuario Actualizado");
            cambiarpanel(panelactual, PanelUsuarios);
            rellenarUsuarios();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}