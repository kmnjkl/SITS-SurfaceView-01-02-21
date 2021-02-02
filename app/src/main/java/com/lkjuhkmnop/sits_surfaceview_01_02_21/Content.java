package com.lkjuhkmnop.sits_surfaceview_01_02_21;

import android.graphics.Canvas;

public class Content {
    public static Winnie winnie = new Winnie(500, 700);

    public static void drawAll(Canvas canvas) {
        winnie.drawWinnie(canvas);
    }
}
