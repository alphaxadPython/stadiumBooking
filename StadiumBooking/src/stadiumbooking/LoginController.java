
package stadiumbooking;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class LoginController implements Initializable {

    @FXML
    private Button login;
    @FXML
    private Label signup;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginUser(MouseEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("User.fxml"));
            Stage stage = (Stage) login.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        }catch (IOException io){
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
        }catch (IOException io){
            io.printStackTrace();
        }
    }

    
    
}
