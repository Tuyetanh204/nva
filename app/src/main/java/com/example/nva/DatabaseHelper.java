package com.example.nva;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "NhanVienDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NHANVIEN = "nhanvien";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_MANV = "maNV";
    private static final String COLUMN_TENNV = "tenNV";
    private static final String COLUMN_CHUCVU = "chucVu";
    private static final String COLUMN_GIOITINH = "gioiTinh";
    private static final String COLUMN_DIACHI = "diaChi";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NHANVIEN + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_MANV + " TEXT,"
                + COLUMN_TENNV + " TEXT,"
                + COLUMN_CHUCVU + " TEXT,"
                + COLUMN_GIOITINH + " TEXT,"
                + COLUMN_DIACHI + " TEXT" + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NHANVIEN);
        onCreate(db);
    }

    public void addNhanVien(String maNV, String tenNV, String chucVu, String gioiTinh, String diaChi) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_MANV, maNV);
        values.put(COLUMN_TENNV, tenNV);
        values.put(COLUMN_CHUCVU, chucVu);
        values.put(COLUMN_GIOITINH, gioiTinh);
        values.put(COLUMN_DIACHI, diaChi);
        db.insert(TABLE_NHANVIEN, null, values);
        db.close();
    }

    public List<NhanVien> getAllNhanVien() {
        List<NhanVien> nhanVienList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NHANVIEN, null);
        if (cursor.moveToFirst()) {
            do {
                NhanVien nhanVien = new NhanVien(cursor.getInt(0),
                        cursor.getString(1), cursor.getString(2),
                        cursor.getString(3), cursor.getString(4),
                        cursor.getString(5));
                nhanVienList.add(nhanVien);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return nhanVienList;
    }
}
