package com.mygdx.game.DrawShape;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class Enemy extends GameEntity {

    public Enemy(Rectangle bodyReact, DrawShape drawShape) {
        super(bodyReact, drawShape);
        color = Color.PINK;
    }


    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
    }

    public void shoot()
    {

    }

    public void spawnEnemy() {
        bodyReact.x = drawShape.randomX();
        bodyReact.y = 430;
    }
}
