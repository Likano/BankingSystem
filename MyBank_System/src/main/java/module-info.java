module com.example.mybank_system {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.mybank_system to javafx.fxml;
    exports com.example.mybank_system;
}