package Amenities;


	import java.util.List;

	public interface InfUserCRUD {
		public boolean insert(AmenitiesUser user);
		public AmenitiesUser search(int room_no);
		public boolean update(AmenitiesUser user);
		public boolean delete(int room_no);
		public List all();
	}

