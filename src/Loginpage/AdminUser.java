package Loginpage;


public class AdminUser {
	
	private int StaffID;
	private String AvaiableStatus;
	private String RoomNo;
	private String Roomavaiablity ;
	private String CleaningStatus;
	

	//Constructors, Setters, Getter, and toString
	
	public AdminUser() {
		
		this.StaffID = 0;
		this.RoomNo="";
		this.AvaiableStatus = "";
		this.Roomavaiablity = "";
		this.CleaningStatus = "";
		
	}
	
	public AdminUser( int StaffID, String RoomNo,String AvaiableStatus, String Roomavaiablity, String CleaningStatus) {
		this.StaffID = StaffID;
		this.RoomNo=RoomNo;
		this.AvaiableStatus = AvaiableStatus;
		this.Roomavaiablity = Roomavaiablity;
		this.CleaningStatus = CleaningStatus;
		
	}
	
	public AdminUser(AdminUser user) {
		this.StaffID= user.StaffID;
		this.RoomNo=user.RoomNo;
		this.AvaiableStatus = user.AvaiableStatus;
		this.Roomavaiablity = user.Roomavaiablity;
		this.CleaningStatus = user.CleaningStatus;
	
	}

	public int getStaffID() {
		return StaffID;
	}

	public void setStaffID(int staffID) {
		StaffID = staffID;
	}

	public String getAvaiableStatus() {
		return AvaiableStatus;
	}

	public void setAvaiableStatus(String avaiableStatus) {
		AvaiableStatus = avaiableStatus;
	}

	public String getRoomNo() {
		return RoomNo;
	}

	public void setRoomNo(String roomNo) {
		RoomNo = roomNo;
	}

	public String getRoomavaiablity() {
		return Roomavaiablity;
	}

	public void setRoomavaiablity(String roomavaiablity) {
		Roomavaiablity = roomavaiablity;
	}

	public String getCleaningStatus
	
	() {
		return CleaningStatus;
	}

	public void setCleaningStatus(String cleaningStatus) {
		CleaningStatus = cleaningStatus;
	}
//To String
	@Override
	public String toString() {
		return "AdminUser [StaffID=" + StaffID + ", AvaiableStatus=" + AvaiableStatus + ", RoomNo=" + RoomNo
				+ ", Roomavaiablity=" + Roomavaiablity + ", CleaningStatus=" + CleaningStatus + "]";
	}
	


}
