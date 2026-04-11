package org.example.drywashcleaningservicesimulator.SaminRahman;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class U2G5IssueRefundViewController {
    @javafx.fxml.FXML
    private TableColumn<Order,String> orderIDTableColumn;
    @javafx.fxml.FXML
    private ComboBox<String> issueTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn<Order,String> orderStatusTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Order,Double> totalCostTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Order,String> paymentStatusTableColumn;
    @javafx.fxml.FXML
    private TextField orderIDTextField;
    @javafx.fxml.FXML
    private TableView<Order> refundIssueTableView;
    private ArrayList<Order> ordersList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize(){
        orderIDTableColumn.setCellValueFactory(new PropertyValueFactory<Order,String>("orderID"));
        paymentStatusTableColumn.setCellValueFactory(new PropertyValueFactory<Order,String>("paymentStatus"));
        totalCostTableColumn.setCellValueFactory(new PropertyValueFactory<Order,Double>("totalCost"));
        orderStatusTableColumn.setCellValueFactory(new PropertyValueFactory<Order,String>("orderStatus"));
        issueTypeComboBox.getItems().addAll("Cancelled By Customer", "Damaged Product", "Service Dissatisfaction");
    }
    @javafx.fxml.FXML
    public void loadOrdersOnActionButton(ActionEvent actionEvent) {
        refundIssueTableView.getItems().clear();
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
                    refundIssueTableView.getItems().add(obj);
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
    public void dashboardOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/drywashcleaningservicesimulator/SaminRahmanFXML/FrontDeskReceptionistView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void issueRefundOnActionButton(ActionEvent actionEvent) {
        File file = new File("Data/orders.bin");
        boolean found = false;
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
            for(Order o : ordersList){
                if(o.getOrderID().equals(orderIDTextField.getText())){
                    found = true;
                    if(!o.getOrderStatus().equals("Cancelled") || !o.getPaymentStatus().equals("paid")){
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setContentText("THIS ORDER CANNOT BE PROCESSED");
                        a.showAndWait();
                    }
                    else{
                        o.setOrderStatus("Refund Issued");
                        o.setRefundReason(issueTypeComboBox.getValue());
                        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                        a.setContentText("Refund Issued for Order");
                        a.showAndWait();
                        orderIDTextField.clear();
                    }

                }oos.writeObject(o);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
