package main;

import dao.AdminDao;

import dao.BatchDao;
import dao.CourseDao;
import dao.CoursePlanDao;
import dao.FacultyDao;
import daolmpl.AdminDaolmpl;
import daolmpl.BatchDaolmpl;
import daolmpl.CourseDaoImpl;
import daolmpl.CoursePlanDaolmpl;
import daolmpl.FacultyDaolmpl;
import exception.DatabaseException;
import model.Admin;
import model.Batch;
import model.Course;
import model.CoursePlan;
import model.Faculty;

import java.math.BigDecimal;
import java.sql.Date; // Import for Date handling
import java.util.Scanner;

/**
 * Main class to interact with the user and perform operations.
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    
//    Entry point of the application. Displays the main menu and handles user input
//     to perform operations based on user choices.

    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter 1 for Admin Stuff");
            System.out.println("Enter 2 for Faculty Stuff");
            System.out.println("Enter 3 for Course Stuff");
            System.out.println("Enter 4 for Batch Stuff");
            System.out.println("Enter 5 for Course Plan Stuff");
            System.out.println("Enter 6 to Exit");

            int choice = getValidIntInput();
            
            switch (choice) {
                case 1:
                    handleAdminOperations();
                    break;
                case 2:
                    handleFacultyOperations();
                    break;
                case 3:
                    handleCourseOperations();
                    break;
                case 4:
                    handleBatchOperations();
                    break;
                case 5:
                    handleCoursePlanOperations();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

//    Prompts the user to enter an integer and validates the input.
    private static int getValidIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
    
    
//    Prompts the user to enter a double and validates the input
    private static double getValidDoubleInput() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

//    Handles operations related to Admin entities based on user input.
    private static void handleAdminOperations() {
        AdminDao adminDao = new AdminDaolmpl();
        System.out.println("Enter 1 to Create Admin");
        System.out.println("Enter 2 to Get Admin");
        System.out.println("Enter 3 to Update Admin");
        System.out.println("Enter 4 to Delete Admin");

        int choice = getValidIntInput();

        try {
            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    Admin admin = new Admin(username, password);
                    adminDao.createAdmin(admin);
                    System.out.println("Admin created successfully.");
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    Admin fetchedAdmin = adminDao.getAdmin(username);
                    if (fetchedAdmin != null) {
                        System.out.println("Admin found: " + fetchedAdmin);
                    } else {
                        System.out.println("Admin not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter new password: ");
                    password = scanner.nextLine();
                    admin = new Admin(username, password);
                    adminDao.updateAdmin(admin);
                    System.out.println("Admin updated successfully.");
                    break;
                case 4:
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    adminDao.deleteAdmin(username);
                    System.out.println("Admin deleted successfully.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } catch (DatabaseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

//    Handles operations related to Faculty entities based on user input.
    private static void handleFacultyOperations() {
        FacultyDao facultyDao = new FacultyDaolmpl();
        System.out.println("Enter 1 to Create Faculty");
        System.out.println("Enter 2 to Get Faculty");
        System.out.println("Enter 3 to Update Faculty");
        System.out.println("Enter 4 to Delete Faculty");

        int choice = getValidIntInput();

        try {
            switch (choice) {
                case 1:
                	// Variables for creating a faculty
                    System.out.print("Enter faculty ID: ");
                    int facultyId = getValidIntInput();
                    System.out.print("Enter faculty name: ");
                    String facultyName = scanner.nextLine();
                    System.out.print("Enter faculty address: ");
                    String facultyAddress = scanner.nextLine();
                    System.out.print("Enter mobile number: ");
                    String mobile = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    Faculty faculty = new Faculty(facultyId, facultyName, facultyAddress, mobile, email, username, password);
                    facultyDao.createFaculty(faculty);
                    System.out.println("Faculty created successfully.");
                    break;
                case 2:
                	// Variables for getting a faculty
                    System.out.print("Enter faculty ID: ");
                    facultyId = getValidIntInput();
                    Faculty fetchedFaculty = facultyDao.getFaculty(facultyId);
                    if (fetchedFaculty != null) {
                        System.out.println("Faculty found: " + fetchedFaculty);
                    } else {
                        System.out.println("Faculty not found.");
                    }
                    break;
                case 3:
                	   // Variables for updating a faculty
                    System.out.print("Enter faculty ID: ");
                    facultyId = getValidIntInput();
                    System.out.print("Enter new faculty name: ");
                    facultyName = scanner.nextLine();
                    System.out.print("Enter new faculty address: ");
                    facultyAddress = scanner.nextLine();
                    System.out.print("Enter new mobile number: ");
                    mobile = scanner.nextLine();
                    System.out.print("Enter new email: ");
                    email = scanner.nextLine();
                    System.out.print("Enter new username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter new password: ");
                    password = scanner.nextLine();
                    
                    faculty = new Faculty(facultyId, facultyName, facultyAddress, mobile, email, username, password);
                    facultyDao.updateFaculty(faculty);
                    System.out.println("Faculty updated successfully.");
                    break;
                case 4:
                    System.out.print("Enter faculty ID: ");
                    facultyId = getValidIntInput();
                    facultyDao.deleteFaculty(facultyId);
                    System.out.println("Faculty deleted successfully.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } catch (DatabaseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void handleCourseOperations() {
        CourseDao courseDao = new CourseDaoImpl();
        System.out.println("Enter 1 to Create Course");
        System.out.println("Enter 2 to Get Course");
        System.out.println("Enter 3 to Update Course");
        System.out.println("Enter 4 to Delete Course");

        int choice = getValidIntInput();

        try {
            switch (choice) {
            case 1:
                System.out.print("Enter course ID: ");
                int courseId = getValidIntInput();
                System.out.print("Enter course name: ");
                String courseName = scanner.nextLine();
                System.out.print("Enter fee: ");
                BigDecimal fee = new BigDecimal(scanner.nextLine());
                System.out.print("Enter course description: ");
                String courseDescription = scanner.nextLine();
                Course course = new Course(courseId, courseName, fee, courseDescription);
                courseDao.createCourse(course);
                System.out.println("Course created successfully.");
                break;
                case 2:
                    System.out.print("Enter course ID: ");
                    courseId = getValidIntInput();
                    Course fetchedCourse = courseDao.getCourse(courseId);
                    if (fetchedCourse != null) {
                        System.out.println("Course found: " + fetchedCourse);
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;
                case 3:
                	System.out.print("Enter course ID: ");
                    courseId = getValidIntInput();
                    System.out.print("Enter new course name: ");
                    courseName = scanner.nextLine();
                    System.out.print("Enter new fee: ");
                    fee = new BigDecimal(scanner.nextLine());
                    System.out.print("Enter new course description: ");
                    courseDescription = scanner.nextLine();
                    course = new Course(courseId, courseName, fee, courseDescription);
                    courseDao.updateCourse(course);
                    System.out.println("Course updated successfully.");
                    break;
                case 4:
                    System.out.print("Enter course ID: ");
                    courseId = getValidIntInput();
                    courseDao.deleteCourse(courseId);
                    System.out.println("Course deleted successfully.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } catch (DatabaseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void handleBatchOperations() {
        BatchDao batchDao = new BatchDaolmpl();
        System.out.println("Enter 1 to Create Batch");
        System.out.println("Enter 2 to Get Batch");
        System.out.println("Enter 3 to Update Batch");
        System.out.println("Enter 4 to Delete Batch");

        int choice = getValidIntInput();

        try {
            switch (choice) {
                case 1:
                	  System.out.print("Enter batch ID: ");
                      int batchId = getValidIntInput();
                      System.out.print("Enter course ID: ");
                      int courseId = getValidIntInput();
                      System.out.print("Enter faculty ID: ");
                      int facultyId = getValidIntInput();
                      System.out.print("Enter number of students: ");
                      int numberOfStudents = getValidIntInput();
                      System.out.print("Enter batch start date (YYYY-MM-DD): ");
                      Date batchStartDate = Date.valueOf(scanner.nextLine());
                      System.out.print("Enter duration (in months): ");
                      int duration = getValidIntInput();
                      
                      Batch batch = new Batch(batchId, courseId, facultyId, numberOfStudents, batchStartDate, duration);
                      batchDao.createBatch(batch);
                      System.out.println("Batch created successfully.");
                      break;
                case 2:
                    System.out.print("Enter batch ID: ");
                    batchId = getValidIntInput();
                    Batch fetchedBatch = batchDao.getBatch(batchId);
                    if (fetchedBatch != null) {
                        System.out.println("Batch found: " + fetchedBatch);
                    } else {
                        System.out.println("Batch not found.");
                    }
                    break;
                case 3:
                	System.out.print("Enter batch ID: ");
                    batchId = getValidIntInput();
                    System.out.print("Enter new course ID: ");
                    courseId = getValidIntInput();
                    System.out.print("Enter new faculty ID: ");
                    facultyId = getValidIntInput();
                    System.out.print("Enter new number of students: ");
                    numberOfStudents = getValidIntInput();
                    System.out.print("Enter new batch start date (YYYY-MM-DD): ");
                    batchStartDate = Date.valueOf(scanner.nextLine());
                    System.out.print("Enter new duration (in months): ");
                    duration = getValidIntInput();
                    
                    batch = new Batch(batchId, courseId, facultyId, numberOfStudents, batchStartDate, duration);
                    batchDao.updateBatch(batch);
                    System.out.println("Batch updated successfully.");
                    break;
                case 4:
                    System.out.print("Enter batch ID: ");
                    batchId = getValidIntInput();
                    batchDao.deleteBatch(batchId);
                    System.out.println("Batch deleted successfully.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } catch (DatabaseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private static Date getValidDateInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Date.valueOf(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
            }
        }
    }

    private static void handleCoursePlanOperations() {
        CoursePlanDao coursePlanDao = new CoursePlanDaolmpl();
        System.out.println("Enter 1 to Create Course Plan");
        System.out.println("Enter 2 to Get Course Plan");
        System.out.println("Enter 3 to Update Course Plan");
        System.out.println("Enter 4 to Delete Course Plan");

        int choice = getValidIntInput();

        try {
            switch (choice) {
                case 1:
                    System.out.print("Enter plan ID: ");
                    int planId = getValidIntInput();
                    System.out.print("Enter batch ID: ");
                    int batchId = getValidIntInput();
                    System.out.print("Enter day number: ");
                    int dayNumber = getValidIntInput();
                    System.out.print("Enter topic: ");
                    String topic = scanner.nextLine();
                    System.out.print("Enter status: ");
                    String status = scanner.nextLine();
                    CoursePlan coursePlan = new CoursePlan(planId, batchId, dayNumber, topic, status);
                    coursePlanDao.createCoursePlan(coursePlan);
                    System.out.println("Course Plan created successfully.");
                    break;
                case 2:
                    System.out.print("Enter plan ID: ");
                    planId = getValidIntInput();
                    CoursePlan fetchedCoursePlan = coursePlanDao.getCoursePlan(planId);
                    if (fetchedCoursePlan != null) {
                        System.out.println("Course Plan found: " + fetchedCoursePlan);
                    } else {
                        System.out.println("Course Plan not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter plan ID: ");
                    planId = getValidIntInput();
                    System.out.print("Enter new batch ID: ");
                    batchId = getValidIntInput();
                    System.out.print("Enter new day number: ");
                    dayNumber = getValidIntInput();
                    System.out.print("Enter new topic: ");
                    topic = scanner.nextLine();
                    System.out.print("Enter new status: ");
                    status = scanner.nextLine();
                    coursePlan = new CoursePlan(planId, batchId, dayNumber, topic, status);
                    coursePlanDao.updateCoursePlan(coursePlan);
                    System.out.println("Course Plan updated successfully.");
                    break;
                case 4:
                    System.out.print("Enter plan ID: ");
                    planId = getValidIntInput();
                    coursePlanDao.deleteCoursePlan(planId);
                    System.out.println("Course Plan deleted successfully.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } catch (DatabaseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
