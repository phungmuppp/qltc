package com.example.ungdungdautien;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class User_class {
    String HoTen,Email,SDT,NgaySinh,Avatar;
    long CMND,ThongKe;
    DatabaseReference nodeRoot;

    public User_class(){
        nodeRoot = FirebaseDatabase.getInstance().getReference();
    }

    public long getCMND() {
        return CMND;
    }

    public long getThongKe() {
        return ThongKe;
    }

    public String getAvatar() {
        return Avatar;
    }

    public String getEmail() {
        return Email;
    }

    public String getHoTen() {
        return HoTen;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }

    public void setCMND(long CMND) {
        this.CMND = CMND;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setThongKe(long thongKe) {
        ThongKe = thongKe;
    }
    public void getDanhSachUser(){
        List<User_class> user_classList = new ArrayList<>();
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.d("kiemtra", snapshot.child("User") + "");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };

        nodeRoot.addListenerForSingleValueEvent(valueEventListener);
    }
}

