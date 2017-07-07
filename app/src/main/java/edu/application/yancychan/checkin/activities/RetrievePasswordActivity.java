package edu.application.yancychan.checkin.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.application.yancychan.checkin.R;

public class RetrievePasswordActivity extends AppCompatActivity {

    private Button mLoginBtn;
    private EditText mEmailEdt;
    private EditText mPwEdt;
    private EditText mPwConEdt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_password);
        initViews();
        setListeners();
    }

    private void initViews() {
        mEmailEdt = (EditText) findViewById(R.id.retrieve_pw_email);
        mPwEdt = (EditText) findViewById(R.id.retrieve_pw_edt);
        mPwConEdt = (EditText) findViewById(R.id.retrieve_pw_confirm);
        mLoginBtn = (Button) findViewById(R.id.retrieve_pw_btn);
    }

    private void setListeners() {
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RetrievePasswordActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}
