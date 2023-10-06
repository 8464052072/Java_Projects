package Learning;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		Random random=new Random();
		
		int userGuess;
		int numberOfGuesses=0;
		int randomNumber;
		randomNumber=random.nextInt(11);

		
		do {
			System.out.println("Enter your Guess:");
			userGuess=sc.nextInt();
			numberOfGuesses++;
			
			
			if(userGuess>randomNumber)
				System.out.println("Too High! , Try again");
			else if(userGuess<randomNumber)
				System.out.println("Too Low! , Try again");
			else
				System.out.println("Congratulations! you guessed the number in "+numberOfGuesses+" Guesses");
			
		}while(userGuess!=randomNumber);
	}

}
