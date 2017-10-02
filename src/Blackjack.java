import java.util.*;
import java.text.*;

public class Blackjack {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        Random randGen = new Random();
        int option = 1;
        int randomCard;
        int cardValue = 0;
        String cardName = "";
        int userHandValue = 0;
        int dealerHand;
        int gameNumber = 1;
        int numUserWins = 0;
        int numDealerWins = 0;
        int numTies = 0;
        double winPercentage;
        boolean improperResponse = false;

        do{
            if (userHandValue > 0) {
                Menu();
                try {
                    option= scnr.nextInt();
                }
                catch (InputMismatchException Error) {
                    System.out.println("Invalid input!\nPlease enter an integer value between 1 and 4.\n");
                        Menu();
                    scnr.nextLine();
                }
            }
            if (!improperResponse) {
                switch (option) {
                    case 1:
                        if (userHandValue == 0) {
                            System.out.println("START GAME #" + gameNumber + "\n");
                        }
                        randomCard = randGen.nextInt(13) + 1;
                        if (randomCard == 1) {
                            cardValue = randomCard;
                            cardName = "an ACE";
                        } else if (randomCard >= 2 && randomCard <= 10) {
                            cardValue = randomCard;
                            cardName = "a " + Integer.toString(randomCard);
                            if (randomCard == 8) {
                                cardName = "an 8";
                            }
                        } else if (randomCard > 10 && randomCard <= 13) {
                            cardValue = 10;
                            if (randomCard == 11) {
                                cardName = "a JACK";
                            } else if (randomCard == 12) {
                                cardName = "a QUEEN";
                            } else if (randomCard == 13) {
                                cardName = "a KING";
                            }
                        }
                        userHandValue += cardValue;
                        System.out.println("Your card is " + cardName + "!");
                        System.out.println("Your hand is: " + userHandValue + "\n");
                        if (userHandValue == 21) {
                            System.out.println("BLACKJACK! You win! \n");
                            numUserWins += 1;
                            userHandValue = 0;
                            gameNumber += 1;
                            break;
                        } else if (userHandValue > 21) {
                            System.out.println("You exceeded 21! You lose :( \n ");
                            numDealerWins += 1;
                            userHandValue = 0;
                            gameNumber += 1;
                            break;
                        }
                        break;
                    case 2:
                        dealerHand = randGen.nextInt(11) + 16;
                        if (dealerHand < userHandValue && userHandValue < 21) {
                            System.out.println("Dealer's hand: " + dealerHand);
                            System.out.println("Your hand is: " + userHandValue + "\n");
                            System.out.println("You win! \n");
                            userHandValue = 0;
                            numUserWins += 1;
                            gameNumber += 1;
                            option = 1;
                            break;
                        } else if (dealerHand > userHandValue && dealerHand < 21) {
                            System.out.println("Dealer's hand: " + dealerHand);
                            System.out.println("Your hand is: " + userHandValue + "\n");
                            System.out.println("Dealer wins! \n");
                            userHandValue = 0;
                            numDealerWins += 1;
                            gameNumber += 1;
                            option = 1;
                            break;
                        } else if (dealerHand == userHandValue && userHandValue < 21) {
                            System.out.println("Dealer's hand: " + dealerHand);
                            System.out.println("Your hand is: " + userHandValue + "\n");
                            System.out.println("It's a tie! No one wins! \n");
                            userHandValue = 0;
                            numTies += 1;
                            gameNumber += 1;
                            option = 1;
                            break;
                        } else if (dealerHand > 21 && userHandValue < 21) {
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
                        winPercentage = (numUserWins / (double) (numUserWins + numDealerWins + numTies)) * 100;
                        if (numUserWins + numDealerWins + numTies == 0){
                            winPercentage = 0 ;
                        }
                        NumberFormat formatter = new DecimalFormat("##0.0");
                        System.out.println("Percentage of Player wins: " + formatter.format(winPercentage) + "% \n");
                        break;
                    default:

                        if (option != 4) {
                            System.out.println("Invalid input!\nPlease enter an integer value between 1 and 4.\n");
                        }

                        break;
                }

            }

        }while(option != 4);

    }
    public static void Menu(){
        System.out.println("1. Get another card");
        System.out.println("2. Hold hand");
        System.out.println("3. Print statistics");
        System.out.println("4. Exit \n");
        System.out.println("Choose an option:  ");

        return;
    }


}