package CIS_350_Term_Project;

import java.awt.*;

public class Car{

    private Graphics view;
    // Represents the color of the car.
    private Color carColor;
    // Represents the X position of the obstacle.
    private int positionX;
    // Represents the Y position of the obstacle.
    private int positionY;

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
        carColor = color;
    }

    /**
     * A method to set the Y position of the car.
     * @param y An integer representing the desired Y position of the car.
     */
    public void setY(int y){
        if (y > 450 && y<750){
            positionY = y;
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
     * A method to obtain the Y position of the car.
     * @return An integer representing the Y position of the car.
     */
    public int getY(){
        return positionY;
    }
    
    /**
     * A method to create a Volkswagen Beetle.
     * @param view A Graphics type object, this must be the same as the Graphics object used in all classes.
     * @param color A Color object representing the desired color of the car.
     */
    public void drawCar(Color color, Graphics view) {
        this.view = view;
        carColor = color;

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
