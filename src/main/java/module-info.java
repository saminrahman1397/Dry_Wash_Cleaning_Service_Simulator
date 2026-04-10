module org.example.drywashcleaningservicesimulator {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.drywashcleaningservicesimulator to javafx.fxml;
    opens org.example.drywashcleaningservicesimulator.SaminRahman to javafx.fxml;
    opens org.example.drywashcleaningservicesimulator.OmarYeasinKhan to javafx.fxml;
    exports org.example.drywashcleaningservicesimulator;
}