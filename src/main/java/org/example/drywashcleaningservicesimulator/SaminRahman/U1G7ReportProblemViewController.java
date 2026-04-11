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

public class U1G7ReportProblemViewController {

    @javafx.fxml.FXML
    private TableColumn<Order,String> orderIDTableColumn;
    @javafx.fxml.FXML
    private ComboBox<String> issueTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn<Order,String> orderStatusTableColumn;
    @javafx.fxml.FXML
    private TableView<Order> reportProblemTableView;
    @javafx.fxml.FXML
    private TextField orderIDTextField;
    @javafx.fxml.FXML
    private TableColumn<Order,String> garmentTypeTableColumn;
    @javafx.fxml.FXML
    private TextArea issueDescriptionTextArea;

    @javafx.fxml.FXML
    public void initialize(){
        orderIDTableColumn.setCellValueFactory(new PropertyValueFactory<Order,String>("orderID"));
        orderStatusTableColumn.setCellValueFactory(new PropertyValueFactory<Order,String>("orderStatus"));
        garmentTypeTableColumn.setCellValueFactory(new PropertyValueFactory<Order,String>("garmentType"));
        issueTypeComboBox.getItems().setAll("Torn Clothes","Color Damage","Missing Item","Other");
    }
    public void loadOrdersOnActionButton(ActionEvent actionEvent) {
        reportProblemTableView.getItems().clear();
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
                        reportProblemTableView.getItems().add(obj);
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
    public void submitComplainOnActionButton(ActionEvent actionEvent) {
        ArrayList<Order> OrderList = new ArrayList<Order>();
        File file = new File("Data/orders.bin");
        boolean found = false;
        if(issueTypeComboBox.getValue().isEmpty() || issueDescriptionTextArea.getText().isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("INPUT EVERYTHING CORRECTLY");
            a.showAndWait();
        }
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            while (true){
                try{
                    Order obj = (Order) ois.readObject();
                    if(obj.getOrderID().equals(orderIDTextField.getText())){
                        obj.setIssues(issueTypeComboBox.getValue());
                        obj.setIssueDescription(issueDescriptionTextArea.getText());
                        found = true;
                        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                        a.setContentText("REPORT SUBMITTED SUCCESSFULLY");
                        a.showAndWait();
                    }
                    OrderList.add(obj);
                }catch(EOFException e){
                    break;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        if(found){
            try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file,false))){
                for (Order o : OrderList) {
                    oos.writeObject(o);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        issueDescriptionTextArea.clear();
        orderIDTextField.clear();
    }
}
