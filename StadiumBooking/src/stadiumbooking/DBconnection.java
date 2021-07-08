package stadiumbooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    
    Connection conn;

    public DBconnection() {
    }
    

    public DBconnection(Connection conn) {
        this.conn = conn;
    }
    
     public static Connection getConnection() throws SQLException{
        Connection connection = null;

        String dbUrl = "jdbc:mysql://localhost:3306/booking"; // hostname:localhost, portNumber:3306, database: LoginForm
        String user = "root";       //enter sql connection user name
        String pass = "";       // enter sql connection password 
        try {
            //driver setup for database
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl, user, pass);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        return connection;
    }

}
