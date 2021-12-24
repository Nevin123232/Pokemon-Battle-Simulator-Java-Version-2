package javapokemon;

import java.io.File;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

import javax.sound.sampled.Clip;

import java.util.Scanner;
public class soundeffects {

	//(add more music), (add the pokemon cries), add pokemon getting hit, add stats rising and falling sounds 
	// sound effects 
	  
	
	//(add more music), (add the pokemon cries), add pokemon getting hit, add stats rising and falling sounds 
		// sound effects 
	static Scanner scan = new Scanner(System.in);
		public static void resist() {
			
			 
			try {

				
				
				String song = "resist.wav";// song file name as string
				
				
				File noise = new File(song); // song file as the variable resist in the program
				
				
				if(noise.exists()) {
					
				
					
					AudioInputStream player = AudioSystem.getAudioInputStream(noise);// song 
					
					Clip clip = AudioSystem.getClip();
					clip.open(player); // clip uses audio input stream
					
					clip.start();
					
					//   clip.loop(clip.LOOP_CONTINUOUSLY);// makes the opening credits theme play until it stops

				}
				else {
					
					System.out.println("The music file can't be found!!");
				}
				
			}
			catch(Exception whatever) { // Catch any exception
				
				whatever.printStackTrace();// (is like whatever.getmessage())  (both output the error/exception)
				
				System.out.println("A glitch occured");
			}
			
			
		}
		
		public static void noo() {
			
			 
			try {

				
				
				String song = "attack.wav";// song file name as string
				
				
				File noise = new File(song); // song file as the variable resist in the program
				
				
				if(noise.exists()) {
					
				
					
					AudioInputStream player = AudioSystem.getAudioInputStream(noise);// song 
					
					Clip clip = AudioSystem.getClip();
					clip.open(player); // clip uses audio input stream
					
					clip.start();
					
					//   clip.loop(clip.LOOP_CONTINUOUSLY);// makes the opening credits theme play until it stops
				
					
				}
				else {
					
					System.out.println("The music file can't be found!!");
				}
				
			}
			catch(Exception whatever) { // Catch any exception
				
				whatever.printStackTrace();// (is like whatever.getmessage())  (both output the error/exception)
				
				System.out.println("A glitch occured");
			}
			
			
		}
		public static void attack() {
			
			 
			try {

				
				
				String song = "effective.wav";// song file name as string
				
				
				File noise = new File(song); // song file as the variable resist in the program
				
				
				if(noise.exists()) {
					
				
					
					AudioInputStream player = AudioSystem.getAudioInputStream(noise);// song 
					
					Clip clip = AudioSystem.getClip();
					clip.open(player); // clip uses audio input stream
					
					clip.start();
					
				
				}
				else {
					
					System.out.println("The music file can't be found!!");
				}
				
			}
			catch(Exception whatever) { // Catch any exception
				
				whatever.printStackTrace();// (is like whatever.getmessage())  (both output the error/exception)
				
				System.out.println("A glitch occured");
			}
			
			
		}
		
		
		
		
		
	public static void cry(pokemon pokemon) {
		
		 
		try {

			
			
			String song = pokemon.call;// song file name as string
			
			
			File noise = new File(song); // song file as the variable endtheme in the program
			
			
			if(noise.exists()) {
				
			
				
				AudioInputStream player = AudioSystem.getAudioInputStream(noise);// song 
				
				Clip clip = AudioSystem.getClip();
				clip.open(player); // clip uses audio input stream
				
				clip.start();
				
				//   clip.loop(clip.LOOP_CONTINUOUSLY);// makes the opening credits theme play until it stops
				
			}
			else {
				
				System.out.println("The music file can't be found!!");
			}
			
		}
		catch(Exception whatever) { // Catch any exception
			
			whatever.printStackTrace();// (is like whatever.getmessage())  (both output the error/exception)
			
			System.out.println("A glitch occured");
		}
		
		
	}
	
		
		
