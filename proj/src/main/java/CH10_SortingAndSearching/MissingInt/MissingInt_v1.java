package CH10_SortingAndSearching.MissingInt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MissingInt_v1 {
    public static long numberOfInts = ((long) Integer.MAX_VALUE) + 1;
    public static byte[] bitfield = new byte[(int) (numberOfInts / 8)];

    public static int findOpenNumber(String inputFilename) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader(inputFilename));
        while (in.hasNextInt()) {
            int n = in.nextInt();
            // Finds the corresponding number in the bitfield by using the OR operator
            // to set the nth bit of a byte (e.g., 1- would correspond to bit 2 of index
            // 1 in the byte array).
            bitfield[n / 8] |= 1 << (n % 8);
        }

        for (int i = 0; i < bitfield.length; i++) {
            for (int j = 0; j < 8; j++) {
                if ((bitfield[i] & (1 << j)) == 0) {
                    //System.out.println(i * 8 + j);
                    return i * 8 + j;
                }
            }
        }
        return -1;
    }
}
