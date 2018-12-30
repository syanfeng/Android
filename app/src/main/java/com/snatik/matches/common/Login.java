package com.snatik.matches.common;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.snatik.matches.MainActivity;
import com.snatik.matches.R;

import java.util.Map;


public class Login extends Activity {
    private EditText etNumber;  //用户名
    private EditText etPassword;    //密码
    private Button btnLogin;    //登录按钮
    private Button btnRegister;    //注册按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        etNumber = (EditText) findViewById(R.id.et_number);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnRegister = (Button) findViewById(R.id.btn_register);
        btnLogin.setOnClickListener(mListener);
        btnRegister.setOnClickListener(mListener);
    }

    OnClickListener mListener = new OnClickListener() {                  //不同按钮按下的监听事件选择
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_login:                            //登录界面的注册按钮
                    login();
                    break;
                case R.id.btn_register:                            //登录界面的注册按钮
                    Intent intent_Login_to_Register = new Intent(Login.this, Register.class);    //切换Login Activity至User Activity
                    startActivity(intent_Login_to_Register);
                    finish();
                    break;
            }
        }
    };

    public void login() {                                              //登录按钮监听事件
        if (isUserNameAndPwdValid()) {
            String userName = etNumber.getText().toString().trim();    //获取当前输入的用户名和密码信息
            String userPwd = etPassword.getText().toString().trim();

            finish();
        }
    }

    public boolean isUserNameAndPwdValid() {
        if (etNumber.getText().toString().trim().equals("")) {
            Toast.makeText(this, getString(R.string.account_empty),
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (etPassword.getText().toString().trim().equals("")) {
            Toast.makeText(this, getString(R.string.pwd_empty),
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}