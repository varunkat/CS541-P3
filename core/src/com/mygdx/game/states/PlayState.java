package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.sprites.obstacle;
import com.mygdx.game.sprites.supman;

public class PlayState extends state {
    private static final int KP_SPACING = 125;
    private static final int KP_COUNT = 4;

    private supman Supman;
    private Texture bg;
    //private obstacle obs;

    private Array<obstacle> kps;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        Supman = new supman(50,300);
        cam.setToOrtho(false, MyGdxGame.WIDTH/2, MyGdxGame.HEIGHT/2);
        bg = new Texture("backg2.png");
       // obs = new obstacle(100);

        kps = new Array<obstacle>();

        for(int i = 1; i <= KP_COUNT; i++){
            kps.add(new obstacle(i*(KP_SPACING + obstacle.KP_WIDTH)));
        }
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
        cam.position.x = supman.getPosition().x + 80;

        for(obstacle obs : kps){
            if(cam.position.x - (cam.viewportWidth / 2) > obs.getPostop().x + obs.getTop().getWidth()){
                obs.reposition(obs.getPostop().x + ((obstacle.KP_WIDTH + KP_SPACING) * KP_COUNT));
            }
            if(obs.collides(Supman.getBounds()))
                gsm.set(new PlayState(gsm));
        }

        cam.update();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, cam.position.x - (cam.viewportWidth/2), 0);
        sb.draw(Supman.getSupman(), Supman.getPosition().x, Supman.getPosition().y);
      for(obstacle obs : kps) {
          sb.draw(obs.getTop(), obs.getPostop().x, obs.getPostop().y);
          sb.draw(obs.getBottom(), obs.getPosbottom().x, obs.getPosbottom().y);
      }
        sb.end();

    }

    @Override
    public void dispose() {

    }
}
