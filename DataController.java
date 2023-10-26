package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class DataController {

    @FXML
    private Button editProfileButton, addPostButton, viewPostButton, deletePostButton, otherOptionsButton;

    @FXML
    private Text welcomeMessage;

    @FXML
    public void initialize() {
        // This method gets called after the FXML file has been loaded
        // For demonstration purposes, let's set a welcome message
        welcomeMessage.setText("Welcome to Data Analytic Hub!");
    }

    @FXML
    public void handleEditProfile() {
        // Handle edit profile logic here
        showAlert("Profile Editing", "Edit profile feature is under development.");
    }

    @FXML
    public void handleAddPost() {
        // Handle add post logic here
        showAlert("Add Post", "Add post feature is under development.");
    }

    @FXML
    public void handleViewPost() {
        // Handle view post logic here
        showAlert("View Post", "View post feature is under development.");
    }

    @FXML
    public void handleDeletePost() {
        // Handle delete post logic here
        showAlert("Delete Post", "Delete post feature is under development.");
    }

    @FXML
    public void handleOtherOptions() {
        // Handle other options logic here
        showAlert("Other Options", "Other options feature is under development.");
    }

    // Utility function to show alerts
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
