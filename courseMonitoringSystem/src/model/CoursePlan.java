package model;

//Represents a course plan detailing the schedule for a batch.
public class CoursePlan {
    private int planId;
    private int batchId;
    private int dayNumber;
    private String topic;
    private String status;

    
//    Constructs a new CoursePlan with the specified details
    public CoursePlan(int planId, int batchId, int dayNumber, String topic, String status) {
        this.planId = planId;
        this.batchId = batchId;
        this.dayNumber = dayNumber;
        this.topic = topic;
        this.status = status;
    }

    // Getters and setters
    public int getPlanId() {
        return planId;
    }
    
    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public String getTopic() {
        return topic;
    }
    
    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CoursePlan [planId=" + planId + ", batchId=" + batchId + ", dayNumber=" + dayNumber + ", topic=" + topic
                + ", status=" + status + "]";
    }
}
