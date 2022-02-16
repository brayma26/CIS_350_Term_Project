package CIS_350_Term_Project;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Drawing class -drawing example
 * @author - Mariah Bray
 * @version - 09/14/20
 */ 
public class Drawing extends JPanel implements MouseMotionListener {
     @Override
    public void mouseMoved(MouseEvent e) {}

    private int c = 1400;
    private int a = c+700;
    private int b = c + 400; 
    private static boolean drawer = false;
    private int screen = 1;

    Car car = new Car(100,475);
    Background b1 = new Background();
    Obstacle o1 = new Obstacle(1400, 500);
    Obstacle o2 = new Obstacle(1600 + 300, 650);

    public void paintComponent(Graphics g) {

        // this statement required
        super.paintComponent(g);

        if(screen == 3){
            // optional: paint the background color (default is white)
            setBackground(Color.CYAN);

            b1.drawBackgroundGame(g);
            
            if(drawer == true){
                screen = o1.drawTrafficCone(g, car.getY());
                o1.setX(looper(o1.getX(),3));
                if (screen == 3){
                    screen = o2.drawLog(g, car.getY());
                    o2.setX(looper(o2.getX(),3));
                }
            }
            
            // draw car
            car.drawCar(Color.YELLOW, g);

            // draw clouds
            b1.drawCloud(a,100, g);
            b1.drawCloud(b,30, g);
            b1.drawCloud(c, 230, g);
            a = looper(a,1);
            b = looper(b,1);
            c = looper(c,1);
            
        }
        else if(screen == 2){
            b1.drawBackgroundCrash(g);
        }
        else if(screen == 1){
            b1.drawStartScreen(g);
        }
        else{
            System.out.println("Error Screen");
        }

        if(o < 300 && o> 100 && tall < 575 && tall > 500 ){
            crash = true;
        }
        
        // draw cars
        drawCar(100, tall, g, Color.YELLOW);
        //drawCarb( z, 575, g);

        addMouseMotionListener(this);
        repaint();
        // drawing must be written in code where pieces on the top layer are be written last

    }

    public int looper(int l, int p){
        if(l < -10){
            l = 1500;
        }
        else{
            l = l-p;
        }
        return l;
    }

    public void crash(Graphics g) {
        // create car body
        g.setColor(Color.RED);
        g.fillRect(0, 0, 1500, 700);
        g.setColor(Color.WHITE);
        g.drawString("CRASH!", 650, 300);
    }

    public void drawObstacle(int x, int y, Graphics g) {
        g.setColor(Color.RED);
        g.fillPolygon(new int[] {x, x+25, x+50}, new int[] {y, y-50, y}, 3);
    }

    public void drawCar(int x, int y, Graphics g, Color bodyColor) {
       // create car body
       g.setColor(bodyColor);
       g.fillRect(x, y, 200, 50);

        g.setColor(bodyColor);
        g.fillOval(x + 30, y - 50, 135, 100);
        
        // create windows
        g.setColor(Color.CYAN);
        g.fillRect(x + 55, y - 35, 40, 30);
        
        g.setColor(Color.CYAN);
        g.fillRect(x + 105, y - 35, 40, 30);
        
        // create wheels
        g.setColor(Color.BLACK);
        g.fillOval(x + 20, y + 10, 50, 50);
        
        g.setColor(Color.BLACK);
        g.fillOval(x + 135, y + 10, 50, 50);
        
        // create headlights
        g.setColor(Color.WHITE);
        g.fillOval(x + 185, y, 20, 20);
        
    }

    public void mouseDragged(MouseEvent e) {
        screen = 3;
        

        if(e.getY() < 425){
            car.setY(425);
        }
        else if(e.getY() > 700){
            car.setY(700);
        }
        else{
            car.setY(e.getY());
        }
        repaint();
        
    }


    public void mousePressed(MouseEvent e) {
        screen = 3;
        repaint();
    }
     
    public static void main(String[] a) {
        JFrame f = new JFrame();
        f.setContentPane(new Drawing());
        f.setSize(1450, 750);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);

       Timer timer = new Timer(2500 , new ActionListener(){
        public void actionPerformed(ActionEvent evt) {
            drawer = true;                             
        }});
        timer.setRepeats(true);
        timer.start();

        String filepath = "Tours-Enthusiast.wav";
        Sound musicObj = new Sound();
        musicObj.playMusic(filepath);
    }
}
