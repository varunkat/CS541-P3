package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.sprites.supman;

public class PlayState extends state {
    private supman Supman;
    private Texture bg;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        Supman = new supman(50,300);
        cam.setToOrtho(false, MyGdxGame.WIDTH/2, MyGdxGame.HEIGHT/2);
        bg = new Texture("backg2.png");
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched())
            Supman.Jump();

    }

    @Override
    public void update(float dt) {
        handleInput();
        Supman.update(dt);

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, cam.position.x - (cam.viewportWidth/2), 0);
        sb.draw(Supman.getSupman(), Supman.getPosition().x, Supman.getPosition().y);
        sb.end();

    }

    @Override
    public void dispose() {

    }
}
