package javapokemon;

import java.io.File;  


import java.io.FileWriter;
import java.io.PrintWriter;
// imports scanner class (for user input) , random class (for pokemon random hijinx) 
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
 
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.security.SecureRandom;




// Please brace yourself for the mess that is my comments and code
   
// time stuff (how to delay printing) 

 
// This is where we get all the inputs

public class userlanguage extends Thread{ // this is the main file , makes threads work
	 
	
	// volatile variables indicate that the variables can be used between threads
	// static variables indicate that the variables can be used between functions in the same class
	
	
	static volatile boolean endfireredtune = false; // try to end victory road theme that plays when the players are choosing their pokemon (shows whether the tune is played or not)
	
	
	static volatile boolean endbattletune = false; // try to end battle tune (shows whether the tune is played or not)
	
	static volatile boolean endvictorytune = false;// end the victory tune at the end 
	
	// volatile means it can be used between threads, static makes it used between functions/methods in this class
	
	static Scanner scan = new Scanner(System.in); // makes a new scanner called scan , it is static meaning that it is used in every function in this java file 

	static int songchoice = 0; // used in determining which song file to play during the battle
	
	public static boolean legitimizer() { // Checks if the language is legit 
    	
		Boolean legit = null; 
		
		

			
	    System.out.println(" Input the language you speak (input 'english' or 'e' or 'french' or'f') \n");
		String test = scan.nextLine(); // language variable
			
   while (legit == null) { //making a while loop
	    if (test.equals("e")) { // Use .equals instead of == 
	    	
	    	test = "english";
	    	System.out.println("Your language, " + test + " has been inputted. \n");
	    	legit = true;
	    	
	    }
	    else if (test.equals("english")) {
		    	
	    	test = "english";
	    	System.out.println("Your language, " + test + " has been inputted.\n");
	    	legit = true;
	    	
		}
	    else if (test.equals("french")) {
	    	
	    	test = "french";
	    	System.out.println("Your language, " + test + " has been inputted.\n");
	    	legit = false;
	    	
		}
	    else if (test.equals("f"))  {
	    	
	    	test = "french";
	    	System.out.println("Your language, " + test + " has been inputted.\n");
	    	legit = false;
	    	
	    }
	    else {
	    System.out.println("Input a legit language ! \n");
	    
	    System.out.println(" Input the language you speak (input 'english' or 'e' or 'french' or'f') (Those are the only languages supported by this version) \n");
		 test = scan.nextLine();
	    }
	    	
	    	
   }
		
		
		
		
			
		  
		
    return legit;
		
    	
	}
    
    
    public static boolean testpokemonname(String pokemonname) { // tests if the pokemon name is legit 
    	
    	boolean poke = false;
    	String[] possiblepokemon = {"metagross", "gliscor", "excadrill", "arcanine", "krookodile", "feraligatr", "gyarados",
				"starmie", "gengar", "espeon", "jolteon", "glaceon", "archeops",
				"umbreon", "leafeon", "vaporeon", "flareon", "sylveon", "scizor", "hydreigon",
				"meloetta", "crobat", "manaphy", "jirachi", "melmetal", "machamp", "milotic",
				"kingdra", "salamence", "dragonite", "chandelure", "greninja",
				"zeraora", "togekiss", "volcarona",
				"pikachu", "mimikyu"};
    	String[] abbreviated = {"met", "gli", "exc" , "arc" , "kro" , "fer", "gya",
				"sta" , "gen" , "esp", "jol", "gla", "arch",
				"umb", "lea", "vap", "fla", "syl", "sci", "hyd",
				"mel", "cro", "man", "jir", "mml", "mac", "mil",
				"kdr", "sal", "dra", "chan", "gren",
				"zera", "toge", "volc",
				"pika", "mimi"};
    	// 53 pokemon are in the possible pokemon array      (53 is the new endgoal)                                                                                                                      "manaphy", "jirachi", "melmetal", "machamp", "milotic", "kingdra", "salamence", "dragonite", "chandelure"};
    	
    	for(int i = 0; i < abbreviated.length; i++) {
    		
    		if (abbreviated[i].equals(pokemonname)){
    			poke = true;
    			break;
    		}
            if (possiblepokemon[i].equals(pokemonname)){
    			poke = true;
    			break;
    		}
    	}
        
    	
    	return poke;
    }
    
    
    
    
    
