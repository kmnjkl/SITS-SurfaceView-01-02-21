package com.lkjuhkmnop.sits_surfaceview_01_02_21;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Winnie implements Drawable{
    private float ox, oy;
    public int wSize = 100;
    private int honeyIncrease = 13;
    private Paint bodyPaint = new Paint();
    private Paint eyePaint = new Paint();
    private int maxFlag = 2;

    public Winnie(float wx, float wy) {
        this.ox = wx;
        this.oy = wy;

        bodyPaint.setColor(Color.rgb(110, 87, 63));
        bodyPaint.setStyle(Paint.Style.FILL);

        eyePaint.setColor(Color.YELLOW);
        eyePaint.setStyle(Paint.Style.FILL);
    }

    public void moveVector(float tx, float ty) {
        this.ox += tx;
        this.oy -= ty;
    }

    public void draw(Canvas canvas) {
//        Eat honey
        this.eatHoney(canvas);
        if ((canvas.getWidth() - (wSize + 4*honeyIncrease)*1.5 - Honey.HONEY_SIZE - ((wSize + 4*honeyIncrease)*1.5 + Honey.HONEY_SIZE)) < 0) {
            Content.message("Oh..! Winnie is too big! Stop eating now!");
            maxFlag--;
        }
        if (ox < 0 + wSize) {
            ox = 0 + wSize;
        }
        if (oy < 0 + wSize) {
            oy = 0 + wSize;
        }
        if (ox > canvas.getWidth() - wSize) {
            ox = canvas.getWidth() - wSize;
        }
        if (oy > canvas.getHeight() - wSize) {
            oy = canvas.getHeight() - wSize;
        }
//        Body
        float bx = ox, by = oy, br = wSize;
        canvas.drawCircle(bx, by, br, bodyPaint);
//        Left "ear"
        float elx = (float) (ox - (Math.sqrt(2) * wSize / 2));
        float ely = (float) (oy - (Math.sqrt(2) * wSize / 2));
        float elr = wSize /2;
        canvas.drawCircle(elx, ely, elr, bodyPaint);
//        Right ear
        float erx = (float) (ox + (Math.sqrt(2) * wSize / 2));
        float ery = (float) (oy - (Math.sqrt(2) * wSize / 2));
        float err = wSize /2;
        canvas.drawCircle(erx, ery, err, bodyPaint);
//        Left eye
        float ylx = (float) (ox - (Math.sqrt(2) * wSize / 2)/2);
        float yly = (float) (oy - (Math.sqrt(2) * wSize / 2)/2);
        float ylr = wSize /5;
        canvas.drawCircle(ylx, yly, ylr, eyePaint);
//        Right eye
        float yrx = (float) (ox + (Math.sqrt(2) * wSize / 2)/2);
        float yry = (float) (oy - (Math.sqrt(2) * wSize / 2)/2);
        float yrr = wSize /5;
        canvas.drawCircle(yrx, yry, yrr, eyePaint);
    }

    private void eatHoney(Canvas canvas) {
        for (Honey h: Content.getHoneys()) {
            float hx = h.getOx(), hy = h.getOy();
            if ((hx - ox)*(hx - ox) + (hy - oy)*(hy - oy) < wSize * wSize) {
                Content.delHoney(h);
                if (maxFlag <= 0) {
                    Content.message("");
                    wSize = 100;
                    maxFlag = 2;
                } else {
                    wSize += honeyIncrease;
                }
                Content.generateHoney(canvas);
            }
        }
    }
}
