package com.mh.biblioteca;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import java.util.Objects;

import static javafx.scene.input.KeyCode.R;

public class BiblioController { ;

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
    private ImageView imgperfilregistro1;

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
    private TextField txtnombreregistro1;

    @FXML
    private TextField txtnombreregistro11;

    @FXML
    private TextField txttelefonoregistro1;

    @FXML
    private TextField txttelefonoregistro11;

    @FXML
    private TextField txttitulolibro;
    private Pane panelactual;

    public Boolean admin = true;//Debes hacer la consulta al acceder para determinar si es admin o no

    private void cambiarpanel(Pane panel1, Pane panel2) {
        panel1.setVisible(false);
        panel2.setVisible(true);
        panelactual = panel2;
    }
    private void limpiarcampos(ObservableList<TextField> limpiar){
        for (int i = 0; i < limpiar.size() ; i++) {
            limpiar.get(i).clear();
        }
        txtdescripcion.clear();
        imglibro.setImage(null);
    }
    @FXML
    public void pressbtacceder() {
        btmenu.setDisable(false);
        PanelIniciar.setVisible(false);
        Panebienvenida.setVisible(true);
        panelactual=PanelInicio;
        if(admin==true){
            cambiarpanel(Vboxusuario,Vboxadmin);
        } else if (admin==false) {
            cambiarpanel(Vboxadmin,Vboxusuario);
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
        cambiarpanel(panelactual,PanelRegistro);
    }
    @FXML
    public void cerrarregistro(ActionEvent actionEvent) {
        cambiarpanel(panelactual,PanelIniciar);
    }
    @FXML
    public void cerrar(ActionEvent event) {
        Button botonclick = (Button) event.getSource();
        botonclick.getParent().setVisible(false);
        limpiarcampos(txtaddlibros);
    }
    @FXML
    public void pressbtalquilar() {
    }
    @FXML
    void cerrarmenubusquedas(MouseEvent event) {
        Panelbusquedas.setVisible(false);
    }
    @FXML
    public void pressbtbuscarusuario() {
    }
    @FXML
    public void pressbteliminar() {
    }
    @FXML
    public void pressbteditar() {
        PanelEditarUsuario.setVisible(true);
    }
    @FXML
    public void pressbtusuarios() {
        cambiarpanel(panelactual,PanelUsuarios);
        Panelsuperior.setStyle("-fx-opacity: 0.7");
    }
    @FXML
    public void SelectUsuario() {
    }
    @FXML
    public void pressbtbiblioteca() {
        bdlibros();
        cambiarpanel(PanelInicio,PaneLibros);
        Panelsuperior.setStyle("-fx-opacity: 1");
    }
    @FXML
    public void pressbtmislibros() {
        bdmislibros();
        cambiarpanel(PanelInicio,PaneLibros);
        Panelsuperior.setStyle("-fx-opacity: 1");
    }
    @FXML
    void pressbtbuscar() {

    }
    Button btnuevo;

    int ultimafila = 0;
    private final String conexion = "jdbc:mysql://localhost:3306/biblio";
    //Esta variable tiene el usuario con el que nos conectaremos a la base de datos
    private final String user = "root";
    //Esta es la contraseña del usuario anterior para conectarnos a la base de datos
    private final String pswd = "1492";

    public Button bt;
    FileChooser fil_chooser = new FileChooser();
    Stage selec = new Stage();
    @FXML
    void pressbtanadir() {
        // Agregar filtros para facilitar la busqueda
        fil_chooser.setTitle("Selecciona una imagen");
        fil_chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );

        File file = fil_chooser.showOpenDialog(selec);

        if (file != null) {
            try {
                Path source = file.toPath();
                Image imagenem = new Image(String.valueOf(source));
                imglibro.setImage(imagenem);
                Path target = Paths.get("src/main/resources/img/imglibros/" + file.getName());
                Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        String image = file.getPath();
        Image imagenem = new Image(image);
        System.out.println(image);


    }
    @FXML
    void bdlibros() {
        int fil = 0;
        int col = 0;
        if(admin==true){
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
            btnuevo.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {Paneladdlibros.setVisible(true);}
            });
            gridlibros.add(btnuevo,0,0);
        }
        
        
        gridlibros.setPrefWidth(scrollpane.getPrefWidth());
        try{
            Connection con = DriverManager.getConnection(conexion, user, pswd);

            Statement st = con.createStatement();
            String consulta = String.format("SELECT Nombre, Foto FROM TABLA_BIBLIO");
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
                gridlibros.add(bt,col,fil);
                gridlibros.setPrefWidth(scrollpane.getPrefWidth());
                col++;
                ultimafila = fil+1;
                if(col==6){
                    col=0;
                    fil++;
                }
                bt.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println(bt.getText());
                    }
                });
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @FXML
    void bdmislibros() {
        int fil = 0;
        int col = 0;

        try{
            Connection con = DriverManager.getConnection(conexion, user, pswd);

            Statement st = con.createStatement();
            String consulta = String.format("SELECT Nombre, Foto FROM TABLA_BIBLIO");
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
                gridlibros.add(bt,col,fil);
                gridlibros.setPrefWidth(scrollpane.getPrefWidth());
                col++;
                ultimafila = fil+1;
                if(col==6){
                    col=0;
                    fil++;
                }
                bt.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println(bt.getText());
                    }
                });
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
    public void pressbtaddlibro(ActionEvent actionEvent) {

    }

    @FXML
    public void cerrarmenu(){
        Paneldesplegable.setVisible(false);
    }
    @FXML
    public void pressbtmenu(){
        Paneldesplegable.setVisible(true);
    }
    @FXML
    protected void onHelloButtonClick() {
    }
    ObservableList<TextField> txtaddlibros = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        txtaddlibros.addAll(txttitulolibro,txtgenero,txtautor,txteditorial,txtisbn);
        panelactual=PanelIniciar;
        btmenu.setDisable(true);
    }
}