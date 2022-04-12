package main;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

/**
 * Game class -draws all components of Crash Course Game.
 * @author - Mariah Bray, Dylan Howard, Thomas Jones
 * @version - 2/21/22
 */
public class Game extends JPanel implements MouseMotionListener {
    @Override
    public void mouseMoved(MouseEvent e) {}
 
    private static boolean drawer = false;
    private static boolean isCar = false;
    private static boolean isRunning = true;
    private int screen = 1;
    private int lives = 3;
    private int passed = 0;
    private Car car = new Car(100,475);
    private Background b1 = new Background(1400);
    private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
    private ArrayList<PowerUp> powers = new ArrayList<PowerUp>();

    public void paintComponent(Graphics g) {

        // this statement required
        super.paintComponent(g);

        if(screen == 2 && car.getLives() <= 0){
            b1.drawBackgroundCrash(g);
            b1.drawTextFinalCrash(g, obstaclesPassed());
        }
        else{

            if(screen == 3){
                setBackground(Color.CYAN);
    
                b1.drawBackgroundGame(g);
                
                //if(drawer){
	                for(int i = 0; i< obstacles.size(); ++i) {
	                	if(i%2 == 0) {
	                		obstacles.get(i).drawTrafficCone(g);
	                	}
	                	else {
	                		obstacles.get(i).drawLog(g);
	                	}
	                }
	                for(int i = 0; i< obstacles.size(); ++i) {
	                	if(i%2 == 0) {
	                		powers.get(i).drawFlower(g);
	                	}
	                	else {
	                		//obstacles.get(i).drawLog(g);
	                	}
	                }
	                
                //}
    
                // draw car
                if(isCar) {
                	car.drawCar(g);
                }
                else {
                	car.drawTruck(g);
                }
    
                g.setColor(Color.BLACK);
                g.setFont(new Font("Comic Sans", Font.PLAIN, 20)); 
                g.drawString("Obstacles Passed: " + obstaclesPassed() + " Lives: " + lives, 1100, 50);
                
            }
            else if(screen == 2){
                b1.drawBackgroundCrash(g);
                b1.drawTextCrash(g, lives);
            }
            else if(screen == 1){
                b1.drawStartScreen(g);
            }
            else{
                System.out.println("Error Screen");
            }
            // drawing must be written in code where pieces on the top layer are written last
        }
    }
    
	public void run() {
	
		for (Obstacle o : obstacles) {
			if (crash(car.getPoints(), o.getPoints())) {
				o.move();
				lives = lives - 1;
				screen = 2;
			}
		}
		
		for (PowerUp p : powers) {
			if (crash(car.getPoints(), p.getPoints())) {
				p.move();
				lives = lives + 1;
			}
		}
		
		repaint();
	}
	
	public void addObstacle(Obstacle o) {
		obstacles.add(o);
	}
	
	public void addPowerUp(PowerUp p) {
		powers.add(p);
	}
	
	public int obstaclesPassed() {
		passed = 0;
		for(Obstacle o : obstacles) {
			passed += o.getCounter();
		}
		return passed;
	}
	

	public boolean crash(ArrayList<Point> o1, ArrayList<Point> o2) {
		
		// make shallow copy of array to avoid concurrent modification
		o1 = (ArrayList<Point>)o1.clone();
		o2 = (ArrayList<Point>)o2.clone();
		
		for(Point p1 : o1) {
			for(Point p2 : o2) {
				if (p1.equals(p2)) {
					return true;
				}
			}
		}
		return false;
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
    }

    public static void main(String[] a) {
        JFrame f = new JFrame();
        Game g = new Game();
        f.setContentPane(g);
        f.setSize(1450, 750);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);
        Obstacle o1 = new Obstacle(1400, 500);
        Obstacle o2 = new Obstacle(1600 + 300, 650);
        g.addObstacle(o1);
        g.addObstacle(o2);
        
        PowerUp p1 = new PowerUp(2000, 550);
        g.addPowerUp(p1);

        //Timer timer = new Timer(2500 , new ActionListener(){
        //    public void actionPerformed(ActionEvent evt) {
        //        drawer = true;
        //    }});
        //timer.setRepeats(true);
        //timer.start();

        Sound music = new Sound();

        //music.playMusic("CIS_350_Term_Project/Tours-Enthusiast.wav");

        music.playMusic();
        g.addMouseMotionListener(g);
        while(isRunning) {
        	g.run();
        }
    }
}