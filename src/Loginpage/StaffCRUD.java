package Loginpage;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StaffCRUD extends AdminDatabase implements InfStaffCRUD {


	//Insert
	@Override
	public boolean insert(StaffUser user) {
		boolean result = false;
		PreparedStatement pStat;
		String sql = "INSERT INTO staff(staff_id, assign_task) VALUES (?,?);";

		try {
			pStat=connect().prepareStatement(sql);
			pStat.setInt(1, user.getStaffID());
            pStat.setString(2,user.getAssignTask());
			pStat.executeUpdate();
			pStat.close();
			result=true;
		}
		catch(Exception ex) {
			System.out.println("Error : "+ex.getMessage());
		}
		return result;
	}
	
	//search
	@Override
	public StaffUser search(int staff_id) {
		Connection conn;
		PreparedStatement pStat;
		ResultSet resultSet;
		String sqlQuery="SELECT * FROM staff WHERE staff_id=?;";
		StaffUser user = new StaffUser();
		
		try {
			conn = connect();
			pStat = conn.prepareStatement(sqlQuery);
			pStat.setInt(1,staff_id);
			resultSet = pStat.executeQuery(); //Select
			user = new StaffUser();
			while(resultSet.next()) {
				user.setStaffID(resultSet.getInt("staff_id"));
				user.setAssignTask(resultSet.getString("assign_task"));
				
				
			}
		}
		catch(Exception ex) {
			System.out.println("Error : "+ex.getMessage());
		}
		return user;
	}
	
}
