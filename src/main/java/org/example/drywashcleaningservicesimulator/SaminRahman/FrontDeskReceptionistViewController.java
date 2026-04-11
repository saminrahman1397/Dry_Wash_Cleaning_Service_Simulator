package org.example.drywashcleaningservicesimulator.SaminRahman;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FrontDeskReceptionistViewController {
    @javafx.fxml.FXML
    public void handOverOrderOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void logoutOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/drywashcleaningservicesimulator/loginView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void handleDamageComplaintOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void updateOrderStatusOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void createNewOrderOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/drywashcleaningservicesimulator/SaminRahmanFXML/U2G1RegisterNewOrderView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void processPaymentOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void issueRefundOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void printOrderSummaryOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/drywashcleaningservicesimulator/SaminRahmanFXML/U2G2PrintOrderSummaryView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
    }
}
