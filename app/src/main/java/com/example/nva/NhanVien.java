package com.example.nva;

import android.os.Parcel;
import android.os.Parcelable;

public class NhanVien implements Parcelable {
    private int id;
    private String maNV;
    private String tenNV;
    private String chucVu;
    private String gioiTinh;
    private String diaChi;

    // Constructor
    public NhanVien(int id, String maNV, String tenNV, String chucVu, String gioiTinh, String diaChi) {
        this.id = id;
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.chucVu = chucVu;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
    }

    // Parcelable methods
    protected NhanVien(Parcel in) {
        id = in.readInt();
        maNV = in.readString();
        tenNV = in.readString();
        chucVu = in.readString();
        gioiTinh = in.readString();
        diaChi = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(maNV);
        dest.writeString(tenNV);
        dest.writeString(chucVu);
        dest.writeString(gioiTinh);
        dest.writeString(diaChi);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<NhanVien> CREATOR = new Creator<NhanVien>() {
        @Override
        public NhanVien createFromParcel(Parcel in) {
            return new NhanVien(in);
        }

        @Override
        public NhanVien[] newArray(int size) {
            return new NhanVien[size];
        }
    };

    // Getters and Setters

public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
