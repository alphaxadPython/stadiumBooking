package stadiumbooking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class stadiumVenue extends Component {

    String Cartegory;
    String Capacity;

    public String getCartegory() {
        return Cartegory;
    }

    public void setCartegory(String Cartegory) {
        this.Cartegory = Cartegory;
    }

    public String getCapacity() {
        return Capacity;
    }

    public void setCapacity(String Capacity) {
        this.Capacity = Capacity;
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

    public stadiumVenue(String name, String location, String seat, String price, String Capacity, String Cartegory, String accNo) {
        this.name = name;
        this.location = location;
        this.seat = seat;
        this.price = price;
        this.Capacity = Capacity;
        this.Cartegory = Cartegory;
        this.accNo = accNo;

    }

    public void stadiumVenueRegister() {
        try (Connection conn = DBconnection.getConnection()) {

            // The mysql insert statement for table users_table
            String query = "INSERT INTO stadvenu(name, location, seats, price, capacity, cartegory, accNo) VALUES (?, ?, ?, ?, ?, ?, ?)";
            // Create the mysql insert prepared statement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, name);
            preparedStmt.setString(2, location);
            preparedStmt.setString(3, seat);
            preparedStmt.setString(4, price);
            preparedStmt.setString(5, Capacity);
            preparedStmt.setString(6, Cartegory);
            preparedStmt.setString(7, accNo);

            // Execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        } catch (SQLException e) {
            System.out.println("Cannot connect the database!" + e.getMessage());
        }
        System.out.println("Stadium has been added");
    }
    
    

}
