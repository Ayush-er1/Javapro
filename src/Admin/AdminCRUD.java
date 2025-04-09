package Admin;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdminCRUD extends AdminDatabase implements InfAdminCRUD {


	//Insert 
	@Override
	public boolean insert(AdminUser user) {
		boolean result = false;
		PreparedStatement pStat;
		String sql = "INSERT INTO admin (staff_id, avaiablestatus,room_no,roomavaiablity, cleaningstatus) VALUES (?, ?, ?, ?, ?);";

		try {
			pStat=connect().prepareStatement(sql);
			pStat.setInt(1, user.getStaffID());
            pStat.setString(2, user.getAvaiableStatus());
            pStat.setInt(3, user.getRoomNo());
            pStat.setString(4, user.getRoomavaiability());
            pStat.setString(5, user.getCleaningStatus());
			pStat.executeUpdate();
			pStat.close();
			result=true;
		}
		catch(Exception ex) {
			System.out.println("Error : "+ex.getMessage());
		}
		return result;
	}
	
	//search method
	@Override
	public AdminUser search(int staff_id) {
		Connection conn;
		PreparedStatement pStat;
		ResultSet resultSet;
		String sqlQuery="SELECT * FROM admin WHERE staff_id=?;";
		AdminUser user = new AdminUser();
		
		
		try {
			conn = connect();
			pStat = conn.prepareStatement(sqlQuery);
			pStat.setInt(1,staff_id);
			resultSet = pStat.executeQuery(); //Select
			user = new AdminUser();
			while(resultSet.next()) {
				user.setStaffID(resultSet.getInt("staff_id"));
				user.setAvaiableStatus(resultSet.getString("avaiablestatus"));
				user.setRoomNo(resultSet.getInt("room_no"));
				user.setRoomavaiability(resultSet.getString("roomavaiablity"));
				user.setCleaningStatus(resultSet.getString("cleaningstatus"));
				
			}
		}
		catch(Exception ex) {
			System.out.println("Error : "+ex.getMessage());
		}
		return user;
	}
	
	//select method
	@Override
	public List all() {
		Connection conn;
		PreparedStatement pStat;
		ResultSet resultSet;
		String sqlQuery="SELECT * FROM admin";
		List<AdminUser> users = new ArrayList<AdminUser>();		
		try {
			conn = connect();
			pStat = conn.prepareStatement(sqlQuery);
			resultSet = pStat.executeQuery(); //Select
			while(resultSet.next()) {
				AdminUser user = new AdminUser();
				user.setStaffID(resultSet.getInt("staff_id"));
				user.setAvaiableStatus(resultSet.getString("avaiablestatus"));
				user.setRoomNo(resultSet.getInt("room_no"));
				user.setRoomavaiability(resultSet.getString("roomavaiablity"));
				user.setCleaningStatus(resultSet.getString("cleaningstatus"));
				
				users.add(user);
			}
		}
		catch(Exception ex) {
			System.out.println("Error : "+ex.getMessage());
		}
		return users;
	}
	
	
	//update 
	@Override
    public boolean update(AdminUser user) {
		
		boolean result=false;
		Connection conn;
		String strSQL="UPDATE admin SET staff_id, avaiablestatus, room_no,roomavaiablity, cleaningstatus) VALUES (?, ?, ?, ?, ?);";
		PreparedStatement pStat;
		
		try {
			conn = connect();
			pStat = conn.prepareStatement(strSQL);
			pStat.setInt(1,user.getStaffID());
            pStat.setString(2,user.getAvaiableStatus());
            pStat.setInt(3,user.getRoomNo());
            pStat.setString(4,user.getRoomavaiability());
            pStat.setString(5,user.getCleaningStatus());
			pStat.executeUpdate(); 
			pStat.close();
			close(conn);
			result=true;
		}
		catch(Exception ex) {
			System.out.println("Error : "+ex.getMessage());
		}
		return result;
	}
	
	//Delete
	@Override
	public boolean delete(int staffID) {		
		boolean result=false;
		Connection conn;
		String strSQL="DELETE FROM admin WHERE staff_id=?;";
		PreparedStatement pStat;		
		try {
			conn = connect();
			pStat = conn.prepareStatement(strSQL);
			 
			pStat.setInt(1,staffID);		
			pStat.executeUpdate(); //insert, update, delete
			pStat.close();
			close(conn);
			result=true;
		}
		catch(Exception ex) {
			System.out.println("Error : "+ex.getMessage());
		}
		return result;
	}

}




