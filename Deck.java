package edu.BlackJack21;

import edu.BlackJack21.Card;
import edu.BlackJack21.Suit;
import edu.BlackJack21.Value;

import java.util.ArrayList;
import java.util.Random;

public class Deck{
    
    private ArrayList<Card> cards;
    
    public Deck()
    {
        this.cards = new ArrayList<>();
    }
    
    public void createFullDeck()
    {
        for(Suit cardSuit : Suit.values()){
            for(Value cardValue : Value.values()){
                this.cards.add(new Card(cardSuit, cardValue));
            }
        }
        
    }
    
    public void shuffle()
    {
        ArrayList<Card> tmpDeck = new ArrayList<>();
        Random random = new Random();
        int randomCardIndex;
        int originalSize = this.cards.size();
        
        
        for(int i = 0; i < originalSize; i++){
            
            randomCardIndex = random.nextInt((this.cards.size()));
            tmpDeck.add(this.cards.get(randomCardIndex));
            cards.remove(randomCardIndex);
        }
        this.cards = tmpDeck;
    }
    
    public void removeCard(int i)
    {
        this.cards.remove(i);
    }
    
    public Card getCard(int i)
    {
        return this.cards.get(i);
    }
    
    public void addCard(Card addCard)
    {
        this.cards.add(addCard);
    }
    
    public int getDeckCard()
    {
        return cards.size();
    }
    
    public void draw(Deck comingFrom)
    {
        this.cards.add(comingFrom.getCard(0));
        comingFrom.removeCard(0);
    }
    
    public int getTotal()
    {
        int totalPts = 0;
        boolean hasAce = false;
        for(int i = 0; i < cards.size(); i++){
            totalPts += cards.get(i).getCardValue();
            if(cards.get(i).printValue() .equals( "ACE")){
                hasAce = true;
            }
            if(hasAce && totalPts <= 11){
                totalPts += 10;
            }
        }
        return totalPts;
    }
    
    public void moveAllToDeck(Deck moveTo)
    {
        int thisDeckSize = this.cards.size();
        for(int i = 0; i < thisDeckSize; i++){
            moveTo.addCard(this.getCard(i));
        }
        for(int i = 0; i < thisDeckSize; i++){
            this.removeCard(0);
            
        }
    }
    
    @Override
    public String toString()
    {
        StringBuilder cardListOutput =new StringBuilder();
        for(Card aCard : this.cards){
           
           cardListOutput.append( "\n {" + aCard.toString()+"}");
        }
        
        return cardListOutput.toString();
    }
    
}
