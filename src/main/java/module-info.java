module com.mh.biblioteca {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.controlsfx.controls;


    opens com.mh.biblioteca to javafx.fxml;
    exports com.mh.biblioteca;
}