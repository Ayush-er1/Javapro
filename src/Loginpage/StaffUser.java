package Loginpage;

public class StaffUser {

		private int StaffID;
		private String AssignTask;

		//Default Constructor
		public StaffUser() {
			StaffID = 0;
			AssignTask = "";
		}
		//copy constructor
		public StaffUser(StaffUser view) {
			StaffID = view.StaffID;
			AssignTask = view.AssignTask;
		}
		//parameterized constructor
		public StaffUser(int staffID, String Assigntask) {

			StaffID = staffID;
			AssignTask = Assigntask;
		}

		//Getter
		public int getStaffID() {
			return StaffID;
		}
//setter
		public void setStaffID(int staffID) {
			StaffID = staffID;
		}

		public String getAssignTask() {
			return AssignTask;
		}

		public void setAssignTask(String Assigntask) {
			AssignTask = Assigntask;
		}

		@Override
		public String toString() {
			return "View [StaffID=" + StaffID + ", Task=" + AssignTask + "]";
		}

	}

