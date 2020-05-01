package CardGames;

public class Game1 {
    static Deck deck = new Deck();

    static int deckLength = deck.startDeck.length;

    static Card[] player1 = new Card[deckLength];
    static Card[] player2 = new Card[deckLength];

    static int step = 0;
    static int currentCard = 0;
    static int pl1FreePlace = deckLength/2;
    static int pl2FreePlace = deckLength/2;

    public static void main(String[] args) {
        deck.newDeck();
        deck.mixDeck();
        System.out.println(deck.toString());

        for (int i = 0; i < deckLength / 2; i++) {
            player1[i] = deck.startDeck[i];
            player2[i] = deck.startDeck[i + deckLength / 2];
        }
        checkPlayersCards();
        mainGame(currentCard);
    }

    static void checkPlayersCards() {
        System.out.print("player1 cards: ");
        for (int i = 0; i < deckLength; i++) {
            if (player1[i] == null) {
                System.out.print(i + ",");
            } else {
                if (i == currentCard % deckLength) {
                    System.out.print("[" + player1[i] + "]");
                } else {
                    System.out.print(player1[i]);
                }
            }
        }
        System.out.print("\n" + "player2 cards: ");
        for (int i = 0; i < deckLength; i++) {
            if (player2[i] == null) {
                System.out.print(i + ",");
            } else {
                if (i == currentCard % deckLength) {
                    System.out.print("[" + player2[i] + "]");
                } else {
                    System.out.print(player2[i]);
                }
            }
        }
        System.out.println("\n");
    }

    static void player1TakesCards(int stCount) {
        int previousCard;
        if (stCount == 0) {
            previousCard = 35;
        } else {previousCard = stCount - 1;}
        if (player1[previousCard] != null) {
                player1TakesCards(previousCard);
            }
        player1[pl1FreePlace++ % player1.length] = player1[stCount];
        player1[pl1FreePlace++ % player1.length] = player2[stCount];
        System.out.printf("player1 takes cards:%s and%s from %d to %d and %d%n", player1[stCount], player2[stCount], stCount, (pl1FreePlace-2) % deckLength, (pl1FreePlace-1) % deckLength);
        player1[stCount] = null;
        player2[stCount++] = null;
        currentCard = stCount;
    }

    static void player2TakesCards(int stCount) {
        int previousCard;
        if (stCount == 0) {
            previousCard = 35;
        } else {previousCard = stCount - 1;}
        if (player2[previousCard] != null) {
            player2TakesCards(previousCard);
        }
        player2[pl2FreePlace++ % player1.length] = player1[stCount];
        player2[pl2FreePlace++ % player1.length] = player2[stCount];
        System.out.printf("player2 takes cards:%s and%s from %d to %d and %d%n", player1[stCount], player2[stCount], stCount, (pl2FreePlace-2) % deckLength, (pl2FreePlace-1) % deckLength);
        player1[stCount] = null;
        player2[stCount++] = null;
        currentCard = stCount;
    }

    static void mainGame(int stCount) {
        System.out.println(++step);
        checkPlayersCards();
        if (player1[stCount % deckLength] == null) {
            System.out.println("player2 wins");
        } else if (player2[stCount % deckLength] == null) {
            System.out.println("player1 wins");
        } else {
            int stepResult = player1[stCount].getPower() - player2[stCount].getPower();
            switch (stepResult) {
                case (-8):
                    player1TakesCards(stCount);
                    break;
                case (0):
                    currentCard += 2;
                    break;
                case (8):
                    player2TakesCards(stCount);
                    break;
                default:
                    if (stepResult > 0) {
                        player1TakesCards(stCount);
                    } else {
                        player2TakesCards(stCount);
                    }
            }
            mainGame(currentCard % deck.startDeck.length);
            }
        }
    }
