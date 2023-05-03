package location;

import java.sql.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

// 데이터베이스 접근 클래스 
public class HistoryDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public HistoryDAO() {

	}

	// 내가 조회한 위치 히스토리 저장
	public int saveLocationHistory(double xCoordinateValue, double yCoordinateValue) {
		String dbURL = "jdbc:mariadb://localhost:3306/mission1";
		String dbID = "mission1user";
		String dbPW = "mission1";

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String lookupDate = (LocalDateTime.now()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		try {
			conn = DriverManager.getConnection(dbURL, dbID, dbPW);

			String sql = "INSERT INTO location_history ( x_coordinate, y_coordinate, lookup_date )\n"
					+ "VALUES ( ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, xCoordinateValue);
			pstmt.setDouble(2, yCoordinateValue);
			pstmt.setString(3, lookupDate);

			int affectedRows = pstmt.executeUpdate();
			if (affectedRows > 0) {
				return 1; // 저장 성공
			} else {
				return -1; // 저장 실패
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

		return -2; // 데이터베이스 오류
	}

	// 테스트용 메서드
	public String selectTest() {
		String dbURL = "jdbc:mariadb://localhost:3306/mission1";
		String dbID = "mission1user";
		String dbPW = "mission1";

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection(dbURL, dbID, dbPW);

			String sql = "select * from location_history";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String xCoordinate = rs.getString("x_coordinate");
				String yCoordinate = rs.getString("y_coordinate");

				return id + ", " + xCoordinate + ", " + yCoordinate;
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
		return "데이터베이스 오류입니다!";
	}

	// 테스트용 메인 함수
	public static void main(String[] args) {
		HistoryDAO dbTest = new HistoryDAO();
//		System.out.println(dbTest.selectTest());
		System.out.println(dbTest.saveLocationHistory(4.1111, 4.2222));

	}
}
