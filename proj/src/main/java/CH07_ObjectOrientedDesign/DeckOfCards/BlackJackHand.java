package CH07_ObjectOrientedDesign.DeckOfCards;

import java.util.ArrayList;

public class BlackJackHand extends Hand<BlackJackCard> {
    // There are multiple possible scores for a blackjack hand, since aces have multiple values.
    // Return the highest possible score that's under21, or the lowest sore that's over.
    public int score() {
        int maxUnder = Integer.MIN_VALUE;
        int minOver = Integer.MAX_VALUE;
        for (int score : possibleScores()) {
            if (score > 21 && score < minOver) {
                minOver = score;
            } else if (score <= 21 && score > maxUnder) {
                maxUnder = score;
            }
        }
        return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
    }

    // return a list of all possible scores hand could have (evaluating each ace as both 1 and 11
    private ArrayList<Integer> possibleScores() {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(0);
        for (BlackJackCard card : cards) {
            addCardToScoreList(card, scores);
        }
        return scores;
    }

    private void addCardToScoreList(BlackJackCard card, ArrayList<Integer> scores) {
        int n = scores.size();
        for (int i = 0; i < n; i++) {
            if (card.isAce()) {
                int s = scores.get(i);
                scores.set(i, 1 + s);
                scores.add(i, 11 + s);
            } else {
                scores.set(i, scores.get(i) + card.value());
            }
        }
    }

    public boolean busted() {
        return score() > 21;
    }

    public boolean is21() {
        return score() == 21;
    }

    public boolean isBlackJack() {
        if (cards.size() != 2) {
            return false;
        }
        BlackJackCard first = cards.get(0);
        BlackJackCard second = cards.get(1);
        return ((first.isAce() && second.isFaceCard())
                || (second.isAce()) && first.isFaceCard());
    }
}
