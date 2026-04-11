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
import java.util.ArrayList;

public class U2G3ProcessPaymentAtCounterController {
    @javafx.fxml.FXML
    private TableColumn<Order,String> orderIDTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Order,Double> totalCostTableColumn;
    @javafx.fxml.FXML
    private TableView<Order> ordersTableView;
    @javafx.fxml.FXML
    private TableColumn<Order,String> paymentStatusTableColumn;
    @javafx.fxml.FXML
    private TextField enterIDTextField;
    @javafx.fxml.FXML
    private TextField moneyTextField;
    private ArrayList<Order> ordersList = new ArrayList<Order>();
    @javafx.fxml.FXML
    public void initialize(){
        orderIDTableColumn.setCellValueFactory(new PropertyValueFactory<Order,String>("orderID"));
        paymentStatusTableColumn.setCellValueFactory(new PropertyValueFactory<Order,String>("paymentStatus"));
        totalCostTableColumn.setCellValueFactory(new PropertyValueFactory<Order,Double>("totalCost"));
    }
    @javafx.fxml.FXML
    public void loadOrdersOnActionButton(ActionEvent actionEvent) {
        ordersTableView.getItems().clear();
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
                        ordersTableView.getItems().add(obj);
                    }
                    ordersList.add(obj);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void makePaymentOnActionButton(ActionEvent actionEvent) {
        File file = new File("Data/orders.bin");
        boolean found = false;
        double amount = 0;
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
            for(Order o : ordersList){
                if(o.getOrderID().equals(enterIDTextField.getText())){
                    found = true;
                    if(Double.parseDouble(moneyTextField.getText())>= o.getTotalCost()){
                        amount = (Double.parseDouble(moneyTextField.getText()) - o.getTotalCost());
                        o.setPaymentStatus("paid");
                        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                        a.setContentText("PAYMENT SUCCESSFUL, PAY BACK + " + amount + "tk");
                        a.showAndWait();
                    }else{
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setContentText("GIVE VALID AMOUNT!");
                        a.showAndWait();
                        return;
                    }

                }oos.writeObject(o);
            }
        }catch(Exception a){
            a.printStackTrace();
        }
        if(!found){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("GIVE VALID ORDER ID!");
            a.showAndWait();
        }
    }

    @javafx.fxml.FXML
    public void dashboardOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/drywashcleaningservicesimulator/SaminRahmanFXML/FrontDeskReceptionistView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
    }
}
