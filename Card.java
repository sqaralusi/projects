//(c) A+ Computer Science
// www.apluscompsci.com
// Name - Shereen Qaralusi
// Date - 09/05/2023

public class Card {
    public static final String FACES[] = {"ZERO",  "ACE",   "TWO",  "THREE", "FOUR", "FIVE",  "SIX",
                                          "SEVEN", "EIGHT", "NINE", "TEN",   "JACK", "QUEEN", "KING"};
    private int face;
    private String suit;

    // constructors
    public Card()
    {
        this(0, " ");
    }
    public Card(int face, String suit)
    {
        this.face = face;
        this.suit = suit;
    }

    // modifiers
    public void setFace(int face)
    {
        this.face = face;
    }

    public void setSuit(String suit)
    {
        this.suit = suit;
    }

    // accessors

    public int getValue()
    {
        if (face >= 10)
        {
            return 10;
        }
        else if (face == 1)
        {
            return 11;
        }
        else
        {
            return face;
        }
    }

    @Override public boolean equals(Object obj)
    {
        Card other = (Card) obj;
        if (suit.equals(other.suit) && face == other.face)
        {
            return true;
        }
        return false;
    }

    // toString
    @Override public String toString()
    {
        return FACES[face] + " of " + suit + " | value = " + getValue();
    }
}