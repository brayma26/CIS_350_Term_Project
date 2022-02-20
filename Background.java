package CIS_350_Term_Project;
import java.awt.*;
public class Background {

    private Graphics view;
    //Represents the X position of the first cloud in the background.
    private int firstCloud = 0;
    //Represents the X position of the second cloud in the background.
    private int secondCloud = firstCloud + 400;
    //Represents the X position of the third cloud in the background.
    private int thirdCloud = firstCloud + 700;

    /**
     * A constructor to create the games background.
     * @param firstCloud An integer representing the X position 
     * of the first cloud in the background (Recommended : 0).
     */
    Background(int firstCloud){
        this.firstCloud = firstCloud;
    }
    
    /**
     * A method to draw the games background when it is being played.
     * @param view A Graphics type object, this must be the same as 
     * the Graphics object used in all classes. 
     */
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

    /**
     * A method to draw the games background when it has yet to be started.
     * @param view A Graphics type object, this must be the same as 
     * the Graphics object used in all classes. 
     */
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

    /**
     * A method to draw clouds for the games background.
     * @param x An integer representing the cloud's X position on screen.
     * @param y An integer representing the cloud's Y position on screen.
     */
    public void drawCloud(int x, int y, Graphics view) {

        view.setColor(Color.WHITE);
        view.fillOval( x, y, 50, 50);
        
        view.setColor(Color.WHITE);
        view.fillOval( x - 20, y + 15, 50, 50);
        
        view.setColor(Color.WHITE);
        view.fillOval( x + 20, y + 10, 50, 50);
    }

    /**
     * A method to allow clouds to loop back around once they have gone off screen
     * @param l An integer representing the cloud's X position on screen.
     * @param p An integer representing how many pixels the cloud is to move each loop.
     * @return An interger representing the new X position of the cloud.
     */
    public int looperCloud(int l, int p){
        if(l < -10){
            l = 1500;
        }
        else{
            l = l-p;
        }
        return l;
    }

    /**
     * A method to draw the games background when a crash has occured.
     * @param view A Graphics type object, this must be the same as 
     * the Graphics object used in all classes. 
     */
    public void drawBackgroundCrash(Graphics view) {
        this.view = view;
        view.setColor(Color.RED);
        view.fillRect(0, 0, 1500, 700);
        view.setColor(Color.WHITE);
        view.setFont(new Font("Comic Sans", Font.PLAIN, 50));
        view.drawString("CRASH!", 600, 300);
    }
    
}
