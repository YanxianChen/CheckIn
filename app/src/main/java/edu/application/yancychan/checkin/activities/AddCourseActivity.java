package edu.application.yancychan.checkin.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.application.yancychan.checkin.R;

public class AddCourseActivity extends AppCompatActivity {

    private Toolbar mToolbar;
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
        setListeners();
    }

    private void initViews(){
        mToolbar = (Toolbar) findViewById(R.id.toolbar_course_add);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mCourseNameEdt = (EditText) findViewById(R.id.courseName_Add_edt);
        mCourseTimeEdt = (EditText) findViewById(R.id.courseTime_Add_edt);
        mCourseCountEdt = (EditText) findViewById(R.id.courseCount_Add_edt);
        mClassTimeEdt = (EditText) findViewById(R.id.classTime_Add_edt);
        mClassLocationEdt = (EditText) findViewById(R.id.classLocation_Add_edt);
        mStudentNumberEdt = (EditText) findViewById(R.id.numberOfStudent_Add_edt);
        mSaveBtn = (Button) findViewById(R.id.save_Add_btn);
    }

    private void setListeners(){
        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddCourseActivity.this, CourseListActivity.class);
                startActivity(intent);
            }
        });
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
