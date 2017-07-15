package edu.application.yancychan.checkin.beans;

import org.litepal.crud.DataSupport;

/**
 * Created by yancychan on 17-7-4.
 */

public class Student extends DataSupport{

    private int studentId;  //学号
    private int gender;    //性别
    private boolean present;    //是否到场

    public Student(){}

    public Student(int studentId){
        this.studentId = studentId;
    }

    public Student(int studentId,int gender,boolean present){
        this.studentId = studentId;
        this.gender = gender;
        this.present = present;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

}
