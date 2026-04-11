package org.example.drywashcleaningservicesimulator.Mark_2420189.Customer_Care_Representative;

import cse213.drycleaning.Mark_2420189.GenericFileManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DeleteComplaint_Controller
{
    @javafx.fxml.FXML
    private Button searchButton;
    @javafx.fxml.FXML
    private Button deleteButton;
    @javafx.fxml.FXML
    private TextField customerIDField;
    ObservableList<Complaints> complaintsList = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {
    }



    @javafx.fxml.FXML
    public void SearchONA(ActionEvent actionEvent) {
        int customerID = Integer.parseInt(customerIDField.getText());
        complaintsList = GenericFileManager.readAll(Complaints.class, "complaints.bin");
        for (Complaints c : complaintsList) {
            if (customerID == c.getCustomerID())
                showAlert("Success", "Complaint found with given ID, Confirm by clicking Delete Button");

            else
                showAlert("Error", "Complaint Not found with given ID");

        }

    }

    @javafx.fxml.FXML
    public void DeleteONA(ActionEvent actionEvent) {
        int customerID = Integer.parseInt(customerIDField.getText());
        complaintsList = GenericFileManager.readAll(Complaints.class, "complaints.bin");

        boolean found = false;

        for (int i = 0; i < complaintsList.size(); i++) {
            if (complaintsList.get(i).getCustomerID() == customerID) {
                complaintsList.remove(i);
                found = true;
                break;
            }
        }

        if (found) {
            GenericFileManager.writeAll(complaintsList, "complaints.bin");
            showAlert("Success", "Complaint Deleted");
        } else {
            showAlert("Error", "Complaint not found");
        }
    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}