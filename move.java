package javapokemon;

import java.util.*;

public class move { 
	
	// This is the place where we process the move inputs from userlanguage

	static Scanner scan = new Scanner(System.in); // makes a new scanner called scan , it is static meaning that it is used in every function in this java file 

	// this is the description of how to get pokemon attacks (Like their stats and stuff) 
	// getting attributes of move objects
	
	double accuracy; // move's accuracy 
	String movetype; // A move's type
	double power; // move's base power
	double effectchance; // chance of effect (unused in this project)
	double critrate; // crit rate
	int priority;  // move's priority
	String attacktype;  // whether the attack is physical, special, or other
	String movename; // name of the move
	
	
	
	public String getmovename(String movename) {
		
		return movename;
		
		
		
	}
	
	
	
	
	public int getpriority(String movename) {
		
		
		int priority = 1; // most moves dont have priority
		
		String[] priority2 = {"suckerpunch", "shadowsneak", "quickattack", "bulletpunch", "aquajet", "iceshard", "watershuriken"};
		
	    
	    
	    if(movename.equals("extremespeed")) {  // checks if it is extremespeed, a move that has max priority
	    	
	    	priority = 3;
	    	
	    }
	    
	    for (int i = 0; i < priority2.length; i++) {  // checks if priority is in priority 2 array, then gives priority a value of 2
	    	
	    	if (priority2[i].equals(movename)) {
	    		
	    		priority = 2;
	    		break;
	    	}
	    	
	    }
		
		return priority;

		
		
		
	}
	
	
	
	
	public int getpower(String movename) {  // gets the base power of the move
		int power = 0; // gets a move's base power
		
		String[] power90 = {"bugbuzz", "playrough","meteormash","flashcannon" ,"wildcharge", "psychic", "flamethrower", "thunderbolt", "icebeam", "energyball"};
		
		
		// searches array of 90 power moves
				for(int i = 0; i < power90.length; i++) {
					
					if (movename.equals(power90[i])) {
						
						power = 90;
						break;
					}
					
				}
		
		String[] power75 = {"drainpunch", "thunderpunch", "airslash", "crosspoison", "firepunch", "icepunch", "rockslide", "brickbreak", "steelwing", "slash", "nightslash", "shadowclaw"};
		// searches array of 75 power moves
		for(int i = 0; i < power75.length; i++) {
			
			if (movename.equals(power75[i])) {
				
				power = 75;
				break;
			}
			
		}

		
		
		
		
		String[] power85 = {"zenheadbut", "poisonjab", "bounce", "sludgebomb", "dragonpulse"};
		
		// searches array of 85 power moves
		for(int i = 0; i < power85.length; i++) {
			
			if (movename.equals(power85[i])) {
				
				power = 85;
				break;
			}
			
		}

		
		String[] power80 = {"aurasphere", "extrasensory", "foulplay", "ironhead","relicsong", "dazzlinggleam", "crosspoison", "leechlife", "bodyslam"  , "xscissor" ,"crunch", "extremespeed", "darkpulse", "dragonclaw", "waterfall", "bounce", "shadowball", "suckerpunch"};
		
		// searches array of 80 power moves
		for(int i = 0; i < power80.length; i++) {
			
			if (movename.equals(power80[i])) {
				
				power = 80;
				break;
			}
			
		}

		String[] power102 = {"return"};
		
		// searches array of 102 power moves
		for(int i = 0; i < power102.length; i++) {
			
			if (movename.equals(power102[i])) {
				
				power = 102;
				break;
			}
			
		}

		
		String[] power100 = {"plasmafists", "earthquake","crosschop", "dynamicpunch" ,"stoneedge","irontail"};
		
		
		// searches array of 100 power moves
		for(int i = 0; i < power100.length; i++) {
			
			if (movename.equals(power100[i])) {
				
				power = 100;
				break;
			}
			
		}

		
		String[] power120 = {"volttackle", "flareblitz", "doubleironbash", "closecombat", "superpower", "bravebird", "dracometeor", "focusblast", "gunkshot"};
		
		// searches array of 120 power moves
		for(int i = 0; i < power120.length; i++) {
			
			if (movename.equals(power120[i])) {
				
				power = 120;
				break;
			}
			
		}

		
		String[] power110 = {"hydropump", "blizzard"};
		
		// searches array of 110 power moves
		for(int i = 0; i < power110.length; i++) {
			
			if (movename.equals(power110[i])) {
				
				power = 110;
				break;
			}
			
		}

		
		String[] power65 = {"firefang", "thunderfang", "icefang"};
		
		// searches array of 65 power moves
		for(int i = 0; i < power65.length; i++) {
			
			if (movename.equals(power65[i])) {
				
				power = 65;
				break;
			}
			
		}

		
		String[] power60 = {"hiddenpower", "doublekick", "waterpulse", "aerialace" };
		
		// searches array of 60 power moves
		for(int i = 0; i < power60.length; i++) {
			
			if (movename.equals(power60[i])) {
				
				power = 60;
				break;
			}
			
		}

		String[] power150 = {"gigaimpact", "hyperbeam", "boomburst"};
		
		// searches array of 150 power moves
		for(int i = 0; i < power150.length; i++) {
			
			if (movename.equals(power150[i])) {
				
				power = 150;
				break;
			}
			
		}

		
		String[] power95 = {"surf", "moonblast", "aquatail"};
		
		// searches array of 95 power moves
		for(int i = 0; i < power95.length; i++) {
			
			if (movename.equals(power95[i])) {
				
				power = 95;
				break;
			}
			
		}

		
		String[] power40 = {"shadowsneak", "aquajet", "quickattack", "iceshard", "bulletpunch"};
		
		
		// searches array of 40 power moves
		for(int i = 0; i < power40.length; i++) {
			
			if (movename.equals(power40[i])) {
				
				power = 40;
				break;
			}
			
		}

		
		
		return power;
	
	}
	
	
	
	
	public double geteffectchance(String movename) {
		double effectchance = 0; // most moves don't have an effect
		
		String[] chance10 = { "volttackle", "bugbuzz", "playrough", "thunderpunch","thunderbolt" ,"psychic","crosspoison" , "steelwing","icepunch", "icebeam","flareblitz" , "firepunch" , "firefang", "thunderfang", "icefang"}; // 10 percent chance moves
		String[] chance20 = {"extrasensory", "zenheadbut", "crunch" , "waterfall", "waterpulse", "darkpulse" }; // 20 percent chance moves
		String[] chance30 = { "gunkshot", "rockslide", "ironhead" , "blizzard", "poisonjab","focusblast" ,"irontail", "sludgebomb" ,"shadowball","bounce" }; // 30 percent chance moves
		
		
		for (int i = 0; i < chance10.length; i++) {
			
			if (movename.equals(chance10[i])) {
				
				effectchance = 10;
				break;
			}
			
			
		}
        for (int i = 0; i < chance20.length; i++) {
			
			
             if (movename.equals(chance20[i])) {
				
				effectchance = 20;
				break;
			}
		}
        for (int i = 0; i < chance30.length; i++) {
	
              if (movename.equals(chance30[i])) {
				
				effectchance = 30;
				break;
			}
	
        }
		
		return effectchance; // serene grace will be counted during battle , if a move has a 100% chance then i'll hard code it during battle function creation
		
		
		
		
	}
	
	
	
	
	public double getcritrate(String movename) {
		double critrate = 3;   // 6.25 percent chance of a crit 
		
		
		String[] highcrit = {"shadowclaw", "nightslash", "leafblade","crosschop" ,"stoneedge"};
		
		
		// searches array of  high crit moves
		for(int i = 0; i < highcrit.length; i++) {
			
			if (movename.equals(highcrit[i])) {
				
				critrate = 6; // higher crit chance lol 4-8 percent 
				break;
			}
			
		}
		
		return critrate;
		
		
		
		
		
	}
	
	
	
