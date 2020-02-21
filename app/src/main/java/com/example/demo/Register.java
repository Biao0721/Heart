package com.example.demo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import data.User;
import data.UserData;

public class Register extends AppCompatActivity {
    private EditText accountNumberTX;
    private EditText passwordTX;
    private EditText _passwordTX;
    private EditText userNameTX;
    private EditText phoneTX;

    private RadioGroup radioGroup;
    private String gender;
    private Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        //隐藏标题栏
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
        init();
    }

    private void init(){
        accountNumberTX = findViewById(R.id.register_account_number);
        passwordTX = findViewById(R.id.register_password);
        _passwordTX = findViewById(R.id._register_password);
        userNameTX = findViewById(R.id.register_user_name);
        phoneTX = findViewById(R.id.register_phone);
        radioGroup = findViewById(R.id.register_user_gender);
        registerBtn = findViewById(R.id.register_success);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup Group, int Checkid) {
                // TODO Auto-generated method stub
                //设置TextView的内容显示CheckBox的选择结果
                String str;
                RadioButton radioButton = findViewById(radioGroup.getCheckedRadioButtonId());
                gender = radioButton.getText().toString();
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (passwordTX.getText().equals(_passwordTX.getText())){
                    new UserData().addUser(
                            accountNumberTX.getText().toString(),
                            userNameTX.getText().toString(),
                            passwordTX.getText().toString(),
                            gender,
                            phoneTX.getText().toString());
                } else {
                    Toast.makeText(Register.this, "两次输入密码不一致", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