    public static String getpokemonname(String player) { // getting the names of the pokemon //player is whether its player 1 or player 2
    	
    	
    	String pokemon = "met"; 
    	System.out.println("\n Input a pokemon or an abbreviation of a pokemon's name. All pokemon are at level 100. " + player );
    	String[] possiblepokemon = {"metagross", "gliscor", "excadrill", "arcanine", "krookodile", "feraligatr", "gyarados", "starmie", "gengar", "espeon", "jolteon", "glaceon", "archeops", "umbreon",
				"leafeon", "vaporeon", "flareon", "sylveon", "scizor",
				"hydreigon", "meloetta", "crobat", "manaphy", "jirachi", "melmetal",
				"machamp", "milotic", "kingdra", "salamence", "dragonite",
				"chandelure",
				"greninja",
				"zeraora", "togekiss", "volcarona",
				"pikachu", "mimikyu"};
    	String[] abbreviated = {"met", "gli", "exc" , "arc" , "kro" , "fer", "gya", "sta" , "gen" , "esp", "jol", "gla", "arch", "umb",
				"lea", "vap", "fla", "syl", "sci",
				"hyd", "mel", "cro", "man", "jir", "mml",
				"mac", "mil", "kdr", "sal", "dra",
				"chan",
				"gren",
				"zera", "toge", "volc",
				"pika", "mimi"};
    	String[] pokemonexplanations = {"[Metagross is a steel psychic pokemon. It has very notable attack and defense, has clearbody ability] ", "[gliscor is a ground-flying pokemon who is well known for having a great attack and defense (has hypercutter)]  ", " [excadrill is  ground-steel pokemon  who can hit every pokemon (Except flying mons) with earthquake (has moldbreaker ability)]", "[arcanine is a loyal fire pokemon who can burn opponents on a whim and heal with morning sun (has intimidate ability) ]","[A savage street dark-ground croc ready to hit hard (has intimidate ability)]", "[A water aligator pokemon who hits harder with sheerforce (has sheer force ability)]", "[A savage pokemon who learns more dragon moves then flying moves but is still water-flying type lol (has intimidate ability) ] ","[An alien star pokemon that is water-psychic type (has magic bounce ability)]", "[An ectoplasmic toxic being (ghost poison) who levitates to flex on pokemon with earthquake (has levitate ability) ]", "[A psychic evolution of eevee (I gave it magic bounce in this simulator) ]", "[A speedy electric type, (I gave it quick feet for the pun)]", "[glaceon is a really coool ice pokemon (I gave it magic bounce so that it could be good) ]", "[ Archeops is a prehistoric rock-flying pokemon that hits hard (I got rid of deafeatist and gave it solid rock)]", "[unbreon is annoying to battle, you will hate it lol, is dark type (has magic bounce) ] ",
				"[ Leafeon is a grass pokemon that has great defenses so I gave it stamina because I hate leaf guard]", "[This pokemon lives for a long time and is water type (I gave it water absorb)]", "[A powerful physical fire type attacker that hits hard its the guts ability]  ", "[a beautiful fairy pokemon that uses pixilate to power up normal moves] ", "[a powerful steel bug pokemon that is really powerful with stab technician bulletpunch]",
				"[An awesome three headed dark dragon pokemon with levitate]", "[A mythical pokemon with serene grace and is based on music who can use relic song to become a speedy normal-fighting type (starts of as normal-psychic type) ]" , "[ A reliable bat sniper ready to help you out; poison,flying, has inner focus ability]", "[A baby water pokemon that is cute until it tail glows, I gave it the serenegrace ability for lols]", "[ A baby steel-psychic pokemon that is cute until it para-flinches you with serenegrace]", "[A big boi basher who hits hard with the double iron bash and ironfist]",
				"[The most well known fighting type pokemon (aside from lucario) that hits all of its move with no guard]", "[A beautiful water type sea serpent that can get higher defenses when it has a status condition]", "[A seahorse (dragon-water) that is as strong as royalty, crits harder with sniper]",  "[A dragon-flying type that is savage, has intimidate]", "[Another dragon-flying type but it has extremespeed and multiscale]",
				"[A chandelier fire-ghost pokemon that snipes with fire and burns opponents with flame body]",
				"[my favorite pokemon of all time, with the ability protean it can be any type it wants, a ninja beast]",
				"[A mythical electric beast, super fast and super overpowered]", "[An angelic creature capable of the most evil battle strategies]", "[An overpowered bug buzzer, ha ha quiver dance go brrrrr]",
				"[The mascot of pokemon, everyone knows who this is, holds light ball and hits hard with volttackle]", "[The pikachu-wannabe, despite being better, it is jealous of pikachu, disguise + swordsdance goes crazy tho]"
				};
    	
    	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
    	// 53 pokemon are in the possible pokemon array (the new end goal)
    	  
    	// teambuilder.nextLine() vs teambuilder.next(); (reads the input) 
    	for (int i = 0; i < abbreviated.length; i++) {
    		
    		System.out.println(i + 1 + ". " + possiblepokemon[i] + "   " + abbreviated[i] + "   " + pokemonexplanations[i] + " \n");
    		
    	
    	}
    	
    	System.out.println("\n Input a pokemon or an abbreviation of a pokemon's name " + player );
              pokemon = scan.nextLine();
    	
    
    	
    	while(testpokemonname(pokemon) != true) {
    		
        	for (int i = 0; i < abbreviated.length; i++) {
        		
        		System.out.println(i + 1 + ". " + possiblepokemon[i] + "   " + abbreviated[i] + "   " + pokemonexplanations[i] + " \n");
        		
        	
        	}
        	
        	System.out.println("\n Input a legitimate pokemon or an abbreviation of a pokemon's name " + player + ".\n");
            pokemon = scan.nextLine(); 
        	
    		
    		
    		
    	}
    	
        for (int o = 0; o < abbreviated.length; o++) {
    		
    		if(pokemon.equals(abbreviated[o])){
    			
    			pokemon = possiblepokemon[o];
    		}
    		
    	
    	}
    	
    	
    	System.out.println("\n " + player + " has chosen a " + pokemon);
    	 
    	
    	
    	return pokemon; 
    	
    	
    	
    }
    
    
    
    
    // makes a new pokemon object
    
