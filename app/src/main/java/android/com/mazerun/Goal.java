package android.com.mazerun;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class Goal extends MainActivity {
    private MediaPlayer soundWin;
    private MediaPlayer soundFail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);
        Intent intent = getIntent();
        String message = intent.getStringExtra("re");
        soundWin = MediaPlayer.create(this, R.raw.win);
        soundFail = MediaPlayer.create(this, R.raw.fail);
        if (message.equals("1")){
            soundWin.start();
            message = "Bạn đã đào thoát khỏi sào huyệt của AssMan";
        } else if (message.equals("0")){
            soundFail.start();
            message = "Bạn đã bị AssMan thông nát ass";
        }
        TextView messageView = (TextView) findViewById(R.id.textView);
        messageView.setText(message);
    }
    public void menu(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void replay(View view){

        this.playEasy(view);
    }
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
