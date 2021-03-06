package com.example.demo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import fragement.Chat;
import fragement.Doctor;
import fragement.Home;
import fragement.Pet;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;

    private ImageButton btnPet;
    private ImageButton btnChat;
    private ImageButton btnDoctor;
    private ImageButton btnHome;

    private Pet    petFragement;
    private Chat   chatFragement;
    private Doctor doctorFragement;
    private Home   homeFragement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //隐藏标题栏
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }

        fragmentManager = getSupportFragmentManager();

        Init();

        //默认开始界面在功能界面
        InitFragment(1);
        btnPet.setImageResource(R.mipmap.title_pet_choose);
    }

    private void InitFragment(int flag){
        //启动事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        hideAllFragment(transaction);
        switch (flag){
            case 1:
                if (petFragement== null){
                    petFragement = new Pet();
                    transaction.add(R.id.fragement,petFragement);
                }
                else{
                    transaction.show(petFragement);
                }
                break;

            case 2:
                if (chatFragement== null){
                    chatFragement = new Chat();
                    transaction.add(R.id.fragement,chatFragement);
                }
                else{
                    transaction.show(chatFragement);
                }
                break;


            case 3:
                if (doctorFragement== null){
                    doctorFragement = new Doctor();
                    transaction.add(R.id.fragement,doctorFragement);
                }
                else{
                    transaction.show(doctorFragement);
                }
                break;

            case 4:
                if (homeFragement== null){
                    homeFragement = new Home();
                    transaction.add(R.id.fragement,homeFragement);
                }
                else{
                    transaction.show(homeFragement);
                }
                break;
        }
        //提交事务
        transaction.commit();
    }

    void Init(){
        btnPet    = findViewById(R.id.titile_pet);
        btnChat   = findViewById(R.id.titile_chat);
        btnDoctor = findViewById(R.id.title_doctor);
        btnHome   = findViewById(R.id.title_home);
        setListeners();
    }

    void setListeners(){
        OnClick onClick = new OnClick();
        btnPet.setOnClickListener(onClick);
        btnChat.setOnClickListener(onClick);
        btnDoctor.setOnClickListener(onClick);
        btnHome.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            //恢复选中图标状态
            restartButton();

            switch (view.getId()){

                case R.id.titile_pet:
                    //跳转到Pet界面
                    btnPet.setImageResource(R.mipmap.title_pet_choose);
                    InitFragment(1);
                    break;

                case R.id.titile_chat:
                    //跳转到Chat界面
                    btnChat.setImageResource(R.mipmap.title_chat_choose);
                    InitFragment(2);
                    break;

                case R.id.title_doctor:
                    //跳转到Doctor界面
                    btnDoctor.setImageResource(R.mipmap.title_doctor_choose);
                    InitFragment(3);
                    break;

                case R.id.title_home:
                    //跳转到Home界面
                    btnHome.setImageResource(R.mipmap.title_home_choose);
                    InitFragment(4);
                    break;
            }
        }
    }

    private void hideAllFragment(FragmentTransaction transaction){
        if (petFragement!= null){
            transaction.hide(petFragement);
        }

        if (chatFragement!= null){
            transaction.hide(chatFragement);
        }

        if (doctorFragement!= null){
            transaction.hide(doctorFragement);
        }

        if (homeFragement!= null){
            transaction.hide(homeFragement);
        }

        // transaction.commit();
    }

    private void restartButton(){
        //设置为未点击状态
        btnPet.setImageResource(R.mipmap.title_pet);
        btnChat.setImageResource(R.mipmap.title_chat);
        btnDoctor.setImageResource(R.mipmap.title_doctor);
        btnHome.setImageResource(R.mipmap.title_home);
    }
}