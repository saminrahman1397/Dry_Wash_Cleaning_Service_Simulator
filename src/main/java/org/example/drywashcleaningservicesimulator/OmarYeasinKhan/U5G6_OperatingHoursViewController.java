package org.example.drywashcleaningservicesimulator.OmarYeasinKhan;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class U5G6_OperatingHoursViewController
{
    @javafx.fxml.FXML
    private TextField openingTimeTF;
    @javafx.fxml.FXML
    private Label statusMessageLabel;
    @javafx.fxml.FXML
    private Label currentOpenLabel;
    @javafx.fxml.FXML
    private Label currentClosedLabel;
    @javafx.fxml.FXML
    private CheckBox isClosedCheckbox;
    @javafx.fxml.FXML
    private TextField closingTimeTF;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void saveButtonOA(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void dashboardOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/drywashcleaningservicesimulator/OmarYeasinKhanFXML/StoreBranchManagerDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
    }
}