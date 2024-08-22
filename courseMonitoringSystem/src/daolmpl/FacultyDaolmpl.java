package daolmpl;

import dao.FacultyDao;
import model.Faculty;
import exception.DatabaseException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utility.DatabaseUtils;

//Implementation of the FacultyDao interface for managing Faculty records.
public class FacultyDaolmpl implements FacultyDao {

//	Creates a new faculty record in the database
    @Override
    public void createFaculty(Faculty faculty) throws DatabaseException {
        String sql = "INSERT INTO Faculty (facultyId, facultyName, facultyAddress, mobile, email, username, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, faculty.getFacultyId());
            stmt.setString(2, faculty.getFacultyName());
            stmt.setString(3, faculty.getFacultyAddress());
            stmt.setString(4, faculty.getMobile());
            stmt.setString(5, faculty.getEmail());
            stmt.setString(6, faculty.getUsername());
            stmt.setString(7, faculty.getPassword());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error creating faculty", e);
        }
    }

//     Retrieves a faculty record by its ID
    @Override
    public Faculty getFaculty(int facultyId) throws DatabaseException {
        String sql = "SELECT * FROM Faculty WHERE facultyId = ?";
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, facultyId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Faculty(
                    rs.getInt("facultyId"),
                    rs.getString("facultyName"),
                    rs.getString("facultyAddress"),
                    rs.getString("mobile"),
                    rs.getString("email"),
                    rs.getString("username"),
                    rs.getString("password")
                );
            }
            return null;
        } catch (SQLException e) {
            throw new DatabaseException("Error fetching faculty", e);
        }
    }

//    Updates an existing faculty record in the database.
    @Override
    public void updateFaculty(Faculty faculty) throws DatabaseException {
        String sql = "UPDATE Faculty SET facultyName = ?, facultyAddress = ?, mobile = ?, email = ?, username = ?, password = ? WHERE facultyId = ?";
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, faculty.getFacultyName());
            stmt.setString(2, faculty.getFacultyAddress());
            stmt.setString(3, faculty.getMobile());
            stmt.setString(4, faculty.getEmail());
            stmt.setString(5, faculty.getUsername());
            stmt.setString(6, faculty.getPassword());
            stmt.setInt(7, faculty.getFacultyId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error updating faculty", e);
        }
    }

//    Deletes a faculty record from the database based on the facultyId.
    @Override
    public void deleteFaculty(int facultyId) throws DatabaseException {
        String sql = "DELETE FROM Faculty WHERE facultyId = ?";
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, facultyId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error deleting faculty", e);
        }
    }
}
