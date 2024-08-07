package ANP8706;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDemo {

    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "root");

            // Prepare the SQL statement
            ps = con.prepareStatement("INSERT INTO register (name, email, password, gender, city) VALUES (?, ?, ?, ?, ?)");

            // Set the values for the prepared statement
            ps.setString(1, "ram");
            ps.setString(2, "ram@gmail.com");
            ps.setString(3, "ram123");
            ps.setString(4, "male");
            ps.setString(5, "hyderabad");

            // Execute the update
            int i = ps.executeUpdate();

            // Check the result
            if (i > 0) {
                System.out.println("Success");
            } else {
                System.out.println("Fail");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


