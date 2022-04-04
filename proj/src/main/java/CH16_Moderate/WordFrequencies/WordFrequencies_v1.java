package CH16_Moderate.WordFrequencies;

import java.util.Locale;

public class WordFrequencies_v1 {
    public static int getFrequency(String[] book, String word) {
        word = word.trim().toLowerCase();
        int count = 0;
        for ( String s : book) {
            if (s.trim().toLowerCase().equals(word)) {
                count++;
            }
        }
        return count;
    }
}
