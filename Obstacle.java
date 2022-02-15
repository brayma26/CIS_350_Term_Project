package CIS_350_Term_Project;
import java.awt.*;

public class Obstacle{

    private Graphics view;
    private Color color;
    private int positionX;
    private int positionY;

    Obstacle(int x, int y){
        positionX = x;
        positionY = y;
    }

    public void setColor(Color color){
        color = this.color;
    }

    public void setX(int x){
        positionX = x;
    }

    public void setY(int y){
        positionY = y;
    }

    public int getX(){
        return positionX;
    }

    public int getY(){
        return positionY;
    }
    
    public void drawObstacle(Graphics view){
        this.view = view;
        view.setColor(Color.RED);
        view.fillPolygon(new int[] {positionX, positionX+25, positionX+50}, new int[] {positionY, positionY-50, positionY}, 3);
    }
}
