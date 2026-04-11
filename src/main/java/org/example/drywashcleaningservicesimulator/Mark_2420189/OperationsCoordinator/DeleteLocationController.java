package org.example.drywashcleaningservicesimulator.Mark_2420189.OperationsCoordinator;
import cse213.drycleaning.Mark_2420189.GenericFileManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DeleteLocationController
{
    @javafx.fxml.FXML
    private TableColumn<Location, String> addressTC;
    @javafx.fxml.FXML
    private TableColumn<Location, String> nameTC;
    @javafx.fxml.FXML
    private TableColumn<Location, Integer> numberTC;
    @javafx.fxml.FXML
    private TextField locationNameTF;
    @javafx.fxml.FXML
    private TableColumn<Location, Integer> idTC;
    @javafx.fxml.FXML
    private Label messageLabel;
    @javafx.fxml.FXML
    private TableView<Location> cleaningLocationTV;
    ObservableList<Location> locationList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {

        idTC.setCellValueFactory(new PropertyValueFactory<>("locationId"));
        nameTC.setCellValueFactory(new PropertyValueFactory<>("locationName"));
        addressTC.setCellValueFactory(new PropertyValueFactory<>("locationAddress"));
        numberTC.setCellValueFactory(new PropertyValueFactory<>("staffCount"));

    }

    @javafx.fxml.FXML
    public void loadButtonOA(ActionEvent actionEvent) {

        cleaningLocationTV.getItems().clear();
        messageLabel.setText("");

        String location = locationNameTF.getText();
        if (location.isEmpty()){
            messageLabel.setText("Please enter a location");
            return;
        }

        locationList = GenericFileManager.readAll(Location.class, "Location.bin");
        for (Location l : locationList){
            if (l.getLocationName().equals(location)){
                cleaningLocationTV.getItems().addAll(l);
            }
        }
        messageLabel.setText("Location Loaded");

    }


    @javafx.fxml.FXML
    public void deleteLocationButtonOA(ActionEvent actionEvent) {

        Location selectedLocation = cleaningLocationTV.getSelectionModel().getSelectedItem();
        if (selectedLocation == null) {
            messageLabel.setText("Please select a location to delete");
            return;
        }
        cleaningLocationTV.getItems().remove(selectedLocation);
        locationList.remove(selectedLocation);
        GenericFileManager.writeAll(locationList, "Location.bin");


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