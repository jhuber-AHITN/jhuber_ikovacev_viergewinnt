module com.example.viergewinntversuch5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.viergewinntversuch5 to javafx.fxml;
    exports com.example.viergewinntversuch5;
}