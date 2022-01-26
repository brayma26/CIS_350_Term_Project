
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
    
    public static void main(String[] a) {
         JFrame f = new JFrame();
        f.setContentPane(new Drawing());
        f.setSize(600, 400);
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
        g.fillRect(0, 150, 600, 450);
        
        g.setColor(Color.YELLOW);
        g.fillRect(0, 250, 600, 10);
        
        // draw clouds
        drawCloud(j,20, g);
        drawCloud(k,10, g);
        drawCloud(l,30, g);
        
        // draw cars
        drawCara( x,175, g);
        drawCarb( z, 275, g);
        addMouseMotionListener(this);
     
        
        
        
        // note that drawing must be written in code so that pieces of the drawing on the top layer must be written last

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
   
    private int x = -350;
    private int z = 600; 
    private int j = 500;
    private int k = 0;
    private int l = 100;
    
    public void mouseDragged(MouseEvent e) {
        x = e.getX();
        z = 600 - 3 * x / 4;
        j = 500 - 3 * x / 2 ;
        k = 0 + 3 * x / 2 ;
        l = 100 + x;
        repaint();
        
    }
}


    
