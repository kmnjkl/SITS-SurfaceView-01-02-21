package com.lkjuhkmnop.sits_surfaceview_01_02_21;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Winnie {
    private float wx, wy, wr=100;
    private Paint bodyPaint = new Paint();
    private Paint eyePaint = new Paint();

    public Winnie(float wx, float wy) {
        this.wx = wx;
        this.wy = wy;

        bodyPaint.setColor(Color.rgb(110, 87, 63));
        bodyPaint.setStyle(Paint.Style.FILL);

        eyePaint.setColor(Color.YELLOW);
        eyePaint.setStyle(Paint.Style.FILL);
    }

    public void moveVector(float tx, float ty) {
        this.wx += tx;
        this.wy -= ty;
    }

    public void drawWinnie(Canvas canvas) {
        if (wx < 0 + wr) {
            wx = 0 + wr;
        }
        if (wy < 0 + wr) {
            wy = 0 + wr;
        }
        if (wx > canvas.getWidth() - wr) {
            wx = canvas.getWidth() - wr;
        }
        if (wy > canvas.getHeight() - wr) {
            wy = canvas.getHeight() - wr;
        }
//        Body
        float bx = wx, by = wy, br = wr;
        canvas.drawCircle(bx, by, br, bodyPaint);
//        Left "ear"
        float elx = (float) (wx - (Math.sqrt(2) * wr / 2));
        float ely = (float) (wy - (Math.sqrt(2) * wr / 2));
        float elr = wr/2;
        canvas.drawCircle(elx, ely, elr, bodyPaint);
//        Right ear
        float erx = (float) (wx + (Math.sqrt(2) * wr / 2));
        float ery = (float) (wy - (Math.sqrt(2) * wr / 2));
        float err = wr/2;
        canvas.drawCircle(erx, ery, err, bodyPaint);
//        Left eye
        float ylx = (float) (wx - (Math.sqrt(2) * wr / 2)/2);
        float yly = (float) (wy - (Math.sqrt(2) * wr / 2)/2);
        float ylr = wr/5;
        canvas.drawCircle(ylx, yly, ylr, eyePaint);
//        Right eye
        float yrx = (float) (wx + (Math.sqrt(2) * wr / 2)/2);
        float yry = (float) (wy - (Math.sqrt(2) * wr / 2)/2);
        float yrr = wr/5;
        canvas.drawCircle(yrx, yry, yrr, eyePaint);
    }
}
