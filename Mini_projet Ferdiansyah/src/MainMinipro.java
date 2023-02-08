
import org.newdawn.slick.*;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class MainMinipro {

	public static void main(String[] args) throws SlickException, UnsupportedAudioFileException, IOException, LineUnavailableException {
			// l'Audio
			File file = new File("Song.wav");
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.start();
			clip.loop(5);	
			
			// Basic Game
			AppGameContainer app = new AppGameContainer(new Connectors("connect Me"));
			app.setTargetFrameRate(60);
			app.setShowFPS(false);
			app.setDisplayMode(500,600,false); // taille + width + modifiable ou pas 
			app.start();
			
			
			
			
		
	}

}
