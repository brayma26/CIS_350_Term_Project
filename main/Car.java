package main;
import java.awt.*;

/**
 * Car class - Manages and draws cars of Crash Course Game.
 * @author - Mariah Bray, Dylan Howard, Thomas Jones
 * @version - 2/21/22
 */

public class Car{

    // Represents the color of the car.
    private Color carColor;
    // Represents the X position of the obstacle.
    private final int positionX;
    // Represents the Y position of the obstacle.
    private int positionY;
    // Represent the lives of player.
    private int lives = 3;

    /**
     * A constructor to create a car.
     * @param x An integer representing the X position of the car.
     * @param y An integer representing the Y position of the car.
     */
    Car(int x, int y){
        positionX = x;
        positionY = y;
    }

    /**
     * A method to set the color of the car.
     * @param color A color object representing the desired color.
     */
    public void setColor(Color color){
        this.carColor = color;
    }

    /**
     * A method to get the color of the car.
     * @return A color object representing the desired color.
     */
    public Color getColor(){
        return carColor;
    }

    /**
     * A method to set the Y position of the car.
     * @param y An integer representing the desired Y position of the car.
     */
    public void setY(int y){
        if (y > 450 && y < 750){
            positionY = y;
        }
    }

    /**
     * A method to set the lives left of the car.
     * @param lives An integer representing the desired lives.
     */
    public void setLives(int lives){

        if (lives < 4 && lives >= 0){
            this.lives = lives;
        }
    }

    /**
     * A method to obtain the X position of the car.
     * @return An integer representing the X position of the car.
     */
    public int getX(){
        return positionX;
    }

    /**
     * A method to obtain the lives left of the car.
     * @return An integer representing the lives left of the car.
     */
    public int getLives(){
        return lives;
    }

    /**
     * A method to obtain the Y position of the car.
     * @return An integer representing the Y position of the car.
     */
    public int getY(){
        return positionY;
    }
    
    /**
     * A method to create a Volkswagen Beetle.
     * @param view A Graphics type object, this must be the same as the Graphics object used in all classes.
     */
    public void drawCar(Graphics view) {
        if(carColor == null){
            carColor = Color.pink;
        }

        // create car body
        view.setColor(carColor);
        view.fillRect(positionX, positionY, 200, 50);
 
        view.setColor(carColor);
        view.fillOval(positionX + 30, positionY - 50, 135, 100);
         
         // create windows
        view.setColor(Color.CYAN);
        view.fillRect(positionX + 55, positionY - 35, 40, 30);
         
        view.setColor(Color.CYAN);
        view.fillRect(positionX + 105, positionY - 35, 40, 30);
         
         // create wheels
        view.setColor(Color.BLACK);
        view.fillOval(positionX + 20, positionY + 10, 50, 50);
         
        view.setColor(Color.BLACK);
        view.fillOval(positionX + 135, positionY + 10, 50, 50);
         
         // create headlights
        view.setColor(Color.WHITE);
        view.fillOval(positionX + 185, positionY, 20, 20);

    }

}
