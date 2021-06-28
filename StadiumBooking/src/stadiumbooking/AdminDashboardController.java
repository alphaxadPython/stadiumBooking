
package stadiumbooking;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;


public class AdminDashboardController implements Initializable {

    @FXML
    private Button adminEvents;
    @FXML
    private Button Admin;
    @FXML
    private Button adminVenues;
    @FXML
    private Button adminBookinghs;
    @FXML
    private TabPane adminTab;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void eventAdmin(MouseEvent event) {
         adminTab.getSelectionModel().select(0);

    }

    @FXML
    private void goHome(MouseEvent event) {
         adminTab.getSelectionModel().select(4);

        
    }

    @FXML
    private void stadiumAdmin(MouseEvent event) {
        adminTab.getSelectionModel().select(1);

    }

    @FXML
    private void Bookings(MouseEvent event) {
      adminTab.getSelectionModel().select(3);

    }

    @FXML
    private void myBookings(MouseEvent event) {
    }


 
    
}
