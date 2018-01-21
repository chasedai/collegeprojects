package takeaway_JSPwebsite.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class userRegister extends connectionBuilder{

	public boolean newUser(String username, String password, String address, String phone) {
		// sql query
		connectDatabase();
		String newUser = "insert into user values('"+username+"','"
				+password+"','"
				+address+"','"
				+phone+"');";
		try {
			stmt.executeUpdate(newUser);
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
