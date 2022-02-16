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
    private int tall = 475;
    public static boolean drawer = false;
    public static boolean crash = false;

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

        if(drawer == true){
            drawObstacle(o, 550, g);
            o = looper(o,3);
        }

        if(o < 300 && o> 100 && tall < 575 && tall > 500 ){
            crash = true;
        }
        
        // draw cars
        drawCar(100, tall, g, Color.YELLOW);
        //drawCarb( z, 575, g);
        addMouseMotionListener(this);

        // draw clouds
        drawCloud(a,100, g);
        drawCloud(b,30, g);
        drawCloud(c, 230, g);
        a = looper(a,1);
        b = looper(b,1);
        c = looper(c,1);
        repaint();

        if(crash == true){
            crash(g);
        }

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
    
    
    public void drawCloud(int x, int y, Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval( x, y, 50, 50);
        
        g.setColor(Color.WHITE);
        g.fillOval( x - 20, y + 15, 50, 50);
        
        g.setColor(Color.WHITE);
        g.fillOval( x + 20, y + 10, 50, 50);

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