    public static pokemon getpokemon(String pokename, String player) {
    	
        pokemon poke = new pokemon();
    	
    	
    	poke.attack = poke.getattack(pokename);
		poke.hp = poke.gethp(pokename);
		poke.speed = poke.getspeed(pokename);
		poke.def = poke.getdefense(pokename);
		poke.spdef = poke.getspecialdefense(pokename);
		poke.spa = poke.getspecialattack(pokename);
		poke.ability = poke.getability(pokename);
		poke.abilityexplain = poke.getabilityexplain(pokename);
		poke.type1 = poke.gettype1(pokename);
		poke.type2 = poke.gettype2(pokename);
	    
		poke.call = poke.getcall(pokename);
		poke.pokename = pokename;
        poke.move1name = poke.getmovename(player, pokename);
		poke.move2name = poke.getmovename(player, pokename, poke.move1name);
		poke.move3name = poke.getmovename(player, pokename, poke.move1name, poke.move2name);
		poke.move4name = poke.getmovename(player, pokename, poke.move1name, poke.move2name, poke.move3name);
	
    	return poke;
    	
    	
    }
    
    public static move getmoves(String movename, String player) {
    	
    	move testmove = new move();
    	
    	testmove.movename = testmove.getmovename(movename); // ties the movename variable to the movename attribute of the movename object
    	
    	testmove.accuracy = testmove.getaccuracy(movename);   // gets the move accuracy
    	
    	testmove.critrate = testmove.getcritrate(movename); // gets move crit rate
    	
    	testmove.effectchance = testmove.geteffectchance(movename); // gets the chance of an effect
    	
    	testmove.priority = testmove.getpriority(movename); // gets the priority 
    	
    	testmove.power = testmove.getpower(movename); // gets the amount of damage the move does
    	
    	testmove.attacktype = testmove.getattacktype(movename); // returns sp (special), ph (physical), se(Set up) , or St (Status)
    	
    	testmove.movetype = testmove.getmovetype(movename, player); // gets the elemental type the move is (water, fire, grass, etc.)
    	
    	
    	
    	return testmove;
    	
    }
    
   
  
    
    public static boolean movechecker(String[] possiblemoves, String name) {

    	// checks if a player's moves are legit (if it is within the moves they chose) 
    	boolean test = false;
    	
    	for (int p = 0; p < possiblemoves.length; p++) {
    		
    		if ( (name.equals("0"))  || (name.equals("1")) || (name.equals("2")) || (name.equals("3")) ) {
    			
    			test = true; 
    			break;
    		}
    	}
    	
    	
    	return test;
    	
    }
    
    
 //function built to check user's song input
	public static boolean songlegitimizer(String input){

		try{

			if(input.equals("s") || input.equals("r") || ((Integer.parseInt(input) < 10) && (Integer.parseInt(input) > 0))) {

				return true; //input is legit
			}
			else{
				return false; //input is not legit
			}
		}
		catch(Exception x){

			System.out.println("Your previous input was invalid, please try again!!\n");
			return false; //input is not legit

		}

	};
	public static void main(String[] args) {


		try {

			intro.startcredits(); // goes to opening credits function

		} catch (Exception e1) {

			e1.printStackTrace();
			System.out.println("Error occured, main credits skipped.....");
		} // goes to start credits and plays music...








			System.out.println("\nPress enter to start playing the game........\n");
			scan.nextLine();


			play(); // starts firered victory road theme i hope


			System.out.println("It is time for the battle to begin, Choose your pokemon wisely player 1 and player 2 \n");


			System.out.println("\n\n\n\n\n\n");
			System.out.println("Player 1, please input your name.  / Joueur 1 typez votre nom");
			String player1name = scan.nextLine();    // Gets the names of the players do they can be filed later
			System.out.println("Player 2, please input your name.  / Joueur 2 typez votre nom");
			String player2name = scan.nextLine();        // Gets the names of the players do they can be filed later


			Boolean rick = legitimizer(); // if it is true then its in english, if rick is false then its french
			String player1pokename = "null";
			String player2pokename = "null";// initializing two strings
			if (rick == true) { // if the player speaks english

				System.out.println("Good this game is available in english");

				System.out.println("\nWhat music would you like as your battle theme?\n"); //asking the user for what song they want

				System.out.println("Here are your choices:\n\n" +
						"- [input 1] for the gen 5 pokemon world championships theme.\n" +
						"- [input 2] for is a mashup of hugh's theme.\n" +
						"- [input 3] for  wally's ORAS theme.\n" +
						"- [input 4] for the trainer theme mashup of various kanto/jhoto games.\n" +
						"- [input 5] for silver's fight theme (jhoto pokemon rival theme) (mashup).\n" +
						"- [input 6] for an ace attorney theme.\n" +
						"- [input 7] for cynthia's PWT theme.\n" +
						"- [input 8] for megalovania (from undertale).\n" +
						"- [input 9] for the PWT final round theme.\n" +
						"- [input s] for a surprise theme.\n" +
						"- [input r] for a random theme. (one of the above options chosen randomly by the computer.\n"
				);
				String songinput = scan.nextLine(); //gets input 1,2,3,4,5,6,7,8,9,s,r

				while (songlegitimizer(songinput) == false) {

					System.out.println("Your previous input was invalid");

					System.out.println("\nWhat music would you like as your battle theme?\n"); //asking the user for what song they want

					System.out.println("Here are your choices:\n\n" +
							"- [input 1] for the gen 5 pokemon world championships theme.\n" +
							"- [input 2] for is a mashup of hugh's theme.\n" +
							"- [input 3] for  wally's ORAS theme.\n" +
							"- [input 4] for the trainer theme mashup of various kanto/jhoto games.\n" +
							"- [input 5] for silver's fight theme (jhoto pokemon rival theme) (mashup).\n" +
							"- [input 6] for an ace attorney theme.\n" +
							"- [input 7] for cynthia's PWT theme.\n" +
							"- [input 8] for megalovania (from undertale).\n" +
							"- [input 9] for the PWT final round theme.\n" +
							"- [input s] for a surprise theme.\n" +
							"- [input r] for a random theme. (one of the above options chosen randomly by the computer.\n"
					);
					songinput = scan.nextLine(); //gets input 1,2,3,4,5,6,7,8,9,s,r


				}

				//determine the value of songchoice integer variable (convert to nummber for later use

				try {

					songchoice = Integer.parseInt(songinput) - 1; //user inputs a value one more than the position of the array of songs
				} catch (Exception ex) {

					if (songinput.equals("s")) {

						songchoice = 9;
					} else if (songinput.equals("r")) {

						SecureRandom songchooser = new SecureRandom(); //random objectdeclaration

						songchoice = songchooser.nextInt(10); //randomly picks a song (a number between 0 and 9 which will be used in the array later
					}
				}


				player1pokename = getpokemonname("player 1"); // getting the names of the pokemon that player 1 and player 2 want
				player2pokename = getpokemonname("player 2");


				System.out.println(player1pokename + " was chosen by player 1 and  " + player2pokename + " was chosen by player 2. \n");


			} else { // if the player speaks french

				System.out.println("\n French is still being inputted in the main program mainframe lol \n");
				System.exit(0); // ends program early because french isn't inputted in this program yet lol...
			}


			// gets a pokemon's stats
			String ree = " player 1 ";
			pokemon player1pokemon = getpokemon(player1pokename, ree);

			soundeffects.cry(player1pokemon);

			// code a way to get the move objects (based on the move names)

			player1pokemon.move1 = getmoves(player1pokemon.move1name, ree);   // gets the first move object for player1

			player1pokemon.move2 = getmoves(player1pokemon.move2name, ree);   // gets the second move object for player 1

			player1pokemon.move3 = getmoves(player1pokemon.move3name, ree);   // gets the third move object  for player 1

			player1pokemon.move4 = getmoves(player1pokemon.move4name, ree);    // gets the fourth move object  for player 1


			System.out.println("Player 1's " + player1pokename + " has been initialized with the stats (For a level 100 pokemon (based on pokemondb.net)");
			System.out.println("* HP: " + player1pokemon.hp);
			System.out.println("* Attack: " + player1pokemon.attack);
			System.out.println("* Defense: " + player1pokemon.def);
			System.out.println("* Special Defense: " + player1pokemon.spdef);
			System.out.println("* Special Attack: " + player1pokemon.spa);
			System.out.println("* Speed: " + player1pokemon.speed);
			System.out.println("\n");
			System.out.println("* Ability: " + player1pokemon.ability + "   : (If the ability doesn't match the actual pokemon game ability then it is because I hated the actual ability and replaced it.) ");
			System.out.println("* " + player1pokemon.abilityexplain);
			System.out.println("* Type1: " + player1pokemon.type1);
			System.out.println("* Type2: " + player1pokemon.type2 + "  (the word 'null' just means that it doesn't have a second type)");

			System.out.println("\n Player 1's " + player1pokename + " has the moves: ");
			System.out.println("- " + player1pokemon.move1name);
			System.out.println("- " + player1pokemon.move2name);
			System.out.println("- " + player1pokemon.move3name);
			System.out.println("- " + player1pokemon.move4name);


			System.out.println("\n \n");

			soundeffects.levelupnoise(); // plays a sound effect

			System.out.println("\n Press enter to continue so that player 2 can choose their pokemon............ \n");
			scan.nextLine();// this is so the player can pause and see their pokemon ability, type and stats.


			String eer = " player 2 ";
			pokemon player2pokemon = getpokemon(player2pokename, eer);

			soundeffects.cry(player2pokemon);
			// code a way to get the pokemon move objects (based on the move names)


			// code a way to get the move objects (based on the move names)

			player2pokemon.move1 = getmoves(player2pokemon.move1name, ree);   // gets the first move object for player2

			player2pokemon.move2 = getmoves(player2pokemon.move2name, ree);   // gets the second move object for player 2

			player2pokemon.move3 = getmoves(player2pokemon.move3name, ree);   // gets the third move object  for player 2

			player2pokemon.move4 = getmoves(player2pokemon.move4name, ree);    // gets the fourth move object  for player 2


			System.out.println("Player 2's " + player2pokename + " has been initialized with the stats (For a level 100 pokemon (based on pokemondb.net)");
			System.out.println("* HP: " + player2pokemon.hp);
			System.out.println("* Attack: " + player2pokemon.attack);
			System.out.println("* Defense: " + player2pokemon.def);
			System.out.println("* Special Defense: " + player2pokemon.spdef);
			System.out.println("* Special Attack: " + player2pokemon.spa);
			System.out.println("* Speed: " + player2pokemon.speed);
			System.out.println("\n");
			System.out.println("* Ability: " + player2pokemon.ability + "   : (If the ability doesn't match the actual pokemon game ability then it is because I hated the actual ability and replaced it.) ");
			System.out.println("* " + player2pokemon.abilityexplain);
			System.out.println("* Type1: " + player2pokemon.type1);
			System.out.println("* Type2: " + player2pokemon.type2 + "    (the word 'null' just means that it doesn't have a second type)");


			System.out.println("\n Player 2's " + player2pokename + " has the moves: ");
			System.out.println("- " + player2pokemon.move1name);
			System.out.println("- " + player2pokemon.move2name);
			System.out.println("- " + player2pokemon.move3name);
			System.out.println("- " + player2pokemon.move4name);


			//  System.out.println(player2pokemon.move1.movetype); // this outputs the move type of the move attribute of the pokemon class


			System.out.print("Press enter to continue............ "); // waits so that the players can see the pokemon and moves that they have chosen
			scan.nextLine();


			soundeffects.levelupnoise(); // plays a sound effect


			System.out.println(" \n Battle sequence initiated \n");
			// make an if statement based on the language (legit true or false )


			// make sure to close the scanner at the end of this simulator lol. (Do i have to close it if it is a static scanner?????)


			// Battle sim based on the moves in the battle sequence


			player1pokemon.maxhp = player1pokemon.hp;
			player2pokemon.maxhp = player2pokemon.hp;


//		PART OF A TEST

			endfireredtune = true;


			// try to end song


			while (player1pokemon.hp > 0 && player2pokemon.hp > 0) {


				//            [    Player 1's turn    ]


				// array of move names
				String player1movenames[] = {player1pokemon.move1name, player1pokemon.move2name, player1pokemon.move3name, player1pokemon.move4name};

				String player2movenames[] = {player2pokemon.move1name, player2pokemon.move2name, player2pokemon.move3name, player2pokemon.move4name};


				// array of move objects
				move player1moves[] = {player1pokemon.move1, player1pokemon.move2, player1pokemon.move3, player1pokemon.move4};

				move player2moves[] = {player2pokemon.move1, player2pokemon.move2, player2pokemon.move3, player2pokemon.move4};


				// position number of the move name in move array
				int player1key;
				int player2key;


				System.out.println("\nInput the number next to the move that you would like your " + player1pokename + " to use Player 1. Here are your options below (0, 1,2,3): \n" + "\n" + "Pokemon used by player 1: " + player1pokename + "\n" + "Player 1 current health: " + player1pokemon.hp + "\nCurrent Status condition: " + player1pokemon.status + "\n Player 1 pokemon confused: " + player1pokemon.confused);

				for (int i = 0; i < player1movenames.length; i++) {

					System.out.println("*  " + player1movenames[i] + "  " + i);


				}


				String un = scan.nextLine();


				while (movechecker(player1movenames, un) != true) {

					System.out.println("\nInput the number next to the move that you would like your " + player1pokename + " to use Player 1. Here are your options below (0, 1,2,3): \n" + "\n" + "Pokemon used by player 1: " + player1pokename + "\n" + "Player 1 current health: " + player1pokemon.hp + "\nCurrent Status condition: \n" + player1pokemon.status + "\n Player 1 pokemon confused: " + player1pokemon.confused);

					for (int i = 0; i < player1movenames.length; i++) {

						System.out.println("*  " + player1movenames[i] + "  " + i);

					}


					un = scan.nextLine();


				}

				player1key = Integer.parseInt(un);


				//            [    Player 2's turn    ]


				System.out.println("Input the number next to the move you want your " + player2pokename + " to use player 2. Here are the options below(0,1,2,3): " + "\n" + "Pokemon used by player 2: " + player2pokename + "\n" + "Player 2 current health: " + player2pokemon.hp + "\nCurrent status condition: " + player2pokemon.status + "\n Player 2 pokemon confused: " + player2pokemon.confused);


				for (int i = 0; i < player2movenames.length; i++) {

					System.out.println("*  " + player2movenames[i] + "   " + i);


				}


				String deux = scan.nextLine();

				while (movechecker(player2movenames, deux) != true) {

					System.out.println("Input the number next to the legitimate move you want your " + player2pokename + " to use player 2. Here are the options below(0,1,2,3): " + "\n" + "Pokemon used by player 2: " + player2pokename + "\n" + "Player 2 current health: " + player2pokemon.hp + "\nCurrent Status Condition: " + player2pokemon.status + "\n Player 2 pokemon confused: " + player2pokemon.confused);

					for (int i = 0; i < player2movenames.length; i++) {

						System.out.println("*  " + player2movenames[i] + "  " + i);

					}


					deux = scan.nextLine();


				}


				player2key = Integer.parseInt(deux);


				un = player1movenames[player1key]; // names of the moves

				deux = player2movenames[player2key]; // names of moves

				// player keys represent the position that the moves are on in the move array and movenames array

				// player1movenames and player2movenames represent array of move names

				// player1moves and player2moves represent array of move objects

				// un and deux are the names of the moves that player1 amd player2 chose respectively


				//outputs the results
        
        
      
     /*   
        System.out.println(un);
        System.out.println(player1key);  // the player1 key determines which moves are going to be sent to the battle function array
       
        
        System.out.println(deux);f
        System.out.println(player2key);
        
        
        
        */


				// Intimidate ability
				if ((player1pokemon.ability.equals("intimidate")) && (player1pokemon.intimidate == false) && !(player2pokemon.ability.equals("clearbody")) && !(player2pokemon.ability.equals("hypercutter"))) {

					System.out.println("Player 1's pokemon has intimidated player 2's pokemon. Player 2's pokemon's attack fell!!! ");
					player1pokemon.intimidate = true; // makes sure that the intimidate ability happens once


				}


				if ((player2pokemon.ability.equals("intimidate")) && (player2pokemon.intimidate == false) && !(player1pokemon.ability.equals("clearbody")) && !(player1pokemon.ability.equals("hypercutter"))) {

					System.out.println("Player 2's pokemon has intimidated player 1's pokemon. Player 1's pokemon's attack fell!!! ");
					player2pokemon.intimidate = true;// makes sure that the intimidate ability happens once

				}

				// quickfeet ability

				if ((player1pokemon.ability.equals("quickfeet")) && player1pokemon.quickfeet == false && !(player1pokemon.status.equals(" No status conditions"))) {

					player1pokemon.speed *= 2;
					player1pokemon.quickfeet = true; // makes sure that the quickfeet ability happens once
					System.out.println("Player 1's pokemon's quickfeet ability activated!!");

				}


				if ((player2pokemon.ability.equals("quickfeet")) && player2pokemon.quickfeet == false && !(player2pokemon.status.equals(" No status conditions"))) {

					player2pokemon.speed *= 2;
					player2pokemon.quickfeet = true;// makes sure that the quickfeet ability happens once
					System.out.println("Player 2's pokemon's quickfeet ability activated!!");

				}


				// guts ability

				if ((player1pokemon.ability.equals("guts")) && player1pokemon.guts == false && !(player1pokemon.status.equals(" No status conditions"))) {

					player1pokemon.attack *= 2;
					player1pokemon.guts = true; // guts ability activated once
					System.out.println("Player 1's pokemon's guts ability activated!!");

				}


				if ((player2pokemon.ability.equals("guts")) && player2pokemon.guts == false && !(player2pokemon.status.equals(" No status conditions"))) {

					player2pokemon.attack *= 2;
					player2pokemon.guts = true;// guts ability activated once
					System.out.println("Player 2's pokemon's guts ability activated!!");

				}


				// marvel scale ability


				if ((player1pokemon.ability.equals("marvelscale")) && player1pokemon.marvelscale == false && !(player1pokemon.status.equals(" No status conditions"))) {

					player1pokemon.def *= 2;
					player1pokemon.marvelscale = true; //marvelscale ability activates once
					System.out.println("Player 1's pokemon's marvelscale ability activated!!");

				}


				if ((player2pokemon.ability.equals("marvelscale")) && player2pokemon.marvelscale == false && !(player2pokemon.status.equals(" No status conditions"))) {

					player2pokemon.def *= 2;
					player2pokemon.marvelscale = true; //marvelscale ability activates once
					System.out.println("Player 2's pokemon's marvelscale ability activated!!");

				}
				//  (player 1's pokemon,player 1's  moveobject,player 2's pokemon, player 2's moveobject)
				battlesequence.battleCoordinator(player1pokemon, player1moves[player1key], player2pokemon, player2moves[player2key]);  // goes to battle function
				// classname.functionname() is how I can access a function or method in another class that I need my program to do.
		
	
	
		
		/* THIS TESTS THE BATTLE AT THE END OF THE TURN, YOU CAN USE IT FOR TESTS 
		
		System.out.println ("\n Would you like to continue testing? (input 1 for no) \n");
		//	String opo = "";
		 
		opo = scan.nextLine();
		
		if (opo.equals("1")) { // Checks if I want to keep choosing moves in this battle so that testing can go by faster
			
			break; 
		}
		*/

			}// end of battle while loop


			// Should stop the song

			player1pokemon.endtheme = true;
			player2pokemon.endtheme = true;

			//	battletheme.play(   ); // checks the health values and if the theme should change or stop


			String winnerpokemon = "";
			String loserpokemon = "";
			String middle = "";


			System.out.println("\n Battle sequence concluded \n");

			System.out.println("Press enter to continue...");


			scan.nextLine();

			// try to stop song (gets a clip object that is connected to the current song/???


			// try to stop the song
			// makes sure that the thread for the battle theme is only made once


			System.out.println("Press enter to continue...");


			scan.nextLine();


			String winner = ""; // initialization of winner and loser
			String loser = "";
			if ((player1pokemon.hp > 0) && (player2pokemon.hp < 0)) {


				endbattletune = true;  // should hopefully end song since both threads are in the same class, are static, and rely on this variable (its volatile so both can access it);


				System.out.println(player1name + " wins ");

				System.out.println(player1name + " is going to be filed into the file of winners!!!! ");

				winner = player1name; // if player1 wins
				winnerpokemon = player1pokemon.pokename; // the pokemon the winner used
				middle = " used a ";

				System.out.println(player2name + " is going to be filed into the file of losers!!!! ");

				loser = player2name;  // if player 2 loses
				loserpokemon = player2pokemon.pokename; // the pokemon the loser used
			} else if ((player2pokemon.hp > 0) && (player1pokemon.hp <= 0)) {

				endbattletune = true;  // should hopefully end song since both threads are in the same class, are static, and rely on this variable (its volatile so both can access it);


				System.out.println(player2name + " wins ");

				System.out.println(player2name + " is going to be filed into the file of winners (javawinners.txt)!!!! ");

				winner = player2name; // if player 2 wins
				winnerpokemon = player2pokemon.pokename;// name of the winner's pokemon
				middle = " used a ";


				System.out.println(player1name + " is going to be filed into the file of losers  (javalosers.txt) !!!! ");

				loser = player1name; // if player 1 loses
				loserpokemon = player1pokemon.pokename;
			} else {
				endvictorytune = true; // makes sure the victory music doesn't play because no one won
				endbattletune = true;  // should hopefully end song since both threads are in the same class, are static, and rely on this variable (its volatile so both can access it);


				System.out.println(" Both players fainted, It is a tie, no one wins so no cool music is played");

				System.out.println(" No one is going to be filed");

				middle = "A TIE HAS OCCURED";
			}


			//files names


			// press f5 to refresh the file
			String winFilename = "javawinners.txt"; // file name variable for winners
			String loseFilename = "javalosers.txt"; // file name variable for losers


			File fileWin = new File(winFilename);  // file object for winners
			File fileLose = new File(loseFilename);//  file object for losers


			System.out.println("Would you like to skip the end credits ??? (Input 'yes' (without quotation marks if you would like to return to game play) ");

			String pr = scan.nextLine();

			System.out.println("Are you sure (re-input your response)");


			pr = scan.nextLine();
			endvictorytune = true;
			if (!(pr.equals("yes"))) {

				System.out.println("Great.. You won't regret it....");

				endcredits.endsong(); // goes to end credits and plays music
			} else {

				System.out.println("Okay... Returning you to gameplay.....");


			}


			try {


				FileWriter a = new FileWriter(fileWin, true);  // writes into the file of winners without deleting previous info
				PrintWriter addWinner = new PrintWriter(a);  // writes into FileWriter a


				addWinner.println(winner + middle + winnerpokemon);    // writes into filewriter which writes into file of winners
				addWinner.close();


				// Outputs previous winners and losers

				Scanner outputwin = new Scanner(fileWin);
				System.out.println("");
				System.out.println("");
				System.out.println("*****ALL PREVIOUS WINNERS*****");
				while (outputwin.hasNext()) {


					if (!(pr.equals("yes"))) {
						TimeUnit.MILLISECONDS.sleep(3000);
					}

					System.out.println(outputwin.nextLine());


				}

				outputwin.close();


			} catch (Exception e) { // catches any exceptions like if the file doesn't exist

				System.out.println(e.getMessage());
				System.out.println("Process Error for player 1");

			}

			try {

				FileWriter b = new FileWriter(fileLose, true);  // writes into loser file without deleting previous info

				PrintWriter addLoser = new PrintWriter(b);  // writes into Filewriter b

				addLoser.println(loser + middle + loserpokemon);
				addLoser.close();


				// Outputs previous winners and losers

				Scanner outputlose = new Scanner(fileLose);
				System.out.println("");
				System.out.println("");
				System.out.println("*****ALL PREVIOUS LOSERS*****");
				while (outputlose.hasNext()) {

					if (!(pr.equals("yes"))) {
						TimeUnit.MILLISECONDS.sleep(3000);
					}

					System.out.println(outputlose.nextLine());


				}

				outputlose.close();


			} catch (Exception e) {// catches any exceptions like if the file doesn't exist

				System.out.println(e.getMessage());
				System.out.println("Process Error for player 2");

			}






	
		// END OF TEST 
		
	
		
		System.out.println("You can terminate/end the program now...");
		
		
		System.out.println("\n Press enter to conclude the program, Have a beautiful day...... \n");
		
		
		
	    scan.nextLine();
	     
	   
	    System.exit(0); // concludes the program
		// I need to see the moves and think of who should go first based on the priority property of the move that they chose.  
		
	    
		
		
		
		
		/* // array of move names
		 * 
		String player1movenames[] = {player1pokemon.move1name, player1pokemon.move2name,  player1pokemon.move3name,  player1pokemon.move4name};
			
		String player2movenames[] = {player2pokemon.move1name, player2pokemon.move2name,  player2pokemon.move3name,  player2pokemon.move4name};
		
		
		// array of move objects 
		move player1moves[] = {player1pokemon.move1, player1pokemon.move2, player1pokemon.move3, player1pokemon.move4};
		
	move player2moves[] = {player2pokemon.move1, player2pokemon.move2, player2pokemon.move3, player2pokemon.move4};
	
	
	*/
		
		
		
		
		
		
		
		
		
		
		
		 
		
		
		
		
	 
		
	}
	
