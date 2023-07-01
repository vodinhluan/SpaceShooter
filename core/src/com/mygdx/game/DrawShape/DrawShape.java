package com.mygdx.game.DrawShape;

import static com.badlogic.gdx.math.MathUtils.random;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.GameScreen;
import com.mygdx.game.MyGdxGame;

import org.w3c.dom.Text;

import java.awt.Font;

public class DrawShape
{
    ShapeRenderer shapeRenderer;
    SpriteBatch batch;
    BitmapFont font;


    public DrawShape(ShapeRenderer shapeRenderer, MyGdxGame game) {
        this.shapeRenderer = shapeRenderer;
        this.batch = new SpriteBatch();
        this.font = new BitmapFont();
    }

    public void drawRect(Rectangle rectangle, Color color)
    {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(color);
        shapeRenderer.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        shapeRenderer.end();
    }

    public void drawText(Rectangle rect, String text)
    {
        batch.begin();
        font.draw(batch, text, rect.x, rect.y + rect.height);
        batch.end();
    }

    public int randomX()
    {
        int randomNumber = random.nextInt(600 + 1 - 50) + 50;
        return randomNumber;
    }

}
