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
    public Player(Rectangle bodyReact, DrawShape drawShape) {
        super(bodyReact, drawShape);
        color = Color.ORANGE;
        setInput();
    }

    private boolean moveLeft;
    private boolean moveRight;
    private boolean moveUp;
    private boolean moveDown;

    public float pX = 280;
    public float pY = 120;

    float playerSpeed = 100;

    public List<Bullet> bullets = new ArrayList<>();

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

        // In ra thông tin debug
        System.out.println("moveLeft: " + moveLeft);
        System.out.println("moveRight: " + moveRight);
        System.out.println("moveUp: " + moveUp);
        System.out.println("moveDown: " + moveDown);

        for(Bullet bullet : bullets)
        {
            bullet.update(deltaTime);
        }

        // Duyệt các phần tử từ đầu đến cuối của một collection.
        //  Cho phép xóa phần tử khi lặp một collection.
        Iterator<Bullet> iter = bullets.iterator();
        while (iter.hasNext()) { // trả về true nếu iterator còn phần tử kế tiếp phần tử đang duyệt
            Bullet bullet = iter.next(); // trả về phần tử hiện tại và di chuyển con trỏ trỏ tới phần tử tiếp theo.
            bullet.update(deltaTime);

            // Xóa bullet nếu ra khỏi màn hình
            if (bullet.bodyReact.y > 500) {
                iter.remove();
            }
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
                    bullets.add(new Bullet(drawShape, pX, pY, Player.this));
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
}
