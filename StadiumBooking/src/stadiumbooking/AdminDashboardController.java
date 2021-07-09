package stadiumbooking;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    private TableView<stadiumVenue> stadiumTable;

    @FXML
    private TableColumn<stadiumVenue, String> stadiumNameCol;
    @FXML
    private TableColumn<stadiumVenue, String> stadiumLocationCol;
    @FXML
    private TableColumn<stadiumVenue, String> stadiumCapacityCol;
    @FXML
    private TableColumn<stadiumVenue, String> stadiumSeatsCol;
    @FXML
    private TableColumn<stadiumVenue, String> stadiumPriceCol;
    @FXML
    private TableColumn<stadiumVenue, String> stadiumAcountCol;

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
    private TableColumn<events, String> eventDateCol;
    @FXML
    private TableColumn<stadiumVenue, String> stadiumCartegoryCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            eventsTable();
            stadiumTable();
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
//registering event here

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

//    registering stadium here
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
                stadiumTable();
            }
        } catch (Exception e) {
        }
    }

//    fetch data for Events
    public ObservableList<events> getEventList() throws SQLException {
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
//    assign events in table

//    assign data to event table
    public void eventsTable() throws SQLException {
        ObservableList<events> list = (ObservableList<events>) getEventList();
        eventNamecol.setCellValueFactory(new PropertyValueFactory<events, String>("name"));
        eventLocationCol.setCellValueFactory(new PropertyValueFactory<events, String>("location"));
        eventSeatsCol.setCellValueFactory(new PropertyValueFactory<events, String>("seat"));
        eventPriceCol.setCellValueFactory(new PropertyValueFactory<events, String>("price"));
        eventAccountCol.setCellValueFactory(new PropertyValueFactory<events, String>("accNo"));
        eventDateCol.setCellValueFactory(new PropertyValueFactory<events, String>("date"));

        eventTable.setItems(list);
    }

//    fetch data for Venues and stadiums
    public ObservableList<stadiumVenue> getStadiumList() throws SQLException {
        ObservableList<stadiumVenue> stadiumList = FXCollections.observableArrayList();
        Connection conn = DBconnection.getConnection();
        String query = "Select * from stadvenu";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            stadiumVenue stad;
            while (rs.next()) {
                stad = new stadiumVenue(rs.getString("name"), rs.getString("location"), rs.getString("seats"), rs.getString("price"), rs.getString("capacity"), rs.getString("cartegory"), rs.getString("accNo"));
                stadiumList.add(stad);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return stadiumList;
    }

//     assign the data to stadium and venue table and show it
    public void stadiumTable() throws SQLException {
        ObservableList<stadiumVenue> stad = (ObservableList<stadiumVenue>) getStadiumList();
        stadiumNameCol.setCellValueFactory(new PropertyValueFactory<stadiumVenue, String>("name"));
        stadiumLocationCol.setCellValueFactory(new PropertyValueFactory<stadiumVenue, String>("location"));
        stadiumSeatsCol.setCellValueFactory(new PropertyValueFactory<stadiumVenue, String>("seat"));
        stadiumPriceCol.setCellValueFactory(new PropertyValueFactory<stadiumVenue, String>("price"));
        stadiumCapacityCol.setCellValueFactory(new PropertyValueFactory<stadiumVenue, String>("capacity"));
        stadiumCartegoryCol.setCellValueFactory(new PropertyValueFactory<stadiumVenue, String>("cartegory"));
        stadiumAcountCol.setCellValueFactory(new PropertyValueFactory<stadiumVenue, String>("accNo"));

        stadiumTable.setItems(stad);
    }

//    public variables to catch selected data in table
    public String Name;
    public String location;
    public String seats;
    public String cost;
    public String account;
    public java.sql.Date dates;
    public String capacity;
    public String cartegory;

//    converting date formats
    public static final LocalDate LOCAL_DATE(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dateString, formatter);
        return localDate;
    }

//    on table click select evet here
    @FXML
    private void Eventselect(MouseEvent event) {
        if (event.getClickCount() == 2) //Checking double click
        {
            eventFullname.setText(eventTable.getSelectionModel().getSelectedItem().name);
            eventLocation.setText(eventTable.getSelectionModel().getSelectedItem().location);
            eventSeats.setText(eventTable.getSelectionModel().getSelectedItem().seat);
            eventCost.setText(eventTable.getSelectionModel().getSelectedItem().price);
            eventAccount.setText(eventTable.getSelectionModel().getSelectedItem().accNo);
//            stadiumCartegory.setValue(eventTable.getSelectionModel().getSelectedItem().Cartegory);

//            set to variables to innitiate update and delete
            Name = eventTable.getSelectionModel().getSelectedItem().name;
            location = eventTable.getSelectionModel().getSelectedItem().location;
            seats = eventTable.getSelectionModel().getSelectedItem().seat;
            cost = eventTable.getSelectionModel().getSelectedItem().price;
            account = eventTable.getSelectionModel().getSelectedItem().accNo;
            dates = eventTable.getSelectionModel().getSelectedItem().date;

            eventDate.setValue(LOCAL_DATE(dates.toString()));
        }
    }

//    deleting event here
    @FXML
    private void deleteEventHere(ActionEvent event) {
        try (Connection conn = DBconnection.getConnection()) {

            // The mysql insert statement for table users_table
            String query = "DELETE FROM events WHERE name=?";
            // Create the mysql insert prepared statement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, Name);

            // Execute the preparedstatement
            preparedStmt.execute();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Deleted Successfully!!");
            alert.setTitle("Deleted");
            alert.setHeaderText(null);
            alert.show();

            eventFullname.setText("");
            eventLocation.setText("");
            eventDate.setValue(null);
            eventSeats.setText("");
            eventCost.setText("");
            eventAccount.setText("");
            eventsTable();

            conn.close();
        } catch (SQLException e) {
            System.out.println("Cannot connect the database!" + e.getMessage());
        }
        System.out.println("Deleting the Event");
    }

//    updating event here
    @FXML
    private void updateEventHere(ActionEvent event) {
        try (Connection conn = DBconnection.getConnection()) {

            // The mysql insert statement for table users_table
            String query = "UPDATE events SET name=?, location=?, date=?, seats=?, price=?, accNo=? where name=?";

            // Create the mysql insert prepared statement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, eventFullname.getText());
            preparedStmt.setString(2, eventLocation.getText());
            java.sql.Date date = java.sql.Date.valueOf(eventDate.getValue());

            preparedStmt.setDate(3, date);
            preparedStmt.setString(4, eventSeats.getText());
            preparedStmt.setString(5, eventCost.getText());
            preparedStmt.setString(6, eventAccount.getText());
            preparedStmt.setString(7, Name);

            // Execute the preparedstatement
            preparedStmt.execute();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Updated Successfully!!!!");
            alert.setTitle("Updates");
            alert.setHeaderText(null);
            alert.show();

            eventFullname.setText("");
            eventLocation.setText("");
            eventDate.setValue(null);
            eventSeats.setText("");
            eventCost.setText("");
            eventAccount.setText("");

            eventsTable();

            conn.close();
        } catch (SQLException e) {
            System.out.println("Cannot connect the database!" + e.getMessage());
        }
        System.out.println("Event has bean Updated");
    }

// on click cell table of the stadium table    
    @FXML
    private void clickStadiums(MouseEvent event) {
        if (event.getClickCount() == 2) {
            stadiumFullname.setText(stadiumTable.getSelectionModel().getSelectedItem().name);
            stadiumLocation.setText(stadiumTable.getSelectionModel().getSelectedItem().location);
            stadiumPrice.setText(stadiumTable.getSelectionModel().getSelectedItem().price);
            stadiumCartegory.setValue(stadiumTable.getSelectionModel().getSelectedItem().Cartegory);
            stadiumSeats.setText(stadiumTable.getSelectionModel().getSelectedItem().seat);
            stadiumAccount.setText(stadiumTable.getSelectionModel().getSelectedItem().accNo);
            stadiumCapacity.setText(stadiumTable.getSelectionModel().getSelectedItem().Capacity);

            Name = stadiumTable.getSelectionModel().getSelectedItem().name;
            location = stadiumTable.getSelectionModel().getSelectedItem().location;
            seats = stadiumTable.getSelectionModel().getSelectedItem().seat;
            cost = stadiumTable.getSelectionModel().getSelectedItem().price;
            account = stadiumTable.getSelectionModel().getSelectedItem().accNo;
            capacity = stadiumTable.getSelectionModel().getSelectedItem().Capacity;
            cartegory = stadiumTable.getSelectionModel().getSelectedItem().Cartegory;

        }
    }

//    deleting the stadium here or venu
    @FXML
    private void deleteStadiumHere(ActionEvent event) {
        try (Connection conn = DBconnection.getConnection()) {

            // delete statement
            String query = "DELETE FROM stadvenu WHERE name=?";
            // Create the mysql delete prepared statement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, Name);

            // Execute the preparedstatement
            preparedStmt.execute();

            System.out.println("deleted successfully!!");

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Deleted Successfully!!");
            alert.setTitle("Deleted");
            alert.setHeaderText(null);
            alert.show();

            stadiumFullname.setText("");
            stadiumLocation.setText("");
            stadiumSeats.setText("");
            stadiumPrice.setText("");
            stadiumAccount.setText("");
            stadiumCapacity.setText("");
            stadiumCartegory.setValue(null);
            stadiumTable();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Cannot connect the database!" + e.getMessage());
        }
        System.out.println("Deleting the stadium or venu");
    }

//    update stadium and venues here
    @FXML
    private void updateStadiumHere(ActionEvent event) {
        try (Connection conn = DBconnection.getConnection()) {

            // The mysql insert statement for table users_table
            String query = "UPDATE stadvenu SET name=?, location=?, seats=?, price=?, capacity=?, cartegory=?, accNo=? where name=?";

            // Create the mysql insert prepared statement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, stadiumFullname.getText());
            preparedStmt.setString(2, stadiumLocation.getText());
            preparedStmt.setString(3, stadiumSeats.getText());
            preparedStmt.setString(4, stadiumPrice.getText());
            preparedStmt.setString(5, stadiumCapacity.getText());
            preparedStmt.setString(6, stadiumCartegory.getValue());
            preparedStmt.setString(7, stadiumAccount.getText());
            preparedStmt.setString(8, Name);

            // Execute the preparedstatement
            preparedStmt.execute();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Updated Successfully!!!!");
            alert.setTitle("Updates");
            alert.setHeaderText(null);
            alert.show();

            stadiumFullname.setText("");
            stadiumLocation.setText("");
            stadiumSeats.setText("");
            stadiumPrice.setText("");
            stadiumAccount.setText("");
            stadiumCapacity.setText("");
            stadiumCartegory.setValue(null);
            stadiumTable();

            conn.close();
        } catch (SQLException e) {
            System.out.println("Cannot connect the database!" + e.getMessage());
        }
        System.out.println("Event has bean Updated");
    }

}
