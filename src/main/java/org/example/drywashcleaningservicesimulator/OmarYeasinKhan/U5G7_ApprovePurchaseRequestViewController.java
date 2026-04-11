package org.example.drywashcleaningservicesimulator.OmarYeasinKhan;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class U5G7_ApprovePurchaseRequestViewController
{
    @javafx.fxml.FXML
    private TableColumn totalAmountTC;
    @javafx.fxml.FXML
    private ComboBox decisionCB;
    @javafx.fxml.FXML
    private Label budgetRemainingLabel;
    @javafx.fxml.FXML
    private Label pendingCountLabel;
    @javafx.fxml.FXML
    private Label statusMessageLabel;
    @javafx.fxml.FXML
    private Label budgetSpentLabel;
    @javafx.fxml.FXML
    private TextArea itemSelectedTA;
    @javafx.fxml.FXML
    private Label budgetLabel;
    @javafx.fxml.FXML
    private TableView requestTableTV;
    @javafx.fxml.FXML
    private TableColumn requestDateTC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void submitDecisionOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void returnToDashBoardOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/drywashcleaningservicesimulator/OmarYeasinKhanFXML/StoreBranchManagerDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
    }

}