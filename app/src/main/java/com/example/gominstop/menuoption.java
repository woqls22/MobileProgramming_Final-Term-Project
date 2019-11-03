package com.example.gominstop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class menuoption extends AppCompatActivity {
    boolean korean, chinese, anyt, japanese, western, favorite = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuoption);
        Button submit = (Button) findViewById(R.id.submit);
    }
    public void submitform(View v){
        if(anyt == true){
            if(korean || chinese || japanese || western || favorite){
                Toast.makeText(this.getApplicationContext(),"다땡겨가 체크되었으므로 모든 옵션체크로 간주됩니다.",Toast.LENGTH_LONG).show();
            }
        }
        if((korean==false)&&(chinese==false)&&(japanese==false)&&(western==false)&&(anyt==false)){
            anyt = true;
            Toast.makeText(this.getApplicationContext(),"체크된 옵션이 없습니다. 모든 옵션체크로 간주됩니다.",Toast.LENGTH_LONG).show();
        }
        boolean option[] = {korean, chinese, japanese, anyt, western, favorite};
        // Intent에 Data 저장.
        Intent intent = new Intent(this, eatselection.class);
        intent.putExtra("option",option);
        startActivity(intent); // 인텐트 실행.
    }
    public void  ischeck(View v){
        ToggleButton mkorean = (ToggleButton) findViewById(R.id.koreanfood);
        ToggleButton mchinese = (ToggleButton) findViewById(R.id.chinesefood);
        ToggleButton manything = (ToggleButton) findViewById(R.id.anything);
        ToggleButton mjapanese = (ToggleButton) findViewById(R.id.japanesefood);
        ToggleButton mwestern = (ToggleButton) findViewById(R.id.westernfood);
        ToggleButton mfavorite = (ToggleButton)findViewById(R.id.favorite);
        switch(v.getId()){
            case R.id.koreanfood:
                if(mkorean.isChecked()){
                    mkorean.setBackgroundColor(Color.rgb(100,160,215));
                    korean = true;
                }
                else{ mkorean.setBackgroundColor(Color.rgb(155,194,245));
                    korean  = false;
                }
                break;
            case R.id.chinesefood:
                if(mchinese.isChecked()){
                    mchinese.setBackgroundColor(Color.rgb(100,160,215));
                    chinese = true;
                }
                else{ mchinese.setBackgroundColor(Color.rgb(155,194,245));
                      chinese = false;
                }
                break;
            case R.id.anything:
                if(manything.isChecked()){
                    manything.setBackgroundColor(Color.rgb(100,160,215));
                    anyt = true;
                }
                else{ manything.setBackgroundColor(Color.rgb(155,194,245));
                    anyt = false;
                }
                break;
            case R.id.japanesefood:
                if(mjapanese.isChecked()){
                    mjapanese.setBackgroundColor(Color.rgb(100,160,215));
                    japanese = true;
                }
                else{ mjapanese.setBackgroundColor(Color.rgb(155,194,245));
                    japanese = false;
                }
                break;
            case R.id.westernfood:
                if(mwestern.isChecked()){
                    mwestern.setBackgroundColor(Color.rgb(100,160,215));
                    western = true;
                }
                else{ mwestern.setBackgroundColor(Color.rgb(155,194,245));
                    western = false;
                }
                break;
            case R.id.favorite:
                if(mfavorite.isChecked()){
                    mfavorite.setBackgroundColor(Color.rgb(100,160,215));
                    favorite = true;
                }
                else{ mfavorite.setBackgroundColor(Color.rgb(155,194,245));
                    favorite = false;
                }
                break;
        }
    }
}