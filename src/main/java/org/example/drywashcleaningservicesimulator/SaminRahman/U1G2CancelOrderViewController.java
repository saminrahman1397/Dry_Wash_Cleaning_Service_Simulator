package org.example.drywashcleaningservicesimulator.SaminRahman;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class U1G2CancelOrderViewController {
    @javafx.fxml.FXML
    private TableColumn<Order, String> orderIDTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Order, String> statusTableColumn;
    @javafx.fxml.FXML
    private TextField orderIDtoCancelTextField;
    @javafx.fxml.FXML
    private TableView<Order> myOrdersTableView;
    @javafx.fxml.FXML
    private TableColumn<Order, LocalDate> orderDateTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Order,String> garmentTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Order,Double> costTableColumn;

    @javafx.fxml.FXML
    public void myOrdersOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void dashboardOnActionButton(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/drywashcleaningservicesimulator/SaminRahmanFXML/CustomerView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void cancelOrderOnActionButton(ActionEvent actionEvent) {
    }
}
