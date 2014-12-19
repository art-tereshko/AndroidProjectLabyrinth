package com.artem_tereshko.androidproject;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Pour que ce soit sur toute ala tablette
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_menu);


    }

    public void start_button_clicked(View v){
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("level", 1);
        startActivity(intent);
    }
    public void  exit_button_clicked(View v){
        moveTaskToBack(true);
    }


    public void button_levels_clicked(View view) {
        Intent intent = new Intent(this, LevelsActivity.class);
        startActivity(intent);
    }
}
