package com.example.lab02.lab022;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class CNAsync  extends AsyncTask<String, Void, Bitmap> {
    private lab02Interface lab02Interface;
    private Context context;

    public CNAsync(lab02Interface lab02Interface, Context context) {
        this.lab02Interface = lab02Interface;
        this.context = context;
    }

    // truyen chuoi lay ve anh
    // input
    @Override
    protected Bitmap doInBackground(String... strings) {
        try {
            //lay ve anh theo duong dan
            return BitmapFactory.decodeStream((InputStream) new URL(strings[0]).getContent());
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
    // output
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap != null) {
            lab02Interface.onLoadBitmap(bitmap);//tra ket qua cho interface
        }else {
            lab02Interface.onError(); // neu loi cũng tra ve kết qua cho interface
        }
    }
    // qua trinh
    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
