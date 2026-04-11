package org.example.drywashcleaningservicesimulator;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class loginViewController {
    @javafx.fxml.FXML
    private TextField passwordTextField;
    @javafx.fxml.FXML
    private ComboBox<String> userTypeComboBox;
    @javafx.fxml.FXML
    private TextField emailTextField;
    private String pass;


    public void initialize(){
        userTypeComboBox.getItems().addAll("Customer","Front Desk Receptionist", "Operations Coordinator", "Customer Care Representative");
    }

    @javafx.fxml.FXML
    public boolean isValidLogin(){
        return (userTypeComboBox.getValue() != null) && (emailTextField.getText().equals("user123@gmail.com")) && (passwordTextField.getText().equals("12345678"));
    }
    public void loginButtonOnAction(ActionEvent actionEvent) throws IOException {
        if (isValidLogin()){
            if (userTypeComboBox.getValue().equals("Customer")){
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SaminRahmanFXML/CustomerView.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
                stage.setScene(scene);
            }
            else if (userTypeComboBox.getValue().equals("Front Desk Receptionist")){
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SaminRahmanFXML/FrontDeskReceptionistView.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
                stage.setScene(scene);
            }
            else if (userTypeComboBox.getValue().equals("Operations Coordinator")){
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/drywashcleaningservicesimulator/Mark_2420189/Customer_Care_Representative/customer_representative_dashboard.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
                stage.setScene(scene);
            }
            else if (userTypeComboBox.getValue().equals("Operations Coordinator")){
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/drywashcleaningservicesimulator/Mark_2420189/OperationsCoordinator/operationsCoordinatorDashboard.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
                stage.setScene(scene);
            }
        }
        else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("PLEASE INPUT PASSWORD AND EMAIL CORRECTLY AFTER CHOOSING USER");
            a.showAndWait();
        }

    }
}
