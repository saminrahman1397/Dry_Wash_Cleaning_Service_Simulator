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

public class StaffAvailabilityController
{
    @FXML
    private TableColumn<Staff, String> staffNameColumn;
    @FXML
    private TableColumn<Staff, Boolean> availabilityColumn;
    @FXML
    private TableView<Staff> staffTable;
    @FXML
    private TableColumn<Staff, Integer> staffIDColumn;
    @FXML
    private TableColumn<Staff, String> staffRoleColumn;
    @FXML
    private Label messageLabel;

    private ObservableList<Staff> assignedStaffList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        staffIDColumn.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        staffNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        staffRoleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
        availabilityColumn.setCellValueFactory(new PropertyValueFactory<>("available"));
    }

    @FXML
    public void loadAssignedButtonOA(ActionEvent actionEvent) {
        staffTable.getItems().clear();

        ObservableList<Staff> allStaff = GenericFileManager.readAll(Staff.class, "Staff.bin");
        assignedStaffList.clear();

        for (Staff s : allStaff) {
            if (!s.isAvailable()) {
                assignedStaffList.add(s);
            }
        }

        staffTable.setItems(assignedStaffList);
        messageLabel.setText("Loaded " + assignedStaffList.size() + " assigned staff");
    }

    @FXML
    public void toggleAvailabilityButtonOA(ActionEvent actionEvent) {
        Staff selectedStaff = staffTable.getSelectionModel().getSelectedItem();

        ObservableList<Staff> allStaff = GenericFileManager.readAll(Staff.class, "Staff.bin");

        for (Staff s : allStaff) {
            if (s.getStaffId() == selectedStaff.getStaffId()) {
                s.setAvailable(true);
                break;
            }
        }

        ObservableList<Location> allLocations = GenericFileManager.readAll(Location.class, "Location.bin");

        for (Location loc : allLocations) {
            if (loc.getLocationId() == selectedStaff.getLocationId()) {
                loc.setStaffCount(loc.getStaffCount() - 1);
                break;
            }
        }

        GenericFileManager.writeAll(allStaff, "Staff.bin");
        GenericFileManager.writeAll(allLocations, "Location.bin");

        assignedStaffList.remove(selectedStaff);
        staffTable.refresh();

        messageLabel.setText("Toggled availability for " + selectedStaff.getName());
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