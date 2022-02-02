
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
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

    private int x = -350;
    private int j = 1400;
    private int k = 0;
    private int l = 100;
    private int tall = 475;
    
    public static void main(String[] a) {
         JFrame f = new JFrame();
        f.setContentPane(new Drawing());
        f.setSize(1450, 750);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);
        
    }

    public void paintComponent(Graphics g){

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
        g.fillRect(0, 600, 1450, 10);
        
        // draw clouds
        drawCloud(j,100, g);
        drawCloud(k,30, g);
        drawCloud(l,230, g);
        
        // draw cars
        drawCara( 100,tall, g);
        //drawCarb( z, 575, g);
        addMouseMotionListener(this);
     
        // drawing must be written in code where pieces on the top layer are be written last

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
        x = e.getX();
        z = 600 - 3 * x / 4;
        j = 1400 - 3 * x / 2 ;
        k = 0 + 3 * x / 2 ;
        l = 100 + x;

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
}


    
