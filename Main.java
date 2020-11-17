package edu.BlackJack21;


import java.util.Scanner;

public class Main {

    public static void main(String[] args)

    {
        //Player money
        double money = 100.00;


        //GameStart
        System.out.println ( "WeLCOMe To BlaCk JaCk!!!" );
        Deck playingDeck = new Deck ();
        playingDeck.createFullDeck ();
        playingDeck.shuffle ();
        Deck playerDeck = new Deck ();
        Deck player2Deck = new Deck ();
        Scanner userInput = new Scanner ( System.in );

        //GameLoop
        while (money > 0) {
            System.out.println ( "You have:$" + money + "How much would you like to bet?" );
            double plaYerBet = userInput.nextDouble ();
            if (plaYerBet > money) {
                System.out.println ( "You Cannot Bet MORE THAN YOU HAVE!!!" );
                break;
            }


            playerDeck.draw ( playingDeck );
            playerDeck.draw ( playingDeck );

            player2Deck.draw ( playingDeck );
            player2Deck.draw ( playingDeck );


            boolean endRound = false;
            
            while (true) {
                System.out.println ( "Your Hand:" );
                System.out.print ( playerDeck.toString () + "\n" + "value:" + playerDeck.getTotal () );
                System.out.println ( "\nplayer 2 Deck" +"\n"+ player2Deck.getCard ( 0 ) + "(HIDDEN)" );
                System.out.println ( "Would You Like Hit(1) Or Stand(2)?" );
                int response = userInput.nextInt ();
                if (response == 1) {
                    playerDeck.draw ( playingDeck );
                    System.out.println ( "You draw:" + playerDeck.getCard ( playerDeck.getDeckCard () - 1 ).toString () );

                    if (playerDeck.getTotal () > 21) {
                        System.out.println ( "bust" + "Total value is:" + playerDeck.getTotal ()
                                + "player2 have{" + player2Deck.getTotal ()+"}" );
                        money -= plaYerBet;
                        endRound = true;
                    }
                }

                if (response == 2) {
                    break;
                }
            }
            System.out.println ( "Player 2 cards:" + player2Deck.toString () );


            if ((player2Deck.getTotal () > playerDeck.getTotal ()) && !endRound) {
                System.out.println ( "Player 2 Won" );
                money -= plaYerBet;
                endRound = true;
            }
            while ((player2Deck.getTotal () < 17) && !endRound) {
                player2Deck.draw ( playingDeck );
                System.out.println ( "{"
                        + player2Deck.getCard ( player2Deck.getDeckCard () - 1 ).toString ()+"}" );

            }
            if ((player2Deck.getTotal () > 21) && !endRound) {
                System.out.println ( "You win" );
                money += plaYerBet;
                endRound = true;
            }

            if (player2Deck.getTotal () == playerDeck.getTotal ()&&!endRound) {
                System.out.println ( "Push" );
                endRound = true;

            }

            if (playerDeck.getTotal () > player2Deck.getTotal () && !endRound) {
                System.out.println ( "You Won the Hand !!!" );
                money += plaYerBet;
                endRound = true;
            }

            else if (!endRound){
                System.out.println ("You loose");
                money-=plaYerBet;
                endRound = true;
            }

            playerDeck.moveAllToDeck ( playingDeck );
            player2Deck.moveAllToDeck ( playingDeck );
        }
        System.out.println("GAME OVER!!!");
    }

}