	public static void levelupnoise() {
		
		 
		try {

			
			
			String song = "effect.wav";// song file name as string
			
			
			File noise = new File(song); // song file as the variable endtheme in the program
			
			
			if(noise.exists()) {
				
			
				
				AudioInputStream player = AudioSystem.getAudioInputStream(noise);// song 
				
				Clip clip = AudioSystem.getClip();
				clip.open(player); // clip uses audio input stream
				
				clip.start();
				
				//   clip.loop(clip.LOOP_CONTINUOUSLY);// makes the opening credits theme play until it stops
				
			}
			else {
				
				System.out.println("The music file can't be found!!");
			}
			
		}
		catch(Exception whatever) { // Catch any exception
			
			whatever.printStackTrace();// (is like whatever.getmessage())  (both output the error/exception)
			
			System.out.println("A glitch occured");
		}
		
		
	}
	

    
    
    
  
    
    
    
    public static void drop() {
		
		 
  		try {

  			
  			
  			String song = "statdrop.wav";// song file name as string
  			
  			
  			File noise = new File(song); // song file as the variable resist in the program
  			
  			
  			if(noise.exists()) {
  				
  			
  				
  				AudioInputStream player = AudioSystem.getAudioInputStream(noise);// song 
  				
  				Clip clip = AudioSystem.getClip();
  				clip.open(player); // clip uses audio input stream
  				
  				clip.start();
  				
  				//   clip.loop(clip.LOOP_CONTINUOUSLY);// makes the opening credits theme play until it stops
  					
  				
  				
  			}
  			else {
  				
  				System.out.println("The music file can't be found!!");
  			}
  			
  		}
  		catch(Exception whatever) { // Catch any exception
  			
  			whatever.printStackTrace();// (is like whatever.getmessage())  (both output the error/exception)
  			
  			System.out.println("A glitch occured");
  		}
  		
  		
  	}
  	
    
    
    
    public static void statincrease() {
		
		 
  		try {

  			
  			
  			String song = "statrise.wav";// song file name as string
  			
  			
  			File noise = new File(song); // song file as the variable resist in the program
  			
  			
  			if(noise.exists()) {
  				
  			
  				
  				AudioInputStream player = AudioSystem.getAudioInputStream(noise);// song 
  				
  				Clip clip = AudioSystem.getClip();
  				clip.open(player); // clip uses audio input stream
  				
  				clip.start();
  				
  				//   clip.loop(clip.LOOP_CONTINUOUSLY);// makes the opening credits theme play until it stops
  				
  				
  			}
  			else {
  				
  				System.out.println("The music file can't be found!!");
  			}
  			
  		}
  		catch(Exception whatever) { // Catch any exception
  			
  			whatever.printStackTrace();// (is like whatever.getmessage())  (both output the error/exception)
  			
  			System.out.println("A glitch occured");
  		}
  		
  		
  	}
  	
    
    
    
    public static void heal() {
		
		 
  		try {

  			
  			
  			String song = "heal.wav";// song file name as string
  			
  			
  			File noise = new File(song); // song file as the variable resist in the program
  			
  			
  			if(noise.exists()) {
  				
  			
  				
  				AudioInputStream player = AudioSystem.getAudioInputStream(noise);// song 
  				
  				Clip clip = AudioSystem.getClip();
  				clip.open(player); // clip uses audio input stream
  				
  				clip.start();
  				
  				//   clip.loop(clip.LOOP_CONTINUOUSLY);// makes the opening credits theme play until it stops
  				
  			}
  			else {
  				
  				System.out.println("The music file can't be found!!");
  			}
  			
  		}
  		catch(Exception whatever) { // Catch any exception
  			
  			whatever.printStackTrace();// (is like whatever.getmessage())  (both output the error/exception)
  			
  			System.out.println("A glitch occured");
  		}
  		
  		
  	}
  	
    
    
    public static void frozen() {
		
		 
  		try {

  			
  			
  			String song = "frozen.wav";// song file name as string
  			
  			
  			File noise = new File(song); // song file as the variable resist in the program
  			
  			
  			if(noise.exists()) {
  				
  			
  				
  				AudioInputStream player = AudioSystem.getAudioInputStream(noise);// song 
  				
  				Clip clip = AudioSystem.getClip();
  				clip.open(player); // clip uses audio input stream
  				
  				clip.start();
  				
  				//   clip.loop(clip.LOOP_CONTINUOUSLY);// makes the opening credits theme play until it stops
  				
  				
  			}
  			else {
  				
  				System.out.println("The music file can't be found!!");
  			}
  			
  		}
  		catch(Exception whatever) { // Catch any exception
  			
  			whatever.printStackTrace();// (is like whatever.getmessage())  (both output the error/exception)
  			
  			System.out.println("A glitch occured");
  		}
  		
  		
  	}
  	
  	
    
    
    
    public static void burned() {
		
		 
  		try {

  			
  			
  			String song = "burned.wav";// song file name as string
  			
  			
  			File noise = new File(song); // song file as the variable resist in the program
  			
  			
  			if(noise.exists()) {
  				
  			
  				
  				AudioInputStream player = AudioSystem.getAudioInputStream(noise);// song 
  				
  				Clip clip = AudioSystem.getClip();
  				clip.open(player); // clip uses audio input stream
  				
  				clip.start();
  				
  				
  			
  			}
  			else {
  				
  				System.out.println("The music file can't be found!!");
  			}
  			
  		}
  		catch(Exception whatever) { // Catch any exception
  			
  			whatever.printStackTrace();// (is like whatever.getmessage())  (both output the error/exception)
  			
  			System.out.println("A glitch occured");
  		}
  		
  		
  	}
  	
  	
      
    
    
    
    
    public static void poisoned() {
		
		 
  		try {

  			
  			
  			String song = "poisoned.wav";// song file name as string
  			
  			
  			File noise = new File(song); // song file as the variable resist in the program
  			
  			
  			if(noise.exists()) {
  				
  			
  				
  				AudioInputStream player = AudioSystem.getAudioInputStream(noise);// song 
  				
  				Clip clip = AudioSystem.getClip();
  				clip.open(player); // clip uses audio input stream
  				
  				clip.start();
  				
  				//   clip.loop(clip.LOOP_CONTINUOUSLY);// makes the opening credits theme play until it stops
  			
  			}
  			else {
  				
  				System.out.println("The music file can't be found!!");
  			}
  			
  		}
  		catch(Exception whatever) { // Catch any exception
  			
  			whatever.printStackTrace();// (is like whatever.getmessage())  (both output the error/exception)
  			
  			System.out.println("A glitch occured");
  		}
  		
  		
  	}
  	
  	
      
    
    
    public static void paralyze() {
		
		 
		try {

			
			
			String song = "paralyzed.wav";// song file name as string
			
			
			File noise = new File(song); // song file as the variable resist in the program
			
			
			if(noise.exists()) {
				
			
				
				AudioInputStream player = AudioSystem.getAudioInputStream(noise);// song 
				
				Clip clip = AudioSystem.getClip();
				clip.open(player); // clip uses audio input stream
				
				clip.start();
				
			
				
			}
			else {
				
				System.out.println("The music file can't be found!!");
			}
			
		}
		catch(Exception whatever) { // Catch any exception
			
			whatever.printStackTrace();// (is like whatever.getmessage())  (both output the error/exception)
			
			System.out.println("A glitch occured");
		}
		
		
	}
	
	
    


}

