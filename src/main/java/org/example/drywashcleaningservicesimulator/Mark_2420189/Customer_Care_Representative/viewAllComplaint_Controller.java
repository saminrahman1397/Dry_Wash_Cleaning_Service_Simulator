package org.example.drywashcleaningservicesimulator.Mark_2420189.Customer_Care_Representative;

import cse213.drycleaning.Mark_2420189.GenericFileManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class viewAllComplaint_Controller
{
    @javafx.fxml.FXML
    private TableColumn<Complaints, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn<Complaints,Integer> IdCol;
    @javafx.fxml.FXML
    private TableView<Complaints> tableView;
    @javafx.fxml.FXML
    private TableColumn<Complaints,String> descriptionCol;
    ObservableList<Complaints> complaintsList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        dateCol.setCellValueFactory(new PropertyValueFactory<>("complaint_date"));
        IdCol.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("complaint_description"));

        complaintsList = GenericFileManager.readAll(Complaints.class, "complaints.bin");
        for (Complaints c : complaintsList) {
                tableView.getItems().add(c);}



    }

}