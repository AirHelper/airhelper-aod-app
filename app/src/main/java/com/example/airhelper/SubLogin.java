package com.example.airhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;


public class SubLogin extends AppCompatActivity {

    private String strName, strProfileImg, strEmail;
    private EditText et_callsign;
    private Button btn_check, btn_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);


        Intent intent = getIntent();
        strName = intent.getStringExtra("name");
        strEmail = intent.getStringExtra("email");
        strProfileImg = intent.getStringExtra("pofileImg");

        TextView tv_name = findViewById(R.id.tv_name);
        TextView tv_email = findViewById(R.id.tv_email);
        ImageView iv_prifile = findViewById(R.id.iv_profile);

        // 이름 set
        tv_name.setText(strName);
        // 이메일 set
        tv_email.setText(strEmail);
        // 콜사인 set
        et_callsign = findViewById(R.id.et_callsign);
        // 프로필 이미지 사진 set
        Glide.with(this).load(strProfileImg).into(iv_prifile);

        // 저장
        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // 로그아웃
        findViewById(R.id.btn_logout).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                UserManagement.getInstance().requestLogout(new LogoutResponseCallback()
                {
                    @Override
                    public void onCompleteLogout()
                    {
                        // 로그아웃 성공시 수행하는 지점
                        finish(); // 현재 액티비티 종료
                    }
                });
            }
        });

        // 확인 버튼 활성화
        btn_check = findViewById(R.id.btn_check);
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubLogin.this , JoinGame.class);
                startActivity(intent);
            }
        });

        // 취소 버튼 활성화
        btn_cancel = findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubLogin.this , MainLogin.class);
                startActivity(intent);
            }
        });

    }
}