package stadiumbooking;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    private Button login;
    @FXML
    private Label signup;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void loginUser(MouseEvent event) {
        try {

            if (username.getText().isEmpty() || password.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please Fill All fields!!");
                alert.setTitle("Empty Fields");
                alert.setHeaderText(null);
                alert.showAndWait();
            } else {
                String user = username.getText();
                String pass = password.getText();

                Register newUser = new Register(user, pass);
                boolean check = newUser.loginUser(user, pass);

                if (!check) {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Login successfully!!");
                    alert.setTitle("Logged!");
                    alert.setHeaderText(null);
                    alert.show();

                    Parent loader = FXMLLoader.load(getClass().getResource("User.fxml"));
                    Stage stage = (Stage) login.getScene().getWindow();

                    Scene scene = new Scene(loader);
                    stage.setScene(scene);

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Account Doesnt exist");
                    alert.setTitle("account Error");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                }

//            setting stage on center
//                javafx.geometry.Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
//                stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
//                stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
            }

        } catch (IOException io) {
            io.printStackTrace();
        }

    }

    @FXML
    private void SignupForm(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Signup.fxml"));
            Stage stage = (Stage) login.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

//    @FXML
//    private void closeLogin(MouseEvent event) {
////        close the stage
//             Stage stage = (Stage) close.getScene().getWindow();
//            
//             stage.close();
//    }
}
