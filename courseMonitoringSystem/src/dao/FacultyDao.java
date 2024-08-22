package dao;

import model.Faculty;

import exception.DatabaseException;

/**
 * DAO Interface for Faculty operations.
 */
public interface FacultyDao {
	
//	Adds a new Faculty record
    void createFaculty(Faculty faculty) throws DatabaseException;
    
//    Retrieves a Faculty by its ID
    Faculty getFaculty(int facultyId) throws DatabaseException;
    
//    Updates an existing Faculty record
    void updateFaculty(Faculty faculty) throws DatabaseException;
    
//    Deletes a Faculty by its ID.
    void deleteFaculty(int facultyId) throws DatabaseException;
}
