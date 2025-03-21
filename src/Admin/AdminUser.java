package Admin;



public class AdminUser {
	
	private int StaffID;
	private String AvaiableStatus;
	private int RoomNo;
	private String Roomavaiability ;
	private String CleaningStatus;
	

	//Constructors, Setters, Getter, and toString
	
	public AdminUser() {
		
		this.StaffID = 0;
		this.RoomNo=0;
		this.AvaiableStatus = "";
		this.Roomavaiability = "";
		this.CleaningStatus = "";
		
	}
	
	public AdminUser( int StaffID, int RoomNo,String AvaiableStatus, String Roomavaiability, String CleaningStatus) {
		this.StaffID = StaffID;
		this.RoomNo=RoomNo;
		this.AvaiableStatus = AvaiableStatus;
		this.Roomavaiability = Roomavaiability;
		this.CleaningStatus = CleaningStatus;
		
	}
	
	public AdminUser(AdminUser user) {
		this.StaffID= user.StaffID;
		this.RoomNo=user.RoomNo;
		this.AvaiableStatus = user.AvaiableStatus;
		this.Roomavaiability = user.Roomavaiability;
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

	public int getRoomNo() {
		return RoomNo;
	}

	public void setRoomNo(int roomNo) {
		RoomNo = roomNo;
	}

	public String getRoomavaiability() {
		return Roomavaiability;
	}

	public void setRoomavaiability(String roomavaiability) {
		Roomavaiability = roomavaiability;
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
				+ ", Roomavaiability=" + Roomavaiability + ", CleaningStatus=" + CleaningStatus + "]";
	}
	
}
	