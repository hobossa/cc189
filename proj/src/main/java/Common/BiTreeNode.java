package Common;

import java.util.ArrayList;
import java.util.LinkedList;

public class BiTreeNode<E> {
    E element;
    public BiTreeNode<E> left;
    public BiTreeNode<E> right;

    public BiTreeNode(E element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return " " + element.toString();
    }

    // static methods

    // from MinimalTree_v1
    public static <E> BiTreeNode<E> createBSTFromSortedArray(E[] sortedArray) {
        return createBSTFromSortedArray(sortedArray, 0, sortedArray.length - 1);
    }

    private static <E> BiTreeNode<E> createBSTFromSortedArray(E[] sortedArray, int startIndex, int endIndex) {
        int i = (endIndex + 1 - startIndex) / 2 + startIndex;
        BiTreeNode<E> node = new BiTreeNode<>(sortedArray[i]);
        if (startIndex < i) {
            node.left = createBSTFromSortedArray(sortedArray, startIndex, i - 1);
        }
        if (i < endIndex) {
            node.right = createBSTFromSortedArray(sortedArray, i + 1, endIndex);
        }
        return node;
    }

    // from ListOfDepths_v2
    public static <E> ArrayList<LinkedList<BiTreeNode<E>>> toListOfDepth(BiTreeNode<E> root) {
        ArrayList<LinkedList<BiTreeNode<E>>> arrayList = new ArrayList<>();
        int depth = 0;
        LinkedList<BiTreeNode<E>> curList = new LinkedList<>();
        curList.add(root);
        while (curList.size() > 0) {
            arrayList.add(curList);
            LinkedList<BiTreeNode<E>> nextList = new LinkedList<>();
            curList.forEach((node) -> {
                if (null != node.left) {
                    nextList.add(node.left);
                }
                if (null != node.right) {
                    nextList.add(node.right);
                }
            });
            curList = nextList;
        }
        return arrayList;
    }

    // simply insert an element into binary search tree, but not maintain the balance.
    public static <E extends Comparable<? super E>> void insert(BiTreeNode<E> node, E element) {
        if (element.compareTo(node.element) <= 0) {
            if (null == node.left) {
                node.left = new BiTreeNode<>(element);
            } else {
                insert(node.left, element);
            }
        } else {
            if (null == node.right) {
                node.right = new BiTreeNode<>(element);
            } else {
                insert(node.right, element);
            }
        }
    }
}
