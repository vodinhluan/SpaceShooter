package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.DrawShape.DrawShape;

import java.util.ArrayList;

public class GameScreen extends ScreenAdapter {
    MyGdxGame game;
    ShapeRenderer shapeRenderer;
    DrawShape drawShape;
    private boolean moveLeft;
    private boolean moveRight;
    private boolean moveUp;
    private boolean moveDown;
    private float bulletTimer;
    private float bulletInterval = 2;
    public boolean isEnemyVisible = true;

    public GameScreen(MyGdxGame game) {
        this.game = game;
        shapeRenderer = new ShapeRenderer();
        drawShape = new DrawShape(shapeRenderer, game);
        bulletTimer = 0;
    }

    @Override
    public void show() {
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
                    game.bullets.add(new Vector2(game.getPlayerX()+10, game.getPlayerY()+60));

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

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (moveLeft) {
            game.setPlayerX(game.getPlayerX() - game.getPlayerSpeed() * delta);
        } else if (moveRight) {
            game.setPlayerX(game.getPlayerX() + game.getPlayerSpeed() * delta);
        } else if (moveUp) {
            game.setPlayerY(game.getPlayerY() + game.getPlayerSpeed() * delta);
        } else if (moveDown) {
            game.setPlayerY(game.getPlayerY() - game.getPlayerSpeed() * delta);
        }

        drawShape.drawCar(game.getPlayerX(), game.getPlayerY(), 20, 50);
        // collision
        if (drawShape.isEnemyVisible()) {
            drawShape.drawEnemy(100, 400, 40, 15);
        }
        // Xử lý phần bắn đạn của Player
        ArrayList<Vector2> bulletsToRemove = new ArrayList<Vector2>();
        for (Vector2 bullet : game.getBullets()) {
            float bulletY = bullet.y + game.getBulletSpeed() * delta;
            bullet.y = bulletY;
            drawShape.drawBullet(bullet.x, bulletY, game.getRadius());

            // Check collision between bullet and enemy
            Rectangle bulletRect = new Rectangle(bullet.x, bulletY, 5, 5);
            Rectangle enemyRect = new Rectangle(100, 400, 40, 15);

            // collision
            if (bulletRect.overlaps(enemyRect)) {
                bulletsToRemove.add(bullet);
                drawShape.clearEnemy(); // Remove the enemy from rendering
            }
            else {
                spawnEnemy(); // Spawn a new enemy
             }

            if (bulletY > Gdx.graphics.getHeight()) {
                bulletsToRemove.add(bullet);
            }
        }
        game.getBullets().removeAll(bulletsToRemove);
    }

    public void spawnEnemy() {
        if (!drawShape.isEnemyVisible()) {
            int enemyX = drawShape.randomX();
            int enemyY = 400; // Set the Y coordinate of the enemy
            drawShape.drawEnemy(enemyX, enemyY, 40, 15);
            drawShape.clearEnemy();
        }
    }

//    private void spawnEnemyWithDelay() {
//        Timer.schedule(new Timer.Task() {
//            @Override
//            public void run() {
//                spawnEnemy();
//            }
//        }, 0,1); // Delay of 1 second (adjust as needed)
//    }


    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
