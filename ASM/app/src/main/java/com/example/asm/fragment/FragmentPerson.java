package com.example.asm.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asm.R;

public class FragmentPerson extends Fragment {

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

        return view;
    }
}