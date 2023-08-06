package com.example.asm.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

public class UpdateProductActivity extends AppCompatActivity {
    EditText edtUpdateProductTensp, edtUpdateProductGiasp, edtUpdateProductHinhanhsp, edtUpdateProductMotasp;
    Button btnUpdateProduct;
    private int id = 0;
    private String tensanpham = "";
    private int giasanpham = 0;
    private String hinhanhsanpham = "";
    private String motasanpham = "";
    private int idsanpham = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_product);

        // Get the intent that started this activity
        Intent intent = getIntent();

        // anh xa --------------
        Anhxa();

        // Check if the intent has the extras you passed from the previous activity
        if (intent != null) {
            // Retrieve the data using the keys you used in putExtra
            id = intent.getIntExtra("id", -1);
            tensanpham = intent.getStringExtra("tensanpham");
            giasanpham = intent.getIntExtra("giasanpham", -1);
            hinhanhsanpham = intent.getStringExtra("hinhanhsanpham");
            motasanpham = intent.getStringExtra("motasanpham");
            idsanpham = intent.getIntExtra("idsanpham", -1);

            edtUpdateProductTensp.setText(tensanpham);
            edtUpdateProductGiasp.setText(String.valueOf(giasanpham));
            edtUpdateProductHinhanhsp.setText(hinhanhsanpham);
            edtUpdateProductMotasp.setText(motasanpham);

            btnUpdateProduct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    UpdateProductVolley();
                }
            });
        }
    }

    private void Anhxa() {
        edtUpdateProductTensp = findViewById(R.id.edt_UpdateTensp);
        edtUpdateProductGiasp = findViewById(R.id.edt_UpdateGiasp);
        edtUpdateProductHinhanhsp = findViewById(R.id.edt_UpdateHinhanhsp);
        edtUpdateProductMotasp = findViewById(R.id.edt_UpdateMotasp);
        btnUpdateProduct = findViewById(R.id.btn_Update_product);
    }

    // ham update du lieu
    private void UpdateProductVolley() {
        //b1. chuan bi du lieu
        //b2. Tao queue
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        //b3. url
        String url = "https://phucle1123.000webhostapp.com/asm/update_product.php";
        //b4. Xac dinh loai request
        //StringRequest(method,url,thanhCong,thatBai){thamso};
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        CheckConnect.ShowToast_Short(getApplicationContext(), response.toString());
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
                mydata.put("id", String.valueOf(id));
                mydata.put("tensanpham", edtUpdateProductTensp.getText().toString());
                mydata.put("giasanpham", edtUpdateProductGiasp.getText().toString());
                mydata.put("hinhanhsanpham", edtUpdateProductHinhanhsp.getText().toString());
                mydata.put("motasanpham", edtUpdateProductMotasp.getText().toString());
                mydata.put("idsanpham", String.valueOf(idsanpham));
                return mydata;
            }
        };
        //b5. truyen tham so (neu co)
        //b6. thuc thi
        queue.add(request);
    }

}