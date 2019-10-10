package com.mygdx.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.sprites.supman;

public class PlayState extends state {
    private supman Supman;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        Supman = new supman(50,300);
        cam.setToOrtho(false, MyGdxGame.WIDTH/2, MyGdxGame.HEIGHT/2);
    }

    @Override
    protected void handleInput() {

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
        sb.draw(Supman.getSupman(), Supman.getPosition().x, Supman.getPosition().y);
        sb.end();

    }

    @Override
    public void dispose() {

    }
}
