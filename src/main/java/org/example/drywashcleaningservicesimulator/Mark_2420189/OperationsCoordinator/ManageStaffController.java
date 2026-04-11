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

public class ManageStaffController {

    @FXML
    private TableColumn<Staff, String> roleTC;
    @FXML
    private ComboBox<String> staffRoleCB;
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

    ObservableList<Staff> staffList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        idTC.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        roleTC.setCellValueFactory(new PropertyValueFactory<>("role"));
        isAssignedTC.setCellValueFactory(new PropertyValueFactory<>("available")); // Use "available" not "availability"

        staffRoleCB.getItems().addAll("Cleaning Technician", "Delivery Driver", "All");
        staffRoleCB.setValue("All"); // Set default value
    }

    @FXML
    public void loadStaffButtonOA(ActionEvent actionEvent) {
        staffTV.getItems().clear();
        messageLabel.setText("");

        staffList = GenericFileManager.readAll(Staff.class, "Staff.bin");

        String selectedRole = staffRoleCB.getValue();

        if (selectedRole == null || selectedRole.equals("All")) {
            staffTV.getItems().addAll(staffList);
        } else {
            for (Staff s : staffList) {
                if (s.getRole().equals(selectedRole)) {
                    staffTV.getItems().add(s);
                }
            }
        }

        messageLabel.setText("Staff Loaded");
    }

    @FXML
    public void deleteButtonOA(ActionEvent actionEvent) {
        Staff selectedStaff = staffTV.getSelectionModel().getSelectedItem();
        if (selectedStaff == null) {
            messageLabel.setText("Please select a staff to delete");
            return;
        }
        staffTV.getItems().remove(selectedStaff);
        staffList.remove(selectedStaff);
        GenericFileManager.writeAll(staffList, "Staff.bin");
        messageLabel.setText("Staff deleted successfully");
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