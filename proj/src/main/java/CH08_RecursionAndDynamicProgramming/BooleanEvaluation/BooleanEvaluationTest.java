package CH08_RecursionAndDynamicProgramming.BooleanEvaluation;


// Given a boolean expression consisting of the symbols 0 (false), 1 (true), & (AND), | (OR), and ^ (XOR),
// and a desired boolean result value result, implement a function to count the number of ways of parenthesizing
// the expression such that it evaluates to result.
// EXAMPLE
// countEval("1^0|0|1", false) -> 2
// countEval("0&0&0&1^1|0", true) -> 10
// Hints: #148, #168, #197, #305, #327

import java.util.concurrent.ThreadLocalRandom;

public class BooleanEvaluationTest {
    public static void main(String[] args) {
        // System.out.println(BooleanEvaluation_v1.countEvaluation("0&0&0&1^1|0", true));
        // System.out.println(BooleanEvaluation_v2.countEvaluation("0&0&0&1^1|0", true));
        // System.out.println(BooleanEvaluation_v1.countEvaluation("0&0&0&1^1|0", false));
        // System.out.println(BooleanEvaluation_v2.countEvaluation("0&0&0&1^1|0", false));
        // System.out.println();

        String expression = randomExpression(10);
        // String expression = "1&0|1";
        // boolean bFound = false;
        // for (int i = 0; i < 10000; i++) {
        //     expression = randomExpression(2);
        //     //System.out.println(expression);
        //     int v1True = BooleanEvaluation_v1.countEvaluation(expression, true);
        //     int v2True = BooleanEvaluation_v2.countEvaluation(expression, true);
        //     int v1False = BooleanEvaluation_v1.countEvaluation(expression, false);
        //     int v2False = BooleanEvaluation_v2.countEvaluation(expression, false);
        //     System.out.println(expression + " - true: "+ v1True + " false: " + v1False);
        //     if (v1True != v2True || v1False != v2False) {
        //         bFound = true;
        //         break;
        //     }
        // }
        //
        // if (!bFound) {
        //     return;
        // }


        System.out.println("Test expression: " + expression);
        long s1 = System.nanoTime();
        System.out.println(BooleanEvaluation_v1.countEvaluation(expression, true));
        long s2 = System.nanoTime();
        System.out.println("Time cost without memo: " + (s2 - s1));
        System.out.println(BooleanEvaluation_v2.countEvaluation(expression, true));
        s1 = System.nanoTime();
        System.out.println("Time cost with memo   : " + (s1 - s2));
        System.out.println(BooleanEvaluation_v1.countEvaluation(expression, false));
        s2 = System.nanoTime();
        System.out.println("Time cost without memo: " + (s2 - s1));
        System.out.println(BooleanEvaluation_v2.countEvaluation(expression, false));
        s1 = System.nanoTime();
        System.out.println("Time cost with memo   : " + (s1 - s2));
    }

    private static String randomExpression(int numOfOp) {
        if (numOfOp < 1) {
            throw new RuntimeException("The number of operator must be greater than 0.");
        }
        int n = 0;
        StringBuilder sb = new StringBuilder(2 * numOfOp + 1);
        while (n < numOfOp) {
            n++;
            sb.append(random01());
            sb.append(randomOp());
        }
        sb.append(random01());
        return sb.toString();
    }

    private static char random01() {
        return ThreadLocalRandom.current().nextBoolean() ? '1' : '0';
    }

    private static char randomOp() {
        int n = ThreadLocalRandom.current().nextInt(0, 3);
        return switch (n) {
            case 0 -> '&';
            case 1 -> '|';
            default -> '^';
        };
    }
}
