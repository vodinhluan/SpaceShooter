package com.mygdx.game.DrawShape;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;

public abstract class GameEntity {
    public Rectangle bodyReact;
    public DrawShape drawShape;
    public Color color = Color.RED;

    public boolean shouldRender = true;

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
        if(!shouldRender) return;

        drawShape.drawRect(bodyReact, color);
    }

    public Rectangle getBounds()
    {
        return bodyReact;
    }
}
