package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.DrawShape.Bullet;
import com.mygdx.game.DrawShape.DrawShape;
import com.mygdx.game.DrawShape.Enemy;
import com.mygdx.game.DrawShape.Player;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class GameScreen extends ScreenAdapter {
    MyGdxGame game;
    ShapeRenderer shapeRenderer;
    DrawShape drawShape;
    Player player;
    Enemy enemy;

    public List<Bullet> bullets = new ArrayList<>();

    public GameScreen(MyGdxGame game) {
        this.game = game;
        shapeRenderer = new ShapeRenderer();
        drawShape = new DrawShape(shapeRenderer, game);

        player = new Player(new Rectangle(250, 250, 25,  50), drawShape, new Runnable() {
            @Override
            public void run() {
                bullets.add(new Bullet(drawShape, player.pX, player.pY+20));
            }
        });

        enemy = new Enemy(new Rectangle(250, 350, 50,  25), drawShape);
        bullets = new ArrayList<>();
    }

    @Override
    public void show() {
        player.setInput();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        enemy.update(delta);
        player.update(delta);

        List<Bullet> destroyThisBullets = new ArrayList<>();

        for (Bullet bullet : bullets) {
            bullet.update(delta);

            if (bullet.getBounds().overlaps(enemy.getBounds()))
            {
                enemy.bodyReact.x = drawShape.randomX();
                destroyThisBullets.add(bullet);
            }
        }

        bullets.removeAll(destroyThisBullets);
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
