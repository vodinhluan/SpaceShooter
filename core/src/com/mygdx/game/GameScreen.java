package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.DrawShape.DrawShape;
import com.mygdx.game.DrawShape.Player;


public class GameScreen extends ScreenAdapter {
    MyGdxGame game;
    ShapeRenderer shapeRenderer;
    DrawShape drawShape;
    Player player;

    public GameScreen(MyGdxGame game) {
        this.game = game;
        shapeRenderer = new ShapeRenderer();
        drawShape = new DrawShape(shapeRenderer, game);
        player = new Player(new Rectangle(), drawShape);
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
