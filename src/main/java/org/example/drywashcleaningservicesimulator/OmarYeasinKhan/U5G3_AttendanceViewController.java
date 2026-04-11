package org.example.drywashcleaningservicesimulator.OmarYeasinKhan;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class U5G3_AttendanceViewController {
    @javafx.fxml.FXML
    private TableView attendanceTV;
    @javafx.fxml.FXML
    private Button loadAttendanceButton;
    @javafx.fxml.FXML
    private TableColumn sbmCol;
    @javafx.fxml.FXML
    private TableColumn imCol;
    @javafx.fxml.FXML
    private TableColumn ocCol;
    @javafx.fxml.FXML
    private TableColumn ctCol;
    @javafx.fxml.FXML
    private TableColumn fdrCol;
    @javafx.fxml.FXML
    private TableColumn ccrCol;
    @javafx.fxml.FXML
    private Label noRecordsLabel;
    @javafx.fxml.FXML
    private TableColumn ddCol;



    @FXML
    public void initialize() {
        sbmCol .setCellValueFactory(new PropertyValueFactory<>("attendanceSBM"));
        imCol  .setCellValueFactory(new PropertyValueFactory<>("attendanceIM"));
        fdrCol .setCellValueFactory(new PropertyValueFactory<>("attendanceFDR"));
        ctCol  .setCellValueFactory(new PropertyValueFactory<>("attendanceCT"));
        ddCol  .setCellValueFactory(new PropertyValueFactory<>("attendanceDD"));
        ccrCol .setCellValueFactory(new PropertyValueFactory<>("attendanceCCR"));
        ocCol  .setCellValueFactory(new PropertyValueFactory<>("attendanceOC"));


    }

    @FXML
    public void loadAttendance() {

    }


    @FXML
    public void dashboardOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/drywashcleaningservicesimulator/OmarYeasinKhanFXML/StoreBranchManagerDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
    }
}
