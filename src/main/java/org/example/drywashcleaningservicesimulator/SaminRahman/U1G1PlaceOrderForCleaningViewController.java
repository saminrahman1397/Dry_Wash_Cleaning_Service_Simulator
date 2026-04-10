package org.example.drywashcleaningservicesimulator.SaminRahman;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

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
    private TextField nameTextField;
    @javafx.fxml.FXML
    private ComboBox<String> garmentTypeComboBox;
    @javafx.fxml.FXML
    private TextField quantityTextField;
    @javafx.fxml.FXML
    private ComboBox<String> urgencyComboBox;

    public void initialize(){
        pickupTimeComboBox.getItems().addAll("Morning", "Afternoon", "Evening");
        serviceMethodComboBox.getItems().addAll("Wash", "Dry Clean", "Iron");
        garmentTypeComboBox.getItems().addAll("Shirt/T-Shirt","Pant/Panjabi","Sari","Suit/Blazer","Blanket");
        urgencyComboBox.getItems().addAll("Regular","Express");
    }

    public boolean validName(){
        if (nameTextField.getText().isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please enter your name!");
            a.showAndWait();
            return false;
        }
        return true;
    }
    public boolean validPhoneNumber(){
        if (phoneNumberTextField.getText().isEmpty() | phoneNumberTextField.getText().length() != 11){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please enter your phone Number correctly!");
            a.showAndWait();
            return false;
        }
        return true;
    }
    public boolean validAddress(){
        if (addressTextField.getText().isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please enter your Address!");
            a.showAndWait();
            return false;
        }
        return true;
    }
    public boolean validQuantity(){
        if (quantityTextField.getText().isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please enter your quantity!");
            a.showAndWait();
            return false;
        }
        else if((Integer.parseInt(quantityTextField.getText()) < 1)){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please enter positive quantity!");
            a.showAndWait();
            return false;
        }
        return true;
    }
    public boolean ComboBoxValidityCheck(){
        if ((serviceMethodComboBox.getValue() == null) && garmentTypeComboBox.getValue() == null && urgencyComboBox.getValue() == null && pickupTimeComboBox.getValue() == null){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please Choose the right options!");
            a.showAndWait();
            return false;
        }
        return true;
    }
    @javafx.fxml.FXML
    public void confirmOrderOnActionButton(ActionEvent actionEvent) {
        if(validAddress() && validName() && validPhoneNumber() && validQuantity() && ComboBoxValidityCheck()){


        }


    }

    @javafx.fxml.FXML
    public void showPriceOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void dashboardOnActionButton(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/drywashcleaningservicesimulator/SaminRahmanFXML/CustomerView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
    }
}
