package com.example.gominstop;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class SecondFragment extends Fragment {
    // Store instance variables
    private String title;
    private int page;

    private ImageView mwoman1;
    private ImageView mwoman2;
    private ImageView mwoman3;
    private ImageView mwoman4;
    private ImageView mwoman5;
    private ImageView mwoman6;

    // newInstance constructor for creating fragment with arguments
    public static SecondFragment newInstance(int page, String title) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragment.setArguments(args);
        return fragment;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");

    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cloth_second, container, false);
        mwoman1 = (ImageView)view.findViewById(R.id.woman1);
        mwoman2 = (ImageView)view.findViewById(R.id.woman2);
        mwoman3 = (ImageView)view.findViewById(R.id.woman3);
        mwoman4 = (ImageView)view.findViewById(R.id.woman4);
        mwoman5 = (ImageView)view.findViewById(R.id.woman5);
        mwoman6 = (ImageView)view.findViewById(R.id.woman6);

        Glide.with(view).load("http://49.236.136.225:8080/AndroidImages/woman1.png").into(mwoman1);
        Glide.with(view).load("http://49.236.136.225:8080/AndroidImages/woman2.png").into(mwoman2);
        Glide.with(view).load("http://49.236.136.225:8080/AndroidImages/woman3.png").into(mwoman3);
        Glide.with(view).load("http://49.236.136.225:8080/AndroidImages/woman5.png").into(mwoman4);
        Glide.with(view).load("http://49.236.136.225:8080/AndroidImages/woman6.png").into(mwoman5);
        Glide.with(view).load("http://49.236.136.225:8080/AndroidImages/woman1.png").into(mwoman6);

        return view;
    }
}