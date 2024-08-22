package daolmpl;

import dao.AdminDao;

import model.Admin;
import exception.DatabaseException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utility.DatabaseUtils;

//Implementation of AdminDao interface for managing Admin records in the database

public class AdminDaolmpl implements AdminDao {

    @Override
//    Adds a new Admin to the database.
    public void createAdmin(Admin admin) throws DatabaseException {
        String sql = "INSERT INTO Admin (username, password) VALUES (?, ?)";
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, admin.getUsername());
            stmt.setString(2, admin.getPassword());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error creating admin", e);
        }
    }
    
//    Retrieves an Admin from the database based on the username.
    @Override
    public Admin getAdmin(String username) throws DatabaseException {
        String sql = "SELECT * FROM Admin WHERE username = ?";
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Admin(
                    rs.getString("username"),
                    rs.getString("password")
                );
            }
            return null;
        } catch (SQLException e) {
            throw new DatabaseException("Error fetching admin", e);
        }
    }

//    Updates the password of an existing Admin in the database
    @Override
    public void updateAdmin(Admin admin) throws DatabaseException {
        String sql = "UPDATE Admin SET password = ? WHERE username = ?";
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, admin.getPassword());
            stmt.setString(2, admin.getUsername());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error updating admin", e);
        }
    }

//    Deletes an Admin record from the database based on the username
    @Override
    public void deleteAdmin(String username) throws DatabaseException {
        String sql = "DELETE FROM Admin WHERE username = ?";
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error deleting admin", e);
        }
    }
}
