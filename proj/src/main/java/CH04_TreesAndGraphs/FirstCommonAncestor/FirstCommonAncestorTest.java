package CH04_TreesAndGraphs.FirstCommonAncestor;

// Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
// Avoid storing additional nodes in a data structure.
// NOTE: This is not necessarily a binary search tree.
// Hints: #10, #16, #28, #36, #46, #70, #80, #96

// we should ask the interviewer
// 1. whether the node has a link to its parent
// 2. If the 1st node is the 2nd node's parent, should we return the 1st node or the parent of the 1st node.


import Common.BiTreeNode;

public class FirstCommonAncestorTest {

    public static void main(String[] args) {
        BiTreeNode<String> nodeA = new BiTreeNode<>("a");
        BiTreeNode<String> nodeB = new BiTreeNode<>("b");
        BiTreeNode<String> nodeC = new BiTreeNode<>("c");
        BiTreeNode<String> nodeD = new BiTreeNode<>("d");
        BiTreeNode<String> nodeE = new BiTreeNode<>("e");
        BiTreeNode<String> nodeF = new BiTreeNode<>("f");
        BiTreeNode<String> nodeG = new BiTreeNode<>("g");
        nodeA.setLeft(nodeB);
        nodeA.setRight(nodeC);
        nodeB.setLeft(nodeD);
        nodeB.setRight(nodeE);
        nodeC.setLeft(nodeF);
        nodeC.setRight(nodeG);
        BiTreeNode<String> ancestor1 = FirstCommonAncestor_v1.firstCommonAncestor(nodeF, nodeC);
        System.out.println(ancestor1.element);

        BiTreeNode<String> ancestor2 = FirstCommonAncestor_v2.firstCommonAncestor(nodeF, nodeC);
        System.out.println(ancestor2.element);

        BiTreeNode<String> ancestor3 = FirstCommonAncestor_v3.firstCommonAncestor(nodeA, nodeD, nodeG);
        System.out.println(ancestor3.element);

        BiTreeNode<String> ancestor4 = FirstCommonAncestor_v4.firstCommonAncestor(nodeA, nodeD, nodeG);
        System.out.println(ancestor4.element);

        BiTreeNode<String> ancestor5 = FirstCommonAncestor_v5.firstCommonAncestor(nodeA, nodeD, nodeG);
        System.out.println(ancestor5.element);
    }
}
