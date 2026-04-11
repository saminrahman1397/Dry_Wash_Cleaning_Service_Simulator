package org.example.drywashcleaningservicesimulator.Mark_2420189.Customer_Care_Representative;

import cse213.drycleaning.Mark_2420189.GenericFileManager;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.time.LocalDate;

public class AddServiceRequest_Controller
{
    @javafx.fxml.FXML
    private TextField locationField;
    @javafx.fxml.FXML
    private TextField customerIDField;
    @javafx.fxml.FXML
    private TextField customerNameField;
    @javafx.fxml.FXML
    private DatePicker date_picker;
    @javafx.fxml.FXML
    private ComboBox<String> serviceCombo;

    @javafx.fxml.FXML
    public void initialize() {
        serviceCombo.getItems().addAll("Regular Dry Cleaning","Garment Pressing Only","Wet Cleaning","Hand Wash Service");

    }


    @javafx.fxml.FXML
    public void addONA(ActionEvent actionEvent) {

        String selectedService = serviceCombo.getValue();
        Integer customerId =Integer.parseInt(customerIDField.getText());
        String customerName = customerNameField.getText();
        String location = locationField.getText();
        LocalDate date=date_picker.getValue();

        ObservableList<serviceRequest> serviceRequests_list = GenericFileManager.readAll(serviceRequest.class, "serviceRequest.bin");

        if(customerId==null||customerName.isEmpty()||selectedService.isEmpty()||location.isEmpty()||date==null){
            showAlert("Error", "Please fill all fields");
        }

        serviceRequest nSR = new serviceRequest(customerId,customerName,location,date,selectedService);
        serviceRequests_list.add(nSR);
        GenericFileManager.writeAll(serviceRequests_list, "serviceRequest.bin");
        showAlert("Success", "Service Request Added");

    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}