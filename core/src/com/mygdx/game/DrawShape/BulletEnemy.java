package com.mygdx.game.DrawShape;

import com.badlogic.gdx.math.Rectangle;

public class BulletEnemy extends GameEntity {
    Enemy enemy;
    public BulletEnemy(Rectangle bodyReact, DrawShape drawShape) {
        super(bodyReact, drawShape);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        bodyReact.y += 100 * deltaTime;
    }


    public void remove() {
//        enemy.bullets.remove(this);
    }

}
