package com.example.ungdungdautien;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ThongKe_class {

    String[] Ngay;
    String[] Thang;
    String[] Nam;
    DatabaseReference dataThongKe;

    public ThongKe_class(){
        dataThongKe = FirebaseDatabase.getInstance().getReference().child("ThongKe");
    }

    public String[] getNam() {
        return Nam;
    }

    public String[] getNgay() {
        return Ngay;
    }

    public String[] getThang() {
        return Thang;
    }

    public void setNam(String[] nam) {
        Nam = nam;
    }

    public void setNgay(String[] ngay) {
        Ngay = ngay;
    }

    public void setThang(String[] thang) {
        Thang = thang;
    }

    public void getDSThongKe(){
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.d("kiemtra", snapshot + "");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };

        dataThongKe.addListenerForSingleValueEvent(valueEventListener);
    }
}
