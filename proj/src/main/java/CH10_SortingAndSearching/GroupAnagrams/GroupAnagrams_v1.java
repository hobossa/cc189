package CH10_SortingAndSearching.GroupAnagrams;

import java.util.Arrays;

public class GroupAnagrams_v1 {
    public static void sortChars(String[] array) {
        Arrays.sort(array, (a, b) -> sortChars(a).compareTo(sortChars(b)));
    }

    public static String sortChars(String str) {
        char[] temp = str.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }
}
