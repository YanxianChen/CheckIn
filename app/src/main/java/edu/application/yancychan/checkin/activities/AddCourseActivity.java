package edu.application.yancychan.checkin.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import edu.application.yancychan.checkin.R;

public class AddCourseActivity extends AppCompatActivity {

    private EditText mCourseNameEdt;
    private EditText mCourseTimeEdt;
    private EditText mCourseCountEdt;
    private EditText mClassTimeEdt;
    private EditText mClassLocationEdt;
    private EditText mStudentNumberEdt;
    private Button mSaveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);
        initViews();
    }

    private void initViews(){
        mCourseNameEdt = (EditText) findViewById(R.id.courseName_Add_edt);
        mCourseTimeEdt = (EditText) findViewById(R.id.courseTime_Add_edt);
        mCourseCountEdt = (EditText) findViewById(R.id.courseCount_Add_edt);
        mClassTimeEdt = (EditText) findViewById(R.id.classTime_Add_edt);
        mClassLocationEdt = (EditText) findViewById(R.id.classLocation_Add_edt);
        mStudentNumberEdt = (EditText) findViewById(R.id.numberOfStudent_Add_edt);
        mSaveBtn = (Button) findViewById(R.id.save_Add_btn);
    }
}
