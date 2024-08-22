package daolmpl;

import dao.CoursePlanDao;
import model.CoursePlan;
import exception.DatabaseException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utility.DatabaseUtils;

//Implementation of the CoursePlanDao interface for managing CoursePlan records
public class CoursePlanDaolmpl implements CoursePlanDao {

	
//	Creates a new course plan record in the database
    @Override
    public void createCoursePlan(CoursePlan coursePlan) throws DatabaseException {
        String sql = "INSERT INTO CoursePlan (planId, batchId, dayNumber, topic, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, coursePlan.getPlanId());
            stmt.setInt(2, coursePlan.getBatchId());
            stmt.setInt(3, coursePlan.getDayNumber());
            stmt.setString(4, coursePlan.getTopic());
            stmt.setString(5, coursePlan.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error creating course plan", e);
        }
    }
    
//    Retrieves a course plan record by its ID.
    @Override
    public CoursePlan getCoursePlan(int planId) throws DatabaseException {
        String sql = "SELECT * FROM CoursePlan WHERE planId = ?";
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, planId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new CoursePlan(
                    rs.getInt("planId"),
                    rs.getInt("batchId"),
                    rs.getInt("dayNumber"),
                    rs.getString("topic"),
                    rs.getString("status")
                );
            }
            return null;
        } catch (SQLException e) {
            throw new DatabaseException("Error fetching course plan", e);
        }
    }

//    Updates an existing course plan record in the database
    @Override
    public void updateCoursePlan(CoursePlan coursePlan) throws DatabaseException {
        String sql = "UPDATE CoursePlan SET batchId = ?, dayNumber = ?, topic = ?, status = ? WHERE planId = ?";
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, coursePlan.getBatchId());
            stmt.setInt(2, coursePlan.getDayNumber());
            stmt.setString(3, coursePlan.getTopic());
            stmt.setString(4, coursePlan.getStatus());
            stmt.setInt(5, coursePlan.getPlanId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error updating course plan", e);
        }
    }

//    Deletes a course plan record from the database based on the planId
    @Override
    public void deleteCoursePlan(int planId) throws DatabaseException {
        String sql = "DELETE FROM CoursePlan WHERE planId = ?";
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, planId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error deleting course plan", e);
        }
    }
}