	public double getaccuracy(String movename) {
		double accuracy = 100; // most moves have 100% accuracy, so 100 is the default
		
		
		String[] accuracy80 = { "stoneedge" , "gunkshot"};// moves with 80 accuracy
		
		
		String[] accuracy85 = { "zenheadbut"  }; // moves with 85 accuracy
		
		String[] accuracy90 = {"playrough", "thunderwave", "willowisp" , "meteormash", "hyperbeam", "aquatail"  , "superfang", "bounce",  "steelwing", "pinmissle", "gigaimpact", "dracometeor"}; // moves with 90 accuracy
		
		String[] accuracy95 = {  "rockslide","thunderfang", "firefang", "icefang" }; // moves with 95 accuracy
		
		String[] accuracy70 = { "focusblast", "blizzard" }; // moves with 70 accuracy
		
		String[] accuracy75 = { "irontail"  }; // moves with 75 accuracy
		
		String[] accuracy30 = {  "horndrill" }; // moves with 30 accuracy
		
		String[] accuracy101 = { "aurasphere",  "aerialace" }; // moves with no chance to miss
		
		
		// searches array of 80 accuracy moves
		for(int i = 0; i < accuracy80.length; i++) {
			
			if (movename.equals(accuracy80[i])) {
				
				accuracy = 80;
				break;
			}
			
		}
		
		// searches array of 85 accuracy moves
		for(int i = 0; i < accuracy85.length; i++) {
			
			if (movename.equals(accuracy85[i])) {
				
				accuracy = 85;
				break;
			}
			
		}
		
		// searches array of 90 accuracy moves
		for(int i = 0; i < accuracy90.length; i++) {
			
			if (movename.equals(accuracy90[i])) {
				
				accuracy = 90;
				break;
			}
			
		}
		
		// searches array of 95 accuracy moves
		for(int i = 0; i < accuracy95.length; i++) {
			
			if (movename.equals(accuracy95[i])) {
				
				accuracy = 95;
				break;
			}
			
		}
		
		// searches array of 30 accuracy moves
		for(int i = 0; i < accuracy30.length; i++) {
			
			if (movename.equals(accuracy30[i])) {
				
				accuracy = 30;
				break;
			}
			
		}
		
		// searches array of 70 accuracy moves
		for(int i = 0; i < accuracy70.length; i++) {
			
			if (movename.equals(accuracy70[i])) {
				
				accuracy = 70;
				break;
			}
			
		}
		
		// searches array of 75 accuracy moves
		for(int i = 0; i < accuracy75.length; i++) {
			
			if (movename.equals(accuracy75[i])) {
				
				accuracy = 75;
				break;
			}
			
		}
		
		
		// searches array of 101 accuracy moves
		for(int i = 0; i < accuracy101.length; i++) {
			
			if (movename.equals(accuracy101[i])) {
				
				accuracy = 101;
				break;
			}
			
		}
		
		
		return accuracy;
		
		
		
		
		
	}
	
	
	
	
	
	
	
