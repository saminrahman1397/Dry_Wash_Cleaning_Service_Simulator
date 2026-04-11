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
import java.time.LocalDate;

public class AddStaffController
{
    @javafx.fxml.FXML
    private TextField staffNameTF;
    @javafx.fxml.FXML
    private ComboBox<String> staffRoleCB;
    @javafx.fxml.FXML
    private DatePicker hireDateDP;
    @javafx.fxml.FXML
    private TextField staffPhoneTF;
    @javafx.fxml.FXML
    private TextField staffEmailTF;
    @javafx.fxml.FXML
    private Label messageLabel;

    @javafx.fxml.FXML
    private TextField staffIdTF;

    @javafx.fxml.FXML
    public void initialize() {
        staffRoleCB.getItems().addAll("Cleaning Technician", "Delivery Driver");
    }

    @javafx.fxml.FXML
    public void saveStaffButtonOA(ActionEvent actionEvent) {

        ObservableList<Staff> staffList = GenericFileManager.readAll(Staff.class, "Staff.bin");

        String staffName = staffNameTF.getText().trim();
        String staffRole = staffRoleCB.getValue();
        String staffPhone = staffPhoneTF.getText().trim();
        String staffEmail = staffEmailTF.getText().trim();
        LocalDate hireDate = hireDateDP.getValue();


        if (staffIdTF.getText().isEmpty()){
            messageLabel.setText("Staff ID cannot be empty");
            return;
        }
        int staffId = Integer.parseInt(staffIdTF.getText());
        Staff newStaff = new Staff(staffName, hireDate, staffRole, staffPhone, staffEmail, staffId);
        staffList.add(newStaff);
        GenericFileManager.writeAll(staffList, "Staff.bin");
        messageLabel.setText("Staff created successfully");

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