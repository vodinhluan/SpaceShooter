package com.mygdx.game.DrawShape;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;

public class Enemy extends GameEntity {
    public float pX = 250;
    public float pY = 350;

    public Enemy(Rectangle bodyReact, DrawShape drawShape) {
        super(bodyReact, drawShape);
    }

    @Override
    public void update(float deltaTime) {

        super.update(deltaTime);
        bodyReact.x = pX;
        bodyReact.y = pY;
    }

    public void spawnEnemy() {
        System.out.println("HELLO BROOOOOO");
        bodyReact.x = drawShape.randomX();
        bodyReact.y = 350;
    }
}
