package CIS_350_Term_Project;
import java.awt.*;

public class Car{

    private Graphics view;
    private Color carColor;
    private int positionX;
    private int positionY;

    Car(int x, int y){
        positionX = x;
        positionY = y;
    }

    public void setColor(Color color){
        carColor = color;
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
