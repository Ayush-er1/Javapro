package Loginpage;

	import java.sql.DriverManager;
	import java.sql.Connection;

	public class AdminDatabase {

		final String DRIVER="com.mysql.cj.jdbc.Driver";
		final String HOST="localhost";
		final int PORT=3306;
		final String DBNAME="Hotel";
		final String USER="root";
		final String PASS="Ayush@12345";
		final String URL="jdbc:mysql://"+HOST+":"+PORT+"/"+DBNAME;
		final String SQL = "INSERT INTO admin VALUES(?,'?','?','?','?');";
				
		public Connection connect() {
			Connection conn=null;
			try {
				
				Class.forName(DRIVER); //Loading driver class
				conn = DriverManager.getConnection(URL, USER, PASS);
			}
			catch(Exception ex) {
				System.out.println("Error : "+ex.getMessage());
			}
			return conn;
		}

		public boolean close(Connection conn) {
			boolean result = false;
			try {
				if (!conn.isClosed()) {
					conn.close();
					result = true;
				}
			} catch (Exception ex) {
				System.out.println("Error : " + ex.getMessage());
			}
			return result;
		}
	}


