package anudip;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("con.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
			Statement st=con.createStatement();
			System.out.println("inserting records");
			String sql="Insert into student values(44)";
			st.executeUpdate(sql);
		}catch(Exception e) {
			System.out.print(e);
		}
	}

}
