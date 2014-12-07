package com.artem_tereshko.androidproject;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


public class LevelsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.activity_levels);
    }


    public void button_level1_clicked(View view) {

        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("level", 1);
        startActivity(intent);
    }

    public void button_level2_clicked(View view) {

        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("level", 2);
        startActivity(intent);
    }

    public void button_level3_clicked(View view) {

        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("level", 3);
        startActivity(intent);
    }
}
