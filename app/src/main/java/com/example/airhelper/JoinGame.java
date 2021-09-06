package com.example.airhelper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class JoinGame extends AppCompatActivity {


    // 하단 바
    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private FragReservation f1;
    private FragCommunity f2;
    private FragCreate f3;
    private FragJoin f4;
    private FragMore f5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_game);

        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_reservation:
                        setFrag(0);
                        break;
                    case R.id.action_community:
                        setFrag(1);
                        break;
                    case R.id.action_create:
                        setFrag(2);
                        break;
                    case R.id.action_join:
                        setFrag(3);
                        break;
                    case R.id.action_more:
                        setFrag(4);
                        break;
                }
                return true;
            }
        });
        f1 = new FragReservation();
        f2 = new FragCommunity();
        f3 = new FragCreate();
        f4 = new FragJoin();
        f5 = new FragMore();
        //첫 화면 지정 선택
        setFrag(0);
    }

    // 화면 교체
    private void setFrag(int n){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n){
            case 0:
                ft.replace(R.id.reservation_frame,f1);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.reservation_frame,f2);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.reservation_frame,f3);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.reservation_frame,f4);
                ft.commit();
                break;
            case 4:
                ft.replace(R.id.reservation_frame,f5);
                ft.commit();
                break;
        }
    }
}