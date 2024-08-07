package anudip;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import anudip.ConnectionFactory;

public class StudentCrudIOperations {
	
	Connection con=null;
	PreparedStatement ppst=null;
	ResultSet rs=null;
	
	public Connection doSimple() {
		Connection connection=null;
		try {
			connection=ConnectionFactory.getConnectionFactory().getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	
	
	
	
	
	
	// crud  - create , read   , update  , delete 
		public void addStudent(Student s ) {
			
			try {
				con = doSimple();
//				Connection c  = ConnectionFactory.getConnectionFactory().getConnection() ;
//				PreparedStatement ppst  = c.prepareStatement("insert into stud values(?, ? ,?)") ;
				 ppst  = con.prepareStatement("insert into stud values(?, ? ,?)") ;
				ppst.setInt(1, s.getStudent_id());
				ppst.setString(2, s.getStudent_name()) ;
				ppst.setInt(3,  s.getStudent_marks()) ;
				
				int ans  = ppst.executeUpdate() ; // one row mai data  insert huva hai 
				
				if (ans != 0) {
					System.out.println("data got inserted succesfully ");
				}else {
					System.out.println("some thing went wrong");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				
				try {
					if (ppst !=  null) {
						ppst.close();

					}
					if (con != null) {
						con.close();
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			}
		
		
		public void updateData(Student s) {
			
			
			try {
				con= doSimple() ;
				ppst  =  con.prepareStatement("update Stud set smarks  = ? where  sid =  ? " );
				ppst.setInt(1, s.getStudent_marks());
				ppst.setInt(2, s.getStudent_id());
		        int	ans = ppst.executeUpdate() ;
		        if (ans != 0) {
					System.out.println("data got updated succesfully ");
				}else {
					System.out.println("some thing went wrong");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				
				try {
					if (ppst !=  null) {
						ppst.close();

					}
					if (con != null) {
						con.close();
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

			
		}
//		public void deleteStudent(int studentId) {
//		    try {
//		        con = doSimple();
//		        ppst = con.prepareStatement("DELETE FROM Stud WHERE sid = ?");
//		        ppst.setInt(1, studentId);
//		        
//		        int ans = ppst.executeUpdate();
//		        
//		        if (ans != 0) {
//		            System.out.println("Data got deleted successfully.");
//		        } else {
//		            System.out.println("Something went wrong.");
//		        }
//		    } catch (SQLException e) {
//		        e.printStackTrace();
//		    } finally {
//		        try {
//		            if (ppst != null) {
//		                ppst.close();
//		            }
//		            if (con != null) {
//		                con.close();
//		            }
//		        } catch (SQLException e) {
//		            e.printStackTrace();
//		        }
//		    }
//		}
		
    }

		