package edu.BlackJack21;

import edu.BlackJack21.Value;

public class Card {
private final Suit suit;
private final Value value;

public Card(Suit suit, Value value)
{   this.value=value;
    this.suit = suit;
}

    public String getValue()
    { return value.toString ();
    }
public String printValue(){
    return String.valueOf ( Value.ACE );
}
    public Suit getSuit()
    { return suit;
    }
public String getCardSuit(){
    return suit.toString ();
}
    public int getCardValue(){
    return value.getCardValue ();
}
public String toString(){
   String suit = String.valueOf ( getCardSuit () );
   String value = String.valueOf ( getValue () );
    return suit+value;
}

}
