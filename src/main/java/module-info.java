module org.example.drywashcleaningservicesimulator {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.drywashcleaningservicesimulator to javafx.fxml;
    exports org.example.drywashcleaningservicesimulator;
}