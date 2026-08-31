//(c) A+ Computer Science
// www.apluscompsci.com
// Name - Shereen Qaralusi
// Date - 09/05/2023

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    public static final int NUMFACES = 13;
    public static final int NUMSUITS = 4;
    public static final int NUMCARDS = 52;

    public static final String SUITS[] = {"CLUBS", "SPADES", "DIAMONDS", "HEARTS"};

    private int topCardIndex;
    private ArrayList<Card> stackOfCards;

    public Deck()
    {
        // initialize data - stackOfCards - topCardIndex
        stackOfCards = new ArrayList<>();

        // loop through suits
        // loop through faces
        // add in a new card
        for (int s = 0; s < NUMSUITS; s++)
        {
            for (int f = 1; f <= NUMFACES; f++)
            {
                stackOfCards.add(new BlackJackCard(f, SUITS[s]));
            }
        }
        topCardIndex = stackOfCards.size() - 1;
    }

    // modifiers
    public void shuffle()
    {
        // shuffle the deck
        // reset variables as needed
        Collections.shuffle(stackOfCards);
        topCardIndex = stackOfCards.size() - 1;
    }

    // accessors
    public int size()
    {
        return stackOfCards.size();
    }

    public int numCardsLeft()
    {
        return topCardIndex + 1;
    }

    public Card nextCard()
    {
        return stackOfCards.get(topCardIndex--);
    }

    public String toString()
    {
        return stackOfCards + "   topCardIndex = " + topCardIndex;
    }
}