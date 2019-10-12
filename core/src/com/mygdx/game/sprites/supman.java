package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class supman {
    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 100;
    private static Vector3 position;
    private Vector3 velocity;
    private Texture Supman;
    private Rectangle bounds;

    public supman(int x, int y){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        Supman = new Texture("supman1.png");
        bounds = new Rectangle(x, y, Supman.getWidth()-50, Supman.getHeight()-50);
    }

    public void update(float dt){
        if(position.y > 0)
            velocity.add(0,GRAVITY,0);
        velocity.scl(dt);
        position.add(MOVEMENT * dt, velocity.y,0);
        if(position.y < 0)
            position.y = 0;
        velocity.scl(1/dt);

        bounds.setPosition(position.x, position.y);
    }

    public static Vector3 getPosition() {
        return position;
    }

    public Texture getSupman() {
        return Supman;
    }

  public void Jump(){
        velocity.y = 250;
    }

    public Rectangle getBounds(){
        return bounds;
    }
}
