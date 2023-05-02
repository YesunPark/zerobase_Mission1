import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 데이터베이스 접근 클래스 
public class HistoryDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public HistoryDAO() {
		
	}

	public void select() {
		
		try {
			String dbURL = "jdbc:mariadb://localhost:3306/mission1";
			String dbID = "mission1user";
			String dbPW = "mission1";
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPW);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String sql = "select * from location_history";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			int affectedRows = pstmt.executeUpdate();
			if (affectedRows > 0) {
				System.out.println("select 성공!");
			} else {
				System.out.println("select 실패!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	 public static void main(String[] args) {
		 HistoryDAO dbTest = new HistoryDAO();
//	        dbTest.dbSelect();  // static 메소드가 아니라서 바로 실행은 불가능. 인스턴스화하면 가능
//	        dbTest.dbInsert();
//	        dbTest.dbUpdate();
	        dbTest.select();
	    }
}
