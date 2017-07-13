package edu.application.yancychan.checkin.activities;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import edu.application.yancychan.checkin.R;
import edu.application.yancychan.checkin.adapters.CourseAdapter;
import edu.application.yancychan.checkin.beans.Course;
import edu.application.yancychan.checkin.managers.MyLinearLayoutManager;
import edu.application.yancychan.checkin.utils.RecyclerViewListDecoration;

public class CourseListActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private CourseAdapter adapter;
    private RecyclerView mRecyclerview;

    public static final String COURSE_NAME = "course_name";
    public static final String COURSE_ID = "course_id";
    public static final String NUMBER_OF_STUDENT = "number_of_student";

    private Course[] courses = {new Course("软件工程",23123,33),
            new Course("计算机网络",67523,66),new Course("软件工程",23123,33),
            new Course("数据结构",43421,81),new Course("软件工程",23123,33),
            new Course("计算机网络",67523,66),new Course("软件工程",23123,33),
            new Course("数据结构",43421,81),new Course("软件工程",23123,33),
            new Course("计算机网络",67523,66),new Course("软件工程",23123,33),
            new Course("数据结构",43421,81),new Course("软件工程",23123,33),
            new Course("计算机网络",67523,66),new Course("软件工程",23123,33),
            new Course("数据结构",43421,81),new Course("软件工程",23123,33),
            new Course("计算机网络",67523,66),new Course("软件工程",23123,33),
            new Course("数据结构",43421,81),new Course("软件工程",23123,33),
            new Course("计算机网络",67523,66),new Course("软件工程",23123,33),
            new Course("数据结构",43421,81)};

    private List<Course> courseList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);
        ButterKnife.inject(this);
        initViews();
        setListeners();
        initCourses();

    }

    private void setListeners() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            Thread.sleep(2000);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                initCourses();
                                adapter.notifyDataSetChanged();
                                mSwipeRefreshLayout.setRefreshing(false);
                            }
                        });
                    }
                }).start();
            }
        });
    }

    private void initViews() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar_course_list);
        setSupportActionBar(mToolbar);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_course_list);
        mRecyclerview = (RecyclerView) findViewById(R.id.manager_recycler_view);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        adapter = new CourseAdapter(this,courseList);
        MyLinearLayoutManager layoutManager = new MyLinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerview.setLayoutManager(layoutManager);
        mRecyclerview.addItemDecoration(new RecyclerViewListDecoration(this,
                RecyclerViewListDecoration.VERTICAL_LIST));
        mRecyclerview.setHasFixedSize(true);
        mRecyclerview.setAdapter(adapter);
    }

    private void initCourses() {
        courseList.clear();
        for (int i=0; i<courses.length; i++) {
            courseList.add(courses[i]);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar_course_list,menu);
        return true;
    }


    //toolbar上的增加课程按钮
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.addCourse_toolbar_courseList:
                Intent intent = new Intent(CourseListActivity.this, AddCourseActivity.class);
                startActivity(intent);
                break;
            default:
        }
        return true;
    }
}
