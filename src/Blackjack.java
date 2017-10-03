import java.util.*;
import java.text.*;

public class Blackjack {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        int option = 1;
        Random randomValue = new Random();
        int randomCard;
        int cardValue = 0;                                                          // variables to determine card value

        String cardDescription = "";
        int userHandValue = 0;
        int numUserWins = 0;
        int dealerHand;
        int gameNumber = 1;
        int numTies = 0;
        int numDealerWins = 0;
        double winPercentage;                                                    // variables to determine the game totals

        do{                                                        // this is one do while loop
            if (userHandValue > 0) {                               // it will continue to run unless the user option == 4
                Menu();                                            // prints the Menu (external method located at bottom)
                try {                                              // this tries to run the scanner and catches any value that doesn't fit the INTEGER criteria
                    option= scnr.nextInt();
                }
                catch (InputMismatchException Error) {             // catches exceptions and says to input a valid integer between 1 and 4
                    System.out.println("Invalid input!\nPlease enter an integer value between 1 and 4.\n");
                        Menu();                                    // this prints the menu again after they put in an invalid option
                    scnr.nextLine();                               // this looks for a new value to run
                }
            }                                                      // this try/catch will keep CYCLING until a proper value for int option is input
            switch (option) {                                      // this switch statement corresponds to the user input
                    case 1:
                        if (userHandValue == 0) {
                            System.out.println("START GAME #" + gameNumber + "\n"); // if the user has nothing in their hand AKA its a new game, it will print that the new game number
                        }
                        randomCard = randomValue.nextInt(13) + 1;       // uses randomCard variable with a bound of 13 to select a value between 0 and 13.

                        if (randomCard >= 2 && randomCard <= 10) {
                            cardValue = randomCard;
                            cardDescription = "a " + Integer.toString(randomCard);
                            if (randomCard == 8) {
                                cardDescription = "an 8";      // eight starts with a vowel so its AN 8
                            }
                            else if (randomCard == 1) {                                  // 13 is the bound for randomCard, and it wont ever be 13+1 = 14
                                cardValue = randomCard;
                                cardDescription = "an ACE";    // ace starts with a vowel so its AN ACE
                            }
                        } else if (randomCard > 10 && randomCard <= 13) {
                            cardValue = 10;                                 // this makes the cardVALUE = 10 and the descriptions of the cards different
                            if (randomCard == 11) {
                                cardDescription = "a JACK";                 // randomcard and carddescription are different because the cardvalue will be added throughout runs of the looop
                            }
                            else if (randomCard == 12) {
                                cardDescription = "a QUEEN";
                            }
                            else if (randomCard == 13) {
                                cardDescription = "a KING";
                            }
                        }
                        userHandValue += cardValue;
                        System.out.println("Your card is " + cardDescription + "!");
                        System.out.println("Your hand is: " + userHandValue + "\n");
                        if (userHandValue == 21) {
                            System.out.println("BLACKJACK! You win! \n");
                            numUserWins += 1;
                            userHandValue = 0;
                            gameNumber += 1;
                            break;
                        }
                        else if (userHandValue > 21) {
                            System.out.println("You exceeded 21! You lose :( \n ");
                            numDealerWins += 1;
                            userHandValue = 0;
                            gameNumber += 1;
                            break;
                        }

                        break;

                    case 2:
                        dealerHand = randomValue.nextInt(11) + 16;
                        if (dealerHand < userHandValue && userHandValue < 21) {
                            System.out.println("Dealer's hand: " + dealerHand);
                            System.out.println("Your hand is: " + userHandValue + "\n");
                            System.out.println("You win! \n");
                            numUserWins += 1;
                            option = 1;
                            gameNumber += 1;
                            userHandValue = 0;
                            break;
                        }

                        else if (dealerHand > userHandValue && dealerHand < 21) {
                            System.out.println("Dealer's hand: " + dealerHand);
                            System.out.println("Your hand is: " + userHandValue + "\n");
                            System.out.println("Dealer wins! \n");
                            numDealerWins += 1;
                            option = 1;
                            gameNumber += 1;
                            userHandValue = 0;
                            break;
                        }

                        else if (dealerHand == userHandValue && userHandValue < 21) {
                            System.out.println("Dealer's hand: " + dealerHand);
                            System.out.println("Your hand is: " + userHandValue + "\n");
                            System.out.println("It's a tie! No one wins! \n");
                            userHandValue = 0;
                            numTies += 1;
                            gameNumber += 1;
                            option = 1;
                            break;
                        }

                        else if (dealerHand > 21 && userHandValue < 21) {
                            System.out.println("Dealer's hand: " + dealerHand);
                            System.out.println("Your hand is: " + userHandValue + "\n");
                            System.out.println("You win! \n");
                            userHandValue = 0;
                            numUserWins += 1;
                            gameNumber += 1;
                            option = 1;
                            break;
                        }


                    case 3:
                        System.out.println("Number of Player wins: " + numUserWins);
                        System.out.println("Number of Dealer wins: " + numDealerWins);
                        System.out.println("Number of tie games: " + numTies);
                        System.out.println("Total # of games played is: " + (gameNumber - 1));
                        winPercentage = (numUserWins / (double) (numDealerWins + numTies + numUserWins )) * 100;
                        if ((double) (numDealerWins + numTies + numUserWins ) ==0) {
                            winPercentage = 0;
                        }

                        NumberFormat formatter = new DecimalFormat("##0.0");
                        System.out.println("Percentage of Player wins: " + formatter.format(winPercentage) + "% \n");


                    case 4:
                        // nothing happens here... the code "dies" XD
                        break;


                    default:
                        if (option != 4) {
                            System.out.println("Invalid input!\nPlease enter an integer value between 1 and 4.\n");
                        }
                        break;

                }

        }while(option != 4);

    }


     static void Menu(){                    // the code refers to this method throughout 
        System.out.println("1. Get another card");
        System.out.println("2. Hold hand");
        System.out.println("3. Print statistics");
        System.out.println("4. Exit ");
        System.out.println("");
        System.out.println("Choose an option:  ");
        return;
    }


}