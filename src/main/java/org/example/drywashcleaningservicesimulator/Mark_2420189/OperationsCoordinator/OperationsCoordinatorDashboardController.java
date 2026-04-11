package org.example.drywashcleaningservicesimulator.Mark_2420189.OperationsCoordinator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class OperationsCoordinatorDashboardController {

    @FXML
    private Button dailySummaryReportButton;
    @FXML
    private AnchorPane OperationsCoordinatorDashboard;
    @FXML
    private Button addStaffButton;
    @FXML
    private Button deleteStaffButton;
    @FXML
    private Button addLocationButton;
    @FXML
    private Button deleteLocationButton;
    @FXML
    private Button editStaffAssignmentButton;
    @FXML
    private Button editLocationButton;
    @FXML
    private Button logoutButton;
    @FXML
    private Button staffAvailabilityButton;

    private Stage currentStage;

    @FXML
    public void initialize() {
        // Don't try to get the stage here - it's not ready yet
        // Use Platform.runLater to get the stage after the scene is set
        javafx.application.Platform.runLater(() -> {
            if (OperationsCoordinatorDashboard.getScene() != null) {
                currentStage = (Stage) OperationsCoordinatorDashboard.getScene().getWindow();
            }
        });
    }

    @FXML
    public void addLocationONA(ActionEvent actionEvent) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("CreateLocation.fxml"));
            Stage stage = (Stage) addLocationButton.getScene().getWindow();
            stage.setScene(new Scene(root, 600, 400));
            stage.setTitle("Add New Cleaning Location");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void editLocationONA(ActionEvent actionEvent) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("EditLocation.fxml"));
            Stage stage = (Stage) editLocationButton.getScene().getWindow();
            stage.setScene(new Scene(root, 600, 400));
            stage.setTitle("Edit Existing Location");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void deleteLocationONA(ActionEvent actionEvent) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("DeleteLocation.fxml"));
            Stage stage = (Stage) deleteLocationButton.getScene().getWindow();
            stage.setScene(new Scene(root, 600, 400));
            stage.setTitle("Delete Cleaning Location");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void addStaffONA(ActionEvent actionEvent) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("AddStaff.fxml"));
            Stage stage = (Stage) addStaffButton.getScene().getWindow();
            stage.setScene(new Scene(root, 600, 400));
            stage.setTitle("Add New Staff Member");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void deleteStaffONA(ActionEvent actionEvent) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("ManageStaff.fxml"));
            Stage stage = (Stage) deleteStaffButton.getScene().getWindow();
            stage.setScene(new Scene(root, 600, 400));
            stage.setTitle("Delete Staff Member");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void editStaffAssignmentONA(ActionEvent actionEvent) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("LocationStaffAssignment.fxml"));
            Stage stage = (Stage) editStaffAssignmentButton.getScene().getWindow();
            stage.setScene(new Scene(root, 600, 400));
            stage.setTitle("Edit Staff Assignment for Location");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void dailySummaryReportONA(ActionEvent actionEvent) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("DailySummaryReport.fxml"));
            Stage stage = (Stage) dailySummaryReportButton.getScene().getWindow();
            stage.setScene(new Scene(root, 600, 400));
            stage.setTitle("Daily Summary Report");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void staffAvailabilityONA(ActionEvent actionEvent) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("StaffAvailibility.fxml"));
            Stage stage = (Stage) staffAvailabilityButton.getScene().getWindow();
            stage.setScene(new Scene(root, 600, 400));
            stage.setTitle("Monitor & Update Staff Availability");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void logoutONA(ActionEvent actionEvent) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("/cse213/drycleaning/login.fxml"));
            Stage stage = (Stage) logoutButton.getScene().getWindow();
            stage.setScene(new Scene(root, 600, 400));
            stage.setTitle("Dry Cleaning Management System - Login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}