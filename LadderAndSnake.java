// -----------------------------------------------------
// Assignment 0
// Question: Part 1
// Written by: Sarah Amaniss 40213883
// -----------------------------------------------------


//Import packages
import java.util.Arrays;
import java.util.Random;

/**
 * 
 *  Sarah Amaniss 40213883 
 *  COMP 249 
 *  Assignment # 0
 *  Due Date: 07/02/2022
 * 
 * The objective of this program is to create the Ladder and Snake Game.
 * In this Game, players will first determine the order of play by each rolling the dice once.
 * If any tie occur, the players in question will roll again to break the tie.
 * After the order has been decided, players will roll the dice alternatively until one of the players
 * reach square 100 by the rules of the game. This will be done by implementing various classes.
 * 
 * @author sarahamaniss
 *
 */
public class LadderAndSnake {

//Data Declaration
private int numOfPlayers;
private int[][] board = new  int[10][10];



/**
 * This is the default constructor. It sets the numbers of players
 * to its minimum of 2.
 */
public LadderAndSnake(){
    numOfPlayers = 2;
}


/**
 * This is a constructor that sets the number of players
 * 
 * @param numPlayers The number of players   
 */
public LadderAndSnake(int numPlayers){
    numOfPlayers = numPlayers;
}


/** 
 * 
 * This is a copy constructor that creates a game with the attributes
 * of another the game. They would have the same numbers or players.
 * 
 * @param game   This is the game to be copied from
 */
public LadderAndSnake(LadderAndSnake game) {
    numOfPlayers = game.numOfPlayers;
}

/**
 * 
 * This is a mutator to modify the number of players.
 * 
 * @param num Number of players
 */
public void setNumOfPlayers(int num){
numOfPlayers = num;
}

/**
 * 
 * This is an accessor to access the number of players.
 * 
 * @return the number of players
 */
public int getNumOfPlayers(){
    return numOfPlayers;
}


/**
 * 
 * Flip Dice Method. Method that will generate a random number between 1 and 6
 * 
 * @return a random number between 1 and 6 inclusively.
 */
public static int flipDice(){
    Random rand = new Random();
    int diceNum = (rand.nextInt(6)+1); //6 is the upperbound exclusively. Therefore add 1 to generate a
                                      //number between 1 and 6 rather than between 0 and 5
    return diceNum;
}

//Play Method
/**
 * This method determines the order of play of each players, and makes them play until one of them
 * reaches square 100 exactly.
 */
public void play(){

System.out.println("Game is played by "+numOfPlayers+" players!");
System.out.println("Now deciding which player will start playing...\n");

//Create an array to store the dice number for each player

int[][] playersArr = new int[2][numOfPlayers];

//Make every player flip the dice
for(int i = 0; i<numOfPlayers; i++){

int currentDice = flipDice();
playersArr[1][i] = currentDice;

//Display dice result of each player
System.out.println("Player "+(i+1)+" got a dice value of "+currentDice);

}

System.out.println();

//Fill the first row of the array with player numbers
for(int i = 0; i< numOfPlayers; i++){
  
    playersArr[0][i]=i+1;


}


//Run the first time to determine the order of the players
//Compare each of the dice value of each of the players, from left to right

for(int i = 0; i<numOfPlayers;i++){

    for(int j = i+1; j<numOfPlayers;j++){
    	
    	//If the player at the left has a dice value lower than that of the player it is being compared to at the right,
    	//exchange their place in the array along with their dice value. So the array contains players from left to right: greatest to lowest dice value.
    	if(playersArr[1][i]<playersArr[1][j]) {
    	
    		int playerNb; //placeholder for the player number
    		int diceNb; //placeholder for the dice number of the player
    		
    		
    		//Exchange player number and dice value.
    		
    		diceNb = playersArr[1][i];
    		playerNb = playersArr[0][i];
    		
    		playersArr[1][i] = playersArr[1][j];
    		playersArr[0][i] = playersArr[0][j];
    		
    		playersArr[1][j] = diceNb;
    		playersArr[0][j] = playerNb;
    		
    		
    	}
      
    }

}



//Run a second time to detect any dice number that are equal.

for(int i = 0; i<numOfPlayers;i++){

    for(int j = i+1; j<numOfPlayers;j++){
    	
    	//If any of the players have equal dice values, they will be next to each other in the array. 
    	if(playersArr[1][i]==playersArr[1][j]) {
    	
    	System.out.println("A tie was achieved between Player "+playersArr[0][i]+" and Player "+playersArr[0][j]+". Attempting to break the tie.\n");
    	
    	//Initialize variables
    	int dice1= 0;
    	int dice2 =0;
    
    	//Make the two players flip the dice.
    	do{
    	dice1 = flipDice();
    	System.out.println("Player "+playersArr[0][i]+" got a dice value of "+dice1);
    	dice2 = flipDice();
    	System.out.println("Player "+playersArr[0][j]+" got a dice value of "+dice2+"\n");
    	
    	
    	if(dice1==dice2) {
    		System.out.println("Another tie! Let's roll the dice again.\n");
    	}
    	
    	}
    	while (dice1 == dice2); //Continue making them flip the dice until they have different dice values.
    	
    	//The smallest index is the "i" index, while the bigger one is the "j" index.
    	//If player at the "j" index has a greater dice number, make then exchange place.
    	//Otherwise, keep the same order because "i" is already at the smallest position of the two.
    	int placeHolder;
    	
    	if(dice2>dice1) {
    		
    		
    		placeHolder = playersArr[0][i];
    		playersArr[0][i] = playersArr[0][j];
    		playersArr[0][j] = placeHolder;
    		
    	}
    
    		
    	}
      
    }

}

//Announcing the player order 
System.out.print("Reached final decision on order of playing: ");

for (int i =0; i < numOfPlayers;i++) {
	System.out.print("Player "+playersArr[0][i]+", ");
}

System.out.println();

//Initialize all player positions to zero
for(int i =0; i<numOfPlayers; i++) {
	
	playersArr[1][i] = 0;
}


System.out.println();

//Play the game

//Create a boolean that indicates whether the game is over or not
boolean gameIsOver =false;


//Play until there is an indication that one of the players has reached 100.
do {
	
//Make every player roll the dice.
for(int i =0; i< numOfPlayers; i++) {
	
 int diceNb = flipDice();
 int positionNb = (playersArr[1][i]+diceNb);
 
 //If any of the players has reached a square greater than 100, make the player move backward with the excessive amount.
 if(positionNb>100) {
	 
	 playersArr[1][i] = 100 - (positionNb -100);
	 
	 System.out.println("Oh no! Player "+playersArr[0][i]+" got a dice value of "+diceNb+"; gone to square 100 then back down to square "+playersArr[1][i]);
	 
 }
 
 
//If the player is at the tip of the ladder or at the head of a snake, switch the position of the player to the corresponding square. Otherwise, leave the original position number.
 switch(positionNb) {
 
 case 1: playersArr[1][i] = 38;
         System.out.println("Player "+playersArr[0][i]+" got a dice value of "+diceNb+"; gone to square "+positionNb+" then up to square "+playersArr[1][i]);
 	     break;    
 case 4: playersArr[1][i] = 14;
         System.out.println("Player "+playersArr[0][i]+" got a dice value of "+diceNb+"; gone to square "+positionNb+" then up to square "+playersArr[1][i]);	
  break;
 case 9: playersArr[1][i] = 31;
 System.out.println("Player "+playersArr[0][i]+" got a dice value of "+diceNb+"; gone to square "+positionNb+" then up to square "+playersArr[1][i]);
  break;
 case 16: playersArr[1][i] = 6;
 System.out.println("Player "+playersArr[0][i]+" got a dice value of "+diceNb+"; gone to square "+positionNb+" then down to square 38 "+playersArr[1][i]);
  break;
 case 21: playersArr[1][i] = 42;
 System.out.println("Player "+playersArr[0][i]+" got a dice value of "+diceNb+"; gone to square "+positionNb+" then up to square "+playersArr[1][i]);
  break;
 case 28: playersArr[1][i] = 84;
 System.out.println("Player "+playersArr[0][i]+" got a dice value of "+diceNb+"; gone to square "+positionNb+" then up to square "+playersArr[1][i]);
  break;
 case 36: playersArr[1][i] = 44;
 System.out.println("Player "+playersArr[0][i]+" got a dice value of "+diceNb+"; gone to square "+positionNb+" then up to square "+playersArr[1][i]);
  break;
 case 48: playersArr[1][i] = 30;
 System.out.println("Player "+playersArr[0][i]+" got a dice value of "+diceNb+"; gone to square "+positionNb+" then down to square "+playersArr[1][i]);
  break;
 case 51: playersArr[1][i] = 67;
 System.out.println("Player "+playersArr[0][i]+" got a dice value of "+diceNb+"; gone to square "+positionNb+" then up to square "+playersArr[1][i]);
  break;
 case 64: playersArr[1][i] = 60;
 System.out.println("Player "+playersArr[0][i]+" got a dice value of "+diceNb+"; gone to square "+positionNb+" then down to square "+playersArr[1][i]);
  break;
 case 71: playersArr[1][i] = 91;
 System.out.println("Player "+playersArr[0][i]+" got a dice value of "+diceNb+"; gone to square "+positionNb+" then up to square "+playersArr[1][i]);
  break;
 case 79: playersArr[1][i] = 19;
 System.out.println("Player "+playersArr[0][i]+" got a dice value of "+diceNb+"; gone to square "+positionNb+" then up to square "+playersArr[1][i]);
 break;
 case 80: playersArr[1][i] = 100;
 System.out.println("Player "+playersArr[0][i]+" got a dice value of "+diceNb+"; gone to square "+positionNb+" then up to square "+playersArr[1][i]+"! Congratulations:) GAME OVER.");
  break;
 case 93: playersArr[1][i] = 68;
 System.out.println("Player "+playersArr[0][i]+" got a dice value of "+diceNb+"; gone to square "+positionNb+" then down to square "+playersArr[1][i]);
  break;
 case 95: playersArr[1][i] = 24;
 System.out.println("Player "+playersArr[0][i]+" got a dice value of "+diceNb+"; gone to square "+positionNb+" then down to square "+playersArr[1][i]);
  break;
 case 97: playersArr[1][i] = 76;
 System.out.println("Player "+playersArr[0][i]+" got a dice value of "+diceNb+"; gone to square "+positionNb+" then down to square "+playersArr[1][i]);
  break;
 case 98: playersArr[1][i] = 78;
 System.out.println("Player "+playersArr[0][i]+" got a dice value of "+diceNb+"; gone to square "+positionNb+" then down to square "+playersArr[1][i]);   
  break;
 case 100: playersArr[1][i] = 100;
 System.out.println("Player "+playersArr[0][i]+" got a dice value of "+diceNb+"; gone to square 100! Congratulations:) GAME OVER.");
 break;
 default: playersArr[1][i] = positionNb;
		 System.out.println("Player "+playersArr[0][i]+" got a dice value of "+diceNb+". Now in square "+playersArr[1][i]);
;


 }
 
//If one player has reached 100, exit the for loop to prevent other players from rolling the dice.
if(playersArr[1][i]>=100) {
	
	gameIsOver = true;
	break;
}

//When everyone is done playing one turn, and if no one has won yet, announce whether the game is over or not
else if(i==numOfPlayers-1) {
	System.out.println("\nGame not over! Flipping again.\n");
}

}

//Verify if any player reached the 100 square after every play. If so, exit the do while loop by making the condition false.
for(int i=0; i<numOfPlayers; i++) {
	
	if (playersArr[0][i]>=100){
		gameIsOver = true;
		
	}
	
}


}while(gameIsOver==false); 

		
		
		
		






}


}



