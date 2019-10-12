package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class obstacle {
    public static final int KP_WIDTH = 130;
    private static final int FLUCTUATION = 160;
    private static final int KP_GAP = 150;
    private static final int LOWEST_OPENING = 120;
    private Texture top, bottom;
    private Vector2 postop, posbottom;
    private Rectangle boundsTop, boundsBot;
    private Random rand;


    public obstacle(float x){
        top = new Texture("topkp1.png");
        bottom = new Texture("bottomkp1.png");
        rand = new Random();


        postop = new Vector2(x, rand.nextInt(FLUCTUATION) + KP_GAP + LOWEST_OPENING);
        posbottom = new Vector2(x, postop.y - KP_GAP - bottom.getHeight());

        boundsTop = new Rectangle(postop.x, postop.y, top.getWidth()-100, top.getHeight()-100);
        boundsBot = new Rectangle(posbottom.x, posbottom.y, bottom.getWidth()-100, bottom.getHeight()-100);
    }

    public Texture getTop() {
        return top;
    }

    public Texture getBottom() {
        return bottom;
    }

    public Vector2 getPostop() {
        return postop;
    }

    public Vector2 getPosbottom() {
        return posbottom;
    }

    public void reposition(float x){
        postop.set(x,rand.nextInt(FLUCTUATION) + KP_GAP + LOWEST_OPENING);
        posbottom.set(x, postop.y - KP_GAP - bottom.getHeight());

        boundsTop.setPosition(postop.x, postop.y);
        boundsBot.setPosition(posbottom.x, posbottom.y);
    }

    public boolean collides(Rectangle player){
        return player.overlaps(boundsTop) || player.overlaps(boundsBot);
    }
}
