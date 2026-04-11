package org.example.drywashcleaningservicesimulator.Mark_2420189.Customer_Care_Representative;

import cse213.drycleaning.Mark_2420189.GenericFileManager;
//import org.example.drywashcleaningservicesimulator.Mark_2420189.OperationsCoordinator.Staff;
//import org.example.drywashcleaningservicesimulator.Mark_2420189.OperationsCoordinator.Staff;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class AddComplaint_Controller
{
    @javafx.fxml.FXML
    private Button submitButton;
    @javafx.fxml.FXML
    private TextField customerIDField;
    @javafx.fxml.FXML
    private TextField complaintDescriptionField;

    @javafx.fxml.FXML
    public void initialize() {
    }


    @javafx.fxml.FXML
    public void addONA(ActionEvent actionEvent) {
        ObservableList<Complaints> complaints_list = GenericFileManager.readAll(Complaints.class, "Complaints.bin");

        Integer customerID =  Integer.parseInt(customerIDField.getText());
        String description = complaintDescriptionField.getText();

        if(customerID==null||description.isEmpty()){
            showAlert("Error", "Please fill all fields");
        }

        Complaints newcomplaints = new Complaints(customerID,description, LocalDate.now());
        complaints_list.add(newcomplaints);
        GenericFileManager.writeAll( complaints_list, "Complaints.bin");
        showAlert("Success", "Complaint Added");



    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}