package Amenities;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserCRUD extends Database implements InfUserCRUD {



	//Insert
	@Override
	public boolean insert(AmenitiesUser user) {
		boolean result = false;
		PreparedStatement pStat;
		String sql = "INSERT INTO amenities (room_no, soap, toothpaste, toothbrush, Shampoo) VALUES (?, ?, ?, ?, ?)";

		try {
			pStat=connect().prepareStatement(sql);
			pStat.setInt(1, user.getRoomNo());
            pStat.setString(2, user.getSoap());
            pStat.setString(3, user.getToothpaste());
            pStat.setString(4, user.getToothbrush());
            pStat.setString(5, user.getShampoo());
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
	public AmenitiesUser search(int room_no) {
		Connection conn;
		PreparedStatement pStat;
		ResultSet resultSet;
		String sqlQuery="SELECT * FROM amenities WHERE room_no=?;";
		AmenitiesUser user = new AmenitiesUser();
		
		try {
			conn = connect();
			pStat = conn.prepareStatement(sqlQuery);
			pStat.setInt(1, room_no);
			resultSet = pStat.executeQuery(); //Select
			user = new AmenitiesUser();
			while(resultSet.next()) {
				user.setRoomNo(resultSet.getInt("room_no"));
				user.setSoap(resultSet.getString("soap"));
				user.setToothpaste(resultSet.getString("toothpaste"));
				user.setToothbrush(resultSet.getString("toothbrush"));
				user.setShampoo(resultSet.getString("Shampoo"));
				
			}
		}
		catch(Exception ex) {
			System.out.println("Error : "+ex.getMessage());
		}
		return user;
	}
	
	//select
	@Override
	public List all() {
		Connection conn;
		PreparedStatement pStat;
		ResultSet resultSet;
		String sqlQuery="SELECT * FROM amenities";
		List<AmenitiesUser> users = new ArrayList<AmenitiesUser>();		
		try {
			conn = connect();
			pStat = conn.prepareStatement(sqlQuery);
			resultSet = pStat.executeQuery(); //Select
			while(resultSet.next()) {
				AmenitiesUser user = new AmenitiesUser();
				user.setRoomNo(resultSet.getInt("RoomNo"));
				user.setSoap(resultSet.getString("Soap"));
				user.setToothpaste(resultSet.getString("Toothpaste"));
				user.setToothbrush(resultSet.getString("Toothbrush"));
				user.setShampoo(resultSet.getString("Shampoo"));
				
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
    public boolean update(AmenitiesUser user) {
		
		boolean result=false;
		Connection conn;
		String strSQL="UPDATE amenities SET soap=?, toothpaste=?, toothbrush=?, Shampoo=? WHERE room_no=?;";
		PreparedStatement pStat;
		
		try {
			conn = connect();
			pStat = conn.prepareStatement(strSQL);
			pStat.setString(1,user.getSoap());
            pStat.setString(2,user.getToothpaste());
            pStat.setString(3,user.getToothbrush());
            pStat.setString(4,user.getShampoo());
            pStat.setInt(5,user.getRoomNo());
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
	
	//Delete
	@Override
	public boolean delete(int roomNo) {		
		boolean result=false;
		Connection conn;
		String strSQL="DELETE FROM amenities WHERE room_no=?;";
		PreparedStatement pStat;		
		try {
			conn = connect();
			pStat = conn.prepareStatement(strSQL);
			 
			pStat.setInt(1,roomNo);		
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