	private boolean typetester(String movetype) {
		
	boolean test = false; // whether the hiddenpower type is legit
	
	   String[] possibletypes =  {"normal", "flying", "fighting", "fire", "water",
		        "electric", "grass", "bug", "poison", "dark", "psychic", "ghost",
		        "ground", "rock", "steel", "ice", "dragon", "fairy"};
		
		for (int i = 0; i < possibletypes.length; i++) {
			
			if (possibletypes[i].equals(movetype)) {
				
				test = true;
				break;
			}
			
			
		}
		
		return test;
	}
	
	
	
	
	
	public String getmovetype(String movename, String player) {
		
		String movetype = "null"; // default type is null
		
		// Update  this data as needed 
		
		
		String[] bugtype = {"quiverdance", "bugbuzz" , "leechlife", "pinmissle" }; // bug type moves
		
		String[] watertype = {"surf" , "hydropump", "aquaring" , "aquajet", "waterfall" , "waterpulse", "aquatail", "watershuriken"}; // water type moves
		
		String[] normaltype = {"boomburst" ,"hyperbeam", "bodyslam", "gigaimpact", "slash", "return", "swordsdance" ,"superfang", "horndrill" , "extremespeed" , "morningsun", "recover", "quickattack", "workup", "relicsong"};  // normal type moves
		
		String[] flyingtype = {"roost", "bravebird","airslash", "aerialace", "bounce" };// flying type moves
		
		String[] fightingtype = {"aurasphere", "drainpunch", "bulkup" , "superpower", "closecombat","dynamicpunch" , "brickbreak" ,"crosschop" ,"focusblast" , "doublekick"}; // fighting type moves
		
		String[] firetype = {"flareblitz", "flamethrower", "firepunch", "firefang", "willowisp"   }; // fire type moves
		
		String[] electrictype = { "volttackle", "plasmafists", "thunderfang", "wildcharge" , "thunderpunch" , "thunderwave", "thunderbolt", }; // electric type moves
		
		String[] grasstype = { "leafblade", "synthesis" , "energyball" }; // grass type moves
		
		String[] poisontype = { "crosspoison" ,"poisonjab", "sludgebomb", "toxic", "gunkshot" }; // poison type moves
		
		String[] darktype = { "crunch","nastyplot" , "suckerpunch","foulplay","honeclaws",  "darkpulse", "nightslash"}; // dark type moves
		
		String[] psychictype = { "extrasensory", "psychic", "zenheadbut" , "calmmind" }; // psychic type moves
		
		String[] ghosttype = {"shadowclaw", "shadowsneak", "shadowball" , "confuseray" }; // ghost type moves
		
		String[] groundtype = { "earthquake"  }; // ground type moves
		
		String[] rocktype = {"stoneedge", "rockslide"   }; // rock type moves 
		
		String[] steeltype = { "irontail", "meteormash","flashcannon", "doubleironbash" ,"ironhead" , "steelwing", "bulletpunch" }; // steel type moves
		
		String[] icetype = { "iceshard", "icepunch" , "icebeam", "blizzard", "icefang" }; // ice type moves
		
		String[] dragontype = { "dragonclaw" , "dracometeor","dragonpulse" }; // dragon type moves
		
		String[] fairytype = {  "playrough", "moonblast" , "dazzlinggleam", "moonlight"}; // fairy type moves
		
		// The reason hyperbeam is in fairy is because sylveon has pixilate and is the only one who learns it in my simulation
		
		
		
		// searches bug type array
		for(int i = 0; i < bugtype.length; i ++) {
			
			if (movename.equals(bugtype[i])) {
				
				movetype = "bug";
				break;
			}
			
			
		}
		
		//searches water type array
       for(int i = 0; i < watertype.length; i ++) {
			
			if (movename.equals(watertype[i])) {
				
				movetype = "water";
				break;
			}
			
			
		}
       
       
   	//searches normal type array
       for(int i = 0; i < normaltype.length; i ++) {
			
			if (movename.equals(normaltype[i])) {
				
				movetype = "normal";
				break;
			}
			
			
		}
       
       
   	//searches flying type array
       for(int i = 0; i < flyingtype.length; i ++) {
			
			if (movename.equals(flyingtype[i])) {
				
				movetype = "flying";
				break;
			}
			
			
		}
       
       
   	//searches fighting type array
       for(int i = 0; i < fightingtype.length; i ++) {
			
			if (movename.equals(fightingtype[i])) {
				
				movetype = "fighting";
				break;
			}
			
			
		}
       
       
   	//searches fire type array
       for(int i = 0; i < firetype.length; i ++) {
			
			if (movename.equals(firetype[i])) {
				
				movetype = "fire";
				break;
				
				
			}
			
			
		}
       
   	//searches electric type array
       for(int i = 0; i < electrictype.length; i ++) {
			
			if (movename.equals(electrictype[i])) {
				
				movetype = "electric";
				break;
				
				
			}
			
			
		}
       
   	//searches grass type array
       for(int i = 0; i < grasstype.length; i ++) {
			
			if (movename.equals(grasstype[i])) {
				
				movetype = "grass";
				break;
				
				
			}
			
			
		}
       
   	//searches poison type array
       for(int i = 0; i < poisontype.length; i ++) {
			
			if (movename.equals(poisontype[i])) {
				
				movetype = "poison";
				break;
				
				
			}
			
			
		}
       
       
   	//searches dark type array
       for(int i = 0; i < darktype.length; i ++) {
			
			if (movename.equals(darktype[i])) {
				
				movetype = "dark";
				break;
				
			}
			
			
		}
       
   	//searches psychic type array
       for(int i = 0; i < psychictype.length; i ++) {
			
			if (movename.equals(psychictype[i])) {
				
				movetype = "psychic";
				break;
				
			}
			
			
		}
       
       
   	//searches ghost type array
       for(int i = 0; i < ghosttype.length; i ++) {
			
			if (movename.equals(ghosttype[i])) {
				
				movetype = "ghost";
				break;
			}
			
			
		}
       
       
   	//searches ground type array
       for(int i = 0; i < groundtype.length; i ++) {
			
			if (movename.equals(groundtype[i])) {
				
				movetype = "ground";
				break;
				
				
			}
			
			
		}
       
       
       
   	//searches rock type array
       for(int i = 0; i < rocktype.length; i ++) {
			
			if (movename.equals(rocktype[i])) {
				
				movetype = "rock";
				break;
				
			}
			
			
		}
       
       
       
   	//searches steel type array
       for(int i = 0; i < steeltype.length; i ++) {
			
			if (movename.equals(steeltype[i])) {
				
				movetype = "steel";
				
				break;
				
				
			}
			
			
		}
       
       
       
   	//searches ice type array
       for(int i = 0; i < icetype.length; i ++) {
			
			if (movename.equals(icetype[i])) {
				
				movetype = "ice";
				break;
				
				
			}
			
			
		}
       
       
   	//searches dragon type array
       for(int i = 0; i < dragontype.length; i ++) {
			
			if (movename.equals(dragontype[i])) {
				
				movetype = "dragon";
				break;
			}
			
			
		}
       
       
   	//searches fairy type array
       for(int i = 0; i < fairytype.length; i ++) {
			
			if (movename.equals(fairytype[i])) {
				
				movetype = "fairy";
				break;
			}
			
			
		}
       
       

		String[] possibletypes =  {"normal", "flying", "fighting", "fire", "water",
		        "electric", "grass", "bug", "poison", "dark", "psychic", "ghost",
		        "ground", "rock", "steel", "ice", "dragon", "fairy"};
		
		
		if (movename.equals("hiddenpower")) {
			
			for (int i = 0; i < possibletypes.length; i++) {
				
				System.out.println("\n * " + possibletypes[i]);
				
				
			}
			
			System.out.println("What type would you like your hidden power to be " + player + " ?");
			movetype = scan.nextLine();
			
			while(typetester(movetype) != true) {
				
				for (int i = 0; i < possibletypes.length; i++) {
					
					System.out.println("\n * " + possibletypes[i]);
					
					
				}
				
				System.out.println("Please input a legitimate type " + player + " ");
				movetype = scan.nextLine();
				
				
			}
			
		}
		
		
		
		
		
		
		return movetype;
		
	}
	
	
	
	

	
	
	
	public String getattacktype(String movename) {
		String attacktype = "null"; // its either special(sp) , physical(ph), setup(se), heal, or a status(st)
		
		
		
		// special attacks
		String[] special = {"boomburst", "bugbuzz", "aurasphere", "extrasensory", "watershuriken",
							"airslash", "energyball", "relicsong","dragonpulse", "flashcannon",
							"flamethrower" ,"dracometeor", "darkpulse", "moonblast", "hyperbeam",
							"waterpulse", "blizzard", "dazzlinggleam","hiddenpower","thunderbolt",
								"psychic", "hydropump","surf" , "focusblast", "sludgebomb" ,
							"shadowball"};
				
		
		// physical attacks 
	    String[] physical = {"volttackle","shadowclaw", "shadowsneak", "playrough", "drainpunch",
							"plasmafists", "gunkshot", "bodyslam","crosschop", "dynamicpunch",
							"superfang","leechlife","steelwing","bravebird", "crosspoison",
								"aquatail", "closecombat", "firepunch" ,"slash", "gigaimpact" ,
								"bulletpunch", "nightslash", "aerialace", "leafblade", "xscissor",
									"foulplay", "iceshard", "pinmissle", "doublekick", "quickattack",
							"meteormash", "zenheadbut", "thunderpunch","icepunch" ,"rockslide",
							"return","earthquake","firefang" ,"thunderfang","icefang",
								"brickbreak", "poisonjab", "ironhead",  "flareblitz", "crunch",
									"extremespeed","wildcharge", "dragonclaw", "irontail","aquajet",
								"superpower", "waterfall","bounce", "stoneedge", "suckerpunch",  };
	    
	    // setup moves
	    String[] setup = {"quiverdance", "swordsdance","focusenergy" ,"calmmind",
						"bulkup","nastyplot", "tailglow", "workup", "honeclaws" };
	    		
	    
	    // healing moves
	    String[] heal = {"morningsun","recover", "moonlight", "synthesis", "aquaring",
				 "roost"};
	    
	    
	    // moves that cause status conditions
	    String[] status = {"toxic","willowisp", "confuseray", "thunderwave", "yawn"  }; 
	    
	    
	    
	    
       for (int i = 0; i < physical.length; i++) {
			
	    	if(movename.equals(physical[i])) {
	    		
	    		attacktype = "ph"; // Shows that the move is a physical move that can hurt the opponent
	    		break; 
	    		
	    	}
			
		}
       for (int i = 0; i < special.length; i++) {
			
	    	if(movename.equals(special[i])) {
	    		
	    		attacktype = "sp"; // Shows that the move is a special move that can hurt the opponent
	    		break; 
	    		
	    	}
			
		}
	    
        for (int i = 0; i < setup.length; i++) {
			
	    	if(movename.equals(setup[i])) {
	    		
	    		attacktype = "se"; // Shows that the move is a setup move that can increase your stats
	    		break; 
	    		
	    	}
			
		}
	    
	    for (int i = 0; i < status.length; i++) {
			
	    	if(movename.equals(status[i])) {
	    		
	    		attacktype = "st"; // Shows that the move is a status move that can cause poison or burn
	    		break; 
	    		
	    	}
			
		}
         for (int i = 0; i < heal.length; i++) {
			
	    	if(movename.equals(heal[i])) {
	    		
	    		attacktype = "he"; // Shows that the move is a healing move that heals you up without hurting the opponent (in the array)
	    		break; 
	    		
	    	}
			
		}
		
		
		return attacktype;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
