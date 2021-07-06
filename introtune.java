package javapokemon;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;


class Multi extends Thread{
  //YOU CAN RUN MULTIPLE THINGS AT THE SAME TIME WITH THREADS.... THIS IS SO COOOL
    public void run(){
//your code here
    	
   	 
		try {

			
			
			String song = "platinum.wav";// song file name as string
			
			
			File introtheme = new File(song); // song file as the variable introtheme in the program
			
			
			if(introtheme.exists()) {
				
				AudioInputStream play = AudioSystem.getAudioInputStream(introtheme);// song 
				
				Clip clip = AudioSystem.getClip();
				clip.open(play);
				
				clip.start();
				
		    // clip.loop(clip.LOOP_CONTINUOUSLY);// makes the opening credits theme play until it stops
			// JOptionPane.showMessageDialog(null, "Press okay to stop the intro theme!!!!"
			//		+ "\nPlatinum opening credits theme..... (In honor of Sinnoh remakes coming in 2021)");// user can stop credits 
				
		
				
		//		clip.close();
				
				
			//The song will end naturally
				
				
				return;
				
				
			}
			else {
				
				System.out.println("The music file can't be found!!");
			}
			
		}
		catch(Exception whatever) { // Catch any exception
			
			whatever.printStackTrace();// (is like whatever.getmessage())  (both output the error/exception)
			
			System.out.println("A glitch occures (Whoever created this is made an error lol)");
		}
		
		
           
        
        
    }
}

public class introtune  {   // a way I can play intro credits and theme at the same time?????
	
	public static void x() {
		
	   Multi t1 = new Multi();
	   t1.start();
	  
	   
	   
		
	}
	
			
			
		
}
