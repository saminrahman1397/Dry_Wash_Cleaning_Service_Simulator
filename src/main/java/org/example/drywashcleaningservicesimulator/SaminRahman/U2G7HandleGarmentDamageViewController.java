package org.example.drywashcleaningservicesimulator.SaminRahman;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.ArrayList;

public class U2G7HandleGarmentDamageViewController {

    @javafx.fxml.FXML
    private TableColumn<Order,String> orderIDTableColumn;
    @javafx.fxml.FXML
    private TextField orderIDTextField;
    @javafx.fxml.FXML
    private TableColumn<Order,String> serviceTypeTableColumm;
    @javafx.fxml.FXML
    private TableView<Order> handleGarmentDamageTableView;
    @javafx.fxml.FXML
    private TableColumn<Order,String> garmentTableColumn;
    @javafx.fxml.FXML
    private TextArea complaintTextArea;
    private ArrayList<Order> ordersList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize(){
        orderIDTableColumn.setCellValueFactory(new PropertyValueFactory<Order,String>("orderID"));
        garmentTableColumn.setCellValueFactory(new PropertyValueFactory<Order,String>("garmentType"));
        serviceTypeTableColumm.setCellValueFactory(new PropertyValueFactory<Order,String>("serviceMethod"));
    }
    @javafx.fxml.FXML
    public void loadOrderOnActionButton(ActionEvent actionEvent) {
        handleGarmentDamageTableView.getItems().clear();
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
                    handleGarmentDamageTableView.getItems().add(obj);
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
    public void submitOnActionButton(ActionEvent actionEvent) {
        File file = new File("Data/orders.bin");
        boolean found = false;
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
            for(Order o : ordersList){
                if(o.getOrderID().equals(orderIDTextField.getText())){
                    o.setDamageComplaint(complaintTextArea.getText());
                    found = true;
                    Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                    a.setContentText("Added for inspection successfully");
                    a.showAndWait();
                }oos.writeObject(o);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        if(!found){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Invalid Order ID");
            a.showAndWait();
        }
    }

    @javafx.fxml.FXML
    public void dashBoardOnActionButton(ActionEvent actionEvent) {
    }
}
