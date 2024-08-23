package programming.HibernateCurdOperations;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	User user1=new User();
//    	user1.setId(1);
//    	user1.setName("chhaya");
//    	user1.setEmail("chhaya@gmail.com");
//    	user1.setPassword("chhaya123");
//    	user1.setGender("female");
//    	user1.setCity("Jabalpur");
    	
//    	User user2=new User();
//    	user2.setName("manish");
//    	user2.setEmail("manish@gmail.com");
//    	user2.setPassword("manish23");
//    	user2.setGender("male");
//    	user2.setCity("hyderabad");
    	
        Configuration cfg = new Configuration();
//        cfg.configure("/in/sp/confog/hibernate.cfg.xml");
        cfg.configure("/in/sp/config/hibernate.cfg.xml");
        
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        
//        insert operation-------
        
//        try {
//        	session.save(user2);
//            transaction.commit();
//            System.out.println("USER DETAILS ADDED SUCCESSFULLY");
//        }
//        catch(Exception e) {
//        	transaction.rollback();
//        	e.printStackTrace();
//        	
//        	System.out.println("USER DETAILS NOT ADDED DUE TO SOME ERROR");
//        }
        
//        --------select operation-----
//        try {
//        	User user=session.get(User.class, 2L);
//        	
//        	
//        	if(user!=null) {
//        		System.out.println(user.getId());
//            	System.out.println(user.getName());
//            	System.out.println(user.getEmail());
//            	System.out.println(user.getPassword());
//            	System.out.println(user.getGender());
//            	System.out.println(user.getCity());
//        	}
//        	else {
//        		System.out.println("USER NOT FOUND");
//        	}
//        }
//        catch(Exception e) {
//        	e.printStackTrace();
//        }
        
////        -------update operation------
//       
//      try {
//    	  User user=session.get(User.class, 2L);
//    	  user.setCity("bangalore");
//    	  
//      	session.saveOrUpdate(user);
//          transaction.commit();
//          System.out.println("USER DETAILS UPDATED SUCCESSFULLY");
//      }
//      catch(Exception e) {
//      	transaction.rollback();
//      	e.printStackTrace();
//      	
//      	System.out.println("USER DETAILS NOT UPDATED  DUE TO SOME ERROR");
//      }
        
        
        
//        ------delete operation----   
    try {
  	  
  	  	User user=new User();
  	  	user.setId(2L);
  	  	
    	session.delete(user);
        transaction.commit();
        System.out.println("USER DETAILS DELETED SUCCESSFULLY");
    }
    catch(Exception e) {
    	transaction.rollback();
    	e.printStackTrace();
    	
    	System.out.println("USER DETAILS NOT DELETED  DUE TO SOME ERROR");
    }
    }
}
