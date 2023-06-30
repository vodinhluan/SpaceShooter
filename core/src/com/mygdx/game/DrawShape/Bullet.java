package com.mygdx.game.DrawShape;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;

public class Bullet extends GameEntity {
    Player player;

    public Bullet(DrawShape drawShape, float px, float py, Player player) {
        super(new Rectangle(px, py, 15, 15), drawShape);
        this.player = player;
        this.color = Color.PINK;
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        bodyReact.y += 300 * deltaTime;
    }

    public void remove() {
        player.bullets.remove(this);
    }
}
