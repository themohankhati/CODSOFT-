package task1;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        //scanner object
        Scanner sc = new Scanner(System.in);

        //generating random number
        Random randNum = new Random();
        int rounds = 0;
        int totalScore = 0;
        String playAgain;

        do {
            rounds++;
            int randomNumber = randNum.nextInt(100) + 1;
            int numOfAttempts = 0;
            int maxAttempts = 5;
            boolean hasWon = false;

            System.out.println("Round" + rounds + " :Guess the number between 1 and 100!");
        while (numOfAttempts < maxAttempts) {
                System.out.println("Guess the number between 1 and 100!");
                int userGuess = sc.nextInt();
                numOfAttempts++;

                if (userGuess == randomNumber) {
                    hasWon = true;
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high!");
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low!");

                }

            }

        if(hasWon){
            System.out.println("Congratulations! you've guessed the number in " +numOfAttempts+ "attempts.");
            totalScore+= (maxAttempts-numOfAttempts+1);
        }
        else {
            System.out.println("You've used all your attempts. The correct number was " + randomNumber + ".");
        }

        System.out.println("Do you want to play again? (yes or no)");
        playAgain=sc.next();

        } while (playAgain.equalsIgnoreCase("yes"));
        System.out.println("So Game is over! you've played"+ rounds
        + "rounds with a total score of"+ totalScore + ".");

    }}
