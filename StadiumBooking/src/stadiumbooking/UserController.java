
package stadiumbooking;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javax.swing.table.DefaultTableModel;


public class UserController implements Initializable {

    @FXML
    private Button home;
    @FXML
    private TabPane mainTab;
    @FXML
    private Button events;
    @FXML
    private Button venues;
    @FXML
    private Button stadium;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    public void showEvents(){
       
    }

    @FXML
    private void goHome(MouseEvent event) {
        mainTab.getSelectionModel().select(0);
    }

    @FXML
    private void goEvents(MouseEvent event) {
        mainTab.getSelectionModel().select(2);

    }

    @FXML
    private void goVenues(MouseEvent event) {
        mainTab.getSelectionModel().select(3);

    }

    @FXML
    private void goStadium(MouseEvent event) {
         mainTab.getSelectionModel().select(1);

    }

    @FXML
    private void goBookStadium(MouseEvent event) {
       mainTab.getSelectionModel().select(4);

    }

    @FXML
    private void goBookEvent(MouseEvent event) {
     mainTab.getSelectionModel().select(6);

    }

    @FXML
    private void goBookVenue(MouseEvent event) {
      mainTab.getSelectionModel().select(5);

    }

    @FXML
    private void myBookings(MouseEvent event) {
       mainTab.getSelectionModel().select(7);

    }
    
}
