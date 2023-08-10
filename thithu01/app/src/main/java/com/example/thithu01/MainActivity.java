package com.example.thithu01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3;
    TextView tvKQ;
    String strKQ = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn01);
        btn2 = findViewById(R.id.btn02);
        btn3 = findViewById(R.id.btn03);
        tvKQ = findViewById(R.id.txtkq);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDSHSlopk73101();
            }

        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDSHStenBVA();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDSHSdiachiHanoi();
            }
        });
    }

    private void getDSHSlopk73101() {

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

        String url = "https://phucle1123.000webhostapp.com/thithu/ds_hocsinh_lopk_73101.php";

        JsonObjectRequest request = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray products = response.getJSONArray("students");
                    strKQ = "";
                    for (int i = 0; i < products.length(); i++) {
                        JSONObject product = products.getJSONObject(i);
                        String idhocsinh = product.getString("idhocsinh");
                        String hoten = product.getString("hoten");
                        String ngaysinh = product.getString("ngaysinh");
                        String gioitinh = product.getString("gioitinh");
                        String diachi = product.getString("diachi");
                        String loptruong = product.getString("loptruong");
                        String bithuchidoan = product.getString("bithuchidoan");
                        String ghichu = product.getString("ghichu");
                        String tenlop = product.getString("tenlop");
                        strKQ += "idhocsinh: " + idhocsinh + "\n";
                        strKQ += "hoten: " + hoten + "\n";
                        strKQ += "ngaysinh: " + ngaysinh + "\n";
                        strKQ += "gioitinh: " + gioitinh + "\n";
                        strKQ += "diachi: " + diachi + "\n";
                        strKQ += "loptruong: " + loptruong + "\n";
                        strKQ += "bithuchidoan: " + bithuchidoan + "\n";
                        strKQ += "ghichu: " + ghichu + "\n";
                        strKQ += "tenlop: " + tenlop + "\n";
                        strKQ += "----------------------------------------\n";
                    }
                    tvKQ.setText(strKQ);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tvKQ.setText(error.getMessage());
            }
        });

        queue.add(request);
    }
    private void getDSHStenBVA() {
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

        String url = "https://phucle1123.000webhostapp.com/thithu/hs_hocsinh_alllop_ten_a.php";

        JsonObjectRequest request = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray products = response.getJSONArray("students");
                    strKQ = "";
                    for (int i = 0; i < products.length(); i++) {
                        JSONObject product = products.getJSONObject(i);
                        String idhocsinh = product.getString("idhocsinh");
                        String hoten = product.getString("hoten");
                        String ngaysinh = product.getString("ngaysinh");
                        String gioitinh = product.getString("gioitinh");
                        String diachi = product.getString("diachi");
                        String loptruong = product.getString("loptruong");
                        String bithuchidoan = product.getString("bithuchidoan");
                        String ghichu = product.getString("ghichu");
                        String tenlop = product.getString("tenlop");
                        strKQ += "idhocsinh: " + idhocsinh + "\n";
                        strKQ += "hoten: " + hoten + "\n";
                        strKQ += "ngaysinh: " + ngaysinh + "\n";
                        strKQ += "gioitinh: " + gioitinh + "\n";
                        strKQ += "diachi: " + diachi + "\n";
                        strKQ += "loptruong: " + loptruong + "\n";
                        strKQ += "bithuchidoan: " + bithuchidoan + "\n";
                        strKQ += "ghichu: " + ghichu + "\n";
                        strKQ += "tenlop: " + tenlop + "\n";
                        strKQ += "----------------------------------------\n";
                    }
                    tvKQ.setText(strKQ);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tvKQ.setText(error.getMessage());
            }
        });

        queue.add(request);
    }
    private void getDSHSdiachiHanoi() {
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

        String url = "https://phucle1123.000webhostapp.com/thithu/hs_hocsinh_diachi_hanoi.php";

        JsonObjectRequest request = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray products = response.getJSONArray("students");
                    strKQ = "";
                    for (int i = 0; i < products.length(); i++) {
                        JSONObject product = products.getJSONObject(i);
                        String idhocsinh = product.getString("idhocsinh");
                        String hoten = product.getString("hoten");
                        String ngaysinh = product.getString("ngaysinh");
                        String gioitinh = product.getString("gioitinh");
                        String diachi = product.getString("diachi");
                        String loptruong = product.getString("loptruong");
                        String bithuchidoan = product.getString("bithuchidoan");
                        String ghichu = product.getString("ghichu");
                        String tenlop = product.getString("tenlop");
                        strKQ += "idhocsinh: " + idhocsinh + "\n";
                        strKQ += "hoten: " + hoten + "\n";
                        strKQ += "ngaysinh: " + ngaysinh + "\n";
                        strKQ += "gioitinh: " + gioitinh + "\n";
                        strKQ += "diachi: " + diachi + "\n";
                        strKQ += "loptruong: " + loptruong + "\n";
                        strKQ += "bithuchidoan: " + bithuchidoan + "\n";
                        strKQ += "ghichu: " + ghichu + "\n";
                        strKQ += "tenlop: " + tenlop + "\n";
                        strKQ += "----------------------------------------\n";
                    }
                    tvKQ.setText(strKQ);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tvKQ.setText(error.getMessage());
            }
        });

        queue.add(request);
    }



}