package CH08_RecursionAndDynamicProgramming.BooleanEvaluation;


import java.util.Hashtable;

// similar to v1, plus memo opt
public class BooleanEvaluation_v2 {
    private static class MemoData {
        int countTrue;
        int countFalse;

        public MemoData(int countTrue, int countFalse) {
            this.countTrue = countTrue;
            this.countFalse = countFalse;
        }
    }

    public static int countEvaluation(String expression, boolean value) {
        Hashtable<String, MemoData> memo = new Hashtable<>();
        return countEvaluationHelper(expression, value, memo);
    }

    public static int countEvaluationHelper(String expression, boolean value, Hashtable<String, MemoData> memo) {
        if (expression.length() == 1) {
            return BooleanEvaluationUtil.char2Boolean(expression.charAt(0)) == value ? 1 : 0;
        }

        if (memo.containsKey(expression)) {
            return value ? memo.get(expression).countTrue : memo.get(expression).countFalse;
        }
        int totalTrue = 0;
        int totalFalse = 0;

        for (int i = 1; i < expression.length(); i += 2) {
            char operator = expression.charAt(i);
            String left = expression.substring(0, i);
            String right = expression.substring(i + 1, expression.length());
            // the following 4 lines data can be memorized.
            int leftTrue = countEvaluationHelper(left, true, memo);
            int leftFalse = countEvaluationHelper(left, false, memo);
            int rightTrue = countEvaluationHelper(right, true, memo);
            int rightFalse = countEvaluationHelper(right, false, memo);

            int countTrue = 0;
            switch (operator) {
                case '&':
                    countTrue = leftTrue * rightTrue;
                    break;
                case '|':
                    countTrue = leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
                    break;
                case '^':
                    countTrue = (leftTrue * rightFalse) + (leftFalse * rightTrue);
                    break;
                default:
                    throw new RuntimeException("unexpected operator");
            }
            int countFalse = (leftTrue + leftFalse) * (rightTrue + rightFalse) - countTrue;
            totalTrue += countTrue;
            totalFalse += countFalse;
        }
        memo.put(expression, new MemoData(totalTrue, totalFalse));
        return value ? totalTrue : totalFalse;
    }
}
