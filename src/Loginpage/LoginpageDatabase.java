package Loginpage;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class LoginpageDatabase {
	// MySQL Database credentials
    final String DRIVER = "com.mysql.cj.jdbc.Driver";
    final String HOST = "localhost";
    final int PORT = 3306;
    final String DBNAME = "Hotel";
    final String USER = "root";  
    final String PASS = "Ayush@12345";  
    final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DBNAME;

    // Method to validate user credentials
    public static String validateUser(String username, String password) {
        String query = "SELECT * FROM login WHERE Userid=? AND password=?";
        
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel","root","Ayush@12345");
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1,username);
            stmt.setString(2,password);
           try( ResultSet rs = stmt.executeQuery()){
        	   if(rs.next()) {
        		   return rs.getString("role");
        	   }
           }
         
        } catch (SQLException e) {
        	System.err.println("Database error:"+e.getMessage());
            e.printStackTrace();
            
        }
        return null;
    }
}

