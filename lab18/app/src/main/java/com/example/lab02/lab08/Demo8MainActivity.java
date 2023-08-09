package com.example.lab02.lab08;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab02.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Demo8MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4;
    TextView tvKQ;
    Context context = this;
    FirebaseFirestore database;
    String strKQ = "";
    EditText txt1, txt2, txt3, txt4;
    ToDo toDo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo8_main);
        btn1 = findViewById(R.id.demo81Btn1);
        btn2 = findViewById(R.id.demo81Btn2);
        btn3 = findViewById(R.id.demo81Btn3);
        btn4 = findViewById(R.id.demo81Btn4);
        tvKQ = findViewById(R.id.demo81TvKQ);
        txt1 = findViewById(R.id.demo81Txt1);
        txt2 = findViewById(R.id.demo81Txt2);
        txt3 = findViewById(R.id.demo81Txt3);
        txt4 = findViewById(R.id.demo81Txt4);
        database=FirebaseFirestore.getInstance();
        btn1.setOnClickListener((view) -> {
            SelectDataFromFirebase();
        });
        btn2.setOnClickListener((view) -> {
            insertFirebase();
        });
        btn3.setOnClickListener((view) -> {
            updateFirebase();
        });
        btn4.setOnClickListener((view) -> {
            deleteFirebase();
        });
    }

    public void insertFirebase() {
        tvKQ.setText("");
        toDo = new ToDo(txt1.getText().toString(), txt2.getText().toString(), txt3.getText().toString(), txt4.getText().toString());
        database.collection("PRODUCTS")
                .document(toDo.getPid())//dat ten cho document
                .set(toDo.convertHashMap())//insert
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        tvKQ.setText("them thanh cong");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(context, "them that bai",
                                Toast.LENGTH_SHORT).show();
                        tvKQ.setText("that bai " + e.getMessage());
                    }
                });
    }

    public void updateFirebase() {
        tvKQ.setText("");
        toDo = new ToDo(txt1.getText().toString(), txt2.getText().toString(), txt3.getText().toString(), txt4.getText().toString());
        database.collection("PRODUCTS")//ten bang du lieu
                .document(toDo.getPid())//lay dong du lieu can update
                .update(toDo.convertHashMap())//update
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(context, "update thanh cong",
                                Toast.LENGTH_SHORT).show();
                        tvKQ.setText("sua thanh cong");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(context, "update that bat",
                                Toast.LENGTH_SHORT).show();
                        tvKQ.setText("That bai " + e.getMessage());
                    }
                });
    }

    public void deleteFirebase() {
        tvKQ.setText("");
        String id = txt1.getText().toString();
        database.collection("PRODUCTS")
                .document(id)
                .delete()//thuc hien xoa
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(context, "Delete thanh cong",
                                Toast.LENGTH_SHORT).show();
                        tvKQ.setText("xoa thanh cong");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(context, "delete that bai",
                                Toast.LENGTH_SHORT).show();
                        tvKQ.setText("xoa that bai " + e.getMessage());
                    }
                });
    }

    public ArrayList<ToDo> SelectDataFromFirebase() {
        tvKQ.setText("");
        ArrayList<ToDo> list = new ArrayList<>();
        database.collection("PRODUCTS")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful())//neu lay du lieu thanh cong thi moi cho vao vong lap
                        {
                            strKQ = "";
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                ToDo toDo1 = document.toObject(ToDo.class);
                                list.add(toDo1);
                                strKQ += "id: " + toDo1.getPid() + "\n";
                                strKQ += "name: " + toDo1.getName() + "\n";
                                strKQ += "price: " + toDo1.getPrice() + "\n";
                                strKQ += "description: " + toDo1.getDes() + "\n";
                                strKQ += "---------------------------------\n";
                            }
                            Toast.makeText(context, strKQ, Toast.LENGTH_SHORT).show();
                            tvKQ.setText(strKQ);
                        } else {
                            Toast.makeText(context, "Doc du lieu that bai",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(context, "Doc du lieu that bai",
                                Toast.LENGTH_SHORT).show();
                        tvKQ.setText("Doc du lieu that bai");
                    }
                });
        return list;
    }

}