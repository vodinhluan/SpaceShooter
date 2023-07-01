package com.mygdx.game.DrawShape;

import com.badlogic.gdx.math.Rectangle;

public class Score extends GameEntity{
    public Score(Rectangle bodyReact, DrawShape drawShape) {
        super(bodyReact, drawShape);
    }


    @Override
    protected void render(float deltatime) {
        super.render(deltatime);
        drawShape.drawText(bodyReact, "SCORE: ");
    }
}
