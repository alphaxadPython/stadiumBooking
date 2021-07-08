package stadiumbooking;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.table.DefaultTableModel;

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
    @FXML
    private Button adminBookinghs1;
    @FXML
    private Label stadiumTotal;
    @FXML
    private Label venuTotal;
    @FXML
    private Label EventsTotal;
    @FXML
    private Label stadiumBookingTotal;
    @FXML
    private Label VenuBookingTotal;
    @FXML
    private Label eventBookingTotal;
    @FXML
    private TableView<events> eventTable;
    @FXML
    private TableColumn<events, String> eventNamecol;
    @FXML
    private TableColumn<events, String> eventLocationCol;
    @FXML
    private TableColumn<events, String> eventSeatsCol;
    @FXML
    private TableColumn<events, String> eventPriceCol;
    @FXML
    private TableColumn<events, String> eventAccountCol;
    @FXML
    private TextField eventFullname;
    @FXML
    private TextField eventLocation;
    @FXML
    private TextField eventAccount;
    @FXML
    private Button eventRegister;
    @FXML
    private DatePicker eventDate;
    @FXML
    private TextField eventSeats;
    @FXML
    private TextField eventCost;
    @FXML
    private Button deleteEvent;
    @FXML
    private Button updateEvent;
    @FXML
    private TableView<?> stadiumTable;
    @FXML
    private TableColumn<?, ?> stadNoCol;
    @FXML
    private TableColumn<?, ?> stadiumNameCol;
    @FXML
    private TableColumn<?, ?> stadiumLocationCol;
    @FXML
    private TableColumn<?, ?> stadiumCapacityCol;
    @FXML
    private TableColumn<?, ?> stadiumSeatsCol;
    @FXML
    private TableColumn<?, ?> stadiumPriceCol;
    @FXML
    private TableColumn<?, ?> stadiumAcountCol;
    @FXML
    private TableColumn<?, ?> stadiumStatusCol;
    @FXML
    private TextField stadiumFullname;
    @FXML
    private TextField stadiumLocation;
    @FXML
    private TextField stadiumAccount;
    @FXML
    private Button registerStadiumVenu;
    @FXML
    private TextField stadiumCapacity;
    @FXML
    private TextField stadiumSeats;
    @FXML
    private TextField stadiumPrice;

    @FXML
    private ComboBox<String> stadiumCartegory;
    @FXML
    private Button deleteStadium;
    @FXML
    private Button updateStadium;
    @FXML
    private TableView<?> stadiumBookings;
    @FXML
    private TableColumn<?, ?> stadBookNoCol;
    @FXML
    private TableColumn<?, ?> stadiumBookUsernameCol;
    @FXML
    private TableColumn<?, ?> sadiumVenuBookCol;
    @FXML
    private TableColumn<?, ?> stadiumBookPhoneCol;
    @FXML
    private TableColumn<?, ?> stadiumBookDaeCol;
    @FXML
    private TableColumn<?, ?> stadiumBookReceiptCol;
    @FXML
    private TableColumn<?, ?> stadiumBookStatusCol;
    @FXML
    private TableColumn<?, ?> eventBookNoCol;
    @FXML
    private TableColumn<?, ?> eventBookUsernameCol;
    @FXML
    private TableColumn<?, ?> eventBookNameCol;
    @FXML
    private TableColumn<?, ?> eventBookPhoneCol;
    @FXML
    private TableColumn<?, ?> eventBookDateCol;
    @FXML
    private TableColumn<?, ?> eventBookReceiptCol;
    @FXML
    private TableColumn<?, ?> eventBookSaetNOCol;
    @FXML
    private TableColumn<?, ?> eventDateCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            eventsTable();
        } catch (SQLException ex) {
            Logger.getLogger(AdminDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList<String> options = FXCollections.observableArrayList(
                "Stadium",
                "Venue"
        );
        stadiumCartegory.setItems(options);
    }

    @FXML
    private void eventAdmin(MouseEvent event) {
        adminTab.getSelectionModel().select(1);
    }

    @FXML
    private void goHome(MouseEvent event) {
        adminTab.getSelectionModel().select(0);
    }

    @FXML
    private void stadiumAdmin(MouseEvent event) {
        adminTab.getSelectionModel().select(2);
    }

    @FXML
    private void Bookings(MouseEvent event) {
        adminTab.getSelectionModel().select(4);
    }

    @FXML
    private void StadBook(MouseEvent event) {
        adminTab.getSelectionModel().select(3);
    }

    @FXML
    private void EventRegistration(ActionEvent event) {
        try {
            if (eventFullname.getText().isEmpty() || eventLocation.getText().isEmpty() || eventSeats.getText().isEmpty() || eventCost.getText().isEmpty() || eventAccount.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please Fill All fields!!");
                alert.setTitle("Empty Fields");
                alert.setHeaderText(null);
                alert.showAndWait();
            } else {
                String fullname = eventFullname.getText();
                String location = eventLocation.getText();
                java.sql.Date date = java.sql.Date.valueOf(eventDate.getValue());
                String Seat = eventSeats.getText();
                String cost = eventCost.getText();
                String account = eventAccount.getText();

                events newEvent = new events(fullname, location, date, Seat, cost, account);
                newEvent.eventRegister();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Event Registered Successfully!!");
                alert.setTitle("Registered Event");
                alert.setHeaderText(null);
                alert.show();

                eventFullname.setText("");
                eventLocation.setText("");
                eventDate.setValue(null);
                eventSeats.setText("");
                eventCost.setText("");
                eventAccount.setText("");
                eventsTable();

            }
        } catch (Exception e) {
        }
    }

    @FXML
    private void stdiumVenuRegistration(MouseEvent event) {
        try {
            if (stadiumFullname.getText().isEmpty() || stadiumLocation.getText().isEmpty() || stadiumSeats.getText().isEmpty() || stadiumPrice.getText().isEmpty() || stadiumAccount.getText().isEmpty() || stadiumCartegory.getSelectionModel().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please Fill All fields!!");
                alert.setTitle("Empty Fields");
                alert.setHeaderText(null);
                alert.showAndWait();
            } else {
                String fullname = stadiumFullname.getText();
                String location = stadiumLocation.getText();
                String Seat = stadiumSeats.getText();
                String cost = stadiumPrice.getText();
                String account = stadiumAccount.getText();
                String cartegory = stadiumCartegory.getValue();
                String capacity = stadiumCapacity.getText();

                stadiumVenue newStadiumVenu = new stadiumVenue(fullname, location, Seat, cost, capacity, cartegory, account);
                newStadiumVenu.stadiumVenueRegister();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Satdium/Venue Registered Successfully!!");
                alert.setTitle("Registered Stadium/Venue");
                alert.setHeaderText(null);
                alert.show();

                stadiumFullname.setText("");
                stadiumLocation.setText("");
                stadiumSeats.setText("");
                stadiumPrice.setText("");
                stadiumAccount.setText("");
                stadiumCartegory.setValue(null);
                stadiumCapacity.setText("");
            }
        } catch (Exception e) {
        }
    }

    public ObservableList<events> getUsersList() throws SQLException {
        ObservableList<events> userlist = FXCollections.observableArrayList();
        Connection conn = DBconnection.getConnection();
        String query = "Select * from events";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            events user;
            while (rs.next()) {
                user = new events(rs.getString("name"), rs.getString("location"), rs.getDate("date"), rs.getString("seats"), rs.getString("price"), rs.getString("accNo"));
                userlist.add(user);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return userlist;
    }

    public void eventsTable() throws SQLException {
        ObservableList<events> list = (ObservableList<events>) getUsersList();
        eventNamecol.setCellValueFactory(new PropertyValueFactory<events, String>("name"));
        eventLocationCol.setCellValueFactory(new PropertyValueFactory<events, String>("location"));
        eventSeatsCol.setCellValueFactory(new PropertyValueFactory<events, String>("seat"));
        eventPriceCol.setCellValueFactory(new PropertyValueFactory<events, String>("price"));
        eventAccountCol.setCellValueFactory(new PropertyValueFactory<events, String>("accNo"));
//        eventDateCol.setCellValueFactory(new PropertyValueFactory<events, String>("date"));

        eventTable.setItems(list);
    }

}
