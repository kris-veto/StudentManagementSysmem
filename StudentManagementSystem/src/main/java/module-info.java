module org.example.week2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.week2 to javafx.fxml;
    exports org.example.week2;
}