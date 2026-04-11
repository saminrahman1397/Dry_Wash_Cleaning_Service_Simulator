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

public class U5G3_AttendanceViewController {
    @javafx.fxml.FXML
    private TableView<U5G3_Attendance> attendanceTV;
    @javafx.fxml.FXML
    private Button loadAttendanceButton;
    @javafx.fxml.FXML
    private TableColumn<U5G3_Attendance, Boolean> sbmCol;
    @javafx.fxml.FXML
    private TableColumn<U5G3_Attendance, Boolean> imCol;
    @javafx.fxml.FXML
    private TableColumn<U5G3_Attendance, Boolean> ocCol;
    @javafx.fxml.FXML
    private TableColumn<U5G3_Attendance, Boolean> ctCol;
    @javafx.fxml.FXML
    private TableColumn<U5G3_Attendance, Boolean> fdrCol;
    @javafx.fxml.FXML
    private TableColumn<U5G3_Attendance, Boolean> ccrCol;
    @javafx.fxml.FXML
    private Label noRecordsLabel;
    @javafx.fxml.FXML
    private TableColumn<U5G3_Attendance, Boolean> ddCol;



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
        ArrayList<U5G3_Attendance> records = U5G3_Attendance.loadAllFromFile();

        if (records.isEmpty()) {
            noRecordsLabel.setText("No attendance records available.");
            attendanceTV.setItems(FXCollections.emptyObservableList());
        } else {
            ObservableList<U5G3_Attendance> data = FXCollections.observableArrayList(records);
            attendanceTV.setItems(data);
        }
    }




}
