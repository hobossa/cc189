package MY.Test;

import java.util.*;

public class Test {
    // private static class Pair{
    //     int a;
    //     int b;
    //
    //     public Pair(int a, int b) {
    //         this.a = a;
    //         this.b = b;
    //     }
    //
    //     @Override
    //     public int hashCode() {
    //         return super.hashCode();
    //     }
    //
    //     @Override
    //     public boolean equals(Object obj) {
    //         if (obj != null && obj instanceof Pair) {
    //             Pair o = (Pair)obj;
    //             return (o.a == this.a && o.b == this.b);
    //         }
    //         return false;
    //     }
    // }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] counts = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            char k = s.charAt(i);
            System.out.println(k - 'a');
            counts[k - 'a']++;
        }

        return true;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int pi = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (pi != -1 && nums[i] == nums[pi]) {
                // skip the duplicate
                continue;
            }
            pi = i;
            int j = i + 1;
            int pj = -1;
            int k = nums.length - 1;

            while (pj != -1 && nums[j] == nums[pj] && j < k) {
                j++;
            }
            pj = j;

            if (j >= k) {
                continue;
            }


            int temp = -nums[i];
            while (j < k) {
                int sum = nums[j] + nums[k];
                if (sum == temp) {
                    Integer[] arr = new Integer[]{nums[i], nums[j], nums[k]};
                    result.add(Arrays.asList(arr));
                } else if (sum < temp) {
                    j++;
                } else { // (sum > temp)
                    k--;
                }
            }
        }
        return result;
    }

    ////
    private static class SolutionBacktrackingEx {
        private int[] nums;
        private List<List<Integer>> res;
        private List<Integer> buffer;

        public List<List<Integer>> permute(int[] nums) {
            this.nums = nums;
            res = new ArrayList<>();
            buffer = new ArrayList<>();
            helper(0);
            return res;
        }

        private void helper(int start) {
            if (buffer.size() == nums.length) {
                res.add(new ArrayList<>(buffer));
                return;
            }

            for (int i = start; i < nums.length; ++i) {
                // swap the selected element to the head of the array.
                // so the rest of the array are the elements that haven't been selected
                buffer.add(nums[i]);
                swap(start, i);
                helper(start + 1);
                buffer.remove(buffer.size() - 1);
                swap(start, i);
            }

        }

        private void swap(int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    private static void testSolutionBacktrackingEx() {
        int[] nums = new int[]{1, 2, 3};
        SolutionBacktrackingEx sl = new SolutionBacktrackingEx();

        for (List<Integer> l : sl.permute(nums)) {
            System.out.println(l);
        }
    }

    private static class Solution1 {
        private List<HashSet<Character>> rowSets;
        private List<HashSet<Character>> colSets;
        private List<HashSet<Character>> gridSets;


        public void solveSudoku(char[][] board) {
            // initial Sets
            rowSets = new ArrayList<>();
            colSets = new ArrayList<>();
            gridSets = new ArrayList<>();
            for (int i = 0; i < 9; ++i) {
                rowSets.add(new HashSet<>());
                colSets.add(new HashSet<>());
                gridSets.add(new HashSet<>());
            }
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    rowSets.get(i).add(board[i][j]);
                    colSets.get(j).add(board[i][j]);
                    gridSets.get(j/3 + 3*(i/3)).add(board[i][j]);
                }
            }

            helper(board, 0);
        }

        private boolean helper(char[][] board, int start) {
            if (81 == start) {
                return true;
            }
            int row = start / 9;
            int col = start % 9;


            if (board[row][col] != '.') {
                return helper(board, start + 1);
            }

            for (char v = '1'; v <= '9'; ++v) {
                if (!putAt(board, v, row, col)) continue;

                boolean ret = helper(board, start + 1);
                if (ret) return ret;

                removeAt(board, row, col);
            }

            return false;
        }


        private boolean putAt(char[][] board, char c, int row, int col) {
            if (rowSets.get(row).contains(c)) return false;
            if (colSets.get(col).contains(c)) return false;
            if (gridSets.get(col/3 + 3*(row/3)).contains(c)) return false;

            board[row][col] = c;
            rowSets.get(row).add(c);
            colSets.get(col).add(c);
            gridSets.get(col/3 + 3*(row/3)).add(c);
            return true;
        }

        private void removeAt(char[][] board, int row, int col) {
            char c = board[row][col];
            rowSets.get(row).remove(c);
            colSets.get(col).remove(c);
            gridSets.get(col/3 + 3*(row/3)).remove(c);
            board[row][col] = '.';
        }
    }
    public static void testSudokuSolution() {
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        SudokuSolution1 sl = new SudokuSolution1();
        sl.solveSudoku(board);
    }

    ///
    public static void main(String[] args) {
        //testSolutionBacktrackingEx();

        testSudokuSolution();

        // StringBuilder buffer = new StringBuilder();
        // buffer.append(1);
        // String str1 = buffer.toString();
        // buffer.append(2);
        // String str2 = buffer.toString();
        // System.out.println(str1);
        // System.out.println(str2);
        //
        // Hashtable<Integer, List<List<Integer>>> map = new Hashtable<>();
        // if (!map.containsKey(1)) {
        //     map.put(1, new ArrayList<>());
        // }
        // ArrayList<Integer> temp = new ArrayList<>(3);
        //
        // long n = 10000000000L;
        // System.out.println(n);
        // System.out.println(Long.MAX_VALUE);
        // String a = "abcdefg";
        // isAnagram(a, a);
        // System.out.println(('b' - 'a'));
        //
        // HashSet<List<Integer>> result = new HashSet<>();
        // Arrays.asList();
        // int[] t = new int[]{1, 3, 5};
        // int[] tt = new int[]{t[0], t[1], t[2]};
        //
        // String s = "ab bc cd";
        // char[] sa = s.toCharArray();
        //
        // Queue<Integer> que = new LinkedList<>();
    }
}

