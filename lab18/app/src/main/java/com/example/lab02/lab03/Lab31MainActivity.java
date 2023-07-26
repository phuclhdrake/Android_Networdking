package com.example.lab02.lab03;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab02.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Lab31MainActivity extends AppCompatActivity {
    TextView tvKQ;
    EditText txt1, txt2;
    Button btn1, btn2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab031_main_activity);
        tvKQ = findViewById(R.id.lab03Tv1);
        txt1 = findViewById(R.id.lab03Txt1);
        txt2 = findViewById(R.id.lab03Txt2);
        btn1 = findViewById(R.id.lab03Btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new GETAsync().execute();
            }
        });
        btn2 = findViewById(R.id.lab03btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new POSTAsync().execute();
            }
        });
    }

    class POSTAsync extends AsyncTask<Void, Void, Void> {
        String pathPost = "https://phucle1123.000webhostapp.com/lab03/lab03_post.php";
        String ketquapost = "";

        //lay du lieu tu server @Override
        protected Void doInBackground(Void... voids) {

            try {
                //1.chuyen path thanh url
                URL url = new URL(pathPost);
                //2.Ma hoa tham so
                String param = "canh=" + URLEncoder.encode(txt1.getText().toString(), "utf-8");
                //3. Mo ket noi
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                //4. Thiet lap cac thuoc tinh cho urlConnection
                urlConnection.setDoOutput(true);
                //co lay du lieu tra ve
                urlConnection.setRequestMethod("POST");
                //su dung phuong thuc post
                urlConnection.setFixedLengthStreamingMode(param.getBytes().length);
                //do dai cua tham so
                urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                //5. truyen tham so
                PrintWriter printWriter = new PrintWriter(urlConnection.getOutputStream());
                printWriter.print(param);
                printWriter.close();
                //6. doc du lieu
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                //bo dem
                StringBuilder stringBuilder = new StringBuilder();
                //bo chua du lieu
                String line = "";
                //doc theo dong
                while ((line = br.readLine()) != null)//neu van con du lieu thi van doc
                {
                    stringBuilder.append(line);//dua du lieu vao bo chua
                }
                ketquapost = stringBuilder.toString();
                //tra ve ket qua
                urlConnection.disconnect();
                //dong ket noi
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        //tra du lieu ve client @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            tvKQ.setText(ketquapost);
        }
    }

    class GETAsync extends AsyncTask<Void, Void, Void> {
        String pathGet = "https://phucle1123.000webhostapp.com/lab03/lab03_get.php";
        String ketquaget = "";

        @Override
        protected Void doInBackground(Void... voids) {
            pathGet += "?toan=" + txt1.getText().toString() + "&van=" + txt2.getText().toString();
            try {
                //chuyen path thanh url
                URL url = new URL(pathGet);
                BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
                //tao bo dem du lieu
                StringBuilder stringBuilder = new StringBuilder();
                //bat dau doc dulieu
                String line = "";
                while ((line = br.readLine()) != null) {//neu van con du lieu
                    stringBuilder.append(line);//dua du lieu vao bo chua
                }
                ketquaget = stringBuilder.toString();//tra ve ket qua
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            tvKQ.setText(ketquaget);
        }
    }
}
