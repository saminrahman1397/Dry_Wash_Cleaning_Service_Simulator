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

public class U1G8ViewInvoiceViewController {
    @javafx.fxml.FXML
    private TableColumn<Order,String> orderIDTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Order,String> orderStatusTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Order,Double> totalCostTableColumn;
    @javafx.fxml.FXML
    private TextField orderIDTextField;
    @javafx.fxml.FXML
    private TableColumn<Order,String> garmentTypeTableColumn;
    @javafx.fxml.FXML
    private TableView<Order> invoiceTableVIew;

    @javafx.fxml.FXML

    public void initialize(){
        orderIDTableColumn.setCellValueFactory(new PropertyValueFactory<Order,String>("orderID"));
        orderStatusTableColumn.setCellValueFactory(new PropertyValueFactory<Order,String>("orderStatus"));
        garmentTypeTableColumn.setCellValueFactory(new PropertyValueFactory<Order,String>("garmentType"));
        totalCostTableColumn.setCellValueFactory(new PropertyValueFactory<Order,Double>("totalCost"));
    }
    public void loadOrdersOnActionButton(ActionEvent actionEvent) {
        invoiceTableVIew.getItems().clear();
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
                        invoiceTableVIew.getItems().add(obj);
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
    public void generateInvoiceOnActionButton(ActionEvent actionEvent) throws IOException {
        File file = new File("Data/orders.bin");
        boolean found = false;
        Order tempObj = null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            while(true){
                try{
                    Order obj = (Order) ois.readObject();
                    if(obj.getOrderID().equals(orderIDTextField.getText())){
                        tempObj = obj;
                        found = true;
                    }
                }catch(EOFException e){
                    break;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        if(found){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/drywashcleaningservicesimulator/SaminRahmanFXML/Invoice.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            InvoiceSceneController invoiceSceneController = fxmlLoader.getController();
            invoiceSceneController.RecieveOrderObjectAndGenerateInvoice(tempObj);
            Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
            stage.setScene(scene);
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("GIVE A VALID ORDER ID");
            a.showAndWait();
        }
    }
}
