package edu.BlackJack21;

public enum Value {
    TWO(2),THREE(3),FOUR(4),FIVE(5)
    , SIX(6),SEVEN(7),EIGHT(8),NINE(9)
    ,TEN(10),JACK(10),QUEEN(10),KING(10)
    ,ACE(1);
    private final int cardValue;
    Value(int cardValue){
        this.cardValue=cardValue;
    }

    public int getCardValue()
    {
        return cardValue;
    }

    @Override
    public String toString()
    { switch (this){

        case JACK:
            //return"JACk";
        case QUEEN:
            //return"QUEEN";
        case KING:
            //return"KING";
        case ACE:
            //return"ACE";
            return super.toString ().substring ( 0,1);
        default:
            return String.valueOf ( getCardValue () );
    }

    }
}




