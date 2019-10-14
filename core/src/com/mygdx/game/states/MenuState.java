package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

public class MenuState extends state {
    private Texture background;
    private Texture playbtn;
    public MenuState(GameStateManager gsm){
        super(gsm);
        background = new Texture("background.png");
        playbtn = new Texture("play.png");
    }
    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background,0,0, MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        sb.draw(playbtn, (MyGdxGame.WIDTH/2)-(playbtn.getWidth()/2), MyGdxGame.HEIGHT/2);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playbtn.dispose();
        System.out.println("Menu state disposed");

    }
}
