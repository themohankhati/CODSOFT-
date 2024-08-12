package task1;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args)
    {
        //         generating random number
        Random randNum=new Random();

        int randomNumber=randNum.nextInt(100)+1;

//            print the generated random number
        System.out.print("Random number: " +randomNumber+ '\n');


//      scanner object
        Scanner sc = new Scanner(System.in);
        System.out.println("Guess the number between 1 and 100!");

        String guessNumber= sc.nextLine();
        System.out.println("User guess:"+ guessNumber);


    };
    }
}
