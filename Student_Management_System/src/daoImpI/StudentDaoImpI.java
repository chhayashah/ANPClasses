package daoImpI;

import java.sql.Connection;

import dao.StudentDao;

public class StudentDaoImpI implements StudentDao {
	
	
	String msg="Student is not registered";
	
	con=doSimple();
	try {
		ppst=con.prepareStatemet("insert into student values(?,?,?,?");
		ppst.setInt(1,s.getStudent_id());
		
		ppst.setString(2,s.getStudent_name());
		
		ppst.setInt(3,s.getStudent_marks());
		
	}
	
	return msg;

}
