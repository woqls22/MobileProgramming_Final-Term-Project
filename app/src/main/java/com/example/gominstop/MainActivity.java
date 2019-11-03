package com.example.gominstop;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Intent intent = new Intent(this, FirstPage.class); // FirstPage Load on (Loading Page..)
        startActivity(intent);
        setContentView(R.layout.activity_main); // After FirstPage, Show out Main Page.
    }
    // <----- POP UP MENU ----->
    public void setting(View v){ //팝업메뉴 띄우기
        if(v.getId() == R.id.menubtn){
        PopupMenu popupMenu = new PopupMenu(this,v);
        this.getMenuInflater().inflate(R.menu.menu_main, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(listener);
        popupMenu.show();
        }
    }
    PopupMenu.OnMenuItemClickListener listener= new PopupMenu.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch( item.getItemId() ){//눌러진 MenuItem의 Item Id를 얻어와 식별
                case R.id.mannual:
                    Toast.makeText(MainActivity.this, "사용방법", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.notice:
                    Toast.makeText(MainActivity.this, "공지사항", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.feedback:
                    makeDialogue();
                    break;
            }
            return false;
        }
    };
    public void mOnClick(View v){
        switch(v.getId()){
            case R.id.meals:
                Intent intent_eat = new Intent(this, menuoption.class); // menuoption activity Load on
                startActivity(intent_eat);
                break;
            case R.id.cloth:
                Intent intent_cloth = new Intent(this, ClothActivity.class); // ClothActivity activity Load on
                startActivity(intent_cloth);
                break;
            case R.id.date:
                Intent intent_date = new Intent(this, datecourse.class); // datecourse activity Load on
                startActivity(intent_date);
                break;
            case R.id.play:
                Intent intent_hip = new Intent(this, Hipplace.class); // Hipplace activity Load on
                startActivity(intent_hip);
                break;
            case R.id.gamble:
                Intent gamble = new Intent(this, GambleActivity.class); // Gamble Activity Load on
                startActivity(gamble);
                break;
        }
    }
    public void makeDialogue(){
        builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.teacher);
        builder.setTitle("불편한점을 말해주세요");
        builder.setMessage("개발자 이메일 주소\n woqls226@gmail.com");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}