package com.mygdx.game.DrawShape;

import static com.badlogic.gdx.math.MathUtils.random;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.GameScreen;
import com.mygdx.game.MyGdxGame;

public class DrawShape
{
    ShapeRenderer shapeRenderer;

    public DrawShape(ShapeRenderer shapeRenderer, MyGdxGame game) {
        this.shapeRenderer = shapeRenderer;
    }

    public void drawRect(Rectangle rectangle, Color color)
    {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(color);
        shapeRenderer.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        shapeRenderer.end();
    }

    public int randomX()
    {
        int randomNumber = random.nextInt(600 + 1 - 50) + 50;
        return randomNumber;
    }

}
