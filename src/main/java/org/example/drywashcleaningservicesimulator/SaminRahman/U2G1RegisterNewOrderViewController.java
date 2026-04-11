package org.example.drywashcleaningservicesimulator.SaminRahman;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.example.drywashcleaningservicesimulator.utilitySamin.OrderUtility;

import java.io.IOException;
import java.time.LocalDate;

public class U2G1RegisterNewOrderViewController {
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
    @javafx.fxml.FXML
    private TextArea specialInstructionsTextArea;

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

    public double calculateTotalCost() {
        double costPerItem = 0;
        //"Shirt/T-Shirt","Pant/Panjabi","Sari","Suit/Blazer","Blanket"
        if (garmentTypeComboBox.getValue().equals("Shirt/T-Shirt")) {
            costPerItem = 60;
        } else if (garmentTypeComboBox.getValue().equals("Pant/Panjabi")) {
            costPerItem = 80;
        } else if ((garmentTypeComboBox.getValue().equals("Sari"))) {
            costPerItem = 100;
        } else if ((garmentTypeComboBox.getValue().equals("Suit/Blazer"))) {
            costPerItem = 400;
        } else if ((garmentTypeComboBox.getValue().equals("Blanket"))) {
            costPerItem = 700;
        }
        double amount = Double.parseDouble(quantityTextField.getText());
        return amount * costPerItem;
    }
    @javafx.fxml.FXML
    public void confirmOrderOnActionButton(ActionEvent actionEvent) {
        if(validAddress() && validName() && validPhoneNumber() && validQuantity() && ComboBoxValidityCheck()){
            Order newOrder = new Order();
            String generatedID = OrderUtility.getNextOrderID();
            newOrder.setOrderID(generatedID);
            newOrder.setCustomerName(nameTextField.getText());
            newOrder.setPhoneNumber(phoneNumberTextField.getText());
            newOrder.setAddress(addressTextField.getText());
            newOrder.setServiceMethod(serviceMethodComboBox.getValue());
            newOrder.setGarmentType(garmentTypeComboBox.getValue());
            newOrder.setOrderDate(LocalDate.now());
            newOrder.setTotalCost(calculateTotalCost());
            if (urgencyComboBox.getValue().equals("Regular")){
                newOrder.setPickupDate(newOrder.getOrderDate().plusWeeks(1));
            }else{
                newOrder.setPickupDate(newOrder.getOrderDate().plusDays(4));
            }
            newOrder.setPickupTimeSlot(pickupTimeComboBox.getValue());
            newOrder.setSpecialInstructions(specialInstructionsTextArea.getText());
            newOrder.setUrgency(urgencyComboBox.getValue());

            OrderUtility.SaveOrder(newOrder);
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setContentText("Order Successfully Added, ID " + generatedID);
            a.showAndWait();

            nameTextField.clear();
            phoneNumberTextField.clear();
            addressTextField.clear();
            quantityTextField.clear();
            specialInstructionsTextArea.clear();
        }


    }

    @javafx.fxml.FXML
    public void showPriceOnActionButton(ActionEvent actionEvent) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Your Total will be " + calculateTotalCost());
        a.showAndWait();
    }

    @javafx.fxml.FXML
    public void dashboardOnActionButton(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/drywashcleaningservicesimulator/SaminRahmanFXML/FrontDeskReceptionistView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
    }
}