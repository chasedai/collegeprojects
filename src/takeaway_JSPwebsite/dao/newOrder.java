package takeaway_JSPwebsite.dao;

import java.sql.SQLException;

public class newOrder extends connectionBuilder{
	
	public boolean newOrder(String username, String coursename, String price) {
		// sql query
		connectDatabase();
		String newCourse = "insert into orders values('"+username+"','"
				+coursename+"','"
				+Float.parseFloat(price)+"',sysdate());";
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
