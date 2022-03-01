package CH04_TreesAndGraphs.PathsWithSum;

import Common.BiTreeNode;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;

// we only need to count the number of paths that sum to a given value.

public class PathsWithSum_v1 {
    public static int numberOfSumPath(BiTreeNode<Integer> root, int sum) {
        // Hashtable<node, Hashtable<runningSumValues, count of this value>;
        Hashtable<BiTreeNode<Integer>, Hashtable<Integer, Integer>> mapRunningSumValues = new Hashtable<>();
        fillMapRunningSumValues(root, mapRunningSumValues);
        int count = 0;
        for (Hashtable<Integer, Integer> mapValueCounts : mapRunningSumValues.values()) {
            count += mapValueCounts.getOrDefault(sum, 0);
        }
        return count;
    }

    private static void fillMapRunningSumValues(BiTreeNode<Integer> node,
                                      Hashtable<BiTreeNode<Integer>, Hashtable<Integer, Integer>> mapRunningSumValues) {
        if (node == null) {
            return;
        }
        Hashtable<Integer, Integer> cur = new Hashtable<>();
        cur.put(node.element, 1);

        fillMapRunningSumValues(node.left, mapRunningSumValues);
        fillMapRunningSumValues(node.right, mapRunningSumValues);

        if (node.left != null) {
            Hashtable<Integer, Integer> left = mapRunningSumValues.get(node.left);
            for (Integer val : left.keySet()) {
                Integer newVal = val + node.element;
                // in case value conflict
                int count = cur.getOrDefault(newVal, 0) +  left.get(val);
                cur.put(newVal, count);
            }
        }

        if (node.right != null) {
            Hashtable<Integer, Integer> right = mapRunningSumValues.get(node.right);
            for (Integer val : right.keySet()) {
                Integer newVal = val + node.element;
                // in case value conflict
                int count = cur.getOrDefault(newVal, 0) +  right.get(val);
                cur.put(newVal, count);
            }
        }

        mapRunningSumValues.put(node, cur);
    }
}
