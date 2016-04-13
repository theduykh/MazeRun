package android.com.mazerun;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends Activity {
//    public List<Class> door = new ArrayList<>();
    public List<Integer> road = new ArrayList<>();

    ///////////////////////
    public List<Integer> doorNum = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        door.add(DoorA.class); //0
//        door.add(DoorA.class); //1
//        door.add(DoorB.class); //2
//        door.add(DoorC.class); //3
//        door.add(DoorD.class); //4
//        door.add(DoorE.class); //5
//        door.add(DoorF.class); //6
//        door.add(DoorG.class); //7
//        door.add(DoorH.class); //8
//        door.add(Goal.class);  //Goal
//        for (int i = 1; i <= 9; i++) {
//            Common.wayOfDoor.add(door);
//        }
        for (int i = 1; i <= 9; i++) {
            Common.wayOfDoorEasy.add(doorNum);
        }
    }

//    public void play(View view) {
//        createRoad();
//        for (int i = 1; i <= 8; i++) {
//            createTrap(i);
//        }
//        Intent intent = new Intent(this, DoorA.class);
//        startActivity(intent);
//    }

    public void playEasy(View view) {
        createRoad();
        for (int i = 1; i <= 8; i++) {
            createTrapEasy(i);
        }
        Intent intent = new Intent(this, DoorEasy.class);
        startActivity(intent);
    }

    public void createRoad() {
        Random r = new Random();
        road.add(0);
        for (int i = 1; i <= 8; i++) {
            road.add(r.nextInt(4) + 1);
        }
    }

//    public void createTrap(int n) {
//        Random r = new Random();
//        List<Class> ways = new ArrayList<>();
//        ways.add(DoorA.class);
//        for (int i = 1; i <= 4; i++) {
//            if (i == road.get(n)) {
//                ways.add(door.get(n + 1));
//            } else {
//                if (n == 1) {
//                    ways.add(door.get(2));
//                } else {
////                    ways.add(door.get(1));
//                    int ran = r.nextInt(n - 1) + 1;
//                    ways.add(door.get(ran));
//                }
//
//            }
//        }
//        Common.wayOfDoor.set(n, ways);
//    }

    public void createTrapEasy(int n) {
        Random r = new Random();
        List<Integer> ways = new ArrayList<>();
        ways.add(1);
        for (int i = 1; i <= 4; i++) {
            if (n == 1) {
                ways.add(2);
            } else {
                if (i == road.get(n)) {
                    ways.add(n+1);
                } else {

                    int ran = r.nextInt(n - 1) + 1;
                    ways.add(ran);
                }
            }
        }
        Common.wayOfDoorEasy.set(n, ways);
    }

    public void hd(View view) {
        String title = "Huong Dan";
        String content = "Chọn và ghi nhớ đường về đích";
        msgBox(title, content);
    }
    public void clickGiaiTri(View view){
        Intent intent = new Intent(this, DoorA.class);
        startActivity(intent);
    }
    public void msgBox(String str, String str2) {
        final AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        dlgAlert.setTitle(str);
        dlgAlert.setMessage(str2);
        dlgAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.dismiss();
            }
        });
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }
    @Override
    public void onBackPressed(){
        finish();
        System.exit(0);
    }
}
