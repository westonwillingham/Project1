import java.util.*;

public class Main {
        public static void main (String args[]) {
            Scanner scnr = new Scanner(System.in);
        int gameNumber = 1;

        System.out.println("START GAME #" +(gameNumber));
        double randomValue = 1 +(Math.random() * (13 - 1));
        long randomNumber = Math.round(randomValue);
        int randomNumberInt = (int) randomNumber;

        int cardValue = 0;

        if (randomNumberInt == 1) {
            System.out.println("Your card is an ACE!");
            cardValue=1;
        }
        if (randomNumberInt > 1 && randomNumberInt < 11) {
            System.out.println("Your card is a " + (randomNumberInt)+"!");
            cardValue =randomNumberInt;
        }

        if (randomNumberInt == 11) {
            System.out.println("Your card is an JACK!");
            cardValue=10;
        }
        if (randomNumberInt == 12) {
            System.out.println("Your card is an QUEEN!");
            cardValue=10;
        }
        if (randomNumberInt == 13) {
            System.out.println("Your card is an KING!");
            cardValue=10;
        }
            System.out.println("Your hand is: " + (cardValue));
            System.out.println();
            System.out.println("1. Get another card");
            System.out.println("2. Hold hand");
            System.out.println("3. Print statistics");
            System.out.println("4. Exit");
            System.out.println();
            System.out.println("Choose and option: ");
            int optionChosen = scnr.nextInt();
            










    }
    }