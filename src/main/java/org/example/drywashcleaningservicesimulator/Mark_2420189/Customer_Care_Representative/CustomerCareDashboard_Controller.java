package org.example.drywashcleaningservicesimulator.Mark_2420189.Customer_Care_Representative;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class CustomerCareDashboard_Controller
{
    @FXML
    private Button addServiceRequestButton;
    @FXML
    private Button deleteComplaintButton;
    @FXML
    private Button deleteRequestButton;
    @FXML
    private Button addFollowUpButton;
    @FXML
    private AnchorPane CustomerCareDashboard;
    @FXML
    private Button addComplaintButton;
    @FXML
    private Button editComplaintButton;
    @FXML
    private Button editContactButton;
    @FXML
    private Button viewAllComplaintsButton;

    @FXML
    public void initialize() {
    }

    @FXML
    public void deleteRequestONA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213/drycleaning/Mark_2420189/Customer_Care_Representative/delete_service_request.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) CustomerCareDashboard.getScene().getWindow();
        stage.setTitle("Customer Care - Delete Canceled Request");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void editComplaintONA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213/drycleaning/Mark_2420189/Customer_Care_Representative/edit_complaint.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) CustomerCareDashboard.getScene().getWindow();
        stage.setTitle("Customer Care - Edit Complaint");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void addFollowUpONA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213/drycleaning/Mark_2420189/Customer_Care_Representative/add_follow_up.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) CustomerCareDashboard.getScene().getWindow();
        stage.setTitle("Customer Care - Add Follow-Up Note");
        stage.setScene(scene);
        stage.show();
    }

    @Deprecated
    public void viewAllComplaintsONA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213/drycleaning/Mark_2420189/Customer_Care_Representative/view_complaints.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) CustomerCareDashboard.getScene().getWindow();
        stage.setTitle("Customer Care - View Complaints");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void deleteComplaintONA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213/drycleaning/Mark_2420189/Customer_Care_Representative/delete_complaint.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) CustomerCareDashboard.getScene().getWindow();
        stage.setTitle("Customer Care - Delete Complaint");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void addComplaintONA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213/drycleaning/Mark_2420189/Customer_Care_Representative/add_complaint.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) CustomerCareDashboard.getScene().getWindow();
        stage.setTitle("Customer Care - Add Complaint");
        stage.setScene(scene);
        stage.show();
    }



    @FXML
    public void editContactONA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213/drycleaning/Mark_2420189/Customer_Care_Representative/edit_contact.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) CustomerCareDashboard.getScene().getWindow();
        stage.setTitle("Customer Care - Edit Contact Number");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void addServiceRequestONA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213/drycleaning/Mark_2420189/Customer_Care_Representative/add_service_request.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) CustomerCareDashboard.getScene().getWindow();
        stage.setTitle("Customer Care - Add Service Request");
        stage.setScene(scene);
        stage.show();
    }



}