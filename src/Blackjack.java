import java.util.*;

public class Blackjack {
        public static void main (String args[]) {
            Scanner scnr = new Scanner(System.in);
            int Game = 1;
            int cardValue;
            int hand;

            System.out.println("START GAME #" + (Game));

            cardValue = cardGeneration();
            System.out.println(cardDeclaration(cardValue));
            System.out.println(handValue(cardValue));

            Menu();

            int userOption = scnr.nextInt();

        }

        public static String handValue(int card) {
            if (card == 1) {
                return ("Your hand is: 1");
            }
            if (card > 1 && card < 11) {
                return ("Your hand is: " + card);
            }

            if (card == 11) {
                return "Your hand is: 10";
            }
            if (card == 12) {
                return "Your hand is: 10";
            }
            if (card == 13) {
                return "Your hand is: 10";
            } else {
                return null;
            }
        }


    public static int cardGeneration() {
                int card = (int) (Math.random() * (13 - 1)) +1;
                return (card);
            }


    public static String cardDeclaration(int card) {
        if (card == 1) {
            return ("Your card is an ACE!");
        }
        if (card > 1 && card < 11) {
            return ("Your card is a " + (card) + "!");
        }
        if (card == 11) {
            return ("Your card is an JACK!");
        }
        if (card == 12) {
            return ("Your card is an QUEEN!");
        }
        if (card == 13) {
            return ("Your card is an KING!");
        }
        else {
            return null;
        }
    }

    public static void Menu(){
                Scanner scnr = new Scanner(System.in);
                System.out.println("1. Get another card");
                System.out.println("2. Hold hand");
                System.out.println("3. Print statistics");
                System.out.println("4. Exit");
                System.out.println();
                System.out.println("Choose an option: ");
                int askOption = scnr.nextInt();
    }
}

