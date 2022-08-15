package javapokemon; 
import java.security.*; // imports the secure random class to make a more secure random

          
// meteor mash has been successfully programmed into the battle program phew
 

//This is basically where pokemon can battle   
public class battlesequence {  
   
/*     
 * //
 *  // 

  //
   * 
   *   
 * //paste a new list of possible pokemon here:
 *
 *
 */  // (This only makes pseudorandom) static Random rand = new Random();  // just like with the scanner we have to make a new random number generator, we can make t static so that we don't have to re-declare it throughout the program. 
	static SecureRandom rand = new SecureRandom();   // makes true random 
	
	//ranges for pokemon damage rolls
	static double mindamageroll = 0.85;
	static double maxdamageroll = 1.00;
	
    public static void battleCoordinator(pokemon player1poke, move player1move, pokemon player2poke, move player2move) { // this function will determine who will move first 

		//checks if any player's pokemon have fainted
		if( (player1poke.hp <= 0) || (player2poke.hp <= 0)){
			return;
		}

    	if(player1poke.ability.equals("noguard")) {
    		
    		player1poke.move1.accuracy = 101;
    		player1poke.move2.accuracy = 101;
    		player1poke.move3.accuracy = 101;
    		player1poke.move4.accuracy = 101;
    		
    	}
    	
    	if(player2poke.ability.equals("noguard")) {
    		
    		player2poke.move1.accuracy = 101;
    		player2poke.move2.accuracy = 101;
    		player2poke.move3.accuracy = 101;
    		player2poke.move4.accuracy = 101;
    		
    	}
    	
    	
		
		if(player1poke.aquaring == true) { // aquaring heal 
			
			double aqua = (double) ( player2poke.maxhp/16);
			
			
		  	if (player1poke.hp + aqua <= player1poke.maxhp) {
		  		 soundeffects.heal();
            	 System.out.println(player1poke.pokename + " has been healed by aquaring: " + player1poke.hp + "  " + " + " + aqua + " =  " +  (player1poke.hp + aqua));
            	 player1poke.hp += aqua;
            	 
            }
            else {
            	 soundeffects.heal();
            		player1poke.hp = player1poke.maxhp;
               	 System.out.println(player1poke.pokename + " is at max hp: " + player1poke.hp  );
               	 
            		
            }
			
		}
		
		if(player2poke.aquaring == true) { // aquaring heal
			
			double aqua = (double) ( player2poke.maxhp/16);
			
			

		  	if (player2poke.hp + aqua <= player2poke.maxhp) {
		  		 soundeffects.heal();
            	 System.out.println(player2poke.pokename + " has been healed by aquaring: " + player2poke.hp + "  " + " + " + aqua + " =  " +  (player2poke.hp + aqua));
            	 player2poke.hp += aqua;
            	 
            }
            else {
            	 soundeffects.heal();
            	player2poke.hp = player2poke.maxhp;
               	 System.out.println(player2poke.pokename + " is at max hp: " + player2poke.hp  );
               	 
            		
            }
		  	
			
		}
		
		
		
		
		if(player1poke.roost == true) { // time to start flying, roost wears off
			System.out.println("Player 1's pokemon has started flying again");
			if(player1poke.type1.equals("roost")) {
				
				player1poke.type1 = "flying";
				player1poke.roost = false;
			}
			else if(player1poke.type2.equals("roost")) {
				
				player1poke.type2 = "flying";
				player1poke.roost = false;
			}
			
		}
		
		
		
		
		if(player2poke.roost == true) {
			System.out.println("Player 2's pokemon has started flying again");
			
			if(player2poke.type1.equals("roost")) {
				
				player2poke.type1 = "flying";
				player2poke.roost = false;
			}
			else if(player2poke.type2.equals("roost")) {
				
				player2poke.type2 = "flying";
				player2poke.roost = false;
				
			}
		}

		//checks if any player's pokemon have fainted
		if( (player1poke.hp <= 0) || (player2poke.hp <= 0)){
			return;
		}
		
		if(player1move.priority > player2move.priority) { // if player 1 move has a higher priority then it will go first

			int accuracy = rand.nextInt(100); //makes a random value. possible values 0-99
			
		//		System.out.println( accuracy ); //(This can output the value of accuracy)


			//CHANGES POKEMON"S TYPE DUE TO PROTEAN

			if(player1poke.ability.equals("protean")){

				System.out.println("!!!Player 1's pokemon's type changed from (" + player1poke.type1 + " , " + player1poke.type2 + ") " + " to (" +
						player1move.movetype + " , null)!!!");
				player1poke.type1 = player1move.movetype;
				player1poke.type2 = "null";
			}



             if( accuracy < player1move.accuracy ) {
            	 
            	 System.out.println("Player 1's " +  player1move.movename + " hit lol ");


                battlesequence.player1move(player1poke, player1move, player2poke, player2move);  // goes to battle function
               
               
        		
		     }
			 else {
            	 
            	 System.out.println("\n Player 1's " + player1move.movename + " has missed lol. ");
            	 
             }
		



		
             int accuracy2 = rand.nextInt(100);
             
			//	System.out.println( accuracy2  );



			//CHANGES POKEMON"S TYPE DUE TO PROTEAN

			if(player2poke.ability.equals("protean")){

				System.out.println("!!!Player 2's pokemon's type changed from (" + player2poke.type1 + " , " + player2poke.type2 + ") " + " to (" +
						player2move.movetype + " , null)!!!");
				player2poke.type1 = player2move.movetype;
				player2poke.type2 = "null";
			}

             if( accuracy2 < player2move.accuracy ) {
            	 
            	 System.out.println("Player 2's " + player2move.movename + " hit lol ");
            	 battlesequence.player2move(player1poke, player1move, player2poke, player2move);  // goes to battle function

           
            	 
         		
		     }
             else {
            	 
            	 System.out.println("Player 2's " + player2move.movename + " has missed lol. ");
            	  
             }


			//checks if any player's pokemon have fainted
			if( (player1poke.hp <= 0) || (player2poke.hp <= 0)){
				return;
			}

		}
		else if(player1move.priority < player2move.priority) {  // if player 2 move has a higher priority then it will go first
			
			
	           int accuracy = rand.nextInt(100); //makes a random value. possible values 0-99
				
			//		System.out.println( accuracy ); //(This can output the value of accuracy)


			//CHANGES POKEMON"S TYPE DUE TO PROTEAN

			if(player2poke.ability.equals("protean")){

				System.out.println("!!!Player 2's pokemon's type changed from (" + player2poke.type1 + " , " + player2poke.type2 + ") " + " to (" +
						player2move.movetype + " , null)!!!");
				player2poke.type1 = player2move.movetype;
				player2poke.type2 = "null";
			}
				
              if( accuracy < player2move.accuracy ) {
            	  
            	  System.out.println("Player 2's " + player2move.movename + " hit lol ");
             	 battlesequence.player2move(player1poke, player1move, player2poke, player2move);  // goes to battle function       	
             	
			     }
              else {
             	 
             	 System.out.println(" Player 2's " + player2move.movename + " has missed lol. ");
             	 
              }
			
				
			
              int accuracy1 = rand.nextInt(100);
              
//          	System.out.println( accuracy1 ); (outputs the value of the accuracy1 variable)


			//CHANGES POKEMON"S TYPE DUE TO PROTEAN

			if(player1poke.ability.equals("protean")){

				System.out.println("!!!Player 1's pokemon's type changed from (" + player1poke.type1 + " , " + player1poke.type2 + ") " + " to (" +
						player1move.movetype + " , null)!!!");
				player1poke.type1 = player1move.movetype;
				player1poke.type2 = "null";
			}

              if( accuracy1 < player1move.accuracy ) {
            	  
            	  System.out.println("Player 1's " + player1move.movename + " hit lol ");
            	  
             	 battlesequence.player1move(player1poke, player1move, player2poke, player2move);  // goes to battle function
             		
        		
			    }
              else {
             	 
             	 System.out.println(" Player 1's " + player1move.movename + " has missed lol. ");
             	  
              }



			//checks if any player's pokemon have fainted
			if( (player1poke.hp <= 0) || (player2poke.hp <= 0)){
				return;
			}
		}
		
		
		else { // If both player's moves have the same priority then we will check the pokemon's speed then decide it randomly
			

			
			if(player1poke.speed > player2poke.speed) { // if player 1's speed is higher then it will move first
				
				int accuracy = rand.nextInt(100); //makes a random value. possible values 0-99
				
				System.out.println( + accuracy );


				//CHANGES POKEMON"S TYPE DUE TO PROTEAN

				if(player1poke.ability.equals("protean")){

					System.out.println("!!!Player 1's pokemon's type changed from (" + player1poke.type1 + " , " + player1poke.type2 + ") " + " to (" +
							player1move.movetype + " , null)!!!");
					player1poke.type1 = player1move.movetype;
					player1poke.type2 = "null";
				}
				
                 if( accuracy < player1move.accuracy ) {
                	 
                	 System.out.println("Player 1's " + player1move.movename + " hit lol ");
                		battlesequence.player1move(player1poke, player1move, player2poke, player2move);  // goes to battle function
       
                     		
                		
			     }
                 else {
                	 
                	 System.out.println(" Player 1's " + player1move.movename + " has missed lol. ");
                	 
                 }
			
				
			
                 int accuracy2 = rand.nextInt(100);
                 
 			//	System.out.println( accuracy2 );


				//CHANGES POKEMON"S TYPE DUE TO PROTEAN

				if(player2poke.ability.equals("protean")){

					System.out.println("!!!Player 2's pokemon's type changed from (" + player2poke.type1 + " , " + player2poke.type2 + ") " + " to (" +
							player2move.movetype + " , null)!!!");
					player2poke.type1 = player2move.movetype;
					player2poke.type2 = "null";
				}
 				
                 if( accuracy2 < player2move.accuracy ) {
                	 
                	 System.out.println("Player 2's " + player2move.movename + " hit lol ");
                	 battlesequence.player2move(player1poke, player1move, player2poke, player2move);  // goes to battle function

             		
			     }
                 else {
                	 
                	 System.out.println(" Player 2's " + player2move.movename +   " has missed lol.");
                	  
                 }


				//checks if any player's pokemon have fainted
				if( (player1poke.hp <= 0) || (player2poke.hp <= 0)){
					return;
				}
			}
			else if(player1poke.speed < player2poke.speed) { // if player 2's speed is higher then it will move first
				
				
	           int accuracy = rand.nextInt(100); //makes a random value. possible values 0-99
				
		//	//		System.out.println( accuracy ); //(This can output the value of accuracy) //(This can output the value of accuracy)


				//CHANGES POKEMON"S TYPE DUE TO PROTEAN

				if(player2poke.ability.equals("protean")){

					System.out.println("!!!Player 2's pokemon's type changed from (" + player2poke.type1 + " , " + player2poke.type2 + ") " + " to (" +
							player2move.movetype + " , null)!!!");
					player2poke.type1 = player2move.movetype;
					player2poke.type2 = "null";
				}

                 if( accuracy < player2move.accuracy ) {
                	 
                	 System.out.println("Player 2's " + player2move.movename + " hit lol ");
                	 battlesequence.player2move(player1poke, player1move, player2poke, player2move);  // goes to battle function
          		
			     }
                 else {
                	 
                	 System.out.println(" Player 2's " + player2move.movename + " has missed lol. ");
                	 
                 }
			
				
			
                 int accuracy1 = rand.nextInt(100);
                 
 			//	System.out.println(accuracy1 );

				//CHANGES POKEMON"S TYPE DUE TO PROTEAN

				if(player1poke.ability.equals("protean")){

					System.out.println("!!!Player 1's pokemon's type changed from (" + player1poke.type1 + " , " + player1poke.type2 + ") " + " to (" +
							player1move.movetype + " , null)!!!");
					player1poke.type1 = player1move.movetype;
					player1poke.type2 = "null";
				}
 				
                 if( accuracy1 < player1move.accuracy ) {
                	 
                	 System.out.println("Player 1's " + player1move.movename + " hit lol ");
                	 battlesequence.player1move(player1poke, player1move, player2poke, player2move);  // goes to battle function
     				
                	 
   	
             		
			     }
                 else {
                	 
                	 System.out.println(" Player 1's " + player1move.movename + " has missed lol. ");
                	  
                 }

				//checks if any player's pokemon have fainted
				if( (player1poke.hp <= 0) || (player2poke.hp <= 0)){
					return;
				}
				
				
			}
			else { // if all stats (priority and speed) are the same then the person going first is going to be random
				
				int num = rand.nextInt(4); // a random number is generated, possible outcomes: 0,1,2,3
				
				System.out.println( num );
				
				if(num >= 2) { // if the number is 2 or 3 then player 2 moves first
					
					
			           int accuracy = rand.nextInt(100); //makes a random value. possible values 0-99
						
					//		System.out.println( accuracy ); //(This can output the value of accuracy)


					//CHANGES POKEMON"S TYPE DUE TO PROTEAN

					if(player2poke.ability.equals("protean")){

						System.out.println("!!!Player 2's pokemon's type changed from (" + player2poke.type1 + " , " + player2poke.type2 + ") " + " to (" +
								player2move.movetype + " , null)!!!");
						player2poke.type1 = player2move.movetype;
						player2poke.type2 = "null";
					}

		                 if( accuracy < player2move.accuracy ) {
		                	 
		                	 System.out.println("Player 2's " + player2move.movename + " hit lol ");
		                	 battlesequence.player2move(player1poke, player1move, player2poke, player2move);  // goes to battle function
               		
					     }
		                 else {
		                	 
		                	 System.out.println(" Player 2's " + player2move.movename + " has missed lol. ");
		                	 
		                 }
					
						
					
		                 int accuracy1 = rand.nextInt(100);
		                 
		 		//	System.out.println( accuracy1 ); (outputs the value of the accuracy1 variable)


					//CHANGES POKEMON"S TYPE DUE TO PROTEAN

					if(player1poke.ability.equals("protean")){

						System.out.println("!!!Player 1's pokemon's type changed from (" + player1poke.type1 + " , " + player1poke.type2 + ") " + " to (" +
								player1move.movetype + " , null)!!!");
						player1poke.type1 = player1move.movetype;
						player1poke.type2 = "null";
					}
		                 if( accuracy1 < player1move.accuracy ) {
		                	 
		                	 System.out.println("Player 1's " + player1move.movename + " hit lol ");
		                	 battlesequence.player1move(player1poke, player1move, player2poke, player2move);  // goes to battle function

		                 		
		                		
					     }
		                 else {
		                	 
		                	 System.out.println(" Player 1's " + player1move.movename + " move has missed lol. ");
		                	  
		                 }

					//checks if any player's pokemon have fainted
					if( (player1poke.hp <= 0) || (player2poke.hp <= 0)){
						return;
					}
							
				}
				else if(num <= 1) { // if the number is 0 or 1 then player 1 moves first
					
					

					int accuracy = rand.nextInt(100); //makes a random value. possible values 0-99
					
				//		System.out.println( accuracy ); //(This can output the value of accuracy)


					//CHANGES POKEMON"S TYPE DUE TO PROTEAN

					if(player1poke.ability.equals("protean")){

						System.out.println("!!!Player 1's pokemon's type changed from (" + player1poke.type1 + " , " + player1poke.type2 + ") " + " to (" +
								player1move.movetype + " , null)!!!");
						player1poke.type1 = player1move.movetype;
						player1poke.type2 = "null";
					}


	                 if( accuracy < player1move.accuracy ) {
	                	 
	                	 System.out.println("Player 1's " + player1move.movename + " hit lol ");
	                		battlesequence.player1move(player1poke, player1move, player2poke, player2move);  // goes to battle function
	 
	                     		
	                		
				     }
	                 else {
	                	 
	                	 System.out.println(" Player 1's " + player1move.movename + " has missed lol. ");
	                	 
	                 }
				
					
				
	                 int accuracy2 = rand.nextInt(100);
	                 
	 	//			System.out.println( accuracy2 ); (can output accuracy 2 variable)

					//CHANGES POKEMON"S TYPE DUE TO PROTEAN

					if(player2poke.ability.equals("protean")){

						System.out.println("!!!Player 2's pokemon's type changed from (" + player2poke.type1 + " , " + player2poke.type2 + ") " + " to (" +
								player2move.movetype + " , null)!!!");
						player2poke.type1 = player2move.movetype;
						player2poke.type2 = "null";
					}
	 				
	                 if( accuracy2 < player2move.accuracy ) {
	                	 
	                	 System.out.println("Player 2's " + player2move.movename + " hit lol ");
	                	 battlesequence.player2move(player1poke, player1move, player2poke, player2move);  // goes to battle function
      		
				     }
	                 else {
	                	 
	                	 System.out.println("Player 2's " + player2move.movename + " has missed lol. ");
	                	  
	                 }

					//checks if any player's pokemon have fainted
					if( (player1poke.hp <= 0) || (player2poke.hp <= 0)){
						return;
					}
					
				}
				
				
			}

			
			
			
			 
		}
		
	}
	 
	
    public static void player1move(pokemon player1poke, move player1move, pokemon player2poke, move player2move) { // this function will be used for player 1's attack  

		//checks for disguise
		if(player1move.attacktype.equals("ph") || player1move.attacktype.equals("sp")){

			if(player2poke.ability.equals("disguise")){

				if(player2poke.disguise == true){

					System.out.println("The opposing pokemon's disguise protected it from taking damage!!!! (That's an L for player 1).");
					player2poke.disguise = false;
					return;
				}
			}

		}

//checks if any player's pokemon have fainted
		if( (player1poke.hp <= 0) || (player2poke.hp <= 0)){
			return;
		}

		// accuracy and move boosts have been determined already.
    	
    		System.out.println("\n PLAYER 1's TURN  \n");
    		String player = " Player 2  ";
            
    		if(player1poke.flinched ==  true) {
    			
    			if(player1poke.ability.equals("innerfocus")) {
    				
    				System.out.println("The pokemon's innerfocus ability prevented flinching.");
    				player1poke.flinched = false;
    			}
    			else {
    				System.out.println("PSYCHE PLAYER 1'S POKEMON FLINCHED " );
        			player1poke.flinched = false;
        			return;
    				
    			}
    			
    		}
    		
    	   if(player1poke.charging ==  true) {
    		System.out.println("PSYCHE PLAYER 1'S POKEMON IS CHARGING " );
   			player1poke.charging = false;
   			return;
    		   
    	   }
    	   
    	   
    	   
    	   
    		if(player1poke.status.equals("Toxic")) {
    			double poison = (double) player1poke.maxhp / 16;
    			poison *= player1poke.toxiccounter;
    			player1poke.toxiccounter *= 2;
    			soundeffects.poisoned();
    			System.out.println("Player 1's pokemon lost health to poison. " + player1poke.hp + " - " + poison + " = " + (player1poke.hp - poison));
    			player1poke.hp = player1poke.hp - poison;

				//checks if any player's pokemon have fainted
				if( (player1poke.hp <= 0) || (player2poke.hp <= 0)){
					return;
				}


    		}
    		
    		
    		if(player1poke.status.equals("Burned")) {
    			double burn = (double) player1poke.maxhp / 16;
    		
    			soundeffects.burned();
    			System.out.println("Player 1's pokemon lost health to burn. " + player1poke.hp + " - " + burn + " = " + (player1poke.hp - burn));
    			player1poke.hp = player1poke.hp - burn;


				//checks if any player's pokemon have fainted
				if( (player1poke.hp <= 0) || (player2poke.hp <= 0)){
					return;
				}
    		}
    		
    		
    		
    		
    		if(player1poke.status.equals("Paralyzed")) {
    			
    			int betterGetlucky = rand.nextInt(100);
    
    			if( betterGetlucky > 50) {
    				System.out.println("PSYCHE PLAYER 1'S POKEMON IS PARALYZED, IT CAN'T MOVE " );
    				soundeffects.paralyze();
        			return;
    				
    			}
    			
    			
    			
    		}
    		
    		
    		if(player1poke.sleepcounter == 6) {
    			
    			System.out.println("Player 1's pokemon has FINNALLY WOKEN UP FROM ITS NAP!!!!!");
    			
    			player1poke.sleepcounter = 0;
    			player1poke.status = " No status conditions";
    		}
    		
    		
    		
    		
    		if(player1poke.status.equals("Sleep")) {
    			
    			int betterGetlucky = rand.nextInt(100);
    		   // // System.out.println(betterGetlucky); //(outputs bettergetlucky variable) //(outputs bettergetlucky variable)
    			if( betterGetlucky < 67) {
    				System.out.println("PSYCHE PLAYER 1'S POKEMON IS SLEEPING, RIP PLAYER 1" );
        			player1poke.sleepcounter++;
        			return;
    				
    			}
    			else {
    				
    				System.out.println(" PLAYER 1's pokemon woke up..........");
    				player1poke.status = " No status conditions";
    				player1poke.drowsy = false;
    				
    			}
    			
    			
    		}
    		
    		
    		if(player1poke.frozencounter == 6) {
    			
    			System.out.println("Player 1's pokemon has FINNALLY THAWED OUT!!!!!");
    			
    			
    			player1poke.frozencounter = 0;
    			player1poke.status = " No status conditions";
    		}
    		
    		
    		
    		
    		if(player1poke.status.equals("Frozen")) {
    			
    			int betterGetlucky = rand.nextInt(100);
    		    // System.out.println(betterGetlucky); //(outputs bettergetlucky variable)
    			if( betterGetlucky < 67) {
    				System.out.println("PSYCHE PLAYER 1'S POKEMON IS FROZEN, RIP PLAYER 1" );
        			player1poke.frozencounter++;
        			soundeffects.frozen();
        			return;
        			
    				
    			}
    			else {
    				
    				System.out.println(" PLAYER 1's pokemon thawed out..........");
    				player1poke.status = " No status conditions";
    			
    				
    			}
    			
    			
    		}
    		
    		
    		
    		
    		
    		if(player1poke.drowsy == true) {
    			
    			
    			player1poke.status = "Sleep";
    
    			player1poke.drowsy = false;
    			
    		
    		}
    		
    		if(player1poke.confused == true) {
    			
    			
    			int betterGetlucky = rand.nextInt(100);
    
    			if( betterGetlucky > 50) {
    				System.out.println("PSYCHE PLAYER 1'S POKEMON IS HURT ITSELF IN ITS CONFUSION " );
        			
    				double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * 40 * (double) (player1poke.attack/ (double) player1poke.def)) * 0.02 ) + 2) ; // How much damage the move will do (the equation)
    		    	
    				player1poke.hp -= damage;

					//checks if any player's pokemon have fainted
					if( (player1poke.hp <= 0) || (player2poke.hp <= 0)){
						return;
					}

        			return;
    				
    			}
    			else if ( betterGetlucky > 79) {
    				
    				player1poke.confused = false; // snaps out of confusion
    				System.out.println("Player 1's pokemon snapped out of confusion!!");
    			}
    			
    			
    		}
    		
    	
    		

    		if(player1poke.bounce == true) {  // makes sure bounce is sent to the next bounce function insead of another move
    			
    			if(player1poke.move1.movename.equals("bounce")) { //movename refers to the string name of the move
    				
    				player2poke.hp = bounce(player1poke, player1poke.move1, player2poke,  player);
        	    	
    			}
    			else if(player1poke.move2.movename.equals("bounce")) {
    				player2poke.hp = bounce(player1poke, player1poke.move2, player2poke,  player);
        	    	
    				
    			}
    			else if(player1poke.move3.movename.equals("bounce")) {
    				
    				player2poke.hp = bounce(player1poke, player1poke.move3, player2poke,  player);
        	    	
    			}
    			else if(player1poke.move4.movename.equals("bounce")) {
    				
    				player2poke.hp = bounce(player1poke, player1poke.move4, player2poke,  player);
        	    	
    			}
    			
    		
    			return;
    		}
    		
    		//stab
    		if(   (player1move.movetype.equals(player1poke.type1)) ||  (player1move.movetype.equals(player1poke.type2)) )  {
    			
    			player1move.power *= 1.5;
    			
    		}




		//checks if any player's pokemon have fainted
		if( (player1poke.hp <= 0) || (player2poke.hp <= 0)){
			return;
		}






//STEEL MOVES
    		if(player1move.movename.equals("meteormash")) {

    			player2poke.hp = meteormash(player1poke, player1move, player2poke,  player);

    			
    		}
    		else if(player1move.movename.equals("bulletpunch")) {

    			player2poke.hp = bulletpunch(player1poke, player1move, player2poke,  player);


    		}
    		else if(player1move.movename.equals("irontail")) {

    			player2poke.hp = irontail(player1poke, player1move, player2poke,  player);


    		}
    		else if(player1move.movename.equals("doubleironbash")) {

    			player2poke.hp = doubleironbash(player1poke, player1move, player2poke,  player);

    			
    		}
    		else if(player1move.movename.equals("steelwing")) {
    			
    			player2poke.hp = steelwing(player1poke, player1move, player2poke,  player);


    		}
    		else if(player1move.movename.equals("flashcannon")) {
    			
    			player2poke.hp = flashcannon(player1poke, player1move, player2poke,  player);


    		}
    		else if(player1move.movename.equals("ironhead")) {
    			
    			player2poke.hp = ironhead(player1poke, player1move, player2poke,  player);

    			
    		}// HEAL MOVES
    		else if(player1move.movename.equals("recover")) {

    			 recover(player1poke, player1move, player2poke,  player);
    			
    			
    		}
    		else if(player1move.movename.equals("morningsun")) {

    			morningsun(player1poke, player1move, player2poke,  player);
		
		
    		}
    		else if(player1move.movename.equals("moonlight")) {
		
    			moonlight(player1poke, player1move, player2poke,  player);
		
		
    		}
    		else if(player1move.movename.equals("roost")) {
    			
    			roost(player1poke, player1move, player2poke,  player);
		
		
    		}
    		else if(player1move.movename.equals("synthesis")) {
    			
    			synthesis(player1poke, player1move, player2poke,  player);
		
		
    		}
    			else if(player1move.movename.equals("aquaring")) {
    			
    			aquaring(player1poke, player1move, player2poke,  player);
		
		
    		}
    		//SET UP MOVES
    			else if(player1move.movename.equals("swordsdance")) {
        			
    				swordsdance(player1poke, player1move, player2poke,  player);
    		
    		
        		}
				else if(player1move.movename.equals("quiverdance")) {

					quiverdance(player1poke, player1move, player2poke,  player);


				}
    			else if(player1move.movename.equals("focusenergy")) {
        			
    				focusenergy(player1poke, player1move, player2poke,  player);
    		
    		
        		}
    			else if(player1move.movename.equals("calmmind")) {
        			
    				calmmind(player1poke, player1move, player2poke,  player);
    		
    		
        		}
    			else if(player1move.movename.equals("bulkup")) {
        			
    				bulkup(player1poke, player1move, player2poke,  player);
    		
    		
        		}
    			else if(player1move.movename.equals("nastyplot")) {

    				nastyplot(player1poke, player1move, player2poke,  player);
    		
    		
        		}
    			else if(player1move.movename.equals("tailglow")) {
        			
		tailglow(player1poke, player1move, player2poke,  player);
    		
    		
        		}
    			else if(player1move.movename.equals("workup")) {
		
		workup(player1poke, player1move, player2poke,  player);


    			}
    			else if(player1move.movename.equals("honeclaws")) {
		
		honeclaws(player1poke, player1move, player2poke,  player);


    			}//STATUS MOVES
    			else if(player1move.movename.equals("willowisp")) {
    				
    				willowisp(player1poke, player1move, player2poke,  player);


    		    			}
    			else if(player1move.movename.equals("thunderwave")) {
    				
    				thunderwave(player1poke, player1move, player2poke,  player);


    		    			}
    			else if(player1move.movename.equals("toxic")) {

    				toxic(player1poke, player1move, player2poke,  player);


    		    			}
    			else if(player1move.movename.equals("confuseray")) {
    				
    				confuseray(player1poke, player1move, player2poke,  player);


    		    			}
    			else if(player1move.movename.equals("yawn")) {
    				
    				yawn(player1poke, player1move, player2poke,  player);


    		    			} //HIDDENPOWER
    			else if(player1move.movename.equals("hiddenpower")) {
        			
        			player2poke.hp = hiddenpower(player1poke, player1move, player2poke,  player);
        			
        			
        		}//NORMAL MOVES
    			else if(player1move.movename.equals("superfang")) {
        			
        			player2poke.hp = superfang(player1poke, player1move, player2poke,  player);
        			
        			
        		}
    			else if(player1move.movename.equals("gigaimpact")) {
	
    				player2poke.hp = gigaimpact(player1poke, player1move, player2poke,  player);
	
	
    			}
    			else if(player1move.movename.equals("return")) {
	
    				player2poke.hp = returnx(player1poke, player1move, player2poke,  player);
	
	
    			}
    			else if(player1move.movename.equals("slash")) {
	
    				player2poke.hp = slash(player1poke, player1move, player2poke,  player);
	
	
    			}
    			else if(player1move.movename.equals("quickattack")) {
	
    				player2poke.hp = quickattack(player1poke, player1move, player2poke,  player);
	
	
    			}
    			else if(player1move.movename.equals("extremespeed")) {
	
    				player2poke.hp = extremespeed(player1poke, player1move, player2poke,  player);
	
	
    			}
    			else if(player1move.movename.equals("horndrill")) {
    				
    				player2poke.hp = horndrill(player1poke, player1move, player2poke,  player);
	
	
    			}
    			else if(player1move.movename.equals("relicsong")) {
    				
    				player2poke.hp = relicsong(player1poke, player1move, player2poke,  player);
	
	
    			}
    			else if(player1move.movename.equals("bodyslam")) {
    				
    				player2poke.hp = bodyslam(player1poke, player1move, player2poke,  player);
	
	
    			}
    			else if(player1move.movename.equals("hyperbeam")) {
    				
    				player2poke.hp = hyperbeam(player1poke, player1move, player2poke,  player);
	
	
    			}
				else if(player1move.movename.equals("boomburst")) {

					player2poke.hp = boomburst(player1poke, player1move, player2poke,  player);


				}
			//BUG MOVES
    			else if(player1move.movename.equals("xscissor")) {
    				
    				player2poke.hp = xscissor(player1poke, player1move, player2poke,  player);
	
	
    			}
				else if(player1move.movename.equals("bugbuzz")) {

					player2poke.hp = bugbuzz(player1poke, player1move, player2poke,  player);


				}
    			else if(player1move.movename.equals("pinmissle")) {
	
    				player2poke.hp = pinmissle(player1poke, player1move, player2poke,  player);


    			}
    			else if(player1move.movename.equals("leechlife")) {
	
    				player2poke.hp = leechlife(player1poke, player1move, player2poke,  player);


    			}// WATER MOVES
    			else if(player1move.movename.equals("aquatail")) {
    				
    				player2poke.hp = aquatail(player1poke, player1move, player2poke,  player);


    			}
    			else if(player1move.movename.equals("surf")) {
    				
    				player2poke.hp = surf(player1poke, player1move, player2poke,  player);


    			}
    			else if(player1move.movename.equals("aquajet")) {
    				
    				player2poke.hp = aquajet(player1poke, player1move, player2poke,  player);


    			}

    			else if(player1move.movename.equals("hydropump")) {
    				
    				player2poke.hp = hydropump(player1poke, player1move, player2poke,  player);


    			}
    			else if(player1move.movename.equals("waterpulse")) {
    				
    				player2poke.hp = waterpulse(player1poke, player1move, player2poke,  player);


    			}
    			else if(player1move.movename.equals("waterfall")) {
    				
    				player2poke.hp = waterfall(player1poke, player1move, player2poke,  player);


    			}
				else if(player1move.movename.equals("watershuriken")) {

					player2poke.hp = watershuriken(player1poke, player1move, player2poke,  player);


				}// ICE MOVES
    			else if(player1move.movename.equals("icepunch")) {
    				
    				player2poke.hp = icepunch(player1poke, player1move, player2poke,  player);


    			}
    			else if(player1move.movename.equals("iceshard")) {
    				
    				player2poke.hp = iceshard(player1poke, player1move, player2poke,  player);


    			}
    			else if(player1move.movename.equals("icebeam")) {
    				
    				player2poke.hp = icebeam(player1poke, player1move, player2poke,  player);


    			}
    			else if(player1move.movename.equals("blizzard")) {
    				
    				player2poke.hp = blizzard(player1poke, player1move, player2poke,  player);


    			}
    			else if(player1move.movename.equals("icefang")) {
    				
    				player2poke.hp = icefang(player1poke, player1move, player2poke,  player);


    			}// DRAGON MOVES
    			else if(player1move.movename.equals("dragonclaw")) {
    				
    				player2poke.hp = dragonclaw(player1poke, player1move, player2poke,  player);


    			}
    			else if(player1move.movename.equals("dracometeor")) {
    				
    				player2poke.hp = dracometeor(player1poke, player1move, player2poke,  player);


    			}
    			else if(player1move.movename.equals("dragonpulse")) {
    				
    				player2poke.hp = dragonpulse(player1poke, player1move, player2poke,  player);


    			}// FAIRY MOVES
    			else if(player1move.movename.equals("dazzlinggleam")) {
    				
    				player2poke.hp = dazzlinggleam(player1poke, player1move, player2poke,  player);


    			}
    			else if(player1move.movename.equals("moonblast")) {
    				
    				player2poke.hp = moonblast(player1poke, player1move, player2poke,  player);


    			}
				else if(player1move.movename.equals("playrough")) {

					player2poke.hp = playrough(player1poke, player1move, player2poke,  player);


				}
				// FLYING MOVES
    			else if(player1move.movename.equals("aerialace")) {
    				
    				player2poke.hp = aerialace(player1poke, player1move, player2poke,  player);


    			}
    			else if(player1move.movename.equals("airslash")) {
    				
    				player2poke.hp = airslash(player1poke, player1move, player2poke,  player);


    			}
    			else if(player1move.movename.equals("bravebird")) {
    				
    				player2poke.hp = bravebird(player1poke, player1move, player2poke,  player);


    			}
    			else if(player1move.movename.equals("bounce")) {
    				
    				player2poke.hp = bounce(player1poke, player1move, player2poke,  player);


    			}// DRAGON DANCE
    			else if(player1move.movename.equals("dragondance")) {
    				
    				dragondance(player1poke, player1move, player2poke,  player);


    			}// FIGHTING MOVES
    			else if(player1move.movename.equals("crosschop")) {
    				
    				player2poke.hp = crosschop(player1poke, player1move, player2poke,  player);


    			}
    			else if(player1move.movename.equals("dynamicpunch")) {
		
    				player2poke.hp = dynamicpunch(player1poke, player1move, player2poke,  player);


    			}
    			else if(player1move.movename.equals("doublekick")) {
		
    				player2poke.hp = doublekick(player1poke, player1move, player2poke,  player);


    				}
    			else if(player1move.movename.equals("focusblast")) {
		
    				player2poke.hp = focusblast(player1poke, player1move, player2poke,  player);


    			}
				else if(player1move.movename.equals("aurasphere")) {

					player2poke.hp = aurasphere(player1poke, player1move, player2poke,  player);


				}
    			else if(player1move.movename.equals("superpower")) {
		
    				player2poke.hp = superpower(player1poke, player1move, player2poke,  player);


    			}
    			else if(player1move.movename.equals("closecombat")) {
		
    				player2poke.hp = closecombat(player1poke, player1move, player2poke,  player);


    			}
    			else if(player1move.movename.equals("brickbreak")) {
		
    				player2poke.hp = brickbreak(player1poke, player1move, player2poke,  player);


    			}
				else if(player1move.movename.equals("drainpunch")) {

					player2poke.hp = drainpunch(player1poke, player1move, player2poke,  player);


				}
			// FIRE MOVES
    			else if(player1move.movename.equals("flamethrower")) {
    				
    				player2poke.hp = flamethrower(player1poke, player1move, player2poke,  player);


    			}
    			else if(player1move.movename.equals("firefang")) {
		
    				player2poke.hp = firefang(player1poke, player1move, player2poke,  player);


    			}
    			else if(player1move.movename.equals("flareblitz")) {
		
    				player2poke.hp = flareblitz(player1poke, player1move, player2poke,  player);


    			}
    			else if(player1move.movename.equals("firepunch")) {
		
    				player2poke.hp = firepunch(player1poke, player1move, player2poke,  player);


    			}// ELECTRIC MOVES
    			else if(player1move.movename.equals("thunderbolt")) {
    				
    				player2poke.hp = thunderbolt(player1poke, player1move, player2poke,  player);


    			}
    			else if(player1move.movename.equals("thunderfang")) {
		
    				player2poke.hp = thunderfang(player1poke, player1move, player2poke,  player);


    			}
    			else if(player1move.movename.equals("wildcharge")) {
		
    				player2poke.hp = wildcharge(player1poke, player1move, player2poke,  player);


    			}
    			else if(player1move.movename.equals("thunderpunch")) {
		
    				player2poke.hp = thunderpunch(player1poke, player1move, player2poke,  player);


    			}
				else if(player1move.movename.equals("volttackle")) {

					player2poke.hp = volttackle(player1poke, player1move, player2poke,  player);


				}
				else if(player1move.movename.equals("plasmafists")) {

					player2poke.hp = plasmafists(player1poke, player1move, player2poke,  player);


				}
				// POISON MOVES
    			else if(player1move.movename.equals("sludgebomb")) {
    				
    				player2poke.hp = sludgebomb(player1poke, player1move, player2poke,  player);


    			}
				else if(player1move.movename.equals("gunkshot")) {

					player2poke.hp = gunkshot(player1poke, player1move, player2poke,  player);


				}
    			else if(player1move.movename.equals("crosspoison")) {
		
    				player2poke.hp = crosspoison(player1poke, player1move, player2poke,  player);


    			}
    			else if(player1move.movename.equals("poisonjab")) {
		
    				player2poke.hp = poisonjab(player1poke, player1move, player2poke,  player);


    			}// DARK MOVES
    			else if(player1move.movename.equals("suckerpunch")) {
    				
    				
    				if( ((player2move.attacktype.equals("sp")) || (player2move.attacktype.equals("ph")) ) && (player1move.priority >= player2move.priority) ) {
    					

        				player2poke.hp = suckerpunch(player1poke, player1move, player2poke,  player);
    					
    				}
    				else {
    					
    					System.out.println("Suckerpunch failed because opponent wasn't using a physical or special attack!!");
    					return;
    				}


    			}
    			else if(player1move.movename.equals("nightslash")) {
    				
    				player2poke.hp = nightslash(player1poke, player1move, player2poke,  player);


    			}
    			else if(player1move.movename.equals("crunch")) {
    				
    				player2poke.hp = crunch(player1poke, player1move, player2poke,  player);


    			}
    			else if(player1move.movename.equals("darkpulse")) {
		
    				player2poke.hp = darkpulse(player1poke, player1move, player2poke,  player);


    			}
    			else if(player1move.movename.equals("foulplay")) {
		
    				player2poke.hp = foulplay(player1poke, player1move, player2poke,  player);


    			}// PSYCHIC
    			else if(player1move.movename.equals("psychic")) {
    				
    				player2poke.hp = psychic(player1poke, player1move, player2poke,  player);


    			}
				else if(player1move.movename.equals("extrasensory")) {

					player2poke.hp = extrasensory(player1poke, player1move, player2poke,  player);


				}
    			else if(player1move.movename.equals("zenheadbut")) {
		
    				player2poke.hp = zenheadbut(player1poke, player1move, player2poke,  player);


    			}// GHOST MOVES
    			else if(player1move.movename.equals("shadowball")) {
    				
    				player2poke.hp = shadowball(player1poke, player1move, player2poke,  player);


    			}
				else if(player1move.movename.equals("shadowsneak")) {

					player2poke.hp = shadowsneak(player1poke, player1move, player2poke,  player);


				}
				else if(player1move.movename.equals("shadowclaw")) {

					player2poke.hp = shadowclaw(player1poke, player1move, player2poke,  player);


				}// GROUND MOVES
    			else if(player1move.movename.equals("earthquake")) {
    				
    				player2poke.hp = earthquake(player1poke, player1move, player2poke,  player);


    			}// ROCK MOVES
    			else if(player1move.movename.equals("stoneedge")) {
    				
    				player2poke.hp = stoneedge(player1poke, player1move, player2poke,  player);


    			}
    			else if(player1move.movename.equals("rockslide")) {
    				
    				player2poke.hp = rockslide(player1poke, player1move, player2poke,  player);


    			}//GRASS MOVES
    			else if(player1move.movename.equals("energyball")) {
    				
    				player2poke.hp = energyball(player1poke, player1move, player2poke,  player);


    			}
    			else if(player1move.movename.equals("leafblade")) {
    				
    				player2poke.hp = leafblade(player1poke, player1move, player2poke,  player);


    			}


    		
    		//flamebody
    		 
            if(player1move.attacktype.equals("ph")) {
         	   
         	   
         	   if(player2poke.ability.equals("flamebody")){
         		   
           		 if( (player1poke.status.equals(" No status conditions")) && !(player1poke.type1.equals("fire")) && !(player1poke.type2.equals("fire")) ) {
           			 int hit = rand.nextInt(10);
                  		
                  		if(hit > 4) {
                  			player1poke.status = "Burned";
                  			soundeffects.burned();
                  			if(player1poke.move1.attacktype.equals("ph")) {
                  				player1poke.move1.power *= 0.5;
                  			}
                  			if(player1poke.move2.attacktype.equals("ph")) {
                  				player1poke.move2.power *= 0.5;
                  			}
                  			if(player1poke.move3.attacktype.equals("ph")) {
                  				player1poke.move3.power *= 0.5;
                  			}
                  			if(player1poke.move4.attacktype.equals("ph")) {
                  				player1poke.move4.power *= 0.5;
                  			}
                  		 System.out.println( player2poke.pokename + " has burned the opponent's " + player1poke.pokename + " due to its flame body!! " + player1poke.pokename + "'s physical attacks power has been cut in half. ");
                  		 
                 }
                 
                 
                 }
                 
				}
         	   
            }






		//poisonpoint

		if(player1move.attacktype.equals("ph")) {


			if(player2poke.ability.equals("poisonpoint")){

				if( (player1poke.status.equals(" No status conditions")) && !(player1poke.type1.equals("poison")) && !(player1poke.type2.equals("poison")) ) {
					int hit = rand.nextInt(10);

					if(hit > 4) {
						player1poke.status = "Toxic";
						soundeffects.poisoned();

						System.out.println( player2poke.pokename + " has poisoned the opponent's " + player1poke.pokename + " due to its poisonpoint ability!! " + player1poke.pokename + " is kinda screwed. ");

					}


				}

			}

		}



