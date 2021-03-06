package CH07_ObjectOrientedDesign.DeckOfCards;

public abstract class Card {
    private boolean available = true;

    // Number of face that's on card - a number 2 through 10,
    // or 11 for Jack, 12 for Queen, 13 for King, or 1 for Ace
    protected int faceValue;
    protected Suit suit;

    public Card(int c, Suit s) {
        this.faceValue = c;
        this.suit = s;
    }

    public abstract int value();

    public Suit suit() {
        return suit;
    }

    // Checks if the card is available to be given out to someone
    public boolean isAvailable() {
        return available;
    }

    public void markUnavailable() {
        available = false;
    }

    public void markAvailable() {
        available = true;
    }

    public void print() {
        String[] faceValues = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        System.out.print(faceValues[faceValue - 1]);
        switch (suit) {
            case Club -> System.out.print("c");
            case Heart -> System.out.print("h");
            case Diamond -> System.out.print("d");
            case Spade -> System.out.print("s");
        }
        System.out.print(" ");
    }
}
