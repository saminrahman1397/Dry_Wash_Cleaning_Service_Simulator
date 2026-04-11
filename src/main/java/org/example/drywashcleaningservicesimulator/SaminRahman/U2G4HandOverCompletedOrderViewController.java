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

import javax.print.DocFlavor;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class U2G4HandOverCompletedOrderViewController {
    @javafx.fxml.FXML
    private TableColumn<Order, String> orderIDTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Order,Double> totalCostTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Order,String> orderStatusTableColumn;
    @javafx.fxml.FXML
    private TableView<Order> handOverOrderTableView;
    @javafx.fxml.FXML
    private TextField orderIDTextField;
    @javafx.fxml.FXML
    private TableColumn<Order, LocalDate> pickupDateTableColumn;
    private ArrayList<Order> ordersList = new ArrayList<Order>();


    @javafx.fxml.FXML
    public void initialize(){
        orderIDTableColumn.setCellValueFactory(new PropertyValueFactory<Order,String>("orderID"));
        totalCostTableColumn.setCellValueFactory(new PropertyValueFactory<Order,Double>("totalCost"));
        pickupDateTableColumn.setCellValueFactory(new PropertyValueFactory<Order,LocalDate>("pickupDate"));
        orderStatusTableColumn.setCellValueFactory(new PropertyValueFactory<Order,String>("orderStatus"));
    }


    @javafx.fxml.FXML
    public void loadOrdersOnActionButton(ActionEvent actionEvent) {
        handOverOrderTableView.getItems().clear();
        ordersList.clear();
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
                    // Filtering for unpaid orders
                    if (!obj.getOrderStatus().equals("Cancelled")) {
                        handOverOrderTableView.getItems().add(obj);
                    }ordersList.add(obj);
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/drywashcleaningservicesimulator/SaminRahmanFXML/FrontDeskReceptionistView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void completeHandoverOnActionButton(ActionEvent actionEvent) {
        File file = new File("Data/orders.bin");
        boolean found = false;
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
                for(Order o: ordersList){
                    if(o.getOrderID().equals(orderIDTextField.getText())){
                        o.setOrderStatus("Completed");
                        found = true;
                        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                        a.setContentText("Handed over");
                        a.showAndWait();
                    }oos.writeObject(o);
                }
        }catch(Exception e ){
            e.printStackTrace();
        }
        if(!found){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Invalid Order ID");
            a.showAndWait();
        }


    }
}
