package com.example.gominstop;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

public class GetallrightAdapter extends PagerAdapter {
    public int length = 5;
    public GetallrightAdapter(Context context){
        this.context = context;

    }
    private LayoutInflater inflater;
    private Context context;
    @Override
    public int getCount() {
        return  this.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((LinearLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.lebrierslider, container, false);
        ImageView slider = (ImageView)v.findViewById(R.id.imageslide);
        switch(position){
            case 0:
                Glide.with(v).load("http://49.236.136.225:8080/AndroidImages/getallright4.jpg").fitCenter().into(slider);
                break;
            case 1:
                Glide.with(v).load("http://49.236.136.225:8080/AndroidImages/getallright2.png").fitCenter().into(slider);
                break;
            case 2:
                Glide.with(v).load("http://49.236.136.225:8080/AndroidImages/getallright3.jpg").fitCenter().into(slider);
                break;
            case 3:
                Glide.with(v).load("http://49.236.136.225:8080/AndroidImages/getallright1.png").fitCenter().into(slider);
                break;
            case 4:
                Glide.with(v).load("http://49.236.136.225:8080/AndroidImages/getallright5.jpg").fitCenter().into(slider);
                break;
        }
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.invalidate();
    }
}

