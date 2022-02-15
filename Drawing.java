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
    private int o = 1400;
    private int a = c+700;
    private int b = c + 400; 
    public static boolean drawer = false;
    public static boolean crash = false;

    Car car = new Car(100,475);
    Background b1 = new Background();
    Obstacle o1 = new Obstacle(o, 550);

    public void paintComponent(Graphics g) {

        // this statement required
        super.paintComponent(g);

        if(crash == false){
            // optional: paint the background color (default is white)
            setBackground(Color.CYAN);

            b1.drawBackgroundGame(g);
            
            if(drawer == true){
                o1.drawObstacle(g);
                o = looper(o,3);
                o1.setX(o);
            }

            if(o < 300 && o> 100 && car.getY() < 575 && car.getY() > 500 ){
                crash = true;
            }
            
            // draw cars
            car.drawCar(Color.YELLOW, g);

            addMouseMotionListener(this);

            // draw clouds
            b1.drawCloud(a,100, g);
            b1.drawCloud(b,30, g);
            b1.drawCloud(c, 230, g);
            a = looper(a,1);
            b = looper(b,1);
            c = looper(c,1);
            
        }
        else{
            b1.drawBackgroundCrash(g);
        }

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

    public void mouseDragged(MouseEvent e) {

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
    }
}


    
