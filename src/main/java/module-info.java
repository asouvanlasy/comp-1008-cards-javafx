module com.example.week3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.CardsJavaFX to javafx.fxml;
    exports com.example.CardsJavaFX;
}