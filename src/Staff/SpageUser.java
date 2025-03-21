package Staff;



public class SpageUser {
	private int StaffID;
	private String AssignedTask;
	private int RoomNo;
	private String Roomavaiability ;
	private String CleaningStatus;
	

	//Constructors, Setters, Getter, and toString
	
	public SpageUser() {
		this.StaffID=0;
		this.AssignedTask="";
		this.RoomNo=0;
		this.Roomavaiability = "";
		this.CleaningStatus = "";
		
	}
	
	public SpageUser( int StaffID, String AssignedTask,int RoomNo, String Roomavaiability, String CleaningStatus) {
		this.StaffID = StaffID;
		this.AssignedTask = AssignedTask;
		this.RoomNo=RoomNo;
		this.Roomavaiability = Roomavaiability;
		this.CleaningStatus = CleaningStatus;
		
	}
	
	public SpageUser(SpageUser user) {
		this.StaffID= user.StaffID;
		this.AssignedTask = user.AssignedTask;
		this.RoomNo=user.RoomNo;	
		this.Roomavaiability = user.Roomavaiability;
		this.CleaningStatus = user.CleaningStatus;
	
	}

	public int getStaffID() {
		return StaffID;
	}

	public void setStaffID(int staffID) {
		StaffID = staffID;
	}

	public String getAssignedTask() {
		return AssignedTask;
	}

	public void setAssignedTask(String assignedTask) {
		AssignedTask = assignedTask;
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
		return "AdminUser [StaffID=" + StaffID + ", AssignedTask=" + AssignedTask + ", RoomNo=" + RoomNo
				+ ", Roomavaiability=" + Roomavaiability + ", CleaningStatus=" + CleaningStatus + "]";
	}
	


}




