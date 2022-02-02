
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

    private static int c = 1400;
    private int a = c+700;
    private int b = c + 400; 
    private int tall = 475;
    public static boolean drawer = false;

    public void paintComponent(Graphics g) {

        // this statement required
        super.paintComponent(g);

        // optional: paint the background color (default is white)
        setBackground(Color.CYAN);
        // display words
        g.setColor(Color.BLACK);
        g.drawString("Bugs on a Trip", 250, 20);
       
        // create road
        g.setColor(Color.GRAY);
        g.fillRect(0, 450, 1450, 600);
        
        g.setColor(Color.YELLOW);
        g.fillRect(0, 600, 1500, 10);
        
        // draw cars
        drawCara( 100,tall, g);
        //drawCarb( z, 575, g);
        addMouseMotionListener(this);

        if(drawer == true){
            //drawobstacle
        }

        // draw clouds
        drawCloud(a,100, g);
        drawCloud(b,30, g);
        drawCloud(c, 230, g);
        a = looper(a);
        b = looper(b);
        c = looper(c);
        repaint();

        // drawing must be written in code where pieces on the top layer are be written last

    }

    public int looper(int l){
        if(l < -10){
            l = 1500;
        }
        else{
            l = l-1;
        }
        return l;
    }
    
    
    public void drawCloud(int x, int y, Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval( x, y, 50, 50);
        
        g.setColor(Color.WHITE);
        g.fillOval( x - 20, y + 15, 50, 50);
        
        g.setColor(Color.WHITE);
        g.fillOval( x + 20, y + 10, 50, 50);

    }
    public void drawCara(int x, int y, Graphics g) {
       // create car body
       g.setColor(Color.YELLOW);
       g.fillRect(x, y, 200, 50);

        g.setColor(Color.YELLOW);
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
    
    public void drawCarb(int x, int y, Graphics g) {
       // create body
       g.setColor(Color.RED);
       g.fillRect(x, y, 200, 50);

       g.setColor(Color.RED);
       g.fillOval(x + 30, y - 50, 135, 100);
        
       //create windows
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
       g.fillOval( x - 5, y, 20, 20);
    }

    
    public void mouseDragged(MouseEvent e) {

        if(e.getY() < 425){
            tall = 425;
        }
        else if(e.getY() > 700){
            tall = 700;
        }
        else{
            tall = e.getY();
        }
        repaint();
        
    }
     

    public static void main(String[] a) {
        JFrame f = new JFrame();
       f.setContentPane(new Drawing());
       f.setSize(1450, 750);
       f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       f.setVisible(true);

       Timer timer = new Timer(5000 , new ActionListener(){
        public void actionPerformed(ActionEvent evt) {
            drawer = true;                             
        }});
        timer.setRepeats(true);
        timer.start();


    }
}


    
