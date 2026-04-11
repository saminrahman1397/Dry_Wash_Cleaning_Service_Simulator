package org.example.drywashcleaningservicesimulator.SaminRahman;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class OrderSummaryViewController {
    @javafx.fxml.FXML
    private Label invoiceLabel;
    public void RecieveOrderObjectAndGenerateInvoice(Order order) {
        String summaryText = "========== ORDER SUMMARY ==========\n\n" +
                "CUSTOMER DETAILS:\n" +
                "Name: " + order.getCustomerName() + "\n" +
                "Phone: " + order.getPhoneNumber() + "\n" +
                "Address: " + order.getAddress() + "\n\n" +

                "JOB DETAILS:\n" +
                "Order ID: #" + order.getOrderID() + "\n" +
                "Garment: " + order.getGarmentType() + "\n" +
                "Service: " + order.getServiceMethod() + "\n" +
                "Urgency: " + order.getUrgency() + "\n\n" +

                "TIMING:\n" +
                "Order Date: " + order.getOrderDate() + "\n" +
                "Pickup Slot: " + order.getPickupTimeSlot() + "\n\n" +

                "FINANCIALS:\n" +
                "Total Bill: " + order.getTotalCost() + " BDT\n" +
                "Payment Status: " + order.getPaymentStatus() + "\n\n" +
                "===================================";
        invoiceLabel.setText(summaryText);
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/drywashcleaningservicesimulator/SaminRahmanFXML/U2G2PrintOrderSummaryView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
    }
}
