import CIS_350_Term_Project.*;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.awt.*;

/**
 * Sample test cases for Crash Course Game
 * Author: Mariah Bray
 */
public class SampleTest {
    public static class BackgroundTest{
        private final int firstCloud = 0;

        Background background = new Background(this.firstCloud);

        @Test
        void looperCloudTest() {
            int testCase;

            testCase = this.background.looperCloud(-15, 100);
            Assert.assertEquals(testCase, 1500);

            testCase = this.background.looperCloud(2000, 100);
            Assert.assertEquals(testCase, 1900);
        }
    }

    public static class CarTest{
        Car car = new Car(100, 475);

        @Test
        void getXTest(){
            Assert.assertEquals(car.getX(), 100);
        }

        @Test
        void getYTest(){
            Assert.assertEquals(car.getY(), 475);
        }

        @Test
        void setYTest(){
            car.setY(300);
            Assert.assertEquals(car.getY(), 300);
        }
    }

    public static class ObstacleTest{
        private Graphics view;
        private int obstacleCounter;

        Obstacle obstacle = new Obstacle(1400, 500);
        Car car = new Car(100, 475);

        @Test
        void getXTest(){
            Assert.assertEquals(obstacle.getX(), 1400);
        }

        @Test
        void getYTest(){
            Assert.assertEquals(obstacle.getY(), 500);
        }

        @Test
        void setXTest(){
            obstacle.setX(1800);
            Assert.assertEquals(obstacle.getX(), 1400);

            obstacle.setX(300);
            Assert.assertEquals(obstacle.getX(), 300);
        }

        @Test
        void setYTest(){
            obstacle.setY(900);
            Assert.assertEquals(obstacle.getY(), 500);

            obstacle.setY(600);
            Assert.assertEquals(obstacle.getY(), 600);

        }
        @Test
        void getCounterTest(){
            Assert.assertEquals(this.obstacleCounter, 0);
        }

        @Test
        void looperXTest(){
            Assert.assertEquals(obstacle.looperX(100, 5), 95);
            Assert.assertEquals(obstacle.looperX(-20, 5), 1500);
        }

        @Test
        void drawConeTest(){
            int x = car.getX();
            System.out.println(x);
            Assert.assertEquals(obstacle.drawTrafficCone(this.view, car.getY()), 3);
        }
    }
}
