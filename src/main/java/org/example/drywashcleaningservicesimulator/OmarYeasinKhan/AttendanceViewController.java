package org.example.drywashcleaningservicesimulator.OmarYeasinKhan;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class AttendanceViewController {
    @javafx.fxml.FXML
    private TableView<Attendance> attendanceTV;
    @javafx.fxml.FXML
    private Button loadAttendanceButton;
    @javafx.fxml.FXML
    private TableColumn<Attendance, Boolean> sbmCol;
    @javafx.fxml.FXML
    private TableColumn<Attendance, Boolean> imCol;
    @javafx.fxml.FXML
    private TableColumn<Attendance, Boolean> ocCol;
    @javafx.fxml.FXML
    private TableColumn<Attendance, Boolean> ctCol;
    @javafx.fxml.FXML
    private TableColumn<Attendance, Boolean> fdrCol;
    @javafx.fxml.FXML
    private TableColumn<Attendance, Boolean> ccrCol;
    @javafx.fxml.FXML
    private Label noRecordsLabel;
    @javafx.fxml.FXML
    private TableColumn<Attendance, Boolean> ddCol;



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
        ArrayList<Attendance> records = Attendance.loadAllFromFile();

        if (records.isEmpty()) {
            noRecordsLabel.setText("No attendance records available.");
            attendanceTV.setItems(FXCollections.emptyObservableList());
        } else {
            ObservableList<Attendance> data = FXCollections.observableArrayList(records);
            attendanceTV.setItems(data);
        }
    }




}
