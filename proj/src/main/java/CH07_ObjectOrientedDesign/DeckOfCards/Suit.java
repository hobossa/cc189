package CH07_ObjectOrientedDesign.DeckOfCards;

public enum Suit {
    Club(0), Diamond(1), Heart(2), Spade(3);
    private int value;

    private Suit(int v) {
        value = v;
    }

    public int getValue() {
        return value;
    }

    public static Suit getSuitFromValue(int value) {
        return switch (value) {
            case 0 -> Club;
            case 1 -> Diamond;
            case 2 -> Heart;
            case 3 -> Spade;
            default -> null;
        };
    }
}
