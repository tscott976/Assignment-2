import java.util.Scanner;

public class RandomNumberGuesser 
{

	public static void main(String[] args) 
	{
			//Declaration of variables for driver
			int highGuess;
			int lowGuess;
			int nextGuess;
			int target;
			String again;
			boolean isCorrect = false;
			Scanner kybrd = new Scanner(System.in);
			
			//Header to print out at top of program
			System.out.println("-----Welcome to the Random Number Guesser-----");
			System.out.println();
			
			//Start of game loop, this is to run until user enters no at prompt
			do
			{
				//Resets the count at the top of the loop using the resetCount method
				RNG.resetCount();
				
				//Resets the highest and lowest guesses for the game
				highGuess = 100;
				lowGuess = 1;
				
				//Gets the random number for the game using the rand method
				target = RNG.rand();
				
				//Asks for first guess
				System.out.println("Enter your first guess");
				
				//If the first guess is incorrect, this loop will validate the guess, 
				//compare the guess, change the highest or lowest guess and then ask for a new guess
				do 
				{
					
					//Reading the guess and using the inputValidation method on it
					do
					{
						nextGuess = kybrd.nextInt();
					}
					while (!RNG.inputValidation(nextGuess, lowGuess, highGuess));
					//Calling the printGuesses method to print the number of guesses
					printGuesses(RNG.getCount());
									
					//Logic adjustments to change lowGuess or highGuess
					if (target > nextGuess)
					{
						System.out.println("Your guess is too low");
						lowGuess = nextGuess;
						isCorrect = false;
					}
					else if (target < nextGuess)
					{
						System.out.println("Your guess is too high");
						highGuess = nextGuess;
						isCorrect = false;
					}
					else if (target == nextGuess)
					{
						isCorrect = true;
					}
					
					//Asking user for their next guess between the adjusted lowGuess and highGuess
					if (!isCorrect)
					{
						System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
					}
				}
				while (isCorrect == false);
				
				
				//Telling the user the guess is correct and asking if they want to play again
				kybrd.nextLine();
				System.out.println("Congratulations, you guessed correctly");
				System.out.println("Try again? (yes or no)");
				again = kybrd.nextLine();
				again = again.toLowerCase();
				
				//Validating the Yes/No entry
				while (!again.equals("yes") && !again.equals("no"))
				{
					System.out.println("That was not a valid entry, please enter yes or no");
					again = kybrd.nextLine();
					again = again.toLowerCase();
				}
				
				
			}
			while (again.equals("yes"));
			
			//Printing out the programmers name at the end of the program
			System.out.println("This program was written by Tim Scott");
			
			kybrd.close();
	}
	
	public static void printGuesses(int guesses)
	{
		//Displaying the number of guesses using the getCount method				
		System.out.println("Number of guesses is " + guesses);
	}

}
