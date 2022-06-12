package com.example.ungdungdautien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class trang1 extends AppCompatActivity {
    private Button btnnext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang1);
        initUi();
        initListener();
    }

    private void initUi(){
        btnnext = (Button) findViewById(R.id.btnNext);
    }
    private void initListener() {
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickNext();
            }
        });
    }
    private void onClickNext() {
        Intent intent = new Intent(trang1.this,HomeMain.class);
        startActivity(intent);
    }



}