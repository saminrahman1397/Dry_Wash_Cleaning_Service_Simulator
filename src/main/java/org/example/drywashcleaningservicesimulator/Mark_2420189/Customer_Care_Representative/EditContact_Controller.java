package org.example.drywashcleaningservicesimulator.Mark_2420189.Customer_Care_Representative;

import cse213.drycleaning.Mark_2420189.GenericFileManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EditContact_Controller
{
    @javafx.fxml.FXML
    private TextField customerIDField;
    @javafx.fxml.FXML
    private Button updateButton;
    @javafx.fxml.FXML
    private TextField newPhoneField;
    ObservableList<Customer> CustomerList = FXCollections.observableArrayList();




    @javafx.fxml.FXML
    public void UpdateONA(ActionEvent actionEvent) {
        int customerID = Integer.parseInt(customerIDField.getText());
        CustomerList = GenericFileManager.readAll(Customer.class, "Customer.bin");

        for (Customer c : CustomerList) {
            if (customerID == c.getCustomerID()) {
                c.setContact(newPhoneField.getText());
                GenericFileManager.writeAll(CustomerList, "Customer.bin");
                showAlert("Success", "Contact Updated");

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
