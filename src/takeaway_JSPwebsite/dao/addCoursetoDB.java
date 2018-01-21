package takeaway_JSPwebsite.dao;

import java.sql.SQLException;

public class addCoursetoDB extends connectionBuilder{

	public boolean newCourse(String courseName, String courseType, String courseDescription, String coursePrice) {
		// sql query
		connectDatabase();
		String newCourse = "insert into courses values('"+courseName+"','"
				+courseType+"','"
				+courseDescription+"','"
				+coursePrice+"');";
		try {
			stmt.executeUpdate(newCourse);
			stmt.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
