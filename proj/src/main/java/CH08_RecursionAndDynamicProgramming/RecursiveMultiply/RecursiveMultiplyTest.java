package CH08_RecursionAndDynamicProgramming.RecursiveMultiply;

// Write a recursive function to multiply two positive integers without using the * operator. You can use
// addition, subtraction, and bit shifting, ut you should minimize the number of those operations.

// Hints: #166, #203, #227, #234, #246, #280.

import java.util.concurrent.ThreadLocalRandom;

public class RecursiveMultiplyTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int x = ThreadLocalRandom.current().nextInt(10, 99);
            int y = ThreadLocalRandom.current().nextInt(10, 99);
            int xy = x * y;
            System.out.print(xy == RecursiveMultiply_v1.multiply(x, y));
            System.out.print(" ");
            System.out.print(xy == RecursiveMultiply_v2.multiply(x, y));
            System.out.print(" ");
            System.out.print(xy == RecursiveMultiply_v3.multiply(x, y));
            System.out.print(" ");
            System.out.print(xy == RecursiveMultiply_v4.multiply(x, y));
            System.out.println();
        }
    }
}
