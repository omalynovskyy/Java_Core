package CardGames;

import java.util.concurrent.Callable;

public class Game1 {
    static Deck deck = new Deck();

    static Card[] player1 = new Card[deck.startDeck.length];
    static Card[] player2 = new Card[deck.startDeck.length];

    static int stepCount = 0;
    static int pl1FreePlace = player1.length/2;
    static int pl2FreePlace = player2.length/2;
    

    public static void main(String[] args) {
        deck.newDeck();
        deck.mixDeck();
        System.out.println(deck.toString());

        for(int i =0; i < deck.startDeck.length/2; i++){
            player1[i] = deck.startDeck[i];
            player2[i] = deck.startDeck[i + deck.startDeck.length/2];
        }
        System.out.println("player1 cards");
        for (int i = 0; i < player1.length; i++) {
            System.out.print(player1[i] + "; ");
        }
        System.out.println("\n" + "player2 cards");
        for (int i = 0; i < player1.length; i++) {
            System.out.print(player2[i] + "; ");
        }

        mainGame(stepCount, pl1FreePlace, pl2FreePlace);

    }
    
    static void player1TakesCards(int stCount, int p1FreePlace) {
        player1[p1FreePlace++ % player1.length] = player1[stCount];
        player1[p1FreePlace++ % player1.length] = player2[stCount];
        player1[stCount] = null;
        player2[stCount] = null;
        System.out.println("player1 takes cards");
        if (stCount <= 0) {
            if (player1[stCount + player1.length - 1] == null) {
                mainGame(stepCount++ % player1.length, pl1FreePlace, pl2FreePlace);
            } else {
                player1TakesCards(stCount - 1, p1FreePlace);
            }
        } else {
            if (player1[stCount - 1] == null) {
                mainGame(stepCount++ % player1.length, pl1FreePlace, pl2FreePlace);
            } else {
                player1TakesCards(stCount - 1, p1FreePlace);
            }
        }
    }

    static void player2TakesCards(int stCount, int p2FreePlace){
        if (player2[stCount] == null) return;
        player2[p2FreePlace++ % player1.length] = player1[stCount];
        player1[p2FreePlace++ % player1.length] = player2[stCount];
        player1[stCount] = null;
        player2[stCount] = null;
        System.out.println("player2 takes cards");
        if (stCount <= 0) {
            if (player2[stCount + player1.length - 1] == null) {
                mainGame(stepCount++ % player1.length, pl1FreePlace, pl2FreePlace);
            } else {
                player2TakesCards(stCount - 1, p2FreePlace);
            }
        } else {
            if (player2[stCount - 1] == null) {
                mainGame(stepCount++ % player1.length, pl1FreePlace, pl2FreePlace);
            } else {
                player2TakesCards(stCount - 1, p2FreePlace);
            }
        }
    }


    static void mainGame(int stepCount, int pl1FreePlace, int pl2FreePlace){
        int stepResult = player1[stepCount].getPower() - player2[stepCount].getPower();
        if (player1[stepCount] == null){
            System.out.println("player2 wins");
        } else if (player2[stepCount] == null){
            System.out.println("player1 wins");
        } else if (stepResult > 0){
            if(stepResult < 8){
                player1TakesCards(stepCount, pl1FreePlace);
                mainGame(stepCount % player1.length, pl1FreePlace, pl2FreePlace);
            }
            player2TakesCards(stepCount, pl2FreePlace);
        } else if (stepResult < 0){
            if (stepResult > -8){
                player2TakesCards(stepCount, pl2FreePlace);
            }
            player1TakesCards(stepCount, pl1FreePlace);
        }
        mainGame((stepCount+2) % deck.startDeck.length, pl1FreePlace, pl2FreePlace);
        
    }
}
