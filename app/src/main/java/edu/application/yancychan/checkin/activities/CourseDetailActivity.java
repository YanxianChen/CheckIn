package edu.application.yancychan.checkin.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import edu.application.yancychan.checkin.R;


public class CourseDetailActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private Button mLaunchCheckBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);
        initViews();
        setListeners();
    }


    private void initViews() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar_course_detail);
        mLaunchCheckBtn = (Button) findViewById(R.id.launch_check_in);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setListeners() {
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mLaunchCheckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CourseDetailActivity.this, CourseCheckInActivity.class);
                startActivity(intent);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar_course_detail,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.course_detail_toolbar_edit:
                Intent intent = new Intent(CourseDetailActivity.this, CourseEditActivity.class);
                startActivity(intent);
                break;
            default:
        }
        return true;
    }

}
