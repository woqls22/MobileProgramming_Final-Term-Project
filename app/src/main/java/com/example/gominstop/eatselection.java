package com.example.gominstop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;

import android.os.Bundle;
import android.os.Environment;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.io.*;

public class eatselection extends AppCompatActivity {
    private boolean [] booleanlist;
    private boolean korea, japan, china, any, west, favo;
    private ArrayList<String> foodlist = new ArrayList<String>();
    private TextView mtext;
    private Random rand = new Random();
    private ImageView foodimg;
    private ArrayList<String> korean_list = new ArrayList<>();
    private ArrayList<String> japan_list = new ArrayList<>();
    private ArrayList<String> china_list = new ArrayList<>();
    private ArrayList<String> western_list = new ArrayList<>();
    private ArrayList<String> Favorite_list = new ArrayList<>();
    private String recommend_menu="-1";
    private int flag = 0;
    private TextView manal;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_eatselection);
        ready();
        /*
        * File Read 해오기
        * */
        manal = (TextView) findViewById(R.id.anal);
        booleanlist = getIntent().getBooleanArrayExtra("option");
        mtext = (TextView)findViewById(R.id.booltest);
        foodimg = (ImageView)findViewById(R.id.imageView1); // 푸드 이미지 랜덤 선택
        set_Favorite(); // Data를 불러와서 Favorite List에 저장함.
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("korean_list", korean_list);
        outState.putStringArrayList("japan_list", japan_list);
        outState.putStringArrayList("china_list", china_list);
        outState.putStringArrayList("western_list", western_list);
    }

    public void getfood(View v){ // 버튼 클릭시 랜덤 메뉴 생성
        setFoodList(booleanlist);
        manal.setText("데이터 분석중 입니다.");
        int randnum = rand.nextInt(foodlist.size());
        String result = foodlist.get(randnum);
        mtext.setText("오늘은 "+ result+" 어때?");
        recommend_menu = result;
        set_foodimg(result);
        manal.setText("분석결과");
    }
    public void setFoodList(boolean[] blst) {
        korea = booleanlist[0];
        china = booleanlist[1];
        japan = booleanlist[2];
        any = booleanlist[3];
        west = booleanlist[4];
        favo = booleanlist[5];
        if (any) {
            add_everyfood(foodlist); // set every foodlist
        } else {
            if (korea == true) {
                add_koreanfood(foodlist); // add korean foodlist
            }
            if (japan== true) {
                add_japanesefood(foodlist); // add japan foodlist
            }
            if (china== true) {
                add_chinesefood(foodlist); // add china foodlist
            }
            if (west== true) {
                add_westernfood(foodlist); // add western foodlist
            }
            if (favo== true) {
                add_favorite(foodlist); // add western foodlist
            }
        }
    } // 사용자가 체크한 항목에 따라 음식 foodlist PUSH_BACK
    public void add_koreanfood(ArrayList<String> foodlist){
        foodlist.addAll(korean_list);
    }
    public void add_japanesefood(ArrayList<String> foodlist){
        foodlist.addAll(japan_list);
    }
    public void add_chinesefood(ArrayList<String> foodlist){
        foodlist.addAll(china_list);
    }
    public void add_westernfood(ArrayList<String> foodlist){
        foodlist.addAll(western_list);
    }
    public void add_favorite(ArrayList<String> foodlist){
        foodlist.addAll(Favorite_list);
    }
    public void add_everyfood(ArrayList<String> foodlist){
        add_koreanfood(foodlist);
        add_japanesefood(foodlist);
        add_chinesefood(foodlist);
        add_westernfood(foodlist);
        add_favorite(foodlist);
    }
    // setting Food Image.
    public void set_foodimg(String Foodname){
        switch(Foodname){
            case "뼈해장국":
                foodimg.setImageResource(R.drawable.bbeohaejangkuk);
                break;
            case "분식칼국수":
                foodimg.setImageResource(R.drawable.bunsickalguksu);
                break;
            case "라면":
                foodimg.setImageResource(R.drawable.instantramen);
                break;
            case "고기칼국수":
                foodimg.setImageResource(R.drawable.gogikalguksu);
                break;
            case "김치찌개":
                foodimg.setImageResource(R.drawable.gimchisoup);
                break;
            case "삼겹살":
                foodimg.setImageResource(R.drawable.porkgogi);
                break;
            case "떡볶이":
                foodimg.setImageResource(R.drawable.toppoki);
                break;
            case "냉면":
                foodimg.setImageResource(R.drawable.naengmun);
                break;
            case "초밥":
                foodimg.setImageResource(R.drawable.shsui);
                break;
            case "일식라멘":
                foodimg.setImageResource(R.drawable.japaneseramen);
                break;
            case "짬뽕":
                foodimg.setImageResource(R.drawable.jjambbong);
                break;
            case "짜장":
                foodimg.setImageResource(R.drawable.jajang);
                break;
            case "해물파스타":
                foodimg.setImageResource(R.drawable.haemulpasta);
                break;
            case "크림파스타":
                foodimg.setImageResource(R.drawable.creampasta);
                break;
            case "햄버거":
                foodimg.setImageResource(R.drawable.hamburger);
                break;
            case "샌드위치":
                foodimg.setImageResource(R.drawable.sandwich);
                break;
            case "닭갈비":
                foodimg.setImageResource(R.drawable.dakgalbi);
                break;
            case "뚝배기불고기":
                foodimg.setImageResource(R.drawable.ddukbul);
                break;
            case "프렌치토스트":
                foodimg.setImageResource(R.drawable.frenchtoast);
                break;
            case "피자":
                foodimg.setImageResource(R.drawable.pizza);
                break;
        }
    }
    public boolean is_in(String name, ArrayList<String> FL){
        for(int i=0; i<FL.size();i++){
            if(FL.get(i) == name){return true;}
        }
        return false;
    }
    public void mEvaluate(View v){
        if(v.getId() == R.id.good){ // 좋아요 항목 반영. 해당 메뉴가 리스트에 추가포함되어 추후 선택될 확률 증가
            if(recommend_menu!="-1"){
                Add_File(recommend_menu);
                Toast.makeText(this,recommend_menu+" 메뉴가 좋아요 반영되었습니다.",Toast.LENGTH_SHORT).show();
                if(is_in(recommend_menu,korean_list)){
                    foodlist.add(recommend_menu);
                    korean_list.add(recommend_menu);}
                else if(is_in(recommend_menu,japan_list)){
                    foodlist.add(recommend_menu);
                    japan_list.add(recommend_menu);}
                else if(is_in(recommend_menu,china_list)){
                    foodlist.add(recommend_menu);
                    china_list.add(recommend_menu);}
                else if(is_in(recommend_menu,western_list)){
                    foodlist.add(recommend_menu);
                    western_list.add(recommend_menu);}
            }
            else{
                Toast.makeText(this," 메뉴선택을 위해 버튼을 눌러주세요.",Toast.LENGTH_SHORT).show();
            }
        }
        else if(v.getId() == R.id.bad) { // 싫어요 항목 반영 해당 메뉴가 포함된 리스트에서 해당항목을 삭제함. 상대적으로 노출횟수 줄어듦.
                if (recommend_menu != "-1") {
                    Delete_File(recommend_menu);
                    if (is_in(recommend_menu, korean_list)) {
                        foodlist.remove(recommend_menu);
                        korean_list.remove(recommend_menu);
                    } else if (is_in(recommend_menu, japan_list)) {
                        foodlist.remove(recommend_menu);
                        japan_list.remove(recommend_menu);
                    } else if (is_in(recommend_menu, china_list)) {
                        foodlist.remove(recommend_menu);
                        china_list.remove(recommend_menu);
                    } else if (is_in(recommend_menu, western_list)) {
                        foodlist.remove(recommend_menu);
                        western_list.remove(recommend_menu);
                    }
                    Toast.makeText(this, recommend_menu + " 메뉴가 싫어요 반영되었습니다.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this," 메뉴선택을 위해 버튼을 눌러주세요.",Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void ready(){ // 각 메뉴를 2번씩 추가
            korean_list.add("뼈해장국"); // 뼈해장국 bbeohaejangkuk
            korean_list.add("분식칼국수"); // 분식칼국수 bunsickalguksu
            korean_list.add("라면"); // 라면 instantramen
            korean_list.add("고기칼국수"); // 고기칼국수 gogikalguksu
            korean_list.add("김치찌개"); // 김치찌개 gimchisoup
            korean_list.add("삼겹살"); // 삼겹살 porkgogi
            korean_list.add("떡볶이"); // 떡볶이 toppoki
            korean_list.add("냉면"); // 냉면 naengmun
            korean_list.add("닭갈비"); // 냉면 dakgalbi
            korean_list.add("뚝배기불고기"); // 뚝배기 불고기 ddukbul
            japan_list.add("초밥"); // 스시 shsui
            japan_list.add("일식라멘");//일식라멘 japaneseramen
            china_list.add("짬뽕"); // 짬뽕 jjambbong
            china_list.add("짜장"); // 짜장 jajang
            western_list.add("해물파스타"); // 해물파스타 haemulpasta
            western_list.add("크림파스타"); // 크림파스타 creampasta
            western_list.add("햄버거"); // 햄버거 hamburger
            western_list.add("피자"); // 피자 pizza
            western_list.add("샌드위치"); // sandwich
            western_list.add("프렌치토스트"); // frenchtoast
            // <------------------------------------------------------>
            korean_list.add("뼈해장국"); // 뼈해장국 bbeohaejangkuk
            korean_list.add("분식칼국수"); // 분식칼국수 bunsickalguksu
            korean_list.add("라면"); // 라면 instantramen
            korean_list.add("고기칼국수"); // 고기칼국수 gogikalguksu
            korean_list.add("김치찌개"); // 김치찌개 gimchisoup
            korean_list.add("삼겹살"); // 삼겹살 porkgogi
            korean_list.add("떡볶이"); // 떡볶이 toppoki
            korean_list.add("냉면"); // 냉면 naengmun
            korean_list.add("닭갈비"); // 냉면 dakgalbi
            korean_list.add("뚝배기불고기"); // 뚝배기 불고기 ddukbul
            japan_list.add("초밥"); // 스시 shsui
            japan_list.add("일식라멘");//일식라멘 japaneseramen
            china_list.add("짬뽕"); // 짬뽕 jjambbong
            china_list.add("짜장"); // 짜장 jajang
            western_list.add("해물파스타"); // 해물파스타 haemulpasta
            western_list.add("크림파스타"); // 크림파스타 creampasta
            western_list.add("햄버거"); // 햄버거 hamburger
            western_list.add("피자"); // 피자 pizza
            western_list.add("샌드위치"); // sandwich
            western_list.add("프렌치토스트"); // frenchtoast
            flag = 1;
    }
    // File Write
    public void Add_File(String recommend_menu){
        String line;
        String Result ="";
// 파일 생성
        File saveFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/camdata"); // 저장 경로
// 폴더 생성
        if(!saveFile.exists()){ // 폴더 없을 경우
            saveFile.mkdir(); // 폴더 생성
        }
        try {
            BufferedWriter Writebuf = new BufferedWriter(new FileWriter(saveFile+"/Foodlist.txt", true));
            BufferedReader Readbuf = new BufferedReader(new FileReader(saveFile+"/Foodlist.txt"));
            Result = Result + ( "#"+recommend_menu); // 음식쓰기
            Writebuf.write(Result, 0, Result.length());
            Writebuf.flush();
            Readbuf.close();
            Writebuf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Delete_File(String recommend_menu){
        String line;
        String Result ="";
        int LenOfOrigin, AfterLen;
        String Temp="";
// 파일 생성
        File saveFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/camdata"); // 저장 경로
// 폴더 생성
        if(!saveFile.exists()){ // 폴더 없을 경우
            saveFile.mkdir(); // 폴더 생성
        }
        try {
            BufferedReader Readbuf = new BufferedReader(new FileReader(saveFile+"/Foodlist.txt"));
            while((line = Readbuf.readLine())!=null){
                Result = Result+line;
            }
            LenOfOrigin = Result.length();
            if(Result.indexOf(recommend_menu) == -1){return ;} // 선택한 메뉴가 Favorite Food List에 없는 경우 함수종료
            for(int i = 0; i<Result.length();i++) {
                Temp = Result.substring(i, i + recommend_menu.length());
                if (Temp.equals(recommend_menu)) {
                    Result = Result.substring(0, i - 1) + Result.substring(i + recommend_menu.length());
                    Log.d("result", Result);
                    break;
                }
            }
            BufferedWriter Writebuf = new BufferedWriter(new FileWriter(saveFile+"/Foodlist.txt"));
            Writebuf.write(Result,0,Result.length());
            Readbuf.close();
            Writebuf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void set_Favorite(){
        String line;
        String Temp = "";
        String Result ="";
        while(!Favorite_list.isEmpty()){
            Favorite_list.remove(0);
        }
// 파일 생성
        File saveFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/camdata"); // 저장 경로
// 폴더 생성
        if(!saveFile.exists()){ // 폴더 없을 경우
            saveFile.mkdir(); // 폴더 생성
        }
        try {
            BufferedReader Readbuf = new BufferedReader(new FileReader(saveFile+"/Foodlist.txt"));
            while((line = Readbuf.readLine())!=null){
                Result = Result+line;
            }
            for(int i = 0; i<Result.length();i++) {
                if(Result.charAt(i) == '#'){
                    for(int j = i+1; j<Result.length();j++){
                        if(Result.charAt(j) == '#'){
                            Temp = Result.substring(i+1,j);
                            Favorite_list.add(Temp);
                            break;
                        }
                        else if( j+1 == Result.length()){
                            Temp = Result.substring(i+1,j+1);
                            Favorite_list.add(Temp);
                            break;
                        }
                    }
                }
            }
            Readbuf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
