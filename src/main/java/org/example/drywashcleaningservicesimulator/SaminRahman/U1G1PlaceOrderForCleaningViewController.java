package org.example.drywashcleaningservicesimulator.SaminRahman;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class U1G1PlaceOrderForCleaningViewController {
    @javafx.fxml.FXML
    private TextField phoneNumberTextField;
    @javafx.fxml.FXML
    private TextField addressTextField;
    @javafx.fxml.FXML
    private ComboBox<String> pickupTimeComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> serviceMethodComboBox;
    @javafx.fxml.FXML
    private DatePicker pickupDateDatePicker;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private ComboBox<String> garmentTypeComboBox;
    @javafx.fxml.FXML
    private TextField quantityTextField;

    public void initialize(){

    }
    @javafx.fxml.FXML
    public void dashboardOnActionButtton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void confirmOrderOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void showPriceOnActionButton(ActionEvent actionEvent) {
    }
}
