package org.example.drywashcleaningservicesimulator.Mark_2420189.OperationsCoordinator;

import cse213.drycleaning.Mark_2420189.GenericFileManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashSet;

public class LocationStaffAssignmentController
{
    @FXML
    private TableColumn<Staff, String> nameTC;
    @FXML
    private TableColumn<Staff, Boolean> isAssignedTC;
    @FXML
    private TableView<Staff> staffTV;
    @FXML
    private TableColumn<Staff, Integer> idTC;
    @FXML
    private Label messageLabel;
    @FXML
    private ComboBox<String> locationCB;

    private ObservableList<Staff> availableStaffList = FXCollections.observableArrayList();
    private ObservableList<Location> locationList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        idTC.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        isAssignedTC.setCellValueFactory(new PropertyValueFactory<>("available"));


        loadLocations();
    }

    private void loadLocations() {
        try {

            ObservableList<Location> allLocations = GenericFileManager.readAll(Location.class, "Location.bin");

            if (allLocations != null && !allLocations.isEmpty()) {
                locationList.clear();
                locationList.addAll(allLocations);


                HashSet<String> uniqueLocations = new HashSet<>();
                for (Location loc : locationList) {
                    if (loc.getLocationName() != null && !loc.getLocationName().isEmpty()) {
                        uniqueLocations.add(loc.getLocationName());
                    }
                }

                locationCB.getItems().clear();
                locationCB.getItems().addAll(uniqueLocations);

                if (!uniqueLocations.isEmpty()) {
                    locationCB.setValue(uniqueLocations.iterator().next());
                }
            } else {
                messageLabel.setText("No locations found in Location.bin");
            }
        } catch (Exception e) {
            messageLabel.setText("Error loading locations: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    public void loadUnassignedStaffButtonOA(ActionEvent actionEvent) {
        try {
            staffTV.getItems().clear();
            messageLabel.setText("");


            ObservableList<Staff> allStaff = GenericFileManager.readAll(Staff.class, "Staff.bin");
            availableStaffList.clear();

            if (allStaff != null && !allStaff.isEmpty()) {

                for (Staff s : allStaff) {
                    if (s.isAvailable()) {
                        availableStaffList.add(s);
                    }
                }

                staffTV.setItems(availableStaffList);
                messageLabel.setText("Loaded " + availableStaffList.size() + " unassigned staff members");
            } else {
                messageLabel.setText("No staff records found");
            }

        } catch (Exception e) {
            messageLabel.setText("Error loading staff: " + e.getMessage());
            e.printStackTrace();
        }
    }
    Staff theStaff;
    Location theLocation;
    @FXML
    public void assignButtonOA(ActionEvent actionEvent) {

        Staff selectedStaff = staffTV.getSelectionModel().getSelectedItem();
        String selectedLocation = locationCB.getValue();

        if (selectedStaff == null) {
            messageLabel.setText("Please select a staff member from the table");
            return;
        }

        if (selectedLocation == null || selectedLocation.isEmpty()) {
            messageLabel.setText("Please select a location from the dropdown");
            return;
        }

        try {

            ObservableList<Staff> allStaff = GenericFileManager.readAll(Staff.class, "Staff.bin");
            boolean staffUpdated = false;

            for (Staff s : allStaff) {
                if (s.getStaffId() == selectedStaff.getStaffId()) {
                    s.setAvailable(false);
                    theStaff = s;
                    staffUpdated = true;
                    break;
                }
            }

            if (!staffUpdated) {
                messageLabel.setText("Staff not found in database");
                return;
            }


            ObservableList<Location> allLocations = GenericFileManager.readAll(Location.class, "Location.bin");
            boolean locationUpdated = false;

            for (Location loc : allLocations) {
                if (loc.getLocationName().equals(selectedLocation)) {
                    loc.setStaffCount(loc.getStaffCount() + 1);
                    locationUpdated = true;
                    theLocation = loc;
                    break;
                }
            }

            if (!locationUpdated) {
                messageLabel.setText("Location not found in database");
                return;
            }


            GenericFileManager.writeAll(allStaff, "Staff.bin");
            GenericFileManager.writeAll(allLocations, "Location.bin");


            availableStaffList.remove(selectedStaff);
            staffTV.refresh();

            messageLabel.setText("Successfully assigned " + selectedStaff.getName() + " to " + selectedLocation);

        } catch (Exception e) {
            messageLabel.setText("Error during assignment: " + e.getMessage());
            e.printStackTrace();
        }

        theStaff.setLocationId(theLocation.getLocationId());
    }

    @FXML
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