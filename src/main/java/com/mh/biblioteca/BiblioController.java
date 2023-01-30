package com.mh.biblioteca;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class BiblioController {

    @FXML
    public ComboBox<String> cbgenero;

    @FXML
    public ComboBox<String> cbgeneroeditadmin;

    @FXML
    private TableColumn<?, ?> ColumApellidos;

    @FXML
    private TableColumn<?, ?> ColumContacDevoluciones;

    @FXML
    private TableColumn<?, ?> ColumDNI;

    @FXML
    private TableColumn<?, ?> ColumEstado;

    @FXML
    private TableColumn<?, ?> Columemail;

    @FXML
    private TableColumn<?, ?> Columtelefono;

    @FXML
    private AnchorPane Menu;

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
    private AnchorPane Paneladdlibros1;

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
    private TableView<?> TableUsuarios;

    @FXML
    private VBox Vboxadmin;

    @FXML
    private VBox Vboxusuario;

    @FXML
    private Button btbuscar;

    @FXML
    private Button btbuscarusuario1;

    @FXML
    private Button btbuscarusuario11;

    @FXML
    private Button btbuscarusuario111;

    @FXML
    private Button btcerrar;

    @FXML
    private Button btcerraraddlibros;

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
    private ImageView imgperfil;

    @FXML
    private ImageView imgperfil1;

    @FXML
    private ImageView imgperfil11;

    @FXML
    private ImageView imgperfil111;

    @FXML
    private ImageView imgperfil12;

    @FXML
    private ImageView imgperfil13;

    @FXML
    private ImageView imgperfil131;

    @FXML
    private ImageView imgperfil1311;

    @FXML
    private ImageView imgperfil13111;

    @FXML
    private ImageView imgperfil131111;

    @FXML
    private ImageView imgperfil2;

    @FXML
    private ImageView imgperfil21;

    @FXML
    private ImageView imgperfil211;

    @FXML
    private ImageView imgperfil2111;

    @FXML
    private ImageView imgperfil21111;

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
    private TextField txtbuscarusuario;

    @FXML
    private TextField txtbusquedas;

    @FXML
    private TextField txtcontrasenaregistro1;

    @FXML
    private TextField txtcontrasenaregistro11;

    @FXML
    private TextArea txtdescripcion;

    @FXML
    private TextArea txtdescripcion1;

    @FXML
    private TextField txtdniregistro1;

    @FXML
    private TextField txtdniregistro11;

    @FXML
    private TextField txteditorial;

    @FXML
    private TextField txtemailregistro1;

    @FXML
    private TextField txtemailregistro11;

    @FXML
    private TextField txtgenero;

    @FXML
    private TextField txtisbn;

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

    private boolean imgrellena;

    @FXML
    private TextField txttelefonoregistro;

    @FXML
    private TextField txttituloeditadmin;

    @FXML
    private TextField txtautoreditadmin;

    @FXML
    private TextField  txteditorialadmin;

    @FXML
    private TextField txtisbneditadmin;

    @FXML
    private TextArea txtdescripcioneditadmin;

    @FXML
    private TextField txtnombreregistro1;

    @FXML
    private TextField txtnombreregistro11;

    @FXML
    private TextField txttelefonoregistro1;

    @FXML
    private TextField txttelefonoregistro11;

    @FXML
    private TextField txttitulolibro;
    @FXML
    private Pane Panelverlibros;
    private Pane panelactual;

    private String fotobd;

    private boolean usuarioact = false;

    Button btnuevo;

    int ultimafila = 0;
    private final String conexionbiblio = "jdbc:mysql://localhost:3306/biblio";
    //Esta variable tiene el usuario con el que nos conectaremos a la base de datos
    private final String user = "root";
    //Esta es la contraseña del usuario anterior para conectarnos a la base de datos
    private final String pswd = "root";

    private Button bt;

    private boolean complogin;

    private String imageruta;

    private boolean compregister;

    ArrayList<Button> listabotones = new ArrayList<>();

    FileChooser fil_chooser = new FileChooser();
    Stage selec = new Stage();

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
            bdlibros();
            Panelveradmin.setVisible(false);
            PaneLibros.setVisible(true);
            bdlibros();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void pressbteditarlibros() {
        try {
            Connection con = DriverManager.getConnection(conexionbiblio, user, pswd);
            Statement stat = con.createStatement();
            if (imageruta==null){
                String consul = String.format("Select Foto from tabla_biblio where ISBN = '%s'", txtisbneditadmin.getText());
                ResultSet rs4 = stat.executeQuery(consul);
                if(rs4.next()){
                    imageruta = rs4.getString(1);
                }
            }

            String st = String.format("update TABLA_BIBLIO set Nombre = '%s', Foto = '%s', Genero = '%s', Autor = '%s', Editorial = '%s', Descripcion = '%s' where ISBN = '%S'", txttituloeditadmin.getText(),
                    imageruta, cbgeneroeditadmin.getSelectionModel().getSelectedItem(), txtautoreditadmin.getText(), txteditorialadmin.getText(), txtdescripcioneditadmin.getText(), txtisbneditadmin.getText());
            stat.execute(st);
            crearalertainfo("Libro actualizado");
            bdlibros();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void pressbtusuarios() {
        cambiarpanel(panelactual, PanelUsuarios);
        Panelsuperior.setStyle("-fx-opacity: 0.7");
    }

    @FXML
    public void SelectUsuario() {
    }

    @FXML
    public void pressbtbiblioteca() {
        bdlibros();
        cambiarpanel(PanelInicio, PaneLibros);
        Panelsuperior.setStyle("-fx-opacity: 1");
    }

    @FXML
    public void pressbtmislibros() {
        bdmislibros();
        cambiarpanel(PanelInicio, PaneLibros);
        Panelsuperior.setStyle("-fx-opacity: 1");
    }

    @FXML
    void pressbtbuscar() {

    }

    @FXML
    public void pressbtanadir() {
        // Agregar filtros para facilitar la busqueda
        fil_chooser.setTitle("Selecciona una imagen");
        fil_chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );

        File file = fil_chooser.showOpenDialog(selec);

        if (file != null) {
            if (PanelRegistro.isVisible()) {
                try {
                    Path source = file.toPath();
                    Image imagenem = new Image(String.valueOf(source));
                    imgperfilregistro1.setImage(imagenem);
                    Path target = Paths.get("src/main/resources/img/imgusers/" + file.getName());
                    Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if(Paneladdlibros.isVisible()){
                try {
                    Path source = file.toPath();
                    Image imagenem = new Image(String.valueOf(source));
                    imglibro.setImage(imagenem);
                    Path target = Paths.get("src/main/resources/img/imglibros/" + file.getName());
                    Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println(file.getName());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if(Panelveradmin.isVisible()){
                try {
                    Path source = file.toPath();
                    Image imagenem = new Image(String.valueOf(source));
                    imglibrover1.setImage(imagenem);
                    Path target = Paths.get("src/main/resources/img/imglibros/" + file.getName());
                    Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        assert file != null;
        String image = file.getPath();
        Image imagenem = new Image(image);
        imageruta = file.getName();
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
                ps2.setInt(7 , 0);
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

    @FXML
    void bdlibros() {
        int fil = 0;
        int col = 0;
        if (admin) {
            col = 1;
            btnuevo = new Button();
            Image imgnew = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/mas.png")));
            ImageView view1 = new ImageView();
            view1.setImage(imgnew);
            view1.setFitHeight(70);
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
            String consulta = "SELECT Nombre, Foto FROM TABLA_BIBLIO";
            ResultSet rs = st.executeQuery(consulta);

            // Recorrer los resultados obtenidos y mostrarlos en pantalla
            while (rs.next()) {
                String nombre = rs.getString("Nombre");
                String foto = rs.getString("Foto");
                fotobd = foto;
                bt = new Button();
                bt.setText(nombre);
                listabotones.add(bt);
                //bt.setId(nombre);
                System.out.println("Nombre Boton " + nombre);
                if (foto==null){
                    String consul = String.format("Select Foto from tabla_biblio where nombre = '%s'", nombre);
                    ResultSet rs4 = st.executeQuery(consul);
                    if(rs4.next()){
                        foto = rs4.getString(1);
                    }
                }
                Image img = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/imglibros/" + foto)));
                ImageView view = new ImageView();
                view.setImage(img);
                view.setFitHeight(200);
                view.setPreserveRatio(true);
                bt.setGraphic(view);
                bt.setContentDisplay(ContentDisplay.TOP);
                bt.setId("btslibros");
                bt.setMinWidth(200);
                bt.setMinHeight(270);
                bt.setMaxWidth(Control.USE_COMPUTED_SIZE);
                bt.setMaxHeight(270);
                bt.setOnAction(event -> {
                    System.out.println(bt.getText());
                    Panelverlibros.setVisible(true);
                    rellenartext(event);
                });
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

    void rellenartext(ActionEvent event){
        Button botonclick = (Button) event.getSource();
        if (admin) {
            try{
                Connection con = DriverManager.getConnection(conexionbiblio, user, pswd);
                Statement st2 = con.createStatement();
                for (int i = 0; i < listabotones.size() - 1; i++) {
                    System.out.println(listabotones.get(i).getText()+" Boton " + i);
                        String consulta2 = String.format("SELECT * FROM TABLA_BIBLIO where Nombre = '%s'", botonclick.getText());
                        System.out.println("ID= " + botonclick.getId());
                        ResultSet rs2 = st2.executeQuery(consulta2);
                        if(rs2.next()){
                            Panelverusuario.setVisible(false);
                            Panelveradmin.setVisible(true);
                            txttituloeditadmin.setText(rs2.getString(2));
                            cbgeneroeditadmin.getSelectionModel().select(rs2.getString(4));
                            txtautoreditadmin.setText(rs2.getString(5));
                            txteditorialadmin.setText(rs2.getString(6));
                            txtisbneditadmin.setText(rs2.getString(7));
                            txtisbneditadmin.setDisable(true);
                            txtdescripcioneditadmin.setText(rs2.getString(8));
                            Image imge = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/imglibros/"+rs2.getString(3))));
                            imglibrover1.setImage(imge);
                        }
                    }
            } catch (Exception ei){
                ei.printStackTrace();
            }

        } else {
            Panelverusuario.setVisible(true);
            Panelveradmin.setVisible(false);
        }
    }



    @FXML
    void bdmislibros() {
        int fil = 0;
        int col = 0;

        try {
            Connection con = DriverManager.getConnection(conexionbiblio, user, pswd);

            Statement st = con.createStatement();
            String consulta = "SELECT Nombre, Foto FROM TABLA_BIBLIO";
            ResultSet rs = st.executeQuery(consulta);

            // Recorrer los resultados obtenidos y mostrarlos en pantalla
            while (rs.next()) {
                String nombre = rs.getString("Nombre");
                String foto = rs.getString("Foto");
                bt = new Button();
                bt.setText(nombre);
                Image img = new Image(Objects.requireNonNull(getClass().getResourceAsStream(foto)));
                ImageView view = new ImageView();
                view.setImage(img);
                view.setFitHeight(200);
                view.setPreserveRatio(true);
                bt.setGraphic(view);
                bt.setContentDisplay(ContentDisplay.TOP);
                bt.setId("btslibros");
                bt.setMinWidth(200);
                bt.setMinHeight(270);
                bt.setMaxWidth(Control.USE_COMPUTED_SIZE);
                bt.setMaxHeight(270);
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void pressbtmenubusqueda() {
        Panelbusquedas.setVisible(true);
    }

    @FXML
    public void pressbtaddlibro() {
        try {
            Connection con = DriverManager.getConnection(conexionbiblio, user, pswd);

            PreparedStatement st = con.prepareStatement("insert into TABLA_BIBLIO (Nombre, Foto, Genero, Autor, Editorial, ISBN, Descripcion) values (?, ?, ?, ?, ?, ?, ?)");
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
            bdlibros();
        } catch(Exception e){
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
    }

    ObservableList<TextField> txtaddlibros = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        txtaddlibros.addAll(txttitulolibro, txtgenero, txtautor, txteditorial, txtisbn);
        panelactual = PanelIniciar;
        btmenu.setDisable(true);
        ObservableList<String> relleno = FXCollections.observableArrayList();

        relleno.addAll("Biografías", "Ciencia", "Cómics", "Filosofía", "Arte y Fotografía", "Cocina", "Deporte", "Drama", "Ficción", "Fantasía",
                "Humor", "Terror", "Viajes", "Thrillers", "Poesía", "Misterio", "Infantil", "Novelas");
        cbgenero.setItems(relleno);
        cbgeneroeditadmin.setItems(relleno);
    }

    @FXML
    public void pressbteditar() {

    }

    @FXML
    public void pressbteliminar() {

    }
}