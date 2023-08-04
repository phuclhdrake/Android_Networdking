package com.example.asm.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.asm.R;
import com.example.asm.adapter.SanphamAdapter;
import com.example.asm.model.Sanpham;
import com.example.asm.ultil.CheckConnect;
import com.example.asm.ultil.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AdminActivity extends AppCompatActivity {
    RecyclerView rcv_admin_product;
    int id = 0;
    String tensanpham = "";
    int giasanpham = 0;
    String hinhanhsanpham = "";
    String motasanpham = "";
    int idsanpham = 0;
    ArrayList<Sanpham> mangSanpham;
    SanphamAdapter sanphamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        anhXa();
        if (CheckConnect.haveNetworkConnection(getApplicationContext())){
            // co ket noi internet
            CheckConnect.ShowToast_Short(getApplicationContext(), "Co mang");
            getDuLieuSP();
        }else {
            CheckConnect.ShowToast_Short(getApplicationContext(), "Khong co ket noi internet !");
            finish();
        }
    }

    private void getDuLieuSP() {
        //b1. chuan bi du lieu
        //b2. Tao queue
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        //b3. url
        String url = "https://phucle1123.000webhostapp.com/asm/get_all_sanpham.php";
        //b4. Xac dinh loai request
        JsonObjectRequest request = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray products = response.getJSONArray("Sanpham");

                    for (int i = 0; i < products.length(); i++) {
                        JSONObject product = products.getJSONObject(i);
                        id = product.getInt("id");
                        tensanpham = product.getString("tensanpham");
                        giasanpham = product.getInt("giasanpham");
                        hinhanhsanpham = product.getString("hinhanhsanpham");
                        motasanpham = product.getString("motasanpham");
                        idsanpham = product.getInt("idsanpham");
                        mangSanpham.add(new Sanpham(id, tensanpham, giasanpham, hinhanhsanpham, motasanpham, idsanpham));
                        sanphamAdapter.notifyDataSetChanged();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CheckConnect.ShowToast_Short(getApplicationContext(), "loi ne");
            }
        });
        //b5. truyen tham so (neu co)
        //b6. thuc thi
        queue.add(request);
    }

    private void anhXa(){
        rcv_admin_product = findViewById(R.id.rcv_product_admin);
        mangSanpham = new ArrayList<>();
        sanphamAdapter = new SanphamAdapter(mangSanpham,getApplicationContext());

        rcv_admin_product.setHasFixedSize(true);
        rcv_admin_product.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1));
//        LinearLayoutManager layoutManager= new LinearLayoutManager(getApplicationContext());
//        rcv_admin_product.setLayoutManager(layoutManager);
        rcv_admin_product.setAdapter(sanphamAdapter);
    }

}