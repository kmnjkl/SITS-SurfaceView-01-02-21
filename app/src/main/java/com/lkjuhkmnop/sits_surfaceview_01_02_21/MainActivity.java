package com.lkjuhkmnop.sits_surfaceview_01_02_21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import io.github.controlwear.virtual.joystick.android.JoystickView;

//implements JoystickView.OnMoveListener
public class MainActivity extends AppCompatActivity {
    private DrawView drawView;
    private TextView textView;
    private TextView msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.drawView = findViewById(R.id.myview);
        this.textView = findViewById(R.id.textview);
        this.msg = findViewById(R.id.msg);

        Content.init(this);

        JoystickView joystick = (JoystickView) findViewById(R.id.joystick);
        joystick.setOnMoveListener(new JoystickView.OnMoveListener() {
            @Override
            public void onMove(int angle, int strength) {
                drawView.setMotion((float)(angle*Math.PI/180), strength);
                if (strength != 0) {
                    textView.setText(getText(R.string.winnie_moving));
                } else {
                    textView.setText(getText(R.string.winnie_stand));
                }
            }
        });
    }

    public void message(String text) {
        this.msg.setText(text);
    }
}