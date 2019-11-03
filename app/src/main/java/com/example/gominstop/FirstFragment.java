package com.example.gominstop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.nio.ByteBuffer;


public class FirstFragment extends Fragment {
    // Store instance variables
    private String title;
    private int page;
    private ImageView mman1;
    private ImageView mman2;
    private ImageView mman3;
    private ImageView mman4;
    private ImageView mman5;
    private ImageView mman6;
    private TextView mtext1;
    private TextView mtext2;
    private TextView mtext3;
    private TextView mtext4;
    private TextView mtext5;
    private TextView mtext6;

    // newInstance constructor for creating fragment with arguments
    public static FirstFragment newInstance(int page, String title) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragment.setArguments(args);
        return fragment;
    }

    ViewFlipper flipper;

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }
    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cloth_first, container, false);
        mman1 = (ImageView) view.findViewById(R.id.man1);
        mman2 = (ImageView) view.findViewById(R.id.man2);
        mman3 = (ImageView) view.findViewById(R.id.man3);
        mman4 = (ImageView) view.findViewById(R.id.man4);
        mman5 = (ImageView) view.findViewById(R.id.man5);
        mman6 = (ImageView) view.findViewById(R.id.man6);
        mtext1 = (TextView) view.findViewById(R.id.mantext1);
        mtext2 = (TextView) view.findViewById(R.id.mantext2);
        mtext3 = (TextView) view.findViewById(R.id.mantext3);
        mtext4 = (TextView) view.findViewById(R.id.mantext4);
        mtext5 = (TextView) view.findViewById(R.id.mantext5);
        mtext6 = (TextView) view.findViewById(R.id.mantext6);
        Glide.with(view).load("http://49.236.136.225:8080/AndroidImages/man1.png").into(mman1);
        Glide.with(view).load("http://49.236.136.225:8080/AndroidImages/man2.png").into(mman2);
        Glide.with(view).load("http://49.236.136.225:8080/AndroidImages/man3.png").into(mman3);
        Glide.with(view).load("http://49.236.136.225:8080/AndroidImages/man4.png").into(mman4);
        Glide.with(view).load("http://49.236.136.225:8080/AndroidImages/man5.png").into(mman5);
        Glide.with(view).load("http://49.236.136.225:8080/AndroidImages/man6.png").into(mman6);
        return view;
    }
}