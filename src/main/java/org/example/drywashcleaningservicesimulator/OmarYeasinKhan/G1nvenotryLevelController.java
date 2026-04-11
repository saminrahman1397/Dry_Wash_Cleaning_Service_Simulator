package org.example.drywashcleaningservicesimulator.OmarYeasinKhan;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class G1nvenotryLevelController
{
    @javafx.fxml.FXML
    private AnchorPane inventoryTV;
    @javafx.fxml.FXML
    private TableColumn itemIDTC;
    @javafx.fxml.FXML
    private TableColumn nameTC;
    @javafx.fxml.FXML
    private TableColumn unitTC;
    @javafx.fxml.FXML
    private TableColumn minLevelTC;
    @javafx.fxml.FXML
    private TableColumn unitePriceTC;
    @javafx.fxml.FXML
    private TableColumn categoryTC;
    @javafx.fxml.FXML
    private TableColumn qtyTC;
    @javafx.fxml.FXML
    private Label noItemsLabel;
    @javafx.fxml.FXML
    private TableColumn maxLevelTC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void loadStockOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void dashboardOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/drywashcleaningservicesimulator/OmarYeasinKhanFXML/InventoryBranchManagerDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
    }
}