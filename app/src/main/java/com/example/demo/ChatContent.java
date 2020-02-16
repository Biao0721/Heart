package com.example.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

import data.FriendData;

public class ChatContent extends AppCompatActivity {
    private TextView userNameTX;
    private Button sendBT;
    private EditText sendET;
    private Map<String, Object> friend;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_list);

        //隐藏标题栏
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }

        init();

        Bundle bundle = getIntent().getExtras();
        friend = new FriendData().getFriendData(bundle.getInt("num"));
        userNameTX.setText(friend.get("friend_name").toString());
    }

    private void init(){
        userNameTX = findViewById(R.id.user_name);
        sendBT     = findViewById(R.id.send);
        sendET     = findViewById(R.id.chat_edit_text);

        // 设置发送按钮事件
        sendBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String send = sendET.getText().toString();
                if(send == null){
                    Toast.makeText(ChatContent.this, "内容不能为空...", Toast.LENGTH_SHORT).show();
                } else {
                    // 建立一个气泡
                    sendET.setText("");
                }

            }
        });
    }
}
