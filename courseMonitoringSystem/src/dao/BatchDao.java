package dao;

import model.Batch;
import exception.DatabaseException;

/**
 * DAO Interface for Batch operations.
 */
public interface BatchDao {
	
//	Adds a new Batch record
    void createBatch(Batch batch) throws DatabaseException;
    
//    Retrieves a Batch by its ID
    Batch getBatch(int batchId) throws DatabaseException;
    
//    Updates an existing Batch record
    void updateBatch(Batch batch) throws DatabaseException;
    
//    Deletes a Batch by its ID
    void deleteBatch(int batchId) throws DatabaseException;
}
