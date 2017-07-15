package edu.application.yancychan.checkin.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import edu.application.yancychan.checkin.R;
import edu.application.yancychan.checkin.adapters.CourseAdapter;
import edu.application.yancychan.checkin.beans.Course;
import edu.application.yancychan.checkin.beans.Teacher;
import edu.application.yancychan.checkin.managers.MyLinearLayoutManager;
import edu.application.yancychan.checkin.utils.RecyclerViewListDecoration;

public class CourseListActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private NavigationView mNavigationView;
    private View mHeaderLayout;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private CourseAdapter adapter;
    private RecyclerView mRecyclerView;
    private CircleImageView mTeacherAvatar;
    private TextView mTeacherName;
    private TextView mTeacherMail;

    Teacher testTeacher = new Teacher("郭霖","13001250622@163.com",R.drawable.teacher_male);
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

    private void initViews() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.draw_layout_course_list);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_course_list);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view_course_list);
        mHeaderLayout = mNavigationView.getHeaderView(0);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_course_list);
        mRecyclerView = (RecyclerView) findViewById(R.id.manager_recycler_view);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mTeacherAvatar = (CircleImageView) mHeaderLayout.findViewById(R.id.nav_avatar);
        mTeacherName = (TextView) mHeaderLayout.findViewById(R.id.nav_username);
        mTeacherMail = (TextView) mHeaderLayout.findViewById(R.id.nav_mail);
        mTeacherName.setText(testTeacher.getTeacherName());
        mTeacherMail.setText(testTeacher.getTeacherEmail());
        Glide.with(getApplicationContext()).load(testTeacher.getAvatar()).into(mTeacherAvatar);
        adapter = new CourseAdapter(this,courseList);
        MyLinearLayoutManager layoutManager = new MyLinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.addItemDecoration(new RecyclerViewListDecoration(this,
                RecyclerViewListDecoration.VERTICAL_LIST));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(adapter);
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

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.
                OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_course:
                        Intent intent = new Intent(getApplicationContext(),CourseListActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_profile:
                        Toast.makeText(getApplicationContext(),"profile",Toast.LENGTH_SHORT);
                        break;
                    default:
                }
                return true;
            }
        });

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
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
