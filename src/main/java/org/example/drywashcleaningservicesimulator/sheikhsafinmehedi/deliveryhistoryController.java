package org.example.drywashcleaningservicesimulator.sheikhsafinmehedi;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class deliveryhistoryController
{
    @javafx.fxml.FXML
    private TableColumn orderIDTableColumn;
    @javafx.fxml.FXML
    private TableColumn customerNameTableColumn;
    @javafx.fxml.FXML
    private TableColumn addressTableColumn;
    @javafx.fxml.FXML
    private TableColumn deliveredTableColumn;
    @javafx.fxml.FXML
    private TableView deliveryHistoryTableView;
    @javafx.fxml.FXML
    private TableColumn timeSlotTableColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("deliverydriverdashboard.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setScene(scene);

        stage.show();
    }
}