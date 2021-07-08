package stadiumbooking;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class stadiumVenuBooking extends Booking {

    String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public stadiumVenuBooking(String username, String phone, java.sql.Date date, String receipt) {
        this.username = username;
        this.phone = phone;
        this.date = date;
        this.receipt = receipt;
    }

    public void BookVenu() {
        try (Connection conn = DBconnection.getConnection()) {

            // The mysql insert statement for table users_table
            String query = " INSERT INTO stadvenubook(username, phone, date, receipt) VALUES (?, ?, ?, ?)";
            // Create the mysql insert prepared statement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, username);
            preparedStmt.setString(2, phone);
            preparedStmt.setDate(3, date);
            preparedStmt.setString(4, receipt);

            // Execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        } catch (SQLException e) {
            System.out.println("Cannot connect the database!" + e.getMessage());
        }
        System.out.println("Venu has been Booked!!");
    }

}
