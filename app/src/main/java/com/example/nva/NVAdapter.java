package com.example.nva;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class NVAdapter extends RecyclerView.Adapter<NVAdapter.ViewHolder> {

    private List<NhanVien> nhanVienList;

    public NVAdapter(List<NhanVien> nhanVienList) {
        this.nhanVienList = nhanVienList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nhanvien, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NhanVien nhanVien = nhanVienList.get(position);
        holder.tvMaNV.setText(nhanVien.getMaNV());
        holder.tvTenNV.setText(nhanVien.getTenNV());
        holder.tvChucVu.setText(nhanVien.getChucVu());
        holder.tvGioiTinh.setText(nhanVien.getGioiTinh());
        holder.tvDiaChi.setText(nhanVien.getDiaChi());
    }

    @Override
    public int getItemCount() {
        return nhanVienList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvMaNV, tvTenNV, tvChucVu, tvGioiTinh, tvDiaChi;

        public ViewHolder(View itemView) {
            super(itemView);
            tvMaNV = itemView.findViewById(R.id.tv_ma_nv);
            tvTenNV = itemView.findViewById(R.id.tv_ten_nv);
            tvChucVu = itemView.findViewById(R.id.tv_chuc_vu);
            tvGioiTinh = itemView.findViewById(R.id.tv_gioi_tinh);
            tvDiaChi = itemView.findViewById(R.id.tv_dia_chi);
        }
    }
}
