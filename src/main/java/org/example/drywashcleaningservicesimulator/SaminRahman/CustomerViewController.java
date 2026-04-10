package org.example.drywashcleaningservicesimulator.SaminRahman;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerViewController {
    @javafx.fxml.FXML
    public void logoutOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/drywashcleaningservicesimulator/loginView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void submitFeedBackOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void applyDiscountOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void trackStatusOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void placeOrderOnActionButton(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/drywashcleaningservicesimulator/SaminRahmanFXML/U1G1PlaceOrderForCleaningView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void cancelOrderOnActionButton(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/drywashcleaningservicesimulator/SaminRahmanFXML/U1G2CancelOrderView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void reportProblemOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewInvoiceOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void makePaymentOnActionButton(ActionEvent actionEvent) {
    }
}
