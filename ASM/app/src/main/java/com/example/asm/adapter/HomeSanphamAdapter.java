package com.example.asm.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asm.R;
import com.example.asm.model.Sanpham;
import com.example.asm.myInterface.IClickItemHomeProduct;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class HomeSanphamAdapter extends RecyclerView.Adapter<HomeSanphamAdapter.ItemHolder> {

    ArrayList<Sanpham> sanphamArrayList;
    Context context;
    private IClickItemHomeProduct iClickItemHomeProduct;

    public HomeSanphamAdapter(ArrayList<Sanpham> sanphamArrayList, Context context, IClickItemHomeProduct iClickHomeProduct) {
        this.sanphamArrayList = sanphamArrayList;
        this.context = context;
        this.iClickItemHomeProduct = iClickHomeProduct;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_product, null);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        final Sanpham sanpham = sanphamArrayList.get(position);
        holder.txtTensp.setText(sanpham.getTenSP());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtGiasp.setText(decimalFormat.format(sanpham.getGiaSP()) + "Đ");
        Picasso.with(context).load(sanpham.getHinhAnhSP())
                .placeholder(R.drawable.imgload)
                .error(R.drawable.imgerror)
                .into(holder.imgHinhanhsp);

        holder.btnGoDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // chhuyen man hinh detail
                iClickItemHomeProduct.onClickItemHomeProduct(sanpham);
            }
        });
    }



    @Override
    public int getItemCount() {
        return sanphamArrayList.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder{
        ImageView imgHinhanhsp;
        TextView txtTensp, txtGiasp;
        LinearLayout btnGoDetail;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            imgHinhanhsp = itemView.findViewById(R.id.imgHinhanhsp_home_product);
            txtTensp = itemView.findViewById(R.id.txtTensp_home_product);
            txtGiasp = itemView.findViewById(R.id.txtGia_home_product);
            btnGoDetail= itemView.findViewById(R.id.btn_GoDetail);
        }
    }
}
