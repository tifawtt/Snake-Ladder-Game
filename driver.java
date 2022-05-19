// -----------------------------------------------------
// Assignment 0
// Question: Part 2 
// Written by: Sarah Amaniss 40213883
// -----------------------------------------------------

//This part of the program is to control the input of the game users.
//The number of players must be contained within a certain range, this program will assure
//that only correct inputs will be utilized.


//Import packages
import java.util.Scanner;

public class driver {

	public static void main(String[] args) {
		
	//Declare Scanner 
		Scanner sc = new Scanner(System.in);
		
    //Declare Variables
		int num;
		int count =0;
		
	//Prompt user for number of players and store it.
		
			    
				System.out.println("*************** WELCOME TO LADDER AND SNAKE ********************\n\nPlease enter the # of players of your game - Number must be between 2 and 4 inclusively: \n");
			    num = sc.nextInt();
			    
			    //If input number is incorrect, increase count of incorrect entries and pass into the next message until
			    //incorrect entries reach 4.  
			    
			    if((num<2)||(num>4)) {
			    	count++;
			    }
			    
				
			   
			   if(count == 1) {
				System.out.println("Bad attempt 1 - Invalid # of players. Please enter a # between 2 and 4 inclusively:\n");
				num = sc.nextInt();
			    
			    if((num<2)||(num>4)) {
			    	count++;
			    }
			    }
			
			if(count==2) {
				System.out.println("Bad attempt 2 - Invalid # of players. Please enter a # between 2 and 4 inclusively:\n");
				num = sc.nextInt();
			    
			    if((num<2)||(num>4)) {
			    	count++;
			    }
			    }
			
			if(count==3) {
				System.out.println("Bad attempt 3 - Invalid # of players. Please enter a # between 2 and 4 inclusively. This is your last attempt: \n");
               num = sc.nextInt();
			    
			    if((num<2)||(num>4)) {
			    	count++;
			    }
			    }
			
			if(count==4) {
				System.out.println("Bad attempt 4! You have exhausted all your chances. Program will terminate. \n");
			}
	
		
		
		//If incorrect entries are lower than 4, play the game. Otherwise, do nothing. End of program. 
		if(count<4){
			
			LadderAndSnake game = new LadderAndSnake(num);
			
			game.play();
	
		}
		
		
	    	
	    	//Close scanner
		    sc.close();
	    	
	
		
	    
	    
	    
	

		
		
		
		
		

	}

}
