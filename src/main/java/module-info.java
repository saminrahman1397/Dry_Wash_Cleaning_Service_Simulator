module org.example.drywashcleaningservicesimulator {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires java.desktop;
    requires javafx.graphics;


    opens org.example.drywashcleaningservicesimulator to javafx.fxml;
    opens org.example.drywashcleaningservicesimulator.SaminRahman to javafx.fxml, javafx.base;
    opens org.example.drywashcleaningservicesimulator.OmarYeasinKhan to javafx.fxml, javafx.base;
    opens org.example.drywashcleaningservicesimulator.utility to javafx.fxml;
    exports org.example.drywashcleaningservicesimulator;
    exports org.example.drywashcleaningservicesimulator.SaminRahman;
    exports org.example.drywashcleaningservicesimulator.OmarYeasinKhan;
}