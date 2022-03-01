package Common;

import java.util.ArrayList;
import java.util.LinkedList;

public class BiTreeNode<E> {
    public E element;
    public BiTreeNode<E> parent;
    public BiTreeNode<E> left;
    public BiTreeNode<E> right;

    public BiTreeNode(E element) {
        this.element = element;
    }

    public void setLeft(BiTreeNode<E> left) {
        this.left = left;
        left.parent = this;
    }

    public void setRight(BiTreeNode<E> right) {
        this.right = right;
        right.parent = this;
    }

    @Override
    public String toString() {
        return " " + element.toString();
    }

    // static methods

    // from MinimalTree_v1
    // this method will create a binary search tree from a sorted array, but it wouldn't check
    // whether the array is sorted or not.
    // If the array was sorted, the tree created would be a BST, otherwise it would not be a BST.
    public static <E> BiTreeNode<E> createBSTFromSortedArray(E[] sortedArray) {
        return createBSTFromSortedArray(sortedArray, 0, sortedArray.length - 1);
    }

    public static <E> BiTreeNode<E> createBTFromArray(E[] sortedArray) {
        return createBSTFromSortedArray(sortedArray, 0, sortedArray.length - 1);
    }

    private static <E> BiTreeNode<E> createBSTFromSortedArray(E[] sortedArray, int startIndex, int endIndex) {
        int i = (endIndex + 1 - startIndex) / 2 + startIndex;
        BiTreeNode<E> node = new BiTreeNode<>(sortedArray[i]);
        if (startIndex < i) {
            node.left = createBSTFromSortedArray(sortedArray, startIndex, i - 1);
            node.left.parent = node;
        }
        if (i < endIndex) {
            node.right = createBSTFromSortedArray(sortedArray, i + 1, endIndex);
            node.right.parent = node;
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
                node.left.parent = node;
            } else {
                insert(node.left, element);
            }
        } else {
            if (null == node.right) {
                node.right = new BiTreeNode<>(element);
                node.right.parent = node;
            } else {
                insert(node.right, element);
            }
        }
    }

    public static <E extends Comparable<? super E>> BiTreeNode<E> find(BiTreeNode<E> node, E value) {
        if (null == node) {
            return null;
        }
        if (value.compareTo(node.element) == 0) {
            return node;
        }
        if (value.compareTo(node.element) <0 ) {
            return BiTreeNode.find(node.left, value);
        }

        return BiTreeNode.find(node.right, value);
    }
}
