package org.example.drywashcleaningservicesimulator.SaminRahman;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;

public class U1G5TrackOrderStatusViewController {

    @javafx.fxml.FXML
    private TableColumn<Order,String> orderIDTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Order,Double> totalCostTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Order, LocalDate> pickupDateTableColumn;
    @javafx.fxml.FXML
    private TableView<Order> trackStatusTableView;
    @javafx.fxml.FXML
    private TextField orderIDTextField;

    @javafx.fxml.FXML
    public void initialize(){
        orderIDTableColumn.setCellValueFactory(new PropertyValueFactory<Order,String>("orderID"));
        totalCostTableColumn.setCellValueFactory(new PropertyValueFactory<Order,Double>("totalCost"));
        pickupDateTableColumn.setCellValueFactory(new PropertyValueFactory<Order,LocalDate>("pickupDate"));
    }
    @javafx.fxml.FXML
    public void loadOrdersOnActionButton(ActionEvent actionEvent) {
        trackStatusTableView.getItems().clear();
        File file = new File("Data/orders.bin");
        if (!file.exists()) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("No orders file found.");
            a.showAndWait();
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    Order obj = (Order) ois.readObject();
                    if (!obj.getOrderStatus().equals("Cancelled")) {
                        trackStatusTableView.getItems().add(obj);
                    }
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @javafx.fxml.FXML
    public void dashboardOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/drywashcleaningservicesimulator/SaminRahmanFXML/CustomerView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void checkStatusOnActionButton(ActionEvent actionEvent) {
        boolean found = false;
        File file = new File("Data/orders.bin");
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            while (true) {
                try {
                    Order obj = (Order) ois.readObject();
                    if (obj.getOrderID().equals(orderIDTextField.getText())) {
                        Alert a = new Alert(Alert.AlertType.INFORMATION);
                        a.setContentText("Your order is " + obj.getOrderStatus());
                        a.showAndWait();
                    }
                }catch(EOFException e){
                    break;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
