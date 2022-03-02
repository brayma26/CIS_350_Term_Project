package main;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Drawing class -draws all components of Crash Course Game.
 * @author - Mariah Bray, Dylan Howard, Thomas Jones
 * @version - 2/21/22
 */
public class Drawing extends JPanel implements MouseMotionListener {
    @Override
    public void mouseMoved(MouseEvent e) {}
 
    private static boolean drawer = false;
    private int screen = 1;

    private Car car = new Car(100,475);
    private Background b1 = new Background(1400);
    private Obstacle o1 = new Obstacle(1400, 500);
    private Obstacle o2 = new Obstacle(1600 + 300, 650);

    public void paintComponent(Graphics g) {

        // this statement required
        super.paintComponent(g);

        if(screen == 2 && car.getLives() <= 0){
            b1.drawBackgroundCrash(g);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Comic Sans", Font.PLAIN, 30)); 
            g.drawString("Game Over", 600, 500);
            g.drawString("Obstacles Passed: " + (o1.getCounter() + o2.getCounter()), 550 , 450);
        }
        else{

            if(screen == 3){
                setBackground(Color.CYAN);
    
                b1.drawBackgroundGame(g);
    
                if(drawer){
                    screen = o1.drawTrafficCone(g, car);
                    if (screen == 3){
                        screen = o2.drawLog(g, car);
                    }
                }
    
                // draw car
                car.drawCar(g);
    
                g.setColor(Color.BLACK);
                g.setFont(new Font("Comic Sans", Font.PLAIN, 20)); 
                g.drawString("Obstacles Passed: " + (o1.getCounter() + o2.getCounter()) + " Lives: " + car.getLives(), 1100, 50);
                
            }
            else if(screen == 2){
                b1.drawBackgroundCrash(g);
                g.setColor(Color.WHITE);
                g.setFont(new Font("Comic Sans", Font.PLAIN, 30)); 
                g.drawString("Lives Left: " + car.getLives(), 605, 450);
                g.drawString("Click to Continue", 575, 500);
            }
            else if(screen == 1){
                b1.drawStartScreen(g);
            }
            else{
                System.out.println("Error Screen");
            }
    
            addMouseMotionListener(this);
            repaint();
            // drawing must be written in code where pieces on the top layer are written last
        }
    
        }
    
        public void mouseDragged(MouseEvent e) {

            if(screen == 1){
                if(e.getY() < 375 && e.getX() < 725){
                    car.setColor(Color.blue);
                }
                else if(e.getY() >= 375 && e.getX() >= 725){
                    car.setColor(Color.green);
                }
                else if(e.getY() < 375 && e.getX() >= 725){
                    car.setColor(Color.magenta);
                }
                else if(e.getY() >= 375 && e.getX() < 725){
                    car.setColor(Color.YELLOW);
                }
                else{
                    car.setColor(Color.PINK);
                }

            }
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

        Sound music = new Sound();

        //music.playMusic("CIS_350_Term_Project/Tours-Enthusiast.wav");

        music.playMusic();
    }
}