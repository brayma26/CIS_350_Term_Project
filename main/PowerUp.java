package main;
import java.awt.*;
import java.util.ArrayList;

/**
 * Obstacle class - Manages and draws obstacles of Crash Course Game.
 * @author - Mariah Bray, Dylan Howard, Thomas Jones
 * @version - 2/21/22
 */
public class PowerUp{

    // Represents the X position of the obstacle.
    private int positionX;
    // Represents the Y position of the obstacle.
    private int positionY;

    //The color used to create bark in the log obstacle.
    private Color woodColor = new Color(65,35,0);
    //The color used to create wood in the log obstacle.
    private Color innerColor = new Color(222,188,153);
    //The color used to create the cone in the traffic cone obstacle.
    private Color trafficColor = new Color(255, 100, 0);
    
    private ArrayList<Point> points = new ArrayList<Point>();

    /**
     * A constructor to create an obstacle.
     * @param x An integer representing the X position of the obstacle.
     * @param y An integer representing the Y position of the obstacle.
     */
    PowerUp(int x, int y){
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
    
    public void move() {
    	positionX = looperX(positionX, 220);
    	points.clear();
    }
    
    /**
     * A method to obtain the Array List of points that represent an obstacle.
     * @return An Array List of points representing the obstacle
     */
    public ArrayList<Point> getPoints(){
        return points;
    }

    /**
     * A method to create a log and control the requirements of a crash for this specific obstacle.
     * @param view A Graphics type object, this must be the same as the Graphics object used in all classes.
     */
    public void drawFlower(Graphics view){
    	points.clear();
        positionX = looperX(positionX,4);
        
        view.setColor(Color.pink);
        view.fillOval(positionX + 20, positionY + 7, 25, 25);
        view.fillOval(positionX-20, positionY+7, 25, 25);
        view.fillOval(positionX+12, positionY-15, 25, 25);
        view.fillOval(positionX-12, positionY-15, 25, 25);
        view.fillOval(positionX, positionY+20, 25, 25);
        view.setColor(Color.yellow);
        view.fillOval(positionX, positionY, 25, 25);
        
        //Create point array to represent log
        for(int i=positionX -40; i <= positionX + 40; ++i) {
        	for(int j=positionY - 30; j <= positionY + 40; ++j) {
        		points.add(new Point(i,j));
        	}
        }
    }

    /**
     * A method to allow obstacle to loop back around once they have gone off-screen
     * @param l An integer representing the obstacles X position on screen.
     * @param p An integer representing how many pixels the obstacle is to move each loop.
     * @return An integer representing the new X position of the obstacle.
     */
    public int looperX(int l, int p){
        if(l < -10){
            //positionY = positionY - 11;
            l = 3000;
        }
        else{
            l = l-p;
        }
        return l;
    }
}
