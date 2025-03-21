package Admin;



import java.util.List;

import Amenities.AmenitiesUser;

	public interface InfAdminCRUD {
		public boolean insert(AdminUser user);
		public AdminUser search(int staff_id);
		public boolean update(AdminUser user);
		public boolean delete(int staff_no);
		public List all();
	}


