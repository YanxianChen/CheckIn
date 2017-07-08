package edu.application.yancychan.checkin.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import edu.application.yancychan.checkin.R;
import edu.application.yancychan.checkin.adapters.CourseAdapter;
import edu.application.yancychan.checkin.beans.Course;
import edu.application.yancychan.checkin.utils.RecyclerViewListDecoration;

public class CourseListActivity extends AppCompatActivity {

    public static final String COURSE_NAME = "course_name";
    public static final String COURSE_ID = "course_id";
    public static final String NUMBER_OF_STUDENT = "number_of_student";

    private Course[] courses = {new Course("软件工程",23123,33),
            new Course("计算机网络",67523,66),new Course("数据结构",43421,81)};

    private List<Course> courseList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);
//        TextView courseName = (TextView) findViewById(R.id.courseName);
        ButterKnife.inject(this);
        Button addCourse = (Button) findViewById(R.id.addCourse);
        addCourse.getBackground().setAlpha(000);
        addCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CourseListActivity.this,AddCourseActivity.class);
                startActivity(intent);
            }
        });
        initCourses();
        RecyclerView recyclerview = (RecyclerView) findViewById(R.id.manager_recycler_view);
        CourseAdapter adapter = new CourseAdapter(this,courseList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.addItemDecoration(new RecyclerViewListDecoration(this,
                RecyclerViewListDecoration.VERTICAL_LIST));
        recyclerview.setHasFixedSize(true);
        recyclerview.setAdapter(adapter);
    }

    private void initCourses() {
        courseList.clear();
        for (int i=0; i<3; i++) {
            courseList.add(courses[i]);
        }
    }
}
