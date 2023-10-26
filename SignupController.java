package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class SignupController {

    @FXML
    private TextField firstname;

    @FXML
    private TextField lastname;

    @FXML
    private TextField username;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField confirmpassword;

    @FXML
    protected void signUp() {
        String fName = firstname.getText();
        String lName = lastname.getText();
        String usr = username.getText();
        String mail = email.getText(); // Note: This variable isn't used in the current method. Consider storing it in the database or removing it if not needed.
        String pwd = password.getText();
        String confirmPwd = confirmpassword.getText();

        if (pwd.equals(confirmPwd)) {
            DatabaseConnection.addUser(usr, pwd, fName, lName, false); // Assuming non-VIP user for this example
            System.out.println("Successfully registered. Now you can login.");
        } else {
            System.out.println("Passwords do not match!");
        }
    }
}
