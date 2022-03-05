package CH07_ObjectOrientedDesign.DeckOfCards;

import java.util.ArrayList;
import java.util.Collections;

public class Deck<T extends Card> {
    private ArrayList<T> cards; // all cards, dealt or not
    private int dealIndex = 0; // marks first undealt card

    public void setDeckOfCards(ArrayList<T> deckOfCards) {
        cards = deckOfCards;
    }

    public void shuffle() {
        if (cards != null) {
            Collections.shuffle(cards);
        }
    }

    public int remainingCards() {
        return cards.size() - dealIndex;
    }

    @SuppressWarnings("unchecked")
    public T[] dealHand(int number) {
        if (remainingCards() < number) {
            return null;
        }
        T[] hand = (T[]) new Card[number];
        int count = 0;
        while (count < number) {
            T card = dealCard();
            if (card != null) {
                hand[count++] = card;
            }
        }
        return hand;
    }

    @SuppressWarnings("unchecked")
    public T dealCard() {
        if (remainingCards() == 0) {
            return null;
        }
        T card = cards.get(dealIndex);
        card.markUnavailable();
        dealIndex++;
        return card;
    }

    public void print() {
        for (Card card : cards) {
            card.print();
        }
    }
}

