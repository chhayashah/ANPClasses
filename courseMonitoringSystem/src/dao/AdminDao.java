package dao;

import model.Admin;
import exception.DatabaseException;

/**
 * DAO Interface for Admin operations.
 */
public interface AdminDao {

//	 Adds a new Admin record.
    void createAdmin(Admin admin) throws DatabaseException;
    
//    Retrieves an Admin by username.
    Admin getAdmin(String username) throws DatabaseException;
    
//    Updates an existing Admin record
    void updateAdmin(Admin admin) throws DatabaseException;
    
//    Deletes an Admin by username
    void deleteAdmin(String username) throws DatabaseException;
    

}
