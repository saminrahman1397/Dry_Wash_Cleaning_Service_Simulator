package org.example.drywashcleaningservicesimulator.Mark_2420189.OperationsCoordinator;

import cse213.drycleaning.Mark_2420189.GenericFileManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.channels.GatheringByteChannel;

public class EditLocationController
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
    private TableColumn<Integer, String> idTC;
    @javafx.fxml.FXML
    private Label messageLabel;
    @javafx.fxml.FXML
    private TableView<Location> cleaningLocationTV;
    ObservableList<Location> locationList = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    private AnchorPane mainPane;

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
    public void editLocationButtonOA(ActionEvent actionEvent) throws IOException {

        Location selectedLocation = cleaningLocationTV.getSelectionModel().getSelectedItem();
        if (selectedLocation == null) {
            messageLabel.setText("Please select a location to edit");
            return;
        }

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditLocation2.fxml"));
        Node node = fxmlLoader.load();
        EditLocation2Controller nextController = fxmlLoader.getController();
        nextController.editLocation = selectedLocation;
        nextController.populateFields();
        locationList.remove(selectedLocation);
        nextController.locationList = locationList;
        mainPane.getChildren().setAll(node);
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