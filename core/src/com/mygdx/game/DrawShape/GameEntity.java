package com.mygdx.game.DrawShape;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;

public abstract class GameEntity {
    public Rectangle bodyReact;
    public DrawShape drawShape;
    public Color color = Color.RED;

    public GameEntity(Rectangle bodyReact, DrawShape drawShape) {
        this.bodyReact = bodyReact;
        this.drawShape = drawShape;
    }

    public void update(float deltaTime)
    {
        render(deltaTime);
    }

    protected void render(float deltatime)
    {
        drawShape.drawRect(bodyReact, color);
    }

    public Rectangle getBounds()
    {
        return bodyReact;
    }
}
