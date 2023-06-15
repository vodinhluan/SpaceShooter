package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;


public class MyGdxGame extends Game {
	SpriteBatch batch;
	ShapeRenderer shapeRenderer;
	BitmapFont font;

	float playerSpeed;
	float playerX = 250;
	float playerY = 100;

	float bulletX;
	float bulletY;
	float radius = 4;
	public boolean bulletShot;
	public float bulletSpeed = 300;
	public ArrayList<Vector2> bullets;

	public float EnemyX;
	public float EnemyY;

	public float bulletEnemyX;
	public float bulletEnemyY;
	public ArrayList<Vector2> bulletsEnemy;


	@Override
	public void create () {
		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
		font = new BitmapFont();
		setScreen(new TitleScreen(this));
		setPlayerSpeed(100);
		bullets = new ArrayList<Vector2>();
		bulletsEnemy = new ArrayList<Vector2>();
	}

	public float getPlayerX()
	{
		return playerX;
	}

	public void setPlayerX(float x)
	{
		playerX = x;
	}

	public float getPlayerY()
	{
		return playerY;
	}

	public void setPlayerY(float y)
	{
		playerY = y;
	}

	public float getPlayerSpeed()
	{
		return playerSpeed;
	}

	public void setPlayerSpeed(float player_speed)
	{
		playerSpeed = player_speed;
	}

	public float getBulletX() {
		return bulletX;
	}

	public void setBulletX(float x) {
		bulletX = x;
	}

	public float getBulletY() {
		return bulletY;
	}

	public void setBulletY(float y) {
		bulletY = y;
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}

	public boolean isBulletShot() {
		return bulletShot;
	}

	public void setBulletShot(boolean bulletShot) {
		this.bulletShot = bulletShot;
	}

	public float getBulletSpeed() {
		return bulletSpeed;
	}

	public void setBulletSpeed(float bulletSpeed) {
		this.bulletSpeed = bulletSpeed;
	}

	public ArrayList<Vector2> getBullets() {
		return bullets;
	}

	public void setBullets(ArrayList<Vector2> bullets) {
		this.bullets = bullets;
	}

	public float getEnemyX() {
		return EnemyX;
	}

	public void setEnemyX(float enemyX) {
		EnemyX = enemyX;
	}

	public float getEnemyY() {
		return EnemyY;
	}

	public void setEnemyY(float enemyY) {
		EnemyY = enemyY;
	}


	public ArrayList<Vector2> getBulletsEnemy() {
		return bulletsEnemy;
	}

	public void setBulletsEnemy(ArrayList<Vector2> bulletsEnemy) {
		this.bulletsEnemy = bulletsEnemy;
	}


	@Override
	public void dispose () {
		batch.dispose();
		shapeRenderer.dispose();
		font.dispose();
	}
}
