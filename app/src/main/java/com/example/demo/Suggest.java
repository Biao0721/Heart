package com.example.demo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Map;

import data.SuggestData;

public class Suggest extends AppCompatActivity {
    TextView textTitle;
    TextView textAuthor;
    TextView textContext;
    private Map<String, Object> suggest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.suggest);

        //隐藏标题栏
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }

        init();
        setContext();
    }

    private void init(){
        textTitle = findViewById(R.id.text_title);
        textAuthor = findViewById(R.id.text_author);
        textContext = findViewById(R.id.text_content);
    }

    private void setContext(){
        Bundle bundle = getIntent().getExtras();
        suggest = new SuggestData().getFriendData(bundle.getInt("num"));
        textTitle.setText(suggest.get("suggest_head").toString());
        textAuthor.setText(suggest.get("suggest_name").toString());
        textContext.setText(suggest.get("suggest_text").toString());
    }
}
