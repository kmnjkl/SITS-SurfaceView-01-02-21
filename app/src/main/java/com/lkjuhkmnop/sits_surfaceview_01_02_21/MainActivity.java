package com.lkjuhkmnop.sits_surfaceview_01_02_21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import io.github.controlwear.virtual.joystick.android.JoystickView;

public class MainActivity extends AppCompatActivity implements JoystickView.OnMoveListener {
    private DrawView dw;
    private TextView mylog;
    public int moveAngle=0;
    public int moveStrength=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.dw = findViewById(R.id.myview);
        this.mylog = findViewById(R.id.mylog);

        JoystickView joystick = (JoystickView) findViewById(R.id.joystick);
//        joystick.setOnMoveListener(new JoystickView.OnMoveListener() {
//            @Override
//            public void onMove(int angle, int strength) {
////                this.moveAngle = angle;
////                this.moveStrength = strength;
//                mylog.setText(angle + "\t" + strength);
//            }
//        });
        joystick.setOnMoveListener(this);
    }

    @Override
    public void onMove(int angle, int strength) {
        this.moveAngle = (int) (angle*Math.PI/180);
        this.moveStrength = strength;
        mylog.setText(angle + "\t" + strength);
    }
}