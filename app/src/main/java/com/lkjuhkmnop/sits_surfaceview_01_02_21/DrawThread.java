package com.lkjuhkmnop.sits_surfaceview_01_02_21;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;

import io.github.controlwear.virtual.joystick.android.JoystickView;

public class DrawThread extends Thread {

    private SurfaceHolder surfaceHolder;
    private MainActivity context;

    public final double speed = 0.3;

    Paint p = new Paint();
    Paint backgroundPaint = new Paint();
    private volatile boolean running = true;    //флаг для остановки потока

    public DrawThread(Context context, SurfaceHolder surfaceHolder) {
        this.context = (MainActivity) context;
        this.surfaceHolder = surfaceHolder;
        p.setColor(Color.RED);
        backgroundPaint.setColor(Color.WHITE);
        p.setStyle(Paint.Style.FILL);
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
                    canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), backgroundPaint);
                    Content.sun.x += context.moveStrength*Math.cos(context.moveAngle)*speed;
                    Content.sun.y -= context.moveStrength*Math.sin(context.moveAngle)*speed;
                    canvas.drawCircle(Content.sun.x,Content.sun.y,Content.sun.r,p);
                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
}