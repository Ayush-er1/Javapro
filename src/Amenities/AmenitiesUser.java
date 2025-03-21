package Amenities;



public class AmenitiesUser {

	private int RoomNo;
	private String Soap;
	private String Toothpaste;
	private String Toothbrush;
	private String Shampoo;
	
	public AmenitiesUser() {
		this.RoomNo = 0;
		this.Soap = "";
		this.Toothpaste = "";
		this.Toothbrush = "";
		this.Shampoo = "";
		
	}
	
	public AmenitiesUser(int RoomNo, String Soap, String Toothpaste, String Toothbrush, String Shampoo ) {
		this.RoomNo = RoomNo;
		this.Soap = Soap;
		this.Toothpaste = Toothpaste;
		this.Toothbrush = Toothbrush;
		this.Shampoo = Shampoo;
		
	}
	
	public AmenitiesUser (AmenitiesUser amenities) {
		this.RoomNo = amenities.RoomNo;
		this.Soap = amenities.Soap;
		this.Toothpaste = amenities.Toothpaste;
		this.Toothbrush = amenities.Toothbrush;
		this.Shampoo = amenities.Shampoo;

	}

	public int getRoomNo() {
		return RoomNo;
	}

	public void setRoomNo(int roomNo) {
		this.RoomNo = roomNo;
	}

	public String getSoap() {
		return Soap;
	}

	public void setSoap(String soap) {
		this.Soap = soap;
	}

	public String getToothpaste() {
		return Toothpaste;
	}

	public void setToothpaste(String toothpaste) {
		this.Toothpaste = toothpaste;
	}

	public String getToothbrush() {
		return Toothbrush;
	}

	public void setToothbrush(String toothbrush) {
		this.Toothbrush = toothbrush;
	}

	public String getShampoo() {
		return Shampoo;
	}

	public void setShampoo(String shampoo) {
		this.Shampoo = shampoo;
	}

	
	@Override
	public String toString() {
		return " Amenities [roomNo=" + RoomNo + ", soap=" + Soap + ", toothpaste=" + Toothpaste + ", toothbrush=" + Toothbrush
				+ ", shampoo=" + Shampoo + "]";
	}
}



