package Staff;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class SpageDatabase {

	final static String DRIVER="com.mysql.cj.jdbc.Driver";
	final String HOST="localhost";
	final int PORT=3306;
	final String DBNAME="Hotel";
	final String USER="root";
	final String PASS="Ayush@12345";
final String URL="jdbc:mysql://"+HOST+":"+PORT+"/"+DBNAME;

			
	 static {
	        try {
	            Class.forName(DRIVER);
	        } catch (ClassNotFoundException e) {
	            System.err.println("Not found!");
	            e.printStackTrace();
	        }
	    }

	 public Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(URL, USER, PASS);
	    }
	    public void close(Connection conn) {
	        if (conn != null) {
	            try {
	                if (!conn.isClosed()) {
	                    conn.close();
	                }
	            } catch (SQLException e) {
	                System.err.println("Failed to close connection: " + e.getMessage());
	            }
	            }
	    }
	}
