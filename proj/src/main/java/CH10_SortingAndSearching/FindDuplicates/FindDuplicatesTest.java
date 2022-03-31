package CH10_SortingAndSearching.FindDuplicates;

// Find Duplicates: You have an array with all the numbers from 1 to N, where N is at most 32,000. The
// array may have duplicate entries, and you do not know what N is. With only 4 kilobytes of memory
// available, how would you print all duplicate elements in the array?
// Hints:#289, #315

public class FindDuplicatesTest {

    public static void main(String[] args) {
        int[] array= {1,2,3,4,5,6,7,8,9,3,2,123,5,765,123};
        FindDuplicates_v1.printDuplicates(array);
    }
}
