package com.mh.biblioteca;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

import static javafx.scene.layout.BorderStrokeStyle.*;

public class BiblioApplication extends Application {

    private Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(BiblioApplication.class.getResource("biblio.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Biblioteca MH");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public Stage getstage() {
        return stage;
    }

    public static void main(String[] args) {
        launch();
    }
}