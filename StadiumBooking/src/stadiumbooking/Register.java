package stadiumbooking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;

public class Register {

    String username;
    String phone;
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public Register(String username, String phone, String password) {
        this.username = username;
        this.phone = phone;
        this.password = password;
    }

    public Register(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String status ="user";

//    signup the user here
    public void signUser() {

        try (Connection conn = DBconnection.getConnection()) {

            // The mysql insert statement for table users_table
            String query = " insert into signup (username, password, phone, status)"
                    + " values (?, ?, ?, ?)";
            // Create the mysql insert prepared statement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, username);
            preparedStmt.setString(2, password);
            preparedStmt.setString(3, phone);
            preparedStmt.setString(4,status);

            // Execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        } catch (SQLException e) {
            System.out.println("Cannot connect the database!" + e.getMessage());
        }
        System.out.println("Data has been sent to users_table");
    }

//    login the user here
    public boolean loginUser(String username, String password) {
        try (Connection conn = DBconnection.getConnection()) {
            // The mysql insert statement for table users_table
            String query = "SELECT * FROM signup where username=? AND password=?";
            // Create the mysql insert prepared statement

            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, username);
            preparedStmt.setString(2, password);

            System.out.println(preparedStmt);

            ResultSet resultSet = preparedStmt.executeQuery();
            if (!resultSet.next()) {
               
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
