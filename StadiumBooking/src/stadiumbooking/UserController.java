
package stadiumbooking;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


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
    @FXML
    private TextField eventBookerFullname;
    @FXML
    private TextField eventBookerPhone;
    @FXML
    private TextField eventBookerReceipt;
    @FXML
    private Button BookEventBtn;
    @FXML
    private TextField eventBookerSeat;
    @FXML
    private TextField venuBookerFullname;
    @FXML
    private TextField venuBookerReceipt;
    @FXML
    private TextField venuBookerPhone;
    @FXML
    private DatePicker venuBookerDate;
    @FXML
    private Button bookvn;
    @FXML
    private TextField stadiumBookerFullname;
    @FXML
    private TextField stadiumBookerPhone;
    @FXML
    private TextField stadiumBookerReceipt;
    @FXML
    private DatePicker stadiumBookerDate;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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

    @FXML
    private void BookEventNow(ActionEvent event) {
           try {
            if (eventBookerFullname.getText().isEmpty() || eventBookerPhone.getText().isEmpty() || eventBookerSeat.getText().isEmpty() || eventBookerReceipt.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please Fill All fields!!");
                alert.setTitle("Empty Fields");
                alert.setHeaderText(null);
                alert.showAndWait();
            } else {
                String fullname = eventBookerFullname.getText();
                String phone = eventBookerPhone.getText();
                String seat = eventBookerSeat.getText();
                String receipt = eventBookerReceipt.getText();
                

                eventBooking newBook = new eventBooking(fullname, phone, seat, receipt);
                newBook.EventBook();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Booked successfully!!!");
                alert.setTitle("Booked successfully!!");
                alert.setHeaderText(null);
                alert.show();

                eventBookerFullname.setText("");
                eventBookerPhone.setText("");
                eventBookerSeat.setText("");
                eventBookerReceipt.setText("");
            }
        } catch (Exception e) {
        }
    }

 
    @FXML
    private void BookVenuNow(ActionEvent event) {
           try {
            if (venuBookerFullname.getText().isEmpty() || venuBookerPhone.getText().isEmpty() || venuBookerReceipt.getText().isEmpty() || venuBookerDate.getValue().equals(null)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please Fill All fields!!");
                alert.setTitle("Empty Fields");
                alert.setHeaderText(null);
                alert.showAndWait();
            } else {
                String fullname = venuBookerFullname.getText();
                String phone = venuBookerPhone.getText();
                java.sql.Date date = java.sql.Date.valueOf(venuBookerDate.getValue().toString());
                String receipt = venuBookerReceipt.getText();
                
                stadiumVenuBooking newBook = new stadiumVenuBooking(fullname, phone, date, receipt);
                newBook.BookVenu();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Booked successfully!!");
                alert.setTitle("Booked successfully!!");
                alert.setHeaderText(null);
                alert.show();

                venuBookerFullname.setText("");
                venuBookerPhone.setText("");
                venuBookerDate.setValue(null);
                venuBookerReceipt.setText("");
            }
        } catch (Exception e) {
        }
    }

    @FXML
    private void BookStadiumHere(ActionEvent event) {
         try {
            if (stadiumBookerFullname.getText().isEmpty() || stadiumBookerPhone.getText().isEmpty() || stadiumBookerReceipt.getText().isEmpty() || stadiumBookerDate.getValue().equals(null)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please Fill All fields!!");
                alert.setTitle("Empty Fields");
                alert.setHeaderText(null);
                alert.showAndWait();
            } else {
                String fullname = stadiumBookerFullname.getText();
                String phone = stadiumBookerPhone.getText();
                java.sql.Date date = java.sql.Date.valueOf(stadiumBookerDate.getValue().toString());
                String receipt = stadiumBookerReceipt.getText();
                
                stadiumVenuBooking newBook = new stadiumVenuBooking(fullname, phone, date, receipt);
                newBook.BookVenu();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Booked successfully!!");
                alert.setTitle("Booked successfully!!");
                alert.setHeaderText(null);
                alert.show();

                stadiumBookerFullname.setText("");
                stadiumBookerPhone.setText("");
                stadiumBookerDate.setValue(null);
                stadiumBookerReceipt.setText("");
            }
        } catch (Exception e) {
        }
    }
    
}
