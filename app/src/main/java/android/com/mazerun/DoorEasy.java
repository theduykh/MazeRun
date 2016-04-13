package android.com.mazerun;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DoorEasy extends MainActivity {
    public List<List<Integer>> wayAll = Common.wayOfDoorEasy;
    public Integer currentDoor = 1;
    public List<Integer> ways = new ArrayList<>();
    public List<Integer> images = new ArrayList<>();
    public ImageView imageView;
    public ProgressBar mProgressBar;
    public int i = 0;
    private MediaPlayer mpintro;
    public CountDownTimer mCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_door_easy);
        mpintro = MediaPlayer.create(this, R.raw.musicbackground);
        mpintro.setLooping(true);
        mpintro.start();
        Intent intent = getIntent();
        imageView = (ImageView) findViewById(R.id.imageView);
        addImage(imageView);
        refresh(imageView);
        countDown();


    }
    public void end (int re){
        Intent intent = new Intent(this, Goal.class);
        mpintro.stop();
        if (re == 1) {
            intent.putExtra("re", "1");
        } else if (re == 0){
            intent.putExtra("re", "0");
        }
        mpintro.stop();
        mCountDownTimer.cancel();
        startActivity(intent);
    }

    public void  countDown(){
         mProgressBar=(ProgressBar)findViewById(R.id.progressBar);
        mProgressBar.setProgress(i);
        mCountDownTimer= new CountDownTimer(100000,1000) {


            @Override
            public void onTick(long millisUntilFinished) {
                i++;
                mProgressBar.setProgress(i);

            }
            @Override
            public void onFinish() {
                i=100;
                mProgressBar.setProgress(i);
                end(0);
            }
        };
        mCountDownTimer.start();
    }

    public void refresh (View view){
        if (currentDoor == 9){
            end(1);
            return;
        }
        setImages(currentDoor);
        getWays(imageView);

    }
    public void getWays(View view){
        ways = wayAll.get(currentDoor);
    }

    public void setImages(int currentDoor){
        imageView.setImageResource(images.get(currentDoor));
    }
    public void addImage(View view){
        images.add(R.drawable.a1);
        images.add(R.drawable.a1);
        images.add(R.drawable.b1);
        images.add(R.drawable.c1);
        images.add(R.drawable.d1);
        images.add(R.drawable.e1);
        images.add(R.drawable.f1);
        images.add(R.drawable.g1);
        images.add(R.drawable.h1);
    }

    public void clickOne(View view){
        Random r = new Random();
        Button btn1 = (Button) findViewById(R.id.aBtn1);
        if (ways.get(1) == currentDoor +1){
            currentDoor++;
        }   else {
            currentDoor -= (r.nextInt(currentDoor-1) + 1);
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
        }
        refresh(imageView);
    }
    public void clickTwo(View view){
        Random r = new Random();
        if (ways.get(2) == currentDoor +1){
            currentDoor++;
        }   else {
            currentDoor -= (r.nextInt(currentDoor-1) + 1);
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
        }
        refresh(imageView);
    }
    public void clickThree(View   view){
        Random r = new Random();
        if (ways.get(3) == currentDoor +1){
            currentDoor++;
        }   else {
            currentDoor -= (r.nextInt(currentDoor-1) + 1);
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
        }
        refresh(imageView);
    }
    public void clickFour(View   view){
        Random r = new Random();
        if (ways.get(4) == currentDoor +1){
            currentDoor++;
        }   else {
            currentDoor -= (r.nextInt(currentDoor-1) + 1);
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
        }
        refresh(imageView);
    }
    public void back(View view){
        mCountDownTimer.cancel();
        mpintro.stop();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed(){
        mCountDownTimer.cancel();
        mpintro.stop();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
