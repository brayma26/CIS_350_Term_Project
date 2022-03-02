package main;

import org.junit.jupiter.api.Assertions;
import java.awt.*;

/**
 * Test class - Test cases for Crash Course Game.
 * Uses JUnit 5.8.1
 * @author - Mariah Bray, Dylan Howard, Thomas Jones
 * @version - 2/21/22
 */
public class Test {

    private final int firstCloud = 0;
    private Background background = new Background(firstCloud);
    private Car car = new Car(100, 475);
    private Obstacle o = new Obstacle(100, 475);
    private Obstacle obstacle = new Obstacle(1400, 500);
    private Sound music = new Sound();

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
    void getXCarTest(){
        Assertions.assertEquals(car.getX(), 100);
    }

    @org.junit.jupiter.api.Test
    void getYCarTest(){
        Assertions.assertEquals(car.getY(), 475);
    }

    @org.junit.jupiter.api.Test
    void setYCarTest(){
        car.setY(500);
        Assertions.assertEquals(car.getY(), 500);
        car.setY(1000);
        Assertions.assertEquals(car.getY(), 500);
        car.setY(200);
        Assertions.assertEquals(car.getY(), 500);
    }

    @org.junit.jupiter.api.Test
    void getLivesCarTest(){
        Assertions.assertEquals(car.getLives(), 3);
    }

    @org.junit.jupiter.api.Test
    void setLivesCarTest(){
        car.setLives(2);
        Assertions.assertEquals(car.getLives(), 2);
        car.setLives(-1);
        Assertions.assertEquals(car.getLives(), 2);
        car.setLives(300);
        Assertions.assertEquals(car.getLives(), 2);
    }

    @org.junit.jupiter.api.Test
    void setColorCarTest(){
        car.setColor(Color.PINK);
        Assertions.assertEquals(car.getColor(), Color.PINK);
    }

    // Tests for Obstacle Class

    @org.junit.jupiter.api.Test
    void getXObstacleTest(){
        Assertions.assertEquals(obstacle.getX(), 1400);
    }

    @org.junit.jupiter.api.Test
    void getYObstacleTest(){
        Assertions.assertEquals(obstacle.getY(), 500);
    }

    @org.junit.jupiter.api.Test
    void setXObstacleTest(){
        obstacle.setX(1800);
        Assertions.assertEquals(obstacle.getX(), 1400);

        obstacle.setX(300);
        Assertions.assertEquals(obstacle.getX(), 300);

        obstacle.setX(-50);
        Assertions.assertEquals(obstacle.getX(), 300);
    }

    @org.junit.jupiter.api.Test
    void setYObstacleTest(){
        obstacle.setY(600);
        Assertions.assertEquals(obstacle.getY(), 600);

        obstacle.setY(1200);
        Assertions.assertEquals(obstacle.getY(), 600);

        obstacle.setY(100);
        Assertions.assertEquals(obstacle.getY(), 600);

    }

    @org.junit.jupiter.api.Test
    void getPassedCounterTest(){
        Assertions.assertEquals(o.getCounter(), 0);
        o.setX(o.looperX(-11, 1));
        Assertions.assertEquals(o.getCounter(), 1);
    }

    @org.junit.jupiter.api.Test
    void looperObstacleTest(){
        Assertions.assertEquals(obstacle.looperX(100, 5), 95);
        Assertions.assertEquals(obstacle.looperX(-20, 5), 1500);
    }

    //Test for Sound Class
    @org.junit.jupiter.api.Test
    void soundTest(){
        Assertions.assertEquals(music.playMusic(),0);
    }


}
