package CH16_Moderate.WordFrequencies;

// Word Frequencies: Design a method to find the frequency of occurrences of any given word in a
// book. What if we were running this algorithm multiple times?
// Hints: #489, #536

public class WordFrequenciesTest {

    public static void main(String[] args) {
        String[] words = {"the", "Lara", "and", "outcropping", "career", "it"};
        WordFrequencies_v2 v2 = new WordFrequencies_v2(words);
        for (String word : words) {
            System.out.println(word + ": " + WordFrequencies_v1.getFrequency(words, word));
            System.out.println(word + ": " + v2.getFrequency(word));
        }
    }
}
