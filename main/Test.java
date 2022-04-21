package main;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;

/**
 * Test class - Test cases for Crash Course Game.
 * Uses JUnit 5.8.1
 * @author - Mariah Bray, Dylan Howard, Thomas Jones
 * @version - 2/21/22
 */
public class Test {

	/** Integer to determine cloud starting point. */
	private final int firstCloud = 0;
	/** test Background of game. */
	private Background background = new Background(firstCloud);
	/** test Car object. */
	private Car car = new Car(100, 475);
	/** test Obstacle object. */
	private Obstacle o = new Obstacle(100, 475);
	/** test Sound of game. */
	private Sound music = new Sound();
	/** test Game object. */
	private Game g = new Game();
	/** test Powerup object. */
	private PowerUp pUp = new PowerUp(100, 475);
	/** test Obstacle Point array. */
	private ArrayList<Point> points1 = new ArrayList<Point>();
	/** test Obstacle Point array. */
	private ArrayList<Point> points2 = new ArrayList<Point>();

	//Tests for Background Class

	@org.junit.jupiter.api.Test
	void looperCloudTest() {
		int testCase;

		testCase = this.background.looperCloud(-15, 100);
		Assertions.assertEquals(testCase, 1500);

		testCase = this.background.looperCloud(2000, 100);
		Assertions.assertEquals(testCase, 1900);
	}

	//Tests for Car Class

	@org.junit.jupiter.api.Test
	void getXCarTest() {
		Assertions.assertEquals(car.getX(), 100);
	}

	@org.junit.jupiter.api.Test
	void getYCarTest() {
		Assertions.assertEquals(car.getY(), 475);
	}

	@org.junit.jupiter.api.Test
	void setYCarTest() {
		car.setY(500);
		Assertions.assertEquals(car.getY(), 500);
		car.setY(1000);
		Assertions.assertEquals(car.getY(), 500);
		car.setY(200);
		Assertions.assertEquals(car.getY(), 500);
	}

	@org.junit.jupiter.api.Test
	void setColorCarTest() {
		car.setColor(Color.PINK);
		Assertions.assertEquals(car.getColor(), Color.PINK);
	}

	@org.junit.jupiter.api.Test
	void getColorCarTest() {
		car.setColor(Color.PINK);
		Assertions.assertEquals(car.getColor(), Color.PINK);
	}

	// Tests for Obstacle Class

	@org.junit.jupiter.api.Test
	void getXObstacleTest() {
		Assertions.assertEquals(o.getX(), 100);
	}

	@org.junit.jupiter.api.Test
	void getYObstacleTest() {
		Assertions.assertEquals(o.getY(), 475);
	}

	@org.junit.jupiter.api.Test
	void setXObstacleTest() {
		o.setX(100);
		Assertions.assertEquals(o.getX(), 100);

		o.setX(1800);
		Assertions.assertEquals(o.getX(), 100);

		o.setX(300);
		Assertions.assertEquals(o.getX(), 300);

		o.setX(-50);
		Assertions.assertEquals(o.getX(), 300);
	}

	@org.junit.jupiter.api.Test
	void setYObstacleTest() {
		o.setY(600);
		Assertions.assertEquals(o.getY(), 600);

		o.setY(1200);
		Assertions.assertEquals(o.getY(), 600);

		o.setY(100);
		Assertions.assertEquals(o.getY(), 600);

	}

	@org.junit.jupiter.api.Test
	void getPassedCounterTest() {
		Assertions.assertEquals(o.getCounter(), 0);
		o.setX(o.looperX(-11, 1));
		Assertions.assertEquals(o.getCounter(), 1);
	}

	@org.junit.jupiter.api.Test
	void moveObstacleTest() {
		int before = o.getX();
		Assertions.assertEquals(o.getX(), before);

		o.move();
		Assertions.assertNotEquals(o.getX(), before);
	}

	@org.junit.jupiter.api.Test
	void movePowerUpTest() {
		int before = pUp.getX();
		Assertions.assertEquals(pUp.getX(), before);

		pUp.move();
		Assertions.assertNotEquals(pUp.getX(), before);
	}

	@org.junit.jupiter.api.Test
	void looperObstacleTest() {
		Assertions.assertEquals(o.looperX(100, 5), 95);
		Assertions.assertEquals(o.looperX(-20, 5), 1500);
	}

	//Test for Sound Class

	@org.junit.jupiter.api.Test
	void soundTest() {
		Assertions.assertEquals(music.
				playMusic("main/Tours-Enthusiast.wav"), 0);
		Assertions.assertEquals(music.
				playMusic("main/Tours-Enthusias.wav"), 1);

	}

	//Test for PowerUp Class

	@org.junit.jupiter.api.Test
	void getXPowerUpTest() {
		Assertions.assertEquals(pUp.getX(), 100);
	}

	@org.junit.jupiter.api.Test
	void getYPowerUpTest() {
		Assertions.assertEquals(pUp.getY(), 475);
	}

	@org.junit.jupiter.api.Test
	void setXPowerUpTest() {
		pUp.setX(200);
		Assertions.assertEquals(pUp.getX(), 200);
		pUp.setX(-30);
		Assertions.assertEquals(pUp.getX(), 200);
	}

	@org.junit.jupiter.api.Test
	void setYPowerUpTest() {
		pUp.setY(500);
		Assertions.assertEquals(pUp.getY(), 500);
		pUp.setY(30);
		Assertions.assertEquals(pUp.getY(), 500);
	}

	@org.junit.jupiter.api.Test
	void looperPowerUpTest() {
		int testCase;

		testCase = this.pUp.looperX(-15, 100);
		Assertions.assertEquals(testCase, 4000);

		testCase = this.pUp.looperX(100, 5);
		Assertions.assertEquals(testCase, 95);
	}

	@org.junit.jupiter.api.Test
	void crashTest() {
		for (int i = 0; i <= 200; ++i) {
			for (int j = 0; j <= 40; ++j) {
				points1.add(new Point(i, j));
			}
		}

		for (int i = 0; i <= 2; ++i) {
			for (int j = 30; j <= 80; ++j) {
				points2.add(new Point(i, j));
			}
		}

		Assertions.assertEquals(g.crash(points1, points2), true);

		points2.clear();
		for (int i = 0; i <= 2; ++i) {
			for (int j = 70; j <= 80; ++j) {
				points2.add(new Point(i, j));
			}
		}
		Assertions.assertEquals(g.crash(points1, points2), false);
	}

	@org.junit.jupiter.api.Test
	void carTest() {
		try {
			g.main(null);

		} catch (Exception e) {
			Assertions.fail();
		}
	}


}
