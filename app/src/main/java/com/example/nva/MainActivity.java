package com.example.nva;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etMaNV, etTenNV, etChucVu, etGioiTinh, etDiaChi;
    private Button btnSave, btnViewList;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMaNV = findViewById(R.id.et_ma_nv);
        etTenNV = findViewById(R.id.et_ten_nv);
        etChucVu = findViewById(R.id.et_chuc_vu);
        etGioiTinh = findViewById(R.id.et_gioi_tinh);
        etDiaChi = findViewById(R.id.et_dia_chi);
        btnSave = findViewById(R.id.btn_save);
        btnViewList = findViewById(R.id.btn_view_list);
        dbHelper = new DatabaseHelper(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maNV = etMaNV.getText().toString();
                String tenNV = etTenNV.getText().toString();
                String chucVu = etChucVu.getText().toString();
                String gioiTinh = etGioiTinh.getText().toString();
                String diaChi = etDiaChi.getText().toString();
                dbHelper.addNhanVien(maNV, tenNV, chucVu, gioiTinh, diaChi);
                etMaNV.setText("");
                etTenNV.setText("");
                etChucVu.setText("");
                etGioiTinh.setText("");
                etDiaChi.setText("");
            }
        });

        btnViewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<NhanVien> nhanVienList = new ArrayList<>(dbHelper.getAllNhanVien());
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                intent.putParcelableArrayListExtra("nhanVienList", nhanVienList);
                startActivity(intent);
            }
        });
    }
}
