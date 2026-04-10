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
import java.util.ArrayList;

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
    private TableColumn<Order, String> garmentTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Order, Double> costTableColumn;

    @javafx.fxml.FXML
    public void initialize() {
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("orderStatus"));
        orderIDTableColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("orderID"));
        orderDateTableColumn.setCellValueFactory(new PropertyValueFactory<Order, LocalDate>("orderDate"));
        garmentTableColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("garmentType"));
        costTableColumn.setCellValueFactory(new PropertyValueFactory<Order, Double>("totalCost"));
    }

    public void myOrdersOnActionButton(ActionEvent actionEvent) {
        myOrdersTableView.getItems().clear();
        File file = new File("Data/orders.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            while (true) {
                try {
                    Order obj = (Order) ois.readObject();
                    myOrdersTableView.getItems().add(obj);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
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


    @javafx.fxml.FXML
    public void cancelOrderOnActionButton(ActionEvent actionEvent) {
        myOrdersTableView.getItems().clear();
        ArrayList<Order> ordersList = new ArrayList<Order>();
        boolean found = false;
        File file2 = new File("Data/orders.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(file2);
            ois = new ObjectInputStream(fis);
            while (true) {
                try {
                    Order obj = (Order) ois.readObject();
                    if (obj.getOrderID().equals(orderIDtoCancelTextField.getText())) {
                        obj.setOrderStatus("Cancelled");
                        found = true;
                    }
                    ordersList.add(obj);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        if (found) {
            ObjectOutputStream oos = null;
            try {
                oos = new ObjectOutputStream(new FileOutputStream(file2, false));
                for (Order o : ordersList) {
                    oos.writeObject(o);
                }
                myOrdersTableView.getItems().setAll(ordersList);
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setContentText("Order Successfully Cancelled");
                a.showAndWait();
            } catch (IOException a) {
                a.printStackTrace();
            }finally{
                try{
                    if (oos != null){
                        oos.close();
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
            }

        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("PUT THE RIGHT ORDER ID!");
            a.showAndWait();
        }
    }
}