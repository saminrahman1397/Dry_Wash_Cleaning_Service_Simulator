package org.example.drywashcleaningservicesimulator;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class technicianworkController
{
    @javafx.fxml.FXML
    private TableView orderDetailsTableView;
    @javafx.fxml.FXML
    private ComboBox selectNewStageComboBox;
    @javafx.fxml.FXML
    private TableColumn quantityTableColumn;
    @javafx.fxml.FXML
    private TableColumn serviceTypeTableColumn;
    @javafx.fxml.FXML
    private TableColumn currentStageTableColumn;
    @javafx.fxml.FXML
    private TableColumn garmentTypeTableColumn;
    @javafx.fxml.FXML
    private TextArea cleaningNotesTextArea;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void saveNotesOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void updateSettingOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void reportDamageOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void markBatchCompleteOnActionButton(ActionEvent actionEvent) {
    }
}