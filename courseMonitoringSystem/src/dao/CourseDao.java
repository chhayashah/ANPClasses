package dao;

import model.Course;
import exception.DatabaseException;

/**
 * DAO Interface for Course operations.
 */
public interface CourseDao {
	
//	Adds a new Course record
    void createCourse(Course course) throws DatabaseException;
    
//    Retrieves a Course by its ID.
    Course getCourse(int courseId) throws DatabaseException;
    
//    Updates an existing Course record
    void updateCourse(Course course) throws DatabaseException;
    
//    Deletes a Course by its ID
    void deleteCourse(int courseId) throws DatabaseException;
}
