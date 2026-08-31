//(c) A+ Computer Science
// www.apluscompsci.com
// Name - Shereen Qaralusi
// Date - 09/05/2023

import java.util.Scanner;

public class BlackJack {

    private Dealer dealer;
    private Player player;

    public BlackJack() {
        dealer = new Dealer();
        player = new Player();
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            player.addCardToHand(dealer.deal());
            player.addCardToHand(dealer.deal());
            dealer.addCardToHand(dealer.deal());
            dealer.addCardToHand(dealer.deal());

            System.out.println("Current hand " + player);
            System.out.print("Do you want to hit? [Y/N] ");
            String input = scanner.next().toUpperCase();

            while (input.equals("Y") && player.getHandValue() < 21) {
                player.addCardToHand(dealer.deal());
                System.out.println(player);
                if (player.getHandValue() < 21) {
                    System.out.print("Do you want to hit? [Y/N] ");
                    input = scanner.next().toUpperCase();
                } else {
                    break;
                }
            }

            int playerHandValue = player.getHandValue();
            int dealerHandValue = dealer.getHandValue();

            System.out.println("\nPLAYER ");
            System.out.println("Hand Value :: " + playerHandValue);
            System.out.println("Hand Size :: " + player.getHandSize());
            System.out.println("Cards in Hand :: " + player);
            System.out.println("\nDEALER");
            System.out.println("Hand Value :: " + dealerHandValue);
            System.out.println("Hand Size :: " + dealer.getHandSize());
            System.out.println("Cards in Hand :: " + dealer);

            while (dealer.hit()) {
                dealer.addCardToHand(dealer.deal());
            }

            playerHandValue = player.getHandValue();
            dealerHandValue = dealer.getHandValue();

            if (dealerHandValue > 21 || playerHandValue > dealerHandValue) {
                System.out.println("\nPlayer has a bigger hand value!");
                player.incrementWinCount();
            } else if (dealerHandValue > playerHandValue) {
                System.out.println("\nDealer has a bigger hand value!");
                dealer.incrementWinCount();
            } else {
                System.out.println("\nIt's a tie!");
            }

            System.out.println("\nDealer has won " + dealer.getWinCount() + " times.");
            System.out.println("Player has won " + player.getWinCount() + " times.");

            System.out.print("\nDo you want to play again? [Y,y,N,n] ");
            input = scanner.next().toUpperCase();
            if (!input.equals("Y")) {
                playAgain = false;
            }

            // Reset hands for a new game
            player.resetHand();
            dealer.resetHand();
        }
    }

    public static void main(String[] args) {
        BlackJack game = new BlackJack();
        game.playGame();
    }
}