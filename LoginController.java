package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginController {

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;
    
   
    @FXML
    protected void handleLogin(ActionEvent event) {
        String usr = username.getText();
        String pwd = password.getText();

        if (isValidCredentials(usr, pwd)) {
            try {
                Parent dashboardPageParent = FXMLLoader.load(getClass().getResource("DashboardView.fxml")); // Ensure path is correct
                Scene dashboardPageScene = new Scene(dashboardPageParent);
                Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                appStage.setScene(dashboardPageScene);
                appStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid Username/Password!");
        }
    }

    @FXML
    private void handleNewUser() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SignupView.fxml")); // Ensure this path is correct
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Register new user ");
            stage.setScene(new Scene(root));
            stage.show();
        }
            catch (IOException e) {
            e.printStackTrace();
        }
    }


    private boolean isValidCredentials(String usr, String pwd) {
        String sql = "SELECT password FROM Users WHERE username=?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usr);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("password").equals(pwd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
