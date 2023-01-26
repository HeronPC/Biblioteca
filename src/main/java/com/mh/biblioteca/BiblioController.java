package com.mh.biblioteca;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.Window;

public class BiblioController {

    @FXML
    private AnchorPane Menu;

    @FXML
    private ScrollPane scrollpane;

    @FXML
    private AnchorPane Paneldesplegable;

    @FXML
    private AnchorPane Panelbusquedas;
    @FXML
    private GridPane gridlibros;

    @FXML
    private Button btbuscar;

    @FXML
    private Button btcuenta;

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
    private ImageView imgperfil;

    @FXML
    private ImageView imgperfil1;

    @FXML
    private ImageView imgperfil11;

    @FXML
    private ImageView imagenlibros;

    @FXML
    private ImageView imgperfil12;

    @FXML
    private ImageView imgperfil13;

    @FXML
    private TextField txtbusquedas;
    @FXML
    void cerrarmenubusquedas(MouseEvent event) {
        Panelbusquedas.setVisible(false);
    }

    @FXML
    void pressbtbuscar() {

    }
    int fil = 0;
    int col = 0;

    int ultimafila = 0;
    @FXML
    void pressbtanadir() {

        Button bt = new Button();
        bt.setStyle("-fx-background-color: black");

        bt.setPrefSize(200,270);
        bt.setMinWidth(Control.USE_PREF_SIZE);
        bt.setMinHeight(Control.USE_PREF_SIZE);
        bt.setMaxWidth(Control.USE_COMPUTED_SIZE);
        bt.setMaxHeight(Control.USE_PREF_SIZE);
        gridlibros.add(bt,col,fil);
        gridlibros.setPrefWidth(scrollpane.getPrefWidth());
        col++;
        ultimafila = fil+1;
        if(col==7){
            col=0;
            fil++;
        }
    }

    @FXML
    void pressbtmenubusqueda() {
        Panelbusquedas.setVisible(true);
        imagenlibros.setFitWidth(((Stage) imagenlibros.getScene().getWindow()).getWidth()*0.5);
        imagenlibros.setFitHeight(((Stage) imagenlibros.getScene().getWindow()).getHeight()*0.5);
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
}