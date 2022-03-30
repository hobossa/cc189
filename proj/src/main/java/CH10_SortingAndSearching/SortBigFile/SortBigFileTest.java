package CH10_SortingAndSearching.SortBigFile;

// Sort Big File: Imagine you have a 20 GB file with one string per line. Explain how you would sort
// the file.
// Hints:#207


// Usually we should not put the whole file in the memory. It's too big.
// IMO, merge sort is a practical way to solve it.
// 1st, we split the Big file to small files which are small enough to load them into memory.
// 2nd, sort the lines in each small file.
// 3rd, merge the small file to get the sorted big file. (avoid loading whole into memory)

public class SortBigFileTest {
    public static void main(String[] args) {

    }
}
