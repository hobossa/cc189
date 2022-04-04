package CH16_Moderate.NumberSwapper;


// Number Swapper: Write a function to swap a number in place (that is, without temporary variables).
// Hints: #492, #716, #737

import java.util.concurrent.ThreadLocalRandom;

public class NumberSwapperTest {

    public static void swap_v1(int a, int b) {
        System.out.println("" + a + " - " + b);
        a = a - b;
        b = b + a;
        a = b - a;
        System.out.println("" + a + " - " + b + "\n");
    }

    public static void swap_v2(int a, int b) {
        System.out.println("" + a + " - " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("" + a + " - " + b + "\n");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            swap_v1(ThreadLocalRandom.current().nextInt(10, 99), ThreadLocalRandom.current().nextInt(100, 999));
        }
        System.out.println("--------------");
        for (int i = 0; i < 10; i++) {
            swap_v2(ThreadLocalRandom.current().nextInt(10, 99), ThreadLocalRandom.current().nextInt(100, 999));
        }
    }
}
