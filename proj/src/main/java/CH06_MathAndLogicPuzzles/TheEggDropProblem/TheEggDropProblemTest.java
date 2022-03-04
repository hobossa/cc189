package CH06_MathAndLogicPuzzles.TheEggDropProblem;

public class TheEggDropProblemTest {

    // In fact, n egg drop problem is a typical dynamic programming problem
    // https://www.itdaan.com/blog/2017/03/28/ff8b16bc712c31ac403eb21b2f0436b3.html
    // https://blog.csdn.net/u010582082/article/details/67634317
    public static void main(String[] args) {
        // for (int i = 10; i < 20; i++) {
        //     int sum = 0;
        //     for (int j = i; j >0 ; j--) {
        //         sum += j;
        //         if (sum >= 100) {
        //             System.out.println(i);
        //             break;
        //         }
        //     }
        //     if (sum >= 100 ) {
        //         break;
        //     }
        // }

        // or find the minimal n that n! >= 100;
        int i = 0;
        for (i = 0; i < 100; i++) {
            if (i*(i + 1) / 2 >= 100) {
                break;
            }
        }
        System.out.println(i);
    }
}
