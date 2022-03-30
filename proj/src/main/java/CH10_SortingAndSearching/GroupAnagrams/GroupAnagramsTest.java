package CH10_SortingAndSearching.GroupAnagrams;


// Group Anagrams: Write a method to sort an array of strings so that all the anagrams are next to 
// each other. 
// Hints: #177, #182, #263, #342

// #182. Two words are anagrams if they contain the same characters but in different orders.
// How can you put characters in order?

// #263. Can you leverage a standard sorting algorithm?

// #342. Do you even need to truly "sort"? Or is just reorganizing the list sufficient?

public class GroupAnagramsTest {
    public static void main(String[] args) {
        String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
        //GroupAnagrams_v1.sortChars(array);
        GroupAnagrams_v2.sortChars(array);
        for (String str : array) {
            System.out.println(str);
        }
    }
}
