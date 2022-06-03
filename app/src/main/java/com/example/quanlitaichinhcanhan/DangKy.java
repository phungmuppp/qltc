package com.example.quanlitaichinhcanhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class dangky extends AppCompatActivity {
    EditText hoVaTenLot,ten,email,tenDangNhap,password,repassword;
    Button buttonDangKy;
    DBHelper DB = new DBHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        hoVaTenLot=findViewById(R.id.editTextHoTenLot);
        ten=findViewById(R.id.editTextTen);
        email=findViewById(R.id.editTextEmail);
        tenDangNhap=findViewById(R.id.editTextTenDN);
        password=findViewById(R.id.editTextPassWord);
        repassword=findViewById(R.id.editTextREPassword);
        buttonDangKy=findViewById(R.id.buttonDangKy1);

        buttonDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoVaTenLot1 = hoVaTenLot.getText().toString();
                String ten1 = ten.getText().toString();
                String email1 = email.getText().toString();
                String tenDangNhap1 = tenDangNhap.getText().toString();
                String password1 = password.getText().toString();
                String repassword1 = repassword.getText().toString();

                if (TextUtils.isEmpty(hoVaTenLot1)||TextUtils.isEmpty(ten1)||TextUtils.isEmpty(email1)||TextUtils.isEmpty(tenDangNhap1)||TextUtils.isEmpty(password1)||TextUtils.isEmpty(repassword1)){
                    Toast.makeText(dangky.this,"Bạn chưa nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    if (password1.equals(repassword1)){
                        Boolean checkeruser = DB.checkusername(tenDangNhap1);
                        if (checkeruser == false) {
                            Boolean insert = DB.insertData(tenDangNhap1, password1, hoVaTenLot1, ten1, email1);
                            if (insert == true){
                                Toast.makeText(dangky.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), HomeMain.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(dangky.this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(dangky.this,"Đăng ký thất bại, người dùng đã tồn tại",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(dangky.this,"Đăng ký thất bại, mật khẩu nhập lại không khớp",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}