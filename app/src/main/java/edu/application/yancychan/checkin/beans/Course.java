package edu.application.yancychan.checkin.beans;

import org.litepal.crud.DataSupport;

import java.sql.Time;

/**
 * Created by yancychan on 17-4-6.
 */

public class Course extends DataSupport{

    private Time classTime;
    private int courseId;
    private int numberOfStudent;
    private String courseName;
    private String courseTeacher;
    private String classLocation;

    public Course() {
    }

    public Course(String courseName, int courseId, int numberOfStudent) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.numberOfStudent = numberOfStudent;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    public Time getClassTime() {
        return classTime;
    }

    public void setClassTime(Time classTime) {
        this.classTime = classTime;
    }

    public String getClassLocation() {
        return classLocation;
    }

    public void setClassLocation(String classLocation) {
        this.classLocation = classLocation;
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
