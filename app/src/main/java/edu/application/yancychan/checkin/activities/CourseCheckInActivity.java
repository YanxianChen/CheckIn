package edu.application.yancychan.checkin.activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import edu.application.yancychan.checkin.R;
import edu.application.yancychan.checkin.activities.fragments.Tab1Fragment;
import edu.application.yancychan.checkin.activities.fragments.Tab2Fragment;
import edu.application.yancychan.checkin.adapters.MyFragmentAdapter;

public class CourseCheckInActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private Tab1Fragment allStudentFragment;
    private Tab2Fragment absenseStudentFragment;

    private MyFragmentAdapter myFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_check_in);
        init();
    }

    private void init(){
        mToolbar = (Toolbar) findViewById(R.id.toolbar_course_check_in);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.vp_viewpager);
        setSupportActionBar(mToolbar);

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);

        allStudentFragment = new Tab1Fragment();
        absenseStudentFragment = new Tab2Fragment();

        myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager());
        myFragmentAdapter.addFrag(allStudentFragment, "签到情况");
        myFragmentAdapter.addFrag(absenseStudentFragment, "手动补签");

        mViewPager.setAdapter(myFragmentAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }


    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar_course_check_in,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.toolbar_course_check_in_done:
                Intent intent = new Intent(CourseCheckInActivity.this, CourseDetailActivity.class);
                startActivity(intent);
                break;
            default:
        }
        return true;
    }
}
