package edu.application.yancychan.checkin.beans;

import org.litepal.crud.DataSupport;

/**
 * Created by yancychan on 17-7-4.
 */

public class Student extends DataSupport{

    private int studentId;  //学号
    private int sex;    //性别
    private boolean present;    //是否到场

    public Student(int studentId){
        this.studentId = studentId;
    }

    public Student(int studentId,int sex,boolean present){
        this.studentId = studentId;
        this.sex = sex;
        this.present = present;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

}
