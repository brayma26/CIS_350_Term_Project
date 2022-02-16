package CIS_350_Term_Project;
import java.awt.*;

public class Obstacle{
    Color woodColor = new Color(120,75,0);
    Color innerColor = new Color(222,188,153);
    Color trafficColor = new Color(255, 165, 0);

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
    
    public int drawTrafficCone(Graphics view, int carY){
        this.view = view;
        view.setColor(trafficColor);
        view.fillPolygon(new int[] {positionX, positionX+25, positionX+50}, new int[] {positionY, positionY-50, positionY}, 3);
        view.fillRect(positionX - 5, positionY, 60, 10);
        view.setColor(Color.WHITE);
        view.fillPolygon(new int[] {positionX+15, positionX+25, positionX+35}, new int[] {positionY-30, positionY-50, positionY-30}, 3);
        
        if(positionX < 300 && positionX> 100 && carY > positionY - 50 && carY < positionY +10 ){
            return 2;
        }
        return 3;
    }

    public int drawLog(Graphics view, int carY){
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
        
        if(positionX < 300 && positionX> 100 && carY > positionY && carY < positionY +60 ){
            return 2;
        }
        return 3;
    }
}
