package stadiumbooking;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class eventBooking extends Booking {

    String seat;

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBookingType() {
        return bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public eventBooking(String seat, String username, String bookingType, String phone, Date date, String receipt) {
        this.username = username;
        this.bookingType = bookingType;
        this.phone = phone;
        this.date = date;
        this.receipt = receipt;
        this.seat = seat;
    }

    public eventBooking(String username, String phone, String seat, String receipt) {
        this.username = username;
        this.phone = phone;
        this.seat = seat;
        this.receipt = receipt;
    }

    public void EventBook() {
        try (Connection conn = DBconnection.getConnection()) {
            // The mysql insert statement for table users_table
            String query = " INSERT INTO eventbook(username, phone, seat, receipt) VALUES (?, ?, ?, ?)";
            // Create the mysql insert prepared statement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, username);
            preparedStmt.setString(2, phone);
            preparedStmt.setString(3, seat);
            preparedStmt.setString(4, receipt);

            // Execute the preparedstatement
            preparedStmt.execute();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Cannot connect the database!" + e.getMessage());
        }
        System.out.println("Event have been Booked");
    }

}
