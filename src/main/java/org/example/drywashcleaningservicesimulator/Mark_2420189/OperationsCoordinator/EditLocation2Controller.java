package org.example.drywashcleaningservicesimulator.Mark_2420189.OperationsCoordinator;
import cse213.drycleaning.Mark_2420189.GenericFileManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class EditLocation2Controller
{
    @javafx.fxml.FXML
    private TextField locationHoursTF;
    @javafx.fxml.FXML
    private TextField locationNameTF;
    @javafx.fxml.FXML
    private Label messageLabel;
    @javafx.fxml.FXML
    private TextArea locationAddressTA;
    Location editLocation;
    @javafx.fxml.FXML
    private AnchorPane mainPane;
    ObservableList<Location> locationList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
    }


    @javafx.fxml.FXML
    public void editButtonOA(ActionEvent actionEvent) throws IOException {
        messageLabel.setText("");
        String locationName = locationNameTF.getText();
        String locationAddress = locationAddressTA.getText();
        String operatingHours = locationHoursTF.getText();
        int locationId = editLocation.getLocationId();

        Location l = new Location(locationId,operatingHours ,locationAddress, locationName);
        locationList.add(l);
        GenericFileManager.writeAll(locationList, "Location.bin");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditLocation.fxml"));
        Node node = fxmlLoader.load();
        mainPane.getChildren().setAll(node);

        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Location update successfully");
        a.showAndWait();
    }

    public void populateFields(){
        locationAddressTA.setText(editLocation.getLocationAddress());
        locationNameTF.setText(editLocation.getLocationName());
        locationHoursTF.setText(editLocation.getOperatingHours());
    }
}