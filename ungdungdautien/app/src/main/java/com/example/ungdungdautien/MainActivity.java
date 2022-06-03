package com.example.ungdungdautien;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextUser,editTextPassWorld;
    Button buttonDangKy,buttonDangNhap;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        ControlButton();
    }

    private void ControlButton() {
        buttonDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), dangky.class);
                startActivity(intent);
            }
        });
        buttonDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = editTextUser.getText().toString();
                String password=editTextPassWorld.getText().toString();

                if (TextUtils.isEmpty(user)|| TextUtils.isEmpty(password))
                    Toast.makeText(MainActivity.this, "Tên đăng nhập và mật khẩu không được để trống !", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpassword=DB.checkusernamepassword(user,password);
                    if (checkuserpassword==true){
                        Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),HomeMain.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(MainActivity.this, "Đăng nhập không thành công", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
    }


    private void Anhxa() {
        editTextUser = (EditText)findViewById(R.id.editTextUser);
        editTextPassWorld =(EditText) findViewById(R.id.editTextPassWord);
        buttonDangKy=(Button)findViewById(R.id.buttonDangKy);
        buttonDangNhap=(Button)findViewById(R.id.buttonDangNhap);
        DB = new DBHelper(this);
    }
}