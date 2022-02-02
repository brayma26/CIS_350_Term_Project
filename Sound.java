import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;

public class Sound {
    void playMusic(String musicLocation){
        try{
            File musicpath = new File(musicLocation);

            if(musicpath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicpath);
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

    public static void main(String[] args) {
        String filepath = "Tours-Enthusiast.wav";

        Sound musicObj = new Sound();
        musicObj.playMusic(filepath);
    }
}


