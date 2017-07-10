package edu.application.yancychan.checkin.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.application.yancychan.checkin.R;

public class CourseEditActivity extends AppCompatActivity {

    private EditText mCourseNameEdt;
    private EditText mCourseTimeEdt;
    private EditText mCourseCountEdt;
    private EditText mClassTimeEdt;
    private EditText mClassLocationEdt;
    private EditText mStudentNumberEdt;
    private Button mChangeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_edit);
        initViews();
        setListeners();
    }

    private void initViews(){
        mCourseNameEdt = (EditText) findViewById(R.id.courseName_Change_edt);
        mCourseTimeEdt = (EditText) findViewById(R.id.courseTime_Change_edt);
        mCourseCountEdt = (EditText) findViewById(R.id.courseCount_Change_edt);
        mClassTimeEdt = (EditText) findViewById(R.id.classTime_Change_edt);
        mClassLocationEdt = (EditText) findViewById(R.id.classLocation_Change_edt);
        mStudentNumberEdt = (EditText) findViewById(R.id.numberOfStudent_Change_edt);
        mChangeBtn = (Button) findViewById(R.id.save_Change_btn);
    }

    private void setListeners() {
        mChangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CourseEditActivity.this, CourseListActivity.class);
                startActivity(intent);
            }
        });
    }
}
