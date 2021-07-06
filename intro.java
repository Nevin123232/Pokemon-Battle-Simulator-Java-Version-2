package javapokemon;
import java.util.concurrent.TimeUnit;

import java.util.Scanner;
// imports sound stuff
  


// the place where I can put some start credits
     
public class intro {

	   
	//I want to use music and make a simple animation for intro credits. 
	 
	
	static Scanner input = new Scanner(System.in);
	public static void startcredits() throws Exception {
		
		 System.out.println("\nPlease turn on your sound........\n");
		 
		System.out.println("Would you like to skip the opening credits??? (Input 'yes' (without quotation marks if you would like to return to gameplay) ");
		
		
		
		String oof = input.nextLine();
		
		if( !(oof.equals("yes")) ) {
			
			System.out.println("Great.. You won't regret it....");
			
			
		}
		else {
			
			System.out.println("Okay... Returning you to gameplay.....");
			
			
			System.out.println(" ");
			
			System.out.println("The move bounce is still pretty buggy in the program....");
			
			System.out.println(" ");
			
			System.out.println("MAKE SURE TO TERMINATE PROGRAM OUTPUT BEFORE CLOSING THIS CONSOLE (to stop the music)....");
			
			System.out.println(" ");
			
			System.out.println("If you forget just close whatever IDE you're using to run this and the music will stop....");
			
			return;
		}
		
		  
		 introtune.x(); // plays intro theme as a new thread
		
		
		 

			
		 
		 TimeUnit.MILLISECONDS.sleep(6650);
		 
		
		

		System.out.println(" ########     ###########     #     #    ########     #            #   ###########   #      #        ");
		System.out.println(" #      #     #         #     #   #      #            # #         ##   #         #   # #    #      ");
		System.out.println(" #      #     #         #     # #        #            #  #       # #   #         #   #  #   #      ");
		System.out.println(" #      #     #         #     #          ########     #   #     #  #   #         #   #   #  #      ");
		System.out.println(" ########     #         #     # #        #            #    #   #   #   #         #   #    # #        ");
		System.out.println(" #            #         #     #   #      #            #     # #    #   #         #   #     ##        ");
		System.out.println(" #            ###########     #      #   ########     #      #     #   ###########   #      #           ");
		
		
		
		
		TimeUnit.MILLISECONDS.sleep(3000);
		
		System.out.println("");
		System.out.println("");
		
		
	
		
		System.out.println(" ######        #        ########   #######      #         ########                    ");
		System.out.println(" #    #       #  #         #          #         #         #              ");
		System.out.println(" #####       #    #        #          #         #         #               ");
		System.out.println(" #    #     ########       #          #         #         ########         ");
		System.out.println(" #    #    #        #      #          #         #         #                 ");
		System.out.println(" ######   #          #     #          #         #######   ########  ");
		
		
		
		System.out.println("                       ");
		 
		System.out.println("                       ");
		
		System.out.println("                       ");
		
		
		
		TimeUnit.MILLISECONDS.sleep(4000);
		
		

		System.out.println(" ######   #     #            #      #    #     #            #      #############  #########       ########                                 ");
		System.out.println(" #        #     # #         ##      #    #     #           #  #          #        #       #       #      #                     ");
		System.out.println(" #        #     #  #       # #      #    #     #          #    #         #        #       #       #      #           ");
		System.out.println(" ######   #     #   #     #  #      #    #     #         ########        #        #       #       ########         ");
		System.out.println("      #   #     #    #   #   #      #    #     #        #        #       #        #       #       #       #                   ");
		System.out.println("      #   #     #     # #    #      #    #     #       #          #      #        #       #       #        #               ");
		System.out.println(" ######   #     #      #     #      ######     ###### #            #     #        #########       #          #                       ");
		
		System.out.println("");
		
		 
		TimeUnit.MILLISECONDS.sleep(2000);
		
		
		System.out.println("    #########          #         ");
		System.out.println("            #         #  #        ");
		System.out.println("    #########        #    #        ");
		System.out.println("    #            #   #    #     ");
		System.out.println("    #########   ###   #  #                  ");
		System.out.println("                                ");
		
	 
		
		TimeUnit.MILLISECONDS.sleep(3375);
		
	
		System.out.println("                       "    + "             "       );
		System.out.println("  #  #       # #       "    + "             "     );
		System.out.println("   #   #   #  #        "    + "             "     );
		System.out.println("    #       #          "    + "             "      );
		System.out.println("   #  #   #  #         "    + "             "    );
		System.out.println("   #    #    #         "    + "             "        );
		System.out.println("    #  ###  #          "    + "             "     );
		System.out.println("       # #             "    + "             "          );
		System.out.println("                       "    + "             "              );
		
		
		
		
		TimeUnit.MILLISECONDS.sleep(3375);
		
			System.out.println("*******  WELCOME TO THE POKEMON BATTLE SIMULATOR: JAVA EDITION. ******");
			

			
			System.out.println("                       "    + "             "       );
			System.out.println("  #  #       # #       "    + "             "     );
			System.out.println("   #   #   #  #        "    + "             "     );
			System.out.println("    #       #          "    + "             "      );
			System.out.println("   #  #   #  #         "    + "             "    );
			System.out.println("   #    #    #         "    + "             "        );
			System.out.println("    #  ###  #          "    + "             "     );
			System.out.println("       # #             "    + "             "          );
			System.out.println("                       "    + "             "              );
			
			
			System.out.println("\n This application is a GREAT improvement to the last simulator I constructed......");
			
			
			
		
		System.out.println("          A second edition inspired by the one I made in C++ with different pokemon, new moves, and sound being used in the game            " );

		 TimeUnit.MILLISECONDS.sleep(5000);
		 
		System.out.println("\nThis one is much better and more efficient than that one..........\n");
  
		 TimeUnit.MILLISECONDS.sleep(5000);
		 System.out.println("   ");
		 
		 
		 System.out.println(" &&&&&&&&&      &&&&&&&&   &&&&&&&&  &&&&&&&&         &                                ");
	     System.out.println(" &              &      &      &          &           & &                             ");
	     System.out.println(" &  &&&&&&      &      &      &          &          &   &                             ");
	     System.out.println(" &       &      &      &      &          &         &&&&&&&                                ");
	     System.out.println(" &       &      &      &      &          &        &       &                               ");
	     System.out.println(" &&&&&&&&&      &&&&&&&&      &          &       &         &                                     ");
			
	     System.out.println("       ");
			
			
			
		System.out.println("PLEASE TURN ON SOUND......... (wait a few seconds for the music to begin)");
		
		 TimeUnit.MILLISECONDS.sleep(5000);
		 
		 System.out.println("   ");
		 
		 
		System.out.println("\nDISCLAIMER: Nevin didn't create pokemon or this music. I just think that they are both really cool.........");
		 
		
		 System.out.println("   ");
		 System.out.println("       ");
		 
		 System.out.println(" &&&&&&&&&         &        &&&&&&&&&&     &&&&&&&&     &        &                                                      ");
		 System.out.println(" &                & &           &          &            &        &                                    ");
		 System.out.println(" &               &   &          &          &            &        &                                     ");
		 System.out.println(" &              &&&&&&&         &          &            &&&&&&&&&&                                      ");
		 System.out.println(" &             &       &        &          &            &        &                                       ");
		 System.out.println(" &&&&&&&&&    &         &       &          &&&&&&&&     &        &                                                                ");
		 
		  
		 System.out.println("       ");
		 
		 TimeUnit.MILLISECONDS.sleep(5000);
		 
		 System.out.println("\nCreator of the Pokemon Battle Simulator(2 player): Java edition <<<(NEVIN NDONWI)>>>");
		 
			
		 System.out.println("       ");
		 
		 System.out.println("  &&&&&&&&&          &          &                                         ");
		 System.out.println("  &                  & &       &&                                             ");
		 System.out.println("  &                  &  &     & &                                         ");
		 System.out.println("  &&&&&&&&&          &   &   &  &                                          ");
		 System.out.println("  &                  &    & &   & ");
		 System.out.println("  &&&&&&&&&          &     &    &                                                      ");
		 
		 
		 
		 
		 System.out.println("       ");
		 
		 
		 
		 
		 TimeUnit.MILLISECONDS.sleep(5000);
		 
		 
			
		 System.out.println("       ");
		 
		 System.out.println("     &        &         &           ");
		 System.out.println("    & &       &         &               ");
		 System.out.println("   &   &      &         &");
		 System.out.println("  &&&&&&&     &         &                ");
		 System.out.println(" &       &    &         &                ");
		 System.out.println("&         &   &&&&&&&   &&&&&&               ");
		 
		
		 
		 
		 System.out.println("       ");
		 
		 
		 System.out.println("Amount of pokemon: 31,   Amount of moves: I stopped counting after 90......");
		
		 TimeUnit.MILLISECONDS.sleep(5000);
		 
		 System.out.println("\nCreator of pokemon: Satoshi Tajiri \nMusic Creator: Junichi Masuda, Go Ichinose, Morikazu Aoki");
	
		 
		 TimeUnit.MILLISECONDS.sleep(5000);
		 
		 System.out.println("Where I got the music downloads(mp3): "
		 		+ "\n(Hoenn themes) https://downloads.khinsider.com/game-soundtracks/album/pokemon-emerald-gameboy-advance-gamerip "
		 		+ "\n(Sinnoh themes) https://downloads.khinsider.com/game-soundtracks/album/pokemon-platinum"
		 		+ "\n(Unova themes) https://downloads.khinsider.com/game-soundtracks/album/pokemon-black-and-white "
		 		+ "Where I got sound effects:\nhttps://downloads.khinsider.com/game-soundtracks/album/pokemon-sfx-gen-3-attack-moves-rse-fr-lg/Slam.mp3 (slam and meteor mash)"
		 		+ "\nPokemon cries: https://play.pokemonshowdown.com/audio/cries/?C=D;O=A (Thanks pokemon showdown)");
		 
		 
		 System.out.println("\n");
		 
		 System.out.println("Here is the mp3 - wav converter I used for the themes and pokemon cries..."
		 		+ "\nhttps://cloudconvert.com/"
		 		+ "\nAnd https://convertio.co/download/4d33a124346963b68599e00c210c3d6b7635f2/ "
		 		+ "\nhttps://audio.online-convert.com/convert-to-wav");
		 
		 TimeUnit.MILLISECONDS.sleep(5000);
		 
		 System.out.println("\n");
		 
		 System.out.println(" Pokemon is really cool and is a useful way to learn object oriented programming");
		 
		 System.out.println("\nALL files in the program folder are needed to run the program (music files, class files etc.)");
		 
		 TimeUnit.MILLISECONDS.sleep(5000);
		 
		
		 System.out.println("\nALTHOUGH Nevin Ndonwi coded this simulation, he does not own pokemon or any of the music.\n.."
		 		+ "Nevin really likes pokemon and just wanted to try to emulate it through Java so that Nevin could "
		 		+ "get better at programming. ");
		 
		 
		 System.out.println("             ");
		 
		 
		  
		 System.out.println("                    @@@@@                                         ");
		 System.out.println("                @@@@@@@@@@@@                                  ");
		 System.out.println("           @@@@@@@@@@@@@@@@@@@@@                              ");
		 System.out.println("        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@                         ");
		 System.out.println("     @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@                     ");
		 System.out.println("   @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@                   ");
		 System.out.println("  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@                ");
		 System.out.println(" @@@@@@@@@@@@@@@@@@     @@@@@@@@@@@@@@@@@@@");
		 System.out.println(" @                 @   @                   @                         ");
		 System.out.println(" @                  @@@                   @                         ");
		 System.out.println("  @                                     @                          ");
		 System.out.println("   @                                   @                       ");
		 System.out.println("     @                               @                         ");
		 System.out.println("        @                          @                            ");
		 System.out.println("           @                     @                               ");
		 System.out.println("               @              @                                     ");
		 System.out.println("                   @     @    ");
		 
		 
		 
		 System.out.println("             ");
		 
		 
		 
		 
		 TimeUnit.MILLISECONDS.sleep(5000);
		 
		 System.out.println(" Thank you for playing this simulator, let me know at **nevinfonndonwi@gmail.com** if there are any bugs.....");
		 
		 System.out.println("\nhave fun, hope you win........");
		
		 TimeUnit.MILLISECONDS.sleep(5000);
		 
		 System.out.println("If you want, check out the version I made in C++ (It is extremely slow and an extremely big file) \n");
		   
		 TimeUnit.MILLISECONDS.sleep(5000);
		 
		 
		 
		 System.out.println("This theme is FIRE....\n");
		 

		 System.out.println("             ");
		 

		 System.out.println("         %%%%%%%    %%%%%%%    %%%%%%%%         %%%%%%%              ");
		 System.out.println("         %            %        %      %         %                  ");
		 System.out.println("         %            %        %      %         %          ");
		 System.out.println("         %            %        %      %         %        ");
		 System.out.println("         %%%%%%%      %        %      %         %          ");
		 System.out.println("         %            %        %%%%%%%%         %%%%%%%         ");
		 System.out.println("         %            %        %       %        %           ");
		 System.out.println("         %            %        %        %       %           ");
		 System.out.println("         %            %        %         %      %           ");
		 System.out.println("         %            %        %          %     %        ");
		 System.out.println("         %            %        %           %    %        ");
		 System.out.println("         %          %%%%%%%    %            %   %%%%%%         ");
		 
		 
		 
		 

		 System.out.println("             ");
		 
		 
		 
		 TimeUnit.MILLISECONDS.sleep(5000);
		 
		  
		
		 
		 
		 System.out.println("This project took about a months time, Google and Stackoverflow really helped,\n Nevin worked on and off for 3 months on this\n");
		 
		 
		 TimeUnit.MILLISECONDS.sleep(2500);
		 
		 System.out.println("This is how I learned Java lol......\n");
		 
         TimeUnit.MILLISECONDS.sleep(2500);
		 
		 System.out.println("NINTENDO PLEASE HIRE MEEEEEEEEE (pretty please????)......\n");
		 
		 TimeUnit.MILLISECONDS.sleep(2500);
		 
		 System.out.println("CREATORS OF POKEMON SHOWDOWN PLEASE HIRE MEEEEEEEEE (pretty please????)......\n");
		 
		 
		 TimeUnit.MILLISECONDS.sleep(3000);
		 
		 System.out.println("             ");
		 
		 System.out.println("  PPPPPPP    P          PPPPPPP             P               PPPPPPPPP   PPPPPPPP                                                                           ");
		 System.out.println("  P     P    P          P                  P  P             P           P                                                                ");
		 System.out.println("  P     P    P          p                 P    P            P           p                                                                ");
		 System.out.println("  P     P    P          P                P      P           P           P                                                                 ");
		 System.out.println("  PPPPPPP    P          P               P        p          P           P                                                                ");
		 System.out.println("  P          p          PPPPPPP        PPPPPPPPPPPP         PPPPPPPPP   PPPPPPPPP                                                                             ");
		 System.out.println("  P          P          P             P            P                P   P                                                               ");
		 System.out.println("  P          P          P            P              P               P   P                                                                ");
		 System.out.println("  P          P          P           P                P              P   P                                                                ");
		 System.out.println("  P          P          P          P                  P             P   P                                                                 ");
		 System.out.println("  P          PPPPPPPP   PPPPPPPP  P                    P    PPPPPPPPP   PPPPPPPPP                                                                                              ");
									
		
		 
		
		 
		 
		 
		 
		 System.out.println("             ");
		 TimeUnit.MILLISECONDS.sleep(2000);
		 
        System.out.println("             ");
		 
		
   	  
        System.out.println("    H      H        HHHHHHHHHHH     HHHHHHHH            HHHHHHHHH                      ");
        System.out.println("    H      H             H          H      H            H             ");
        System.out.println("    H      H             H          H      H            H                ");
        System.out.println("    H      H             H          H      H            H               ");
        System.out.println("    HHHHHHHH             H          HHHHHHHH            H          ");
        System.out.println("    H      H             H          H       H           HHHHHHHHH            ");
        System.out.println("    H      H             H          H        H          H         ");
        System.out.println("    H      H             H          H         H         H          ");
        System.out.println("    H      H             H          H          H        H       ");
        System.out.println("    H      H        HHHHHHHHHH      H           H       HHHHHHHHH              ");
		 
		
        TimeUnit.MILLISECONDS.sleep(2000);
		 
		
		 
		 
		 
		 
		 System.out.println("             ");
		 
		 System.out.println(" M                M              MMMMMMMM                   ");
		 System.out.println(" M M            M M              M         ");
		 System.out.println(" M   M         M  M              M                   ");
		 System.out.println(" M    M       M   M              MMMMMMMM                  ");
		 System.out.println(" M     M     M    M              M                  ");
		 System.out.println(" M      M  M      M              M                            ");
		 System.out.println(" M       M M      M              MMMMMMMM             ");
		
		 
		 
		 
		 
		 System.out.println("             ");
		 
		 
		 
		 System.out.println("But in all seriousness, Have a great time playing this sim \n");
		 
		   System.out.println("             ");
			 
			
		   	  
	        
		
			 
			
		 
		 
		 
		 
		 
		 
			
	}

	
}
