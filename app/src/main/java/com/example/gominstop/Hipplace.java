package com.example.gominstop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;


public class Hipplace extends AppCompatActivity {
    Adapter adapter;
    GetallrightAdapter getallrightAdapter;
    FountainAdapter fountainAdapter;
    TrapAdapter trapAdapter;
    TribeAdapter tribeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hipplace);
        ViewPager getallright = (ViewPager)findViewById(R.id.getallright); // Getallright_slide
        getallrightAdapter = new GetallrightAdapter(this);
        getallright.setAdapter(getallrightAdapter);

        ViewPager fountain = (ViewPager)findViewById(R.id.fountain); // fountain slide
        fountainAdapter = new  FountainAdapter(this);
        fountain.setAdapter(fountainAdapter);

        ViewPager trap = (ViewPager)findViewById(R.id.trap); // trap  slide
        trapAdapter = new  TrapAdapter(this);
        trap.setAdapter(trapAdapter);

        ViewPager tribe = (ViewPager)findViewById(R.id.tribe); // tribe slide
        tribeAdapter = new  TribeAdapter(this);
        tribe.setAdapter(tribeAdapter);
    }
}
