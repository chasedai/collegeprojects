package takeaway_JSPwebsite.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import takeaway_JSPwebsite.models.user;

public class userValidator extends connectionBuilder {

	public boolean validate(String username, String password) {
		// sql query
		connectDatabase();
		String validateExistQuery = "select * from user where username = '"
				+ username + "';";
		ResultSet rs;
		try {
			rs = stmt.executeQuery(validateExistQuery);
			if (rs.next()) {
				String db_password = rs.getString("u_password");
				if (db_password.equals(password)) {
					stmt.close();
					conn.close();
					return true;
				}
			} else {
				stmt.close();
				conn.close();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public user returnUser(String username) {
		connectDatabase();
		String getUser = "select * from user where username = '" + username
				+ "';";
		ResultSet rs;
		try {
			rs = stmt.executeQuery(getUser);
			rs.next();
			String password = rs.getString("u_password");
			String address = rs.getString("address");
			String phone = rs.getString("phone");
			user User = new user(username, password, address, phone);
			return User;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public boolean changeInfo(String username, String password, String address,
			String phone) {

		connectDatabase();
		String updateInfo = "update user SET u_password='" + password
				+ "', address='" + address + "',phone='" + phone
				+ "' WHERE username='" + username + "'";
		ResultSet rs;
		try {
			stmt.executeUpdate(updateInfo);
			stmt.close();
			conn.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
