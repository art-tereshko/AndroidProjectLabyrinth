package com.artem_tereshko.androidproject;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;


public class GameActivity extends Activity implements GameListener {

    GraphicsEngine graphicsEngine;

    int CurrenrLevel = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

        Intent intent = getIntent();
        CurrenrLevel = intent.getIntExtra("level", 1);

        SensorManager manager = (SensorManager) getBaseContext().getSystemService(Service.SENSOR_SERVICE);
        graphicsEngine = new GraphicsEngine(this, manager, windowManager.getDefaultDisplay().getRotation(), CurrenrLevel);
        graphicsEngine.SetGameListener(this);
        setContentView(graphicsEngine);


    }

    @Override
    protected void onPause() {
        super.onPause();
        graphicsEngine.Pause();

    }

    @Override
    protected void onStart() {
        super.onStart();
        graphicsEngine.Start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        graphicsEngine.Stop();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onGameWin() {

        Intent intent = new Intent(this, WinActivity.class);
        if (CurrenrLevel < 3)
            intent.putExtra("level", CurrenrLevel+1);
        else
            intent.putExtra("level", 1);

        startActivity(intent);

    }

    @Override
    public void onGameLose() {
        Intent intent = new Intent(this, LoseActivity.class);
        startActivity(intent);

    }
}
