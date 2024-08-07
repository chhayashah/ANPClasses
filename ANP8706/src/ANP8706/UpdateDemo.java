package ANP8706;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateDemo {
	public static void main(String[] args) throws Exception {
		String city1="pune";
		String email1="chh@gmail.com";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","root");
		PreparedStatement ps=con.prepareStatement("update register set city=? where email=?");
		// ?->postional parameter
		ps.setString(1, city1);
		ps.setString(2, email1);
		
		int count=ps.executeUpdate();
		if(count>0) {
			System.out.println("updated successfully");
		}else {
			System.out.println("updated failed");
		}
		con.close();
	}
}
