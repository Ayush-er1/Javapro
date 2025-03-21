package Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SpageCRUD extends SpageDatabase implements InfSpageCRUD {


	//Insert
	@Override
	public boolean insert(SpageUser user) {
		boolean result = false;
		
		String sql = "INSERT INTO staff (staff_id, assign_task) VALUES (?, ?);"
          + "INSERT INTO admin (staff_id, room_no, roomavaiablity, cleaningstatus) VALUES (?, ?, ?, ?);";

		try (Connection conn=connect();	
			PreparedStatement pStat=conn.prepareStatement(sql)){
			pStat.setInt(1, user.getStaffID());
            pStat.setString(2, user.getAssignedTask());
            
            pStat.setInt(3, user.getStaffID());
            pStat.setInt(4,user.getRoomNo());
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
			conn = connect();
			pStat = conn.prepareStatement(sqlQuery);
			pStat.setInt(1,staff_id);
			resultSet = pStat.executeQuery(); 
			user = new SpageUser();
			while(resultSet.next()) {
				user.setStaffID(resultSet.getInt("staff_id"));
				user.setAssignedTask(resultSet.getString("assign_task"));
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
	
//All data of staffs
	
@Override
public List<SpageUser> all() {
    Connection conn;
    PreparedStatement pStat;
    ResultSet resultSet;
    List<SpageUser> users = new ArrayList<>();
    String sqlQuery = "SELECT s.staff_id, s.assign_task, a.room_no, a.roomavaiablity, a.cleaningstatus " +
                    "FROM staff s " + "JOIN admin a ON s.staff_id = a.staff_id;";

        try {
        conn = connect();
        pStat = conn.prepareStatement(sqlQuery);
        resultSet = pStat.executeQuery();

               while (resultSet.next()) {
            SpageUser user = new SpageUser();
            user.setStaffID(resultSet.getInt("staff_id"));
            user.setAssignedTask(resultSet.getString("assign_task"));
            user.setRoomNo(resultSet.getInt("room_no"));
            user.setRoomavaiability(resultSet.getString("roomavaiablity"));
            user.setCleaningStatus(resultSet.getString("cleaningstatus"));
            users.add(user);
        }
           } catch (Exception ex) {
        System.out.println("Error : " + ex.getMessage());
    }
    return users;
}
}


