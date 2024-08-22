package daolmpl;

import dao.BatchDao;
import model.Batch;
import exception.DatabaseException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utility.DatabaseUtils;


//Implementation of BatchDao interface for managing Batch records in the database.
public class BatchDaolmpl implements BatchDao {

//	Adds a new Batch to the database.
    @Override
    public void createBatch(Batch batch) throws DatabaseException {
        String sql = "INSERT INTO Batch (batchId, courseId, facultyId, numberOfStudents, batchStartDate, duration) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, batch.getBatchId());
            stmt.setInt(2, batch.getCourseId());
            stmt.setInt(3, batch.getFacultyId());
            stmt.setInt(4, batch.getNumberOfStudents());
            stmt.setDate(5, batch.getBatchStartDate());
            stmt.setInt(6, batch.getDuration());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error creating batch", e);
        }
    }

//    Retrieves a Batch from the database based on the batchId
    @Override
    public Batch getBatch(int batchId) throws DatabaseException {
        String sql = "SELECT * FROM Batch WHERE batchId = ?";
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, batchId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Batch(
                    rs.getInt("batchId"),
                    rs.getInt("courseId"),
                    rs.getInt("facultyId"),
                    rs.getInt("numberOfStudents"),
                    rs.getDate("batchStartDate"),
                    rs.getInt("duration")
                );
            }
            return null;
        } catch (SQLException e) {
            throw new DatabaseException("Error fetching batch", e);
        }
    }

//    Updates an existing Batch record in the database
    @Override
    public void updateBatch(Batch batch) throws DatabaseException {
        String sql = "UPDATE Batch SET courseId = ?, facultyId = ?, numberOfStudents = ?, batchStartDate = ?, duration = ? WHERE batchId = ?";
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, batch.getCourseId());
            stmt.setInt(2, batch.getFacultyId());
            stmt.setInt(3, batch.getNumberOfStudents());
            stmt.setDate(4, batch.getBatchStartDate());
            stmt.setInt(5, batch.getDuration());
            stmt.setInt(6, batch.getBatchId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error updating batch", e);
        }
    }

//    Deletes a Batch record from the database based on the batchId
    @Override
    public void deleteBatch(int batchId) throws DatabaseException {
        String sql = "DELETE FROM Batch WHERE batchId = ?";
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, batchId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error deleting batch", e);
        }
    }
}
