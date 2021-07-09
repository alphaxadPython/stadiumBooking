
package stadiumbooking;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    @FXML
    private TableView<stadiumVenue> stadiumTable;
    @FXML
    private TableColumn<stadiumVenue, String> nameCol;
    @FXML
    private TableColumn<stadiumVenue, String> capacityCol;
    @FXML
    private TableColumn<stadiumVenue, String> locationCol;
    @FXML
    private TableColumn<stadiumVenue, String> seatsCol;
    @FXML
    private TableColumn<stadiumVenue, String> priceCol;
    @FXML
    private TableColumn<stadiumVenue, String> accountCol;
    @FXML
    private TableView<events> evenTable;
    @FXML
    private TableColumn<events, String> eventCol;
    @FXML
    private TableColumn<events, String> eventDate;
    @FXML
    private TableColumn<events, String> eventLocation;
    @FXML
    private TableColumn<events, String> eventSeat;
    @FXML
    private TableColumn<events, String> eventPrice;
    @FXML
    private TableColumn<events, String> eventAccount;
    @FXML
    private TableView<stadiumVenue> venuTable;
    @FXML
    private TableColumn<stadiumVenue, String> venuName;
    @FXML
    private TableColumn<stadiumVenue, String> venuCapacity;
    @FXML
    private TableColumn<stadiumVenue, String> venuLocation;
    @FXML
    private TableColumn<stadiumVenue, String> venuSeats;
    @FXML
    private TableColumn<stadiumVenue, String> venuPrice;
    @FXML
    private TableColumn<stadiumVenue, String> venuAccount;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
            stadiumTable();
            eventList();
            venuTable();
        } catch (SQLException ex) {
            Logger.getLogger(AdminDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
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

//    booking the event
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

// Booking the venu
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

    
//    Booking the stadium
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
    
//    fetch data for the stadium 
    public ObservableList<stadiumVenue> getStadiumList() throws SQLException {
        ObservableList<stadiumVenue> stadiumList = FXCollections.observableArrayList();
        Connection conn = DBconnection.getConnection();
        String query = "Select * from stadvenu where cartegory='Stadium'";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            stadiumVenue stad;
            while (rs.next()) {
                stad = new stadiumVenue(rs.getString("name"), rs.getString("location"), rs.getString("seats"), rs.getString("price"), rs.getString("capacity"), rs.getString("accNo"));
                stadiumList.add(stad);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return stadiumList;
    }
    
//    assign data to stadium table
     public void stadiumTable() throws SQLException {
        ObservableList<stadiumVenue> stad = (ObservableList<stadiumVenue>) getStadiumList();
        nameCol.setCellValueFactory(new PropertyValueFactory<stadiumVenue, String>("name"));
        capacityCol.setCellValueFactory(new PropertyValueFactory<stadiumVenue, String>("capacity"));
        locationCol.setCellValueFactory(new PropertyValueFactory<stadiumVenue, String>("location"));
        seatsCol.setCellValueFactory(new PropertyValueFactory<stadiumVenue, String>("seat"));
        priceCol.setCellValueFactory(new PropertyValueFactory<stadiumVenue, String>("price"));
        accountCol.setCellValueFactory(new PropertyValueFactory<stadiumVenue, String>("accNo"));
        
        stadiumTable.setItems(stad);
    }
     
     
//    fetch data for the events
    public ObservableList<events> getEvents() throws SQLException {
        ObservableList<events> eventList = FXCollections.observableArrayList();
        Connection conn = DBconnection.getConnection();
        String query = "Select * from events";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            events event;
            while (rs.next()) {
                event = new events(rs.getString("name"), rs.getString("location"), rs.getDate("date"), rs.getString("seats"), rs.getString("price"), rs.getString("accNo"));
                eventList.add(event);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return eventList;
    }
    
    
//    assign the events in table
     public void eventList() throws SQLException {
          ObservableList<events> list = (ObservableList<events>) getEvents();
        eventCol.setCellValueFactory(new PropertyValueFactory<events, String>("name"));
        eventLocation.setCellValueFactory(new PropertyValueFactory<events, String>("location"));
        eventSeat.setCellValueFactory(new PropertyValueFactory<events, String>("seat"));
        eventPrice.setCellValueFactory(new PropertyValueFactory<events, String>("price"));
        eventAccount.setCellValueFactory(new PropertyValueFactory<events, String>("accNo"));
        eventDate.setCellValueFactory(new PropertyValueFactory<events, String>("date"));

        evenTable.setItems(list);
         

    }
  
         
//    fetch data for the stadium 
    public ObservableList<stadiumVenue> getVenuList() throws SQLException {
        ObservableList<stadiumVenue> stadiumList = FXCollections.observableArrayList();
        Connection conn = DBconnection.getConnection();
        String query = "Select * from stadvenu where cartegory='Venu'";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            stadiumVenue stad;
            while (rs.next()) {
                stad = new stadiumVenue(rs.getString("name"), rs.getString("location"), rs.getString("seats"), rs.getString("price"), rs.getString("capacity"), rs.getString("accNo"));
                stadiumList.add(stad);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return stadiumList;
    }
    
//    assign data to stadium table
     public void venuTable() throws SQLException {
        ObservableList<stadiumVenue> stad = (ObservableList<stadiumVenue>) getVenuList();
        venuName.setCellValueFactory(new PropertyValueFactory<stadiumVenue, String>("name"));
        venuCapacity.setCellValueFactory(new PropertyValueFactory<stadiumVenue, String>("capacity"));
        venuLocation.setCellValueFactory(new PropertyValueFactory<stadiumVenue, String>("location"));
        venuSeats.setCellValueFactory(new PropertyValueFactory<stadiumVenue, String>("seat"));
        venuPrice.setCellValueFactory(new PropertyValueFactory<stadiumVenue, String>("price"));
        venuAccount.setCellValueFactory(new PropertyValueFactory<stadiumVenue, String>("accNo"));
        
        venuTable.setItems(stad);
    }
     
     
}
