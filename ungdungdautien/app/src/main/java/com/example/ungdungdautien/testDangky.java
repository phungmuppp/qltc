package com.example.ungdungdautien;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class testDangky extends AppCompatActivity {

    private EditText edtemail,edtpassword,edtrepassword;
    private LinearLayout layout_DangNhap;
    private Button buttonDangky;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_dangky);
        initUi();
        initListener();
    }



    private void initUi(){
        edtemail = (EditText) findViewById(R.id.edtEmail);
        edtpassword = (EditText) findViewById(R.id.edtpassword);
        edtrepassword = (EditText) findViewById(R.id.edtrepassword);
        layout_DangNhap = (LinearLayout) findViewById(R.id.layout_dangnhap);
        buttonDangky = (Button) findViewById(R.id.btnDangKy);
    }
    private void initListener() {
        buttonDangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickDangky();
            }
        });
        layout_DangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickDangNhap();
            }
        });
    }

    private void onClickDangky() {
        String strEmail = edtemail.getText().toString().trim();
        String strPassword = edtpassword.getText().toString().trim();
        String strRePassword = edtrepassword.getText().toString().trim();

        if (TextUtils.isEmpty(strEmail)||TextUtils.isEmpty(strPassword)||TextUtils.isEmpty(strRePassword)){
            Toast.makeText(testDangky.this,"Email hoặc mật khẩu không được để trống",Toast.LENGTH_SHORT).show();
        }else if (!strPassword.equals(strRePassword)){
            Toast.makeText(testDangky.this,"Mật khẩu và mật khẩu nhập lại phải giống nhau",Toast.LENGTH_SHORT).show();
        }else {
            FirebaseAuth mAuth = FirebaseAuth.getInstance();
            mAuth.createUserWithEmailAndPassword(strEmail,strPassword)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Intent intent = new Intent(testDangky.this, trang1.class);
                                startActivity(intent);
                                finishAffinity();
                            }else {
                                Toast.makeText(testDangky.this,"Dăng ký thất bại, tài khoản đã tồn tại",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
    private void onClickDangNhap() {
        Intent intent = new Intent(testDangky.this, MainActivity.class);
        startActivity(intent);
    }
}