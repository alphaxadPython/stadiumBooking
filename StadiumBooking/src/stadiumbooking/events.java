package stadiumbooking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class events extends Component {

    String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    

    public events(String date, String name, String location, String seat, String price, String accNo) {
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
            preparedStmt.setString(3, date);
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
    
      public ArrayList<events> getUsersList() throws SQLException{
        ArrayList<events> userlist = new ArrayList<>();
        Connection conn = DBconnection.getConnection();
        String query = "Select * from events";
        Statement st;
        ResultSet rs;
        try {
        st = conn.createStatement();
        rs = st.executeQuery(query);
        events user;
        while(rs.next()){
        user = new events(rs.getString("name"), rs.getString("location"), rs.getString("date"), rs.getString("seats"), rs.getString("price"), rs.getString("accNo"));
        userlist.add(user);
        }
        } catch (Exception ex) {
        ex.printStackTrace();
        }

        return userlist;
     }
    
    public void eventsTable() throws SQLException{
//         ArrayList<events> list = getUsersList();
//     
//        DefaultTableModel model = (DefaultTableModel)tablename.getModel();
//        
//        Object[] col = new Object[6];
//        for(int i=0; i < list.size(); i++){
//            col[0] = list.get(i).getName();
//            col[1] = list.get(i).getLocation();
//            col[2] = list.get(i).getDate();
//            col[3] = list.get(i).getSeat();
//            col[4] = list.get(i).getPrice();
//            col[5] = list.get(i).getAccNo();
//            model.addRow(col);
//
//
//        }
    }
}
