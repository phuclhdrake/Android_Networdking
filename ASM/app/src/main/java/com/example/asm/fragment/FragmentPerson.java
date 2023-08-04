package com.example.asm.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.asm.R;
import com.example.asm.activity.AdminActivity;
import com.example.asm.activity.LoginActivity;
import com.example.asm.activity.SignUpActivity;

public class FragmentPerson extends Fragment {

    Button btnAdmin;

    public FragmentPerson() {
        // Required empty public constructor
    }

    public static FragmentPerson newInstance(String param1, String param2) {
        FragmentPerson fragment = new FragmentPerson();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_person, container, false);
        btnAdmin = view.findViewById(R.id.btnAdmin);
        btnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AdminActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}