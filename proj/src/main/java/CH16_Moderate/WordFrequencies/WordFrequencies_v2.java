package CH16_Moderate.WordFrequencies;

import java.util.Hashtable;

public class WordFrequencies_v2 {
    private Hashtable<String, Integer> table;

    public WordFrequencies_v2(String[] book) {
        this.table = new Hashtable<>();
        for (String word : book) {
            word = word.trim().toLowerCase();
            this.table.put(word, 1 + this.table.getOrDefault(word, 0));
        }
    }

    public int getFrequency(String word) {
        if (word == null) return 0;
        return this.table.getOrDefault(word.trim().toLowerCase(), 0);
    }
}
