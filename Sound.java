package CIS_350_Term_Project;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Sound {
    void playMusic(){
        try{
            // Can cut out "src/" if doesn't work
            File musicPath = new File("src/CIS_350_Term_Project/Tours-Enthusiast.wav");

            if(musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            }else{
                System.out.println("Cant find file");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}


