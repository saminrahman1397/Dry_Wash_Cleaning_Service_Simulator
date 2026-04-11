package org.example.drywashcleaningservicesimulator.OmarYeasinKhan;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class G3ReceivedController
{
    @javafx.fxml.FXML
    private TableView itemsTV;
    @javafx.fxml.FXML
    private TableColumn orderedQtyTC;
    @javafx.fxml.FXML
    private ComboBox purchaseOrderCB;
    @javafx.fxml.FXML
    private TextField receievedQtyTF;
    @javafx.fxml.FXML
    private TableColumn unitPriceTC;
    @javafx.fxml.FXML
    private Label orderTotalLabel;
    @javafx.fxml.FXML
    private TableColumn itemNameTC;
    @javafx.fxml.FXML
    private Label statusLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void confirmOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadOrderOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void dashboardOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/drywashcleaningservicesimulator/OmarYeasinKhanFXML/InventoryBranchManagerDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void setQtyOA(ActionEvent actionEvent) {
    }
}