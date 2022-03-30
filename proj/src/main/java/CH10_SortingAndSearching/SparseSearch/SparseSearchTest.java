package CH10_SortingAndSearching.SparseSearch;

// Sparse Search: Given a sorted array of strings that is interspersed with empty strings, write a
// method to find the location of a given string.
// EXAMPLE
// Input: ball, {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}
// Output: 4
// Hints: #256

public class SparseSearchTest {
    public static void main(String[] args) {
        String[] stringList = {"apple", "", "", "banana", "", "", "", "carrot", "duck", "", "", "eel", "", "flower"};
        System.out.println(SparseSearch_v1.search(stringList, "ac"));
        String[] keys = {"apple", "banana", "carrot", "duck", "eel", "flower"};
        for (String key : keys) {
            System.out.println(SparseSearch_v1.search(stringList, key));
        }
    }
}
