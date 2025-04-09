package Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpageCRUD extends SpageDatabase implements InfSpageCRUD {

	private Connection connect1() {
	    try {
	        Connection conn = new SpageDatabase().getConnection();  // Ensure connection is established
	        if (conn == null) {
	            throw new SQLException("Database connection is null");
	        }
	        return conn;
	    } catch (SQLException ex) {
	        System.out.println("Database Connection Failed: " + ex.getMessage());
	        return null;
	    }
	}
	//Insert
	@Override
	public boolean insert(SpageUser user) {
		boolean result = false;
		
		String sql = "SELECT s.staff_id, s.assign_task, a.room_no, a.roomavaiablity, a.cleaningstatus " +
                "FROM staff s JOIN admin a ON s.staff_id = a.staff_id;";
		try (Connection conn=connect1();	
			PreparedStatement pStat=conn.prepareStatement(sql)){
			pStat.setInt(1, user.getStaffID());
            pStat.setString(2, user.getAssignedTask());
            
            pStat.setInt(3, user.getStaffID());
            pStat.setString(4,user.getRoomNo());
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
	
	private Connection connect() {
		// TODO Auto-generated method stub
		return null;
	}

	//search
	@Override
	public SpageUser search(int staff_id) {
		Connection conn;
		PreparedStatement pStat;
		ResultSet resultSet;
		String sqlQuery="select s.staff_id,s.assign_task,a.room_no, a.roomavaiablity, a.cleaningstatus FROM staff s\r\n"
				+ "JOIN admin a ON s.staff_id = a.staff_id=?;";
		SpageUser user = new SpageUser();
		
		try {
			conn = connect1();
			pStat = conn.prepareStatement(sqlQuery);
			pStat.setInt(1,staff_id);
			resultSet = pStat.executeQuery(); 
			user = new SpageUser();
			while(resultSet.next()) {
				user.setStaffID(resultSet.getInt("staff_id"));
				user.setAssignedTask(resultSet.getString("assign_task"));
				user.setRoomNo(resultSet.getString("room_no"));
				user.setRoomavaiability(resultSet.getString("roomavaiablity"));
				user.setCleaningStatus(resultSet.getString("cleaningstatus"));
				
			}
		}
		catch(Exception ex) {
			System.out.println("Error : "+ex.getMessage());
		}
		return user;
	}
	
//All data of staffs
	@Override
	public List<SpageUser> all() {
        List<SpageUser> users = new ArrayList<>();
        String sqlQuery = "SELECT s.staff_id, s.assign_task, a.room_no, a.roomavaiablity, a.cleaningstatus " +
                          "FROM staff s LEFT JOIN admin a ON s.staff_id = a.staff_id;";

        try (Connection conn = connect1();
             PreparedStatement pStat = conn.prepareStatement(sqlQuery);
             ResultSet resultSet = pStat.executeQuery()) {

            while (resultSet.next()) {
                SpageUser user = new SpageUser();
                user.setStaffID(resultSet.getInt("staff_id"));
                user.setAssignedTask(resultSet.getString("assign_task"));
                user.setRoomNo(resultSet.getString("room_no"));
                user.setRoomavaiability(resultSet.getString("roomavaiablity"));
                user.setCleaningStatus(resultSet.getString("cleaningstatus"));
                users.add(user);
                System.out.println(user);
            }
        } catch (Exception ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return users;
    }
}