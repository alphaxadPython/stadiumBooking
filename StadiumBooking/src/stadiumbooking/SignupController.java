package stadiumbooking;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SignupController implements Initializable {

    @FXML
    private Button signup;
    @FXML
    private Label login;
    @FXML
    private TextField username;
    @FXML
    private TextField phone;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField password2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void signUser(MouseEvent event) {
        try {
            String pwd1 = password.getText();
           String  pwd2 = password2.getText();
            if (username.getText().isEmpty() || phone.getText().isEmpty() || password.getText().isEmpty() || password2.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please Fill All fields!!");
                alert.setTitle("Empty Fields");
                alert.showAndWait();
            } else if (pwd1.equals(pwd2)){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("User.fxml"));
                Stage stage = (Stage) signup.getScene().getWindow();
                Scene scene = new Scene(loader.load());
                stage.setScene(scene);
            } else {
                
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("The two passwords do not match");
                alert.setTitle("Empty Fields");
                alert.showAndWait();
            }

        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    @FXML
    private void loginForm(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Stage stage = (Stage) login.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

//    @FXML
//    private void closeSignup(MouseEvent event) {
////         close the stage
//             Stage stage = (Stage) close.getScene().getWindow();
//             stage.close();
//    }
}
