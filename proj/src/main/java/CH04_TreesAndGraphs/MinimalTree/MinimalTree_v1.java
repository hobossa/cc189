package CH04_TreesAndGraphs.MinimalTree;

// The question is to generate a minimal tree from a sorted array.
// a minimal tree (not a complete tree).
// so we can let the number of nodes in the left child is not less than it in the right child.
public class MinimalTree_v1 {

    // recursion approach
    // space O(log n), time O(n)
    public static <E> BiTreeNode<E> generateTreeFromSortedArray(E[] sortedArray) {
        return generateTreeFromSortedArray(sortedArray, 0, sortedArray.length-1);
    }

    private static <E> BiTreeNode<E> generateTreeFromSortedArray(E[] sortedArray, int startIndex, int endIndex) {
        int i = (endIndex + 1 - startIndex) / 2 + startIndex;
        BiTreeNode<E> node = new BiTreeNode<>(sortedArray[i]);
        if (startIndex < i) {
            node.left = generateTreeFromSortedArray(sortedArray, startIndex, i-1);
        }
        if (i < endIndex) {
            node.right = generateTreeFromSortedArray(sortedArray, i+1, endIndex);
        }
        return node;
    }
}
