package CIS_350_Term_Project;
import java.awt.*;
public class Background {

    private Graphics view;
    private int firstCloud = 0;
    private int secondCloud = firstCloud + 400;
    private int thirdCloud = firstCloud + 700;

    Background(int firstCloud){
        this.firstCloud = firstCloud;
    }
    
    public void drawBackgroundGame(Graphics view) {
        this.view = view;
       
        // create road
        view.setColor(Color.GRAY);
        view.fillRect(0, 450, 1450, 600);
        
        view.setColor(Color.YELLOW);
        view.fillRect(0, 600, 1500, 10);

        // draw clouds
        drawCloud(firstCloud,100, view);
        drawCloud(secondCloud,30, view);
        drawCloud(thirdCloud, 230, view);
        
        firstCloud = looperCloud(firstCloud,1);
        secondCloud = looperCloud(secondCloud,1);
        thirdCloud = looperCloud(thirdCloud,1);

    }

    public void drawStartScreen(Graphics view) {
        this.view = view;
    
        view.setColor(Color.magenta);
        view.fillRect(0, 0, 1500, 100);
        view.fillRect(0, 400, 1500, 100);
        view.setColor(Color.yellow);
        view.fillRect(0, 100, 1500, 100);
        view.fillRect(0, 500, 1500, 100);
        view.setColor(Color.GREEN);
        view.fillRect(0, 200, 1500, 100);
        view.fillRect(0, 600, 1500, 100);
        view.setColor(Color.CYAN);
        view.fillRect(0, 300, 1500, 100);
        view.fillRect(0, 700, 1500, 100);

        // display words
        view.setColor(Color.BLACK);
        view.setFont(new Font("Comic Sans", Font.PLAIN, 50)); 
        view.drawString("Crash Course!", 550, 280);
        view.setFont(new Font("Comic Sans", Font.PLAIN, 30)); 
        view.drawString("Click and Drag Anywhere to Start", 500, 380);

    }

    public void drawCloud(int x, int y, Graphics view) {

        view.setColor(Color.WHITE);
        view.fillOval( x, y, 50, 50);
        
        view.setColor(Color.WHITE);
        view.fillOval( x - 20, y + 15, 50, 50);
        
        view.setColor(Color.WHITE);
        view.fillOval( x + 20, y + 10, 50, 50);
    }

    public int looperCloud(int l, int p){
        if(l < -10){
            l = 1500;
        }
        else{
            l = l-p;
        }
        return l;
    }

    public void drawBackgroundCrash(Graphics view) {
        this.view = view;
        view.setColor(Color.RED);
        view.fillRect(0, 0, 1500, 700);
        view.setColor(Color.WHITE);
        view.setFont(new Font("Comic Sans", Font.PLAIN, 50));
        view.drawString("CRASH!", 600, 300);
    }
    
}
