package dao;

import exception.StudentException;

public interface StudentDao {

	public String addStudent(Student s) throws StudentException;
	
	public String updateStudent(Student s) throws StudentException;
	
	public String deleteStudent(int studentId) throws StudentException;
	
	public List<Student> getAllStudent() throws StudentException;
	
	public Student getSingleStudentbyID() throws StudentException;

}
