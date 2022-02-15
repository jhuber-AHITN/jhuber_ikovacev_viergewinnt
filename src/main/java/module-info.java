module com.example.viergewinntv7 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    exports com.example.viergewinntv7.view;
    exports com.example.viergewinntv7.controller;
    exports com.example.viergewinntv7.model;


    opens com.example.viergewinntv7 to javafx.fxml;
    exports com.example.viergewinntv7;
}