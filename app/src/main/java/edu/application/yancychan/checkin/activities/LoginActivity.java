package edu.application.yancychan.checkin.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.List;

import edu.application.yancychan.checkin.R;
import edu.application.yancychan.checkin.beans.Teacher;

public class LoginActivity extends AppCompatActivity {

    private Button mLoginBtn;
    private View mRegisterTv;
    private TextView mLoginText;
    private EditText mEmailEdt;
    private EditText mPwEdt;

    private List<Teacher> teachers;

    private String mLoginTeacherEmail;
    private String mLoginTeacherPw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        setListeners();
    }

    private void initViews() {
        mLoginBtn = (Button) findViewById(R.id.login_btn);
        mRegisterTv = findViewById(R.id.login_register_tip_tv);
        mLoginText = (TextView) findViewById(R.id.login_text);
        mEmailEdt = (EditText) findViewById(R.id.login_user_edt);
        mPwEdt = (EditText) findViewById(R.id.login_pw_edt);
    }


    private void setListeners(){

        //title点击事件
        mLoginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        //登录按钮点击事件
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginCheck();
            }
        });

        //忘记密码点击事件
        mRegisterTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 17-7-4 跳到忘记密码界面
                Intent intent = new Intent(LoginActivity.this, RetrievePasswordActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loginCheck(){
        // TODO: 17-7-15 此处应该请求服务器服务,查询账号密码是否正确 ,这里先伪造一下,直接查询本地数据库
        mLoginTeacherEmail = mEmailEdt.getText().toString();
        mLoginTeacherPw = mPwEdt.getText().toString();
        teachers =  DataSupport.where("teacheremail =? and teacherpassword = ?",mLoginTeacherEmail,mLoginTeacherPw).find(Teacher.class);
        if (teachers.size() == 1){
            Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, CourseListActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(LoginActivity.this,"输入的邮箱密码有误,请重新输入",Toast.LENGTH_SHORT).show();
        }
    }
}


