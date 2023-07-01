package com.mygdx.game.DrawShape;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Player extends GameEntity {
    public Player(Rectangle bodyReact, DrawShape drawShape, Runnable onPlayerShootListener) {
        super(bodyReact, drawShape);
        color = Color.ORANGE;
        this.onPlayerShotsListener = onPlayerShootListener;
        setInput();

        pX = bodyReact.x;
        pY = bodyReact.y;
    }

    private boolean moveLeft;
    private boolean moveRight;
    private boolean moveUp;
    private boolean moveDown;

    public float pX;
    public float pY;

    float playerSpeed = 100;
    Runnable onPlayerShotsListener;

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        bodyReact.x = pX;
        bodyReact.y = pY;


        if (moveLeft) {
            pX = pX - playerSpeed * deltaTime;
        } else if (moveRight) {
            pX = pX + playerSpeed * deltaTime;
        } else if (moveUp) {
            pY = pY + playerSpeed * deltaTime;
        } else if (moveDown) {
            pY = pY - playerSpeed * deltaTime;
        }
    }


    public void setInput()
    {
        Gdx.input.setInputProcessor(new InputAdapter() {
            // Di chuyen
            @Override
            public boolean keyDown(int keyCode) {
                if (keyCode == Input.Keys.A) {
                    moveLeft = true;
                } else if (keyCode == Input.Keys.D) {
                    moveRight = true;
                } else if (keyCode == Input.Keys.W) {
                    moveUp = true;
                } else if (keyCode == Input.Keys.S) {
                    moveDown = true;
                } else if (keyCode == Input.Keys.SPACE) {
                    onPlayerShoots();
                }
                return true;
            }

            @Override
            public boolean keyUp(int keyCode) {
                if (keyCode == Input.Keys.A) {
                    moveLeft = false;
                } else if (keyCode == Input.Keys.D) {
                    moveRight = false;
                }
                else if (keyCode == Input.Keys.W) {
                    moveUp = false;
                } else if (keyCode == Input.Keys.S) {
                    moveDown = false;
                }
                return true;
            }
        });
    }

    private void onPlayerShoots() {
        onPlayerShotsListener.run();
    }
}
