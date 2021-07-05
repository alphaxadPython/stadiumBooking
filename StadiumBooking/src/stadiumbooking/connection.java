package stadiumbooking;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection {
    
    Connection conn = null;
    public Connection ConnectDB() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/booking", "root", "");
            return conn;
        }catch (Exception e) {return null;}
 

    }

}
