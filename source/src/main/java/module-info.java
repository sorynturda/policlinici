module com.example.source {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires mysql.connector.j;

    opens com.example.source to javafx.fxml;
    exports com.example.source;
    exports com.example.source.controller;
    opens com.example.source.controller to javafx.fxml;
}