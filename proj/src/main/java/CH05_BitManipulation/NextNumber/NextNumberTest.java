package CH05_BitManipulation.NextNumber;

// Given a positive integer, print the next smallest and the next largest number that have the same
// number of 1 bits in their binary representation.

// Hints: #147, #175 #242, #312, #339, #358, #375, #390

// ask the interviewer, what should return if there is no such a number.

public class NextNumberTest {
    public static void main(String[] args) {
        //int i = ThreadLocalRandom.current().nextInt(99999);
        int i = Integer.MAX_VALUE-1;
        System.out.println(i);
        System.out.println(Integer.toBinaryString(i));

        System.out.println();
        System.out.println(Integer.toBinaryString(NextNumber_v1.getPrev(i)));
        System.out.println(Integer.toBinaryString(NextNumber_v1.getNext(i)));
    }

}
