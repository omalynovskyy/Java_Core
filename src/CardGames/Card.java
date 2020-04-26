package CardGames;

public class Card {
    private Suite suite;
    private int power;

    public Card() {
    }

    public Card(Suite suite, int power) {
        this.suite = suite;
        this.power = power;
    }

    public Suite getSuite() {
        return suite;
    }

    public void setSuite(Suite suite) {
        this.suite = suite;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
