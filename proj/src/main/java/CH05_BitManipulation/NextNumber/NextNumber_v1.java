package CH05_BitManipulation.NextNumber;

public class NextNumber_v1 {
    public static final int SEQUENCE_LENGTH = 31;

    // similar to https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2005.%20Bit%20Manipulation/Q5_04_Next_Number/QuestionB.java
    // and the solution is more arithmetical (https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2005.%20Bit%20Manipulation/Q5_04_Next_Number/QuestionC.java)
    // return -1 if there is no such a number.
    public static int getNext(int i) {
        int lowestOnePos = positionOfNextOne(i, 0);
        if (-1 == lowestOnePos) {
            return -1;
        }
        int zeroPos = positionOfNextZero(i, lowestOnePos+1);
        if (-1 == zeroPos) {
            return -1;
        }
        // swap zeroPos with zeroPos-1
        i = setBit(i, zeroPos);
        i = clearBit(i, zeroPos-1);
        // count how many 1s through zeroPos-2 to 0
        int p = zeroPos -2;
        int count = 0;
        while (p >= 0) {
            if ( ((1<<p) & i) != 0) {
                count++;
            }
            p--;
        }
        // move all these 1 to the lowest bit. eg., 0101 0100 -> 0000 0111
        int m = -1 << count;
        m = ~m;
        i = (i & (-1 << (zeroPos-1))) | m;

        return i;
    }

    public static int getPrev(int i) {
        int lowestZeroPos = positionOfNextZero(i, 0);
        if (-1 == lowestZeroPos) {
            return -1;
        }
        int onePos = positionOfNextOne(i, lowestZeroPos+1);
        if (-1 == onePos) {
            return -1;
        }
        int zeroPos = positionOfPrevZero(i, onePos);
        // swap these 2 bit.
        i = clearBit(i, onePos);
        i = setBit(i, zeroPos);
        return i;
    }

    public static int positionOfNextZero(int i, int start) {
        int p = start;
        while (p < SEQUENCE_LENGTH) {
            if (((1 << p) & i) == 0) {
                break;
            }
            p++;
        }

        return p >= SEQUENCE_LENGTH ? -1 : p;
    }

    public static int positionOfPrevZero(int i, int start) {
        int p = start;
        while (p >= 0) {
            if (((1 << p) & i) == 0) {
                break;
            }
            p--;
        }

        return p >= 0 ? p : -1;
    }

    public static int positionOfNextOne(int i, int start) {
        int p = start;
        while (p < SEQUENCE_LENGTH) {
            if (((1 << p) & i) != 0) {
                break;
            }
            p++;
        }
        return p >= SEQUENCE_LENGTH ? -1 : p;
    }

    public static int positionOfPrevOne(int i, int start) {
        int p = start;
        while (p >= 0) {
            if (((1 << p) & i) != 0) {
                break;
            }
            p--;
        }
        return p >= 0 ? p : -1;
    }

    public static int setBit(int i, int pos) {
        assert ( 0 <= pos && pos < SEQUENCE_LENGTH);
        int mask = 1 << pos;
        return i | mask;
    }

    public static int clearBit(int i, int pos) {
        assert ( 0 <= pos && pos < SEQUENCE_LENGTH);
        int mask = ~(1 << pos);
        return i & mask;
    }
}

