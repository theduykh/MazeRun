package android.com.mazerun;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class DoorA extends Activity {
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_door_a);
        Intent intent = getIntent();
        final Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        linearLayout = (LinearLayout) findViewById(R.id.tap);
        linearLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    linearLayout.setVisibility(View.INVISIBLE);
                    //*****lam cho device rung lien tuc o day
                    vibrator.vibrate(new long[] {100, 50, 500}, 0);
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    linearLayout.setVisibility(View.VISIBLE);
                    vibrator.cancel();
                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void vibra(){
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(100);
    }
}
