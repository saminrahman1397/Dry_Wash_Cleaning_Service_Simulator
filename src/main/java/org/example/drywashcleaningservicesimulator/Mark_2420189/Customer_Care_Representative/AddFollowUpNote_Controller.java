package org.example.drywashcleaningservicesimulator.Mark_2420189.Customer_Care_Representative;

import cse213.drycleaning.Mark_2420189.GenericFileManager;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddFollowUpNote_Controller
{
    @javafx.fxml.FXML
    private Button submitButton;
    @javafx.fxml.FXML
    private TextField customerIDField;
    @javafx.fxml.FXML
    private TextField customerNameField;
    @javafx.fxml.FXML
    private TextArea followUpNoteArea;

    @javafx.fxml.FXML
    public void initialize() {
    }


    @javafx.fxml.FXML
    public void addNoteONA(ActionEvent actionEvent) {
        int customerId=Integer.parseInt(customerIDField.getText());
        String customerName = customerNameField.getText();
        String followUpNote=followUpNoteArea.getText();
        ObservableList<Customer> FollowUpList = GenericFileManager.readAll(Customer.class, "Customer.bin");

        if(customerIDField.getText().isEmpty()||customerName.isEmpty()||followUpNote.isEmpty()){
            showAlert("Error", "Please fill all fields");
        }

        Customer nC = new Customer(customerName,followUpNote,"0",customerId);
        FollowUpList.add(nC);
        GenericFileManager.writeAll(FollowUpList, "Customer.bin");
        showAlert("Success", "Follow Up Added");

    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }





}