package CIS_350_Term_Project;
import java.awt.*;

public class Obstacle{

    private Graphics view;
    // Represents the X position of the obstacle.
    private int positionX;
    // Represents the Y position of the obstacle.
    private int positionY;
    // Represents the number of times the obstacle has been passed successfully.
    private int obstacleCounter = 0;

    //The color used to create bark in the log obstacle.
    Color woodColor = new Color(120,75,0);
    //The color used to create wood in the log obstacle.
    Color innerColor = new Color(222,188,153);
    //The color used to create the cone in the traffic cone obstacle.
    Color trafficColor = new Color(255, 165, 0);

    /**
     * A constructor to create an obstacle.
     * @param x An integer representing the X position of the obstacle.
     * @param y An integer representing the Y position of the obstacle.
     */
    Obstacle(int x, int y){
        positionX = x;
        positionY = y;
    }

    /**
     * A method to set the X position of the obstacle.
     * @param x An integer representing the desired X position of the obstacle.
     */
    public void setX(int x){
        if (x > -10 && x<=1600){
            positionX = x;
        }
    }

    /**
     * A method to set the Y position of the obstacle.
     * @param y An integer representing the desired Y position of the obstacle.
     */
    public void setY(int y){
        if (y > 450 && y<750){
            positionY = y;
        }
    }

    /**
     * A method to obtain the X position of the obstacle.
     * @return An integer representing the X position of the obstacle.
     */
    public int getX(){
        return positionX;
    }

    /**
     * A method to obtain the Y position of the obstacle.
     * @return An integer representing the Y position of the obstacle.
     */
    public int getY(){
        return positionY;
    }

    /**
     * A method to obtain the internal count of obstacles the user has passed successfully.
     * @return An integer representing the obstacles passed count.
     */
    public int getCounter(){
        return obstacleCounter;
    }
    
    /**
     * A method to create a traffic cone and control the requierments of a crash for this specific obstacle.
     * @param view A Graphics type object, this must be the same as the Graphics object used in all classes.
     * @param carY An integer representing the Y position of the user's car.
     * @return An interger representing the games state. 2 will be returned if a crash has occured, 
     * 3 will be returned if the game continues as normal.
     */
    public int drawTrafficCone(Graphics view, Car car){
        this.view = view;
        positionX = looperX(positionX,3);
        view.setColor(trafficColor);
        view.fillPolygon(new int[] {positionX, positionX+25, positionX+50}, new int[] {positionY, positionY-50, positionY}, 3);
        view.fillRect(positionX - 5, positionY, 60, 10);
        view.setColor(Color.WHITE);
        view.fillPolygon(new int[] {positionX+15, positionX+25, positionX+35}, new int[] {positionY-30, positionY-50, positionY-30}, 3);

        if(positionX < 300 && positionX> 200 && car.getY() > positionY - 50 && car.getY() < positionY +10 ){
            positionX = positionX - 200;
            car.setLives(car.getLives() - 1);
            return 2;
        }
        return 3;
    }

    /**
     * A method to create a log and control the requierments of a crash for this specific obstacle.
     * @param view A Graphics type object, this must be the same as the Graphics object used in all classes.
     * @param carY An integer representing the Y position of the user's car.
     * @return An interger representing the games state. 2 will be returned if a crash has occured, 
     * 3 will be returned if the game continues as normal.
     */
    public int drawLog(Graphics view, Car car){
        positionX = looperX(positionX,5);
        this.view = view;
        view.setColor(woodColor);
        view.fillOval(positionX, positionY, 60, 60);
        view.setColor(innerColor);
        view.fillOval(positionX + 5, positionY + 5, 50, 50);
        view.setColor(woodColor);
        view.drawOval(positionX+10, positionY+10, 40, 40);
        view.drawOval(positionX+15, positionY+15, 30, 30);
        view.drawOval(positionX+20, positionY+20, 20, 20);
        view.drawOval(positionX+25, positionY+25, 10, 10);
        
        if(positionX < 300 && positionX> 200 && car.getY() > positionY - 60 && car.getY() < positionY +30 ){
            positionX = positionX - 200; 
            car.setLives(car.getLives() - 1);
            return 2;
        }
        return 3;
    }

    /**
     * A method to allow obstacle to loop back around once they have gone off screen
     * @param l An integer representing the obstacles X position on screen.
     * @param p An integer representing how many pixels the obstacle is to move each loop.
     * @return An interger representing the new X position of the obstacle.
     */
    public int looperX(int l, int p){
        if(l < -10){
            //positionY = positionY - 11;
            l = 1500;
            obstacleCounter++;
        }
        else{
            l = l-p;
        }
        return l;
    }
}
