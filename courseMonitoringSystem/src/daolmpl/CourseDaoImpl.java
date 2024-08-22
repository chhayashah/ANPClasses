package daolmpl;

import dao.CourseDao;
import model.Course;
import exception.DatabaseException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.BigDecimal;
import utility.DatabaseUtils;

/**
 * Implementation of the CourseDao interface for managing Course records.
 */
public class CourseDaoImpl implements CourseDao {

//     Creates a new course record in the database.
     
    @Override
    public void createCourse(Course course) throws DatabaseException {
        String sql = "INSERT INTO Course (courseId, courseName, fee, courseDescription) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, course.getCourseId());
            stmt.setString(2, course.getCourseName());
            stmt.setBigDecimal(3, course.getFee()); // Use setBigDecimal for BigDecimal
            stmt.setString(4, course.getCourseDescription());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error creating course", e);
        }
    }

//     Retrieves a course record by its ID.
    
    @Override
    public Course getCourse(int courseId) throws DatabaseException {
        String sql = "SELECT * FROM Course WHERE courseId = ?";
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, courseId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Course(
                    rs.getInt("courseId"),
                    rs.getString("courseName"),
                    rs.getBigDecimal("fee"), // Use getBigDecimal for BigDecimal
                    rs.getString("courseDescription")
                );
            }
            return null;
        } catch (SQLException e) {
            throw new DatabaseException("Error fetching course", e);
        }
    }

//     Updates an existing course record in the database.
    
    @Override
    public void updateCourse(Course course) throws DatabaseException {
        String sql = "UPDATE Course SET courseName = ?, fee = ?, courseDescription = ? WHERE courseId = ?";
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, course.getCourseName());
            stmt.setBigDecimal(2, course.getFee()); // Use setBigDecimal for BigDecimal
            stmt.setString(3, course.getCourseDescription());
            stmt.setInt(4, course.getCourseId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error updating course", e);
        }
    }

//     Deletes a course record from the database.
     
    @Override
    public void deleteCourse(int courseId) throws DatabaseException {
        String sql = "DELETE FROM Course WHERE courseId = ?";
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, courseId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error deleting course", e);
        }
    }
}