//static
		if(player1move.attacktype.equals("ph")) {


			if(player2poke.ability.equals("static")){

				if( (player1poke.status.equals(" No status conditions")) ) {
					int hit = rand.nextInt(10);

					if(hit > 4) {
						player1poke.status = "Paralyzed";
						soundeffects.paralyze();
						player1poke.speed *= 0.5;

						System.out.println( player2poke.pokename + " has paralyzed the opponent's " + player1poke.pokename + " due to its static ability!! " + player1poke.pokename + "'s speed has been cut in half. ");

					}


				}

			}

		}


//roughskin
		if(player1move.attacktype.equals("ph")) {


			if(player2poke.ability.equals("roughskin")){




					soundeffects.attack();

			System.out.println( player2poke.pokename + " has hurt the opponent's " + player1poke.pokename + " with its rough skin!! ");

			double rough = (player1poke.maxhp * 0.125);
			System.out.println("ROUGH SKIN DAMAGE: " + player1poke.hp + " - " + rough + " = " + (player1poke.hp - rough));
			player1poke.hp -=rough;








			}

		}




		//checks if any player's pokemon have fainted
		if( (player1poke.hp <= 0) || (player2poke.hp <= 0)){
			return;
		}




//gooey
		if(player1move.attacktype.equals("ph")) {


			if(player2poke.ability.equals("gooey")){




				soundeffects.drop();

				System.out.println( player2poke.pokename + " has slowed down the opponent's " + player1poke.pokename + " with its gooey skin!! ");

				player1poke.speed *= 0.5;










			}

		}

    	   /*
    	    * 
    	    * 	String[] psychictype = { "psychic", "zenheadbut" , "calmmind" }; // psychic type moves
		
		String[] ghosttype = {"shadowball" , "confuseray" }; // ghost type moves
		
		String[] groundtype = { "earthquake"  }; // ground type moves
		
		String[] rocktype = {"stoneedge", "rockslide"   }; // rock type moves 
    	    */
    		
    		
    		
	}
    
    
    public static void player2move(pokemon player1poke, move player1move, pokemon player2poke, move player2move) { // this function will be used for player 2's attack  

		//checks for disguise on player 1's pokemon
		if(player2move.attacktype.equals("ph") || player2move.attacktype.equals("sp")){

			if(player1poke.ability.equals("disguise")){

				if(player1poke.disguise == true){

					System.out.println("The opposing pokemon's disguise protected it from taking damage!!!! (That's an L for player 2).");
					player1poke.disguise = false;
					return;
				}
			}

		}

		//checks if any player's pokemon have fainted
		if( (player1poke.hp <= 0) || (player2poke.hp <= 0)){
			return;
		}
    		System.out.println("\n PLAYER 2'S TURN    \n");
    		String player = " Player 1  ";
    		
    		
    		if(player2poke.flinched == true) {
    			
    			
    			if(player2poke.ability.equals("innerfocus")) {
    				
    				System.out.println("Inner focus prevented flinching!!!");
    				player2poke.flinched = false;
    			}
    			else {
    				System.out.println("PSYCH PLAYER 2's POKEMON flinched !!");
        			
        			player2poke.flinched = false;
        			return;
    				
    			}
    			
    		}
    		
    		
    		
    		  if(player2poke.charging ==  true) {
    	    		System.out.println("PSYCHE PLAYER 2'S POKEMON IS CHARGING " );
    	   			player2poke.charging = false;
    	   			return;
    	    		   
    	     }
    	  	
    		if(player2poke.status.equals("Toxic")) {
    			double poison = (double) player2poke.maxhp / 16;
    			poison *= player2poke.toxiccounter;
    			player2poke.toxiccounter *= 2;
    			
    			
    			soundeffects.poisoned();
    			System.out.println("Player 2's pokemon lost health to poison. " + player2poke.hp + " - " + poison + " = " + (player2poke.hp - poison));
    			player2poke.hp = player2poke.hp - poison;

				//checks if any player's pokemon have fainted
				if( (player1poke.hp <= 0) || (player2poke.hp <= 0)){
					return;
				}
    		}
    		
    		
    		if(player2poke.status.equals("Burned")) {
    			double burn = (double) player2poke.maxhp / 16;
    		
    			soundeffects.burned();
    			System.out.println("Player 2's pokemon lost health to burn. " + player2poke.hp + " - " + burn + " = " + (player2poke.hp - burn));
    			player2poke.hp = player2poke.hp - burn;

				//checks if any player's pokemon have fainted
				if( (player1poke.hp <= 0) || (player2poke.hp <= 0)){
					return;
				}
    		}
    		
    		
    		
    		
    		if(player2poke.status.equals("Paralyzed")) {
    			
    			int betterGetlucky = rand.nextInt(100);
    
    			if( betterGetlucky > 50) {
    				System.out.println("PSYCHE PLAYER 2'S POKEMON IS PARALYZED, IT CAN'T MOVE " );
    				soundeffects.paralyze();
        			return;
    				
    			}
    			
    			
    			
    		}
    		
    		
    		if(player2poke.confused == true) {
    			
    			
    			int betterGetlucky = rand.nextInt(100);
    
    			if( betterGetlucky > 50) {
    				System.out.println("PSYCHE PLAYER 2'S POKEMON IS HURT ITSELF IN ITS CONFUSION " );
        			
    				double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * 40 * (double) (player2poke.attack/ (double) player2poke.def)) * 0.02 ) + 2) ; // How much damage the move will do (the equation)
    		    	
    				player2poke.hp -= damage;

					//checks if any player's pokemon have fainted
					if( (player1poke.hp <= 0) || (player2poke.hp <= 0)){
						return;
					}

        			return;
    				
    			}	
    			else if ( betterGetlucky > 79) {
    				
    				player2poke.confused = false; // snaps out of confusion
    				System.out.println("Player 2's pokemon snapped out of confusion!!");
    			}
    			
    			
    			
    		}
    		

    		if(player2poke.sleepcounter == 6) {
    			
    			System.out.println("PLAYER 2's POKEMON HAS FINNALLY WOKEN UP (About time)");
    			player2poke.status = " No status conditions";
    			player2poke.sleepcounter = 0;
    			
    			
    		}
    		
    		
    		if(player2poke.status.equals("Sleep")) {
    			
    			
    			
    			int betterGetlucky = rand.nextInt(100);
    			   // System.out.println(betterGetlucky); //(outputs bettergetlucky variable)
    			if( betterGetlucky < 67) {
    				System.out.println("PSYCHE PLAYER 2'S POKEMON IS SLEEPING, RIP PLAYER 2" );
        			player2poke.sleepcounter++;
        			return;
    				
    			}
    			else {
    				
    				System.out.println(" PLAYER 2's pokemon woke up..........");
    				player2poke.status = " No status conditions";
    				player2poke.drowsy = false;
    				
    			}
    			
    			
    		}
    		
    		
    		
    		
    		if(player2poke.drowsy == true) {
    			
    			
    			player2poke.status = "Sleep";
    			
    			player2poke.drowsy = false;
    			
    			
    		}
    		
    		
    		

    		if(player2poke.frozencounter == 6) {
    			
    			System.out.println("PLAYER 2's POKEMON HAS FINNALLY THAWED OUT (About time)");
    			player2poke.status = " No status conditions";
    			player2poke.frozencounter = 0;
    			
    			
    		}
    		
    		
    		if(player2poke.status.equals("Frozen")) {
    			
    			
    			
    			int betterGetlucky = rand.nextInt(100);
    			   // System.out.println(betterGetlucky); //(outputs bettergetlucky variable)
    			if( betterGetlucky < 67) {
    				System.out.println("PSYCHE PLAYER 2'S POKEMON IS FROZEN, RIP PLAYER 2" );
        			player2poke.frozencounter++;
        			soundeffects.frozen();
        			return;
    				
    			}
    			else {
    				
    				System.out.println(" PLAYER 2's pokemon thawed out..........");
    				player2poke.status = " No status conditions";
    			
    				
    			}
    			
    			
    		}
    		
    		
    		if(player2poke.bounce == true) { // makes sure bounce's power is used
    			
    			if(player2poke.move1.movename.equals("bounce")) { // movename refers to the string name of the move
    				
    				player2poke.hp = bounce(player2poke, player2poke.move1, player1poke,  player);
    	    		
    				
    			}
    			else if(player2poke.move2.movename.equals("bounce")) {
    				
    				player2poke.hp = bounce(player2poke, player2poke.move2, player1poke,  player);
    	    		
    				
    			}
    			else if(player2poke.move3.movename.equals("bounce")) {
    				player2poke.hp = bounce(player2poke, player2poke.move3, player1poke,  player);
    	    		
    				
    				
    			}
    			else if(player2poke.move4.movename.equals("bounce")) {
    				player2poke.hp = bounce(player2poke, player2poke.move4, player1poke,  player);
    	    		
    				
    				
    			}
    			
    				
    			return;
    		}
    		
    		//stab
    		if(   (player2move.movetype.equals(player2poke.type1)) ||  (player2move.movetype.equals(player2poke.type2)) )  {
    			
    			player2move.power *= 1.5;
    			
    		}


		//checks if any player's pokemon have fainted
		if( (player1poke.hp <= 0) || (player2poke.hp <= 0)){
			return;
		}





    		//STEEL MOVES
    		
           if(player2move.movename.equals("meteormash")) {
   
    			player1poke.hp = meteormash(player2poke, player2move, player1poke,  player);
    			
    		} 
            else if (player2move.movename.equals("bulletpunch")) {
        	   
   			player1poke.hp = bulletpunch(player2poke, player2move, player1poke,  player);
   			
   		    } 
           else if (player2move.movename.equals("irontail")) {
        	   
      			player1poke.hp = irontail(player2poke, player2move, player1poke,  player);
      			
      		 } 
           else if (player2move.movename.equals("doubleironbash")) {
        	   
     			player1poke.hp = doubleironbash(player2poke, player2move, player1poke,  player);
     			
     		 } 
           else if (player2move.movename.equals("steelwing")) {
        	   
    			player1poke.hp = steelwing(player2poke, player2move, player1poke,  player);
    			
    		 } 
           else if (player2move.movename.equals("ironhead")) {
        	   
   			player1poke.hp = ironhead(player2poke, player2move, player1poke,  player);
   			
   		 } 
           else if (player2move.movename.equals("flashcannon")) {
        	   
   			player1poke.hp = flashcannon(player2poke, player2move, player1poke,  player);
   			
   		 } //HEAL MOVES
           
           else if (player2move.movename.equals("recover")) {
        	   
      			 recover(player2poke, player2move, player1poke,  player);
      			
      		 }
           else if (player2move.movename.equals("moonlight")) {
        	   
      			 moonlight(player2poke, player2move, player1poke,  player);
      			
      		 }
           else if (player2move.movename.equals("morningsun")) {
        	   
      			 morningsun(player2poke, player2move, player1poke,  player);
      			
      		 }
           else if (player2move.movename.equals("roost")) {
        	   
    			 roost(player2poke, player2move, player1poke,  player);
    			
    		 }

           else if (player2move.movename.equals("synthesis")) {
        	   
  			 synthesis(player2poke, player2move, player1poke,  player);
  			
  		 }
           else if (player2move.movename.equals("aquaring")) {
        	   
    			 aquaring(player2poke, player2move, player1poke,  player);
    			
    		 } //SET UP MOVES
           else if (player2move.movename.equals("swordsdance")) {
        	   
        	   swordsdance(player2poke, player2move, player1poke,  player);
  			
  		 }
		   else if (player2move.movename.equals("quiverdance")) {

			   quiverdance(player2poke, player2move, player1poke,  player);

		   }
           else if (player2move.movename.equals("focusenergy")) {
        	   
        	   focusenergy(player2poke, player2move, player1poke,  player);
  			
  		 }
           else if (player2move.movename.equals("calmmind")) {
        	   
        	   calmmind(player2poke, player2move, player1poke,  player);
  			
  		 }
           else if (player2move.movename.equals("nastyplot")) {
        	   
        	   nastyplot(player2poke, player2move, player1poke,  player);
  			
  		 }
           else if (player2move.movename.equals("tailglow")) {
 	   
        	   tailglow(player2poke, player2move, player1poke,  player);
		
           }
           else if (player2move.movename.equals("workup")) {
 	   
        	   workup(player2poke, player2move, player1poke,  player);
		
           }
          else if (player2move.movename.equals("honeclaws")) {
 	   
        	  honeclaws(player2poke, player2move, player1poke,  player);
		
           }
          else if (player2move.movename.equals("bulkup")) {
        	   
        	  bulkup(player2poke, player2move, player1poke,  player);
		
           }// STATUS MOVES
           
          else if (player2move.movename.equals("willowisp")) {
       	   
        	  willowisp(player2poke, player2move, player1poke,  player);
		
           }
          else if (player2move.movename.equals("thunderwave")) {
       	   
        	  thunderwave(player2poke, player2move, player1poke,  player);
		
           }
          else if (player2move.movename.equals("toxic")) {
       	   
        	  toxic(player2poke, player2move, player1poke,  player);
		
           }
          else if (player2move.movename.equals("confuseray")) {
       	   
        	  confuseray(player2poke, player2move, player1poke,  player);
		
           }
          else if (player2move.movename.equals("yawn")) {
          	   
        	  yawn(player2poke, player2move, player1poke,  player);
		
           }// NORMAL MOVES
          else if (player2move.movename.equals("superfang")) {
       	   
     			player1poke.hp = superfang(player2poke, player2move, player1poke,  player);
     			
     		 } 
          else if (player2move.movename.equals("return")) {
          	   
   			player1poke.hp = returnx(player2poke, player2move, player1poke,  player);
   			
   		 } 
          else if (player2move.movename.equals("quickattack")) {
          	   
   			player1poke.hp = quickattack(player2poke, player2move, player1poke,  player);
   			
   		 } 
          else if (player2move.movename.equals("extremespeed")) {
          	   
   			player1poke.hp = extremespeed(player2poke, player2move, player1poke,  player);
   			
   		 } // HIDDENPOWER
          else if (player2move.movename.equals("hiddenpower")) {
          	   
   			player1poke.hp = hiddenpower(player2poke, player2move, player1poke,  player);
   			
   		 } 
          else if (player2move.movename.equals("slash")) {
          	   
   			player1poke.hp = slash(player2poke, player2move, player1poke,  player);
   			
   		 } 
          else if (player2move.movename.equals("gigaimpact")) {
          	   
   			player1poke.hp = gigaimpact(player2poke, player2move, player1poke,  player);
   			
   		 }
          else if (player2move.movename.equals("horndrill")) {
         	   
     			player1poke.hp = horndrill(player2poke, player2move, player1poke,  player);
     			
     		 }
          else if (player2move.movename.equals("relicsong")) {
        	   
   			player1poke.hp = relicsong(player2poke, player2move, player1poke,  player);
   			
   		 }
          else if (player2move.movename.equals("bodyslam")) {
       	   
     			player1poke.hp = bodyslam(player2poke, player2move, player1poke,  player);
     			
          }
          else if (player2move.movename.equals("hyperbeam")) {
          	   
   			player1poke.hp = hyperbeam(player2poke, player2move, player1poke,  player);
   			
   		 }
		   else if (player2move.movename.equals("boomburst")) {

			   player1poke.hp = boomburst(player2poke, player2move, player1poke,  player);

		   }
		  //BUG MOVES
          else if (player2move.movename.equals("pinmissle")) {
         	   
     			player1poke.hp = pinmissle(player2poke, player2move, player1poke,  player);
     			
     		 }
          else if (player2move.movename.equals("leechlife")) {
         	   
     			player1poke.hp = leechlife(player2poke, player2move, player1poke,  player);
     			
     		 }
		   else if (player2move.movename.equals("bugbuzz")) {

			   player1poke.hp = bugbuzz(player2poke, player2move, player1poke,  player);

		   }
          else if (player2move.movename.equals("xscissor")) {
         	   
     			player1poke.hp = xscissor(player2poke, player2move, player1poke,  player);
     			
     		 }  // WATER MOVES
          else if (player2move.movename.equals("waterpulse")) {
        	   
     			player1poke.hp = waterpulse(player2poke, player2move, player1poke,  player);
     			
     		 }       
          else if (player2move.movename.equals("aquajet")) {
           	   
      			player1poke.hp = aquajet(player2poke, player2move, player1poke,  player);
      			
      		 }
          else if (player2move.movename.equals("hydropump")) {
        	   
     			player1poke.hp = hydropump(player2poke, player2move, player1poke,  player);
     			
     		 }
          else if (player2move.movename.equals("waterfall")) {
        	   
     			player1poke.hp = waterfall(player2poke, player2move, player1poke,  player);
     			
     		 }
          else if (player2move.movename.equals("surf")) {
        	   
     			player1poke.hp = surf(player2poke, player2move, player1poke,  player);
     			
     		 }
          else if (player2move.movename.equals("aquatail")) {
        	   
     			player1poke.hp = aquatail(player2poke, player2move, player1poke,  player);
     			
     		 }
		   else if (player2move.movename.equals("watershuriken")) {

			   player1poke.hp = watershuriken(player2poke, player2move, player1poke,  player);

		   }
		   // ICE MOVES
          else if (player2move.movename.equals("iceshard")) {
       	   
   			player1poke.hp = iceshard(player2poke, player2move, player1poke,  player);
   			
   		 }
          else if (player2move.movename.equals("icepunch")) {
       	   
   			player1poke.hp = icepunch(player2poke, player2move, player1poke,  player);
   			
   		 }
          else if (player2move.movename.equals("blizzard")) {
          	   
     			player1poke.hp = blizzard(player2poke, player2move, player1poke,  player);
     			
     		 }
          else if (player2move.movename.equals("icebeam")) {
          	   
     			player1poke.hp = icebeam(player2poke, player2move, player1poke,  player);
     			
     		 }
          else if (player2move.movename.equals("icefang")) {
          	   
     			player1poke.hp = icefang(player2poke, player2move, player1poke,  player);
     			
     		 }// DrAGON MOVES
         else if (player2move.movename.equals("dragonpulse")) {
         	   
   			player1poke.hp = dragonpulse(player2poke, player2move, player1poke,  player);
   			
   		 }
        else if (player2move.movename.equals("dragonclaw")) {
        	   
   			player1poke.hp = dragonclaw(player2poke, player2move, player1poke,  player);
   			
   		 }
        else if (player2move.movename.equals("dracometeor")) {
        	   
   			player1poke.hp = dracometeor(player2poke, player2move, player1poke,  player);
   			//FAIRY MOVES
   		 }
        else if (player2move.movename.equals("moonblast")) {
     	   
   			player1poke.hp = moonblast(player2poke, player2move, player1poke,  player);
   			
   		 }
	   else if (player2move.movename.equals("playrough")) {

		   player1poke.hp = playrough(player2poke, player2move, player1poke,  player);

	   }
        else if (player2move.movename.equals("dazzlinggleam")) {
        	   
   			player1poke.hp = dazzlinggleam(player2poke, player2move, player1poke,  player);
   			
   		 }// FLYING MOVES
        else if (player2move.movename.equals("aerialace")) {
     	   
   			player1poke.hp = aerialace(player2poke, player2move, player1poke,  player);
   			
   		 }
        else if (player2move.movename.equals("airslash")) {
      	   
   			player1poke.hp = airslash(player2poke, player2move, player1poke,  player);
   			
   		 }
        else if (player2move.movename.equals("bravebird")) {
     	   
   			player1poke.hp = bravebird(player2poke, player2move, player1poke,  player);
   			
   		 }
        else if (player2move.movename.equals("bounce")) {
        	   
   			player1poke.hp = bounce(player2poke, player2move, player1poke,  player);
   			
   		 }//DRAGONDANCE
        else if (player2move.movename.equals("dragondance")) {
     	   
   			 dragondance(player2poke, player2move, player1poke,  player);
   			
   		 }// FIGHTING MOVES
        else if (player2move.movename.equals("closecombat")) {
      	   
   			player1poke.hp = closecombat(player2poke, player2move, player1poke,  player);
   			
   		 }
        else if (player2move.movename.equals("superpower")) {
      	   
   			player1poke.hp = superpower(player2poke, player2move, player1poke,  player);
   			
   		 }
        else if (player2move.movename.equals("brickbreak")) {
      	   
   			player1poke.hp = brickbreak(player2poke, player2move, player1poke,  player);
   			
   		 }
	   else if (player2move.movename.equals("drainpunch")) {

		   player1poke.hp = drainpunch(player2poke, player2move, player1poke,  player);

	   }
        else if (player2move.movename.equals("focusblast")) {
      	   
   			player1poke.hp = focusblast(player2poke, player2move, player1poke,  player);
   			
   		 }
	   else if (player2move.movename.equals("aurasphere")) {

		   player1poke.hp = aurasphere(player2poke, player2move, player1poke,  player);

	   }
        else if (player2move.movename.equals("doublekick")) {
       	   
   			player1poke.hp = doublekick(player2poke, player2move, player1poke,  player);
   			
   		 }
        else if (player2move.movename.equals("crosschop")) {
      	   
   			player1poke.hp = crosschop(player2poke, player2move, player1poke,  player);
   			
   		 }
        else if (player2move.movename.equals("dynamicpunch")) {
      	   
   			player1poke.hp = dynamicpunch(player2poke, player2move, player1poke,  player);
   			
   		 }// FIRE MOVES
        else if (player2move.movename.equals("flamethrower")) {
       	   
   			player1poke.hp = flamethrower(player2poke, player2move, player1poke,  player);
   			
   		 }
        else if (player2move.movename.equals("firepunch")) {
       	   
   			player1poke.hp = firepunch(player2poke, player2move, player1poke,  player);
   			
   		 }
        else if (player2move.movename.equals("firefang")) {
      	   
   			player1poke.hp = firefang(player2poke, player2move, player1poke,  player);
   			
   		 }
        else if (player2move.movename.equals("flareblitz")) {
      	   
   			player1poke.hp = flareblitz(player2poke, player2move, player1poke,  player);
   			
   		 }// ELECTRIC MOVES
        
        else if (player2move.movename.equals("thunderbolt")) {
        	   
   			player1poke.hp = thunderbolt(player2poke, player2move, player1poke,  player);
   			
   		 }
        else if (player2move.movename.equals("thunderpunch")) {
       	   
   			player1poke.hp = thunderpunch(player2poke, player2move, player1poke,  player);
   			
   		 }
	   else if (player2move.movename.equals("volttackle")) {

		   player1poke.hp = volttackle(player2poke, player2move, player1poke,  player);

	   }
	   else if (player2move.movename.equals("plasmafists")) {

		   player1poke.hp = plasmafists(player2poke, player2move, player1poke,  player);

	   }
        else if (player2move.movename.equals("thunderfang")) {
      	   
   			player1poke.hp = thunderfang(player2poke, player2move, player1poke,  player);
   			
   		 }
        else if (player2move.movename.equals("wildcharge")) {
      	   
   			player1poke.hp = wildcharge(player2poke, player2move, player1poke,  player);
   			
   		 }// POISON MOVES
        else if (player2move.movename.equals("sludgebomb")) {
        	   
   			player1poke.hp = sludgebomb(player2poke, player2move, player1poke,  player);
   			
   		 }
	   else if (player2move.movename.equals("gunkshot")) {

		   player1poke.hp = gunkshot(player2poke, player2move, player1poke,  player);

	   }
        else if (player2move.movename.equals("poisonjab")) {
      	   
   			player1poke.hp = poisonjab(player2poke, player2move, player1poke,  player);
   			
   		 }
        else if (player2move.movename.equals("crosspoison")) {
      	   
   			player1poke.hp = crosspoison(player2poke, player2move, player1poke,  player);
   			
   		 } // DARK MOVES
        else if (player2move.movename.equals("suckerpunch")) {
       	   
        	
        	if( ((player1move.attacktype.equals("sp")) || (player1move.attacktype.equals("ph"))) && (player1move.priority <= player2move.priority)  ) {
        		
   			player1poke.hp = suckerpunch(player2poke, player2move, player1poke,  player);
   			
        	}
        	else {
        		
        		System.out.println("Suckerpunch failed because the opponent is not using a physical or special move,");
        		return;
        	}
        	
   		 }    
        else if (player2move.movename.equals("crunch")) {
       	   
   			player1poke.hp = crunch(player2poke, player2move, player1poke,  player);
   			
   		 }
        else if (player2move.movename.equals("darkpulse")) {
        	   
   			player1poke.hp = darkpulse(player2poke, player2move, player1poke,  player);
   			
   		 }
        else if (player2move.movename.equals("nightslash")) {
      	   
   			player1poke.hp = nightslash(player2poke, player2move, player1poke,  player);
   			
   		 }
        else if (player2move.movename.equals("foulplay")) {
      	   
   			player1poke.hp = foulplay(player2poke, player2move, player1poke,  player);
   			
   		 }//PSYCHIC MOVES
        else if (player2move.movename.equals("psychic")) {
       	   
   			player1poke.hp = psychic(player2poke, player2move, player1poke,  player);
   			
   		 }
	   else if (player2move.movename.equals("extrasensory")) {

		   player1poke.hp = extrasensory(player2poke, player2move, player1poke,  player);

	   }
        else if (player2move.movename.equals("zenheadbut")) {
      	   
   			player1poke.hp = zenheadbut(player2poke, player2move, player1poke,  player);
   			
   		 }// GHOST MOVES
        else if (player2move.movename.equals("shadowball")) {
        	   
   			player1poke.hp = shadowball(player2poke, player2move, player1poke,  player);
   			
   		 }
	   else if (player2move.movename.equals("shadowclaw")) {

		   player1poke.hp = shadowclaw(player2poke, player2move, player1poke,  player);

	   }
	   else if (player2move.movename.equals("shadowsneak")) {

		   player1poke.hp = shadowsneak(player2poke, player2move, player1poke,  player);

	   }// GROUND MOVES
        else if (player2move.movename.equals("earthquake")) {
     	   
   			player1poke.hp = earthquake(player2poke, player2move, player1poke,  player);
   			
   		 }// ROCK MOVES
        else if (player2move.movename.equals("rockslide")) {
     	   
   			player1poke.hp = rockslide(player2poke, player2move, player1poke,  player);
   			
   		 }
        else if (player2move.movename.equals("stoneedge")) {
     	   
   			player1poke.hp = stoneedge(player2poke, player2move, player1poke,  player);
   			
   		 }// GRASS MOVES
        else if (player2move.movename.equals("energyball")) {
      	   
   			player1poke.hp = energyball(player2poke, player2move, player1poke,  player);
   			
   		 }
        else if (player2move.movename.equals("leafblade")) {
     	   
   			player1poke.hp = leafblade(player2poke, player2move, player1poke,  player);
   			
   		 }

         
            		
           
        	   
        	   //flamebody
           
           if(player2move.attacktype.equals("ph")) {
        	   
        	   
        	   if(player1poke.ability.equals("flamebody")){
        		   
          		 if( (player2poke.status.equals(" No status conditions")) && !(player2poke.type1.equals("fire")) && !(player2poke.type2.equals("fire")) ) {
          			 int hit = rand.nextInt(10);
                 		
                 		if(hit > 4) {
                 			player2poke.status = "Burned";
                 			soundeffects.burned();
                 			if(player2poke.move1.attacktype.equals("ph")) {
                 				player2poke.move1.power *= 0.5;
                 			}
                 			if(player2poke.move2.attacktype.equals("ph")) {
                 				player2poke.move2.power *= 0.5;
                 			}
                 			if(player2poke.move3.attacktype.equals("ph")) {
                 				player2poke.move3.power *= 0.5;
                 			}
                 			if(player2poke.move4.attacktype.equals("ph")) {
                 				player2poke.move4.power *= 0.5;
                 			}
                 		 System.out.println( player1poke.pokename + " has burned the opponent's " + player2poke.pokename + " due to its flame body!! " + player2poke.pokename + "'s physical attacks power has been cut in half. ");
                 		 
                }
                
                
                }
                
       }
        	   
           }





		//poisonpoint

		if(player2move.attacktype.equals("ph")) {


			if(player1poke.ability.equals("poisonpoint")){

				if( (player2poke.status.equals(" No status conditions")) && !(player2poke.type1.equals("poison")) && !(player2poke.type2.equals("poison")) ) {
					int hit = rand.nextInt(10);

					if(hit > 4) {
						player2poke.status = "Toxic";
						soundeffects.poisoned();

						System.out.println( player1poke.pokename + " has poisoned the opponent's " + player2poke.pokename + " due to its poisonpoint!! " + player2poke.pokename + " is kinda screwed. ");

					}


				}

			}

		}



