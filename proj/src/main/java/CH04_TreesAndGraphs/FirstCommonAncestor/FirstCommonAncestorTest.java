package CH04_TreesAndGraphs.FirstCommonAncestor;

// Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
// Avoid storing additional nodes in a data structure.
// NOTE: This is not necessarily a binary tree.
// Hints: #10, #16, #28, #36, #46, #70, #80, #96

// we should ask the interviewer whether the node has a link to its parent


public class FirstCommonAncestorTest {

    public static void main(String[] args) {
        TreeNode<String> nodeA = new TreeNode<>("a");
        TreeNode<String> nodeB = new TreeNode<>("b");
        TreeNode<String> nodeC = new TreeNode<>("c");
        TreeNode<String> nodeD = new TreeNode<>("d");
        TreeNode<String> nodeE = new TreeNode<>("e");
        TreeNode<String> nodeF = new TreeNode<>("f");
        TreeNode<String> nodeG = new TreeNode<>("g");
        nodeA.addChild(nodeB);
        nodeA.addChild(nodeC);
        nodeB.addChild(nodeD);
        nodeB.addChild(nodeE);
        nodeC.addChild(nodeF);
        nodeC.addChild(nodeG);
        TreeNode<String> ancestor1 = FirstCommonAncestor_v1.firstCommonAncestor(nodeF, nodeC);
        System.out.println(ancestor1.getElement());

        TreeNode<String> ancestor2 = FirstCommonAncestor_v2.firstCommonAncestor(nodeF, nodeC);
        System.out.println(ancestor2.getElement());

        TreeNode<String> ancestor3 = FirstCommonAncestor_v3.firstCommonAncestor(nodeA, nodeF, nodeC);
        System.out.println(ancestor3.getElement());
    }
}
