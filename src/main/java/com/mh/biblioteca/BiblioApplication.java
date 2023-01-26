package com.mh.biblioteca;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BiblioApplication extends Application {

    private Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(BiblioApplication.class.getResource("biblio.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
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