package CH05_BitManipulation.FlipBit2Win;

import java.util.LinkedList;

public class FlipBit2Win_v1 {
    public static int SEQUENCE_LENGTH = 32;

    public static int flipBit2Win(int n) {
        //System.out.println(Integer.toBinaryString(n));
        int preBit = 0;
        int preCount = 0;
        // build a list that count the num of consecutive bit 1. and insert 0 if there are more than 2 bit 0
        // for example:
        // 11001  the list is [1, 0, 2, 0]. PS: we don't care about the last 0, just leave it alone.
        LinkedList<Integer> listCount = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < SEQUENCE_LENGTH; i++) {
            int t = (1 << i) & n;
            if (t != 0) {
                count++;
            } else {
                if (!(preCount == 0 && preBit == 0)) {
                    listCount.add(count);
                    preCount = count;
                }
                count = 0;
            }
            preBit = t;
        }
        // add the count of last sequence.
        if (preBit!= 0) {
            listCount.add(count);
        }
        // for convenient, make sure that listCount at least has 2 elements.
        while (listCount.size() < 2) {
            listCount.add(0);
        }
        System.out.println(listCount);
        int max = 0;
        for (int i = 0; i < listCount.size()-1; i++) {
            int m = listCount.get(i) + listCount.get(i+1);
            if (m > max) {
                max = m;
            }
        }
        max = max < SEQUENCE_LENGTH ? max+1: max;
        return max;
    }
}
