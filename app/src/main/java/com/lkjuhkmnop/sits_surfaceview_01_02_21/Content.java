package com.lkjuhkmnop.sits_surfaceview_01_02_21;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.Random;

public class Content {
    public static Winnie winnie;
    private static ArrayList<Honey> honeys = new ArrayList<Honey>();
    private static Random random = new Random();
    private static MainActivity mainActivity;

    public static void drawAll(Canvas canvas) {
        winnie.draw(canvas);
        for (Honey h: honeys) {
            h.draw(canvas);
        }
    }

    public static ArrayList<Honey> getHoneys() {
        return honeys;
    }

    public static void delHoney(Honey h) {
        honeys.remove(h);
    }

    public static void init(MainActivity ma) {
        mainActivity = ma;
        honeys.add(new Honey(500, 1000));
        winnie = new Winnie(500, 700);
    }

    public static void generateHoney(Canvas canvas) {
        float right = (float) (canvas.getWidth() - winnie.wSize*1.5 - Honey.HONEY_SIZE);
        float left = (float) (winnie.wSize*1.5 + Honey.HONEY_SIZE);
        float top = (float) (winnie.wSize*1.5 + Honey.HONEY_SIZE);
        float bottom = (float) (canvas.getHeight() - winnie.wSize*1.5 - Honey.HONEY_SIZE);
        float hx = left + random.nextInt((int)(right - left));
        float hy = top + random.nextInt((int)(bottom - top));
        honeys.add(new Honey(hx, hy));
    }

    public static void message(String text) {
        mainActivity.message(text);
    }
}
