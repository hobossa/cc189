package MY.KMP;

public class KMPTest {
    private static int[] computeFailKMP(char[] pattern) {
        int m = pattern.length;
        int[] fail = new int[m];    // by default, all overlaps are zero
        int j = 1;
        int k = 0;
        while (j < m) { // compute fail[j] during this pass, if nonzero
            if (pattern[j] == pattern[k]) { // k+1 characters match thus far
                fail[j] = k + 1;
                j++;
                k++;
            } else if (k > 0) {
                k = fail[k - 1];  // k follows a matching prefix
            } else {
                j++;        // no match found starting at j
            }
        }
        return fail;
    }

    private boolean repeatedSubstringPatternKMP(String s) {
        int[] next = getKMPNext(s);
        int len = s.length();
        int n = len - next[len-1];
        return n != 0 && len % n == 0;
    }

    private int[] getKMPNext(String str) {
        int m = str.length();
        int[] next = new int[m];

        int k = 0;
        int j = 1;
        while (j < m) {
            if (str.charAt(k) == str.charAt(j)) {
                next[j] = k + 1;
                ++k;
                ++j;
            } else if (k > 0) {
                k = next[k - 1];
            } else {
                next[j] = 0;
                ++j;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        char[] pattern = "aabaaf".toCharArray();
        int[] fail = KMPTest.computeFailKMP(pattern);
        for (int i = 0; i < fail.length; i++) {
            System.out.println(fail[i]);
        }
    }
}
