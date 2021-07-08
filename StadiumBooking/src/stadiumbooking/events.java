package stadiumbooking;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class events extends Component {

    java.sql.Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public events(String name, String location, java.sql.Date date, String seat, String price, String accNo) {
        this.date = date;
        this.name = name;
        this.location = location;
        this.seat = seat;
        this.price = price;
        this.accNo = accNo;
    }

    public void eventRegister() {
        try (Connection conn = DBconnection.getConnection()) {

            // The mysql insert statement for table users_table
            String query = " insert into events (name, location, date, seats, price, accNo)"
                    + " values (?, ?, ?, ?, ?, ?)";
            // Create the mysql insert prepared statement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, name);
            preparedStmt.setString(2, location);
            preparedStmt.setDate(3, date);
            preparedStmt.setString(4, seat);
            preparedStmt.setString(5, price);
            preparedStmt.setString(6, accNo);

            // Execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        } catch (SQLException e) {
            System.out.println("Cannot connect the database!" + e.getMessage());
        }
        System.out.println("Event has been added");
    }

}
