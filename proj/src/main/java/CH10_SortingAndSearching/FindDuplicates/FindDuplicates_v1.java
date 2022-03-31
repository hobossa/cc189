package CH10_SortingAndSearching.FindDuplicates;

public class FindDuplicates_v1 {

    public static void printDuplicates(int[] array) {
        byte[] bitfield = new byte[4000];  //
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 1 && array[i] <= 32000) {
                if (1 == getBit(bitfield, array[i] - 1)) {
                    System.out.println(array[i]);
                }
                setBit(bitfield, array[i] - 1);
            }
        }
    }

    private static void setBit(byte[] bitfield, int n) {
        int mask = 1 << (n % 8);
        bitfield[n / 8] |= mask;
    }

    private static int getBit(byte[] bitfield, int n) {
        int mask = 1 << (n % 8);
        if (0 == (bitfield[n / 8] & mask)) {
            return 0;
        }
        return 1;
    }
}
