package org.example.drywashcleaningservicesimulator;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class loginViewController {
    @javafx.fxml.FXML
    private TextField passwordTextField;
    @javafx.fxml.FXML
    private ComboBox<String> userTypeComboBox;
    @javafx.fxml.FXML
    private TextField emailTextField;
    private String pass;


    public void initialize(){
        userTypeComboBox.getItems().addAll("Customer","Front Desk Receptionist");
    }

    public boolean checkPasswordValidity(){

    }
    @javafx.fxml.FXML
    public void loginButtonOnAction(ActionEvent actionEvent) {
    }
}
