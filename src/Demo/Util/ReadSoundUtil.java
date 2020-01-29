package Demo.Util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class ReadSoundUtil extends Thread{
	static Player player;
	static String backgroundMusicPath;
	static String explodeSoundPath;
	static BufferedInputStream bis;
	public boolean isClosed=false;
	static {
		backgroundMusicPath="Sound/music/backgroundMusic.wav";
		explodeSoundPath="Sound/sound/explodeSound.wav";
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!isClosed) {
			try {
				bis=new BufferedInputStream(new FileInputStream(backgroundMusicPath));
//				bis=new BufferedInputStream(ReadSoundUtil.class.getResourceAsStream(backgroundMusicPath));
				player=new Player(bis);
				player.play();
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void loop() {
		isClosed=false;
		this.start();
	}
	
	public void close() {
		isClosed=true;
		player.close();
	}
	
}
