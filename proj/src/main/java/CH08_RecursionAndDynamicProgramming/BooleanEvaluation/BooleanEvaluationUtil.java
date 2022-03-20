package CH08_RecursionAndDynamicProgramming.BooleanEvaluation;

public class BooleanEvaluationUtil {
    public static boolean char2Boolean(char c) {
        return switch (c) {
            case '1' -> true;
            case '0' -> false;
            default -> throw new RuntimeException("char2Boolean unknown char");
        };
    }

}
