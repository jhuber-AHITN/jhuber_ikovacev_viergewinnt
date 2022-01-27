module com.example.viergewinntv7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.viergewinntv7 to javafx.fxml;
    exports com.example.viergewinntv7;
}