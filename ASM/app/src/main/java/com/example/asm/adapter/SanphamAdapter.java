package com.example.asm.adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.asm.R;
import com.example.asm.activity.AddProductActivity;
import com.example.asm.activity.AdminActivity;
import com.example.asm.activity.UpdateProductActivity;
import com.example.asm.model.Sanpham;
import com.example.asm.ultil.CheckConnect;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SanphamAdapter extends RecyclerView.Adapter<SanphamAdapter.ItemHolder> {
    ArrayList<Sanpham> arrayListSanpham;
    Context context;
    int productId;

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

        holder.btnImgDeleteProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // xoa o day
                productId = sanpham.getId();
                CheckConnect.ShowToast_Short(context, String.valueOf(productId));
                deleteProductVolley(productId);
            }


        });

        holder.btnImgEditProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckConnect.ShowToast_Short(context, "check");
                //update product
                Intent intent = new Intent(context, UpdateProductActivity.class);
//                intent.putExtra("id", sanpham.getId());
//                intent.putExtra("tensanpham", sanpham.getTenSP());
//                intent.putExtra("giasanpham", sanpham.getGiaSP());
//                intent.putExtra("hinhanhsanpham", sanpham.getHinhAnhSP());
//                intent.putExtra("motasanpham", sanpham.getMoTaSP());
//                intent.putExtra("idsanpham", sanpham.getIdSP());
                context.startActivity(intent);
                //---------------------------
                //showDialogConfirmation();
                //-------------------------------
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayListSanpham.size();
    }


    public class ItemHolder extends RecyclerView.ViewHolder{
        public TextView txtTensp, txtGia, txtMota;
        public ImageView imgSanpham, btnImgEditProduct, btnImgDeleteProduct;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            imgSanpham = itemView.findViewById(R.id.img_admin_product);
            txtTensp = itemView.findViewById(R.id.txtTensp_admin_product);
            txtGia = itemView.findViewById(R.id.txtGia_admin_product);
            txtMota = itemView.findViewById(R.id.txtMota_admin_product);

            btnImgEditProduct = itemView.findViewById(R.id.btn_editProduct_img);
            btnImgDeleteProduct = itemView.findViewById(R.id.btn_deleteProduct_img);
        }
    }

    private void deleteProductVolley(int productId) {
        //b1. chuan bi du lieu
        //b2. Tao queue
        RequestQueue queue = Volley.newRequestQueue(context);
        //b3. url
        String url = "https://phucle1123.000webhostapp.com/asm/delete_product.php";
        //b4. Xac dinh loai request
        //StringRequest(method,url,thanhCong,thatBai){thamso};
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        CheckConnect.ShowToast_Short(context, response.toString());
                        notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CheckConnect.ShowToast_Short(context, error.getMessage());
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> mydata = new HashMap<>();
                mydata.put("id", String.valueOf(productId));
                return mydata;
            }
        };
        //b5. truyen tham so (neu co)
        //b6. thuc thi
        queue.add(request);
    }

    private void showDialogConfirmation() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        View dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_confirmation, null);
        dialogBuilder.setView(dialogView);

        TextView dialogMessage = dialogView.findViewById(R.id.dialog_message);
        Button btnYes = dialogView.findViewById(R.id.btnYes);
        Button btnNo = dialogView.findViewById(R.id.btnNo);

        AlertDialog dialog = dialogBuilder.create();
        dialog.show();

        // Set the dialog message
        dialogMessage.setText("Are you sure you want to continue?");

        // Handle "Yes" button click
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform the "Yes" action here
                CheckConnect.ShowToast_Short(context, "check");
                dialog.dismiss();
            }
        });

        // Handle "No" button click
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform the "No" action here
                CheckConnect.ShowToast_Short(context, "check");
                dialog.dismiss();
            }
        });
    }

}
