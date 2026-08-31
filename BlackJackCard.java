//(c) A+ Computer Science
// www.apluscompsci.com
// Name - Shereen Qaralusi
// Date - 09/05/2023

public class BlackJackCard extends Card {
    // constructors
    public BlackJackCard() {}

    public BlackJackCard(int face, String suit)
    {
        super(face, suit);
    }

    @Override public int getValue()
    {
        // enables you to build the value for the game into the card
        // this makes writing the whole program a little easier
        if (super.getValue() == 1)
            return 11;
        if (super.getValue() == 10)
            return 10;
        return super.getValue();
    }
}