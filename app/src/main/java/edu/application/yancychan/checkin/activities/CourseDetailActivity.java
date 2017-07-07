package edu.application.yancychan.checkin.activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.application.yancychan.checkin.R;
import edu.application.yancychan.checkin.adapters.StudentAdapter;
import edu.application.yancychan.checkin.beans.Student;

import static edu.application.yancychan.checkin.activities.CourseListActivity.COURSE_ID;
import static edu.application.yancychan.checkin.activities.CourseListActivity.COURSE_NAME;
import static edu.application.yancychan.checkin.activities.CourseListActivity.NUMBER_OF_STUDENT;

public class CourseDetailActivity extends AppCompatActivity {

    public Student[] students = {new Student(41455078,R.drawable.man,true),new Student(41455066,
            R.drawable.man,false),
            new Student(41455011,R.drawable.woman,true),new Student(41455073,R.drawable.man,true),
            new Student(41455228,R.drawable.woman,false),new Student(41455118,R.drawable.man,true),
            new Student(49455070,R.drawable.man,false),new Student(41155378,R.drawable.woman,false)};

//    private Student[] students = {new Student(41455078),new Student(41455066),
//            new Student(41455011),new Student(41455073),
//            new Student(41455228),new Student(41455118),
//            new Student(49455070),new Student(41155378)};

    private List<Student> studentList = new ArrayList<>();

    private LinearLayout tab1Layout, tab2Layout;

    private int index = 1;

    private FragmentManager fragmentManager;

    private Fragment tab1Fragment, tab2Fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);
        TextView openCheckIn = (TextView) findViewById(R.id.CheckIn);
        TextView manualCheckIn = (TextView) findViewById(R.id.manualCheckIn);
//        openCheckIn.getBackground().setAlpha(000);
//        manualCheckIn.getBackground().setAlpha(000);
        TextView courseIdContent = (TextView) findViewById(R.id.courseId);
        TextView courseNameContent = (TextView) findViewById(R.id.courseName_detail);
        TextView numberOfStudentContent = (TextView) findViewById(R.id.numberOfStudent);
        initStudents();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this,4);
        recyclerView.setLayoutManager(layoutManager);
        StudentAdapter adapter = new StudentAdapter(studentList);
        recyclerView.setAdapter(adapter);

        Intent intent = getIntent();
        String courseId = intent.getStringExtra(COURSE_ID);
        String courseName = intent.getStringExtra(COURSE_NAME);
        String numberOfStudent = intent.getStringExtra(NUMBER_OF_STUDENT);
        courseIdContent.setText(courseId);
        courseNameContent.setText(courseName);
        numberOfStudentContent.setText(numberOfStudent);



        //numberOfStudentContent.append((CharSequence)numberOfStudent);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu,menu);
//        return true;
//    }

    public void initStudents(){
        studentList.clear();
        for (int i=0; i<students.length; i++){

            studentList.add(students[i]);
        }
    }
}
