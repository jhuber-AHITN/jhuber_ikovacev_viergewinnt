module com.example.testaa {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.testaa to javafx.fxml;
    exports com.example.testaa;
}