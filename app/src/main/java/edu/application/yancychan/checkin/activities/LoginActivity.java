package edu.application.yancychan.checkin.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.application.yancychan.checkin.R;

public class LoginActivity extends AppCompatActivity {

    private Button mLoginBtn;
    private View mRegisterTv;
    private TextView mLoginText;
    private EditText mUsernameEdt;
    private EditText mPwEdt;

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
        mUsernameEdt = (EditText) findViewById(R.id.login_user_edt);
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
                // TODO: 17-7-4 登录到主界面
                Intent intent = new Intent(LoginActivity.this, CourseListActivity.class);
                startActivity(intent);
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
}


