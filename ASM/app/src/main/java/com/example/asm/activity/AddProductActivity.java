package com.example.asm.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.asm.R;
import com.example.asm.ultil.CheckConnect;

import java.util.HashMap;
import java.util.Map;

public class AddProductActivity extends AppCompatActivity {
    Button btnAddProduct;
    EditText edtTensp, edtGiasp, edtHinhanhsp, edtMotasp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        Anhxa();

        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProductVolley();
            }
        });
    }

    private void Anhxa() {
        btnAddProduct = findViewById(R.id.btn_add_product);
        edtTensp = findViewById(R.id.edt_Tensp);
        edtGiasp = findViewById(R.id.edt_Giasp);
        edtHinhanhsp = findViewById(R.id.edt_Hinhanhsp);
        edtMotasp = findViewById(R.id.edt_Motasp);
    }



    private void addProductVolley() {
        //b1. chuan bi du lieu
        //b2. Tao queue
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        //b3. url
        String url = "https://phucle1123.000webhostapp.com/asm/create_product.php";
        //b4. Xac dinh loai request
        //StringRequest(method,url,thanhCong,thatBai){thamso};
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        CheckConnect.ShowToast_Short(getApplicationContext(), response.toString());
//                        Intent intent = new Intent(getApplicationContext(), AdminActivity.class);
//                        startActivity(intent);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CheckConnect.ShowToast_Short(getApplicationContext(), error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> mydata = new HashMap<>();
                mydata.put("tensanpham", edtTensp.getText().toString());
                mydata.put("giasanpham", edtGiasp.getText().toString());
                mydata.put("hinhanhsanpham", edtHinhanhsp.getText().toString());
                mydata.put("motasanpham", edtMotasp.getText().toString());
                mydata.put("idsanpham", "1");
                return mydata;
            }
        };
        //b5. truyen tham so (neu co)
        //b6. thuc thi
        queue.add(request);
    }


}