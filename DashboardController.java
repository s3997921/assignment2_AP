package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DashboardController {

    @FXML
    private Label welcomeLabel;

    public void initialize() {
        // Load the welcome message
        welcomeLabel.setText("Welcome!");
    }

    @FXML
    private void handleEditProfile(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("EditProfile.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void handleAddPost(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("AddPost.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    @FXML
    private void handleToViewPost(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ViewPost.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    @FXML
    private void handleDeletePost(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("DeletePost.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    private void handleOtherOption(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("OtherOption.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    

    }
