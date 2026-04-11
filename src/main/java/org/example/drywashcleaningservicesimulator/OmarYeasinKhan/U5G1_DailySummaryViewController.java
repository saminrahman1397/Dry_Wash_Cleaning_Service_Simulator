package org.example.drywashcleaningservicesimulator.OmarYeasinKhan;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class U5G1_DailySummaryViewController
{
    @javafx.fxml.FXML
    private Label inProgressOrdersLabel;
    @javafx.fxml.FXML
    private Label totalRevenLabel;
    @javafx.fxml.FXML
    private Label totalOrdersLabel;
    @javafx.fxml.FXML
    private Label pendingOrdersLabel;
    @javafx.fxml.FXML
    private Label completedOrdersLabel;
    @javafx.fxml.FXML
    private Label cancelledOrdersLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void dashboardOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/drywashcleaningservicesimulator/OmarYeasinKhanFXML/StoreBranchManagerDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
    }
}