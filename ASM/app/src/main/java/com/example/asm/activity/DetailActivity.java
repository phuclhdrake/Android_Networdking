package com.example.asm.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asm.R;
import com.example.asm.model.Sanpham;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    Button btnMua;
    ImageView imgHinhanhsp;
    TextView txtTensp, txtGiasp, txtMotasp;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        btnMua = findViewById(R.id.btnDetailMua);
        btnMua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, OrderActivity.class);
                startActivity(intent);
                /////demo
            }
        });
        // get du lieu tu home adapter
//        Bundle bundle = getIntent().getExtras();
//        if (bundle == null){
//            return;
//        }
//        Sanpham sanpham = (Sanpham) bundle.get("objSanpham");
//        txtTensp.setText(sanpham.getTenSP());
//        txtGiasp.setText(sanpham.getGiaSP());
//        txtMotasp.setText(sanpham.getMoTaSP());
//        Picasso.with(getApplicationContext()).load(sanpham.getHinhAnhSP())
//                .placeholder(R.drawable.imgload)
//                .error(R.drawable.imgerror)
//                .into(imgHinhanhsp);
    }
}