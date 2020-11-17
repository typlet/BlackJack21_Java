package edu.BlackJack21;

public enum Suit {
    SPADES,HEARTS, DIAMOND,CLUB;


    public String toString(){
        switch (this){
            case CLUB:
                return "♣";
            case DIAMOND:
                return "♦";
            case HEARTS:
                return "♥";
            case SPADES:
                return "♠";
        }
  return "Nothing to show:☻♦☺♣☺♥☻";
    }
}
