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

public class U1G4MakePaymentViewController {
    @javafx.fxml.FXML
    private TableColumn<Order,String> orderIDTableColumn;
    @javafx.fxml.FXML
    private TableView<Order> makePaymentTableView;
    @javafx.fxml.FXML
    private TableColumn<Order,String> paymentStatusTableColumn;
    @javafx.fxml.FXML
    private TextField transactionIDTextField;
    @javafx.fxml.FXML
    private TableColumn<Order,Double> amountToPayTableColumn;
    @javafx.fxml.FXML
    private TextField bkashNumberTextField;
    @javafx.fxml.FXML
    private TextField orderIDTextField;

    @javafx.fxml.FXML
    public void initialize(){
        orderIDTableColumn.setCellValueFactory(new PropertyValueFactory<Order,String>("orderID"));
        paymentStatusTableColumn.setCellValueFactory(new PropertyValueFactory<Order,String>("paymentStatus"));
        amountToPayTableColumn.setCellValueFactory(new PropertyValueFactory<Order,Double>("totalCost"));
    }



    @javafx.fxml.FXML
    public void loadOrdersOnActionButton(ActionEvent actionEvent) {
        makePaymentTableView.getItems().clear();
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
                    if (obj.getPaymentStatus().equals("unpaid")) {
                        makePaymentTableView.getItems().add(obj);
                    }
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean isValid(){
        Alert a = new Alert(Alert.AlertType.ERROR);
        if(bkashNumberTextField.getText().length() != 11){
            a.setContentText("Enter a valid Number!");
            a.showAndWait();
            return false;
        }else if(!transactionIDTextField.getText().equals("TXN-2026-XYZ")){
            a.setContentText("Invalid Transaction ID!");
            a.showAndWait();
            return false;
        }
        return true;
    }

    @javafx.fxml.FXML
    public void makePaymentOnActionButton(ActionEvent actionEvent) {
        ArrayList<Order> paymentList = new ArrayList<Order>();
        boolean found = false;
        File file = new File("Data/orders.bin");
        if (isValid()){
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
                while(true){
                    try {
                        Order obj = (Order) ois.readObject();
                        if (obj.getOrderID().equals(orderIDTextField.getText())) {
                            found = true;
                        }
                        paymentList.add(obj);
                    }catch (EOFException e){
                        break;
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }

            if(found){
                try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
                    for (Order o : paymentList){
                        if(o.getOrderID().equals(orderIDTextField.getText())){
                            o.setPaymentStatus("paid");
                            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                            a.setContentText("PAYMENT SUCCESSFUL!");
                            a.showAndWait();
                        }
                        oos.writeObject(o);
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
            }else{
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("WRONG ORDER ID");
                a.showAndWait();
            }

        }

    }

    @javafx.fxml.FXML
    public void dashboardOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/drywashcleaningservicesimulator/SaminRahmanFXML/CustomerView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
    }
}