	// plays the emerald victory theme so that it loops continuously
	

public void run(){
	
	playfirered(  );
	
	
}

public static void playwin(  ) {
	

	
	try {

		
		
		String song = "victory.wav";// song file name as string
		
		
		File noise = new File(song); // song file as the variable resist in the program
		
		
		if(noise.exists()) {
			
		
			
			AudioInputStream player = AudioSystem.getAudioInputStream(noise);// song 
			
			Clip clip = AudioSystem.getClip();
			clip.open(player); // clip uses audio input stream
			
			clip.start(); // thread plays song
			clip.loop(clip.LOOP_CONTINUOUSLY); // hopefully plays song until unneeded
			
			while(true) {
				
				if( endvictorytune   == true) {
					
					clip.stop();
					clip.close();
					break;
				}
				
			
			}
		
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



public static void playfirered(  ) {
	

	
	try {

		
		
		String song = "victoryroad.wav";// song file name as string
		
		
		File noise = new File(song); // song file as the variable resist in the program
		
		
		if(noise.exists()) {
			
		
			
			AudioInputStream player = AudioSystem.getAudioInputStream(noise);// song 
			
			Clip clip = AudioSystem.getClip();
			clip.open(player); // clip uses audio input stream
			
			clip.start(); // thread plays song
			clip.loop(clip.LOOP_CONTINUOUSLY); // hopefully plays song until unneeded
			
			while(true) {
				
				if( endfireredtune   == true) {
					
					clip.stop();
					clip.close();
					break;
				}
				
			
			}
			
			
		playbattle();// transitions to play the pokemon battle theme!!!!
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

 

	 
	
// Plays the battle theme so that it is able to stop 
	

public static void playbattle(  ) {
	

	
	try {

		
		

//list of possible songs to play
		String songs[] = {"battletheme1.wav", "battletheme2.wav", "battletheme3.wav", "battletheme4.wav", "battletheme5.wav",
				"battletheme6.wav", "battletheme7.wav", "battletheme8.wav", "battletheme9.wav", "battletheme10.wav"};



		String song = songs[songchoice];// song file name as string

		File noise = new File(song); // song file as the variable resist in the program
		
		
		if(noise.exists()) {
			
		
			
			AudioInputStream player = AudioSystem.getAudioInputStream(noise);// song 
			
			Clip clip = AudioSystem.getClip();
			clip.open(player); // clip uses audio input stream
			
			clip.start(); // thread plays song
			clip.loop(clip.LOOP_CONTINUOUSLY);  // hopefully plays song until unneeded
			
			while(true) {
				
				if( endbattletune   == true) {
					
					clip.stop();
					clip.close();
					break;
				}
				
			
			}
			
			
		playwin();// transitions to play the pokemon emerald victory theme!!!!
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


public static void play( ) {
	
	   userlanguage thread = new userlanguage(  );// creates thread to play battle theme
	   thread.start(); // start
	
	 
	
}




}





