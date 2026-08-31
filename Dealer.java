//(c) A+ Computer Science
// www.apluscompsci.com
// Name - Shereen Qaralusi
// Date - 09/05/2023

import java.util.ArrayList;
import java.util.Collections;

public class Dealer extends Player {
    // Define a deck of cards
    private Deck deck;

    public Dealer() {
        deck = new Deck();
        deck.shuffle();
    }

    public void shuffle() {
        // Shuffle the deck
        deck.shuffle();
    }

    public Card deal() {
        Card card = deck.nextCard();
        addCardToHand(card);
        return card;
    }

    public int numCardsLeftInDeck() {
        return deck.numCardsLeft();
    }

    @Override
    public int getHandValue() {
        int value = 0;
        boolean hasAce = false;

        for (Card card : hand) {
            value += card.getValue();
            if (card.getValue() == 11) {
                hasAce = true;
            }
        }

        if (value > 21 && hasAce) {
            value -= 10;
        }

        return value;
    }

    @Override
    public int getHandSize() {
        return hand.size();
    }

    @Override
    public String toString() {
        StringBuilder handString = new StringBuilder();
        handString.append("hand = [");
        for (Card card : hand) {
            handString.append(card).append(" | ");
        }
        handString.append("] - ").append(getHandValue());
        return handString.toString();
    }
}