package org.example.drywashcleaningservicesimulator.SaminRahman;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class U1G6SubmitFeedbackViewController {
    @javafx.fxml.FXML
    private RadioButton oneStarRadioButton;
    @javafx.fxml.FXML
    private RadioButton fourStarRadioButton;
    @javafx.fxml.FXML
    private RadioButton threeStarRadioButton;
    @javafx.fxml.FXML
    private RadioButton twoStarRadioButton;
    @javafx.fxml.FXML
    private RadioButton fiveStarRadioButton;
    @javafx.fxml.FXML
    private RadioButton noRadioButton;
    @javafx.fxml.FXML
    private TextArea commentsTextArea;
    @javafx.fxml.FXML
    private RadioButton maybeRadioButton;
    @javafx.fxml.FXML
    private RadioButton yesRadioButton;

    @javafx.fxml.FXML
    public void submitFeedbackOnActionButton(ActionEvent actionEvent) {
        boolean ratingSelected = oneStarRadioButton.isSelected() || twoStarRadioButton.isSelected() ||
                threeStarRadioButton.isSelected() || fourStarRadioButton.isSelected() ||
                fiveStarRadioButton.isSelected();

        boolean recommendationSelected = yesRadioButton.isSelected() || noRadioButton.isSelected() ||
                maybeRadioButton.isSelected();
        if(!ratingSelected || !recommendationSelected) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please choose at least one option!");
            a.showAndWait();
            return;
        }
        else if(commentsTextArea.getText().isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please write a comment!");
            a.showAndWait();
            return;
        }
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText("Thank you for your feedback!");
        a.showAndWait();
        commentsTextArea.clear();
    }

    @javafx.fxml.FXML
    public void dashboardOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/drywashcleaningservicesimulator/SaminRahmanFXML/CustomerView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
    }
}
