module com.mh.biblioteca {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.mh.biblioteca to javafx.fxml;
    exports com.mh.biblioteca;
}