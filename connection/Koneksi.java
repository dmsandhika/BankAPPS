package connection;

import java.sql.*;


public class Koneksi {
    public static Connection getConnection() throws Exception{
        
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mybank_db","root","");
        return conn;
        
    }
}