//static
		if(player2move.attacktype.equals("ph")) {


			if(player1poke.ability.equals("static")){

				if( (player2poke.status.equals(" No status conditions"))  ) {
					int hit = rand.nextInt(10);

					if(hit > 4) {
						player2poke.status = "Paralyzed";
						soundeffects.paralyze();
						player2poke.speed *= 0.5;
						System.out.println( player1poke.pokename + " has paralyzed the opponent's " + player2poke.pokename + " due to its static ability!! " + player2poke.pokename + "'s speed has been cut in half. ");

					}


				}

			}

		}






		//roughskin
		if(player2move.attacktype.equals("ph")) {


			if(player1poke.ability.equals("roughskin")){




				soundeffects.attack();

				System.out.println( player1poke.pokename + " has hurt the opponent's " + player2poke.pokename + " with its rough skin!! ");

				double rough = (player2poke.maxhp * 0.125);
				System.out.println("ROUGH SKIN DAMAGE: " + player2poke.hp + " - " + rough + " = " + (player2poke.hp - rough));
				player2poke.hp -=rough;








			}

		}

		//checks if any player's pokemon have fainted
		if( (player1poke.hp <= 0) || (player2poke.hp <= 0)){
			return;
		}


		//gooey
		if(player2move.attacktype.equals("ph")) {


			if(player1poke.ability.equals("gooey")){




				soundeffects.drop();

				System.out.println( player1poke.pokename + " has slowed down the opponent's " + player2poke.pokename + " with its gooey skin!! ");

				player2poke.speed *= 0.5;







			}

		}

           /*
            * 
            * 
		String[] psychictype = { "psychic", "zenheadbut" , "calmmind" }; // psychic type moves
		
		String[] ghosttype = {"shadowball" , "confuseray" }; // ghost type moves
		
		String[] groundtype = { "earthquake"  }; // ground type moves
		
		String[] rocktype = {"stoneedge", "rockslide"   }; // rock type moves 
		
		
            */
         //String[] icetype = { "iceshard", "icepunch" , "icebeam", "blizzard", "icefang" }; // ice type moves
   		
   		
           // quickattack, slash, return, gigaimpact, superfang, horndrill, extremespeed, 
   		

    	}
	
    
    
    
    
    
    /*
     * 
    
     * 
     * STEEL TYPE POKEMON ATTACKS
     * 
     * 
     * 
     * 
     */
    
    
    
    
    // This is the code for the move meteor mash , a steel move 
    public static double meteormash(pokemon attacker, move attack, pokemon defender, String player) {
    
    
    	
    	if((defender.bounce == true) && !(attacker.ability.equals("noguard")) ) { // Checks if the opponent is in the air....
    		
    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
    		return defender.hp;
    	}
    
    	double health = defender.hp; // health value of the pokemon being attacked
    	
    	//working
		
    	double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; // The stupid damage roll pokemon made in gen 3: 0.85-1, 
    	
    	
    	soundeffects.noo(); 
    	
    	
    	System.out.println("Your damage roll is " + roll);
    	
    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


		if(attacker.ability.equals("toughclaws")){


			damage *= 1.3;
			System.out.println("Tough claws increased the damage of the attack!!");


		}

    	// make sure to code for crits 
    	
    	int crit = rand.nextInt(400);
    	
    	
    	
    	if (attack.critrate == 3.0)  {
    
	     
    	     if (crit <= 27) {
    	
    	    	 	
    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
    		    
    			 if(attacker.ability.equals("sniper")) {
    				 
    				 damage *= 2.5;
    				 System.out.println("\n You got the sniper boost \n");
    			 }
    			 else {
    				 
    				 
    			 damage *= 1.5;
    			 
    			 }
    	     }
    	
    	}
    	else if (attack.critrate == 6.0) {
     		
     		
    		 if (crit <= 55) {
    		    	
    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
    		    
    			 if(attacker.ability.equals("sniper")) {
    				 
    				 damage *= 2.5;
    				 System.out.println("\n You got the sniper boost \n");
    			 }
    			 else {
    			 damage *= 1.5;
    			 }
    	     }
     		
	    }
    	else {
    		
    		

   		 if (crit <= 101) {
   		    	
   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
   		    
   			 if(attacker.ability.equals("sniper")) {
   				 
   				 damage *= 2.5;
   				 System.out.println("\n You got the sniper boost \n");
   			 }
   			 else {
   			 damage *= 1.5;
   			 }
   	     }
    		
    		
    		
    	}
    	
    	
	
        if(   (defender.type1.equals("fire")) || (defender.type1.equals("water")) || (defender.type1.equals("steel")) || (defender.type1.equals("electric")) ) {
    		
    		damage *= 0.5;  //Steel is resisted by these types
    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists  soundeffects.resist(); // plays sound effect for a move that resists 
    		
    	}
    	

        if(   (defender.type2.equals("fire")) || (defender.type2.equals("water")) || (defender.type2.equals("steel")) || (defender.type2.equals("electric")) ) {
    		
    		damage *= 0.5;  //Steel is resisted by these types
    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
    		
    	}
        
        
        
        if(   (defender.type1.equals("rock")) || (defender.type1.equals("ice")) || (defender.type1.equals("fairy"))  ) {
    		
    		damage *= 2;  //Steel is super effective against these types
    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting  	
    		
    	}
    	

        if(   (defender.type2.equals("rock")) || (defender.type2.equals("ice")) || (defender.type2.equals("fairy")) ) {
    		
    		damage *= 2;  //Steel is super effective agaisnt these types
    		System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting  	soundeffects.attack(); // This plays a sound effect of the move hitting
    		
    	}
        
        
        if( (defender.ability.equals("multiscale") ) ){
          	 
      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
      	    	 
      	     System.out.println("multiscale reduced the damage the pokemon took");
      	     
      	     damage = damage/2;
      	     
      	     }
      	 }
        
        if(defender.ability.equals("solidrock")){
       	 
       	
       	 damage *= 0.66;
       	 
       	 System.out.println("Solid rock reduced the damage of the attack");
       	 
       	 }
       	 


        damage = Math.round(damage);
        
        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
    	

        health =  health - damage; 
    	
    	 
        
		int boost = rand.nextInt(100);
		
		
		if (boost <= 20) {
			
			attacker.attack *= 1.5;
			System.out.println(boost + "   "  + "Your pokemon just got the meteormash attack boost !!!!! \n");
			soundeffects.statincrease();
		}
    	
	
		
		if(defender.ability.equals("stamina")) {
			
			defender.def *= 1.5;
			soundeffects.statincrease();
			System.out.println("The opposing pokemon's defense rose");
		}
		
		
    	return Math.round(health);
    	
		
    	
    	
    }
    
    
    
    
  
    
    
    // Attempting to code bullet punch, a steel move 
    
    public static double bulletpunch(pokemon attacker, move attack, pokemon defender, String player) {
    
    	
    	if((defender.bounce == true) && !(attacker.ability.equals("noguard")) )  { // Checks if the opponent is in the air....
    		
    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
    		return defender.hp; // misses if the opponent is in the air
    	}


    	double health = defender.hp; // health value of the pokemon being attacked
    	
    	
          double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; // The stupid damage roll pokemon made in gen 3: 0.85-1
    	
          soundeffects.noo(); 
          
    	System.out.println("Your damage roll is " + roll);
    	
    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


		if(attacker.ability.equals("toughclaws")){


			damage *= 1.3;
			System.out.println("Tough claws increased the damage of the attack!!");


		}

    	// make sure to code for crits 
    	
    	int crit = rand.nextInt(400);
    	
    	
    	
    	if (attack.critrate == 3.0)  {
    
	     
    	     if (crit <= 27) {
    	
    	    	 	
    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
    		    
    			 if(attacker.ability.equals("sniper")) {
    				 
    				 damage *= 2.5;
    				 System.out.println("\n You got the sniper boost \n");
    			 }
    			 else {
    				 
    				 
    			 damage *= 1.5;
    			 
    			 }
    	     }
    	
    	}
    	else if (attack.critrate == 6.0) {
     		
     		
    		 if (crit <= 55) {
    		    	
    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
    		    
    			 if(attacker.ability.equals("sniper")) {
    				 
    				 damage *= 2.5;
    				 System.out.println("\n You got the sniper boost \n");
    			 }
    			 else {
    			 damage *= 1.5;
    			 }
    	     }
     		
	    }
    	else {
    		
    		

   		 if (crit <= 101) {
   		    	
   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
   		    
   			 if(attacker.ability.equals("sniper")) {
   				 
   				 damage *= 2.5;
   				 System.out.println("\n You got the sniper boost \n");
   			 }
   			 else {
   			 damage *= 1.5;
   			 }
   	     }
    		
    		
    		
    	}
    	
    	
	
        if(   (defender.type1.equals("fire")) || (defender.type1.equals("water")) || (defender.type1.equals("steel")) || (defender.type1.equals("electric")) ) {
    		
    		damage *= 0.5;  //Steel is resisted by these types
    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");soundeffects.resist(); 
    		
    	}
    	

        if(   (defender.type2.equals("fire")) || (defender.type2.equals("water")) || (defender.type2.equals("steel")) || (defender.type2.equals("electric")) ) {
    		
    		damage *= 0.5;  //Steel is resisted by these types
    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
    		
    	}
        
        
        if(   (defender.type1.equals("rock")) || (defender.type1.equals("ice")) || (defender.type1.equals("fairy"))  ) {
    		
    		damage *= 2;  //Steel is super effective against these types
    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
    		
    	}
    	

        if(   (defender.type2.equals("rock")) || (defender.type2.equals("ice")) || (defender.type2.equals("fairy")) ) {
    		
    		damage *= 2;  //Steel is super effective agaisnt these types
    		System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting
    		
    	}



   	 if( (defender.ability.equals("multiscale") ) ){
   	 
   	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
   	     
   	     damage = damage/2;
   	     
   	     }
   	 }
   	 
   	 
   	 if(attacker.ability.equals("technician")) {
   		 
   		 
   		 damage *= 1.5;
   		 System.out.println("Technician powered up the hit!!");
   	 }
   	 

 	if(defender.ability.equals("solidrock")){
 	 
 	damage = damage * 0.6;
 	 System.out.println("Solid rock reduced the damage of the attack");
 	 
 	 }
   	 
        damage = Math.round(damage);
        
        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
    	
        

    	 
        health =  health - damage; 
        
        
        
        if(defender.ability.equals("stamina")) {
			
			defender.def *= 1.5;
			soundeffects.statincrease();
			System.out.println("The opposing pokemon's defense rose");
		}
    	
    	return Math.round(health);
    	
    	
    	
    }
    
    
    
    
    
    
    // attempting to code iron tail, a steel move
    
    // ALL STEEL TYPE MOVES ARE CODED IN THE GAME 

    // coded bullet punch, irontail, steelwing, doubleironbash, ironhead,  flashcannon and meteor mash.
    
    // Attempting to code iron tail
    
    
   // the attacker pokemon is the pokemon attacking, the attack is the move being used, the defender pokemon is the pokemon defending itself and player is player1/2 string 
    public static double irontail(pokemon attacker, move attack, pokemon defender, String player) {
    
    	if((defender.bounce == true) && !(attacker.ability.equals("noguard")) ) { // Checks if the opponent is in the air....
    		
    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
    		return defender.hp; // misses if the opponent is in the air
    	}



    	double health = defender.hp; // health value of the pokemon being attacked


		double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; // The stupid damage roll pokemon made in gen 3: 0.85-1
    	
        soundeffects.noo(); 
        
    	System.out.println("Your damage roll is " + roll);
    	
    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)




		if(attacker.ability.equals("toughclaws")){


			damage *= 1.3;
			System.out.println("Tough claws increased the damage of the attack!!");


		}

    	// make sure to code for crits 
    	
    	int crit = rand.nextInt(400);
    	
    	
    	
    	if (attack.critrate == 3.0)  {
    
	     
    	     if (crit <= 27) {
    	
    	    	 	
    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
    		    
    			 if(attacker.ability.equals("sniper")) {
    				 
    				 damage *= 2.5;
    				 System.out.println("\n You got the sniper boost \n");
    			 }
    			 else {
    				 
    				 
    			 damage *= 1.5;
    			 
    			 }
    	     }
    	
    	}
    	else if (attack.critrate == 6.0) {
     		
     		
    		 if (crit <= 55) {
    		    	
    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
    		    
    			 if(attacker.ability.equals("sniper")) {
    				 
    				 damage *= 2.5;
    				 System.out.println("\n You got the sniper boost \n");
    			 }
    			 else {
    			 damage *= 1.5;
    			 }
    	     }
     		
	    }
    	else {
    		
    		

   		 if (crit <= 101) {
   		    	
   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
   		    
   			 if(attacker.ability.equals("sniper")) {
   				 
   				 damage *= 2.5;
   				 System.out.println("\n You got the sniper boost \n");
   			 }
   			 else {
   			 damage *= 1.5;
   			 }
   	     }
    		
    		
    		
    	}
    	
    	
	
        if(   (defender.type1.equals("fire")) || (defender.type1.equals("water")) || (defender.type1.equals("steel")) || (defender.type1.equals("electric")) ) {
    		
    		damage *= 0.5;  //Steel is resisted by these types
    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n "); soundeffects.resist(); 
    		
    	}
    	

        if(   (defender.type2.equals("fire")) || (defender.type2.equals("water")) || (defender.type2.equals("steel")) || (defender.type2.equals("electric")) ) {
    		
    		damage *= 0.5;  //Steel is resisted by these types
    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
    		
    	}
        
        
        if(   (defender.type1.equals("rock")) || (defender.type1.equals("ice")) || (defender.type1.equals("fairy"))  ) {
    		
    		damage *= 2;  //Steel is super effective against these types
    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
    		
    	}
    	

        if(   (defender.type2.equals("rock")) || (defender.type2.equals("ice")) || (defender.type2.equals("fairy")) ) {
    		
    		damage *= 2;  //Steel is super effective agaisnt these types
    		System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting
    		
    	}
        
        
        if( (defender.ability.equals("multiscale") ) ){
          	 
      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
      	     
      	     damage = damage/2;
      	     
      	     }
      	 }
      	 

    	if(defender.ability.equals("solidrock")){
    	 
    	damage = damage * 0.6;
    	 System.out.println("Solid rock reduced the damage of the attack");
    	 
    	 }
    	 
        
        
        damage = Math.round(damage);
        
        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
    	
        
        
		int drop = rand.nextInt(100);
		
		if(defender.ability.equals("clearbody")) {
			
			if (drop <= 30) {
    			
    		
    			System.out.println(drop + ":  YOUR pokemon would have gotten the irontail defense drop, but THE OPPOSING pokemon's clear body stops it !!!!! \n");
    			
			}
			
		}
		else {
			
			if (drop <= 30) {
			
			defender.def *= 0.5;
			soundeffects.drop();
			System.out.println(drop + ": YOUR pokemon just got the irontail defense drop, THE OPPOSING pokemon's defense fell !!!!! \n");
			}
		
		}
		

        
        health =  health - damage; 
    	
        if(defender.ability.equals("stamina")) {
			
			defender.def *= 1.5;
			soundeffects.statincrease();
			System.out.println("The opposing pokemon's defense rose");
		}
    	return Math.round(health);
    	
    	
    	
    }
    
    
    // double iron bash 
    
    public static double doubleironbash(pokemon attacker, move attack, pokemon defender, String player) {
    
    	
    	if((defender.bounce == true) && !(attacker.ability.equals("noguard")) ) {// Checks if the opponent is in the air....
    		
    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
    		return defender.hp; // misses if the opponent is in the air
    	}
    	
    	

    	double health = defender.hp; // health value of the pokemon being attacked


		double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; // The stupid damage roll pokemon made in gen 3: 0.85-1
		
        soundeffects.noo(); 
        
    	System.out.println("Your damage roll is " + roll);
    	
    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


		if(attacker.ability.equals("toughclaws")){


			damage *= 1.3;
			System.out.println("Tough claws increased the damage of the attack!!");


		}

    	// make sure to code for crits 
    	
    	int crit = rand.nextInt(400);
    	
    	
    	
    	if (attack.critrate == 3.0)  {
    
	     
    	     if (crit <= 27) {
    	
    	    	 	
    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
    		    
    			 if(attacker.ability.equals("sniper")) {
    				 
    				 damage *= 2.5;
    				 System.out.println("\n You got the sniper boost \n");
    			 }
    			 else {
    				 
    				 
    			 damage *= 1.5;
    			 
    			 }
    	     }
    	
    	}
    	else if (attack.critrate == 6.0) {
     		
     		
    		 if (crit <= 55) {
    		    	
    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
    		    
    			 if(attacker.ability.equals("sniper")) {
    				 
    				 damage *= 2.5;
    				 System.out.println("\n You got the sniper boost \n");
    			 }
    			 else {
    			 damage *= 1.5;
    			 }
    	     }
     		
	    }
    	else {
    		
    		

   		 if (crit <= 101) {
   		    	
   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
   		    
   			 if(attacker.ability.equals("sniper")) {
   				 
   				 damage *= 2.5;
   				 System.out.println("\n You got the sniper boost \n");
   			 }
   			 else {
   			 damage *= 1.5;
   			 }
   	     }
    		
    		
    		
    	}
    	
    	
	
        if(   (defender.type1.equals("fire")) || (defender.type1.equals("water")) || (defender.type1.equals("steel")) || (defender.type1.equals("electric")) ) {
    		
    		damage *= 0.5;  //Steel is resisted by these types
    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");
    		soundeffects.resist(); 
    	}
    	

        if(   (defender.type2.equals("fire")) || (defender.type2.equals("water")) || (defender.type2.equals("steel")) || (defender.type2.equals("electric")) ) {
    		
    		damage *= 0.5;  //Steel is resisted by these types
    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
    		
    	}
        
        
        
        if(   (defender.type1.equals("rock")) || (defender.type1.equals("ice")) || (defender.type1.equals("fairy"))  ) {
    		
    		damage *= 2;  //Steel is super effective against these types
    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
    		
    	}
    	

        if(   (defender.type2.equals("rock")) || (defender.type2.equals("ice")) || (defender.type2.equals("fairy")) ) {
    		
    		damage *= 2;  //Steel is super effective agaisnt these types
    		System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting
    		
    	}
        
        
        if( (defender.ability.equals("multiscale") ) ){
          	 
      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
      	     
      	     damage = damage/2;
      	     
      	     }
      	 }
        
        
        
        if(attacker.ability.equals("ironfist")) {
        	
        	damage *= 1.3;
        	
        	System.out.println("Ironfist powered up the hit!!!");
        }
        
        

    	if(defender.ability.equals("solidrock")){
    	 
    	damage = damage * 0.6;
    	 System.out.println("Solid rock reduced the damage of the attack");
    	 
    	 }
    	 
        
        
        damage = Math.round(damage);
        
        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
    	
        
        health =  health - damage; 
    	
        if(defender.ability.equals("stamina")) {
			
			defender.def *= 1.5;
			soundeffects.statincrease();
			System.out.println("The opposing pokemon's defense rose");
		}
        
        
    	return Math.round(health);
    	
    	
    	
    }
    
    // steelwing
    
    public static double steelwing(pokemon attacker, move attack, pokemon defender, String player) {
	
    	
    	if(defender.bounce == true) { // Checks if the opponent is in the air....
    		
    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
    		return defender.hp; // misses if the opponent is in the air
    	}
	
	
    	double health = defender.hp; // health value of the pokemon being attacked
    	
    	
        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
    	
        soundeffects.noo(); 
        
    	System.out.println("Your damage roll is " + roll);
    	
    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


		if(attacker.ability.equals("toughclaws")){


			damage *= 1.3;
			System.out.println("Tough claws increased the damage of the attack!!");


		}

    	// make sure to code for crits 
    	
    	int crit = rand.nextInt(400);
    	
    	
    	
    	if (attack.critrate == 3.0)  {
    
	     
    	     if (crit <= 27) {
    	
    	    	 	
    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
    		    
    			 if(attacker.ability.equals("sniper")) {
    				 
    				 damage *= 2.5;
    				 System.out.println("\n You got the sniper boost \n");
    			 }
    			 else {
    				 
    				 
    			 damage *= 1.5;
    			 
    			 }
    	     }
    	
    	}
    	else if (attack.critrate == 6.0) {
     		
     		
    		 if (crit <= 55) {
    		    	
    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
    		    
    			 if(attacker.ability.equals("sniper")) {
    				 
    				 damage *= 2.5;
    				 System.out.println("\n You got the sniper boost \n");
    			 }
    			 else {
    			 damage *= 1.5;
    			 }
    	     }
     		
	    }
    	else {
    		
    		

   		 if (crit <= 101) {
   		    	
   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
   		    
   			 if(attacker.ability.equals("sniper")) {
   				 
   				 damage *= 2.5;
   				 System.out.println("\n You got the sniper boost \n");
   			 }
   			 else {
   			 damage *= 1.5;
   			 }
   	     }
    		
    		
    		
    	}
    	
    	
	
        if(   (defender.type1.equals("fire")) || (defender.type1.equals("water")) || (defender.type1.equals("steel")) || (defender.type1.equals("electric")) ) {
    		
    		damage *= 0.5;  //Steel is resisted by these types
    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");
    		
    	}
    	 

        if(   (defender.type2.equals("fire")) || (defender.type2.equals("water")) || (defender.type2.equals("steel")) || (defender.type2.equals("electric")) ) {
    		
    		damage *= 0.5;  //Steel is resisted by these types
    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
    		
    	}
        
        
        if(   (defender.type1.equals("rock")) || (defender.type1.equals("ice")) || (defender.type1.equals("fairy"))  ) {
    		
    		damage *= 2;  //Steel is super effective against these types
    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
    		
    	}
    	

        if(   (defender.type2.equals("rock")) || (defender.type2.equals("ice")) || (defender.type2.equals("fairy")) ) {
    		
    		damage *= 2;  //Steel is super effective agaisnt these types
    		System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting
    		
    	}
        
        
        if( (defender.ability.equals("multiscale") ) ){
          	 
      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
      	     
      	     damage = damage/2;
      	     
      	     }
      	 }

    	if(defender.ability.equals("solidrock")){
    	 
    	damage = damage * 0.6;
    	 System.out.println("Solid rock reduced the damage of the attack");
    	 
    	 }
    	 
        
        damage = Math.round(damage);
        
        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
    	
        
        health =  health - damage; 
    	
    	
      
		int boost = rand.nextInt(100);
		
		
		if (boost <= 10) {
			
			attacker.def *= 1.5;
			soundeffects.statincrease();
			System.out.println(boost + ": YOUR pokemon just got the steel wing defense boost !!!!! \n");
		}
		
		
        
    	
    
		if(defender.ability.equals("stamina")) {
			
			defender.def *= 1.5;
			soundeffects.statincrease();
			System.out.println("The opposing pokemon's defense rose");
		}
    
    	return Math.round(health);
    	
    	
    	
    }
    
    
    
    // ironhead
    
    	public static double ironhead(pokemon attacker, move attack, pokemon defender, String player) {
        
    		
        	
        	if(defender.bounce == true) { // Checks if the opponent is in the air....
        		
        		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        		return defender.hp; // misses if the opponent is in the air
        	}
    	
    	
        	
    	double health = defender.hp; // health value of the pokemon being attacked
    	
    	
        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
    	
        soundeffects.noo(); 
        
    	System.out.println("Your damage roll is " + roll);
    	
    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


			if(attacker.ability.equals("toughclaws")){


				damage *= 1.3;
				System.out.println("Tough claws increased the damage of the attack!!");


			}

    	// make sure to code for crits 
    	
    	int crit = rand.nextInt(400);
    	
    	
    	
    	if (attack.critrate == 3.0)  {
    
	     
    	     if (crit <= 27) {
    	
    	    	 	
    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
    		    
    			 if(attacker.ability.equals("sniper")) {
    				 
    				 damage *= 2.5;
    				 System.out.println("\n You got the sniper boost \n");
    			 }
    			 else {
    				 
    				 
    			 damage *= 1.5;
    			 
    			 }
    	     }
    	
    	}
    	else if (attack.critrate == 6.0) {
     		
     		
    		 if (crit <= 55) {
    		    	
    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
    		    
    			 if(attacker.ability.equals("sniper")) {
    				 
    				 damage *= 2.5;
    				 System.out.println("\n You got the sniper boost \n");
    			 }
    			 else {
    			 damage *= 1.5;
    			 }
    	     }
     		
	    }
    	else {
    		
    		

   		 if (crit <= 101) {
   		    	
   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
   		    
   			 if(attacker.ability.equals("sniper")) {
   				 
   				 damage *= 2.5;
   				 System.out.println("\n You got the sniper boost \n");
   			 }
   			 else {
   			 damage *= 1.5;
   			 }
   	     }
    		
    		
    		
    	}
    	
    	
	
        if(   (defender.type1.equals("fire")) || (defender.type1.equals("water")) || (defender.type1.equals("steel")) || (defender.type1.equals("electric")) ) {
    		
    		damage *= 0.5;  //Steel is resisted by these types
    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");
    		
    	}
    	

        if(   (defender.type2.equals("fire")) || (defender.type2.equals("water")) || (defender.type2.equals("steel")) || (defender.type2.equals("electric")) ) {
    		
    		damage *= 0.5;  //Steel is resisted by these types
    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
    		
    	}
        
        
        if(   (defender.type1.equals("rock")) || (defender.type1.equals("ice")) || (defender.type1.equals("fairy"))  ) {
    		
    		damage *= 2;  //Steel is super effective against these types
    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
    		
    	}//System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting
    	

        if(   (defender.type2.equals("rock")) || (defender.type2.equals("ice")) || (defender.type2.equals("fairy")) ) {
    		
    		damage *= 2;  //Steel is super effective agaisnt these types
    		System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting
    		
    	}
        
        
        if( (defender.ability.equals("multiscale") ) ){
          	 
      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
      	     
      	     damage = damage/2;
      	     
      	     }
      	 }
        

    	if(defender.ability.equals("solidrock")){
    	 
    	damage = damage * 0.6;
    	 System.out.println("Solid rock reduced the damage of the attack");
    	 
    	 }
    	 
        damage = Math.round(damage);
        
        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
    	
        
        health =  health - damage; 
    	
    	int flinch = rand.nextInt(10);
    	
    	if ((flinch <= 3) && (attacker.speed >= defender.speed)){
    		
    		System.out.println(flinch + " The opposing pokemon is flinched");
    		defender.flinched = true;
    		
    	}
    	
    	
    	if(attacker.ability.equals("serenegrace")) {
    		
    		
    		if ((flinch <= 6) && (attacker.speed >= defender.speed)){
        		
        		System.out.println(flinch + " The opposing pokemon is flinched (Serene grace came in clutch) ");
        		defender.flinched = true;
        		
        	}
    		
    		
    	}
      
    	
    	 
    	
        
		if(defender.ability.equals("stamina")) {
			
			defender.def *= 1.5;
			soundeffects.statincrease();
			System.out.println("The opposing pokemon's defense rose");
		}
    
    	
		
		
    	return Math.round(health);
    	
    	
    	
    }
    
    
    
    
    
     
    
     
    // flash cannon
 
 
 
    	public static double flashcannon(pokemon attacker, move attack, pokemon defender, String player) {
      
    		
    		
        	
        	if(defender.bounce == true) { // Checks if the opponent is in the air....
        		
        		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        		return defender.hp; // misses if the opponent is in the air
        	}
    	
    	
        	
  	double health = defender.hp; // health value of the pokemon being attacked
  	
  	
      double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
  	
      soundeffects.noo(); 
      
  	System.out.println("Your damage roll is " + roll);
  	
  	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.spa/ (double) defender.spdef)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)
  	
  	// make sure to code for crits 
  	
  	int crit = rand.nextInt(400);
  	
  	
  	
  	if (attack.critrate == 3.0)  {
  
	     
  	     if (crit <= 27) {
  	
  	    	 	
  			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
  		    
  			 if(attacker.ability.equals("sniper")) {
  				 
  				 damage *= 2.5;
  				 System.out.println("\n You got the sniper boost \n");
  			 }
  			 else {
  				 
  				 
  			 damage *= 1.5;
  			 
  			 }
  	     }
  	
  	}
  	else if (attack.critrate == 6.0) {
   		
   		
  		 if (crit <= 55) {
  		    	
  			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
  		    
  			 if(attacker.ability.equals("sniper")) {
  				 
  				 damage *= 2.5;
  				 System.out.println("\n You got the sniper boost \n");
  			 }
  			 else {
  			 damage *= 1.5;
  			 }
  	     }
   		
	    }
  	else {
  		
  		

 		 if (crit <= 101) {
 		    	
 			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
 		    
 			 if(attacker.ability.equals("sniper")) {
 				 
 				 damage *= 2.5;
 				 System.out.println("\n You got the sniper boost \n");
 			 }
 			 else {
 			 damage *= 1.5;
 			 }
 	     }
  		
  		
  		
  	}
  	
  	
	
      if(   (defender.type1.equals("fire")) || (defender.type1.equals("water")) || (defender.type1.equals("steel")) || (defender.type1.equals("electric")) ) {
  		
  		damage *= 0.5;  //Steel is resisted by these types
  		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");soundeffects.resist(); 
  		
  	}
  	

      if(   (defender.type2.equals("fire")) || (defender.type2.equals("water")) || (defender.type2.equals("steel")) || (defender.type2.equals("electric")) ) {
  		
  		damage *= 0.5;  //Steel is resisted by these types
  			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
  		
  	}
      
      
      
      if(   (defender.type1.equals("rock")) || (defender.type1.equals("ice")) || (defender.type1.equals("fairy"))  ) {
  		
  		damage *= 2;  //Steel is super effective against these types
  		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
  		
  	}
  	

      if(   (defender.type2.equals("rock")) || (defender.type2.equals("ice")) || (defender.type2.equals("fairy")) ) {
  		
  		damage *= 2;  //Steel is super effective agaisnt these types
  		System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting
  		
  	}
      
      
      
      if( (defender.ability.equals("multiscale") ) ){
        	 
    	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
    	     
    	     damage = damage/2;
    	     
    	     }
    	 }
      

  	if(defender.ability.equals("solidrock")){
  	 
  	damage = damage * 0.6;
  	 System.out.println("Solid rock reduced the damage of the attack");
  	 
  	 }
  	 
      damage = Math.round(damage);
      
      System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
  	
      
      health =  health - damage; 
  	
      int spdefdrop = rand.nextInt(10);
      System.out.println("will it spdef drop: " + spdefdrop);
  	
      
  	if( !(defender.ability.equals("clearbody")) ) {
		
  	   
  	    if(spdefdrop < 1) {
  	    	soundeffects.drop();
  	  		System.out.println("will it spdef drop: " + spdefdrop);
  	  		defender.spdef *= 0.5;
  	  		System.out.println(" The opposing " + player + "'s special defense fell. ");
  	  		
  	  	}
	}
      
   
    
  	return Math.round(health);
  	
  	
  	
  }   	
  
    	
    	
    	
    	
    	/*
    	 * 
    	 * 
    	 * NON ATTACKING MOVES AS METHODS
    	 * 
    	 */
    	
    	
    	
    	
    	
    	
    
    	
    	
    	//HEALING MOVES
    	
    	
         public static void recover(pokemon attacker, move attack, pokemon defender, String player) {
         	
        	double heal = (double) (attacker.maxhp/2);
        	 
        	if (attacker.hp + heal <= attacker.maxhp) {
        		
        	 System.out.println(attacker.pokename + " has been healed by recover: " + attacker.hp + "  " + " + " + heal + " =  " +  (attacker.hp + heal));
        	 attacker.hp += heal;
        	 soundeffects.heal();
        	}
        	else {
        		 soundeffects.heal();
        		attacker.hp = attacker.maxhp;
           	 System.out.println(attacker.pokename + " is at max hp: " + attacker.hp  );
           
        		
        	}
         	
        }
    	 
    	 public static void morningsun(pokemon attacker, move attack, pokemon defender, String player) {

    		 double heal = (double) (attacker.maxhp/2);
        	 
         	if (attacker.hp + heal <= attacker.maxhp) {
         		
         		 soundeffects.heal();
         	 System.out.println(attacker.pokename + " has been healed by morningsun: " + attacker.hp + "  " + " + " + heal + " =  " +  (attacker.hp + heal));
         	 attacker.hp += heal;
         	 
         	}
         	else {
         		 soundeffects.heal();
         		attacker.hp = attacker.maxhp;
            	 System.out.println(attacker.pokename + " is at max hp: " + attacker.hp  );
            	 
         		
         	} 
     
         	
         }
    	 
    	
        public static void moonlight(pokemon attacker, move attack, pokemon defender, String player) {
        	

        	double heal = (double) (attacker.maxhp/2);
       	 
        	if (attacker.hp + heal <= attacker.maxhp) {
        		 soundeffects.heal();
        	 System.out.println(attacker.pokename + " has been healed by moonlight: " + attacker.hp + "  " + " + " + heal + " =  " +  (attacker.hp + heal));
        	 attacker.hp += heal;
        	 
        	}
        	else {
        		 soundeffects.heal();
        		attacker.hp = attacker.maxhp;
           	 System.out.println(attacker.pokename + " is at max hp: " + attacker.hp  );
           
        		
        	}
    
        }
        
        
        	public static void roost(pokemon attacker, move attack, pokemon defender, String player) {
        	

        	double heal = (double) (attacker.maxhp/2);
       	 
        	if (attacker.hp + heal <= attacker.maxhp) {
        		 soundeffects.heal();
        	 System.out.println(attacker.pokename + " has been healed by roost: " + attacker.hp + "  " + " + " + heal + " =  " + (attacker.hp + heal) );
        	 System.out.println("The user has lost its flying typing");
        	 
        	 
        	 if (attacker.type1 == "flying") {
        		 
        		 attacker.roost = true;
        		 attacker.type1 = "roost";
        	 }
        	 else if (attacker.type2 == "flying") {
        		 
        		 attacker.roost = true;
        		 attacker.type2 = "roost";
        	 }
        	 attacker.hp += heal;
        	 
        	 
        	 
        	}
        	else {
        		 soundeffects.heal();
        		attacker.hp = attacker.maxhp;
           	 System.out.println(attacker.pokename + " is at max hp: " + attacker.hp  );
           	 
        	
        		
        	}
    
        }
        
        
        	 public static void synthesis(pokemon attacker, move attack, pokemon defender, String player) {

        		 double heal = (double) (attacker.maxhp/2);
            	 
             	if (attacker.hp + heal <= attacker.maxhp) {
             		 soundeffects.heal();
             	 System.out.println(attacker.pokename + " has been healed by synthesis: " + attacker.hp + "  " + " + " + heal + " =  " +  (attacker.hp + heal));
             	 attacker.hp += heal;
             	 
             	}
             	else { soundeffects.heal();
             		attacker.hp = attacker.maxhp;
                	 System.out.println(attacker.pokename + " is at max hp: " + attacker.hp  );
                	 
             		
             	}
         
             	
             }
  
        	 

        	 public static void aquaring(pokemon attacker, move attack, pokemon defender, String player) {

        		 attacker.aquaring = true;
             	
        		 System.out.println("Your " + attacker.pokename + " has created a self healing ring. ");
        		 soundeffects.heal();
             }
  
        
   
        	 
        	 // next time create set up moves.
        	 
        	 
        	 
        	 
        	 
        	 
        	 
        	 //SET UP MOVES
        	 
        	 public static void swordsdance(pokemon attacker, move attack, pokemon defender, String player) {

        		 attacker.attack *= 2;
             	soundeffects.statincrease();
        		 System.out.println("Your " + attacker.pokename + " has sharply raised its attack ");
             }

			public static void quiverdance(pokemon attacker, move attack, pokemon defender, String player) {

				attacker.spa *= 1.5;
				attacker.spdef *= 1.5;
				attacker.speed *= 1.5;
				soundeffects.statincrease();
				System.out.println("Your " + attacker.pokename + " has raised its special attack and special defense and speed, the opponent is really screwed. ");
			}
        	 
        	 public static void dragondance(pokemon attacker, move attack, pokemon defender, String player) {

        		 attacker.attack *= 1.5;
             	attacker.speed *= 1.5;
             	soundeffects.statincrease();
        		 System.out.println("Your " + attacker.pokename + " has raised its attack and speed (Rip the opponent) ");
             }

        	 public static void calmmind(pokemon attacker, move attack, pokemon defender, String player) {

        		 attacker.spa *= 1.5;
        		 attacker.spdef *= 1.5;
        		 soundeffects.statincrease();
        		 System.out.println("Your " + attacker.pokename + " has raised its special attack and special defense ");
             }
  
        	 public static void bulkup(pokemon attacker, move attack, pokemon defender, String player) {

        		 attacker.attack *= 1.5;
        		 attacker.def *= 1.5;
        		 soundeffects.statincrease();
        		 System.out.println("Your " + attacker.pokename + " has raised its attack and defense ");
             }
        	 
        	 public static void nastyplot(pokemon attacker, move attack, pokemon defender, String player) {

        		 attacker.spa *= 2;
        		 soundeffects.statincrease();
        		 System.out.println("Your " + attacker.pokename + " has sharply raised its special attack ");
             }
        	 
        	 public static void tailglow(pokemon attacker, move attack, pokemon defender, String player) {

        		 attacker.spa *= 2;
        		 soundeffects.statincrease();
        		 System.out.println("Your " + attacker.pokename + " has sharply raised its special attack ");
             }
        	 
        	 public static void workup(pokemon attacker, move attack, pokemon defender, String player) {

        		 attacker.spa *= 1.5;
             	attacker.attack *=1.5;
             	soundeffects.statincrease();
        		 System.out.println("Your " + attacker.pokename + " has raised its attack and special attack ");
             }
        	 
        	 
        	 public static void honeclaws(pokemon attacker, move attack, pokemon defender, String player) {
             	attacker.attack *=1.5;
             	
             	attacker.move1.accuracy *= 1.5;
             	attacker.move2.accuracy *= 1.5;
             	attacker.move3.accuracy *= 1.5;
             	attacker.move4.accuracy *= 1.5;
             	soundeffects.statincrease();
        		 System.out.println("Your " + attacker.pokename + " has raised its attack and accuracy");
             }
        	 
        	 public static void focusenergy(pokemon attacker, move attack, pokemon defender, String player) {

        		attacker.move1.critrate *= 2;
              	attacker.move2.critrate *= 2;
              	attacker.move3.critrate *= 2;
              	attacker.move4.critrate *= 2;
              	soundeffects.statincrease();
        		 System.out.println("Your " + attacker.pokename + " has raised its crit rate ");
             }
        	 
        	 
        	 
        	 
        	 
        	 
        	 
        	 
        	 
        	 // STATUS MOVES
        	 
        	 
        	 
        	 public static void thunderwave(pokemon attacker, move attack, pokemon defender, String player) {

        		 
        			
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	
        	    	
        	    	if(defender.ability.equals("magicbounce")) {
        	    		
        	    		
        	    		System.out.println("YOU got uno reversed. Magic bounce bounced it back!!!!!!!");
        	    		soundeffects.paralyze();
        	    		
        	    		
        	    		
        	    		
               		 if(attacker.status.equals(" No status conditions"))   {
               			 
                     		
                     		
                     			attacker.status = "Paralyzed";
                     			attacker.speed *= 0.5;
                     			
                     		 System.out.println("The opposing " + defender.pokename + " has paralyzed the your " + attacker.pokename + " . " + attacker.pokename + "'s speed fell. ");
                     		 
                     		soundeffects.paralyze();
                     		soundeffects.drop();
                     		return;
               		 }
               		 else {
               			 
               			 System.out.println(" Your pokemon is saved because your pokemon already has a status condition");
               			 return;
               		 }
               		 
               		 
               		 
               		 
        	    	}
        	    	
        	    	
        	    	
        	    	
        	    	
        		 if(defender.status.equals(" No status conditions"))   {
        			 
              		int hit = rand.nextInt(10);
              		
              		if(hit == 1) {
              			
              			System.out.println("Thunderwave missed!! ");
              			return;
              		}
              		else {
              		
              			defender.status = "Paralyzed";
              			defender.speed *= 0.5;
              			soundeffects.paralyze();
              			soundeffects.drop();
              		 System.out.println("Your " + attacker.pokename + " has paralyzed the opponent's " + defender.pokename + " with "  + attack.movename + " . " + defender.pokename + "'s speed fell. ");
              		 
              		 
              		}
        		 }
        		 else {
        			 
        			 System.out.println("The opponent's pokemon already has a status condition");
        			 return;
        		 }
        		 
 
              }
         	 
        	 
        	 public static void willowisp(pokemon attacker, move attack, pokemon defender, String player) {
        			
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	
        	    	if(defender.ability.equals("magicbounce")) {
        	    		
        	    		
        	    		System.out.println("YOU got uno reversed. Magic bounce bounced it back!!!!!!!");
        	    		
        	    		
        	    		 if( (attacker.status.equals(" No status conditions")) && !(attacker.type1.equals("fire")) && !(attacker.type2.equals("fire")) ) {
                	
                       		
                       			attacker.status = "Burned";
                       			soundeffects.burned();
                       			if(attacker.move1.attacktype.equals("ph")) {
                       				attacker.move1.power *= 0.5;
                       			}
                       			if(attacker.move2.attacktype.equals("ph")) {
                       				attacker.move2.power *= 0.5;
                       			}
                       			if(attacker.move3.attacktype.equals("ph")) {
                       				attacker.move3.power *= 0.5;
                       			}
                       			if(attacker.move4.attacktype.equals("ph")) {
                       				attacker.move4.power *= 0.5;
                       			}
                       		 System.out.println("The opposing " + defender.pokename + " has burned the your " + attacker.pokename + " . " + attacker.pokename + "'s physical attacks power has been cut in half. ");
                       		 
                       		 return;
                       		
                            }
                     		 else {
                     			 
                     			 System.out.println("Your pokemon already has a status condition or you are fire type. ");
                     			 return;
                     		 }
        	    	
               		 
               		 
        	    	}
	    	
	    	
	    	
	    	
        		 if( (defender.status.equals(" No status conditions")) && !(defender.type1.equals("fire")) && !(defender.type2.equals("fire")) ) {
        			 int hit = rand.nextInt(10);
               		
               		if(hit == 1) {
               			
               			System.out.println("Willowisp missed!! ");
               			return;
               		}
               		else {
               		
               			defender.status = "Burned";
               			soundeffects.burned();
               			if(defender.move1.attacktype.equals("ph")) {
               				defender.move1.power *= 0.5;
               			}
               			if(defender.move2.attacktype.equals("ph")) {
               				defender.move2.power *= 0.5;
               			}
               			if(defender.move3.attacktype.equals("ph")) {
               				defender.move3.power *= 0.5;
               			}
               			if(defender.move4.attacktype.equals("ph")) {
               				defender.move4.power *= 0.5;
               			}
               		 System.out.println("Your " + attacker.pokename + " has burned the opponent's " + defender.pokename + " with " + attack.movename + " . " + defender.pokename + "'s physical attacks power has been cut in half. ");
               		 
               		 
               		}
                    }
             		 else {
             			 
             			 System.out.println("The opponent's pokemon already has a status condition or the opponent is fire type. ");
             			 return;
             		 }
          		
              }
         	 
        	 
        	 public static void confuseray(pokemon attacker, move attack, pokemon defender, String player) {
        			
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return; // misses if the opponent is in the air
        	    	}
        		
        	    	
        	    	
        	    	
        	    	if(defender.ability.equals("magicbounce")) {
        	    		
        	    		
        	    		System.out.println("YOU got uno reversed. Magic bounce bounced it back!!!!!!!");
        	    		attacker.confused = true;
        	    		System.out.println("Your pokemon is now confused!!!!");
        	    	   return;
        	    	}
	    	
	    	
        	    	defender.confused = true;
        		
         		
              }
         	 
         	 
        	 public static void yawn(pokemon attacker, move attack, pokemon defender, String player) {
        			
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	
        	    	if(defender.ability.equals("magicbounce")) {
        	    		
        	    		System.out.println("You got uno reversed");
               		 if( (attacker.status.equals(" No status conditions")) ) {
               			 
               		 
                		attacker.drowsy = true;
                		System.out.println("Your pokemon is drowsy....");
                		return;
               		 }
               		 else {
               			 
               			 System.out.println("Your pokemon already has a status condition");
               			 return;
               		 }
        	    		
        	    	}
        	    	
        	    	
        		 if( (defender.status.equals(" No status conditions")) ) {
        			 
        		 
         		defender.drowsy = true;
         		System.out.println("The opponent's pokemon is drowsy....");
         		
        		 }
        		 else {
        			 
        			 System.out.println("The opponent already has a status condition");
        			 
        		 }
              }
        	 
        	 public static void toxic(pokemon attacker, move attack, pokemon defender, String player) {

        			
        	    	
        	    	if( (defender.bounce == true) ) { // Checks if the opponent is in the air....
        	    		
        	    		if( !((attacker.type1.equals("poison")) || attacker.type2.equals("poison")) ) {
        	    			
        	    			System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
            	    		return; // misses if the opponent is in the air
        	    		}
        	    		else {
            	    		System.out.println(" THE OPPOSING POKEMON THOUGHT THAT IT COULD ESCAPE BY BOUNCING!!!!!!!!!!!!!!!! \n IT GOT SNIPED IN MID-AIR!!!");
            	    	// pioson types can't miss toxic

        	    		}
        	    		
        	    	}
        	    	
        		
        	
        	    	if(defender.ability.equals("magicbounce")) {
        	    		
        	    		
        	    		System.out.println("You got uno reversed due to magic bounce!!!");
        	    		 
           			 if( (attacker.status.equals(" No status conditions")) && !(attacker.type1.equals("steel")) && !(attacker.type2.equals("steel")) && !(attacker.type1.equals("poison")) && !(attacker.type2.equals("poison")) ) {
           				attacker.status = "Toxic";
           				soundeffects.poisoned();
           	         		System.out.println("Your pokemon is badly poisoned.");
           	         		return;
           	        		 }
           	        		 else {
           	        			 
           	        			 System.out.println("The opponent's pokemon already has a status condition or is poison or is steel type");
           	        			 return;
           	        		 }
        	    		
        	    	}
        	    	
        	    	
        		 int hit = rand.nextInt(10);
        		 System.out.println(hit);
        		 if (  ( (hit == 0) || (hit == 1) ) ) {
        			 
        			 if ( ((attacker.type1.equals("poison")) || attacker.type2.equals("poison")) ) {
        				 
        				 if( (defender.status.equals(" No status conditions")) && !(defender.type1.equals("steel")) && !(defender.type2.equals("steel"))&& !(defender.type1.equals("poison")) && !(defender.type2.equals("poison")) ) {
        		         		defender.status = "Toxic";
        		         		soundeffects.poisoned();
        		         		System.out.println("The opposing pokemon is badly poisoned.");
        		         }
        		        else {
        		        			 
        		        			 System.out.println("TOXIC FAILED:   The opponent's pokemon already has a status condition or is poison or is steel type");
        		        			 return;
        		           }
        				 
        				 
        			 }
        			 else {
        				 
        				 System.out.println("Toxic missed!!");
        				 return;
        			 }
        			 
        			return; 
        		 }
        		 else {
        			 
        			 if( (defender.status.equals(" No status conditions")) && !(defender.type1.equals("steel")) && !(defender.type2.equals("steel")) && !(defender.type1.equals("poison")) && !(defender.type2.equals("poison")) ) {
        	         		defender.status = "Toxic";
        	         		soundeffects.poisoned();
        	         		System.out.println("The opposing pokemon is badly poisoned.");
        	        		 }
        	        		 else {
        	        			 
        	        			 System.out.println("The opponent's pokemon already has a status condition or is poison or is steel type");
        	        			 return;
        	        		 }
        			 
        			 
        			 
        		  }
        		 
        		
        		 
        		 
        		
              }
         	 
        	 
        	 // code other tyes of moves
        	 
        	 // start with hidden power so that I have a template for the rest of the moves
        	 
        	 
        	 
        	 
        	 
        	 // 
        	    
        	    // Attempting to code hidden power a move of many types
        	    
        	 
        	 
        	 /*
        	  * 
        	  * HIDDENPOWER
        	  *  
        	  */
        	 
        	 
        	    public static double hiddenpower(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	        soundeffects.noo(); 
        	        
        	    	System.out.println("Your damage roll is " + roll); soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.spa/ (double) defender.spdef)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)
        	    	
        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
        	    	//STEEL TYPE HIDDENPOWER
        	    	
        	    	
        	    	if(attack.movetype.equals("steel")) {
        		
        	        if(   (defender.type1.equals("fire")) || (defender.type1.equals("water")) || (defender.type1.equals("steel")) || (defender.type1.equals("electric")) ) {
        	    		
        	    		damage *= 0.5;  //Steel is resisted by these types
        	    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");soundeffects.resist(); 
        	    		
        	    	}
        	    	

        	        if(   (defender.type2.equals("fire")) || (defender.type2.equals("water")) || (defender.type2.equals("steel")) || (defender.type2.equals("electric")) ) {
        	    		
        	    		damage *= 0.5;  //Steel is resisted by these types
        	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
        	    		
        	    	}
        	        
        	        
        	        if(   (defender.type1.equals("rock")) || (defender.type1.equals("ice")) || (defender.type1.equals("fairy"))  ) {
        	    		
        	    		damage *= 2;  //Steel is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(   (defender.type2.equals("rock")) || (defender.type2.equals("ice")) || (defender.type2.equals("fairy")) ) {
        	    		
        	    		damage *= 2;  //Steel is super effective agaisnt these types
        	    		System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	        
        	        
        	        	if(defender.ability.equals("solidrock")){
        	        	 
        	        	damage = damage * 0.6;
        	        	 System.out.println("Solid rock reduced the damage of the attack");
        	        	 
        	        	 }
        	        	 
        	        
        	        } // BUG TYPE HIDDENPOWER
        	    	else if(attack.movetype.equals("bug")) {
                		
            	        if( (defender.type1.equals("fairy")) ||  (defender.type1.equals("poison")) || (defender.type1.equals("fighting")) || (defender.type1.equals("fire")) || (defender.type1.equals("flying")) || (defender.type1.equals("steel")) || (defender.type1.equals("rock")) ) {
            	    		
            	    		damage *= 0.5;  //bug is resisted by these types
            	    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");soundeffects.resist(); 
            	    		
            	    	}
            	    	

            	        if(  (defender.type2.equals("fairy")) ||  (defender.type2.equals("poison")) || (defender.type2.equals("fighting")) || (defender.type2.equals("fire")) || (defender.type2.equals("flying")) || (defender.type2.equals("steel")) || (defender.type2.equals("rock")) ) {
            	    		
            	    		damage *= 0.5;  //bug is resisted by these types
            	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
            	    		
            	    	}
            	        
            	        
            	        
            	        if(   (defender.type1.equals("grass")) || (defender.type1.equals("psychic"))  || (defender.type1.equals("dark")) ) {
            	    		
            	    		damage *= 2;  //bug is super effective against these types
            	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
            	    		
            	    	}
            	    	

            	        if(   (defender.type2.equals("grass")) || (defender.type2.equals("psychic")) || (defender.type2.equals("dark"))) {
            	    		
            	    		damage *= 2;  //bug is super effective agaisnt these types
            	    		System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting
            	    		
            	    	}
            	        
            	        
            	        
            	   } //NORMAL TYPE HIDDENPOWER
        	    	else if(attack.movetype.equals("normal")) {
                		
            	        if(   (defender.type1.equals("steel")) || (defender.type1.equals("rock")) ) {
            	    		
            	    		damage *= 0.5;  //normal is resisted by these types
            	    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");soundeffects.resist(); 
            	    		
            	    	}
            	    	

            	        if(  (defender.type2.equals("steel")) || (defender.type2.equals("rock")) ) {
            	    		
            	    		damage *= 0.5;  //normal is resisted by these types
            	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
            	    		
            	    	}
            	        
            	        
            	        if(defender.type1.equals("ghost") || defender.type2.equals("ghost")) {
            	        	
            	        	damage *= 0;
            	        	System.out.println("\n GHOST POKEMON ARE IMMUNE TO NORMAL TYPE ATTACKS \n");
            	        	
            	        } 
            	        
            	   } //FIRE TYPE HIDDENPOWER
        	    	else if(attack.movetype.equals("fire")) {
                		
            	        if( (defender.type1.equals("fire")) ||  (defender.type1.equals("water")) || (defender.type1.equals("rock")) || (defender.type1.equals("dragon")) ) {
            	    		
            	    		damage *= 0.5;  //fire is resisted by these types
            	    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");soundeffects.resist(); 
            	    		
            	    	}
            	    	

            	        if( (defender.type2.equals("fire")) || (defender.type2.equals("water")) || (defender.type2.equals("rock")) || (defender.type2.equals("dragon")) ) {
            	    		
            	    		damage *= 0.5;  //fire is resisted by these types
            	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
            	    		
            	    	}
            	        
            	        
            	        
            	        if(   (defender.type1.equals("grass")) || (defender.type1.equals("ice")) || (defender.type1.equals("bug"))  || (defender.type1.equals("steel")) ) {
            	    		
            	    		damage *= 2;  //fire is super effective against these types
            	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
            	    		
            	    	}
            	    	

            	        if(   (defender.type2.equals("grass")) || (defender.type2.equals("ice")) || (defender.type2.equals("steel")) || (defender.type2.equals("bug"))) {
            	    		
            	    		damage *= 2;  //fire is super effective agaisnt these types
            	    		System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting
            	    		
            	    	}
            	        
            	        
            	        
            	   }//WATER TYPE HIDDENPOWER
        	    	else if(attack.movetype.equals("water")) {
                		
            	        if(  (defender.type1.equals("water")) || (defender.type1.equals("grass")) || (defender.type1.equals("dragon")) ) {
            	    		
            	    		damage *= 0.5;  //water is resisted by these types
            	    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");soundeffects.resist(); 
            	    		
            	    	}
            	    	

            	        if(  (defender.type2.equals("water")) || (defender.type2.equals("grass")) || (defender.type2.equals("dragon")) ) {
            	    		
            	    		damage *= 0.5;  //water is resisted by these types
            	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
            	    		
            	    	}
            	        
            	        
            	        
            	        if(   (defender.type1.equals("fire")) || (defender.type1.equals("rock"))  || (defender.type1.equals("ground")) ) {
            	    		
            	    		damage *= 2;  //water is super effective against these types
            	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
            	    		
            	    	}
            	    	

            	        if(   (defender.type2.equals("fire")) || (defender.type2.equals("rock")) || (defender.type2.equals("ground"))) {
            	    		
            	    		damage *= 2;  //water is super effective agaisnt these types
            	    		System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting
            	    		
            	    	}
            	        
            	        if(defender.ability.equals("waterabsorb")) {
            	        	
            	        	health += damage;
            	        	System.out.println("The opposing pokemon was healed by water absorb");
            	        	return Math.round(health);
            	        	
            	        	
            	        }
            	        

        	        	if(defender.ability.equals("solidrock")){
        	        	 
        	        	damage = damage * 0.6;
        	        	 System.out.println("Solid rock reduced the damage of the attack");
        	        	 
        	        	 }
        	        	 
            	        
            	   } //ELECTRIC TYPE HIDDENPOWER
        	    	else if(attack.movetype.equals("electric")) {
                		
            	        if(  (defender.type1.equals("electric")) || (defender.type1.equals("grass")) || (defender.type1.equals("dragon")) ) {
            	    		
            	    		damage *= 0.5;  //electric is resisted by these types
            	    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");soundeffects.resist(); 
            	    		
            	    	}
            	    	

            	        if(  (defender.type2.equals("electric")) || (defender.type2.equals("grass")) || (defender.type2.equals("dragon")) ) {
            	    		
            	    		damage *= 0.5;  //electric is resisted by these types
            	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
            	    		
            	    	}
    
            	        if(   (defender.type1.equals("water")) || (defender.type1.equals("flying")) ) {
            	    		
            	    		damage *= 2;  //electric is super effective against these types
            	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
            	    		
            	    	}
            	    	

            	        if(   (defender.type2.equals("water")) || (defender.type2.equals("flying")) ) {
            	    		
            	    		damage *= 2;  //electric is super effective agaisnt these types
            	    		System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting
            	    		
            	    	}
            	        
            	        if(defender.type1.equals("ground") || defender.type2.equals("ground")) {
            	        	
            	        	damage *= 0;
            	        	System.out.println("\n GROUND POKEMON ARE IMMUNE TO ELECTRIC TYPE ATTACKS \n");
            	        	
            	        } 

        	        	if(defender.ability.equals("solidrock")){
        	        	 
        	        	damage = damage * 0.6;
        	        	 System.out.println("Solid rock reduced the damage of the attack");
        	        	 
        	        	 }
        	        	 
            	   } //GRASS TYPE HIDDENPOWER
        	    	else if(attack.movetype.equals("grass")) {
                		
            	        if(  (defender.type1.equals("poison")) ||  (defender.type1.equals("steel")) ||  (defender.type1.equals("flying")) ||  (defender.type1.equals("fire")) ||  (defender.type1.equals("bug")) || (defender.type1.equals("grass")) || (defender.type1.equals("dragon")) ) {
            	    		
            	    		damage *= 0.5;  //grass is resisted by these types
            	    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");soundeffects.resist(); 
            	    		
            	    	}
            	    	

            	        if(  (defender.type2.equals("fire")) || (defender.type2.equals("poison")) ||  (defender.type2.equals("steel")) ||  (defender.type2.equals("flying")) || (defender.type2.equals("bug")) || (defender.type2.equals("grass")) || (defender.type2.equals("dragon")) ) {
            	    		
            	    		damage *= 0.5;  //grass is resisted by these types
            	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
            	    		
            	    	}
            	        
            	        
            	        
            	        if(   (defender.type1.equals("water")) || (defender.type1.equals("rock"))  || (defender.type1.equals("ground")) ) {
            	    		
            	    		damage *= 2;  //grass is super effective against these types
            	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
            	    		
            	    	}
            	    	

            	        if(   (defender.type2.equals("water")) || (defender.type2.equals("rock")) || (defender.type2.equals("ground"))) {
            	    		
            	    		damage *= 2;  //grass is super effective agaisnt these types
            	    		System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting
            	    		
            	    	}
            	        
            	        
            	        
            	   } //ICE TYPE HIDDENPOWER
        	    	else if(attack.movetype.equals("ice")) {
                		
        	    		
        	    		if(   (defender.type1.equals("steel")) ||  (defender.type1.equals("ice")) ||  (defender.type1.equals("water")) || (defender.type1.equals("fire")) ) {
               	    		
               	        	damage *= 0.5;  //ice is resisted by these types
               	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
               	    		
               	    	}
               	    	

               	        if(   (defender.type2.equals("steel")) || (defender.type2.equals("ice")) || (defender.type2.equals("water")) || (defender.type2.equals("fire")) ) {
               	    		
               	        	damage *= 0.5;  //ice is resisted by these types
               	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
               	    		
               	    	}
               	        
               	        
            	        if(  (defender.type1.equals("ground")) ||(defender.type1.equals("flying")) || (defender.type1.equals("grass")) || (defender.type1.equals("dragon")) ) {
            	    		
            	        	damage *= 2;  //ice is super effective against these types
            	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
            	    		
            	    	}
            	    	

            	        
            	        if(  (defender.type2.equals("ground")) ||(defender.type2.equals("flying")) || (defender.type2.equals("grass")) || (defender.type2.equals("dragon")) ) {
            	    		
            	        	damage *= 2;  //ice is super effective against these types
            	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
            	    		
            	    	}
            	        

        	        	if(defender.ability.equals("solidrock")){
        	        	 
        	        	damage = damage * 0.6;
        	        	 System.out.println("Solid rock reduced the damage of the attack");
        	        	 
        	        	 }
        	        	 
            	     
            	        //
            	      
    
            	   }// //FIGHTING TYPE HIDDENPOWER
        	    	else if(attack.movetype.equals("fighting")) {
                		
        	    	  	  
               	        
            	    	
        	    		if(   (defender.type1.equals("fairy")) ||(defender.type1.equals("bug")) ||(defender.type1.equals("psychic")) ||  (defender.type1.equals("flying")) ||  (defender.type1.equals("poison")) ) {
               	    		
               	        	damage *= 0.5;  //fighting is resisted by these types
               	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
               	    		
               	    	}
               	    	

               	        if(   (defender.type2.equals("fairy")) ||(defender.type2.equals("bug")) || (defender.type2.equals("psychic")) || (defender.type2.equals("flying")) || (defender.type2.equals("poison")) ) {
               	    		
               	        	damage *= 0.5;  //fighting is resisted by these types
               	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
               	    		
               	    	}
               	        
               	        
            	        if(  (defender.type1.equals("steel")) ||(defender.type1.equals("dark")) || (defender.type1.equals("rock")) ||(defender.type1.equals("ice")) || (defender.type1.equals("normal")) ) {
            	    		
            	        	damage *= 2;  //fighting is super effective against these types
            	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
            	    		
            	    	}
            	    	

            	        if(  (defender.type2.equals("steel")) ||(defender.type2.equals("dark")) || (defender.type2.equals("rock")) ||(defender.type2.equals("ice")) || (defender.type2.equals("normal")) ) {
            	    		
            	        	damage *= 2;  //fighting is super effective against these types
            	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
            	    		
            	    	}

            	     
            	        
            	        if(defender.type1.equals("ghost") || defender.type2.equals("ghost")) {
            	        	
            	        	damage *= 0;
            	        	System.out.println("\n GHOST POKEMON ARE IMMUNE TO FIGHTING TYPE ATTACKS \n");
            	        	
            	        } 
            	      

            	      
    
            	   } //POISON TYPE HIDDENPOWER
        	    	else if(attack.movetype.equals("poison")) {
                		
        	    		
        	    		if(   (defender.type1.equals("poison")) ||  (defender.type1.equals("ground")) ||  (defender.type1.equals("ghost")) || (defender.type1.equals("rock")) ) {
               	    		
               	        	damage *= 0.5;  //poison is resisted by these types
               	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
               	    		
               	    	}
               	    	

               	        if(   (defender.type2.equals("poison")) || (defender.type2.equals("ground")) || (defender.type2.equals("ghost")) || (defender.type2.equals("rock")) ) {
               	    		
               	        	damage *= 0.5;  //poison is resisted by these types
               	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
               	    		
               	    	}
               	        
               	        
            	        if(   (defender.type1.equals("grass")) || (defender.type1.equals("fairy")) ) {
            	    		
            	        	damage *= 2;  //poison is super effective against these types
            	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
            	    		
            	    	}
            	    	

            	        if(  (defender.type2.equals("grass")) || (defender.type2.equals("fairy")) ) {
            	    		
            	        	damage *= 2;  //poison is super effective against these types
            	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
            	    		
            	    	}
    
            	        if(defender.type1.equals("steel") || defender.type2.equals("steel")) {
            	        	
            	        	damage *= 0;
            	        	System.out.println("\n STEEL POKEMON ARE IMMUNE TO POISON TYPE ATTACKS \n");
            	        	
            	        } 
            	        //
            	      
    
            	   }
        	    	//GROUND TYPE HIDDENPOWER
        	    	else if(attack.movetype.equals("ground")) {
                		
        	    		
        	    		if(   (defender.type1.equals("grass")) || (defender.type1.equals("bug")) ) {
               	    		
               	        	damage *= 0.5;  //ground is resisted by these types
               	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
               	    		
               	    	}
               	    	

               	        if(   (defender.type2.equals("grass")) || (defender.type2.equals("bug")) ) {
               	    		
               	        	damage *= 0.5;  //ground is resisted by these types
               	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
               	    		
               	    	}
               	        
               	        
            	        if(    (defender.type1.equals("steel")) ||(defender.type1.equals("rock")) || (defender.type1.equals("poison")) || (defender.type1.equals("electric")) || (defender.type1.equals("fire")) ) {
            	    		
            	        	damage *= 2;  //ground is super effective against these types
            	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
            	    		
            	    	}
            	    	

            	        if( (defender.type2.equals("steel")) ||(defender.type2.equals("poison")) || (defender.type2.equals("rock")) || (defender.type2.equals("electric")) || (defender.type2.equals("fire")) ) {
            	    		
            	        	damage *= 2;  //ground is super effective against these types
            	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
            	    		
            	    	}
    
            	        
            	        if(  (defender.type1.equals("flying")) ||  (defender.type2.equals("flying"))   ) {
            	        	
            	        	
            	        	damage *= 0;
            	        	System.out.println("\n Flying pokemon are immune to ground moves!!!!");
            	        }
            	        if(  (defender.ability.equals("levitate")) &&  !(attacker.ability.equals("moldbreaker"))   ) {
            	        	
            	        	damage *= 0;
            	        	System.out.println(" The opposing pokemon's levitate makes it immune to ground moves ");
            	        }
            	     
            	        //
            	      
    
            	   } //FLYING TYPE HIDDENPOWER
        	    	else if(attack.movetype.equals("flying")) {
                		
        	    		
        	    		if(   (defender.type1.equals("steel")) || (defender.type1.equals("rock")) || (defender.type1.equals("electric")) ) {
               	    		
               	        	damage *= 0.5;  //flying is resisted by these types
               	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
               	    		
               	    	}
               	    	

               	        if(   (defender.type2.equals("steel")) || (defender.type2.equals("rock")) || (defender.type2.equals("electric")) ) {
               	    		
               	        	damage *= 0.5;  //flying is resisted by these types
               	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
               	    		
               	    	}
               	        
               	        
            	        if(     (defender.type1.equals("grass")) || (defender.type1.equals("fighting")) || (defender.type1.equals("bug")) ) {
            	    		
            	        	damage *= 2;  //flying is super effective against these types
            	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
            	    		
            	    	}
            	    	

            	        if(  (defender.type2.equals("grass")) || (defender.type2.equals("fighting")) || (defender.type2.equals("bug")) ) {
            	    		
            	        	damage *= 2;  //flying is super effective against these types
            	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
            	    		
            	    	}
    
            	     
            	        //
            	      
    
            	   } //PSYCHIC TYPE HIDDENPOWER
        	    	else if(attack.movetype.equals("psychic")) {
                		
        	    		
        	    		if(   (defender.type1.equals("steel")) || (defender.type1.equals("psychic"))  ) {
               	    		
               	        	damage *= 0.5;  //psychic is resisted by these types
               	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
               	    		
               	    	}
               	    	

               	        if(   (defender.type2.equals("steel")) || (defender.type2.equals("psychic")) ) {
               	    		
               	        	damage *= 0.5;  //psychic is resisted by these types
               	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
               	    		
               	    	}
               	        
               	        
            	        if( (defender.type1.equals("fighting")) || (defender.type1.equals("poison")) ) {
            	    		
            	        	damage *= 2;  //psychic is super effective against these types
            	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
            	    		
            	    	}
            	    	

            	        if(  (defender.type2.equals("fighting")) || (defender.type2.equals("poison")) ) {
            	    		
            	        	damage *= 2;  //psychic is super effective against these types
            	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
            	    		
            	    	}
    
            	        if(defender.type1.equals("dark") || defender.type2.equals("dark")) {
            	        	
            	        	damage *= 0;
            	        	System.out.println("\n DARK POKEMON ARE IMMUNE TO PSYCHIC TYPE ATTACKS \n");
            	        	
            	        } 
            	        //
            	      
    
            	   }//ROCK TYPE HIDDENPOWER
        	    	else if(attack.movetype.equals("rock")) {
                		
        	    		
        	    		if(   (defender.type1.equals("ground")) ||(defender.type1.equals("steel")) || (defender.type1.equals("fighting"))  ) {
               	    		
               	        	damage *= 0.5;  //rock is resisted by these types
               	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
               	    		
               	    	}
               	    	

               	        if(   (defender.type2.equals("ground")) ||  (defender.type2.equals("steel")) || (defender.type2.equals("fighting")) ) {
               	    		
               	        	damage *= 0.5;  //rock is resisted by these types
               	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
               	    		
               	    	}
               	        
               	        
            	        if( (defender.type1.equals("fire")) || (defender.type1.equals("ice")) || (defender.type1.equals("flying")) || (defender.type1.equals("bug")) ) {
            	    		
            	        	damage *= 2;  //rock is super effective against these types
            	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
            	    		
            	    	}
            	    	

            	        if(  (defender.type2.equals("fire")) || (defender.type2.equals("ice")) || (defender.type2.equals("flying")) || (defender.type2.equals("bug")) ) {
            	    		
            	        	damage *= 2;  //rock is super effective against these types
            	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
            	    		
            	    	}
    
            	     

        	        	if(defender.ability.equals("solidrock")){
        	        	 
        	        	damage = damage * 0.6;
        	        	 System.out.println("Solid rock reduced the damage of the attack");
        	        	 
        	        	 }
        	        	 
            	        //
            	      
    
            	   }//GHOST TYPE HIDDENPOWER
        	    	else if(attack.movetype.equals("ghost")) {
                		
        	    		
        	    		if(   (defender.type1.equals("dark"))   ) {
               	    		
               	        	damage *= 0.5;  //ghost is resisted by these types
               	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
               	    		
               	    	}
               	    	

               	        if(   (defender.type2.equals("dark"))  ) {
               	    		
               	        	damage *= 0.5;  //ghost is resisted by these types
               	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
               	    		
               	    	}
               	        
               	        
            	        if( (defender.type1.equals("ghost")) || (defender.type1.equals("psychic")) ) {
            	    		
            	        	damage *= 2;  //ghost is super effective against these types
            	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
            	    		
            	    	}
            	    	

            	        if(  (defender.type2.equals("ghost")) || (defender.type2.equals("psychic")) ) {
            	    		
            	        	damage *= 2;  //ghost is super effective against these types
            	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
            	    		
            	    	}
    
            	        if(defender.type1.equals("normal") || defender.type2.equals("normal")) {
            	        	
            	        	damage *= 0;
            	        	System.out.println("\n NORMAL POKEMON ARE IMMUNE TO GHOST TYPE ATTACKS \n");
            	        	
            	        } 
            	        //
            	      
    
            	   } //DRAGON TYPE HIDDENPOWER
        	    	else if(attack.movetype.equals("dragon")) {
                		
        	    		
        	    		if(   (defender.type1.equals("steel"))   ) {
               	    		
               	        	damage *= 0.5;  //dragon is resisted by these types
               	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
               	    		
               	    	}
               	    	

               	        if(   (defender.type2.equals("steel"))  ) {
               	    		
               	        	damage *= 0.5;  //dragon is resisted by these types
               	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
               	    		
               	    	}
               	        
               	        
            	        if( (defender.type1.equals("dragon"))  ) {
            	    		
            	        	damage *= 2;  //dragon is super effective against these types
            	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
            	    		
            	    	}
            	    	

            	        if(  (defender.type2.equals("dragon"))  ) {
            	    		
            	        	damage *= 2;  //dragon is super effective against these types
            	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
            	    		
            	    	}
    
            	        if(defender.type1.equals("fairy") || defender.type2.equals("fairy")) {
            	        	
            	        	damage *= 0;
            	        	System.out.println("\n FAIRY POKEMON ARE IMMUNE TO DRAGON TYPE ATTACKS \n");
            	        	
            	        } 
            	        //
            	      
    
            	   }//DARK TYPE HIDDENPOWER
        	    	else if(attack.movetype.equals("dark")) {
                		
        	    		
        	    		if(   (defender.type1.equals("fighting")) || (defender.type1.equals("fairy")) ||  (defender.type1.equals("dark"))   ) {
               	    		
               	        	damage *= 0.5;  //dark is resisted by these types
               	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
               	    		
               	    	}
               	    	

               	        if(   (defender.type2.equals("fighting")) || (defender.type2.equals("fairy")) ||  (defender.type2.equals("dark"))  ) {
               	    		
               	        	damage *= 0.5;  //dark is resisted by these types
               	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
               	    		
               	    	}
               	        
               	        
            	        if( (defender.type1.equals("ghost")) || (defender.type1.equals("psychic")) ) {
            	    		
            	        	damage *= 2;  //dark is super effective against these types
            	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
            	    		
            	    	}
            	    	

            	        if(  (defender.type2.equals("ghost")) || (defender.type2.equals("psychic")) ) {
            	    		
            	        	damage *= 2;  //dark is super effective against these types
            	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
            	    		
            	    	}
    
            	     
            	      
    
            	   }//FAIRY TYPE HIDDENPOWER
        	    	else if(attack.movetype.equals("fairy")) {
                		
        	    		
        	    		if(   (defender.type1.equals("steel")) || (defender.type1.equals("poison")) ||  (defender.type1.equals("fire"))   ) {
               	    		
               	        	damage *= 0.5;  //fairy is resisted by these types
               	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
               	    		
               	    	}
               	    	

               	        if(   (defender.type2.equals("steel")) || (defender.type2.equals("poison")) ||  (defender.type2.equals("fire"))  ) {
               	    		
               	        	damage *= 0.5;  //fairy is resisted by these types
               	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
               	    		
               	    	}
               	        
               	        
            	        if( (defender.type1.equals("dark")) || (defender.type1.equals("dragon"))|| (defender.type1.equals("fighting")) ) {
            	    		
            	        	damage *= 2;  //fairy is super effective against these types
            	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
            	    		
            	    	}
            	    	

            	        if(  (defender.type2.equals("dark")) || (defender.type2.equals("dragon"))|| (defender.type2.equals("fighting")) ) {
            	    		
            	        	damage *= 2;  //fairy is super effective against these types
            	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
            	    		
            	    	}
    
            	     
            	      
    
            	   }

        	    	
        	    	 
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        	        
        	        
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	 
        	    }
        	    
        	    
        	    
        	    
        	    
        	    
        	 // code normal moves 
        	    
        	    /*
        	     * 
        	     * NORMAL TYPE ATTACKS
        	     * 
        	     */
        	    
        	    // quickattack, slash, return, gigaimpact, superfang, horndrill, extremespeed, 
        	    
        	    //gigaimpact
        	 
        	    
        	    
        	    
        	    
        	    
        	    
        	    
        	    
        	    public static double gigaimpact(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	        soundeffects.noo(); 
        	        
        	    	System.out.println("Your damage roll is " + roll);soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
        	    	
        	    	
        	       if(   (defender.type1.equals("steel")) || (defender.type1.equals("rock")) ) {
           	    		
           	    		damage *= 0.5;  //normal is resisted by these types
           	    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");soundeffects.resist(); 
           	    		
           	    	}
           	    	

           	        if(  (defender.type2.equals("steel")) || (defender.type2.equals("rock")) ) {
           	    		
           	    		damage *= 0.5;  //normal is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
           	        if(defender.type1.equals("ghost") || defender.type2.equals("ghost")) {
           	        	
           	        	damage *= 0;
           	        	System.out.println("\n GHOST POKEMON ARE IMMUNE TO NORMAL TYPE ATTACKS \n");
           	        	
           	        } 
           	        
           	        
           	        
           	     
           	        if( (defender.ability.equals("multiscale") ) ){
           	          	 
           	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
           	      	     
           	      	     damage = damage/2;
           	      	     
           	      	     }
           	      	 }
           	        
        		
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	        attacker.charging = true;
        	        
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;
        				soundeffects.statincrease();
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    //boomburst




						public static double boomburst(pokemon attacker, move attack, pokemon defender, String player) {


							if(defender.bounce == true) { // Checks if the opponent is in the air....

								System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
								return defender.hp; // misses if the opponent is in the air
							}


							double health = defender.hp; // health value of the pokemon being attacked


							double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi

							soundeffects.noo();

							System.out.println("Your damage roll is " + roll);

							double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.spa/ (double) defender.spdef)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)

							// make sure to code for crits

							int crit = rand.nextInt(400);



							if (attack.critrate == 3.0)  {


								if (crit <= 27) {


									System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");

									if(attacker.ability.equals("sniper")) {

										damage *= 2.5;
										System.out.println("\n You got the sniper boost \n");
									}
									else {


										damage *= 1.5;

									}
								}

							}
							else if (attack.critrate == 6.0) {


								if (crit <= 55) {

									System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");

									if(attacker.ability.equals("sniper")) {

										damage *= 2.5;
										System.out.println("\n You got the sniper boost \n");
									}
									else {
										damage *= 1.5;
									}
								}

							}
							else {



								if (crit <= 101) {

									System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");

									if(attacker.ability.equals("sniper")) {

										damage *= 2.5;
										System.out.println("\n You got the sniper boost \n");
									}
									else {
										damage *= 1.5;
									}
								}



							}




							if(   (defender.type1.equals("steel")) || (defender.type1.equals("rock")) ) {

								damage *= 0.5;  //normal is resisted by these types
								System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");soundeffects.resist();

							}


							if(  (defender.type2.equals("steel")) || (defender.type2.equals("rock")) ) {

								damage *= 0.5;  //normal is resisted by these types
								System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists

							}


							if(defender.type1.equals("ghost") || defender.type2.equals("ghost")) {

								damage *= 0;
								System.out.println("\n GHOST POKEMON ARE IMMUNE TO NORMAL TYPE ATTACKS \n");

							}




							if( (defender.ability.equals("multiscale") ) ){

								if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");

									damage = damage/2;

								}
							}


							damage = Math.round(damage);

							System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );


							health =  health - damage;



							return Math.round(health);



						}
        	    
        	    //hyperbeam
           	 
        	    public static double hyperbeam(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	        soundeffects.noo(); 
        	        
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.spa/ (double) defender.spdef)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)
        	    	
        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	if(attacker.ability.equals("pixilate")) { // makes the move fairy type
        	    		
        	    		
        	    		if(   (defender.type1.equals("steel")) || (defender.type1.equals("poison")) ||  (defender.type1.equals("fire"))   ) {
               	    		
               	        	damage *= 0.5;  //fairy is resisted by these types
               	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
               	    		
               	    	}
               	    	

               	        if(   (defender.type2.equals("steel")) || (defender.type2.equals("poison")) ||  (defender.type2.equals("fire"))  ) {
               	    		
               	        	damage *= 0.5;  //fairy is resisted by these types
               	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
               	    		
               	    	}
               	        
               	        
            	        if( (defender.type1.equals("dark")) || (defender.type1.equals("dragon"))|| (defender.type1.equals("fighting")) ) {
            	    		
            	        	damage *= 2;  //fairy is super effective against these types
            	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
            	    		
            	    	}
            	    	

            	        if(  (defender.type2.equals("dark")) || (defender.type2.equals("dragon"))|| (defender.type2.equals("fighting")) ) {
            	    		
            	        	damage *= 2;  //fairy is super effective against these types
            	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
            	    		
            	    	}
    
            	     // for stab
        	    		if(   (attack.movetype.equals(attacker.type1)) ||  (attack.movetype.equals(attacker.type2)) )  {
        	    			
        	    			damage *= 1.5;
        	    			
        	    		}
        	    		
        	    		

            	        damage = Math.round(damage);
            	        
            	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
            	    	
            	        
            	        health =  health - damage; 
            	    	
            	        attacker.charging = true;
            	    	
            	    	return Math.round(health);
            	    	
            	    	
        	    		
        	    	}
        	    		
        	    	
        	    	
        	       if(   (defender.type1.equals("steel")) || (defender.type1.equals("rock")) ) {
           	    		
           	    		damage *= 0.5;  //normal is resisted by these types
           	    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");soundeffects.resist(); 
           	    		
           	    	}
           	    	

           	        if(  (defender.type2.equals("steel")) || (defender.type2.equals("rock")) ) {
           	    		
           	    		damage *= 0.5;  //normal is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
           	        if(defender.type1.equals("ghost") || defender.type2.equals("ghost")) {
           	        	
           	        	damage *= 0;
           	        	System.out.println("\n GHOST POKEMON ARE IMMUNE TO NORMAL TYPE ATTACKS \n");
           	        	
           	        } 
           	        
           	        
           	        
           	     
           	        if( (defender.ability.equals("multiscale") ) ){
           	          	 
           	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
           	      	     
           	      	     damage = damage/2;
           	      	     
           	      	     }
           	      	 }
           	        
        		
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	        attacker.charging = true;
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    
        	    
        	    
        	    
        	    
        	    //superfang
        	    
        	    public static double superfang(pokemon attacker, move attack, pokemon defender, String player) {
            	    
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
 	
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    
        	        soundeffects.noo(); 
        	        
        	    	double damage = roll * ( (defender.hp/2) + 1);
        	 
           	        
           	        
           	        if(defender.type1.equals("ghost") || defender.type2.equals("ghost")) {
           	        	
           	        	damage *= 0;
           	        	System.out.println("\n GHOST POKEMON ARE IMMUNE TO NORMAL TYPE ATTACKS \n");
           	        	
           	        } 
           	        
           	        
           	        
           	     
           	        if( (defender.ability.equals("multiscale") ) ){
           	          	 
           	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
           	      	     
           	      	     damage = damage/2;
           	      	     
           	      	     }
           	      	 }
           	        
        		
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	        
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;
        				soundeffects.statincrease();
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    
        	    
        	    //horndrill
        	    
        	    
        	    public static double horndrill(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
      
        	    	
        	    	double damage = defender.hp + 1;
        	    	
        	    	// make sure to code for crits 
        	    	
        	     
           	        if(defender.type1.equals("ghost") || defender.type2.equals("ghost")) {
           	        	
           	        	damage *= 0;
           	        	System.out.println("\n GHOST POKEMON ARE IMMUNE TO NORMAL TYPE ATTACKS \n");
           	        	
           	        } 
           	        
           	     
           	        if( (defender.ability.equals("multiscale") ) ){
           	          	 
           	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
           	      	     
           	      	     damage = damage/2;
           	      	     
           	      	     }
           	      	 }
         
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    
        	    
        	    
        	    
        	    
        	    // return
        	    
        	    
        	    public static double returnx(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	        soundeffects.noo(); 
        	        
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
        	    	
        	    	
        	       if(   (defender.type1.equals("steel")) || (defender.type1.equals("rock")) ) {
           	    		
           	    		damage *= 0.5;  //normal is resisted by these types
           	    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");soundeffects.resist(); 
           	    		
           	    	}
           	    	

           	        if(  (defender.type2.equals("steel")) || (defender.type2.equals("rock")) ) {
           	    		
           	    		damage *= 0.5;  //normal is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
           	        if(defender.type1.equals("ghost") || defender.type2.equals("ghost")) {
           	        	
           	        	damage *= 0;
           	        	System.out.println("\n GHOST POKEMON ARE IMMUNE TO NORMAL TYPE ATTACKS \n");
           	        	
           	        } 
           	        
           	        
           	        
           	     
           	        if( (defender.ability.equals("multiscale") ) ){
           	          	 
           	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
           	      	     
           	      	     damage = damage/2;
           	      	     
           	      	     }
           	      	 }
           	        
        		
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	        
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;soundeffects.statincrease();
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    
        	    //slash
        	    
        	    public static double slash(pokemon attacker, move attack, pokemon defender, String player) {
            	    
        	    	
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	        soundeffects.noo(); 
        	        
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
        	    	
        	    	
        	       if(   (defender.type1.equals("steel")) || (defender.type1.equals("rock")) ) {
           	    		
           	    		damage *= 0.5;  //normal is resisted by these types
           	    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");soundeffects.resist(); 
           	    		
           	    	}
           	    	

           	        if(  (defender.type2.equals("steel")) || (defender.type2.equals("rock")) ) {
           	    		
           	    		damage *= 0.5;  //normal is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
           	        if(defender.type1.equals("ghost") || defender.type2.equals("ghost")) {
           	        	
           	        	damage *= 0;
           	        	System.out.println("\n GHOST POKEMON ARE IMMUNE TO NORMAL TYPE ATTACKS \n");
           	        	
           	        } 
           	        
           	        
           	     
           	        if( (defender.ability.equals("multiscale") ) ){
           	          	 
           	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
           	      	     
           	      	     damage = damage/2;
           	      	     
           	      	     }
           	      	 }
           	        
           	 	 
           	   	 if(attacker.ability.equals("technician")) {
           	   		 
           	   		 
           	   		 damage *= 1.5;
           	   		 System.out.println("Technician powered up the hit!!");
           	   	 }
        		
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	        
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;
        				soundeffects.statincrease();
        				
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    
    
        	    
        	    // Attempting to code extremespeed, a normal move 
        	    
        	    public static double extremespeed(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	
        	    	soundeffects.noo(); 
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
        	    	
        	    	
        	       if(   (defender.type1.equals("steel")) || (defender.type1.equals("rock")) ) {
           	    		
           	    		damage *= 0.5;  //normal is resisted by these types
           	    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");soundeffects.resist(); 
           	    		
           	    	}
           	    	

           	        if(  (defender.type2.equals("steel")) || (defender.type2.equals("rock")) ) {
           	    		
           	    		damage *= 0.5;  //normal is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
           	        if(defender.type1.equals("ghost") || defender.type2.equals("ghost")) {
           	        	
           	        	damage *= 0;
           	        	System.out.println("\n GHOST POKEMON ARE IMMUNE TO NORMAL TYPE ATTACKS \n");
           	        	
           	        } 
           	        
           	        
           	        
           	     
           	        if( (defender.ability.equals("multiscale") ) ){
           	          	 
           	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
           	      	     
           	      	     damage = damage/2;
           	      	     
           	      	     }
           	      	 }
           	        
        		
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	        
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;
        				soundeffects.statincrease();
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    
        	    // Attempting to code quickattack, a normal move 
        	    
        	    public static double quickattack(pokemon attacker, move attack, pokemon defender, String player) {
        	    
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
        	    	
        	    	
        	       if(   (defender.type1.equals("steel")) || (defender.type1.equals("rock")) ) {
           	    		
           	    		damage *= 0.5;  //normal is resisted by these types
           	    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");soundeffects.resist(); 
           	    		
           	    	}
           	    	

           	        if(  (defender.type2.equals("steel")) || (defender.type2.equals("rock")) ) {
           	    		
           	    		damage *= 0.5;  //normal is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
           	        if(defender.type1.equals("ghost") || defender.type2.equals("ghost")) {
           	        	
           	        	damage *= 0;
           	        	System.out.println("\n GHOST POKEMON ARE IMMUNE TO NORMAL TYPE ATTACKS \n");
           	        	
           	        } 
           	        
           	        
           	        
           	     
           	        if( (defender.ability.equals("multiscale") ) ){
           	          	 
           	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
           	      	     
           	      	     damage = damage/2;
           	      	     
           	      	     }
           	      	 }
           	        
        		
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	        
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;
        				soundeffects.statincrease();
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    
        	    public static double relicsong(pokemon attacker, move attack, pokemon defender, String player) {
            	    
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.spa/ (double) defender.spdef)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)
        	    	
        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
        	    	
        	    	
        	       if(   (defender.type1.equals("steel")) || (defender.type1.equals("rock")) ) {
           	    		
           	    		damage *= 0.5;  //normal is resisted by these types
           	    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n "); soundeffects.resist(); 
           	    		
           	    	}
           	    	

           	        if(  (defender.type2.equals("steel")) || (defender.type2.equals("rock")) ) {
           	    		
           	    		damage *= 0.5;  //normal is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
           	        if(defender.type1.equals("ghost") || defender.type2.equals("ghost")) {
           	        	
           	        	damage *= 0;
           	        	System.out.println("\n GHOST POKEMON ARE IMMUNE TO NORMAL TYPE ATTACKS \n");
           	        	
           	        } 
           	        
           	        if( attacker.relic == false) {
           	        
           	        	System.out.println(" Meloetta has transformed into it's pirouette form!!! It is now normal and fighting type ");
           	        	attacker.type1 = "normal";
           	        	attacker.type2 = "fighting";
           	        	attacker.maxhp = 404;
           	        	attacker.attack = 390;
           	            attacker.def = 306;
       	                attacker.spdef = 278;
           	            attacker.spa = 278;
           	            attacker.speed = 390;
           	            attacker.relic = true;
           	        	
           	        	
           	        }
           	        else if(attacker.relic == true) {
           	        	
           	        	System.out.println(" Meloetta has transformed into it's aria form!!! It is now normal and psychic type ");
           	        	attacker.type1 = "normal";
           	        	attacker.type2 = "psychic";
           	        	attacker.maxhp = 404;
           	        	attacker.attack = 278;
           	            attacker.def = 278;
           	            attacker.spdef = 390;
           	            attacker.spa = 390;
           	            attacker.speed = 306;
           	            attacker.relic = false;
           	        	
           	        	
           	        }
           	        
           	        
           	        int bedtime = rand.nextInt(10);
           	        
           	        System.out.println(bedtime);
           	        
           	       
           	        	
           	        if(bedtime < 4) {
            	        	
           	            if(attacker.ability.equals("serenegrace")) {
           	        	 
           	        	 
           	         
            	        	if(defender.status.equals(" No status conditions")) {
            	        		
            	        		defender.status = "Sleep";
            	        		System.out.println("THE OPPOSING POKEMON TOOK A NAP DUE TO THE LULLABY, SERENE GRACE HARD CARRIED !!!!");
            	        	}
            	        	
            	        	
            	          }
           	         
           	        }
           	        	
           	        if(bedtime < 2) {
           	        	
           	        	if(defender.status.equals(" No status conditions")) {
           	        		
           	        		defender.status = "Sleep";
           	        		System.out.println("THE OPPOSING POKEMON TOOK A NAP DUE TO THE SONG!!!!");
                      	  
           	        	}
           	        	
           	        	
           	        }
           	     
           	        if( (defender.ability.equals("multiscale") ) ){
           	          	 
           	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
           	      	     
           	      	     damage = damage/2;
           	      	     
           	      	     }
           	      	 }
        		
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    
        	    }
        	    
        	    // code bodyslam 
        	    
        	    
        	    
        	    // Attempting to code bodyslam, a normal move 
        	    
        	    public static double bodyslam(pokemon attacker, move attack, pokemon defender, String player) {
        	    
        	    	
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
        	    	
        	    	
        	       if(   (defender.type1.equals("steel")) || (defender.type1.equals("rock")) ) {
           	    		
           	    		damage *= 0.5;  //normal is resisted by these types
           	    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");   soundeffects.resist(); 
           	    		
           	    	}
           	    	

           	        if(  (defender.type2.equals("steel")) || (defender.type2.equals("rock")) ) {
           	    		
           	    		damage *= 0.5;  //normal is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
           	        if(defender.type1.equals("ghost") || defender.type2.equals("ghost")) {
           	        	
           	        	damage *= 0;
           	        	System.out.println("\n GHOST POKEMON ARE IMMUNE TO NORMAL TYPE ATTACKS \n");
           	        	
           	        } 
           	        
           	        int para = rand.nextInt(10);
           	        
           	        
           	        	
           	        if(attacker.ability.equals("serenegrace")) {
           	        	if(defender.status.equals(" No status conditions")) {
	        			
           	        		if(para < 6) {
   	        		
           	        			System.out.println("The opposing pokemon has been slammed into paralysis, Serene Grace carried");
           	        			defender.status = "Paralyzed";
           	        			soundeffects.paralyze();
           	        		}
           	        	
           	        	}
	        		}
           	 	
           	 	
           	        if(defender.status.equals(" No status conditions")) {
           	        		
           	        		
           	        		if(para < 3) {
           	        		
           	        			
           	        			defender.status = "Paralyzed";
           	        			soundeffects.paralyze();
           	        			System.out.println("The opposing pokemon is paralyzed due to body slam!!");
           	        	}
           	        		
           	        
           	        		
           	        		
           	        }
           	        	
           	        	
           	        
           	        
           	        
           	     
           	        if( (defender.ability.equals("multiscale") ) ){
           	          	 
           	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
           	      	     
           	      	     damage = damage/2;
           	      	     
           	      	     }
           	      	 }
           	        
        		
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	        
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;
        				soundeffects.statincrease();
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    
        	    //END OF NORMAL TYPE ATTACKS
        	    
        	    
        	    /*
        	     * 
        	     * BUG TYPE ATTACKS
        	     * 
        	     */
        	       
        	    // code bug moves 
        	    
        	    
        	    //x scissor
        	    
        	    public static double xscissor(pokemon attacker, move attack, pokemon defender, String player) {
            	    
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	
        	    	
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	        if( (defender.type1.equals("fairy")) ||  (defender.type1.equals("poison")) || (defender.type1.equals("fighting")) || (defender.type1.equals("fire")) || (defender.type1.equals("flying")) || (defender.type1.equals("steel")) || (defender.type1.equals("rock")) ) {
        	    		
        	    		damage *= 0.5;  //bug is resisted by these types
        	    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");   soundeffects.resist(); 
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("fairy")) ||  (defender.type2.equals("poison")) || (defender.type2.equals("fighting")) || (defender.type2.equals("fire")) || (defender.type2.equals("flying")) || (defender.type2.equals("steel")) || (defender.type2.equals("rock")) ) {
        	    		
        	    		damage *= 0.5;  //bug is resisted by these types
        	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
        	    		
        	    	}
        	        
        	        
        	        
        	        if(   (defender.type1.equals("grass")) || (defender.type1.equals("psychic"))  || (defender.type1.equals("dark")) ) {
        	    		
        	    		damage *= 2;  //bug is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(   (defender.type2.equals("grass")) || (defender.type2.equals("psychic")) || (defender.type2.equals("dark"))) {
        	    		
        	    		damage *= 2;  //bug is super effective agaisnt these types
        	    		System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	        
        	        
        	        
        	        
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
        	  
           	        
        	    	 
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
           	        
        	    	 
        	      	 if(attacker.ability.equals("technician")) {
        	      		 
        	      		 
        	      		 damage *= 1.5;
        	      		 System.out.println("Technician powered up the hit!!");
        	      	 }
        	      	 
        	      	 
        	      	 
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	        
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;
        				
        				soundeffects.statincrease();
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }

				//BUGBUZZ


						public static double bugbuzz(pokemon attacker, move attack, pokemon defender, String player) {


							if(defender.bounce == true) { // Checks if the opponent is in the air....

								System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
								return defender.hp; // misses if the opponent is in the air
							}


							double health = defender.hp; // health value of the pokemon being attacked


							double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi

							System.out.println("Your damage roll is " + roll);

							soundeffects.noo();

							double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.spa/ (double) defender.spdef)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)

							// make sure to code for crits

							int crit = rand.nextInt(400);



							if (attack.critrate == 3.0)  {


								if (crit <= 27) {


									System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");

									if(attacker.ability.equals("sniper")) {

										damage *= 2.5;
										System.out.println("\n You got the sniper boost \n");
									}
									else {


										damage *= 1.5;

									}
								}

							}
							else if (attack.critrate == 6.0) {


								if (crit <= 55) {

									System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");

									if(attacker.ability.equals("sniper")) {

										damage *= 2.5;
										System.out.println("\n You got the sniper boost \n");
									}
									else {
										damage *= 1.5;
									}
								}

							}
							else {



								if (crit <= 101) {

									System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");

									if(attacker.ability.equals("sniper")) {

										damage *= 2.5;
										System.out.println("\n You got the sniper boost \n");
									}
									else {
										damage *= 1.5;
									}
								}



							}






							if( (defender.type1.equals("fairy")) ||  (defender.type1.equals("poison")) || (defender.type1.equals("fighting")) || (defender.type1.equals("fire")) || (defender.type1.equals("flying")) || (defender.type1.equals("steel")) || (defender.type1.equals("rock")) ) {

								damage *= 0.5;  //bug is resisted by these types
								System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");soundeffects.resist();

							}


							if(  (defender.type2.equals("fairy")) ||  (defender.type2.equals("poison")) || (defender.type2.equals("fighting")) || (defender.type2.equals("fire")) || (defender.type2.equals("flying")) || (defender.type2.equals("steel")) || (defender.type2.equals("rock")) ) {

								damage *= 0.5;  //bug is resisted by these types
								System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists

							}



							if(   (defender.type1.equals("grass")) || (defender.type1.equals("psychic"))  || (defender.type1.equals("dark")) ) {

								damage *= 2;  //bug is super effective against these types
								System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting

							}


							if(   (defender.type2.equals("grass")) || (defender.type2.equals("psychic")) || (defender.type2.equals("dark"))) {

								damage *= 2;  //bug is super effective agaisnt these types
								System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting

							}




							if( (defender.ability.equals("multiscale") ) ){

								if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");

									damage = damage/2;

								}
							}


							damage = Math.round(damage);

							System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );


							health =  health - damage;





							int oof = rand.nextInt(100);


							if( !(defender.ability.equals("clearbody"))   ) {



								if(attacker.ability.equals("serenegrace")) {

									if(oof > 90) {

										defender.spdef *= 0.5;
										System.out.println("The opponent's special defense decreased, serene grace elped the opponent.... ");

									}



								}


								if(oof < 10) {

									defender.spdef *= 0.5;
									System.out.println("The opponent's special defense decreased.... ");

								}


							}












							return Math.round(health);



						}

					// leechlife
        	    
        	    
        	    
        	    public static double leechlife(pokemon attacker, move attack, pokemon defender, String player) {
            	    
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	
        	    	
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	        if( (defender.type1.equals("fairy")) ||  (defender.type1.equals("poison")) || (defender.type1.equals("fighting")) || (defender.type1.equals("fire")) || (defender.type1.equals("flying")) || (defender.type1.equals("steel")) || (defender.type1.equals("rock")) ) {
        	    		
        	    		damage *= 0.5;  //bug is resisted by these types
        	    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");soundeffects.resist(); 
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("fairy")) ||  (defender.type2.equals("poison")) || (defender.type2.equals("fighting")) || (defender.type2.equals("fire")) || (defender.type2.equals("flying")) || (defender.type2.equals("steel")) || (defender.type2.equals("rock")) ) {
        	    		
        	    		damage *= 0.5;  //bug is resisted by these types
        	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
        	    		
        	    	}
        	        
        	        
        	        
        	        if(   (defender.type1.equals("grass")) || (defender.type1.equals("psychic"))  || (defender.type1.equals("dark")) ) {
        	    		
        	    		damage *= 2;  //bug is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(   (defender.type2.equals("grass")) || (defender.type2.equals("psychic")) || (defender.type2.equals("dark"))) {
        	    		
        	    		damage *= 2;  //bug is super effective agaisnt these types
        	    		System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	        
        	        
        	        
        	        
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    
        	    	
        	  
           	        
        	    	 
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
           	        
           	        
        		
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	    	
        	    	if (attacker.hp < attacker.maxhp) {
        	    		
        	    		System.out.println("The attacking pokemon gained hp through leechlife!! ");
        	    		
        	    		System.out.println(attacker.hp + " + " + (damage/2) + " = "  + (attacker.hp + (damage/2)) );
        	    		
        	    		attacker.hp += (damage / 2);
        	    		
        	    		
        	    	}
        	    	else {
        	    		
        	    		
        	    		System.out.println(" The attacking pokemon is already at full hp!!");
        	    		
        	    		
        	    		
        	    	}
        	        
        	        health =  health - damage; 
        	    	
        	        
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;
        				soundeffects.statincrease();
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    
        	    // pin missile 
        	    
        	    
        	    public static double pinmissle(pokemon attacker, move attack, pokemon defender, String player) {
            	    
        	    	
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	int times = rand.nextInt(10);
        	    	
        	    	if( (times == 0) || (times == 1) ) {
        	    		
        	    		
        	    		attack.power = 15;
        	    		System.out.println("Pin Missle only hit once (In my game thats a 15 base power)!!!");
        	    	}
        	    	else if( (times == 2) || (times == 3) ) {
        	    		attack.power = 30;
        	    		System.out.println("Pin Missle only hit twice (In my game thats a 30 base power)!!!");
        	    		
        	    		
        	    	}
        	    	else if( (times == 4) || (times == 5) ) {
        	    		attack.power = 60;
        	    		System.out.println("Pin Missle only hit 3 times (In my game thats a 60 base power)!!!");
        	    		
        	    		
        	    	}
        	    	else if( (times == 6) || (times == 7) ) {
        	    		attack.power = 120;
        	    		System.out.println("Pin Missle hit 4 times (In my game thats a 120 base power)!!!");
	
	
        	    	}
        	    	else if( (times == 8) || (times == 9) ) {
        	    		attack.power = 240;
        	    		System.out.println("Pin Missle hit 5 times (In my game thats a 240 base power) !!!");
	
	
        	    	}
        	    	
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	        if( (defender.type1.equals("fairy")) ||  (defender.type1.equals("poison")) || (defender.type1.equals("fighting")) || (defender.type1.equals("fire")) || (defender.type1.equals("flying")) || (defender.type1.equals("steel")) || (defender.type1.equals("rock")) ) {
        	    		
        	    		damage *= 0.5;  //bug is resisted by these types
        	    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n "); soundeffects.resist(); 
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("fairy")) ||  (defender.type2.equals("poison")) || (defender.type2.equals("fighting")) || (defender.type2.equals("fire")) || (defender.type2.equals("flying")) || (defender.type2.equals("steel")) || (defender.type2.equals("rock")) ) {
        	    		
        	    		damage *= 0.5;  //bug is resisted by these types
        	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
        	    		
        	    	}
        	        
        	        
        	        
        	        if(   (defender.type1.equals("grass")) || (defender.type1.equals("psychic"))  || (defender.type1.equals("dark")) ) {
        	    		
        	    		damage *= 2;  //bug is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(   (defender.type2.equals("grass")) || (defender.type2.equals("psychic")) || (defender.type2.equals("dark"))) {
        	    		
        	    		damage *= 2;  //bug is super effective agaisnt these types
        	    		System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	        
        	        
        	        
        	        
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
        	  
        	    	 
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
           	        
           	        
        		
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	        
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;
        				soundeffects.statincrease();
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    
        	    
        	    
        	    /*
        	     * 
        	     * WATER TYPE ATTACKS
        	     * 
        	     */
        	       
        	    
        	    // code water moves 
        	    
        	
        	
        	    // WATER PULSE
     	    public static double waterpulse(pokemon attacker, move attack, pokemon defender, String player) {
            	    
     	   	
     	    	
     	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
     	    		
     	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
     	    		return defender.hp; // misses if the opponent is in the air
     	    	}
     		
     		
     	    	
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.spa/ (double) defender.spdef)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)
        	    	
        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	      
        	        if(  (defender.type1.equals("water")) || (defender.type1.equals("grass")) || (defender.type1.equals("dragon")) ) {
        	    		
        	    		damage *= 0.5;  //water is resisted by these types
        	    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");soundeffects.resist(); 
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("water")) || (defender.type2.equals("grass")) || (defender.type2.equals("dragon")) ) {
        	    		
        	    		damage *= 0.5;  //water is resisted by these types
        	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
        	    		
        	    	}
        	        
        	        
        	        
        	        if(   (defender.type1.equals("fire")) || (defender.type1.equals("rock"))  || (defender.type1.equals("ground")) ) {
        	    		
        	    		damage *= 2;  //water is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(   (defender.type2.equals("fire")) || (defender.type2.equals("rock")) || (defender.type2.equals("ground"))) {
        	    		
        	    		damage *= 2;  //water is super effective agaisnt these types
        	    		System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	        
        	        
        	        
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
        	    	int confuse = rand.nextInt(100);
        	  
        	    	if (confuse > 21) {
        		  
        	    		defender.confused = true;
        		  		System.out.println("The opponent is now confused due to water pulse !!! ");
        	    	}
           	        
        	  
           	        
           	        if (attacker.ability.equals("serenegrace")) {
           	        	
           	        	
           	        	
           	        	if (confuse > 42) {
                  		  
            	    		defender.confused = true;
            		  		System.out.println("The opponent is now confused due to water pulse (Serene grace hard carried) !!! ");
            	    	}
               	        
           	        	
           	        	
           	        }
           	        
           	     
           	        if( (defender.ability.equals("multiscale") ) ){
           	          	 
           	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
           	      	     
           	      	     damage = damage/2;
           	      	     
           	      	     }
           	      	 }
           	        

    	        	if(defender.ability.equals("solidrock")){
    	        	 
    	        	damage = damage * 0.6;
    	        	 System.out.println("Solid rock reduced the damage of the attack");
    	        	 
    	        	 }
    	        	 
        		
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        if(defender.ability.equals("waterabsorb")) {
        	        	
        	        	health += damage;
        	        	System.out.println("The opposing pokemon was healed by water absorb");
        	        	return Math.round(health);
        	        	
        	        	
        	        }
        	        
        	        
        	        health =  health - damage; 
        	    	
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    
        	//HYDROPUMP    
     	    public static double hydropump(pokemon attacker, move attack, pokemon defender, String player) {
            	    
     	   	
     	    	
     	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
     	    		
     	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
     	    		return defender.hp; // misses if the opponent is in the air
     	    	}
     		
     		
     	    	
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.spa/ (double) defender.spdef)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)
        	    	
        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	      
        	        if(  (defender.type1.equals("water")) || (defender.type1.equals("grass")) || (defender.type1.equals("dragon")) ) {
        	    		
        	    		damage *= 0.5;  //water is resisted by these types
        	    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); 
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("water")) || (defender.type2.equals("grass")) || (defender.type2.equals("dragon")) ) {
        	    		
        	    		damage *= 0.5;  //water is resisted by these types
        	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
        	    		
        	    	}
        	        
        	        
        	        
        	        if(   (defender.type1.equals("fire")) || (defender.type1.equals("rock"))  || (defender.type1.equals("ground")) ) {
        	    		
        	    		damage *= 2;  //water is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(   (defender.type2.equals("fire")) || (defender.type2.equals("rock")) || (defender.type2.equals("ground"))) {
        	    		
        	    		damage *= 2;  //water is super effective agaisnt these types
        	    		System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	        
        	        
        	        
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
        	  
           	        
        	    	 
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
           	        
           	        

    	        	if(defender.ability.equals("solidrock")){
    	        	 
    	        	damage = damage * 0.6;
    	        	 System.out.println("Solid rock reduced the damage of the attack");
    	        	 
    	        	 }
    	        	 
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        if(defender.ability.equals("waterabsorb")) {
        	        	
        	        	health += damage;
        	        	System.out.println("The opposing pokemon was healed by water absorb");
        	        	return Math.round(health);
        	        	
        	        	
        	        }
        	        
        	        health =  health - damage; 
        	    	
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    
     	    
     	    
     	    
        	    //waterfall
        	    public static double waterfall(pokemon attacker, move attack, pokemon defender, String player) {
            	    
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	      
        	        if(  (defender.type1.equals("water")) || (defender.type1.equals("grass")) || (defender.type1.equals("dragon")) ) {
        	    		
        	    		damage *= 0.5;  //water is resisted by these types
        	    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");soundeffects.resist(); 
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("water")) || (defender.type2.equals("grass")) || (defender.type2.equals("dragon")) ) {
        	    		
        	    		damage *= 0.5;  //water is resisted by these types
        	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
        	    		
        	    	}
        	        
        	        
        	        
        	        if(   (defender.type1.equals("fire")) || (defender.type1.equals("rock"))  || (defender.type1.equals("ground")) ) {
        	    		
        	    		damage *= 2;  //water is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(   (defender.type2.equals("fire")) || (defender.type2.equals("rock")) || (defender.type2.equals("ground"))) {
        	    		
        	    		damage *= 2;  //water is super effective agaisnt these types
        	    		System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	        
        	        
        	        
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
        	  
        	    	if( !(attacker.ability.equals("sheerforce")) ) {
        	    		
        				
               	        int flinch = rand.nextInt(50);
               	        
               	        if( (flinch > 11)  && (attacker.speed >= defender.speed) ) {
               	        	
               	        	defender.flinched = true;
               	        }
        	    		
        	    		
        	    	}
        	    	else {
        	    		
        	    		
        	    		damage *= 1.3;
        	    		
        	    		System.out.println("Sheerforce powered up the hit......");
        	    	}
        	    			
        	    			
        	    	 
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
           	        
           	        

    	        	if(defender.ability.equals("solidrock")){
    	        	 
    	        	damage = damage * 0.6;
    	        	 System.out.println("Solid rock reduced the damage of the attack");
    	        	 
    	        	 }
    	        	 
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	        
        	        if(defender.ability.equals("waterabsorb")) {
        	        	
        	        	health += damage;
        	        	System.out.println("The opposing pokemon was healed by water absorb");
        	        	return Math.round(health);
        	        	
        	        	
        	        }
        	        
        	        
        	        health =  health - damage; 
        	    	
        	        
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;
        				soundeffects.statincrease();
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    //AQUATAIL
        	    public static double aquatail(pokemon attacker, move attack, pokemon defender, String player) {
            	    
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	      
        	        if(  (defender.type1.equals("water")) || (defender.type1.equals("grass")) || (defender.type1.equals("dragon")) ) {
        	    		
        	    		damage *= 0.5;  //water is resisted by these types
        	    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); 
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("water")) || (defender.type2.equals("grass")) || (defender.type2.equals("dragon")) ) {
        	    		
        	    		damage *= 0.5;  //water is resisted by these types
        	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
        	    		
        	    	}
        	        
        	        
        	        
        	        if(   (defender.type1.equals("fire")) || (defender.type1.equals("rock"))  || (defender.type1.equals("ground")) ) {
        	    		
        	    		damage *= 2;  //water is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(   (defender.type2.equals("fire")) || (defender.type2.equals("rock")) || (defender.type2.equals("ground"))) {
        	    		
        	    		damage *= 2;  //water is super effective agaisnt these types
        	    		System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	        
        	        
        	        
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}

        	    	 
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        	        
        	        

    	        	if(defender.ability.equals("solidrock")){
    	        	 
    	        	damage = damage * 0.6;
    	        	 System.out.println("Solid rock reduced the damage of the attack");
    	        	 
    	        	 }
    	        	 
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        if(defender.ability.equals("waterabsorb")) {
        	        	
        	        	health += damage;
        	        	System.out.println("The opposing pokemon was healed by water absorb");
        	        	return Math.round(health);
        	        	
        	        	
        	        }
        	        
        	        health =  health - damage; 
        	        
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;
        				soundeffects.statincrease();
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    
   	    //x SURF
        	    
        	    public static double surf(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.spa/ (double) defender.spdef)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)
        	    	
        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	      
        	        if(  (defender.type1.equals("water")) || (defender.type1.equals("grass")) || (defender.type1.equals("dragon")) ) {
        	    		
        	    		damage *= 0.5;  //water is resisted by these types
        	    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); 
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("water")) || (defender.type2.equals("grass")) || (defender.type2.equals("dragon")) ) {
        	    		
        	    		damage *= 0.5;  //water is resisted by these types
        	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
        	    		
        	    	}
        	        
        	        
        	        
        	        if(   (defender.type1.equals("fire")) || (defender.type1.equals("rock"))  || (defender.type1.equals("ground")) ) {
        	    		
        	    		damage *= 2;  //water is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(   (defender.type2.equals("fire")) || (defender.type2.equals("rock")) || (defender.type2.equals("ground"))) {
        	    		
        	    		damage *= 2;  //water is super effective agaisnt these types
        	    		System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	        
        	        
        	        
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
        	  
        	    	 
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
           	        

    	        	if(defender.ability.equals("solidrock")){
    	        	 
    	        	damage = damage * 0.6;
    	        	 System.out.println("Solid rock reduced the damage of the attack");
    	        	 
    	        	 }
    	        	 
        	        
        	        if(defender.ability.equals("waterabsorb")) {
        	        	
        	        	health += damage;
        	        	System.out.println("The opposing pokemon was healed by water absorb");
        	        	return Math.round(health);
        	        	
        	        	
        	        }
        	        
        		
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    
        	    // AQUAJET
        	   
        	    
        	    
        	    public static double aquajet(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
        	    	
        	    	
        	 
        	     	
          	      
        	        if(  (defender.type1.equals("water")) || (defender.type1.equals("grass")) || (defender.type1.equals("dragon")) ) {
        	    		
        	    		damage *= 0.5;  //water is resisted by these types
        	    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");   soundeffects.resist(); 
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("water")) || (defender.type2.equals("grass")) || (defender.type2.equals("dragon")) ) {
        	    		
        	    		damage *= 0.5;  //water is resisted by these types
        	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
        	    		
        	    	}
        	        
        	        
        	        
        	        if(   (defender.type1.equals("fire")) || (defender.type1.equals("rock"))  || (defender.type1.equals("ground")) ) {
        	    		
        	    		damage *= 2;  //water is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(   (defender.type2.equals("fire")) || (defender.type2.equals("rock")) || (defender.type2.equals("ground"))) {
        	    		
        	    		damage *= 2;  //water is super effective agaisnt these types
        	    		System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	        
           	        
        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        		
        	        

    	        	if(defender.ability.equals("solidrock")){
    	        	 
    	        	damage = damage * 0.6;
    	        	 System.out.println("Solid rock reduced the damage of the attack");
    	        	 
    	        	 }
    	        	 
    	        	
    	        	
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        if(defender.ability.equals("waterabsorb")) {
        	        	
        	        	health += damage;
        	        	System.out.println("The opposing pokemon was healed by water absorb");
        	        	return Math.round(health);
        	        	
        	        	
        	        }
        	        
        	        health =  health - damage; 
        	    	
        	        
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;
        				soundeffects.statincrease();
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }


				//Watershuriken


				public static double watershuriken(pokemon attacker, move attack, pokemon defender, String player) {




					if(defender.bounce == true) { // Checks if the opponent is in the air....

						System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
						return defender.hp; // misses if the opponent is in the air
					}



					double health = defender.hp; // health value of the pokemon being attacked

					int times = rand.nextInt(10);

					if( (times == 0) || (times == 1) ) {


						attack.power = 15;
						System.out.println("Watershuriken only hit once (In my game thats a 15 base power)!!!");
					}
					else if( (times == 2) || (times == 3) ) {
						attack.power = 30;
						System.out.println("Watershuriken only hit twice (In my game thats a 30 base power)!!!");


					}
					else if( (times == 4) || (times == 5) ) {
						attack.power = 60;
						System.out.println("Watershuriken only hit 3 times (In my game thats a 60 base power)!!!");


					}
					else if( (times == 6) || (times == 7) ) {
						attack.power = 120;
						System.out.println("Watershuriken hit 4 times (In my game thats a 120 base power)!!!");


					}
					else if( (times == 8) || (times == 9) ) {
						attack.power = 240;
						System.out.println("Watershuriken hit 5 times (In my game thats a 240 base power) !!!");


					}



					double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi

					System.out.println("Your damage roll is " + roll);


					soundeffects.noo();

					double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

					// make sure to code for crits

					int crit = rand.nextInt(400);







					//type stuff


					if(  (defender.type1.equals("water")) || (defender.type1.equals("grass")) || (defender.type1.equals("dragon")) ) {

						damage *= 0.5;  //water is resisted by these types
						System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");   soundeffects.resist();

					}


					if(  (defender.type2.equals("water")) || (defender.type2.equals("grass")) || (defender.type2.equals("dragon")) ) {

						damage *= 0.5;  //water is resisted by these types
						System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists

					}



					if(   (defender.type1.equals("fire")) || (defender.type1.equals("rock"))  || (defender.type1.equals("ground")) ) {

						damage *= 2;  //water is super effective against these types
						System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting

					}


					if(   (defender.type2.equals("fire")) || (defender.type2.equals("rock")) || (defender.type2.equals("ground"))) {

						damage *= 2;  //water is super effective agaisnt these types
						System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting

					}




					if (attack.critrate == 3.0)  {


						if (crit <= 27) {


							System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");

							if(attacker.ability.equals("sniper")) {

								damage *= 2.5;
								System.out.println("\n You got the sniper boost \n");
							}
							else {


								damage *= 1.5;

							}
						}

					}
					else if (attack.critrate == 6.0) {


						if (crit <= 55) {

							System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");

							if(attacker.ability.equals("sniper")) {

								damage *= 2.5;
								System.out.println("\n You got the sniper boost \n");
							}
							else {
								damage *= 1.5;
							}
						}

					}
					else {



						if (crit <= 101) {

							System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");

							if(attacker.ability.equals("sniper")) {

								damage *= 2.5;
								System.out.println("\n You got the sniper boost \n");
							}
							else {
								damage *= 1.5;
							}
						}



					}




					if( (defender.ability.equals("multiscale") ) ){

						if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");

							damage = damage/2;

						}
					}



					damage = Math.round(damage);

					System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );


					health =  health - damage;





					return Math.round(health);



				}








	// 3/22/2021 (Types of moves sketched: Water, bug, steel, normal,  ) (start on ice, dragon, fairy)
        	    
        	    
        	    /*
        	     * 
        	     * ICE TYPE ATTACKS
        	     * 
        	     */
        	       
        	    
        	    
    	    
        	    //Blizzard
        	    public static double blizzard(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.spa/ (double) defender.spdef)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)
        	    	
        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
        	    	
    	    		if(   (defender.type1.equals("steel")) ||  (defender.type1.equals("ice")) ||  (defender.type1.equals("water")) || (defender.type1.equals("fire")) ) {
           	    		
           	        	damage *= 0.5;  //ice is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	    	

           	        if(   (defender.type2.equals("steel")) || (defender.type2.equals("ice")) || (defender.type2.equals("water")) || (defender.type2.equals("fire")) ) {
           	    		
           	        	damage *= 0.5;  //ice is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
        	        if(  (defender.type1.equals("ground")) ||(defender.type1.equals("flying")) || (defender.type1.equals("grass")) || (defender.type1.equals("dragon")) ) {
        	    		
        	        	damage *= 2;  //ice is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("ground")) ||(defender.type2.equals("flying")) || (defender.type2.equals("grass")) || (defender.type2.equals("dragon")) ) {
        	    		
        	        	damage *= 2;  //ice is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}

        	       int frozen = rand.nextInt(100);
        	       
        	       if(frozen < 33) {
        	    	   if(defender.status.equals(" No status conditions")) {
        	    	   
        	    		   defender.status = "Frozen";
        	    	   System.out.println("The opposing pokemon has become frozen!!!!!!");
        	    	   soundeffects.frozen();
        	    	   
        	    	   }
        	       }
        		
        	       
        	       if(attacker.ability.equals("serenegrace")) {
        	    	   
        	    	   
            	       if(frozen < 66 ) {
            	    	   if(defender.status.equals(" No status conditions")) {
            	    	   
            	    		   defender.status = "Frozen";
            	    	   System.out.println("The opposing pokemon has become frozen, serenegrace has hard carried!!!!!!");
            	    	   soundeffects.frozen();
            	    	   
            	    	   }
            	       }
        	    	   
        	       }
        	       
        	       
        	       
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        	       
        	        

    	        	if(defender.ability.equals("solidrock")){
    	        	 
    	        	damage = damage * 0.6;
    	        	 System.out.println("Solid rock reduced the damage of the attack");
    	        	 
    	        	 }
    	        	 
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    
        	    	    
        	    
        	    // Icebeam
        	    public static double icebeam(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.spa/ (double) defender.spdef)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)
        	    	
        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
        	    	
    	    		if(   (defender.type1.equals("steel")) ||  (defender.type1.equals("ice")) ||  (defender.type1.equals("water")) || (defender.type1.equals("fire")) ) {
           	    		
           	        	damage *= 0.5;  //ice is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	    	

           	        if(   (defender.type2.equals("steel")) || (defender.type2.equals("ice")) || (defender.type2.equals("water")) || (defender.type2.equals("fire")) ) {
           	    		
           	        	damage *= 0.5;  //ice is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
        	        if(  (defender.type1.equals("ground")) ||(defender.type1.equals("flying")) || (defender.type1.equals("grass")) || (defender.type1.equals("dragon")) ) {
        	    		
        	        	damage *= 2;  //ice is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("ground")) ||(defender.type2.equals("flying")) || (defender.type2.equals("grass")) || (defender.type2.equals("dragon")) ) {
        	    		
        	        	damage *= 2;  //ice is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}

        	       int frozen = rand.nextInt(100);
        	       
        	       if(frozen < 11) {
        	    	   if(defender.status.equals(" No status conditions")) {
        	    	   
        	    		   defender.status = "Frozen";
        	    	   System.out.println("The opposing pokemon has become frozen!!!!!!");
        	    	   soundeffects.frozen();
        	    	   
        	    	   }
        	       }
        		
        	       
        	       if(attacker.ability.equals("serenegrace")) {
        	    	   
        	    	   
            	       if(frozen < 22 ) {
            	    	   if(defender.status.equals(" No status conditions")) {
            	    	   
            	    		   defender.status = "Frozen";
            	    	   System.out.println("The opposing pokemon has become frozen, serenegrace has hard carried!!!!!!");
            	    	   soundeffects.frozen();
            	    	   
            	    	   }
            	       }
        	    	   
        	       }
        	       
        	       
        	       
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        	       
        	        

    	        	if(defender.ability.equals("solidrock")){
    	        	 
    	        	damage = damage * 0.6;
    	        	 System.out.println("Solid rock reduced the damage of the attack");
    	        	 
    	        	 }
    	        	 
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    
        	    
        	    
        	    
        	    
        		//Icefang
        	    public static double icefang(pokemon attacker, move attack, pokemon defender, String player) {
            	    
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
        	    	
    	    		if(   (defender.type1.equals("steel")) ||  (defender.type1.equals("ice")) ||  (defender.type1.equals("water")) || (defender.type1.equals("fire")) ) {
           	    		
           	        	damage *= 0.5;  //ice is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	    	

           	        if(   (defender.type2.equals("steel")) || (defender.type2.equals("ice")) || (defender.type2.equals("water")) || (defender.type2.equals("fire")) ) {
           	    		
           	        	damage *= 0.5;  //ice is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
        	        if(  (defender.type1.equals("ground")) ||(defender.type1.equals("flying")) || (defender.type1.equals("grass")) || (defender.type1.equals("dragon")) ) {
        	    		
        	        	damage *= 2;  //ice is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("ground")) ||(defender.type2.equals("flying")) || (defender.type2.equals("grass")) || (defender.type2.equals("dragon")) ) {
        	    		
        	        	damage *= 2;  //ice is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}

        	        
        	       int frozen = rand.nextInt(100);
        	       
                   int flinch = rand.nextInt(100);
        	       
        	       if( (flinch > 90 ) && (attacker.speed >= defender.speed)) {
        	    	  
        	    	   defender.flinched = true;
        	       }
        		
        	       
        	       
        	       if(frozen < 11) {
        	    	   if(defender.status.equals(" No status conditions")) {
        	    	   
        	    		   defender.status = "Frozen";
        	    	   System.out.println("The opposing pokemon has become frozen!!!!!!");
        	    	   soundeffects.frozen();
        	    	   
        	    	   }
        	       }
        		
        	       
        	       if(attacker.ability.equals("serenegrace")) {
        	    	   
        	    	   
            	       if(frozen < 20 ) {
            	    	   if(defender.status.equals(" No status conditions")) {
            	    	   
            	    		   defender.status = "Frozen";
            	    	   System.out.println("The opposing pokemon has become frozen, serenegrace has hard carried!!!!!!");
            	    	   soundeffects.frozen();
            	    	   
            	    	   }
            	       }
        	    	   
        	       }
        	       
        	       
        	       
        	       
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        	        
        	        

    	        	if(defender.ability.equals("solidrock")){
    	        	 
    	        	damage = damage * 0.6;
    	        	 System.out.println("Solid rock reduced the damage of the attack");
    	        	 
    	        	 }
    	        	 
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	        
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;
        				soundeffects.statincrease();
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    //ICESHARD
        	    public static double iceshard(pokemon attacker, move attack, pokemon defender, String player) {
            	    
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
        	    	
    	    		if(   (defender.type1.equals("steel")) ||  (defender.type1.equals("ice")) ||  (defender.type1.equals("water")) || (defender.type1.equals("fire")) ) {
           	    		
           	        	damage *= 0.5;  //ice is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	    	

           	        if(   (defender.type2.equals("steel")) || (defender.type2.equals("ice")) || (defender.type2.equals("water")) || (defender.type2.equals("fire")) ) {
           	    		
           	        	damage *= 0.5;  //ice is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
        	        if(  (defender.type1.equals("ground")) ||(defender.type1.equals("flying")) || (defender.type1.equals("grass")) || (defender.type1.equals("dragon")) ) {
        	    		
        	        	damage *= 2;  //ice is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("ground")) ||(defender.type2.equals("flying")) || (defender.type2.equals("grass")) || (defender.type2.equals("dragon")) ) {
        	    		
        	        	damage *= 2;  //ice is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}

        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        		
        	        

    	        	if(defender.ability.equals("solidrock")){
    	        	 
    	        	damage = damage * 0.6;
    	        	 System.out.println("Solid rock reduced the damage of the attack");
    	        	 
    	        	 }
    	        	 
    	        	
    	        	
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	        
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;
        				soundeffects.statincrease();
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    
        	    //ICEPUNCH
        	    
        	    public static double icepunch(pokemon attacker, move attack, pokemon defender, String player) {
            	    
        	    	
        	    	
        	    	if((defender.bounce == true) && !(attacker.ability.equals("noguard")) ) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
        	    	
    	    		if(   (defender.type1.equals("steel")) ||  (defender.type1.equals("ice")) ||  (defender.type1.equals("water")) || (defender.type1.equals("fire")) ) {
           	    		
           	        	damage *= 0.5;  //ice is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	    	

           	        if(   (defender.type2.equals("steel")) || (defender.type2.equals("ice")) || (defender.type2.equals("water")) || (defender.type2.equals("fire")) ) {
           	    		
           	        	damage *= 0.5;  //ice is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
        	        if(  (defender.type1.equals("ground")) ||(defender.type1.equals("flying")) || (defender.type1.equals("grass")) || (defender.type1.equals("dragon")) ) {
        	    		
        	        	damage *= 2;  //ice is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("ground")) ||(defender.type2.equals("flying")) || (defender.type2.equals("grass")) || (defender.type2.equals("dragon")) ) {
        	    		
        	        	damage *= 2;  //ice is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}

        	        
        	        
        	        if( !(attacker.ability.equals("sheerforce"))) {
        	        	
        	        	 int frozen = rand.nextInt(100);
              	       
              	       if(frozen < 11) {
              	    	   if(defender.status.equals(" No status conditions")) {
              	    	   
              	    		   defender.status = "Frozen";
              	    	   System.out.println("The opposing pokemon has become frozen!!!!!!");
              	    	 soundeffects.frozen();
              	    	   
              	    	   }
              	       }
              		
              	       
              	       if(attacker.ability.equals("serenegrace")) {
              	    	   
              	    	   
                  	       if(frozen > 90 ) {
                  	    	   if(defender.status.equals(" No status conditions")) {
                  	    	   
                  	    		   defender.status = "Frozen";
                  	    	   System.out.println("The opposing pokemon has become frozen, serenegrace has hard carried!!!!!!");
                  	    	 soundeffects.frozen();
                  	    	   
                  	    	   }
                  	       }
              	    	   
              	       }
        	        	
        	        	
        	        }
        	        else {
        	        	
        	        	
        	        	damage *= 1.3;
        	        	System.out.println("sheerforce powered up the hit.");
        	        }
        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        	       
        	        
        	        if(attacker.ability.equals("ironfist")) {
        	        	
        	        	damage *= 1.3;
        	        	
        	        	System.out.println("Ironfist powered up the hit!!!");
        	        }
        	        
        	        

    	        	if(defender.ability.equals("solidrock")){
    	        	 
    	        	damage = damage * 0.6;
    	        	 System.out.println("Solid rock reduced the damage of the attack");
    	        	 
    	        	 }
    	        	 
        	       
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	        
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;
        				soundeffects.statincrease();
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    
        	    
        	    
        	    /*
        	     * 
        	     * DRAGON TYPE ATTACKS
        	     * 
        	     */
        	       
        	    
        	    
        	    
        	    //dragon  String[] dragontype = { "dragonclaw" , "dracometeor","dragonpulse" }; // dragon type moves
        	    
        	    //DRAGONCLAW
        	    public static double dragonclaw(pokemon attacker, move attack, pokemon defender, String player) {
            	    
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
        	    	
    	    		
    	    		if(   (defender.type1.equals("steel"))   ) {
           	    		
           	        	damage *= 0.5;  //dragon is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	    	

           	        if(   (defender.type2.equals("steel"))  ) {
           	    		
           	        	damage *= 0.5;  //dragon is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
        	        if( (defender.type1.equals("dragon"))  ) {
        	    		
        	        	damage *= 2;  //dragon is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("dragon"))  ) {
        	    		
        	        	damage *= 2;  //dragon is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}

        	        if(defender.type1.equals("fairy") || defender.type2.equals("fairy")) {
        	        	
        	        	damage *= 0;
        	        	System.out.println("\n FAIRY POKEMON ARE IMMUNE TO DRAGON TYPE ATTACKS \n");
        	        	
        	        } 
        	        
        	        
        	        
        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        	        
        	        
        	    	
    	  
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	        
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;
        				soundeffects.statincrease();
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        	    	
        	    
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
  
        	    
  
  
  
        	    
   	    public static double dragonpulse(pokemon attacker, move attack, pokemon defender, String player) {
            	    
   	 	
   	    	
   	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
   	    		
   	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
   	    		return defender.hp; // misses if the opponent is in the air
   	    	}
   		
   		
   	    	
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.spa/ (double) defender.spdef)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)
        	    	
        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
        	    	
    	    		
    	    		if(   (defender.type1.equals("steel"))   ) {
           	    		
           	        	damage *= 0.5;  //dragon is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	    	

           	        if(   (defender.type2.equals("steel"))  ) {
           	    		
           	        	damage *= 0.5;  //dragon is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
        	        if( (defender.type1.equals("dragon"))  ) {
        	    		
        	        	damage *= 2;  //dragon is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("dragon"))  ) {
        	    		
        	        	damage *= 2;  //dragon is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}

        	        if(defender.type1.equals("fairy") || defender.type2.equals("fairy")) {
        	        	
        	        	damage *= 0;
        	        	System.out.println("\n FAIRY POKEMON ARE IMMUNE TO DRAGON TYPE ATTACKS \n");
        	        	
        	        } 
        	        
        	        
        	        
        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        	        
        	        
        	    	
    	  
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	    	
        	    
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
  
        	    
    	    //DRACOMETEOR
        	    
        	    public static double dracometeor(pokemon attacker, move attack, pokemon defender, String player) {
            	    
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.spa/ (double) defender.spdef)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)
        	    	
        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
        	    	
    	    		
    	    		if(   (defender.type1.equals("steel"))   ) {
           	    		
           	        	damage *= 0.5;  //dragon is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	    	

           	        if(   (defender.type2.equals("steel"))  ) {
           	    		
           	        	damage *= 0.5;  //dragon is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
        	        if( (defender.type1.equals("dragon"))  ) {
        	    		
        	        	damage *= 2;  //dragon is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("dragon"))  ) {
        	    		
        	        	damage *= 2;  //dragon is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}

        	        if(defender.type1.equals("fairy") || defender.type2.equals("fairy")) {
        	        	
        	        	damage *= 0;
        	        	System.out.println("\n FAIRY POKEMON ARE IMMUNE TO DRAGON TYPE ATTACKS \n");
        	        	
        	        } 
        	        
        	        
        	        
        	        
        	        
        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        	    	
    	  
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	    	
        	        attacker.spa *= 0.5;
        	        System.out.println("THE ATTACKER'S SPECIAL ATTACK HARSHLY FELL!!!!!");
        	        soundeffects.drop();
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
    	    
        	    //fairy String[] fairytype = {  "moonblast" , "dazzlinggleam",}; // fairy type moves
        		
        	    
        	    /*
        	     * 
        	     * FAIRY TYPE ATTACKS
        	     * 
        	     */
        	       
        	    //MOONBLAST
        	    public static double moonblast(pokemon attacker, move attack, pokemon defender, String player) {
            	    
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.spa/ (double) defender.spdef)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)
        	    	
        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
        
        	       int reduce = rand.nextInt(100);
        	      
        	       if( !(defender.ability.equals("clearbody"))   ) {
        	    	   
        	    	   if(reduce < 11) {
            	    	   
            	    	   defender.spa *= 0.5;
            	    	   System.out.println("The opposing pokemon's special attack has been reduced!!!!!!");
            	    	   
            	    	   
            	       }
            		
            	       
            	       if(attacker.ability.equals("serenegrace")) {
            	    	   
            	    	   
                	       if(reduce < 22 ) {
                	    	   
                	    	   defender.spa *= 0.5;
                	    		 
                	    	   System.out.println("The opposing pokemon's special attack has been reduced (Serene grace has hard carried!!!!!!");
                	    	   
                	    	   
                	       }
            	    	   
            	       }
            	       
        	    	   
        	    	   
        	       }
        	      
        	       
        	   	if(   (defender.type1.equals("steel")) || (defender.type1.equals("poison")) ||  (defender.type1.equals("fire"))   ) {
       	    		
       	        	damage *= 0.5;  //fairy is resisted by these types
       	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
       	    		
       	    	}
       	    	

       	        if(   (defender.type2.equals("steel")) || (defender.type2.equals("poison")) ||  (defender.type2.equals("fire"))  ) {
       	    		
       	        	damage *= 0.5;  //fairy is resisted by these types
       	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
       	    		
       	    	}
       	        
       	        
    	        if( (defender.type1.equals("dark")) || (defender.type1.equals("dragon"))|| (defender.type1.equals("fighting")) ) {
    	    		
    	        	damage *= 2;  //fairy is super effective against these types
    	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
    	    		
    	    	}
    	    	

    	        if(  (defender.type2.equals("dark")) || (defender.type2.equals("dragon"))|| (defender.type2.equals("fighting")) ) {
    	    		
    	        	damage *= 2;  //fairy is super effective against these types
    	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
    	    		
    	    	}
    	        
    	        if( (defender.ability.equals("multiscale") ) ){
    	          	 
    	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
    	      	     
    	      	     damage = damage/2;
    	      	     
    	      	     }
    	      	 }
    	     
    	      
        	       
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }




						//PLAYROUGH
						public static double playrough(pokemon attacker, move attack, pokemon defender, String player) {



							if(defender.bounce == true) { // Checks if the opponent is in the air....

								System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
								return defender.hp; // misses if the opponent is in the air
							}



							double health = defender.hp; // health value of the pokemon being attacked


							double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi

							System.out.println("Your damage roll is " + roll);

							soundeffects.noo();

							double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


							if(attacker.ability.equals("toughclaws")){


								damage *= 1.3;
								System.out.println("Tough claws increased the damage of the attack!!");


							}

							// make sure to code for crits

							int crit = rand.nextInt(400);



							if (attack.critrate == 3.0)  {


								if (crit <= 27) {


									System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");

									if(attacker.ability.equals("sniper")) {

										damage *= 2.5;
										System.out.println("\n You got the sniper boost \n");
									}
									else {


										damage *= 1.5;

									}
								}

							}
							else if (attack.critrate == 6.0) {


								if (crit <= 55) {

									System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");

									if(attacker.ability.equals("sniper")) {

										damage *= 2.5;
										System.out.println("\n You got the sniper boost \n");
									}
									else {
										damage *= 1.5;
									}
								}

							}
							else {



								if (crit <= 101) {

									System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");

									if(attacker.ability.equals("sniper")) {

										damage *= 2.5;
										System.out.println("\n You got the sniper boost \n");
									}
									else {
										damage *= 1.5;
									}
								}



							}



							int reduce = rand.nextInt(100);

							if( !(defender.ability.equals("clearbody"))   ) {

								if(reduce < 11) {

									defender.attack *= 0.5;
									System.out.println("The opposing pokemon's physical attack has been reduced!!!!!!");


								}


								if(attacker.ability.equals("serenegrace")) {


									if(reduce < 22 ) {

										defender.attack *= 0.5;

										System.out.println("The opposing pokemon's physical attack has been reduced (Serene grace has hard carried!!!!!!");


									}

								}



							}


							if(   (defender.type1.equals("steel")) || (defender.type1.equals("poison")) ||  (defender.type1.equals("fire"))   ) {

								damage *= 0.5;  //fairy is resisted by these types
								System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists

							}


							if(   (defender.type2.equals("steel")) || (defender.type2.equals("poison")) ||  (defender.type2.equals("fire"))  ) {

								damage *= 0.5;  //fairy is resisted by these types
								System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists

							}


							if( (defender.type1.equals("dark")) || (defender.type1.equals("dragon"))|| (defender.type1.equals("fighting")) ) {

								damage *= 2;  //fairy is super effective against these types
								System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting

							}


							if(  (defender.type2.equals("dark")) || (defender.type2.equals("dragon"))|| (defender.type2.equals("fighting")) ) {

								damage *= 2;  //fairy is super effective against these types
								System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting

							}

							if( (defender.ability.equals("multiscale") ) ){

								if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");

									damage = damage/2;

								}
							}



							damage = Math.round(damage);

							System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );


							health =  health - damage;


							return Math.round(health);



						}





	//DAZZLINGGLEAM
        	    public static double dazzlinggleam(pokemon attacker, move attack, pokemon defender, String player) {
            	    
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.spa/ (double) defender.spdef)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)
        	    	
        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    
        	       
        	   	if(   (defender.type1.equals("steel")) || (defender.type1.equals("poison")) ||  (defender.type1.equals("fire"))   ) {
       	    		
       	        	damage *= 0.5;  //fairy is resisted by these types
       	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
       	    		
       	    	}
       	    	

       	        if(   (defender.type2.equals("steel")) || (defender.type2.equals("poison")) ||  (defender.type2.equals("fire"))  ) {
       	    		
       	        	damage *= 0.5;  //fairy is resisted by these types
       	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
       	    		
       	    	}
       	        
       	        
    	        if( (defender.type1.equals("dark")) || (defender.type1.equals("dragon"))|| (defender.type1.equals("fighting")) ) {
    	    		
    	        	damage *= 2;  //fairy is super effective against these types
    	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
    	    		
    	    	}
    	    	

    	        if(  (defender.type2.equals("dark")) || (defender.type2.equals("dragon"))|| (defender.type2.equals("fighting")) ) {
    	    		
    	        	damage *= 2;  //fairy is super effective against these types
    	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
    	    		
    	    	}

    	        
    	        if( (defender.ability.equals("multiscale") ) ){
    	          	 
    	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
    	      	     
    	      	     damage = damage/2;
    	      	     
    	      	     }
    	      	 }
    	      
        	       
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    
        	    /*
        	     * 
        	     * FLYING TYPE ATTACKS
        	     * 
        	     */
        	       
        
        	    //AERIALACE
        	    public static double aerialace(pokemon attacker, move attack, pokemon defender, String player) {
            	    
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
       
        			
    	    		if(   (defender.type1.equals("steel")) || (defender.type1.equals("rock")) || (defender.type1.equals("electric")) ) {
           	    		
           	        	damage *= 0.5;  //flying is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	    	

           	        if(   (defender.type2.equals("steel")) || (defender.type2.equals("rock")) || (defender.type2.equals("electric")) ) {
           	    		
           	        	damage *= 0.5;  //flying is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
        	        if(     (defender.type1.equals("grass")) || (defender.type1.equals("fighting")) || (defender.type1.equals("bug")) ) {
        	    		
        	        	damage *= 2;  //flying is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("grass")) || (defender.type2.equals("fighting")) || (defender.type2.equals("bug")) ) {
        	    		
        	        	damage *= 2;  //flying is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}

        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        	        
        	        
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	        
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;
        				soundeffects.statincrease();
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        	        return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
 
        	    
        	    
        	    //BRAVEBIRD
        	    
        	    public static double bravebird(pokemon attacker, move attack, pokemon defender, String player) {
            	    
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
       
        			
    	    		if(   (defender.type1.equals("steel")) || (defender.type1.equals("rock")) || (defender.type1.equals("electric")) ) {
           	    		
           	        	damage *= 0.5;  //flying is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	    	

           	        if(   (defender.type2.equals("steel")) || (defender.type2.equals("rock")) || (defender.type2.equals("electric")) ) {
           	    		
           	        	damage *= 0.5;  //flying is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
        	        if(     (defender.type1.equals("grass")) || (defender.type1.equals("fighting")) || (defender.type1.equals("bug")) ) {
        	    		
        	        	damage *= 2;  //flying is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("grass")) || (defender.type2.equals("fighting")) || (defender.type2.equals("bug")) ) {
        	    		
        	        	damage *= 2;  //flying is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        		
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	    	
        	        System.out.println("The user took damage as a result of bravebird!! " + attacker.hp + " - " + (damage/3) + " = " + (attacker.hp - (damage/3)) );
        	    
        	        attacker.hp -=  (damage/3);
        	        
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;
        				soundeffects.statincrease();
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        	        return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
 
 

                //AIRSLASH
         	    public static double airslash(pokemon attacker, move attack, pokemon defender, String player) {
             	    
         	   	
         	    	
         	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
         	    		
         	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
         	    		return defender.hp; // misses if the opponent is in the air
         	    	}
         		
         		
         	    	
         	    	double health = defender.hp; // health value of the pokemon being attacked
         	    	
         	    	
         	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
         	    	
         	    	System.out.println("Your damage roll is " + roll);
         	    	soundeffects.noo(); 
         	    	
         	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.spa/ (double) defender.spdef)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)
         	    	
         	    	// make sure to code for crits 
         	    	
         	    	int crit = rand.nextInt(400);
         	    	
         	    	
         	    	
         	    	if (attack.critrate == 3.0)  {
         	    
         		     
         	    	     if (crit <= 27) {
         	    	
         	    	    	 	
         	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
         	    		    
         	    			 if(attacker.ability.equals("sniper")) {
         	    				 
         	    				 damage *= 2.5;
         	    				 System.out.println("\n You got the sniper boost \n");
         	    			 }
         	    			 else {
         	    				 
         	    				 
         	    			 damage *= 1.5;
         	    			 
         	    			 }
         	    	     }
         	    	
         	    	}
         	    	else if (attack.critrate == 6.0) {
         	     		
         	     		
         	    		 if (crit <= 55) {
         	    		    	
         	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
         	    		    
         	    			 if(attacker.ability.equals("sniper")) {
         	    				 
         	    				 damage *= 2.5;
         	    				 System.out.println("\n You got the sniper boost \n");
         	    			 }
         	    			 else {
         	    			 damage *= 1.5;
         	    			 }
         	    	     }
         	     		
         		    }
         	    	else {
         	    		
         	    		

         	   		 if (crit <= 101) {
         	   		    	
         	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
         	   		    
         	   			 if(attacker.ability.equals("sniper")) {
         	   				 
         	   				 damage *= 2.5;
         	   				 System.out.println("\n You got the sniper boost \n");
         	   			 }
         	   			 else {
         	   			 damage *= 1.5;
         	   			 }
         	   	     }
         	    		
         	    		
         	    		
         	    	}
         	    	
         	    
    
         			
     	    		if(   (defender.type1.equals("steel")) || (defender.type1.equals("rock")) || (defender.type1.equals("electric")) ) {
            	    		
            	        	damage *= 0.5;  //flying is resisted by these types
            	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
            	    		
            	    	}
            	    	

            	        if(   (defender.type2.equals("steel")) || (defender.type2.equals("rock")) || (defender.type2.equals("electric")) ) {
            	    		
            	        	damage *= 0.5;  //flying is resisted by these types
            	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
            	    		
            	    	}
            	        
            	        
         	        if(     (defender.type1.equals("grass")) || (defender.type1.equals("fighting")) || (defender.type1.equals("bug")) ) {
         	    		
         	        	damage *= 2;  //flying is super effective against these types
         	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
         	    		
         	    	}
         	    	

         	        if(  (defender.type2.equals("grass")) || (defender.type2.equals("fighting")) || (defender.type2.equals("bug")) ) {
         	    		
         	        	damage *= 2;  //flying is super effective against these types
         	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
         	    		
         	    	}

         	        int flinch = rand.nextInt(100);
         	        

         	        	
         	        	if(attacker.ability.equals("serenegrace")) {
         	        		if( (flinch < 60) && (attacker.speed >= defender.speed)){
                 	        	
                 	        	defender.flinched = true;
                 	        	
             	        	}
         	        		
         	        		
         	        	}
         	        	
         	        	if( (flinch < 30) && (attacker.speed >= defender.speed)) {
         	        	
         	            	defender.flinched = true;
         	     
         	        	
         	        	}

         	       
         	        
         	       
         	        if( (defender.ability.equals("multiscale") ) ){
         	          	 
         	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
         	      	     
         	      	     damage = damage/2;
         	      	     
         	      	     }
         	      	 }
         	        
         	        
         	        damage = Math.round(damage);
         	        
         	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
         	    	
         	        
         	        health =  health - damage; 
         	    	
         	    	
         	    	return Math.round(health);
         	    	
         	    	
         	    	
         	    }
         	    
         	    
         	    
               //BOUNCE
        	    public static double bounce(pokemon attacker, move attack, pokemon defender, String player) {
            	    
        	    	
        	    
        		
        	    	
        	    	if(attacker.bounce == false) {
        	    		
        	    		System.out.println("The pokemon bounced into the air!!!!!");
        	    		attacker.bounce = true;
        	    		return defender.hp;
        	    		
        	    	}
        	    	else {
        	    		
        	    		attacker.bounce = false;
        	    		System.out.println("The pokemon jumped slammed the opponent!!!!!");
        	    		
        	    		
        	        	
        	        	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	        		
        	        		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	        		return defender.hp; // misses if the opponent is in the air
        	        	}
        	    	
        	    	
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)

					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    
   
        			
    	    		if(   (defender.type1.equals("steel")) || (defender.type1.equals("rock")) || (defender.type1.equals("electric")) ) {
           	    		
           	        	damage *= 0.5;  //flying is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	    	

           	        if(   (defender.type2.equals("steel")) || (defender.type2.equals("rock")) || (defender.type2.equals("electric")) ) {
           	    		
           	        	damage *= 0.5;  //flying is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
        	        if(     (defender.type1.equals("grass")) || (defender.type1.equals("fighting")) || (defender.type1.equals("bug")) ) {
        	    		
        	        	damage *= 2;  //flying is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("grass")) || (defender.type2.equals("fighting")) || (defender.type2.equals("bug")) ) {
        	    		
        	        	damage *= 2;  //flying is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}

        	        int para = rand.nextInt(100);
        	        
        	        if(defender.status.equals(" No status conditions")) {
        	        	
        	        	if(attacker.ability.equals("serenegrace")) {
        	        		if(para < 60) {
                	        	
                	        	System.out.println("The opposing pokemon is paralyzed due to bounce (serene grace carried!!!) ");
                	        	soundeffects.paralyze();
                	        	defender.status = "Paralyzed";
                	        	
            	        	}
        	        		
        	        		
        	        	}
        	        	
        	        	if(para < 30) {
        	        	
        	            	System.out.println("The opposing pokemon is paralyzed due to bounce ");
        	            	soundeffects.paralyze();
            	        	defender.status = "Paralyzed";
        	     
        	        	
        	        	}
        	        }
        	       
        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        	        
        	        
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	        
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;
        				soundeffects.statincrease();
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    
        	    
    // 3/23/2021 (Types of moves sketched: Water, bug, steel,flying, normal, ice, dragon, fairy)
        	    
        	    // Start on: fire, electric, grass, fighting
        	    
          	  
  //x scissor
        	    
        	    
        	    /*
        	     * 
        	     * FIGHTING TYPE ATTACKS
        	     * 
        	     */
        	       
        	    
        	    //FOCUSBLAST
        	    
    	    public static double focusblast(pokemon attacker, move attack, pokemon defender, String player) {
    	    	
    	    	
    	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
    	    		
    	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
    	    		return defender.hp; // misses if the opponent is in the air
    	    	}
    		
    		
    	    	
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.spa/ (double) defender.spdef)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)
        	    	
        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
      
        	        
        	        
        	        
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
        	  
  	  
           	        
        	    	
    	    		if(   (defender.type1.equals("fairy")) ||(defender.type1.equals("bug")) ||(defender.type1.equals("psychic")) ||  (defender.type1.equals("flying")) ||  (defender.type1.equals("poison")) ) {
           	    		
           	        	damage *= 0.5;  //fighting is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	    	

           	        if(   (defender.type2.equals("fairy")) ||(defender.type2.equals("bug")) || (defender.type2.equals("psychic")) || (defender.type2.equals("flying")) || (defender.type2.equals("poison")) ) {
           	    		
           	        	damage *= 0.5;  //fighting is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
        	        if(  (defender.type1.equals("steel")) ||(defender.type1.equals("dark")) || (defender.type1.equals("rock")) ||(defender.type1.equals("ice")) || (defender.type1.equals("normal")) ) {
        	    		
        	        	damage *= 2;  //fighting is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("steel")) ||(defender.type2.equals("dark")) || (defender.type2.equals("rock")) ||(defender.type2.equals("ice")) || (defender.type2.equals("normal")) ) {
        	    		
        	        	damage *= 2;  //fighting is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}

        	     
        	        
        	        if(defender.type1.equals("ghost") || defender.type2.equals("ghost")) {
        	        	
        	        	damage *= 0;
        	        	System.out.println("\n GHOST POKEMON ARE IMMUNE TO FIGHTING TYPE ATTACKS \n");
        	        	
        	        } 
        	      


           	        
        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        		
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        int oof = rand.nextInt(100);
        	        
        	        
        	        if (   !( defender.ability.equals("clearbody"))    ) {
        	        	
        	        	 if(oof < 30) {
             	        	
             	        	defender.spdef *= 0.5;
             	        	soundeffects.drop();
             	        	System.out.println("The opponent's defense fell");
             	        }
        	        	
        	        	
        	        }
        	       
        	        
        	        health =  health - damage; 
        	    	
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }



					//AURASPHERE

					public static double aurasphere(pokemon attacker, move attack, pokemon defender, String player) {


						double health = defender.hp; // health value of the pokemon being attacked


						double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi

						System.out.println("Your damage roll is " + roll);

						soundeffects.noo();

						double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.spa/ (double) defender.spdef)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)

						// make sure to code for crits

						int crit = rand.nextInt(400);




						if (attack.critrate == 3.0)  {


							if (crit <= 27) {


								System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");

								if(attacker.ability.equals("sniper")) {

									damage *= 2.5;
									System.out.println("\n You got the sniper boost \n");
								}
								else {


									damage *= 1.5;

								}
							}

						}
						else if (attack.critrate == 6.0) {


							if (crit <= 55) {

								System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");

								if(attacker.ability.equals("sniper")) {

									damage *= 2.5;
									System.out.println("\n You got the sniper boost \n");
								}
								else {
									damage *= 1.5;
								}
							}

						}
						else {



							if (crit <= 101) {

								System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");

								if(attacker.ability.equals("sniper")) {

									damage *= 2.5;
									System.out.println("\n You got the sniper boost \n");
								}
								else {
									damage *= 1.5;
								}
							}



						}






						if(   (defender.type1.equals("fairy")) ||(defender.type1.equals("bug")) ||(defender.type1.equals("psychic")) ||  (defender.type1.equals("flying")) ||  (defender.type1.equals("poison")) ) {

							damage *= 0.5;  //fighting is resisted by these types
							System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists

						}


						if(   (defender.type2.equals("fairy")) ||(defender.type2.equals("bug")) || (defender.type2.equals("psychic")) || (defender.type2.equals("flying")) || (defender.type2.equals("poison")) ) {

							damage *= 0.5;  //fighting is resisted by these types
							System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists

						}


						if(  (defender.type1.equals("steel")) ||(defender.type1.equals("dark")) || (defender.type1.equals("rock")) ||(defender.type1.equals("ice")) || (defender.type1.equals("normal")) ) {

							damage *= 2;  //fighting is super effective against these types
							System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting

						}


						if(  (defender.type2.equals("steel")) ||(defender.type2.equals("dark")) || (defender.type2.equals("rock")) ||(defender.type2.equals("ice")) || (defender.type2.equals("normal")) ) {

							damage *= 2;  //fighting is super effective against these types
							System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting

						}



						if(defender.type1.equals("ghost") || defender.type2.equals("ghost")) {

							damage *= 0;
							System.out.println("\n GHOST POKEMON ARE IMMUNE TO FIGHTING TYPE ATTACKS \n");

						}





						if( (defender.ability.equals("multiscale") ) ){

							if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");

								damage = damage/2;

							}
						}

						damage = Math.round(damage);

						System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );






						health =  health - damage;


						return Math.round(health);



					}




	//DOUBLEKICK
        	    public static double doublekick(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
      
        	        
        	        
        	        
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
        	  
  	  
           	        
        	    	
    	    		if(   (defender.type1.equals("fairy")) ||(defender.type1.equals("bug")) ||(defender.type1.equals("psychic")) ||  (defender.type1.equals("flying")) ||  (defender.type1.equals("poison")) ) {
           	    		
           	        	damage *= 0.5;  //fighting is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	    	

           	        if(   (defender.type2.equals("fairy")) ||(defender.type2.equals("bug")) || (defender.type2.equals("psychic")) || (defender.type2.equals("flying")) || (defender.type2.equals("poison")) ) {
           	    		
           	        	damage *= 0.5;  //fighting is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
        	        if(  (defender.type1.equals("steel")) ||(defender.type1.equals("dark")) || (defender.type1.equals("rock")) ||(defender.type1.equals("ice")) || (defender.type1.equals("normal")) ) {
        	    		
        	        	damage *= 2;  //fighting is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("steel")) ||(defender.type2.equals("dark")) || (defender.type2.equals("rock")) ||(defender.type2.equals("ice")) || (defender.type2.equals("normal")) ) {
        	    		
        	        	damage *= 2;  //fighting is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}

        	     
        	        
        	        if(defender.type1.equals("ghost") || defender.type2.equals("ghost")) {
        	        	
        	        	damage *= 0;
        	        	System.out.println("\n GHOST POKEMON ARE IMMUNE TO FIGHTING TYPE ATTACKS \n");
        	        	
        	        } 
        	      

        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
           	        
        		
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	        
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;
        				soundeffects.statincrease();
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    //CROSSCHOP
        	    public static double crosschop(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if((defender.bounce == true) && !(attacker.ability.equals("noguard")) ) {// Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
      
        	        
        	        
        	        
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
        	  
  	  
           	        
        	    	
    	    		if(   (defender.type1.equals("fairy")) ||(defender.type1.equals("bug")) ||(defender.type1.equals("psychic")) ||  (defender.type1.equals("flying")) ||  (defender.type1.equals("poison")) ) {
           	    		
           	        	damage *= 0.5;  //fighting is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	    	

           	        if(   (defender.type2.equals("fairy")) ||(defender.type2.equals("bug")) || (defender.type2.equals("psychic")) || (defender.type2.equals("flying")) || (defender.type2.equals("poison")) ) {
           	    		
           	        	damage *= 0.5;  //fighting is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
        	        if(  (defender.type1.equals("steel")) ||(defender.type1.equals("dark")) || (defender.type1.equals("rock")) ||(defender.type1.equals("ice")) || (defender.type1.equals("normal")) ) {
        	    		
        	        	damage *= 2;  //fighting is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("steel")) ||(defender.type2.equals("dark")) || (defender.type2.equals("rock")) ||(defender.type2.equals("ice")) || (defender.type2.equals("normal")) ) {
        	    		
        	        	damage *= 2;  //fighting is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}

        	     
        	        
        	        if(defender.type1.equals("ghost") || defender.type2.equals("ghost")) {
        	        	
        	        	damage *= 0;
        	        	System.out.println("\n GHOST POKEMON ARE IMMUNE TO FIGHTING TYPE ATTACKS \n");
        	        	
        	        } 
        	      

        	      

        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
           	        
        		
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	        
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;
        				soundeffects.statincrease();
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    
        	    
        	    
        	    //DYNAMICPUNCH
        	    public static double dynamicpunch(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if((defender.bounce == true) && !(attacker.ability.equals("noguard")) ) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
      
        	        
        	        
        	        
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
  	  
           	        
        	    	
    	    		if(   (defender.type1.equals("fairy")) ||(defender.type1.equals("bug")) ||(defender.type1.equals("psychic")) ||  (defender.type1.equals("flying")) ||  (defender.type1.equals("poison")) ) {
           	    		
           	        	damage *= 0.5;  //fighting is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	    	

           	        if(   (defender.type2.equals("fairy")) ||(defender.type2.equals("bug")) || (defender.type2.equals("psychic")) || (defender.type2.equals("flying")) || (defender.type2.equals("poison")) ) {
           	    		
           	        	damage *= 0.5;  //fighting is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
        	        if(  (defender.type1.equals("steel")) ||(defender.type1.equals("dark")) || (defender.type1.equals("rock")) ||(defender.type1.equals("ice")) || (defender.type1.equals("normal")) ) {
        	    		
        	        	damage *= 2;  //fighting is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("steel")) ||(defender.type2.equals("dark")) || (defender.type2.equals("rock")) ||(defender.type2.equals("ice")) || (defender.type2.equals("normal")) ) {
        	    		
        	        	damage *= 2;  //fighting is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}

        	     
        	        
        	        if(defender.type1.equals("ghost") || defender.type2.equals("ghost")) {
        	        	
        	        	damage *= 0;
        	        	System.out.println("\n GHOST POKEMON ARE IMMUNE TO FIGHTING TYPE ATTACKS \n");
        	        	
        	        } 
        	      

        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
           	        
           	        
        		
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	    	defender.confused = true;
        	    	System.out.println("The opposing pokemon has become confused. ");
        	    	
        	    	
        	    	
        	    	 
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;
        				soundeffects.statincrease();
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    //DRAINPUNCH

						public static double drainpunch(pokemon attacker, move attack, pokemon defender, String player) {



							if(defender.bounce == true) { // Checks if the opponent is in the air....

								System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
								return defender.hp; // misses if the opponent is in the air
							}




							double health = defender.hp; // health value of the pokemon being attacked


							double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi

							System.out.println("Your damage roll is " + roll);

							soundeffects.noo();

							double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


							if(attacker.ability.equals("toughclaws")){


								damage *= 1.3;
								System.out.println("Tough claws increased the damage of the attack!!");


							}

							// make sure to code for crits




							if(   (defender.type1.equals("fairy")) ||(defender.type1.equals("bug")) ||(defender.type1.equals("psychic")) ||  (defender.type1.equals("flying")) ||  (defender.type1.equals("poison")) ) {

								damage *= 0.5;  //fighting is resisted by these types
								System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists

							}


							if(   (defender.type2.equals("fairy")) ||(defender.type2.equals("bug")) || (defender.type2.equals("psychic")) || (defender.type2.equals("flying")) || (defender.type2.equals("poison")) ) {

								damage *= 0.5;  //fighting is resisted by these types
								System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists

							}


							if(  (defender.type1.equals("steel")) ||(defender.type1.equals("dark")) || (defender.type1.equals("rock")) ||(defender.type1.equals("ice")) || (defender.type1.equals("normal")) ) {

								damage *= 2;  //fighting is super effective against these types
								System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting

							}


							if(  (defender.type2.equals("steel")) ||(defender.type2.equals("dark")) || (defender.type2.equals("rock")) ||(defender.type2.equals("ice")) || (defender.type2.equals("normal")) ) {

								damage *= 2;  //fighting is super effective against these types
								System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting

							}



							if(defender.type1.equals("ghost") || defender.type2.equals("ghost")) {

								damage *= 0;
								System.out.println("\n GHOST POKEMON ARE IMMUNE TO FIGHTING TYPE ATTACKS \n");

							}


							int crit = rand.nextInt(400);


							if (attack.critrate == 3.0)  {


								if (crit <= 27) {


									System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");

									if(attacker.ability.equals("sniper")) {

										damage *= 2.5;
										System.out.println("\n You got the sniper boost \n");
									}
									else {


										damage *= 1.5;

									}
								}

							}
							else if (attack.critrate == 6.0) {


								if (crit <= 55) {

									System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");

									if(attacker.ability.equals("sniper")) {

										damage *= 2.5;
										System.out.println("\n You got the sniper boost \n");
									}
									else {
										damage *= 1.5;
									}
								}

							}
							else {



								if (crit <= 101) {

									System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");

									if(attacker.ability.equals("sniper")) {

										damage *= 2.5;
										System.out.println("\n You got the sniper boost \n");
									}
									else {
										damage *= 1.5;
									}
								}



							}





							if( (defender.ability.equals("multiscale") ) ){

								if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");

									damage = damage/2;

								}
							}



							damage = Math.round(damage);

							System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );


							if (attacker.hp < attacker.maxhp) {

								System.out.println("The attacking pokemon gained hp through drainpunch!! ");

								System.out.println(attacker.hp + " + " + (damage/2) + " = "  + (attacker.hp + (damage/2)) );

								attacker.hp += (damage / 2);


							}
							else {


								System.out.println(" The attacking pokemon is already at full hp!!");



							}

							health =  health - damage;




							if(defender.ability.equals("stamina")) {

								defender.def *= 1.5;
								soundeffects.statincrease();
								System.out.println("The opposing pokemon's defense rose");
							}


							return Math.round(health);



						}




        	    //BRICKBREAK
        	    public static double brickbreak(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
      
        	        
        	        
        	        
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
        	  
  	  
           	        
        	    	
    	    		if(   (defender.type1.equals("fairy")) ||(defender.type1.equals("bug")) ||(defender.type1.equals("psychic")) ||  (defender.type1.equals("flying")) ||  (defender.type1.equals("poison")) ) {
           	    		
           	        	damage *= 0.5;  //fighting is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
            	    	

           	        if(   (defender.type2.equals("fairy")) ||(defender.type2.equals("bug")) || (defender.type2.equals("psychic")) || (defender.type2.equals("flying")) || (defender.type2.equals("poison")) ) {
           	    		
           	        	damage *= 0.5;  //fighting is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
        	        if(  (defender.type1.equals("steel")) ||(defender.type1.equals("dark")) || (defender.type1.equals("rock")) ||(defender.type1.equals("ice")) || (defender.type1.equals("normal")) ) {
        	    		
        	        	damage *= 2;  //fighting is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}   
        	    	

        	        if(  (defender.type2.equals("steel")) ||(defender.type2.equals("dark")) || (defender.type2.equals("rock")) ||(defender.type2.equals("ice")) || (defender.type2.equals("normal")) ) {
        	    		
        	        	damage *= 2;  //fighting is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}

        	     
        	        
        	        if(defender.type1.equals("ghost") || defender.type2.equals("ghost")) {
        	        	
        	        	damage *= 0;
        	        	System.out.println("\n GHOST POKEMON ARE IMMUNE TO FIGHTING TYPE ATTACKS \n");
        	        	
        	        } 
        	      

        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
           	        
        		
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	        
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;
        				
        				soundeffects.statincrease();
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    
        	    //CLOSECOMBAT
        	    public static double closecombat(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if((defender.bounce == true) && !(attacker.ability.equals("noguard")) ) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
      
        	        
        	        
        	        
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
        	  
           	        
        	    	
    	    		if(   (defender.type1.equals("fairy")) ||(defender.type1.equals("bug")) ||(defender.type1.equals("psychic")) ||  (defender.type1.equals("flying")) ||  (defender.type1.equals("poison")) ) {
           	    		
           	        	damage *= 0.5;  //fighting is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	    	

           	        if(   (defender.type2.equals("fairy")) ||(defender.type2.equals("bug")) || (defender.type2.equals("psychic")) || (defender.type2.equals("flying")) || (defender.type2.equals("poison")) ) {
           	    		
           	        	damage *= 0.5;  //fighting is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
        	        if(  (defender.type1.equals("steel")) ||(defender.type1.equals("dark")) || (defender.type1.equals("rock")) ||(defender.type1.equals("ice")) || (defender.type1.equals("normal")) ) {
        	    		
        	        	damage *= 2;  //fighting is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("steel")) ||(defender.type2.equals("dark")) || (defender.type2.equals("rock")) ||(defender.type2.equals("ice")) || (defender.type2.equals("normal")) ) {
        	    		
        	        	damage *= 2;  //fighting is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}

        	     
        	        
        	        if(defender.type1.equals("ghost") || defender.type2.equals("ghost")) {
        	        	
        	        	damage *= 0;
        	        	System.out.println("\n GHOST POKEMON ARE IMMUNE TO FIGHTING TYPE ATTACKS \n");
        	        	
        	        } 
        	      

           	        
        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        		
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	        soundeffects.drop();
        	    	System.out.println("The user's defense and special defence fell....");
        	    	attacker.def *=0.5;
        	    	attacker.spdef *= 0.5;
        	    	
        	    	
        	    	 
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;
        				soundeffects.statincrease();
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        			
        			
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    //SUPERPOWER
        	    public static double superpower(pokemon attacker, move attack, pokemon defender, String player) {
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
 	
 	
 	
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
      
        	        
        	        
        	        
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
        	  
  	  
           	        
        	    	
    	    		if(   (defender.type1.equals("fairy")) ||(defender.type1.equals("bug")) ||(defender.type1.equals("psychic")) ||  (defender.type1.equals("flying")) ||  (defender.type1.equals("poison")) ) {
           	    		
           	        	damage *= 0.5;  //fighting is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	    	

           	        if(   (defender.type2.equals("fairy")) ||(defender.type2.equals("bug")) || (defender.type2.equals("psychic")) || (defender.type2.equals("flying")) || (defender.type2.equals("poison")) ) {
           	    		
           	        	damage *= 0.5;  //fighting is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
        	        if(  (defender.type1.equals("steel")) ||(defender.type1.equals("dark")) || (defender.type1.equals("rock")) ||(defender.type1.equals("ice")) || (defender.type1.equals("normal")) ) {
        	    		
        	        	damage *= 2;  //fighting is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("steel")) ||(defender.type2.equals("dark")) || (defender.type2.equals("rock")) ||(defender.type2.equals("ice")) || (defender.type2.equals("normal")) ) {
        	    		
        	        	damage *= 2;  //fighting is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}

        	     
        	        
        	        if(defender.type1.equals("ghost") || defender.type2.equals("ghost")) {
        	        	
        	        	damage *= 0;
        	        	System.out.println("\n GHOST POKEMON ARE IMMUNE TO FIGHTING TYPE ATTACKS \n");
        	        	
        	        } 
        	      

        	      

        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
           	        
        	        
        	        if(attacker.ability.equals("ironfist")) {
        	        	
        	        	damage *= 1.3;
        	        	
        	        	System.out.println("Ironfist powered up the hit!!!");
        	        }
        	        
        	        
        	        
        	        
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	        soundeffects.drop();
        	    	System.out.println("The user's defense and attack fell....");
        	    	attacker.def *=0.5;
        	    	attacker.attack *= 0.5;
        	    	
        	    	
        	    	 
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;
        				soundeffects.statincrease();
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        			
        			
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    
        	    
        	    
 // 3/23/2021 (Types of moves sketched: Water, bug, steel,flying, normal, fighting, ice, dragon, fairy)
        	    
        	    // Start on: fire, electric, grass 
        	    
        	    //"flareblitz", "flamethrower", "firepunch", "firefang"
  	    
        	    
        	    
        	    
        	    
        	    
        	    /*
        	     * 
        	     * FIRE TYPE ATTACKS
        	     * 
        	     */
        	       
        	    
        	    
        	    //flamethrower
        	    public static double flamethrower(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.spa/ (double) defender.spdef)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)
        	    	
        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
       
        	    	
         	        if( (defender.type1.equals("fire")) ||  (defender.type1.equals("water")) || (defender.type1.equals("rock")) || (defender.type1.equals("dragon")) ) {
        	    		
        	    		damage *= 0.5;  //fire is resisted by these types
        	    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");soundeffects.resist(); 
        	    		
        	    	}
        	    	

        	        if( (defender.type2.equals("fire")) || (defender.type2.equals("water")) || (defender.type2.equals("rock")) || (defender.type2.equals("dragon")) ) {
        	    		
        	    		damage *= 0.5;  //fire is resisted by these types
        	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
        	    		
        	    	}
        	        
        	        
        	        
        	        if(   (defender.type1.equals("grass")) || (defender.type1.equals("ice")) || (defender.type1.equals("bug"))  || (defender.type1.equals("steel")) ) {
        	    		
        	    		damage *= 2;  //fire is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(   (defender.type2.equals("grass")) || (defender.type2.equals("ice")) || (defender.type2.equals("steel")) || (defender.type2.equals("bug"))) {
        	    		
        	    		damage *= 2;  //fire is super effective agaisnt these types
        	    		System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        		
        	        
        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        	        
        	        
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	    	
        	        
        	        
        	        int oof = rand.nextInt(100);
        	        
        	        
        	        	
 
               		 if( (defender.status.equals(" No status conditions")) && !(defender.type1.equals("fire")) && !(defender.type2.equals("fire")) ) {
               			
                      		if(oof < 10) {
                      		
                      		
                      			defender.status = "Burned";
                      			soundeffects.burned();
                      			if(defender.move1.attacktype.equals("ph")) {
                      				defender.move1.power *= 0.5;
                      			}
                      			if(defender.move2.attacktype.equals("ph")) {
                      				defender.move2.power *= 0.5;
                      			}
                      			if(defender.move3.attacktype.equals("ph")) {
                      				defender.move3.power *= 0.5;
                      			}
                      			if(defender.move4.attacktype.equals("ph")) {
                      				defender.move4.power *= 0.5;
                      			}
                      		 System.out.println("Your " + attacker.pokename + " has burned the opponent's " + defender.pokename + " with " + attack.movename + ". " + defender.pokename + "'s physical attacks power has been cut in half. ");
                      		}
                      		 
                      	
                    		
                    		
                 		
        	        }
        	        return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    
        	    
        	    //firepunch
        	    public static double firepunch(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if((defender.bounce == true) && !(attacker.ability.equals("noguard")) ) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
       
        	    	
         	        if( (defender.type1.equals("fire")) ||  (defender.type1.equals("water")) || (defender.type1.equals("rock")) || (defender.type1.equals("dragon")) ) {
        	    		
        	    		damage *= 0.5;  //fire is resisted by these types
        	    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");soundeffects.resist(); 
        	    		
        	    	}
        	    	

        	        if( (defender.type2.equals("fire")) || (defender.type2.equals("water")) || (defender.type2.equals("rock")) || (defender.type2.equals("dragon")) ) {
        	    		
        	    		damage *= 0.5;  //fire is resisted by these types
        	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
        	    		
        	    	}
        	        
        	        
        	        
        	        if(   (defender.type1.equals("grass")) || (defender.type1.equals("ice")) || (defender.type1.equals("bug"))  || (defender.type1.equals("steel")) ) {
        	    		
        	    		damage *= 2;  //fire is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(   (defender.type2.equals("grass")) || (defender.type2.equals("ice")) || (defender.type2.equals("steel")) || (defender.type2.equals("bug"))) {
        	    		
        	    		damage *= 2;  //fire is super effective agaisnt these types
        	    		System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	        
        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        	        
        	        
        		
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	    	
        	        
        	        
        	        int oof = rand.nextInt(100);
        	        
        	        
        	        	
        	        if(attacker.ability.equals("serenegrace")) {
        	        	
        	        	
        	        	 if( (defender.status.equals(" No status conditions")) && !(defender.type1.equals("fire")) && !(defender.type2.equals("fire")) ) {
                    			
                       		if(oof > 90) {
                       		
                       		
                       			defender.status = "Burned";
                       			soundeffects.burned();
                       			if(defender.move1.attacktype.equals("ph")) {
                       				defender.move1.power *= 0.5;
                       			}
                       			if(defender.move2.attacktype.equals("ph")) {
                       				defender.move2.power *= 0.5;
                       			}
                       			if(defender.move3.attacktype.equals("ph")) {
                       				defender.move3.power *= 0.5;
                       			}
                       			if(defender.move4.attacktype.equals("ph")) {
                       				defender.move4.power *= 0.5;
                       			}
                       		 System.out.println("Your " + attacker.pokename + " has burned the opponent's " + defender.pokename + " with " + attack.movename + " . " + defender.pokename + "'s physical attacks power has been cut in half. ");
                       		}
                       		 
                       	
                     		
                     		
                  		
         	        }
        	        	 
        	        	 
        	        	
        	        }

               		 if( (defender.status.equals(" No status conditions")) && !(defender.type1.equals("fire")) && !(defender.type2.equals("fire")) ) {
               			
                      		if(oof < 10) {
                      		
                      		
                      			defender.status = "Burned";
                      			soundeffects.burned();
                      			if(defender.move1.attacktype.equals("ph")) {
                      				defender.move1.power *= 0.5;
                      			}
                      			if(defender.move2.attacktype.equals("ph")) {
                      				defender.move2.power *= 0.5;
                      			}
                      			if(defender.move3.attacktype.equals("ph")) {
                      				defender.move3.power *= 0.5;
                      			}
                      			if(defender.move4.attacktype.equals("ph")) {
                      				defender.move4.power *= 0.5;
                      			}
                      		 System.out.println("Your " + attacker.pokename + " has burned the opponent's " + defender.pokename + " with " + attack.movename + " . " + defender.pokename + "'s physical attacks power has been cut in half. ");
                      		}
                      		 
                      	
                    		
                    		
                 		
        	        }
               		 
               		 
               		 
                 	
               	    
             		if(defender.ability.equals("stamina")) {
             			
             			defender.def *= 1.5;
             			soundeffects.statincrease();
             			System.out.println("The opposing pokemon's defense rose");
             		}
                 
                 	
        	        return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    
        	    
        	    //firefang
        	    public static double firefang(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
       
        	    	
         	        if( (defender.type1.equals("fire")) ||  (defender.type1.equals("water")) || (defender.type1.equals("rock")) || (defender.type1.equals("dragon")) ) {
        	    		
        	    		damage *= 0.5;  //fire is resisted by these types
        	    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");soundeffects.resist(); 
        	    		
        	    	}
        	    	

        	        if( (defender.type2.equals("fire")) || (defender.type2.equals("water")) || (defender.type2.equals("rock")) || (defender.type2.equals("dragon")) ) {
        	    		
        	    		damage *= 0.5;  //fire is resisted by these types
        	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
        	    		
        	    	}
        	        
        	        
        	        
        	        if(   (defender.type1.equals("grass")) || (defender.type1.equals("ice")) || (defender.type1.equals("bug"))  || (defender.type1.equals("steel")) ) {
        	    		
        	    		damage *= 2;  //fire is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(   (defender.type2.equals("grass")) || (defender.type2.equals("ice")) || (defender.type2.equals("steel")) || (defender.type2.equals("bug"))) {
        	    		
        	    		damage *= 2;  //fire is super effective agaisnt these types
        	    		System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	        
        	        
        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        	        
        		
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	    	
        	        
        	        
        	        
        	        int oof = rand.nextInt(100);
        	        
        	        int flinch = rand.nextInt(100);
        	        	

               		 if( (defender.status.equals(" No status conditions")) && !(defender.type1.equals("fire")) && !(defender.type2.equals("fire")) ) {
               			
                      		if(oof < 10) {
                      		
                      		
                      			defender.status = "Burned";
                      			soundeffects.burned();
                      			if(defender.move1.attacktype.equals("ph")) {
                      				defender.move1.power *= 0.5;
                      			}
                      			if(defender.move2.attacktype.equals("ph")) {
                      				defender.move2.power *= 0.5;
                      			}
                      			if(defender.move3.attacktype.equals("ph")) {
                      				defender.move3.power *= 0.5;
                      			}
                      			if(defender.move4.attacktype.equals("ph")) {
                      				defender.move4.power *= 0.5;
                      			}
                      		 System.out.println("Your " + attacker.pokename + " has burned the opponent's " + defender.pokename + " with " + attack.movename + " . " + defender.pokename + "'s physical attacks power has been cut in half. ");
                      		}
                      		 
                      	
                    		
                    		
                 		
        	        }
               		 
               		 
               		if( (flinch < 10) && (attacker.speed >= defender.speed) ) {
               			
               			defender.flinched = true;
               			System.out.println("The opposing pokemon flinched!!!");
               		}
               		
               	 
                	
               	    
            		if(defender.ability.equals("stamina")) {
            			
            			defender.def *= 1.5;
            			soundeffects.statincrease();
            			System.out.println("The opposing pokemon's defense rose");
            		}
                
                	
        	        return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
    
        	    
        	    
        	    //flareblitz
        	    public static double flareblitz(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
       
        	    	
         	        if( (defender.type1.equals("fire")) ||  (defender.type1.equals("water")) || (defender.type1.equals("rock")) || (defender.type1.equals("dragon")) ) {
        	    		
        	    		damage *= 0.5;  //fire is resisted by these types
        	    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); 
        	    		
        	    	}
        	    	

        	        if( (defender.type2.equals("fire")) || (defender.type2.equals("water")) || (defender.type2.equals("rock")) || (defender.type2.equals("dragon")) ) {
        	    		
        	    		damage *= 0.5;  //fire is resisted by these types
        	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
        	    		
        	    	}
        	        
        	        
        	        
        	        if(   (defender.type1.equals("grass")) || (defender.type1.equals("ice")) || (defender.type1.equals("bug"))  || (defender.type1.equals("steel")) ) {
        	    		
        	    		damage *= 2;  //fire is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(   (defender.type2.equals("grass")) || (defender.type2.equals("ice")) || (defender.type2.equals("steel")) || (defender.type2.equals("bug"))) {
        	    		
        	    		damage *= 2;  //fire is super effective agaisnt these types
        	    		System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        		
        	        
        	        
        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        	        
        	        
        	        
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	    	
        	        System.out.println("The user took damage as a result of flareblitz!! " + attacker.hp + " - " + (damage/3) + " = " + (attacker.hp - (damage/3)) );
        	    
        	        attacker.hp -=  (damage/3);
        	        
        	        
        	        
        	        int oof = rand.nextInt(100);
        	        
        	        
        	        	

               		 if( (defender.status.equals(" No status conditions")) && !(defender.type1.equals("fire")) && !(defender.type2.equals("fire")) ) {
               			
                      		if(oof < 10) {
                      		
                      		
                      			defender.status = "Burned";
                      			soundeffects.burned();
                      			if(defender.move1.attacktype.equals("ph")) {
                      				defender.move1.power *= 0.5;
                      			}
                      			if(defender.move2.attacktype.equals("ph")) {
                      				defender.move2.power *= 0.5;
                      			}
                      			if(defender.move3.attacktype.equals("ph")) {
                      				defender.move3.power *= 0.5;
                      			}
                      			if(defender.move4.attacktype.equals("ph")) {
                      				defender.move4.power *= 0.5;
                      			}
                      		 System.out.println("Your " + attacker.pokename + " has burned the opponent's " + defender.pokename + " with " + attack.movename + " . " + defender.pokename + "'s physical attacks power has been cut in half. ");
                      		}
                      		 
                      	
                    		
                    		
                 		
        	        }
               		 
               		 
               		 
                 	
               	    
             		if(defender.ability.equals("stamina")) {
             			
             			defender.def *= 1.5;
             			soundeffects.statincrease();
             			System.out.println("The opposing pokemon's defense rose");
             		}
                 
                 	
        	        return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
 
        	    
        	    
        	    
        	    
        	    // electric
        	    
        	    
        	    
        	    
        	    /*
        	     * 
        	     * ELECTRIC TYPE ATTACKS
        	     * 
        	     */
        	       
        	    //thunderbolt
        	    public static double thunderbolt(pokemon attacker, move attack, pokemon defender, String player) {


        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.spa/ (double) defender.spdef)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)
        	    	
        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
       
        	    	
        	        if(  (defender.type1.equals("electric")) || (defender.type1.equals("grass")) || (defender.type1.equals("dragon")) ) {
        	    		
        	    		damage *= 0.5;  //electric is resisted by these types
        	    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");    soundeffects.resist(); 
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("electric")) || (defender.type2.equals("grass")) || (defender.type2.equals("dragon")) ) {
        	    		
        	    		damage *= 0.5;  //electric is resisted by these types
        	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
        	    		
        	    	}

        	        if(   (defender.type1.equals("water")) || (defender.type1.equals("flying")) ) {
        	    		
        	    		damage *= 2;  //electric is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(   (defender.type2.equals("water")) || (defender.type2.equals("flying")) ) {
        	    		
        	    		damage *= 2;  //electric is super effective agaisnt these types
        	    		System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	        
        	        if(defender.type1.equals("ground") || defender.type2.equals("ground")) {
        	        	
        	        	damage *= 0;
        	        	System.out.println("\n GROUND POKEMON ARE IMMUNE TO ELECTRIC TYPE ATTACKS \n");
        	        	
        	        } 
         	  
        	        
        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        	        
        	        

    	        	if(defender.ability.equals("solidrock")){
    	        	 
    	        	damage = damage * 0.6;
    	        	 System.out.println("Solid rock reduced the damage of the attack");
    	        	 
    	        	 }
    	        	 
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	   
        	        
        	        
        	        
        	        int oof = rand.nextInt(100);
        	        
        	        
        	        	
                      	 if( (defender.status.equals(" No status conditions")) ) {
                    		
                      		 if( (attacker.ability.equals("serenegrace")) ) {
                      			 
                      			if(oof > 89) {
                               		
                           			System.out.println("The defending pokemon has become paralyzed (serene grace carried)!!!!! ");
                           			defender.status = "Paralyzed";
                           			soundeffects.paralyze();
                           		     defender.speed *= 0.5;
                           		
                           		}
                           		 
                      			 
                      			 
                      		 }
                      		 
                      		 
                      		 
                       		if(oof < 10) {
                       		
                       			System.out.println("The defending pokemon has become paralyzed!!!!! ");
                       			defender.status = "Paralyzed";
                       			soundeffects.paralyze();
                       		     defender.speed *= 0.5;
                       		
                       		}
                       		 
                   }
                      	 
                      	 
                      	 
                     
                     	
                      	 
        	        return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    //volttackle

					public static double volttackle(pokemon attacker, move attack, pokemon defender, String player) {


						if(defender.bounce == true) { // Checks if the opponent is in the air....

							System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
							return defender.hp; // misses if the opponent is in the air
						}


						double health = defender.hp; // health value of the pokemon being attacked


						double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi

						System.out.println("Your damage roll is " + roll);

						soundeffects.noo();

						double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


						if(attacker.ability.equals("toughclaws")){


							damage *= 1.3;
							System.out.println("Tough claws increased the damage of the attack!!");


						}

						// make sure to code for crits

						int crit = rand.nextInt(400);



						if (attack.critrate == 3.0)  {


							if (crit <= 27) {


								System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");

								if(attacker.ability.equals("sniper")) {

									damage *= 2.5;
									System.out.println("\n You got the sniper boost \n");
								}
								else {


									damage *= 1.5;

								}
							}

						}
						else if (attack.critrate == 6.0) {


							if (crit <= 55) {

								System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");

								if(attacker.ability.equals("sniper")) {

									damage *= 2.5;
									System.out.println("\n You got the sniper boost \n");
								}
								else {
									damage *= 1.5;
								}
							}

						}
						else {



							if (crit <= 101) {

								System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");

								if(attacker.ability.equals("sniper")) {

									damage *= 2.5;
									System.out.println("\n You got the sniper boost \n");
								}
								else {
									damage *= 1.5;
								}
							}



						}






						if(  (defender.type1.equals("electric")) || (defender.type1.equals("grass")) || (defender.type1.equals("dragon")) ) {

							damage *= 0.5;  //electric is resisted by these types
							System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");   soundeffects.resist();

						}


						if(  (defender.type2.equals("electric")) || (defender.type2.equals("grass")) || (defender.type2.equals("dragon")) ) {

							damage *= 0.5;  //electric is resisted by these types
							System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists

						}

						if(   (defender.type1.equals("water")) || (defender.type1.equals("flying")) ) {

							damage *= 2;  //electric is super effective against these types
							System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting

						}


						if(   (defender.type2.equals("water")) || (defender.type2.equals("flying")) ) {

							damage *= 2;  //electric is super effective agaisnt these types
							System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting

						}

						if(defender.type1.equals("ground") || defender.type2.equals("ground")) {

							damage *= 0;
							System.out.println("\n GROUND POKEMON ARE IMMUNE TO ELECTRIC TYPE ATTACKS \n");

						}




						if( (defender.ability.equals("multiscale") ) ){

							if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");

								damage = damage/2;

							}
						}



						damage = Math.round(damage);

						System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );


						health =  health - damage;


						System.out.println("The user took damage as a result of volttackle!! " + attacker.hp + " - " + (damage/3) + " = " + (attacker.hp - (damage/3)) );

						attacker.hp -=  (damage/3);



						int oof = rand.nextInt(100);





						if( (defender.status.equals(" No status conditions")) ) {


							if(oof < 10) {



								defender.status = "Paralyzed";
								defender.speed *= 0.5;
								soundeffects.paralyze();
								soundeffects.drop();
								System.out.println("Your " + attacker.pokename + " has paralyzed the opponent's " + defender.pokename + " with "  + attack.movename + " . " + defender.pokename + "'s speed fell. ");







							}





						}





						if(defender.ability.equals("stamina")) {

							defender.def *= 1.5;
							soundeffects.statincrease();
							System.out.println("The opposing pokemon's defense rose");
						}


						return Math.round(health);



					}


	//THUNDERPUNCH
        	    public static double thunderpunch(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if((defender.bounce == true) && !(attacker.ability.equals("noguard")) ) {// Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
       
        	    	
        	        if(  (defender.type1.equals("electric")) || (defender.type1.equals("grass")) || (defender.type1.equals("dragon")) ) {
        	    		
        	    		damage *= 0.5;  //electric is resisted by these types
        	    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");   soundeffects.resist(); 
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("electric")) || (defender.type2.equals("grass")) || (defender.type2.equals("dragon")) ) {
        	    		
        	    		damage *= 0.5;  //electric is resisted by these types
        	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
        	    		
        	    	}

        	        if(   (defender.type1.equals("water")) || (defender.type1.equals("flying")) ) {
        	    		
        	    		damage *= 2;  //electric is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(   (defender.type2.equals("water")) || (defender.type2.equals("flying")) ) {
        	    		
        	    		damage *= 2;  //electric is super effective agaisnt these types
        	    		System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	        
        	        if(defender.type1.equals("ground") || defender.type2.equals("ground")) {
        	        	
        	        	damage *= 0;
        	        	System.out.println("\n GROUND POKEMON ARE IMMUNE TO ELECTRIC TYPE ATTACKS \n");
        	        	
        	        } 
        	    	
        	    	
        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        		
        	        
        	        if(attacker.ability.equals("ironfist")) {
        	        	
        	        	damage *= 1.3;
        	        	
        	        	System.out.println("Ironfist powered up the hit!!!");
        	        }
        	        
        	        

    	        	if(defender.ability.equals("solidrock")){
    	        	 
    	        	damage = damage * 0.6;
    	        	 System.out.println("Solid rock reduced the damage of the attack");
    	        	 
    	        	 }
    	        	 
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	    	
        	        
        	        
        	        
        	        int oof = rand.nextInt(100);
        	        
        	        
        	        	

               		 if( (defender.status.equals(" No status conditions")) ) {
               			
                    			
                       		if(oof < 10) {

								defender.status = "Paralyzed";
								defender.speed *= 0.5;
								soundeffects.paralyze();
								soundeffects.drop();
								System.out.println("Your " + attacker.pokename + " has paralyzed the opponent's " + defender.pokename + " with "  + attack.movename + " . " + defender.pokename + "'s speed fell. ");








							}
                      		 
                      	
                    		
                    		
                 		
        	        }
               		 
               		 
                 	
               	    
             		if(defender.ability.equals("stamina")) {
             			
             			defender.def *= 1.5;
             			soundeffects.statincrease();
             			System.out.println("The opposing pokemon's defense rose");
             		}
                 
                 	
        	        return Math.round(health);
        	    	
        	    	
        	    	
        	    }


				//PLASMAFISTS


					public static double plasmafists(pokemon attacker, move attack, pokemon defender, String player) {


						if((defender.bounce == true) && !(attacker.ability.equals("noguard")) ) {// Checks if the opponent is in the air....

							System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
							return defender.hp; // misses if the opponent is in the air
						}


						double health = defender.hp; // health value of the pokemon being attacked


						double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi

						System.out.println("Your damage roll is " + roll);

						soundeffects.noo();

						double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


						if(attacker.ability.equals("toughclaws")){


							damage *= 1.3;
							System.out.println("Tough claws increased the damage of the attack!!");


						}

						// make sure to code for crits

						int crit = rand.nextInt(400);



						if (attack.critrate == 3.0)  {


							if (crit <= 27) {


								System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");

								if(attacker.ability.equals("sniper")) {

									damage *= 2.5;
									System.out.println("\n You got the sniper boost \n");
								}
								else {


									damage *= 1.5;

								}
							}

						}
						else if (attack.critrate == 6.0) {


							if (crit <= 55) {

								System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");

								if(attacker.ability.equals("sniper")) {

									damage *= 2.5;
									System.out.println("\n You got the sniper boost \n");
								}
								else {
									damage *= 1.5;
								}
							}

						}
						else {



							if (crit <= 101) {

								System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");

								if(attacker.ability.equals("sniper")) {

									damage *= 2.5;
									System.out.println("\n You got the sniper boost \n");
								}
								else {
									damage *= 1.5;
								}
							}



						}



						if(  (defender.type1.equals("electric")) || (defender.type1.equals("grass")) || (defender.type1.equals("dragon")) ) {

							damage *= 0.5;  //electric is resisted by these types
							System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");   soundeffects.resist();

						}


						if(  (defender.type2.equals("electric")) || (defender.type2.equals("grass")) || (defender.type2.equals("dragon")) ) {

							damage *= 0.5;  //electric is resisted by these types
							System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists

						}

						if(   (defender.type1.equals("water")) || (defender.type1.equals("flying")) ) {

							damage *= 2;  //electric is super effective against these types
							System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting

						}


						if(   (defender.type2.equals("water")) || (defender.type2.equals("flying")) ) {

							damage *= 2;  //electric is super effective agaisnt these types
							System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting

						}

						if(defender.type1.equals("ground") || defender.type2.equals("ground")) {

							damage *= 0;
							System.out.println("\n GROUND POKEMON ARE IMMUNE TO ELECTRIC TYPE ATTACKS \n");

						}



						if( (defender.ability.equals("multiscale") ) ){

							if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");

								damage = damage/2;

							}
						}


						if(attacker.ability.equals("ironfist")) {

							damage *= 1.3;

							System.out.println("Ironfist powered up the hit!!!");
						}



						if(defender.ability.equals("solidrock")){

							damage = damage * 0.6;
							System.out.println("Solid rock reduced the damage of the attack");

						}

						damage = Math.round(damage);

						System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );


						health =  health - damage;






						if(defender.ability.equals("stamina")) {

							defender.def *= 1.5;
							soundeffects.statincrease();
							System.out.println("The opposing pokemon's defense rose");
						}


						return Math.round(health);



					}


	//THUNDERFANG
        	    
        	    public static double thunderfang(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
        	    	
        	    	
        	    	
        	        if(  (defender.type1.equals("electric")) || (defender.type1.equals("grass")) || (defender.type1.equals("dragon")) ) {
        	    		
        	    		damage *= 0.5;  //electric is resisted by these types
        	    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");      soundeffects.resist(); 
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("electric")) || (defender.type2.equals("grass")) || (defender.type2.equals("dragon")) ) {
        	    		
        	    		damage *= 0.5;  //electric is resisted by these types
        	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
        	    		
        	    	}

        	        if(   (defender.type1.equals("water")) || (defender.type1.equals("flying")) ) {
        	    		
        	    		damage *= 2;  //electric is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(   (defender.type2.equals("water")) || (defender.type2.equals("flying")) ) {
        	    		
        	    		damage *= 2;  //electric is super effective agaisnt these types
        	    		System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	        
        	        if(defender.type1.equals("ground") || defender.type2.equals("ground")) {
        	        	
        	        	damage *= 0;
        	        	System.out.println("\n GROUND POKEMON ARE IMMUNE TO ELECTRIC TYPE ATTACKS \n");
        	        	
        	        } 
       
        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        	       
        	        

    	        	if(defender.ability.equals("solidrock")){
    	        	 
    	        	damage = damage * 0.6;
    	        	 System.out.println("Solid rock reduced the damage of the attack");
    	        	 
    	        	 }
    	        	 
    	        	
    	        	
    	        	
    	        	
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	    	
        	        
        	        
        	        
        	        int oof = rand.nextInt(100);
        	        
        	        int flinch = rand.nextInt(100);
        	        	

               		 if( (defender.status.equals(" No status conditions")) ) {
           	
                    			
                       		if( (oof < 10) && (attacker.speed >= defender.speed)){

								defender.status = "Paralyzed";
								defender.speed *= 0.5;
								soundeffects.paralyze();
								soundeffects.drop();
								System.out.println("Your " + attacker.pokename + " has paralyzed the opponent's " + defender.pokename + " with "  + attack.movename + " . " + defender.pokename + "'s speed fell. ");


							}
                       		 
                 		
                 		
        	        }
               		 
               		 
               		if( (flinch < 10)&& (attacker.speed >= defender.speed)) {
               			
               			defender.flinched = true;
               			System.out.println("The opposing pokemon flinched!!!");
               		}
               		
               	 
                	
               	    
            		if(defender.ability.equals("stamina")) {
            			
            			defender.def *= 1.5;
            			soundeffects.statincrease();
            			System.out.println("The opposing pokemon's defense rose");
            		}
                
                	
        	        return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
    
        	    
        	    //WILDCHARGE
        	    
        	    public static double wildcharge(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
       
        	    	
        	    	
        	    	
        	    	
        	    	
        	        if(  (defender.type1.equals("electric")) || (defender.type1.equals("grass")) || (defender.type1.equals("dragon")) ) {
        	    		
        	    		damage *= 0.5;  //electric is resisted by these types
        	    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");    soundeffects.resist(); 
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("electric")) || (defender.type2.equals("grass")) || (defender.type2.equals("dragon")) ) {
        	    		
        	    		damage *= 0.5;  //electric is resisted by these types
        	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
        	    		
        	    	}

        	        if(   (defender.type1.equals("water")) || (defender.type1.equals("flying")) ) {
        	    		
        	    		damage *= 2;  //electric is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(   (defender.type2.equals("water")) || (defender.type2.equals("flying")) ) {
        	    		
        	    		damage *= 2;  //electric is super effective agaisnt these types
        	    		System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	        
        	        if(defender.type1.equals("ground") || defender.type2.equals("ground")) {
        	        	
        	        	damage *= 0;
        	        	System.out.println("\n GROUND POKEMON ARE IMMUNE TO ELECTRIC TYPE ATTACKS \n");
        	        	
        	        } 
        	        
        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        	        
        	        

    	        	if(defender.ability.equals("solidrock")){
    	        	 
    	        	damage = damage * 0.6;
    	        	 System.out.println("Solid rock reduced the damage of the attack");
    	        	 
    	        	 }
    	        	 
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	    	
        	        System.out.println("The user took damage as a result of wildcharge!! " + attacker.hp + " - " + (damage/3) + " = " + (attacker.hp - (damage/3)) );
        	    
        	        attacker.hp -=  (damage/3);
        	        
        	        
        	        
        	        int oof = rand.nextInt(100);
        	        
        	        
        	        	

               		 if( (defender.status.equals(" No status conditions")) ) {
               			
                      		if(oof < 10) {

								defender.status = "Paralyzed";
								defender.speed *= 0.5;
								soundeffects.paralyze();
								soundeffects.drop();
								System.out.println("Your " + attacker.pokename + " has paralyzed the opponent's " + defender.pokename + " with "  + attack.movename + " . " + defender.pokename + "'s speed fell. ");


							}
                      		 
                      	
                    		
                    		
                 		
        	        }
               		 
               		 
                 	
               	    
             		if(defender.ability.equals("stamina")) {
             			
             			defender.def *= 1.5;
             			soundeffects.statincrease();
             			System.out.println("The opposing pokemon's defense rose");
             		}
                 
                 	
        	        return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
    // 3/23/2021 (Types of moves sketched: Water, bug, steel,flying, normal, ice, dragon, fairy)
        	    
        	    // Start on: fire, electric, grass, fighting
 // grass
        	    
        	    /*
        	     * 
        	     * GRASS TYPE ATTACKS
        	     * 
        	     */
        	       
        	    //leafblade
        	    public static double leafblade(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
      
        	        
        	        
        	        
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
        	  
        	    	
        	        if(  (defender.type1.equals("poison")) ||  (defender.type1.equals("steel")) ||  (defender.type1.equals("flying")) ||  (defender.type1.equals("fire")) ||  (defender.type1.equals("bug")) || (defender.type1.equals("grass")) || (defender.type1.equals("dragon")) ) {
        	    		
        	    		damage *= 0.5;  //grass is resisted by these types
        	    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");   soundeffects.resist(); 
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("fire")) || (defender.type2.equals("poison")) ||  (defender.type2.equals("steel")) ||  (defender.type2.equals("flying")) || (defender.type2.equals("bug")) || (defender.type2.equals("grass")) || (defender.type2.equals("dragon")) ) {
        	    		
        	    		damage *= 0.5;  //grass is resisted by these types
        	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
        	    		
        	    	}
        	        
        	        
        	        
        	        if(   (defender.type1.equals("water")) || (defender.type1.equals("rock"))  || (defender.type1.equals("ground")) ) {
        	    		
        	    		damage *= 2;  //grass is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(   (defender.type2.equals("water")) || (defender.type2.equals("rock")) || (defender.type2.equals("ground"))) {
        	    		
        	    		damage *= 2;  //grass is super effective agaisnt these types
        	    		System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	
    	    	
        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        		
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	        
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;
        				soundeffects.statincrease();
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
 
        	    
        	    
        	    

        	    //energyball
        	    public static double energyball(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.spa/ (double) defender.spdef)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)
        	    	
        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	
        	    	
        	    	
        	    	
        	        if(  (defender.type1.equals("poison")) ||  (defender.type1.equals("steel")) ||  (defender.type1.equals("flying")) ||  (defender.type1.equals("fire")) ||  (defender.type1.equals("bug")) || (defender.type1.equals("grass")) || (defender.type1.equals("dragon")) ) {
        	    		
        	    		damage *= 0.5;  //grass is resisted by these types
        	    		System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n "); soundeffects.resist(); 
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("fire")) || (defender.type2.equals("poison")) ||  (defender.type2.equals("steel")) ||  (defender.type2.equals("flying")) || (defender.type2.equals("bug")) || (defender.type2.equals("grass")) || (defender.type2.equals("dragon")) ) {
        	    		
        	    		damage *= 0.5;  //grass is resisted by these types
        	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
        	    		
        	    	}
        	        
        	        
        	        
        	        if(   (defender.type1.equals("water")) || (defender.type1.equals("rock"))  || (defender.type1.equals("ground")) ) {
        	    		
        	    		damage *= 2;  //grass is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(   (defender.type2.equals("water")) || (defender.type2.equals("rock")) || (defender.type2.equals("ground"))) {
        	    		
        	    		damage *= 2;  //grass is super effective agaisnt these types
        	    		System.out.println("\n  IT'S SUPER EFFECTIVE !!!! \n");  	soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	
        		
        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        	        
        	        
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	    	
        	        
        	        
        	        int oof = rand.nextInt(100);
        	        
        	        if( !(defender.ability.equals("clearbody")) ){
        	        	
        	        	  if(attacker.ability.equals("serenegrace")) {
              	        	if(oof > 90) {
              	        		
              	      
              	        		soundeffects.drop();
                 		 			System.out.println("The opponent's special defense fell(Serene grace carried).....");
                 		 		    defender.spdef *= 0.5;
                 		 		
                 		 		}
                        		 
              	        	
              	        	
              	        }

                     		 		if(oof < 10) {
                     		 			soundeffects.drop();
                     		 			System.out.println("The opponent's special defense fell.....");
                     		 		    defender.spdef *= 0.5;
                     		 		
                     		 		}
                            		 
        	        	
        	        }
        	        
        	      
                      	
                    		
                    		
                 		
        	        
        	        return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    
        	    
          	    
        	    // 3/23/2021 (Types of moves sketched: Water, bug, steel,flying, normal, ice, dragon,fire, electric, grass, fighting, fairy)
        	        	  
        	    //Start poison, dark, psychic, ghost, ground, rock
        	    
        	    
        	    /*
        	     * 
        	     * POISON TYPE ATTACKS
        	     * 
        	     */
        	      //sludgebomb
        	    public static double sludgebomb(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.spa/ (double) defender.spdef)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)
        	    	
        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
      
        	        
        	        
        	        
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
      
           	        
        	    	
    	    		if(   (defender.type1.equals("poison")) ||  (defender.type1.equals("ground")) ||  (defender.type1.equals("ghost")) || (defender.type1.equals("rock")) ) {
           	    		
           	        	damage *= 0.5;  //poison is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	    	

           	        if(   (defender.type2.equals("poison")) || (defender.type2.equals("ground")) || (defender.type2.equals("ghost")) || (defender.type2.equals("rock")) ) {
           	    		
           	        	damage *= 0.5;  //poison is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
        	        if(   (defender.type1.equals("grass")) || (defender.type1.equals("fairy")) ) {
        	    		
        	        	damage *= 2;  //poison is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("grass")) || (defender.type2.equals("fairy")) ) {
        	    		
        	        	damage *= 2;  //poison is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}

        	        if(defender.type1.equals("steel") || defender.type2.equals("steel")) {
        	        	
        	        	damage *= 0;
        	        	System.out.println("\n STEEL POKEMON ARE IMMUNE TO POISON TYPE ATTACKS \n");
        	        	
        	        } 
        	        //
        		
        	        
        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        	        
        	        
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	    	
      
        	        
        	        int poison = rand.nextInt(100);
        	        
        	        
        	        	if(defender.status.equals(" No status conditions")) {
        	        		

               		 		if(poison < 31) {
                      		
               		 			System.out.println("The opponent became poisoned due to the sludgebomb.....");
               		 		    defender.status.equals("Poisoned");
               		 		soundeffects.poisoned();
               		 		}
               		 		
               		 		
        	        		
        	        	}

               		 		
               		 		
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }

        	    //crosspoison
        	    public static double crosspoison(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
      
        	        
        	        
        	        
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
      
           	        
        	    	
    	    		if(   (defender.type1.equals("poison")) ||  (defender.type1.equals("ground")) ||  (defender.type1.equals("ghost")) || (defender.type1.equals("rock")) ) {
           	    		
           	        	damage *= 0.5;  //poison is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	    	

           	        if(   (defender.type2.equals("poison")) || (defender.type2.equals("ground")) || (defender.type2.equals("ghost")) || (defender.type2.equals("rock")) ) {
           	    		
           	        	damage *= 0.5;  //poison is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
        	        if(   (defender.type1.equals("grass")) || (defender.type1.equals("fairy")) ) {
        	    		
        	        	damage *= 2;  //poison is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("grass")) || (defender.type2.equals("fairy")) ) {
        	    		
        	        	damage *= 2;  //poison is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}

        	        if(defender.type1.equals("steel") || defender.type2.equals("steel")) {
        	        	
        	        	damage *= 0;
        	        	System.out.println("\n STEEL POKEMON ARE IMMUNE TO POISON TYPE ATTACKS \n");
        	        	
        	        } 
        	        //
        		
        	        
        	        
        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        	        
        	        
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	    	
      
        	        
        	        int poison = rand.nextInt(100);
        	        
        	        
        	        	if(defender.status.equals(" No status conditions")) {
        	        		

               		 		if(poison < 10) {
                      		
               		 			System.out.println("The opponent became poisoned.....");
               		 		    defender.status.equals("Poisoned");
               		 		
               		 		soundeffects.poisoned();
               		 		}
               		 		
               		 		
        	        		
        	        	}

               		 		
        	        	 
        	        	
        	            
        	    		if(defender.ability.equals("stamina")) {
        	    			
        	    			defender.def *= 1.5;
        	    			soundeffects.statincrease();
        	    			System.out.println("The opposing pokemon's defense rose");
        	    		}
        	        
        	        	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
 
        	    
    
        	    //poisonjab
        	    
        	    public static double poisonjab(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
      
        	        
        	        
        	        
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
      
           	        
        	    	
    	    		if(   (defender.type1.equals("poison")) ||  (defender.type1.equals("ground")) ||  (defender.type1.equals("ghost")) || (defender.type1.equals("rock")) ) {
           	    		
           	        	damage *= 0.5;  //poison is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	    	

           	        if(   (defender.type2.equals("poison")) || (defender.type2.equals("ground")) || (defender.type2.equals("ghost")) || (defender.type2.equals("rock")) ) {
           	    		
           	        	damage *= 0.5;  //poison is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
        	        if(   (defender.type1.equals("grass")) || (defender.type1.equals("fairy")) ) {
        	    		
        	        	damage *= 2;  //poison is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("grass")) || (defender.type2.equals("fairy")) ) {
        	    		
        	        	damage *= 2;  //poison is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}

        	        if(defender.type1.equals("steel") || defender.type2.equals("steel")) {
        	        	
        	        	damage *= 0;
        	        	System.out.println("\n STEEL POKEMON ARE IMMUNE TO POISON TYPE ATTACKS \n");
        	        	
        	        } 
        	        //
        	        
        	        
        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        	        
        	        
        		
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	    	
      
        	        
        	        int poison = rand.nextInt(100);
        	        
        	        
        	        	if(defender.status.equals(" No status conditions")) {
        	        		

               		 		if(poison < 31) {
                      		
               		 			System.out.println("The opponent became poisoned due to the jab.....");
               		 		    defender.status.equals("Poisoned");
               		 		soundeffects.poisoned();
               		 		}
               		 		
               		 		
        	        		
        	        	}

        	        	 
        	        	
        	            
        	    		if(defender.ability.equals("stamina")) {
        	    			
        	    			defender.def *= 1.5;
        	    			soundeffects.statincrease();
        	    			System.out.println("The opposing pokemon's defense rose");
        	    		}
        	        
        	        		
               		 		
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }



				//gunkshot


						public static double gunkshot(pokemon attacker, move attack, pokemon defender, String player) {


							if(defender.bounce == true) { // Checks if the opponent is in the air....

								System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
								return defender.hp; // misses if the opponent is in the air
							}


							double health = defender.hp; // health value of the pokemon being attacked


							double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi

							System.out.println("Your damage roll is " + roll);


							soundeffects.noo();

							double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


							if(attacker.ability.equals("toughclaws")){


								damage *= 1.3;
								System.out.println("Tough claws increased the damage of the attack!!");


							}

							// make sure to code for crits

							int crit = rand.nextInt(400);




							if (attack.critrate == 3.0)  {


								if (crit <= 27) {


									System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");

									if(attacker.ability.equals("sniper")) {

										damage *= 2.5;
										System.out.println("\n You got the sniper boost \n");
									}
									else {


										damage *= 1.5;

									}
								}

							}
							else if (attack.critrate == 6.0) {


								if (crit <= 55) {

									System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");

									if(attacker.ability.equals("sniper")) {

										damage *= 2.5;
										System.out.println("\n You got the sniper boost \n");
									}
									else {
										damage *= 1.5;
									}
								}

							}
							else {



								if (crit <= 101) {

									System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");

									if(attacker.ability.equals("sniper")) {

										damage *= 2.5;
										System.out.println("\n You got the sniper boost \n");
									}
									else {
										damage *= 1.5;
									}
								}



							}



							if(   (defender.type1.equals("poison")) ||  (defender.type1.equals("ground")) ||  (defender.type1.equals("ghost")) || (defender.type1.equals("rock")) ) {

								damage *= 0.5;  //poison is resisted by these types
								System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists

							}


							if(   (defender.type2.equals("poison")) || (defender.type2.equals("ground")) || (defender.type2.equals("ghost")) || (defender.type2.equals("rock")) ) {

								damage *= 0.5;  //poison is resisted by these types
								System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists

							}


							if(   (defender.type1.equals("grass")) || (defender.type1.equals("fairy")) ) {

								damage *= 2;  //poison is super effective against these types
								System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting

							}


							if(  (defender.type2.equals("grass")) || (defender.type2.equals("fairy")) ) {

								damage *= 2;  //poison is super effective against these types
								System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting

							}

							if(defender.type1.equals("steel") || defender.type2.equals("steel")) {

								damage *= 0;
								System.out.println("\n STEEL POKEMON ARE IMMUNE TO POISON TYPE ATTACKS \n");

							}
							//



							if( (defender.ability.equals("multiscale") ) ){

								if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");

									damage = damage/2;

								}
							}



							damage = Math.round(damage);

							System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );


							health =  health - damage;




							int poison = rand.nextInt(100);


							if(defender.status.equals(" No status conditions")) {


								if(poison < 31) {

									System.out.println("The opponent became poisoned due to the jab.....");
									defender.status.equals("Poisoned");
									soundeffects.poisoned();
								}



							}




							if(defender.ability.equals("stamina")) {

								defender.def *= 1.5;
								soundeffects.statincrease();
								System.out.println("The opposing pokemon's defense rose");
							}



							return Math.round(health);



						}


	// 3/23/2021 (Types of moves sketched: Water, bug, steel,flying, normal, ice, dragon,fire, electric, grass, fighting, fairy)
        	        	  
        	    //Start poison, dark, psychic, ghost, ground, rock       	    
        	    
        	    
        	    
        	    
        	 // 3/24/2021 (Types of moves sketched: Water, bug, steel,flying, normal, ice, dragon,fire, electric, grass,poison,fighting, fairy)
	        	  
        	    //Start dark, psychic, ghost, ground, rock       	
        	    
        	    
 	    
        	    
        	    /*
        	     * 
        	     * DARK TYPE ATTACKS
        	     * 
        	     */
        	       
        	    
        	    //crunch
        	    public static double crunch(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
      
        	        
        	        
        	        
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
      
 
        	    	
        	    	
        	    	
    	    		
    	    		if(   (defender.type1.equals("fighting")) || (defender.type1.equals("fairy")) ||  (defender.type1.equals("dark"))   ) {
           	    		
           	        	damage *= 0.5;  //dark is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	    	

           	        if(   (defender.type2.equals("fighting")) || (defender.type2.equals("fairy")) ||  (defender.type2.equals("dark"))  ) {
           	    		
           	        	damage *= 0.5;  //dark is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
        	        if( (defender.type1.equals("ghost")) || (defender.type1.equals("psychic")) ) {
        	    		
        	        	damage *= 2;  //dark is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("ghost")) || (defender.type2.equals("psychic")) ) {
        	    		
        	        	damage *= 2;  //dark is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}

        	     
        	      

        	    	
        	        //
        	        
        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        	        
        	        
        		
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	    	
        	        if( !(attacker.ability.equals("sheerforce")) ) {
        	        	
        	        	 int drop = rand.nextInt(100);
             	        
             	        if(  !(defender.ability.equals("clearbody"))   ) {
             	        	
             	        	  if(drop < 30) {
             	        		 soundeffects.drop();
                   	        	System.out.println("The opponent's defense fell....");
                   	        	
                   	        	defender.def *= 0.5;
                   	        	
                   	        }
                 
             	        }
        	        	
        	        }
        	        else {
        	        	
        	        	
        	        	damage *= 1.3;
        	        	System.out.println("Sheerforce powered up the hit...");
        	        }
        	       
        	      
        	        
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;
        				soundeffects.statincrease();
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
 
        	    
        	    
        	    //darkpulse
        	    public static double darkpulse(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.spa/ (double) defender.spdef)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)
        	    	
        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
      
        	        
        	        
        	        
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
      
 
        	    	
        	    	
        	    	
    	    		
    	    		if(   (defender.type1.equals("fighting")) || (defender.type1.equals("fairy")) ||  (defender.type1.equals("dark"))   ) {
           	    		
           	        	damage *= 0.5;  //dark is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	    	

           	        if(   (defender.type2.equals("fighting")) || (defender.type2.equals("fairy")) ||  (defender.type2.equals("dark"))  ) {
           	    		
           	        	damage *= 0.5;  //dark is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
        	        if( (defender.type1.equals("ghost")) || (defender.type1.equals("psychic")) ) {
        	    		
        	        	damage *= 2;  //dark is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("ghost")) || (defender.type2.equals("psychic")) ) {
        	    		
        	        	damage *= 2;  //dark is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}

        	     
        	      

        	    	
        	        //
        		
        	        
        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        	        
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	    	int flinch = rand.nextInt(100);
        	    	
        	    	if( (flinch < 20)&& (attacker.speed >= defender.speed)) {
        	    		
        	    		
        	    	defender.flinched = true;
        	    	}
      
        	    
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
 
        	    
        	    
        	    
        	    
        	    //suckerpunch
        	    
        	    public static double suckerpunch(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
      
        	        
        	        
        	        
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
      
 
        	    	
        	    	
        	    	
    	    		
    	    		if(   (defender.type1.equals("fighting")) || (defender.type1.equals("fairy")) ||  (defender.type1.equals("dark"))   ) {
           	    		
           	        	damage *= 0.5;  //dark is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	    	

           	        if(   (defender.type2.equals("fighting")) || (defender.type2.equals("fairy")) ||  (defender.type2.equals("dark"))  ) {
           	    		
           	        	damage *= 0.5;  //dark is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
        	        if( (defender.type1.equals("ghost")) || (defender.type1.equals("psychic")) ) {
        	    		
        	        	damage *= 2;  //dark is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("ghost")) || (defender.type2.equals("psychic")) ) {
        	    		
        	        	damage *= 2;  //dark is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}

        	     
        	      

        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        	        //
        		
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	    	
        	        
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;
        				soundeffects.statincrease();
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        	    
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
 
        	    
        	    
        	    
        	    //foulplay
 	    
        	    
        	    public static double foulplay(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (defender.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)
        	    	
        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
      
        	        
        	        
        	        
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
      
 
        	    	
        	    	
        	    	
    	    		
    	    		if(   (defender.type1.equals("fighting")) || (defender.type1.equals("fairy")) ||  (defender.type1.equals("dark"))   ) {
           	    		
           	        	damage *= 0.5;  //dark is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	    	

           	        if(   (defender.type2.equals("fighting")) || (defender.type2.equals("fairy")) ||  (defender.type2.equals("dark"))  ) {
           	    		
           	        	damage *= 0.5;  //dark is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
        	        if( (defender.type1.equals("ghost")) || (defender.type1.equals("psychic")) ) {
        	    		
        	        	damage *= 2;  //dark is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("ghost")) || (defender.type2.equals("psychic")) ) {
        	    		
        	        	damage *= 2;  //dark is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}

        	     
        	      

        	    	
        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        	        
        	        
        	        //
        		
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	    	
      
        	        
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;
        				soundeffects.statincrease();
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
 
        	    
        	    //nightslash
        	    
        	    public static double nightslash(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
      
        	        
        	        
        	        
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
      
 
        	    	
        	    	
        	    	
    	    		
    	    		if(   (defender.type1.equals("fighting")) || (defender.type1.equals("fairy")) ||  (defender.type1.equals("dark"))   ) {
           	    		
           	        	damage *= 0.5;  //dark is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	    	

           	        if(   (defender.type2.equals("fighting")) || (defender.type2.equals("fairy")) ||  (defender.type2.equals("dark"))  ) {
           	    		
           	        	damage *= 0.5;  //dark is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
        	        if( (defender.type1.equals("ghost")) || (defender.type1.equals("psychic")) ) {
        	    		
        	        	damage *= 2;  //dark is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("ghost")) || (defender.type2.equals("psychic")) ) {
        	    		
        	        	damage *= 2;  //dark is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}

        	     
        	      
        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        	    	
        	        //
        	        
        	    	 
        	      	 if(attacker.ability.equals("technician")) {
        	      		 
        	      		 
        	      		 damage *= 1.5;
        	      		 System.out.println("Technician powered up the hit!!");
        	      	 }
        		
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	    	
      
        	        
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;
        				soundeffects.statincrease();
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
 
        	    
        	    
        	    
        	    
           	 // 3/24/2021 (Types of moves sketched: Water, bug, dark,steel,flying, normal, ice, dragon,fire, electric, grass,poison,fighting, fairy)
   	        	  
           	    //Start  psychic, ghost, ground, rock 
        	    
        	    
        	    
        	    
        	    
        	    
        	    /*
        	     * 
        	     * PSYCHIC TYPE ATTACKS
        	     * 
        	     */
        	       
        	    //psychic
        	    public static double psychic(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.spa/ (double) defender.spdef)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)
        	    	
        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
       
        	    	
    	    		
    	    		if(   (defender.type1.equals("steel")) || (defender.type1.equals("psychic"))  ) {
           	    		
           	        	damage *= 0.5;  //psychic is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	    	

           	        if(   (defender.type2.equals("steel")) || (defender.type2.equals("psychic")) ) {
           	    		
           	        	damage *= 0.5;  //psychic is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
        	        if( (defender.type1.equals("fighting")) || (defender.type1.equals("poison")) ) {
        	    		
        	        	damage *= 2;  //psychic is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("fighting")) || (defender.type2.equals("poison")) ) {
        	    		
        	        	damage *= 2;  //psychic is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}

        	        if(defender.type1.equals("dark") || defender.type2.equals("dark")) {
        	        	
        	        	damage *= 0;
        	        	System.out.println("\n DARK POKEMON ARE IMMUNE TO PSYCHIC TYPE ATTACKS \n");
        	        	
        	        } 
        	        //
        	    	
        	    	
        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        	        
        	        
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	   
        	        
        	        
        	        
        	        int oof = rand.nextInt(100);
        	        
        	        
        	        	if( !(defender.ability.equals("clearbody"))   ) {
        	        		
        	        		
        	        		
        	        			if(attacker.ability.equals("serenegrace")) {
        	        				
                	        		if(oof > 90) {
                                   		
                               			defender.spdef *= 0.5;
                               		   System.out.println("The opponent's special defense decreased, serene grace elped the opponent.... ");
                               		
                               		}
                               		 
        	        				
        	        				
        	        			}
        	        			
        	        			
        	        		if(oof < 10) {
                           		
                       			defender.spdef *= 0.5;
                       		   System.out.println("The opponent's special defense decreased.... ");
                       		
                       		}
                       		 
        	        		
        	        	}
                      			
                       	
                       	
                     		
                     		
                  		
         	        
                      	
                    		
                    		
                 		
        	        
        	        return Math.round(health);
        	    	
        	    	
        	    	
        	    }



					public static double extrasensory(pokemon attacker, move attack, pokemon defender, String player) {


						if(defender.bounce == true) { // Checks if the opponent is in the air....

							System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
							return defender.hp; // misses if the opponent is in the air
						}


						double health = defender.hp; // health value of the pokemon being attacked


						double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi

						System.out.println("Your damage roll is " + roll);

						soundeffects.noo();

						double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.spa/ (double) defender.spdef)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)

						// make sure to code for crits

						int crit = rand.nextInt(400);



						if (attack.critrate == 3.0)  {


							if (crit <= 27) {


								System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");

								if(attacker.ability.equals("sniper")) {

									damage *= 2.5;
									System.out.println("\n You got the sniper boost \n");
								}
								else {


									damage *= 1.5;

								}
							}

						}
						else if (attack.critrate == 6.0) {


							if (crit <= 55) {

								System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");

								if(attacker.ability.equals("sniper")) {

									damage *= 2.5;
									System.out.println("\n You got the sniper boost \n");
								}
								else {
									damage *= 1.5;
								}
							}

						}
						else {



							if (crit <= 101) {

								System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");

								if(attacker.ability.equals("sniper")) {

									damage *= 2.5;
									System.out.println("\n You got the sniper boost \n");
								}
								else {
									damage *= 1.5;
								}
							}



						}




						if(   (defender.type1.equals("steel")) || (defender.type1.equals("psychic"))  ) {

							damage *= 0.5;  //psychic is resisted by these types
							System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists

						}


						if(   (defender.type2.equals("steel")) || (defender.type2.equals("psychic")) ) {

							damage *= 0.5;  //psychic is resisted by these types
							System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists

						}


						if( (defender.type1.equals("fighting")) || (defender.type1.equals("poison")) ) {

							damage *= 2;  //psychic is super effective against these types
							System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting

						}


						if(  (defender.type2.equals("fighting")) || (defender.type2.equals("poison")) ) {

							damage *= 2;  //psychic is super effective against these types
							System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting

						}

						if(defender.type1.equals("dark") || defender.type2.equals("dark")) {

							damage *= 0;
							System.out.println("\n DARK POKEMON ARE IMMUNE TO PSYCHIC TYPE ATTACKS \n");

						}
						//



						if( (defender.ability.equals("multiscale") ) ){

							if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");

								damage = damage/2;

							}
						}


						damage = Math.round(damage);

						System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );


						health =  health - damage;





						int flinch = rand.nextInt(100);




						if(attacker.ability.equals("serenegrace")) {
							if( (flinch < 60) && (attacker.speed >= defender.speed)){

								defender.flinched = true;

							}


						}

						if( (flinch < 30) && (attacker.speed >= defender.speed)) {

							defender.flinched = true;


						}













						return Math.round(health);



					}




	//zenheadbut
          	    
        	    public static double zenheadbut(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
      
        	        
        	        
        	        
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
      
 
        	    	
  	
    	    		
    	    		if(   (defender.type1.equals("steel")) || (defender.type1.equals("psychic"))  ) {
           	    		
           	        	damage *= 0.5;  //psychic is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	    	

           	        if(   (defender.type2.equals("steel")) || (defender.type2.equals("psychic")) ) {
           	    		
           	        	damage *= 0.5;  //psychic is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
        	        if( (defender.type1.equals("fighting")) || (defender.type1.equals("poison")) ) {
        	    		
        	        	damage *= 2;  //psychic is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("fighting")) || (defender.type2.equals("poison")) ) {
        	    		
        	        	damage *= 2;  //psychic is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}

        	        if(defender.type1.equals("dark") || defender.type2.equals("dark")) {
        	        	
        	        	damage *= 0;
        	        	System.out.println("\n DARK POKEMON ARE IMMUNE TO PSYCHIC TYPE ATTACKS \n");
        	        	
        	        } 
        	        //
        	    	
        	    	
       
        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }

        	    	
        	        //
        		
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	    	int flinch = rand.nextInt(100);
        	    	
        	    	if((flinch < 20) && (attacker.speed >= defender.speed)){
        	    		
        	    		
        	    	defender.flinched = true;
        	    	
        	    	
        	    	}
        	    	 
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;
        				soundeffects.statincrease();
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        	    
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
 
        	    
              	 // 3/24/2021 (Types of moves sketched: Water,  psychic,bug, dark,steel,flying, normal, ice, dragon,fire, electric, grass,poison,fighting, fairy)
      	        	  
              	    //Start  ghost, ground, rock 
           	    
        	    
        	    /*
        	     * 
        	     * GHOST TYPE ATTACKS
        	     * 
        	     */

				//shadowsneak

						public static double shadowsneak(pokemon attacker, move attack, pokemon defender, String player) {


							if((defender.bounce == true) && !(attacker.ability.equals("noguard")) )  { // Checks if the opponent is in the air....

								System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
								return defender.hp; // misses if the opponent is in the air
							}


							double health = defender.hp; // health value of the pokemon being attacked


							double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; // The stupid damage roll pokemon made in gen 3: 0.85-1

							soundeffects.noo();

							System.out.println("Your damage roll is " + roll);

							double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


							if(attacker.ability.equals("toughclaws")){


								damage *= 1.3;
								System.out.println("Tough claws increased the damage of the attack!!");


							}

							// make sure to code for crits

							int crit = rand.nextInt(400);



							if (attack.critrate == 3.0)  {


								if (crit <= 27) {


									System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");

									if(attacker.ability.equals("sniper")) {

										damage *= 2.5;
										System.out.println("\n You got the sniper boost \n");
									}
									else {


										damage *= 1.5;

									}
								}

							}
							else if (attack.critrate == 6.0) {


								if (crit <= 55) {

									System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");

									if(attacker.ability.equals("sniper")) {

										damage *= 2.5;
										System.out.println("\n You got the sniper boost \n");
									}
									else {
										damage *= 1.5;
									}
								}

							}
							else {



								if (crit <= 101) {

									System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");

									if(attacker.ability.equals("sniper")) {

										damage *= 2.5;
										System.out.println("\n You got the sniper boost \n");
									}
									else {
										damage *= 1.5;
									}
								}



							}





							if(   (defender.type1.equals("dark"))   ) {

								damage *= 0.5;  //ghost is resisted by these types
								System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists

							}


							if(   (defender.type2.equals("dark"))  ) {

								damage *= 0.5;  //ghost is resisted by these types
								System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists

							}


							if( (defender.type1.equals("ghost")) || (defender.type1.equals("psychic")) ) {

								damage *= 2;  //ghost is super effective against these types
								System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting

							}


							if(  (defender.type2.equals("ghost")) || (defender.type2.equals("psychic")) ) {

								damage *= 2;  //ghost is super effective against these types
								System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting

							}

							if(defender.type1.equals("normal") || defender.type2.equals("normal")) {

								damage *= 0;
								System.out.println("\n NORMAL POKEMON ARE IMMUNE TO GHOST TYPE ATTACKS \n");

							}
							//


							if( (defender.ability.equals("multiscale") ) ){

								if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");

									damage = damage/2;

								}
							}


							if(attacker.ability.equals("technician")) {


								damage *= 1.5;
								System.out.println("Technician powered up the hit!!");
							}


							if(defender.ability.equals("solidrock")){

								damage = damage * 0.6;
								System.out.println("Solid rock reduced the damage of the attack");

							}

							damage = Math.round(damage);

							System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );




							health =  health - damage;



							if(defender.ability.equals("stamina")) {

								defender.def *= 1.5;
								soundeffects.statincrease();
								System.out.println("The opposing pokemon's defense rose");
							}

							return Math.round(health);



						}






	//shadowclaw

							public static double shadowclaw(pokemon attacker, move attack, pokemon defender, String player) {


								if(defender.bounce == true) { // Checks if the opponent is in the air....

									System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
									return defender.hp; // misses if the opponent is in the air
								}


								double health = defender.hp; // health value of the pokemon being attacked


								double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi

								System.out.println("Your damage roll is " + roll);

								soundeffects.noo();

								double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


								if(attacker.ability.equals("toughclaws")){


									damage *= 1.3;
									System.out.println("Tough claws increased the damage of the attack!!");


								}

								// make sure to code for crits

								int crit = rand.nextInt(400);




								if (attack.critrate == 3.0)  {


									if (crit <= 27) {


										System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");

										if(attacker.ability.equals("sniper")) {

											damage *= 2.5;
											System.out.println("\n You got the sniper boost \n");
										}
										else {


											damage *= 1.5;

										}
									}

								}
								else if (attack.critrate == 6.0) {


									if (crit <= 55) {

										System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");

										if(attacker.ability.equals("sniper")) {

											damage *= 2.5;
											System.out.println("\n You got the sniper boost \n");
										}
										else {
											damage *= 1.5;
										}
									}

								}
								else {



									if (crit <= 101) {

										System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");

										if(attacker.ability.equals("sniper")) {

											damage *= 2.5;
											System.out.println("\n You got the sniper boost \n");
										}
										else {
											damage *= 1.5;
										}
									}



								}






								if(   (defender.type1.equals("dark"))   ) {

									damage *= 0.5;  //ghost is resisted by these types
									System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists

								}


								if(   (defender.type2.equals("dark"))  ) {

									damage *= 0.5;  //ghost is resisted by these types
									System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists

								}


								if( (defender.type1.equals("ghost")) || (defender.type1.equals("psychic")) ) {

									damage *= 2;  //ghost is super effective against these types
									System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting

								}


								if(  (defender.type2.equals("ghost")) || (defender.type2.equals("psychic")) ) {

									damage *= 2;  //ghost is super effective against these types
									System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting

								}

								if(defender.type1.equals("normal") || defender.type2.equals("normal")) {

									damage *= 0;
									System.out.println("\n NORMAL POKEMON ARE IMMUNE TO GHOST TYPE ATTACKS \n");

								}
								//



								if( (defender.ability.equals("multiscale") ) ){

									if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");

										damage = damage/2;

									}
								}

								//


								if(attacker.ability.equals("technician")) {


									damage *= 1.5;
									System.out.println("Technician powered up the hit!!");
								}

								damage = Math.round(damage);

								System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );


								health =  health - damage;






								if(defender.ability.equals("stamina")) {

									defender.def *= 1.5;
									soundeffects.statincrease();
									System.out.println("The opposing pokemon's defense rose");
								}


								return Math.round(health);



							}



	//shadowball
        	    public static double shadowball(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if(defender.bounce == true) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	soundeffects.noo(); 
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.spa/ (double) defender.spdef)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)
        	    	
        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	
        	    	
        	    	
        	    	
    	    		if(   (defender.type1.equals("dark"))   ) {
           	    		
           	        	damage *= 0.5;  //ghost is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	    	

           	        if(   (defender.type2.equals("dark"))  ) {
           	    		
           	        	damage *= 0.5;  //ghost is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
        	        if( (defender.type1.equals("ghost")) || (defender.type1.equals("psychic")) ) {
        	    		
        	        	damage *= 2;  //ghost is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("ghost")) || (defender.type2.equals("psychic")) ) {
        	    		
        	        	damage *= 2;  //ghost is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}

        	        if(defender.type1.equals("normal") || defender.type2.equals("normal")) {
        	        	
        	        	damage *= 0;
        	        	System.out.println("\n NORMAL POKEMON ARE IMMUNE TO GHOST TYPE ATTACKS \n");
        	        	
        	        } 
        	        //
        	      
        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        	        
        		
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	    	
        	    	
        	        
        	        
        	        int oof = rand.nextInt(100);
        	        
        	        
        	        	if(   !(defender.ability.equals("clearbody"))   ) {
        	        		
        	        		
        	        		if(attacker.ability.equals("serenegrace")) {
        	        			if(oof > 70) {
        	        				soundeffects.drop();
                   		 			System.out.println("The opponent's special defense fell.....");
                   		 		    defender.spdef *= 0.5;
                   		 		
                   		 		}
                          		 
        	        			
        	        			
        	        		}
        	        		if(oof < 30) {
        	        			soundeffects.drop();
               		 			System.out.println("The opponent's special defense fell.....");
               		 		    defender.spdef *= 0.5;
               		 		
               		 		}
                      		 
                      	
        	        		
        	        	}

               		 	
                    		
                    		
                 		
        	        
        	        return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	   //ground moves
        	    
        	    
        	    
        	    /*
        	     * 
        	     * GROUND TYPE ATTACKS
        	     * 
        	     */
        	       //earthquake
        	    public static double earthquake(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if((defender.bounce == true) && !(attacker.ability.equals("noguard")) ) {// Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	    	
        	        soundeffects.noo(); 
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	    	
        	    	
    	    	
        	    	
    	    		if(   (defender.type1.equals("grass")) || (defender.type1.equals("bug")) ) {
           	    		
           	        	damage *= 0.5;  //ground is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	    	

           	        if(   (defender.type2.equals("grass")) || (defender.type2.equals("bug")) ) {
           	    		
           	        	damage *= 0.5;  //ground is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
        	        if(    (defender.type1.equals("steel")) ||(defender.type1.equals("rock")) || (defender.type1.equals("poison")) || (defender.type1.equals("electric")) || (defender.type1.equals("fire")) ) {
        	    		
        	        	damage *= 2;  //ground is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if( (defender.type2.equals("steel")) ||(defender.type2.equals("poison")) || (defender.type2.equals("rock")) || (defender.type2.equals("electric")) || (defender.type2.equals("fire")) ) {
        	    		
        	        	damage *= 2;  //ground is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}

        	     
        	        //
        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        	        
        	        
        	        if(  (defender.ability.equals("levitate")) &&  !(attacker.ability.equals("moldbreaker"))   ) {
        	        	
        	        	damage *= 0;
        	        	System.out.println(" The opposing pokemon's levitate makes it immune to ground moves ");
        	        }
        	        
        	        
        	        if(  (defender.type1.equals("flying")) ||  (defender.type2.equals("flying"))   ) {
        	        	
        	        	
        	        	damage *= 0;
        	        	System.out.println("\n Flying pokemon are immune to ground moves!!!!");
        	        }
        	        
        	        
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	        
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;
        				soundeffects.statincrease();
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    
        	    
        	    
        		 // 3/24/2021 (Types of moves sketched: Water, ground, psychic,bug, dark,steel,flying, normal, ice,  ghost, dragon,fire, electric, grass,poison,fighting, fairy)
	        	  
         	    //Start  rock 
    	    
        	    
        	    /*
        	     * 
        	     * ROCK TYPE ATTACKS
        	     * 
        	     */
        	       


        	    //stoneedge
        	    
        	    
        	    public static double stoneedge(pokemon attacker, move attack, pokemon defender, String player) {
        	    	
        	    	
        	    	if((defender.bounce == true) && !(attacker.ability.equals("noguard")) ) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("Stone Edge sniped the opponent in mid-air!!!!!");
        	    		
        	    	}
        		
        		
        	    	double health = defender.hp; // health value of the pokemon being attacked
        	    	
        	    	
        	        double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi
        	        soundeffects.noo(); 
        	        
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	
        	    	if(   (defender.type1.equals("ground")) ||(defender.type1.equals("steel")) || (defender.type1.equals("fighting"))  ) {
           	    		
           	        	damage *= 0.5;  //rock is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	    	

           	        if(   (defender.type2.equals("ground")) ||  (defender.type2.equals("steel")) || (defender.type2.equals("fighting")) ) {
           	    		
           	        	damage *= 0.5;  //rock is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
        	        if( (defender.type1.equals("fire")) || (defender.type1.equals("ice")) || (defender.type1.equals("flying")) || (defender.type1.equals("bug")) ) {
        	    		
        	        	damage *= 2;  //rock is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("fire")) || (defender.type2.equals("ice")) || (defender.type2.equals("flying")) || (defender.type2.equals("bug")) ) {
        	    		
        	        	damage *= 2;  //rock is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}

        	     
        	        //
        	      

        	        //
        		
        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        	        
        	        

    	        	if(defender.ability.equals("solidrock")){
    	        	 
    	        	damage = damage * 0.6;
    	        	 System.out.println("Solid rock reduced the damage of the attack");
    	        	 
    	        	 }
    	        	 
    	        	
    	        	
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        
        	        health =  health - damage; 
        	        
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;
        				soundeffects.statincrease();
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        	    	
        	    	return Math.round(health);
        	    	
        	    	
        	    	
        	    }
        	    
        	    
        	    
        	    
        	    
        	    
        	    
        	    
        	    //rockslide
        	    
        	    
        	    
        	    public static double rockslide(pokemon attacker, move attack, pokemon defender, String player) {
            	    
        	    	
        	    	
        	    	if((defender.bounce == true) && !(attacker.ability.equals("noguard")) ) { // Checks if the opponent is in the air....
        	    		
        	    		System.out.println("The move missed because the opponent bounced up high in the air!!!!!");
        	    		return defender.hp; // misses if the opponent is in the air
        	    	}
        		
        		
        	    	
        	    	double health = defender.hp; // health value of the pokemon being attacked



					double roll = mindamageroll + (maxdamageroll - mindamageroll) * rand.nextDouble() ; //now modified to 0.85-1)// The stupid damage roll pokemon made in gen 3: 0-1, modified by Nevin Ndonwi

					soundeffects.noo();
        	    	System.out.println("Your damage roll is " + roll);
        	    	
        	    	double damage = ((double)(((((2 * 100) * 0.2) + 2 )   * attack.power * (double) (attacker.attack/ (double) defender.def)) * 0.02 ) + 2) * roll; // How much damage the move will do (the equation)


					if(attacker.ability.equals("toughclaws")){


						damage *= 1.3;
						System.out.println("Tough claws increased the damage of the attack!!");


					}

        	    	// make sure to code for crits 
        	    	
        	    	int crit = rand.nextInt(400);
        	    	
        	    	
        	    	
        	    	if (attack.critrate == 3.0)  {
        	    
        		     
        	    	     if (crit <= 27) {
        	    	
        	    	    	 	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a normal crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    				 
        	    				 
        	    			 damage *= 1.5;
        	    			 
        	    			 }
        	    	     }
        	    	
        	    	}
        	    	else if (attack.critrate == 6.0) {
        	     		
        	     		
        	    		 if (crit <= 55) {
        	    		    	
        	    			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a high crit rate) \n");
        	    		    
        	    			 if(attacker.ability.equals("sniper")) {
        	    				 
        	    				 damage *= 2.5;
        	    				 System.out.println("\n You got the sniper boost \n");
        	    			 }
        	    			 else {
        	    			 damage *= 1.5;
        	    			 }
        	    	     }
        	     		
        		    }
        	    	else {
        	    		
        	    		

        	   		 if (crit <= 101) {
        	   		    	
        	   			 System.out.println("\n YOU GOT A CRIT YOU LUCKY PERSON (You have a really high crit rate) \n");
        	   		    
        	   			 if(attacker.ability.equals("sniper")) {
        	   				 
        	   				 damage *= 2.5;
        	   				 System.out.println("\n You got the sniper boost \n");
        	   			 }
        	   			 else {
        	   			 damage *= 1.5;
        	   			 }
        	   	     }
        	    		
        	    		
        	    		
        	    	}
        	    	
        	
        	    	if(   (defender.type1.equals("ground")) ||(defender.type1.equals("steel")) || (defender.type1.equals("fighting"))  ) {
           	    		
           	        	damage *= 0.5;  //rock is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	    	

           	        if(   (defender.type2.equals("ground")) ||  (defender.type2.equals("steel")) || (defender.type2.equals("fighting")) ) {
           	    		
           	        	damage *= 0.5;  //rock is resisted by these types
           	    			System.out.println(" \n IT'S NOT VERY EFFECTIVE!!!! \n ");  soundeffects.resist(); // plays sound effect for a move that resists 
           	    		
           	    	}
           	        
           	        
        	        if( (defender.type1.equals("fire")) || (defender.type1.equals("ice")) || (defender.type1.equals("flying")) || (defender.type1.equals("bug")) ) {
        	    		
        	        	damage *= 2;  //rock is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}
        	    	

        	        if(  (defender.type2.equals("fire")) || (defender.type2.equals("ice")) || (defender.type2.equals("flying")) || (defender.type2.equals("bug")) ) {
        	    		
        	        	damage *= 2;  //rock is super effective against these types
        	    		System.out.println(" \n IT'S SUPER EFFECTIVE!!!! \n ");  soundeffects.attack(); // This plays a sound effect of the move hitting
        	    		
        	    	}

        	     
        	        //
        	      
        	        
        	        if( (defender.ability.equals("multiscale") ) ){
        	          	 
        	      	     if(defender.hp == defender.maxhp) { System.out.println("multiscale reduced the damage the pokemon took");
        	      	     
        	      	     damage = damage/2;
        	      	     
        	      	     }
        	      	 }
        	        
        	        //	
        	        if(defender.ability.equals("solidrock")){
   	        	 
   	        	damage = damage * 0.6;
   	        	 System.out.println("Solid rock reduced the damage of the attack");
   	        	 
   	        	 }
   	        	 
   	        	
   	        	
        		
        	        damage = Math.round(damage);
        	        
        	        System.out.println("\n" + defender.hp + "  "  + " - "  + damage + " = " + "  " + player + "'s new health: " + Math.round(defender.hp - damage)  );
        	    	
        	        int oof = rand.nextInt();
        	        
        	        if( (oof < 30) && (attacker.speed >= defender.speed)){
        	        	
        	        	defender.flinched = true;
        	        }
        	        
        	        

    	        
        	        health =  health - damage; 
        	    	
        	        
        	    	
        	        
        			if(defender.ability.equals("stamina")) {
        				
        				defender.def *= 1.5;
        				soundeffects.statincrease();
        				System.out.println("The opposing pokemon's defense rose");
        			}
        	    
        	    	
        	    	return Math.round(health);
         	    	
        	    	
        	    	
        	    }
        	    
        	
		// moves and abilities completed on 3/25/2021
        	     
        	     //suckerpunch and flinching need to be fixed
        	    
        	  
        	    
        	    // start documenting this project (finish this springbreak)
        	    
        	    
        	    
}// end of class battle sequence



//rock- flying (water, ice, rock, electric, steel, )

/*
 
 if(defender.ability.equals("solidrock"){
 
damage = damage * 0.6;
 System.out.println("Solid rock reduced the damage of the attack");
 }
 
 */

 


// doing a battle sim in java makes it easier to add pokemon because it is class based and i dont have to code it for each pokemon


 

















