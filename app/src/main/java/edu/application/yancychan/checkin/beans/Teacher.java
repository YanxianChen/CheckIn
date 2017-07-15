package edu.application.yancychan.checkin.beans;

import org.litepal.crud.DataSupport;

/**
 * Created by yancychan on 17-7-4.
 */

public class Teacher extends DataSupport {

    private int gender;
    private int teacherId;
    private int avatar;
    private String teacherName;
    private String teacherEmail;
    private String teacherPassword;

    public Teacher(){}

    public Teacher(String teacherName,String teacherEmail,int avatar){
        this.teacherName = teacherName;
        this.teacherEmail = teacherEmail;
        this.avatar = avatar;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }


    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }
}
