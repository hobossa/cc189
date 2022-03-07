package CH08_RecursionAndDynamicProgramming.TowersOfHanoi;


public class TowerOfHanoi_v1 {
    public static void moveDisks(int numberOfDisks, Tower src, Tower mid, Tower dest) {

        if (numberOfDisks <= 0) {
            return;
        }
        moveDisks(numberOfDisks-1, src, dest, mid);
        src.moveTopTo(dest);
        // System.out.println(src);
        // System.out.println(mid);
        // System.out.println(dest);
        // System.out.println();
        moveDisks(numberOfDisks-1, mid, src, dest);
    }


    public static void hanoi() {
        Tower src = new Tower("Source");
        Tower mid = new Tower("Middle");
        Tower dest = new Tower("Destination");
        int numberOfDisks = 3;
        for (int i = numberOfDisks; i > 0; i--) {
            src.addDisk(i);
        }
        // System.out.println(src);
        // System.out.println(mid);
        // System.out.println(dest);
        // System.out.println();
        moveDisks(numberOfDisks, src, mid, dest);
     }
}
