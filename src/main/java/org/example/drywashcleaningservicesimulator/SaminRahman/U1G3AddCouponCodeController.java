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

public class U1G3AddCouponCodeController {
    @javafx.fxml.FXML
    private TableColumn<Order,String> orderIDTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Order,Double> totalCostTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Order,String> paymentStatusTableColumn;
    @javafx.fxml.FXML
    private TextField couponCodeTextField;
    @javafx.fxml.FXML
    private TextField enterOrderIDTextField;
    @javafx.fxml.FXML
    private TableView<Order> couponTableView;

    @javafx.fxml.FXML
    public void initialize(){
        orderIDTableColumn.setCellValueFactory(new PropertyValueFactory<Order,String>("orderID"));
        totalCostTableColumn.setCellValueFactory(new PropertyValueFactory<Order,Double>("totalCost"));
        paymentStatusTableColumn.setCellValueFactory(new PropertyValueFactory<Order,String>("paymentStatus"));
    }
    @javafx.fxml.FXML
    public void showCouponCode(ActionEvent actionEvent) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("YOU CAN USE SAVE5 or SAVE7");
        a.showAndWait();
    }

    @javafx.fxml.FXML
    public void applyCouponOnActionButton(ActionEvent actionEvent) {
        couponTableView.getItems().clear();
        ArrayList<Order> couponOrderList = new ArrayList<Order>();
        boolean found = false;
        double discount = 0;
        double discountedAmount = 0;
        File file = new File("Data/orders.bin");
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            while (true) {
                try {
                    Order obj = (Order) ois.readObject();
                    if (obj.getOrderID().equals(enterOrderIDTextField.getText())) {
                        found = true;
                    }
                    couponOrderList.add(obj);
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
                oos = new ObjectOutputStream(new FileOutputStream(file, false));
                if (!couponCodeTextField.getText().equals("SAVE5") && !couponCodeTextField.getText().equals("SAVE7")){
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setContentText("Invalid Coupon");
                    a.showAndWait();
                    return;
                }
                for (Order o : couponOrderList) {
                    if(o.getOrderID().equals(enterOrderIDTextField.getText())){
                        if(couponCodeTextField.getText().equals("SAVE5")){
                            discount = (o.getTotalCost() * 0.05);
                        }
                        else if(couponCodeTextField.getText().equals("SAVE7")){
                            discount =  (o.getTotalCost() * 0.07);
                        }
                        discountedAmount = o.getTotalCost() - discount;
                        o.setTotalCost(discountedAmount);
                    }
                    oos.writeObject(o);
                }
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setContentText("Coupon Added Successfully Cancelled and you saved " + discount + " tk");
                a.showAndWait();
            } catch (IOException a) {
                a.printStackTrace();
            } finally {
                try {
                    if (oos != null) {
                        oos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @javafx.fxml.FXML
    public void dashBoardOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/drywashcleaningservicesimulator/SaminRahmanFXML/CustomerView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void loadOrdersOnActionButton(ActionEvent actionEvent) {
            couponTableView.getItems().clear();
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
                        if (obj.getPaymentStatus().equals("unpaid")) {
                            couponTableView.getItems().add(obj);
                        }
                    } catch (EOFException e) {
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

