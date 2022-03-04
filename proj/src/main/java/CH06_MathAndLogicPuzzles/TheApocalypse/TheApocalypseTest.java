package CH06_MathAndLogicPuzzles.TheApocalypse;

// In the new post apocalyptic world, the world queen is desperately concerned about the birth rate.
// Therefore, she decrees that all families should ensure that they have one girl or else they face
// massive fines. If all families abide by this policy -- that is, they have continue to have children
// until they have one girl, at which point they immediately stop -- what will the gender ratio of the
// new generation be?
// (Assume that the odds of someone having a boy or a girl on any given pregnancy is equal.) Solve this
// out logically and then write a computer simulation of it.

// Hints: #154, #160, #171, #188, #201


import java.util.concurrent.ThreadLocalRandom;

public class TheApocalypseTest {
    private static class BoysAndGirls {
        int nBoys = 0;
        int nGirls = 0;
    }

    private static void runFamilies(int numberOfFamilies, BoysAndGirls bgs) {
        for (int i = 0; i < numberOfFamilies; i++) {
            while (true) {
                int n = ThreadLocalRandom.current().nextInt();
                if (n % 2 == 0) {   // boys
                    bgs.nBoys++;
                } else {    // finally, we get a girl.
                    bgs.nGirls++;
                    break;
                }
            }
        }
    }


    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            int n = i * 2000;
            BoysAndGirls bgs = new BoysAndGirls();
            System.out.println("simulate " + n + " families: ");
            runFamilies(n, bgs);
            System.out.println("    we got " + bgs.nGirls + " girls, and " + bgs.nBoys + " boys");
        }
    }
}
