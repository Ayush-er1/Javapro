package Loginpage;

public class StaffUser {

		private int StaffID;
		private String AssignTask;

		public StaffUser() {
			StaffID = 0;
			AssignTask = "";
		}
		public StaffUser(StaffUser view) {
			StaffID = view.StaffID;
			AssignTask = view.AssignTask;
		}
		public StaffUser(int staffID, String Assigntask) {

			StaffID = staffID;
			AssignTask = Assigntask;
		}

		public int getStaffID() {
			return StaffID;
		}

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

