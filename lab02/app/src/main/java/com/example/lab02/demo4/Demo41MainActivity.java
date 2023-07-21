package com.example.lab02.demo4;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab02.R;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Demo41MainActivity extends AppCompatActivity {
    EditText txt1, txt2, txt3;
    Button btnInsert, btnGet;
    TextView tvKQ;
    ArrayList<String> dataList;
    ArrayAdapter<String> adapter;
    ListView listView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo41_main);
        txt1 = findViewById(R.id.demo41Txt1);
        txt2 = findViewById(R.id.demo41Txt2);
        txt3 = findViewById(R.id.demo41Txt3);
        btnInsert = findViewById(R.id.demo41Btn1);
        btnGet = findViewById(R.id.demo41Btn2);
        tvKQ = findViewById(R.id.demo41TvKQ);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectData();
            }
        });
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });

        // Tạo ArrayList để lưu trữ dữ liệu
        dataList = new ArrayList<>();

        // Tạo một instance của ArrayAdapter và liên kết nó với ListView
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }

    String kq = "";//chuoi ket qua
    ArrayList<Prd> ls;//tao list prd
    Prd prd = new Prd();//tao doi tuong prd

    void insertData() {
        //B0. Dua du lieu vao doi tuong
        prd.setName(txt1.getText().toString());
        prd.setPrice(txt2.getText().toString());
        prd.setDescription(txt3.getText().toString());
        //B1. Tao doi tuong retrofit
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://phucle1123.000webhostapp.com/lab04/").addConverterFactory(GsonConverterFactory.create()).build();
        //b2. Chuan bi ham va thuc thi ham
        //2.1 - goi inteface
        InterfaceInsert interfaceInsert = retrofit.create(InterfaceInsert.class);
        //2.2. chuan bi ham
        Call<SvrResponseInsert> call = interfaceInsert.insertPrd(prd.getName(), prd.getPrice(), prd.getDescription());
        //2.3 goi ham
        call.enqueue(new Callback<SvrResponseInsert>() {
            //thanh cong
            @Override
            public void onResponse(Call<SvrResponseInsert> call, Response<SvrResponseInsert> response) {
                SvrResponseInsert svrResponseInsert = response.body();//lay noi dung server tra ve
                tvKQ.setText(svrResponseInsert.getMessage());//in ra ket qua
            }

            //that bai
            @Override
            public void onFailure(Call<SvrResponseInsert> call, Throwable t) {
                tvKQ.setText(t.getMessage());//in ra thong bao loi
            }
        });
    }
    void selectData() {
        //b1. tao doi tuong retrofit
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://phucle1123.000webhostapp.com/lab04/").addConverterFactory(GsonConverterFactory.create()).build();
        //b2. Goi interface, chuan bi ham va goi ham
        InterfaceSelect interfaceSelect = retrofit.create(InterfaceSelect.class);
        Call<SvrResponseSelect> call = interfaceSelect.getPrd();
        call.enqueue(new Callback<SvrResponseSelect>() {
            //thanh cong
            @Override
            public void onResponse(Call<SvrResponseSelect> call, Response<SvrResponseSelect> response) {
                SvrResponseSelect svrResponseSelect = response.body();//lay ket qua server tra ve
                ls = new ArrayList<>(Arrays.asList(svrResponseSelect.getProducts()));//chuyen du lieu sang list
                kq = "";// Xóa dữ liệu hiện có trong biến kq
                for (Prd p : ls)//cho vao vong for de doc tung doi tuong
                {
                    kq += "Name: " + p.getName() + "\nPrice: " + p.getPrice() + "\nDes: " + p.getDescription() + "\n" + "---------------------------------\n";
                }
                // Xóa dữ liệu trong ArrayList
                dataList.clear();
                // Thêm giá trị kq vào ArrayList và cập nhật adapter
                dataList.add(kq);
                adapter.notifyDataSetChanged();
            }

            //that bai
            @Override
            public void onFailure(Call<SvrResponseSelect> call, Throwable t) {
                tvKQ.setText(t.getMessage());//in ra thong bao loi
            }
        });
    }
}