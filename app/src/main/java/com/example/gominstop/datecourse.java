package com.example.gominstop;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import androidx.viewpager.widget.ViewPager;


public class datecourse extends AppCompatActivity {
    Adapter adapter;
    MuseaumAdapter museaumAdapter;
    GwanggyoAdapter gwanggyoAdapter;
    FloatingAdapter floatingAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_datecourse);
        ViewPager restaurant = (ViewPager)findViewById(R.id.restaurant); // restaurant slide
        adapter = new Adapter(this);
        restaurant.setAdapter(adapter);

        ViewPager museaum = (ViewPager)findViewById(R.id.museaum); // museaum slide
        museaumAdapter = new  MuseaumAdapter(this);
        museaum.setAdapter(museaumAdapter);

        ViewPager Gwanggyo = (ViewPager)findViewById(R.id.gwanggyo); // Gwanggyo river park slide
        gwanggyoAdapter = new  GwanggyoAdapter(this);
        Gwanggyo.setAdapter(gwanggyoAdapter);

        ViewPager Floating = (ViewPager)findViewById(R.id.floating); // floating rooftop bar slide
        floatingAdapter = new  FloatingAdapter(this);
        Floating.setAdapter(floatingAdapter);
    }
}