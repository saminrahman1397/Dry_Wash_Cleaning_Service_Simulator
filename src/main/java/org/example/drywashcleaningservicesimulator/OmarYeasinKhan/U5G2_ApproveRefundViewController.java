package org.example.drywashcleaningservicesimulator.OmarYeasinKhan;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class U5G2_ApproveRefundViewController
{
    @javafx.fxml.FXML
    private TableColumn orderTC;
    @javafx.fxml.FXML
    private TableColumn paymentMethodTC;
    @javafx.fxml.FXML
    private TableView refundTV;
    @javafx.fxml.FXML
    private Label pendingLabel;
    @javafx.fxml.FXML
    private TableColumn RefundAmountTC;
    @javafx.fxml.FXML
    private TableColumn refundReasonTC;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private TableColumn orderTotalTC;
    @javafx.fxml.FXML
    private TableColumn requestDateTC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void submitDecisionOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void dashboardOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/drywashcleaningservicesimulator/OmarYeasinKhanFXML/StoreBranchManagerDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
    }
}