package com.lkjuhkmnop.sits_surfaceview_01_02_21;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class DrawThread extends Thread {
    public float motionAngle;
    public float motionStrength;

    private SurfaceHolder surfaceHolder;
    private MainActivity context;

    public final double SPEED = 0.2;

    Paint backgroundPaint = new Paint();

    private volatile boolean running = true;    //флаг для остановки потока

    public DrawThread(Context context, SurfaceHolder surfaceHolder) {
        this.context = (MainActivity) context;
        this.surfaceHolder = surfaceHolder;
        backgroundPaint.setColor(Color.GREEN);
    }

    public void requestStop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            Canvas canvas = surfaceHolder.lockCanvas();
            if (canvas != null) {
                try {
//                    "Draw" background
                    canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), backgroundPaint);
//                    Move Winnie-the-Pooh
                    float tx = (float)(motionStrength * Math.cos(motionAngle) * SPEED);
                    float ty = (float)(motionStrength * Math.sin(motionAngle) * SPEED);
                    Content.winnie.moveVector(tx, ty);
                    Content.drawAll(canvas);
                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }

    public void setMotion(float angle, float strength) {
        this.motionAngle = angle;
        this.motionStrength = strength;
    }
}