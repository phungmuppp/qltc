package com.example.ungdungdautien;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;

public class HomeMain extends AppCompatActivity {
    ThongKe_class thongKe_class;
//    Button buttondangxuat;
    private FirebaseAuth mAuth;
    private ImageView imgAvatar;
    private TextView txvName, txvMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_main);

        thongKe_class = new ThongKe_class();
        thongKe_class.getDSThongKe();

        initUi();
        mAuth = FirebaseAuth.getInstance();
//        ControlButton();
    }

    private void initUi() {
        imgAvatar =(ImageView) findViewById(R.id.img_avatar);
        txvName = (TextView) findViewById(R.id.txv_name);
        txvMoney = (TextView) findViewById(R.id.txt_money);

    }


//    private void Anhxa() {
//        buttondangxuat = (Button)findViewById(R.id.buttonDangXuat);
//    }

//    private void ControlButton() {
//        buttondangxuat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FirebaseAuth.getInstance().signOut();
//                Intent intent = new Intent(HomeMain.this,MainActivity.class);
//                startActivity(intent);
//            }
//        });
//    }
}