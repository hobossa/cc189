package CH10_SortingAndSearching.MissingInt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MissingInt_v2 {

    public static int findOpenNumber(String inputFilename) throws FileNotFoundException {
        int rangeSize = (1 << 20);  // 2^20 bits (2^17 bytes)

        // Get count of number of values within each block
        int[] blocks = getCountPerBlock(inputFilename, rangeSize);

        // Find a block with a missing value
        int blockIndex = findBlockWithMissing(blocks, rangeSize);
        if (blockIndex < 0) {
            return -1;
        }

        // Create bit vector for items within this range
        byte[] bitVector = getBitVectorForRange(inputFilename, blockIndex, rangeSize);

        // Find a zero in the bit vector
        int offset = findZero(bitVector);
        if (offset < 0) {
            return -1;
        }

        // Compute missing value
        return blockIndex * rangeSize + offset;

    }

    private static int findZero(byte[] bitVector) {
        for (int i = 0; i < bitVector.length; i++) {
            if (bitVector[i] != ~0) {
                // If not all 1s
                int bitIndex = findZero(bitVector[i]);
                return i * Byte.SIZE + bitIndex;
            }
        }
        return -1;
    }

    private static int findZero(byte b) {
        for (int i = 0; i < Byte.SIZE; i++) {
            int mask = 1 << i;
            if ((b & mask) == 0) {
                return i;
            }
        }
        return -1;
    }

    private static byte[] getBitVectorForRange(String inputFilename, int blockIndex, int rangeSize) throws FileNotFoundException {
        int startRange = blockIndex * rangeSize;
        int endRange = startRange + rangeSize;
        byte[] bitVector = new byte[rangeSize / Byte.SIZE];

        Scanner in = new Scanner(new FileReader(inputFilename));
        while (in.hasNextInt()) {
            int value = in.nextInt();
            if (startRange <= value && value < endRange) {
                int offset = value - startRange;
                int mask = (1 << (offset % Byte.SIZE));
                bitVector[offset / Byte.SIZE] |= mask;
            }
        }
        in.close();
        return bitVector;
    }

    private static int findBlockWithMissing(int[] blocks, int rangeSize) {
        for (int i = 0; i < blocks.length; i++) {
            if (blocks[i] < rangeSize) {
                return i;
            }
        }
        return -1;
    }

    private static int[] getCountPerBlock(String inputFilename, int rangeSize) throws FileNotFoundException {
        int arraySize = Integer.MAX_VALUE / rangeSize + 1;
        int[] blocks = new int[arraySize];

        Scanner in = new Scanner(new FileReader(inputFilename));
        while (in.hasNextInt()) {
            int value = in.nextInt();
            blocks[value/rangeSize]++;
        }
        in.close();
        return blocks;
    }
}
