package com.mygdx.game.DrawShape;

import static com.badlogic.gdx.math.MathUtils.random;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.GameScreen;
import com.mygdx.game.MyGdxGame;

public class DrawShape
{
    ShapeRenderer shapeRenderer;
    MyGdxGame game;
    private boolean isEnemyVisible; // Add this variable


    public DrawShape(ShapeRenderer shapeRenderer, MyGdxGame game) {
        this.shapeRenderer = shapeRenderer;
        isEnemyVisible = true; // Initialize isEnemyVisible to true
    }



    public void drawCar(float x, float y, int width, int height)
    {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.rect(x, y, width, height);
        shapeRenderer.end();
    }

    public void drawBullet(float x, float y, float radius)
    {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.YELLOW);
        shapeRenderer.circle(x, y, radius);
        shapeRenderer.end();
    }

    public void drawEnemy(float x, float y, int width, int height)
    {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.PURPLE);
        shapeRenderer.rect(x, y, width, height);
        shapeRenderer.end();
    }

    public void drawBulletEnemy(float x, float y, float radius)
    {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.PINK);
        shapeRenderer.circle(x, y, radius);
        shapeRenderer.end();
    }

    public void clearEnemy() {
        isEnemyVisible = false;
        //drawEnemy(randomX(), 400, 40, 15);
    }

    public boolean isEnemyVisible() {
        return isEnemyVisible;
    }


    public int randomX()
    {
        int randomNumber = random.nextInt(600 + 1 - 50) + 50;
        return randomNumber;
    }

}
