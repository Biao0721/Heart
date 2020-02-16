package com.example.demo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Login extends AppCompatActivity {
    List<Map<String, String>> user = new ArrayList<>();

    private EditText usernameET;
    private EditText passwordET;
    private Button loginBtn;

    public static String name = "未登录";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //隐藏标题栏
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }

        setUser();
        init();
    }

    private void setUser(){
        String[] accountNumber = {
                "KonDBin", "LinSSi", "HuJinHao", "LuSY", "LeeYanN", "SunXiao", "HanXueQiao"
        };

        String[] userName = {
                "孔德彬", "林思思", "胡锦浩", "卢思怡", "李妍霓", "孙潇", "韩雪侨"
        };

        String[] password = {
                "123", "123", "123", "123", "123", "123", "123"
        };

        for(int i = 0; i < accountNumber.length; i++){
            Map<String, String> userItem = new HashMap<>();
            userItem.put("account_number", accountNumber[i]);
            userItem.put("password", password[i]);
            userItem.put("user_name", userName[i]);
            user.add(userItem);
        }
    }

    private void init(){
        usernameET = findViewById(R.id.user);
        passwordET = findViewById(R.id.password);
        loginBtn   = findViewById(R.id.login);
        setListeners();
    }

    private boolean login(){
        String userText = usernameET.getText().toString();
        String passwordText = passwordET.getText().toString();

        for(int i = 0; i < user.size(); i++){
            if(user.get(i).get("account_number").equals(userText) ){
                if(user.get(i).get("password").equals(passwordText)){
                    setName(user.get(i).get("user_name"));
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
    }

    private static void setName(String _name){
        name = _name;
    }
}
