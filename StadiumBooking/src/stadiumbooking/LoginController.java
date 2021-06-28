
package stadiumbooking;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class LoginController implements Initializable {
    
     private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    private Button login;
    @FXML
    private Label signup;
    @FXML
    private Label close;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginUser(MouseEvent event) {
         try {
            Parent loader = FXMLLoader.load(getClass().getResource("User.fxml"));
            Stage stage = (Stage) login.getScene().getWindow();

            Scene scene = new Scene(loader);
            stage.setScene(scene);
        
//            setting stage on center
             javafx.geometry.Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
            stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
            stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
            
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

    @FXML
    private void closeLogin(MouseEvent event) {
//        close the stage
             Stage stage = (Stage) close.getScene().getWindow();
            
             stage.close();
    }

    
    
}
