package model;

import java.math.BigDecimal;

//Represents a course in the course management system.
public class Course {
    private int courseId;
    private String courseName;
    private BigDecimal fee;
    private String courseDescription;

    
//    Constructs a new Course with the specified details.
    public Course(int courseId, String courseName, BigDecimal fee, String courseDescription) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.fee = fee;
        this.courseDescription = courseDescription;
    }

    // Getters and setters
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    @Override
    public String toString() {
        return "Course{" +
               "courseId=" + courseId +
               ", courseName='" + courseName + '\'' +
               ", fee=" + fee +
               ", courseDescription='" + courseDescription + '\'' +
               '}';
    }
}
