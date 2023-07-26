package com.example.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab02.lab022.CNAsync;
import com.example.lab02.lab022.lab02Interface;

public class MainActivity extends AppCompatActivity implements lab02Interface, View.OnClickListener {
    Button btn;
    TextView txt;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.lab02Btn);
        txt = findViewById(R.id.lab02Txt);
        img = findViewById(R.id.lab02Img);

        btn.setOnClickListener(this);
    }
    // khi click vao button
    @Override
    public void onClick(View v) {
        new CNAsync(this, this).execute("http://tinypic.com/images/goodbye.jpg");
    }
    // tra ve ket qua
    @Override
    public void onLoadBitmap(Bitmap bitmap) {
        img.setImageBitmap(bitmap);
        txt.setText("load du lieu thanh cong");
    }
    // neu co loi
    @Override
    public void onError() {
        txt.setText("loi load du lieu");
    }
}