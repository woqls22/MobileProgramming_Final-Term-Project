package com.example.gominstop;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GambleActivity extends AppCompatActivity {
    private NumberPicker Player;
    private ImageView player1;
    private ImageView player2;
    private ImageView player3;
    private ImageView player4;
    private Random ran;
    private Button startbtn;
    private Button checkbtn;
    private TextView textplayer1;
    private TextView textplayer2;
    private TextView textplayer3;
    private TextView textplayer4;
    String Result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamble);
        Player = (NumberPicker)findViewById(R.id.playerNumber);
        Player.setWrapSelectorWheel(false);
        player1 = (ImageView)findViewById(R.id.player1);
        player2 = (ImageView)findViewById(R.id.player2);
        player3 = (ImageView)findViewById(R.id.player3);
        player4 = (ImageView)findViewById(R.id.player4);
         textplayer1 = (TextView)findViewById(R.id.textplayer1);
         textplayer2 = (TextView)findViewById(R.id.textplayer2);
         textplayer3 = (TextView)findViewById(R.id.textplayer3);
         textplayer4 = (TextView)findViewById(R.id.textplayer4);
        checkbtn =(Button)findViewById(R.id.Result);
        Player.setMinValue(0);
        Player.setMaxValue(4);
        startbtn =(Button)findViewById(R.id.GameStart);
        ran = new Random();
    }
    public void mOnClick(View v){
        switch (v.getId()) {
            case R.id.GameStart:
                setImage();
                break;
        }
    }

    public void setImage(){
        int num_of_player = Player.getValue();

        Animation anim1 = AnimationUtils.loadAnimation(this, R.anim.player1);
        Animation anim2 = AnimationUtils.loadAnimation(this, R.anim.player2);
        Animation anim3 = AnimationUtils.loadAnimation(this, R.anim.player3);
        Animation anim4 = AnimationUtils.loadAnimation(this, R.anim.player4);
        int a = ran.nextInt(5000)+1000;
        int b = ran.nextInt(5000)+1000;
        int c = ran.nextInt(5000)+1000;
        int d = ran.nextInt(5000)+1000;
        int[] Ranking = new int[4];

        switch (num_of_player){
            case 0 :
                Toast.makeText(this, "참가 인원을 설정해주세요", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this, "게임 참가인원을 늘려주세요", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                player1.setImageResource(R.drawable.plane);
                player2.setImageResource(R.drawable.plane);
                player3.setImageResource(0);
                player4.setImageResource(0);
                textplayer1.setText("1번");
                textplayer2.setText("2번");
                textplayer3.setText("");
                textplayer4.setText("");
                anim1.setDuration(a);
                anim2.setDuration(b);
                player1.startAnimation(anim1);
                player2.startAnimation(anim2);
                Ranking[0] = a;
                Ranking[1] = b;
                if(find_max(Ranking, 2)==b){
                    Result = "2번 꼴찌!";
                }
                else{
                    Result = "1번 꼴찌!";
                }
                break;
            case 3:
                player1.setImageResource(R.drawable.plane);
                player2.setImageResource(R.drawable.plane);
                player3.setImageResource(R.drawable.plane);
                player4.setImageResource(0);
                textplayer1.setText("1번");
                textplayer2.setText("2번");
                textplayer3.setText("3번");
                textplayer4.setText("");

                anim1.setDuration(a);
                anim2.setDuration(b);
                anim3.setDuration(c);
                player1.startAnimation(anim1);
                player2.startAnimation(anim2);
                player3.startAnimation(anim3);
                Ranking[0] = a;
                Ranking[1] = b;
                Ranking[2] = c;
                if(find_max(Ranking, 3)==c){
                    Result = "3번 꼴찌!";
                }
                else if (find_max(Ranking, 3)==b){
                    Result = "2번 꼴찌!";
                }
                else if (find_max(Ranking, 3)==a){
                    Result = "1번 꼴찌!";
                }
                break;
            case 4:
                player1.setImageResource(R.drawable.plane);
                player2.setImageResource(R.drawable.plane);
                player3.setImageResource(R.drawable.plane);
                player4.setImageResource(R.drawable.plane);
                textplayer1.setText("1번");
                textplayer2.setText("2번");
                textplayer3.setText("3번");
                textplayer4.setText("4번");
                anim1.setDuration(a);
                anim2.setDuration(b);
                anim3.setDuration(c);
                anim4.setDuration(d);
                player1.startAnimation(anim1);
                player2.startAnimation(anim2);
                player3.startAnimation(anim3);
                player4.startAnimation(anim4);
                Ranking[0] = a;
                Ranking[1] = b;
                Ranking[2] = c;
                Ranking[3] = d;
                if(find_max(Ranking, 4)==c){
                    Result = "3번 꼴찌!";
                }
                else if (find_max(Ranking, 4)==b){
                    Result = "2번 꼴찌!";
                }
                else if (find_max(Ranking, 4)==a){
                    Result = "1번 꼴찌!";
                }
                else if (find_max(Ranking, 4)==d){
                    Result = "4번 꼴찌!";
                }
                break;
        }
    }
    public void checkResult(View v){
        if(v.getId() == checkbtn.getId()) {
            if (Result == "") {
                Toast.makeText(this, "게임을 진행해주세요", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, Result, Toast.LENGTH_SHORT).show();
            }
        }
    }
    public int find_max(int[]arr, int n){
        int max = arr[0];
        for(int i = 0; i<n; i++){
            if(max<arr[i]){
                max = arr[i];
            }
        }
        return max;
    }
}
