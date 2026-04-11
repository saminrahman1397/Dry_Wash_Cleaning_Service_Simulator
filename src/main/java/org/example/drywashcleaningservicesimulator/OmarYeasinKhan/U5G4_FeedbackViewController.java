package org.example.drywashcleaningservicesimulator.OmarYeasinKhan;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class U5G4_FeedbackViewController
{
    @javafx.fxml.FXML
    private Label oneStarLabel;
    @javafx.fxml.FXML
    private Label fourStarLabel;
    @javafx.fxml.FXML
    private Label averageRatingLabel;
    @javafx.fxml.FXML
    private TableColumn RatingTC;
    @javafx.fxml.FXML
    private Label threeStarLabel;
    @javafx.fxml.FXML
    private Label twoStarLabel;
    @javafx.fxml.FXML
    private Label totalReviewsLabel;
    @javafx.fxml.FXML
    private TableColumn orderIDTC;
    @javafx.fxml.FXML
    private TableColumn recommendedTC;
    @javafx.fxml.FXML
    private TableColumn commentTC;
    @javafx.fxml.FXML
    private TableView feedbackTV;
    @javafx.fxml.FXML
    private Label fiveStarLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void dashboardOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/drywashcleaningservicesimulator/OmarYeasinKhanFXML/StoreBranchManagerDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void loadFeedbackOA(ActionEvent actionEvent) {
    }
}