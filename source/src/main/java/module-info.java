module app {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires mysql.connector.j;

    exports com.example.source.controller;
    opens com.example.source.controller to javafx.fxml;
    exports com.example.source;
    opens com.example.source to javafx.fxml;
    exports com.example.source.claseTabele;
    opens com.example.source.claseTabele to javafx.fxml;
    exports com.example.source.controller.ResurseUmane;
    opens com.example.source.controller.ResurseUmane to javafx.fxml;
    exports com.example.source.controller.Receptioner;
    opens com.example.source.controller.Receptioner to javafx.fxml;
}