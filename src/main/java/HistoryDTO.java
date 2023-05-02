import java.util.Date;
// 위치 히스토리를 담는 클래스 
public class HistoryDTO {
	private int id;
	private double xCoordinate;
	private double yCoordinate;
	private Date lookupDate;
	
	// 생성자 
	public HistoryDTO() {}
	public HistoryDTO(int id, double xCoordinate, double yCoordinate, Date lookupDate) {
		super();
		this.id = id;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.lookupDate = lookupDate;
	}
	
	// 게터&세터 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getxCoordinate() {
		return xCoordinate;
	}
	public void setxCoordinate(double xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	public double getyCoordinate() {
		return yCoordinate;
	}
	public void setyCoordinate(double yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	public Date getLookupDate() {
		return lookupDate;
	}
	public void setLookupDate(Date lookupDate) {
		this.lookupDate = lookupDate;
	}
	
	@Override
	public String toString() {
		return "HistoryDTO [id=" + id + ", xCoordinate=" + xCoordinate + ", yCoordinate=" + yCoordinate
				+ ", lookupDate=" + lookupDate + "]";
	}
	
	
}
