package CH10_SortingAndSearching.GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

public class GroupAnagrams_v2 {
    public static void sortChars(String[] array) {
        Hashtable<String, ArrayList<String>> mapList = new Hashtable<>();
        for (int i = 0; i < array.length; i++) {
            String key = sortChars(array[i]);
            if (!mapList.containsKey(key)) {
                ArrayList<String> temp = new ArrayList<>();
                mapList.put(key, temp);
            }
            mapList.get(key).add(array[i]);
        }

        // convert hash table to array
        int index = 0;
        for (String key : mapList.keySet()) {
            ArrayList<String > list = mapList.get(key);
            for (String str : list) {
                array[index++] = str;
            }
        }
    }

    public static String sortChars(String str) {
        char[] temp = str.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }
}
