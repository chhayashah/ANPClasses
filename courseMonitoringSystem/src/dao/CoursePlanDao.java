package dao;

import model.CoursePlan;
import exception.DatabaseException;

/**
 * DAO Interface for Course Plan operations.
 */
public interface CoursePlanDao {
	
//	Adds a new Course Plan record
    void createCoursePlan(CoursePlan coursePlan) throws DatabaseException;
    
//    Retrieves a Course Plan by its ID
    CoursePlan getCoursePlan(int planId) throws DatabaseException;
    
//     Updates an existing Course Plan record
    void updateCoursePlan(CoursePlan coursePlan) throws DatabaseException;
    
//    Deletes a Course Plan by its ID
    void deleteCoursePlan(int planId) throws DatabaseException;
}
