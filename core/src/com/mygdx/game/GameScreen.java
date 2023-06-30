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
    Bullet bullet;

    //private boolean isCollision = false;
    public List<Bullet> bullets = new ArrayList<>();

    public GameScreen(MyGdxGame game) {
        this.game = game;
        shapeRenderer = new ShapeRenderer();
        drawShape = new DrawShape(shapeRenderer, game);
        player = new Player(new Rectangle(), drawShape);
        enemy = new Enemy(new Rectangle(), drawShape);
        bullet = new Bullet(drawShape, player.pX+20, player.pY+20, player);
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

        player.drawShape.drawRect(new Rectangle(player.bodyReact.x, player.bodyReact.y,50, 20), player.color);
        player.update(delta);

        enemy.update(delta);

        for (Bullet bullet : bullets) {
            bullet.update(delta);
            if (bullet.getBounds().overlaps(enemy.getBounds())) //Phương thức overlaps() chỉ trả về giá trị boolean (true hoặc false)
            {
                enemy.spawnEnemy();
                bullets.remove(bullet);
            }
        }


//        if (bullet.getBounds().overlaps(enemy.getBounds())) {
//            isCollision = true;
//        }
//        enemy.update(delta);
//        if (isCollision) {
//            enemy.spawnEnemy();
//            isCollision = false;
//        }
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
