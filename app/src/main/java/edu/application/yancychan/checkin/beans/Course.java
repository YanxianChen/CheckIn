package edu.application.yancychan.checkin.beans;

import java.sql.Time;

/**
 * Created by yancychan on 17-4-6.
 */

public class Course {

    private int courseId;

    private String courseName;

    private String courseTeacher;

    private int numberOfStudent;

    private Time classTime;

    public Course(String courseName, int courseId, int numberOfStudent){
        this.courseName = courseName;
        this.courseId = courseId;
        this.numberOfStudent = numberOfStudent;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getNumberOfStudent() {
        return numberOfStudent;
    }

    public void setNumberOfStudent(int numberOfStudent) {
        this.numberOfStudent = numberOfStudent;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

}
