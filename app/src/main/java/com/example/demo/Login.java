package com.example.demo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

import data.User;
import data.UserData;

public class Login extends AppCompatActivity {
    private Map<Integer, User> user;

    private EditText usernameET;
    private EditText passwordET;
    private Button loginBtn;
    private Button registerBtn;

    public static User userItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //隐藏标题栏
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }

        user = new UserData().getUser();
        init();
    }

    private void init(){
        usernameET  = findViewById(R.id.user);
        passwordET  = findViewById(R.id.password);
        loginBtn    = findViewById(R.id.login);
        registerBtn = findViewById(R.id.login_register);
        setListeners();
    }

    private boolean login(){
        String userText = usernameET.getText().toString();
        String passwordText = passwordET.getText().toString();

        for(int i = 0; i < user.size(); i++){
            if(user.get(i).getAccountNumber().equals(userText) ){
                if(user.get(i).getPassword().equals(passwordText)){
                    setUser(user.get(i));
                    Toast.makeText(Login.this,"登录成功...",Toast.LENGTH_SHORT).show();
                    return true;
                } else {
                    passwordET.setText("");
                    Toast.makeText(Login.this,"密码错误...",Toast.LENGTH_SHORT).show();
                    return false;
                }
            }else{
                continue;
            }
        }
        Toast.makeText(Login.this,"未找到用户...",Toast.LENGTH_SHORT).show();
        return false;
    }

    private void setListeners(){
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(login()){
                    Intent intent = new Intent();
                    intent.setClass(Login.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Login.this, Register.class);
                startActivity(intent);
            }
        });
    }

    private static void setUser(User _userItem){
        userItem = _userItem;
    }
}
