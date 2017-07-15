package edu.application.yancychan.checkin.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.glomadrian.materialanimatedswitch.MaterialAnimatedSwitch;

import edu.application.yancychan.checkin.R;
import edu.application.yancychan.checkin.beans.Teacher;
import edu.application.yancychan.checkin.managers.RegisterErrorConstant;
import edu.application.yancychan.checkin.utils.StringUtil;

/**
 * Created by yancychan on 17-7-3.
 */

public class RegisterActivity extends AppCompatActivity {

    //验证邮箱正则表达式
    // TODO: 17-7-4 还未写实现
    public static String emailCheck =
            "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";


    private TextView mRegisterTitle;
    private EditText mUsernameEdt;
    private EditText mEmailEdt;
    private EditText mPwEdt;
    private EditText mRePwEdt;
    private MaterialAnimatedSwitch mGenderSwitchBtn;
    private Button mRegisterBtn;

    private int gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViews();
        setListeners();
    }

    private void initViews() {
        mRegisterTitle = (TextView) findViewById(R.id.register_text);
        mUsernameEdt = (EditText) findViewById(R.id.register_user_username);
        mEmailEdt = (EditText) findViewById(R.id.register_user_email);
        mPwEdt = (EditText) findViewById(R.id.register_pw_edt);
        mRePwEdt = (EditText) findViewById(R.id.register_pw_confirm);
        mGenderSwitchBtn = (MaterialAnimatedSwitch) findViewById(R.id.register_gender_switch);
        mRegisterBtn = (Button) findViewById(R.id.register_btn);
    }

    private void setListeners(){
        mRegisterTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        mGenderSwitchBtn.setOnCheckedChangeListener(new MaterialAnimatedSwitch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(boolean isChecked) {
                gender = isChecked ? 1 : 0;
            }
        });

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toRegister();
            }
        });
    }

    private void toRegister(){
        Teacher newTeacher = new Teacher();
        newTeacher.setTeacherName(mUsernameEdt.getText().toString());
        newTeacher.setTeacherEmail(mEmailEdt.getText().toString());
        newTeacher.setTeacherPassword(mPwEdt.getText().toString());
        newTeacher.setGender(gender);
        if (gender == 0){
            newTeacher.setAvatar(R.drawable.teacher_male);
        }else {
            newTeacher.setAvatar(R.drawable.teacher_female);
        }
        RegisterCheck(newTeacher, mRePwEdt.getText().toString());
    }

    private void RegisterCheck(Teacher newTeacher, String rePw){
        // TODO: 17-7-15  此处应该进行网络请求,向服务器获取信息,再进行接下来的操作

        int resultCode = checkTextLegality(newTeacher,rePw);
        if (resultCode == -1){
            newTeacher.save();
            Toast.makeText(RegisterActivity.this, "注册成功",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(RegisterActivity.this,
                    RegisterErrorConstant.getErrorMsg(resultCode), Toast.LENGTH_SHORT).show();
        }
    }

    private int checkTextLegality(Teacher newTeacher, String rePw) {
        if (StringUtil.replaceBlank(newTeacher.getTeacherName()).equals(""))
            return RegisterErrorConstant.ERROR_USERNAME_EMPTY;
        if (StringUtil.replaceBlank(newTeacher.getTeacherEmail()).equals("")){
            return RegisterErrorConstant.ERROR_EMAIL_EMPTY;
        }
        if (StringUtil.isHavingBlank(newTeacher.getTeacherName()))
            return RegisterErrorConstant.ERROR_USERNAME_SPACE;
        if (StringUtil.replaceBlank(newTeacher.getTeacherPassword()).equals("") || StringUtil.replaceBlank(rePw).equals(""))
            return RegisterErrorConstant.ERROR_PW_EMPTY;
        if (StringUtil.isHavingBlank(newTeacher.getTeacherPassword()) || StringUtil.isHavingBlank(rePw))
            return RegisterErrorConstant.ERROR_PW_SPACE;
        if (!newTeacher.getTeacherPassword().equals(rePw))
            return RegisterErrorConstant.ERROR_REPW_NOT_SAME;
        if (newTeacher.getTeacherName().length() > 24)
            return RegisterErrorConstant.ERROR_USERNAME_MORE_24;
        if (newTeacher.getTeacherPassword().length() > 32 || rePw.length() > 32)
            return RegisterErrorConstant.ERROR_PW_MORE_32;
        return -1;
    }
}
