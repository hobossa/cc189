package CH04_TreesAndGraphs.RandomNode;

import Common.BiTreeNode;

import java.util.concurrent.ThreadLocalRandom;


// version 1,
// 1. get the number of nodes in the tree.
// 2. generate a random int between [0, numberOfNodes)
// 3. use any traversal method to get the node. (in-order, pre-order, post-order)

// we can ask the interviewers does the node has a size field.

public class RandomNodeTest_v1 {
    private static class Result<E> {
        int counter;
        BiTreeNode<E> node;
        public Result(int counter) {
            this.counter = counter;
            node = null;
        }
    }

    public static <E> BiTreeNode<E> getRandomNode(BiTreeNode<E> tree) {
        int size = size(tree);
        if (size == 0) {
            return null;
        }

        int rI = ThreadLocalRandom.current().nextInt(size);
        System.out.println("random int: " + rI);
        Result r = new Result<>(rI);
        preOrderGetAtIndex(tree, r);
        return r.node;
    }

    public static <E> BiTreeNode<E> getAtIndex(BiTreeNode<E> tree, int index) {
        int size = size(tree);
        if (size == 0) {
            return null;
        }

        int rI = index;
        Result r = new Result<>(rI);
        preOrderGetAtIndex(tree, r);
        return r.node;
    }

    // the way use a Result object may seem weird.
    // we can also push the nodes in a stack until we get a certain number of nodes.
    // then return the relative node in the stack.
    private static <E> void preOrderGetAtIndex(BiTreeNode<E> node, Result r) {
        if (r.node != null) {
            return;
        }

        if (node == null) {
            return;
        }

        if (r.counter == 0) {
            r.node = node;
            return;
        }
        r.counter--;
        preOrderGetAtIndex(node.left, r);
        preOrderGetAtIndex(node.right, r);
    }

    private static <E> int size(BiTreeNode<E> node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }
}
