package com.example.asm.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asm.R;
import com.example.asm.model.Loaisp;
import com.example.asm.model.Sanpham;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SanphamAdapter extends RecyclerView.Adapter<SanphamAdapter.ItemHolder> {
    ArrayList<Sanpham> arrayListSanpham;
    Context context;

    public SanphamAdapter(ArrayList<Sanpham> arrayListSanpham, Context context) {
        this.arrayListSanpham = arrayListSanpham;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_admin_product, null);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Sanpham sanpham = arrayListSanpham.get(position);
        holder.txtTensp.setText(sanpham.getTenSP());

        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtGia.setText(decimalFormat.format(sanpham.getGiaSP()) + "Đ");
        holder.txtMota.setText(sanpham.getMoTaSP());
        Picasso.with(context).load(sanpham.getHinhAnhSP())
                .placeholder(R.drawable.imgload)
                .error(R.drawable.imgerror)
                .into(holder.imgSanpham);
    }

    @Override
    public int getItemCount() {
        return arrayListSanpham.size();
    }


    public class ItemHolder extends RecyclerView.ViewHolder{
        public TextView txtTensp, txtGia, txtMota;
        public ImageView imgSanpham;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            imgSanpham = itemView.findViewById(R.id.img_admin_product);
            txtTensp = itemView.findViewById(R.id.txtTensp_admin_product);
            txtGia = itemView.findViewById(R.id.txtGia_admin_product);
            txtMota = itemView.findViewById(R.id.txtMota_admin_product);
        }
    }

}
