package com.lkjuhkmnop.sits_surfaceview_01_02_21;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Honey implements Drawable {
    private float ox, oy;
    public static final float HONEY_SIZE = 35;
    private Paint outPaint = new Paint();
    private Paint inPaint = new Paint();

    public Honey(float ox, float oy) {
        this.ox = ox;
        this.oy = oy;

        outPaint.setColor(Color.parseColor("#8C3600"));
        outPaint.setStyle(Paint.Style.FILL);

        inPaint.setColor(Color.parseColor("#FFC645"));
        inPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRect(ox - HONEY_SIZE, oy - HONEY_SIZE, ox + HONEY_SIZE, oy + HONEY_SIZE, outPaint);
        canvas.drawOval(ox - HONEY_SIZE, oy - HONEY_SIZE - HONEY_SIZE/4, ox + HONEY_SIZE, oy - HONEY_SIZE + HONEY_SIZE/4, inPaint);
    }

    @Override
    public void moveVector(float vx, float vy) {
        this.ox += vx;
        this.oy += vy;
    }

    public float getOx() {
        return ox;
    }

    public float getOy() {
        return oy;
    }
}
