package org.example.drywashcleaningservicesimulator.Mark_2420189.Customer_Care_Representative;

import cse213.drycleaning.Mark_2420189.GenericFileManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class EditComplaint_Controller {
    @javafx.fxml.FXML
    private Button searchButton;
    @javafx.fxml.FXML
    private TextField customerIDField;
    @javafx.fxml.FXML
    private Button updateButton;
    @javafx.fxml.FXML
    private TextField newDescriptionField;
    ObservableList<Complaints> complaintsList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {

    }


    @javafx.fxml.FXML
    public void ONASearch(ActionEvent actionEvent) {
        int customerID = Integer.parseInt(customerIDField.getText());
        complaintsList = GenericFileManager.readAll(Complaints.class, "complaints.bin");
        for (Complaints c : complaintsList) {
            if (customerID == c.getCustomerID())
                showAlert("Success", "Complaint found with given ID, ADD new Description");
            else
                showAlert("Error", "Complaint Not found with given ID");

        }

    }

    @javafx.fxml.FXML
    public void UpdateONA(ActionEvent actionEvent) {
        int customerID = Integer.parseInt(customerIDField.getText());
        complaintsList = GenericFileManager.readAll(Complaints.class, "complaints.bin");

            for (Complaints c : complaintsList) {
                if (customerID == c.getCustomerID()) {
                    c.setComplaint_description(newDescriptionField.getText());
                    GenericFileManager.writeAll(complaintsList, "complaints.bin");
                    showAlert("Success", "Complaint Updated");

                    break;
                }
            }



    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}