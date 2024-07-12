package OkeBank;
import java.net.URL;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    public Conn(){

        try {
            // Establishing the connection
            c = DriverManager.getConnection("jdbc:mysql:///okebankmanagementdatabase", "root", "stephenoke1!");
            s = c.createStatement();

            // Your SQL logic here

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
