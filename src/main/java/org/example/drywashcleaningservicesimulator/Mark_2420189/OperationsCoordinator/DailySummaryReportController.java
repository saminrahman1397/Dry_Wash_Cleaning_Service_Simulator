package org.example.drywashcleaningservicesimulator.Mark_2420189.OperationsCoordinator;
import cse213.drycleaning.Mark_2420189.GenericFileManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class DailySummaryReportController
{
    @javafx.fxml.FXML
    private Label dateLabel;
    @javafx.fxml.FXML
    private Label staffCountLabel;
    @javafx.fxml.FXML
    private DatePicker reportDateDP;
    @javafx.fxml.FXML
    private Label messageLabel;
    @javafx.fxml.FXML
    private Label locationLabel;

    ObservableList<Location> locationList = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    private ComboBox<Integer> locationIdCB;

    @javafx.fxml.FXML
    public void initialize() {

        loadLocation();
    }

    @javafx.fxml.FXML
    public void generateReportButtonOA(ActionEvent actionEvent) {

        for (Location l : locationList){
            if(l.getLocationId()==locationIdCB.getValue()) {
                locationLabel.setText(l.getLocationName());
                dateLabel.setText(String.valueOf(reportDateDP.getValue()));
                staffCountLabel.setText(Integer.toString(l.getStaffCount()));
            }
        }


    }

    public void loadLocation(){
        locationList = GenericFileManager.readAll(Location.class, "Location.bin");
        ArrayList<Integer> locationIdList = new ArrayList<>();
        for(Location l : locationList){
            locationIdList.add(l.getLocationId());
        }
        for (int s : locationIdList) {
            locationIdCB.getItems().add(s);
        }
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("operationsCoordinatorDashboard.fxml"));
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Operations Coordinator Dashboard");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}