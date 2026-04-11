package org.example.drywashcleaningservicesimulator.Mark_2420189.OperationsCoordinator;
import cse213.drycleaning.Mark_2420189.GenericFileManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class CreateLocationsController
{
    @javafx.fxml.FXML
    private TextField locationHoursTF;
    @javafx.fxml.FXML
    private TextField locationNameTF;
    @javafx.fxml.FXML
    private Label messageLabel;
    @javafx.fxml.FXML
    private TextArea locationAddressTA;

    ObservableList<Location> locationList = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    private TextField locationIdTF;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void addButtonOA(ActionEvent actionEvent) {

        messageLabel.setText("");
        String locationName = locationNameTF.getText();
        String locationAddress = locationAddressTA.getText();
        String operatingHours = locationHoursTF.getText();
        int locationId = Integer.parseInt(locationIdTF.getText());

        if (locationName.isEmpty()) {
            messageLabel.setText("Location Name cannot be empty");
            return;
        }

        Location newLocation = new Location(locationId,operatingHours ,locationAddress, locationName);
        locationList.add(newLocation);
        GenericFileManager.writeAll(locationList, "Location.bin");
        messageLabel.setText("Location added successfully");

    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("operationsCoordinatorDashboard.fxml"));
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Operations Coordinator Dashboard");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}